package baseball.domain;

import baseball.common.Message;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

public class BaseballNumber {

    private List<Integer> baseballNumberList;

    public BaseballNumber(){
        this.baseballNumberList = new ArrayList<>();
    }

    public BaseballNumber(String inputStr) {
        this.baseballNumberList = new ArrayList<>();
        if(validate(inputStr)){
            this.baseballNumberList = storeInputString(inputStr);
        }
    }

    private boolean validate(String inputString) {
        String regex = "^[1-9]{3}$";

        if(!Pattern.matches(regex, inputString)) {
            throw new IllegalArgumentException(Message.MSG_EXCEPTION);
        }

        return true;
    }

    private int convertStringToNumber(String inputStr){
        return Integer.parseInt(inputStr);
    }

    private List<Integer> storeInputString(String inputStr){
        int inputNumber = convertStringToNumber(inputStr);
        numberToList(inputNumber);

        return baseballNumberList;
    }

    private void numberToList(int inputNumber){
        String[] inputNumberArr = String.valueOf(inputNumber).split("");
        for (String numberStr : inputNumberArr) {
            int digit = Integer.parseInt(numberStr);
            isValid(digit);
            baseballNumberList.add(digit);
        }
    }

    private void isValid(int digit){
        if(baseballNumberList.contains(digit)){
            throw new IllegalArgumentException(Message.MSG_EXCEPTION);
        }
    }

    public int getDigitNumber(int sequence){
        return baseballNumberList.get(sequence);
    }

    public boolean isExist(int digit){
        return baseballNumberList.contains(digit);
    }

    public int getIndex(int digit){
        return baseballNumberList.indexOf(digit);
    }

    public int getSize(){
        return baseballNumberList.size();
    }

    public void addDigit(int digit){
        baseballNumberList.add(digit);
    }

    public List<Integer> getBaseballNumberList() {
        return baseballNumberList;
    }
}
