package baseball.controller;

import baseball.common.Message;
import baseball.domain.BaseballNumber;
import baseball.domain.Computer;
import baseball.domain.Player;
import baseball.domain.Score;
import baseball.service.CompareService;
import baseball.service.JudgeService;
import baseball.ui.Input;

public class BaseballGameController {

    private static final int NEW_GAME = 1;
    private static final int QUIT_GAME = 2;
    private static final String ON_STATE = "ON";
    private static final String OFF_STATE = "OFF";
    private static final int STRIKE_OUT = 3;

    private static Computer computer;
    private static Player player;
    private static Score score;
    private static Message message;
    private static String state;
    private static Input input;

    public static void run(){
        initBaseballGame();
        while(!OFF_STATE.equals(state)){
            inputNumber();
            printJudgement();
            confirmResult();
        }
    }

    private static void initBaseballGame(){
        state = ON_STATE;
        computer = new Computer();
        player = new Player();
        message = new Message();
    }

    private static void inputNumber(){
        message.printMessage(Message.MSG_INPUT);
        input = new Input();
        String inputStr = input.inputNumber();
        player.setBaseballNumber(new BaseballNumber(inputStr));
    }

    private static void printJudgement(){
        CompareService compareService = new CompareService(Computer.getComputerNumber(), player.getBaseballNumber());
        score = compareService.getScore();
        JudgeService judgeService = new JudgeService();
        String result = judgeService.judgeResult(compareService, player.getBaseballNumber());
        message.printMessage(result + "\n");
    }

    private static void confirmResult(){
        if(score.getStrike() == STRIKE_OUT){
            state = OFF_STATE;
            message.printMessage(Message.MSG_WIN);
            determineGame();
        }
    }

    private static int askGameContinue() throws IllegalArgumentException {
        message.printMessage(Message.MSG_ASK);
        try{
            int choice = Integer.parseInt(input.inputNumber());
            if(choice != 1 && choice != 2){
                throw new IllegalArgumentException(Message.MSG_EXCEPTION);
            }
            return choice;
        }catch(NumberFormatException e) {
            throw new IllegalArgumentException(Message.MSG_EXCEPTION);
        }
    }

    private static void determineGame(){
        int choice = askGameContinue();

        if(choice == NEW_GAME){
            message.printMessage(Message.MSG_RESTART);
            initBaseballGame();
        }
        if(choice == QUIT_GAME){
            message.printMessage(Message.MSG_END);
            state = OFF_STATE;
        }
    }

}
