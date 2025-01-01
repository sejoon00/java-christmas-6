package christmas.domain;

import christmas.error.ErrorCode;
import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class Order {

    private final String DELIMITER = ",";
    private final List<OrderItem> orderItems;

    public Order(String orderInputs) {
        this.orderItems = createOrderItems(orderInputs);
    }

    public List<OrderItem> getOrderItems() {
        return orderItems;
    }

    public int calculateTotalPrice() {
        return orderItems.stream()
                .mapToInt(OrderItem::getPrice)
                .sum();
    }

    private List<OrderItem> createOrderItems(String orderInputs) {
        List<OrderItem> orderItems = Arrays.stream(orderInputs.split(DELIMITER))
                .map(OrderItem::new)
                .toList();
        validateDuplication(orderItems);
        return orderItems;
    }

    private static void validateDuplication(List<OrderItem> orderItems) {
        Set<String> duplicateChecker = orderItems.stream()
                .map(OrderItem::getName)
                .collect(Collectors.toSet());
        if (duplicateChecker.size() != orderItems.size()) {
            throw new IllegalArgumentException(ErrorCode.INVALID_MENU_FORMAT.getMessage());
        }
    }
}
