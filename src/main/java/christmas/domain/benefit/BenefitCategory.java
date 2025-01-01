package christmas.domain.benefit;

import christmas.domain.Calender;
import christmas.domain.Order;
import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;
import java.util.function.Function;

public enum BenefitCategory {

    평일할인("평일할인", 2_023, input -> {

        LocalDate date = (LocalDate) input;
        if (date.getDayOfWeek().getValue() == 7) {
            return true;
        }
        return date.getDayOfWeek().getValue() <= 4 && date.getDayOfWeek().getValue() >= 1;
    }),
    주말할인("주말할인", 2_023, input -> {

        LocalDate date = (LocalDate) input;
        return date.getDayOfWeek().getValue() <= 6 && date.getDayOfWeek().getValue() >= 5;
    }),
    특별할인("특별할인", 1_000, input -> {

        LocalDate date = (LocalDate) input;
        return date.getDayOfWeek().getValue() == 7 || date.getDayOfMonth() == 25;
    }),
    증정이벤트("증정이벤트", 25_000, input -> false),
    크리스마스_디데이할인("크리스마스_디데이할인", 100, input -> {
        LocalDate date = (LocalDate) input;
        if (date.getDayOfMonth() <= 25) {
            return true;
        }
        return false;
    }),
    ;

    private final String name;
    private final int price;
    private final Function<Object, Boolean> dateValidator;

    BenefitCategory(String name, int price, Function<Object, Boolean> dateValidator) {
        this.name = name;
        this.price = price;
        this.dateValidator = dateValidator;
    }

    public String getName() {
        return name;
    }

    public int getPrice() {
        return price;
    }

    public static List<BenefitCategory> getAvailableBenefitItems(Calender calender, Order order) {
        List<BenefitCategory> benefitItems = new java.util.ArrayList<>(Arrays.stream(BenefitCategory.values())
                .filter(benefitItem -> benefitItem.dateValidator.apply(calender.getDate()))
                .toList());

        if (order.calculateTotalPrice() >= 120_000) {
            benefitItems.add(증정이벤트);
        }

        return benefitItems;
    }
}
