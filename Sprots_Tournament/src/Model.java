import java.util.ArrayList;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.Toggle;
import javafx.scene.control.ToggleGroup;

public class Model {

	public Model() {
	}

	public boolean checkIfNameIsWritten(TextField txt) {
		if (txt.getText().isEmpty()) {
			return false;
		} else
			return true;
	}

	public boolean checkIfSportChosen(ToggleGroup tgl) {
		if (tgl.getSelectedToggle() != null)
			return true;
		return false;
	}

	public boolean checkSelectedSportType(Toggle tgl, RadioButton but) {
		if (tgl.equals(but))
			return true;
		return false;
	}

	public String checkIfNumbers(TextField txt) {
		try {
			Integer.parseInt(txt.getText());
		} catch (NumberFormatException ex) {
			return "All results must be numbers";
		}
		if (Integer.parseInt(txt.getText()) < 0) {
			return "Score must not be negative";
		}
		return "";
	}

	public String checkIf3SetsWinner(TextField txt1, TextField txt2, TextField txt3, TextField txt6, TextField txt7,
			TextField txt8) {
		int firstSetFirstOpponent = Integer.parseInt(txt1.getText());
		int secondSetFirstOpponent = Integer.parseInt(txt2.getText());
		int thirdSetFirstOpponent = Integer.parseInt(txt3.getText());
		int firstSetSecondOpponent = Integer.parseInt(txt6.getText());
		int secondSetSecondOpponent = Integer.parseInt(txt7.getText());
		int thirdSetSecondOpponent = Integer.parseInt(txt8.getText());
		if ((firstSetFirstOpponent > firstSetSecondOpponent) && (secondSetFirstOpponent > secondSetSecondOpponent)
				&& (thirdSetFirstOpponent > thirdSetSecondOpponent))
			return "first wins";
		else if ((firstSetFirstOpponent < firstSetSecondOpponent) && (secondSetFirstOpponent < secondSetSecondOpponent)
				&& (thirdSetFirstOpponent < thirdSetSecondOpponent))
			return "second wins";
		else
			return "there is no winner";
	}

	public String checkIfBasketWinner(TextField txt1, TextField txt2, TextField txt3, TextField txt4, TextField txt5,
			TextField txt6, TextField txt7, TextField txt8) {
		int firstQuarterFirstOpponent = Integer.parseInt(txt1.getText());
		int secondQuarterFirstOpponent = Integer.parseInt(txt2.getText());
		int thirdQuarterFirstOpponent = Integer.parseInt(txt3.getText());
		int fourthQuarterFirstOpponent = Integer.parseInt(txt4.getText());
		int firstQuarterSecondOpponent = Integer.parseInt(txt5.getText());
		int secondQuarterSecondOpponent = Integer.parseInt(txt6.getText());
		int thirdQuarterSecondOpponent = Integer.parseInt(txt7.getText());
		int fourthQuarterSecondOpponent = Integer.parseInt(txt8.getText());
		int firstOpponentTotalScore = 0;
		int secondOpponentTotalScore = 0;
		firstOpponentTotalScore = firstQuarterFirstOpponent + secondQuarterFirstOpponent + thirdQuarterFirstOpponent
				+ fourthQuarterFirstOpponent;
		secondOpponentTotalScore = firstQuarterSecondOpponent + secondQuarterSecondOpponent + thirdQuarterSecondOpponent
				+ fourthQuarterSecondOpponent;
		if (firstOpponentTotalScore > secondOpponentTotalScore)
			return "first wins";
		else if (secondOpponentTotalScore > firstOpponentTotalScore)
			return "second wins";
		else
			return "there is no winner";
	}

	public String checkIfSoccerWinner(TextField txt1, TextField txt2, TextField txt3, TextField txt4) {
		int firstHalfFirstOpponent = Integer.parseInt(txt1.getText());
		int secondHalfFirstOpponent = Integer.parseInt(txt2.getText());
		int firstHalfSecondOpponent = Integer.parseInt(txt3.getText());
		int secondHalfSecondOpponent = Integer.parseInt(txt4.getText());
		if ((firstHalfFirstOpponent + secondHalfFirstOpponent) > (firstHalfSecondOpponent + secondHalfSecondOpponent))
			return "first wins";
		else if ((firstHalfFirstOpponent + secondHalfFirstOpponent) < (firstHalfSecondOpponent
				+ secondHalfSecondOpponent))
			return "second wins";
		else
			return "there is no winner";
	}

