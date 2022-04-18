package baseball.service;

import baseball.domain.BaseballNumber;
import baseball.domain.Score;

public class CompareService {

    private final BaseballNumber baseballNumber_computer;
    private final BaseballNumber baseballNumber_player;
    private final Score score;

    public CompareService(BaseballNumber baseballNumber_computer, BaseballNumber baseballNumber_player){
        this.baseballNumber_computer = baseballNumber_computer;
        this.baseballNumber_player = baseballNumber_player;
        score = new Score(0,0);
    }

    public Score countTotal(BaseballNumber baseballNumber_player){
        int size = baseballNumber_player.getSize();
        for (int i = 0; i < size; i++) {
            int playerDigit = baseballNumber_player.getDigitNumber(i);
            addTotal(playerDigit, score);
        }

        return score;
    }

    private void addTotal(int playerDigit, Score score){
        if(baseballNumber_computer.isExist(playerDigit)){
            score.setTotal(score.getTotal()+1);
        }
    }

    public Score countStrike(BaseballNumber baseballNumber_player){
        for (int i = 0; i < baseballNumber_player.getSize(); i++) {
            int playerDigit = baseballNumber_player.getDigitNumber(i);
            addStrike(playerDigit, score);
        }

        return score;
    }

    private void addStrike(int playerDigit, Score score){
        if(baseballNumber_computer.getIndex(playerDigit) ==  baseballNumber_player.getIndex(playerDigit)){
            score.setStrike(score.getStrike()+1);
        }
    }

    public Score getScore() {
        return score;
    }
}
