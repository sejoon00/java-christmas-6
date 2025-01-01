package christmas.domain.benefit.benefitItems;

import christmas.domain.Calender;
import christmas.domain.Order;
import christmas.domain.benefit.BenefitCategory;

public class ChristmasBenefit extends BenefitItem {

    public ChristmasBenefit(BenefitCategory benefitCategory, int discountPrice) {
        super(benefitCategory, discountPrice);
    }

    public static ChristmasBenefit of(BenefitCategory benefitCategory, Calender calender, Order order) {
        return new ChristmasBenefit(benefitCategory, calculateDiscountPrice(benefitCategory, calender, order));
    }

    private static int calculateDiscountPrice(BenefitCategory benefitCategory, Calender calender, Order order) {

        return 1000 + (calender.getDate().getDayOfMonth() - 1) * benefitCategory.getPrice();
    }
}
