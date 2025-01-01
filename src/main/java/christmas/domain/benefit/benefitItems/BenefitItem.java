package christmas.domain.benefit.benefitItems;

import christmas.domain.benefit.BenefitCategory;

public abstract class BenefitItem {
    private BenefitCategory benefitCategory;
    private int discountPrice;

    public BenefitItem(BenefitCategory benefitCategory, int discountPrice) {
        this.benefitCategory = benefitCategory;
        this.discountPrice = discountPrice;
    }

    public String getName() {
        return benefitCategory.getName();
    }

    public int getDiscountPrice() {
        return discountPrice;
    }

    public BenefitCategory getBenefitCategory() {
        return benefitCategory;
    }
}
