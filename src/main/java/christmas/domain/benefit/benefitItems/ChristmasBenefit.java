package christmas.domain.benefit.benefitItems;

import christmas.domain.Calender;
import christmas.domain.Menu;
import christmas.domain.benefit.BenefitCategory;

public class ChristmasBenefit extends BenefitItem {

    public ChristmasBenefit(BenefitCategory benefitCategory, int discountPrice) {
        super(benefitCategory, discountPrice);
    }

    public static ChristmasBenefit of(BenefitCategory benefitCategory, Calender calender, Menu menu) {
        return new ChristmasBenefit(benefitCategory, calculateDiscountPrice(benefitCategory, calender, menu));
    }

    private static int calculateDiscountPrice(BenefitCategory benefitCategory, Calender calender, Menu menu) {

        return 1000 + (calender.getDate().getDayOfMonth() - 1) * benefitCategory.getPrice();
    }
}
