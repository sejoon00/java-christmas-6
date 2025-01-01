package christmas.domain.benefit;

import christmas.domain.Calender;
import christmas.domain.Menu;
import christmas.domain.benefit.benefitItems.BenefitItem;
import java.util.List;

public class Benefits {

    public static final int GIFT_PRICE = 25_000;
    private List<BenefitItem> benefitItems;

    public Benefits(Calender calender, Menu menu) {
        List<BenefitCategory> benefitCategory = BenefitCategory.getBenefitItems(calender, menu);
        this.benefitItems = BenefitItemFactory.createBenefitItems(benefitCategory, calender, menu);
    }

    public List<BenefitItem> getBenefitItems() {
        return benefitItems;
    }

    public int getBenefitPrice() {
        return benefitItems.stream()
                .mapToInt(BenefitItem::getDiscountPrice)
                .sum();
    }

    public int getDiscountPrice(){
        int sum = benefitItems.stream()
                .mapToInt(BenefitItem::getDiscountPrice)
                .sum();

        if(isGiftBenefit())
            sum -= GIFT_PRICE;

        return sum;
    }

    public String getGiftBenefit() {
        if(isGiftBenefit()) {
            return "샴페인 1개";
        }
        return "없음";
    }

    private boolean isGiftBenefit() {
        return benefitItems.stream()
                .anyMatch(benefitItem -> benefitItem.getBenefitCategory() == BenefitCategory.증정이벤트);
    }

    public Badges getBadges() {
        return Badges.getBadge(getBenefitPrice());
    }
}
