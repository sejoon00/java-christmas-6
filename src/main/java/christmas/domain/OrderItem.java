package christmas.domain;

import christmas.error.ErrorCode;

public class OrderItem {
    public static final int MINIMUM_COUNT = 0;
    private final String DELIMITER = "-";

    private final MenuItem menuItem;
    private final int orderCount;

    OrderItem(String input) {
        String[] splitInput = splitInput(input);
        this.menuItem = MenuItem.getMenuList(splitInput[0]);
        this.orderCount = parseIntOrderCount(splitInput[1]);
    }

    public String getName() {
        return menuItem.getName();
    }

    public int getOrderCount() {
        return orderCount;
    }

    public int getPrice() {
        return menuItem.getPrice() * orderCount;
    }

    public boolean isDessert() {
        return menuItem.getCategory().equals(MenuCategory.Desserts);
    }

    public boolean isMainDish() {
        return menuItem.getCategory().equals(MenuCategory.MainDishes);
    }

    private String[] splitInput(String input) {
        String[] split = input.split(DELIMITER);
        if (split.length != 2) {
            throw new IllegalArgumentException(ErrorCode.INVALID_MENU_FORMAT.getMessage());
        }
        return split;
    }

    private static int parseIntOrderCount(String orderCount) {
        try {
            int count = Integer.parseInt(orderCount);
            if(count <= MINIMUM_COUNT)
                throw new IllegalArgumentException(ErrorCode.INVALID_MENU_FORMAT.getMessage());
            return count;
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(ErrorCode.INVALID_MENU_FORMAT.getMessage());
        }
    }
}
