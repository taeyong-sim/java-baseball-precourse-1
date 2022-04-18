package baseball.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;


@DisplayName("Computer Class TEST")
class ComputerTest {

    private Computer computer;

    @BeforeEach
    void init(){
        computer = new Computer();
    }

    @DisplayName("Computer 초기화")
    @Test
    void computerInitTest(){
        assertNotNull(computer.generateRandomNumber());
    }

    @DisplayName("Computer 숫자 Size")
    @Test
    void computerRandomNumberSizeTest(){
        BaseballNumber computerNumber = computer.generateRandomNumber();
        assertEquals(computerNumber.getSize(), 3);
    }

}