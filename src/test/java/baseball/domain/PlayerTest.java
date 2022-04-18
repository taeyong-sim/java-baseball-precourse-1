package baseball.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;


@DisplayName("Player class TEST")
class PlayerTest {

    private Player player;

    @BeforeEach
    void init(){
        player = new Player();
    }

    @DisplayName("player 초기화")
    @Test
    void initPlayer(){
        BaseballNumber baseballNumber = new BaseballNumber("123");
        player.setBaseballNumber(baseballNumber);
        assertEquals(new ArrayList<>(Arrays.asList(1,2,3)), player.getBaseballNumber().getBaseballNumberList());
    }
}