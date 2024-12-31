package christmas.io;

import christmas.domain.Calender;
import christmas.domain.Menu;
import christmas.domain.OrderItem;
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
    }
}
