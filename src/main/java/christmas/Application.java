package christmas;

import christmas.domain.Calender;
import christmas.domain.Menu;
import christmas.io.InputView;
import christmas.io.OutputView;

public class Application {
    public static void main(String[] args) {

        OutputView.printWelcomeMessage();

        try (InputView inputView = new InputView()) {
            Calender calender = inputView.inputDate();
            Menu menu = inputView.inputMenu();
            OutputView.printEventMessage(calender);
            OutputView.printOrderMenu(menu);
            OutputView.printTotalPrice(menu);
        }

    }
}
