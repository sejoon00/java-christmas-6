package christmas.domain.benefit;

import christmas.domain.Calender;
import christmas.domain.Menu;
import java.util.ArrayList;
import java.util.List;

public class BenefitItemFactory {

    public static List<BenefitItem> createBenefitItems(List<BenefitCategory> benefitCategory, Calender calender, Menu menu) {
        List<BenefitItem> benefitItems = new ArrayList<>();
        for(BenefitCategory category : benefitCategory) {
            benefitItems.add(createBenefitItem(category, calender, menu));
        }
        return benefitItems;
    }

    private static BenefitItem createBenefitItem(BenefitCategory category, Calender calender, Menu menu) {
        switch(category) {
            case 평일할인:
                return WeekdaysBenefit.of(category, calender, menu);
            case 주말할인:
                return WeekendBenefit.of(category, calender, menu);
            case 크리스마스_디데이할인:
                return ChristmasBenefit.of(category, calender, menu);
            case 특별할인:
                return SpecialBenefit.of(category, calender, menu);
            case 증정이벤트:
                return GiftBenefit.of(category, calender, menu);
            default:
                throw new IllegalArgumentException("잘못된 혜택 카테고리입니다.");
        }
    }
}
