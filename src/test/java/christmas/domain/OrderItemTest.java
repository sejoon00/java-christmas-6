package christmas.domain;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class OrderItemTest {

    @Test
    void 주문_상품_생성_성공() {
        OrderItem orderItem = new OrderItem("제로콜라-2");
        assertEquals("제로콜라", orderItem.getName());
        assertEquals(2, orderItem.getOrderCount());
    }

    @ParameterizedTest(name = "[{index}] Invalid order item input: {0}")
    @ValueSource(strings = { "제로콜라-0", "제로콜라-abc", "제로콜라--1", "제로콜라-1-1", "제로콜라", "제로콜라-1-1" })
    void 주문_상품_생성_실패(String input) {
        assertThrows(IllegalArgumentException.class, () -> new OrderItem(input));
    }


}