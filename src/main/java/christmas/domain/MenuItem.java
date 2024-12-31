package christmas.domain;

import christmas.error.ErrorCode;
import java.util.Arrays;

public enum MenuItem {

    양송이스프(6_000, "양송이스프", MenuCategory.Appetizers),
    타파스(5_500, "타파스", MenuCategory.Appetizers),
    시저샐러드(8_000, "시저샐러드", MenuCategory.Appetizers),
    티본스테이크(55_000, "티본스테이크", MenuCategory.MainDishes),
    바비큐립(54_000, "바비큐립", MenuCategory.MainDishes),
    해산물파스타(35_000, "해산물파스타", MenuCategory.MainDishes),
    크리스마스파스타(25_000, "크리스마스파스타", MenuCategory.MainDishes),
    초코케이크(15_000, "초코케이크", MenuCategory.Desserts),
    아이스크림(5_000, "아이스크림", MenuCategory.Desserts),
    제로콜라(3_000, "제로콜라", MenuCategory.Drinks),
    레드와인(60_000, "레드와인", MenuCategory.Drinks),
    샴페인(25_000, "샴페인", MenuCategory.Drinks);

    private final int price;
    private final String name;
    private final MenuCategory category;

    MenuItem(int price, String name, MenuCategory category) {
        this.price = price;
        this.name = name;
        this.category = category;
    }

    public static MenuItem getMenuList(String menuName) {
        return Arrays.stream(MenuItem.values())
                .filter(menuItem -> menuItem.name.equals(menuName))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException(ErrorCode.INVALID_MENU_FORMAT.getMessage()));
    }

    public int getPrice() {
        return price;
    }

    public String getName() {
        return name;
    }

    public MenuCategory getCategory() {
        return category;
    }
}
