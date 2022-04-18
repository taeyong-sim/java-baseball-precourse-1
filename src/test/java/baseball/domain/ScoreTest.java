package baseball.domain;

import baseball.service.CompareService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;


@DisplayName("Score Class TEST")
class ScoreTest {

    private BaseballNumber baseballNumber;
    private CompareService compareService;

    @BeforeEach
    void init(){
        baseballNumber = new BaseballNumber("243");
        compareService = new CompareService(new BaseballNumber("123"), baseballNumber);
    }

    @DisplayName("Score Total")
    @Test
    void scoreTotalTest(){
        Score score = compareService.countTotal(baseballNumber);
        assertEquals(score.getTotal(), 2);
    }

    @DisplayName("Score Strike")
    @Test
    void scoreStrikeTest(){
        Score score = compareService.countStrike(baseballNumber);
        assertEquals(score.getStrike(), 1);
    }
}