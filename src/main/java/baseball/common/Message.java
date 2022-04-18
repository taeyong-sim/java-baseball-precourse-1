package baseball.common;

public class Message {

    public final static String MSG_INPUT = "숫자를 입력해주세요 : ";
    public final static String MSG_WIN = "3개의 숫자를 모두 맞히셨습니다! 게임 종료\n";
    public final static String MSG_STRIKE = "스트라이크";
    public final static String MSG_BALL = "볼";
    public final static String MSG_NOTHING = "낫싱";
    public final static String MSG_ASK = "게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.\n";
    public final static String MSG_END = "게임이 종료되었습니다.\n";
    public final static String MSG_RESTART = "다시 게임을 시작합니다.\n";
    public final static String MSG_EXCEPTION = "잘못된 숫자를 입력하셨습니다.\n";

    public void printMessage(String message){
        System.out.print(message);
    }



}