	public String checkIf5SetsWinner(TextField txt1, TextField txt2, TextField txt3, TextField txt4, TextField txt5,
			TextField txt6, TextField txt7, TextField txt8, TextField txt9, TextField txt10) {
		int firstSetOppo1 = Integer.parseInt(txt1.getText());
		int secondSetOppo1 = Integer.parseInt(txt2.getText());
		int thirdSetOppo1 = Integer.parseInt(txt3.getText());
		int fourthSetOppo1 = Integer.parseInt(txt4.getText());
		int fifthSetOppo1 = Integer.parseInt(txt5.getText());
		int firstSetOppo2 = Integer.parseInt(txt6.getText());
		int secondSetOppo2 = Integer.parseInt(txt7.getText());
		int thirdSetOppo2 = Integer.parseInt(txt8.getText());
		int fourthSetOppo2 = Integer.parseInt(txt9.getText());
		int fifthSetOppo2 = Integer.parseInt(txt10.getText());
		int oppo1SetsWin = 0, oppo2SetsWin = 0;
		if (firstSetOppo1 > firstSetOppo2)
			oppo1SetsWin++;
		if (firstSetOppo1 < firstSetOppo2)
			oppo2SetsWin++;
		if (secondSetOppo1 > secondSetOppo2)
			oppo1SetsWin++;
		if (secondSetOppo1 < secondSetOppo2)
			oppo2SetsWin++;
		if (thirdSetOppo1 > thirdSetOppo2)
			oppo1SetsWin++;
		if (thirdSetOppo1 < thirdSetOppo2)
			oppo2SetsWin++;
		if (fourthSetOppo1 > fourthSetOppo2)
			oppo1SetsWin++;
		if (fourthSetOppo1 < fourthSetOppo2)
			oppo2SetsWin++;
		if (fifthSetOppo1 > fifthSetOppo2)
			oppo1SetsWin++;
		if (fifthSetOppo1 < fifthSetOppo2)
			oppo2SetsWin++;
		if ((oppo1SetsWin == 3 && oppo2SetsWin == 2) || (oppo1SetsWin == 4 && oppo2SetsWin == 1)
				|| oppo1SetsWin == 5 && oppo2SetsWin == 0) // 3-2,4-1,5-0
			return "first wins";
		else if ((oppo2SetsWin == 3 && oppo1SetsWin == 2) || (oppo2SetsWin == 4 && oppo1SetsWin == 1)
				|| oppo2SetsWin == 5 && oppo1SetsWin == 0) // 2-3,1-4,0-5
			return "second wins";
		else
			return "there is no winner";
	}

	public boolean checkIfNotEmptyAndInOut(TextField txt) {
		if (txt.getText().equals("In") || txt.getText().equals("Out"))
			return true;
		return false;
	}

	public String checkPenaltyWinner(TextField txt1, TextField txt2, TextField txt3, TextField txt4, TextField txt5,
			TextField txt6, TextField txt7, TextField txt8, TextField txt9, TextField txt10) {
		int firstOpponentTotalScore = 0;
		int secondOpponentTotalScore = 0;
		ArrayList<TextField> firstScores = new ArrayList<TextField>();
		ArrayList<TextField> secondScores = new ArrayList<TextField>();
		firstScores.add(txt1);
		firstScores.add(txt2);
		firstScores.add(txt3);
		firstScores.add(txt4);
		firstScores.add(txt5);
		secondScores.add(txt6);
		secondScores.add(txt7);
		secondScores.add(txt8);
		secondScores.add(txt9);
		secondScores.add(txt10);
		for (TextField txt : firstScores) {
			if (txt.getText().equals("In")) {
				firstOpponentTotalScore++;
			}
		}
		for (TextField txt : secondScores) {
			if (txt.getText().equals("In")) {
				secondOpponentTotalScore++;
			}
		}

		if (firstOpponentTotalScore > secondOpponentTotalScore)
			return "first wins";
		else if (secondOpponentTotalScore > firstOpponentTotalScore)
			return "second wins";
		else
			return "there is no winner";
	}

	public String checkIfOvertimeWinner(TextField txt1, TextField txt2) {
		int firstOpponentScore = Integer.parseInt(txt1.getText());
		int secondOpponentScore = Integer.parseInt(txt2.getText());
		if (firstOpponentScore > secondOpponentScore)
			return "first wins";
		else if (firstOpponentScore < secondOpponentScore)
			return "second wins";
		return "there is no winner";

	}

	public boolean checkIfNotEmpty(TextField txt) {
		if (txt.getText().isEmpty())
			return false;
		return true;
	}

}
