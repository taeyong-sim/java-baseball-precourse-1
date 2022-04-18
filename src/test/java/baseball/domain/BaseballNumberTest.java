package baseball.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;


@DisplayName("BaseballNumber class TEST")
class BaseballNumberTest {

    @DisplayName("BaseballNumber List 비교")
    @Test
    void ListEqualityTest(){
        BaseballNumber baseballNumber = new BaseballNumber("123");
        List<Integer> numberList = new ArrayList<>(Arrays.asList(1,2,3));
        assertEquals(baseballNumber.getBaseballNumberList(), numberList);
    }

    @DisplayName("숫자 아닌 문자가 포함된 값 입력시 IllegalArgumentException 발생")
    @Test
    void onlyNumberTest(){
        assertThrows(IllegalArgumentException.class, () -> new BaseballNumber("12a"));
    }

    @DisplayName("3자리 숫자가 아닌 값 입력시 IllegalArgumentException 발생")
    @Test
    void threeDigitNumberTest(){
        assertThrows(IllegalArgumentException.class, () -> new BaseballNumber("12"));
    }

    @DisplayName("0이 포함된 값 입력시 IllegalArgumentException 발생")
    @Test
    void notContainZeroTest(){
        assertThrows(IllegalArgumentException.class, () -> new BaseballNumber("120"));
    }
}