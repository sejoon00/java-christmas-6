package christmas.domain.benefit;

import christmas.domain.Calender;
import christmas.domain.Menu;

public class GiftBenefit extends BenefitItem {


    public GiftBenefit(BenefitCategory benefitCategory, int discountPrice) {
        super(benefitCategory, discountPrice);
    }

    public static GiftBenefit of(BenefitCategory benefitCategory, Calender calender, Menu menu) {
        return new GiftBenefit(benefitCategory, calculateDiscountPrice(benefitCategory, calender, menu));
    }

    private static int calculateDiscountPrice(BenefitCategory benefitCategory, Calender calender, Menu menu) {
        return 25_000;
    }
}
