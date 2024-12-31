package christmas.error;

public enum ErrorCode {

    BLANK_INPUT_MESSAGE("잘못된 입력입니다. 다시 입력해 주세요."),
    INVALID_DATE_FORMAT("날짜 형식이 잘못되었습니다. 다시 입력해 주세요."),
    INVALID_MENU_FORMAT("유효하지 않은 주문입니다. 다시 입력해 주세요."),

    ;
    private final String message;
    private static final String PREFIX = "[ERROR] ";

    ErrorCode(String message) {
        this.message = message;
    }

    public String getMessage() {
        return PREFIX + message;
    }
}
