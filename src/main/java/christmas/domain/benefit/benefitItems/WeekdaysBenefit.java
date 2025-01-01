package christmas.domain.benefit.benefitItems;

import christmas.domain.Calender;
import christmas.domain.Order;
import christmas.domain.OrderItem;
import christmas.domain.benefit.BenefitCategory;
import java.util.List;

public class WeekdaysBenefit extends BenefitItem {

    public WeekdaysBenefit(BenefitCategory benefitCategory, int discountPrice) {
        super(benefitCategory, discountPrice);
    }

    public static WeekdaysBenefit of(BenefitCategory benefitCategory, Calender calender, Order order) {
        return new WeekdaysBenefit(benefitCategory, calculateDiscountPrice(benefitCategory, calender, order));
    }

    private static int calculateDiscountPrice(BenefitCategory benefitCategory, Calender calender, Order order) {
        List<OrderItem> orderItems = order.getOrderItems();
        return orderItems.stream()
                .filter(OrderItem::isDessert)
                .mapToInt(orderItem -> benefitCategory.getPrice() * orderItem.getOrderCount())
                .sum();
    }
}
