package christmas.domain;

import christmas.error.ErrorCode;
import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class Menu {

    private final String DELIMITER = ",";
    private final List<OrderItem> orderItems;

    public Menu(String menuInputs) {
        this.orderItems = createMenuItems(menuInputs);
    }

    public List<OrderItem> getOrderItems() {
        return orderItems;
    }

    private List<OrderItem> createMenuItems(String menuInputs) {
        List<OrderItem> orderItems = Arrays.stream(menuInputs.split(DELIMITER))
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
