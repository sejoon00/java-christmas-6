package christmas.domain.benefit;

import christmas.domain.Calender;
import christmas.domain.Order;
import christmas.domain.benefit.benefitItems.BenefitItem;
import christmas.domain.benefit.benefitItems.ChristmasBenefit;
import christmas.domain.benefit.benefitItems.GiftBenefit;
import christmas.domain.benefit.benefitItems.SpecialBenefit;
import christmas.domain.benefit.benefitItems.WeekdaysBenefit;
import christmas.domain.benefit.benefitItems.WeekendBenefit;
import java.util.ArrayList;
import java.util.List;

public class BenefitItemFactory {

    public static List<BenefitItem> createBenefitItems(List<BenefitCategory> benefitCategory, Calender calender, Order order) {
        List<BenefitItem> benefitItems = new ArrayList<>();
        for(BenefitCategory category : benefitCategory) {
            benefitItems.add(createBenefitItem(category, calender, order));
        }
        return benefitItems;
    }

    private static BenefitItem createBenefitItem(BenefitCategory category, Calender calender, Order order) {
        switch(category) {
            case 평일할인:
                return WeekdaysBenefit.of(category, calender, order);
            case 주말할인:
                return WeekendBenefit.of(category, calender, order);
            case 크리스마스_디데이할인:
                return ChristmasBenefit.of(category, calender, order);
            case 특별할인:
                return SpecialBenefit.of(category, calender, order);
            case 증정이벤트:
                return GiftBenefit.of(category, calender, order);
            default:
                throw new IllegalArgumentException("잘못된 혜택 카테고리입니다.");
        }
    }
}
