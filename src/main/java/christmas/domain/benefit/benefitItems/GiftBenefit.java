package christmas.domain.benefit.benefitItems;

import christmas.domain.Calender;
import christmas.domain.Order;
import christmas.domain.benefit.BenefitCategory;

public class GiftBenefit extends BenefitItem {


    public GiftBenefit(BenefitCategory benefitCategory, int discountPrice) {
        super(benefitCategory, discountPrice);
    }

    public static GiftBenefit of(BenefitCategory benefitCategory, Calender calender, Order order) {
        return new GiftBenefit(benefitCategory, calculateDiscountPrice(benefitCategory, calender, order));
    }

    private static int calculateDiscountPrice(BenefitCategory benefitCategory, Calender calender, Order order) {
        return 25_000;
    }
}
