package christmas.domain.benefit;

import christmas.domain.Calender;
import christmas.domain.Menu;
import christmas.domain.OrderItem;
import java.util.List;

public class WeekendBenefit extends BenefitItem {

    public WeekendBenefit(BenefitCategory benefitCategory, int discountPrice) {
        super(benefitCategory, discountPrice);
    }

    public static WeekdaysBenefit of(BenefitCategory benefitCategory, Calender calender, Menu menu) {
        return new WeekdaysBenefit(benefitCategory, calculateDiscountPrice(benefitCategory, calender, menu));
    }

    private static int calculateDiscountPrice(BenefitCategory benefitCategory, Calender calender, Menu menu) {
        List<OrderItem> orderItems = menu.getOrderItems();
        return orderItems.stream()
                .filter(OrderItem::isMainDish)
                .mapToInt(orderItem -> benefitCategory.getPrice() * orderItem.getOrderCount())
                .sum();
    }
}