package christmas.domain.benefit.benefitItems;

import christmas.domain.Calender;
import christmas.domain.Order;
import christmas.domain.benefit.BenefitCategory;

public class SpecialBenefit extends BenefitItem {


    public SpecialBenefit(BenefitCategory benefitCategory, int discountPrice) {
        super(benefitCategory, discountPrice);
    }

    public static SpecialBenefit of(BenefitCategory benefitCategory, Calender calender, Order order) {
        return new SpecialBenefit(benefitCategory, calculateDiscountPrice(benefitCategory, calender, order));
    }

    private static int calculateDiscountPrice(BenefitCategory benefitCategory, Calender calender, Order order) {
        return 1000;
    }
}
