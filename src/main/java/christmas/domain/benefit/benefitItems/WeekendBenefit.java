package christmas.domain.benefit.benefitItems;

import christmas.domain.Calender;
import christmas.domain.Order;
import christmas.domain.OrderItem;
import christmas.domain.benefit.BenefitCategory;
import java.util.List;

public class WeekendBenefit extends BenefitItem {

    public WeekendBenefit(BenefitCategory benefitCategory, int discountPrice) {
        super(benefitCategory, discountPrice);
    }

    public static WeekdaysBenefit of(BenefitCategory benefitCategory, Calender calender, Order order) {
        return new WeekdaysBenefit(benefitCategory, calculateDiscountPrice(benefitCategory, calender, order));
    }

    private static int calculateDiscountPrice(BenefitCategory benefitCategory, Calender calender, Order order) {
        List<OrderItem> orderItems = order.getOrderItems();
        return orderItems.stream()
                .filter(OrderItem::isMainDish)
                .mapToInt(orderItem -> benefitCategory.getPrice() * orderItem.getOrderCount())
                .sum();
    }
}
