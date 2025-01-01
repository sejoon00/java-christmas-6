package christmas.domain.benefit.benefitItems;

import christmas.domain.Calender;
import christmas.domain.Menu;
import christmas.domain.benefit.BenefitCategory;

public class SpecialBenefit extends BenefitItem {


    public SpecialBenefit(BenefitCategory benefitCategory, int discountPrice) {
        super(benefitCategory, discountPrice);
    }

    public static SpecialBenefit of(BenefitCategory benefitCategory, Calender calender, Menu menu) {
        return new SpecialBenefit(benefitCategory, calculateDiscountPrice(benefitCategory, calender, menu));
    }

    private static int calculateDiscountPrice(BenefitCategory benefitCategory, Calender calender, Menu menu) {
        return 1000;
    }
}
