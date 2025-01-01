package christmas.io;

import christmas.domain.Calender;
import christmas.domain.Order;
import christmas.error.ErrorCode;
import java.util.function.Supplier;

public class InputView implements AutoCloseable {

    private final Reader DEFAULT_READER = new ConsoleReader();
    private final Reader reader;

    public InputView(Reader reader) {
        this.reader = reader;
    }

    public InputView() {
        this.reader = DEFAULT_READER;
    }

    private String readLine() {
        String input = reader.readLine();
        validate(input);
        return input;
    }

    private static void printReInput(IllegalArgumentException ex) {
        System.out.flush();
        System.out.println(ex.getMessage());
    }

    private static void validate(String input) {
        if (input.isBlank()) {
            throw new IllegalArgumentException(ErrorCode.BLANK_INPUT_MESSAGE.getMessage());
        }
    }

    public Calender inputDate() {
        return retryInput("12월 중 식당 예상 방문 날짜는 언제인가요? (숫자만 입력해 주세요!)",
                () -> new Calender(readLine()));
    }

    public Order inputMenu() {
        return retryInput("주문하실 메뉴와 개수를 알려 주세요. (e.g. 해산물파스타-2,레드와인-1,초코케이크-1)",
                () -> new Order(readLine()));
    }


    private static <T> T retryInput(String prompt, Supplier<T> inputSupplier) {
        System.out.println(prompt);
        while (true) {
            try {
                T result = inputSupplier.get();
                return result;
            } catch (IllegalArgumentException ex) {
                printReInput(ex);
            }
        }
    }

    @Override
    public void close() {
        reader.close();
    }
}
