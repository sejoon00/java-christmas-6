package christmas.io;

import christmas.domain.benefit.Benefits;
import christmas.domain.Calender;
import christmas.domain.Menu;
import christmas.domain.OrderItem;
import java.text.DecimalFormat;
import java.time.LocalDate;
import java.util.List;

public class OutputView {

    public static void printWelcomeMessage() {
        System.out.println("안녕하세요! 우테코 식당 12월 이벤트 플래너입니다.");
    }

    public static void printEventMessage(Calender calender) {
        LocalDate date = calender.getDate();
        System.out.println(date.getMonth().getValue() + "월 " + date.getDayOfMonth() + "일에 우테코 식당에서 받을 이벤트 혜택 미리 보기! \n");
    }

    public static void printOrderMenu(Menu menu) {
        System.out.println("<주문 메뉴>");
        List<OrderItem> orderItems = menu.getOrderItems();
        orderItems.forEach(
                orderItem -> System.out.println(orderItem.getName() + " " + orderItem.getOrderCount() + "개")
        );
        System.out.println();
    }

    public static void printTotalPrice(Menu menu) {
        int totalPrice = menu.calculateTotalPrice();
        DecimalFormat df = new DecimalFormat("###,###");
        System.out.println("<할인 전 총주문 금액>");
        System.out.println(df.format(totalPrice) + "원\n");
    }

    public static void printBenefit(Menu menu, Benefits benefits){
        printGiftBenefit(benefits);
        printBenefits(benefits);
        printTotalDiscountPrice(benefits);
        printAfterDiscountPrice(menu, benefits);
        printBadge(benefits);
    }

    public static void printGiftBenefit(Benefits benefits) {
        System.out.println("<증정 메뉴>");
        System.out.println(benefits.getGiftBenefit() + "\n");
    }

    public static void printBenefits(Benefits benefits) {
        System.out.println("<혜택 내역>");
        benefits.getBenefitItems().forEach(
                benefitItem -> {
                    DecimalFormat df = new DecimalFormat("###,###");
                    System.out.println(benefitItem.getName() + ": -" + df.format(benefitItem.getDiscountPrice()) + "원");
                }
        );
        System.out.println();
    }

    public static void printTotalDiscountPrice(Benefits benefits) {
        System.out.println("<총혜택 금액>");
        int totalDiscountPrice = benefits.getBenefitPrice();
        DecimalFormat df = new DecimalFormat("###,###");
        System.out.println("-" + df.format(totalDiscountPrice) + "원\n");
    }

    public static void printAfterDiscountPrice(Menu menu, Benefits benefits) {
        int afterDiscountPrice = menu.calculateTotalPrice() - benefits.getDiscountPrice();
        DecimalFormat df = new DecimalFormat("###,###");
        System.out.println("<할인 후 예상 결제 금액>");
        System.out.println(df.format(afterDiscountPrice) + "원\n");
    }

    public static void printBadge(Benefits benefits) {
        System.out.println("<12월 이벤트 배지>");
        System.out.println(benefits.getBadges().getName());
    }
}
