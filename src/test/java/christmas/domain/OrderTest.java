package christmas.domain;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class OrderTest {

    @Test
    void 메뉴_생성_성공() {
        Order order = new Order("제로콜라-2,타파스-1");
        assertEquals(2, order.getOrderItems().size());
    }

    @ParameterizedTest(name = "[{index}] Invalid menu input: {0}")
    @ValueSource(strings = { "제로콜라-1, 타파스-1",  "제로콜라-1,제로콜라-1", "제로콜라-1, 제로콜라-2"})
    void 메뉴_생성_실패(String input) {
        assertThrows(IllegalArgumentException.class, () -> new Order(input));
    }

}