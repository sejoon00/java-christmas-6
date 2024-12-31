package christmas.domain;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class CalenderTest {

    @Test
    void 날짜출력_성공() {
        Calender calender = new Calender("25");
        assertEquals("MONDAY", calender.getDayOfWeek().toString());
    }


    @ParameterizedTest(name = "[{index}] Invalid date input: {0}")
    @ValueSource(strings = { "32", "0", "-1", "abc", "2023-02-30", "99" })
    void 날짜출력_실패(String input) {
        assertThrows(IllegalArgumentException.class, () -> new Calender("32"));
    }

}