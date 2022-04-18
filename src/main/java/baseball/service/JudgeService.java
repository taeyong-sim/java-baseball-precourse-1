package baseball.service;

import baseball.common.Message;
import baseball.domain.BaseballNumber;


public class JudgeService {

    public String judgeResult(CompareService compareService, BaseballNumber baseballNumber_player){
        int total = compareService.countTotal(baseballNumber_player)
                                  .getTotal();
        int strike = compareService.countStrike(baseballNumber_player)
                                  .getStrike();
        int ball = total - strike;

        if(total == 0){
            return Message.MSG_NOTHING;
        }
        if(strike == 0){
            return ball + Message.MSG_BALL;
        }
        if(ball == 0){
            return strike + Message.MSG_STRIKE;
        }

        return ball + Message.MSG_BALL + " " + strike + Message.MSG_STRIKE;
    }
}
