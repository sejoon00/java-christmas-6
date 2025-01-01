package christmas;

import christmas.domain.benefit.Benefits;
import christmas.domain.Calender;
import christmas.domain.Order;
import christmas.io.InputView;
import christmas.io.OutputView;

public class Application {
    public static void main(String[] args) {

        OutputView.printWelcomeMessage();

        try (InputView inputView = new InputView()) {
            Calender calender = inputView.inputDate();
            Order order = inputView.inputMenu();
            OutputView.printEventMessage(calender);
            OutputView.printOrderMenu(order);
            OutputView.printTotalPrice(order);
            Benefits benefits = new Benefits(calender, order);
            OutputView.printBenefit(order, benefits);
        }

    }
}
