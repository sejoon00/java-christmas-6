package christmas.domain.benefit;

import christmas.domain.Calender;
import christmas.domain.Menu;
import christmas.domain.OrderItem;
import java.util.List;

public class WeekdaysBenefit extends BenefitItem {

    public WeekdaysBenefit(BenefitCategory benefitCategory, int discountPrice) {
        super(benefitCategory, discountPrice);
    }

    public static WeekdaysBenefit of(BenefitCategory benefitCategory, Calender calender, Menu menu) {
        return new WeekdaysBenefit(benefitCategory, calculateDiscountPrice(benefitCategory, calender, menu));
    }

    private static int calculateDiscountPrice(BenefitCategory benefitCategory, Calender calender, Menu menu) {
        List<OrderItem> orderItems = menu.getOrderItems();
        return orderItems.stream()
                .filter(OrderItem::isDessert)
                .mapToInt(orderItem -> benefitCategory.getPrice() * orderItem.getOrderCount())
                .sum();
    }
}
