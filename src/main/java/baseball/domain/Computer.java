package baseball.domain;

import camp.nextstep.edu.missionutils.Randoms;


public class Computer {

	private static final int START_INCLUSIVE = 1;
	private static final int END_INCLUSIVE = 9;
	private static final int COUNT = 3;

	private static BaseballNumber computerNumber;

	public Computer() {
		computerNumber = new BaseballNumber();
		computerNumber = generateRandomNumber();
	}

	private void saveRandomNumber(int digit){
		if (!computerNumber.isExist(digit)) {
			computerNumber.addDigit(digit);
		}
	}

	public BaseballNumber generateRandomNumber(){

		while(computerNumber.getSize() < COUNT) {
			int randomDigit = Randoms.pickNumberInRange(START_INCLUSIVE, END_INCLUSIVE);
			saveRandomNumber(randomDigit);
		}

		return computerNumber;
	}

	public static BaseballNumber getComputerNumber() {
		return computerNumber;
	}



}