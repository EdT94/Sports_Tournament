

import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.control.Toggle;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class Controller {
	private Model model;
	private View view;
	private static boolean participants, sportType, notEmpty;
	private String sport;

	public Controller(Model model, View view) {
		this.model = model;
		this.view = view;
		mySetOnActionAddParticipant();
		mySetOnActionStartChampionship();
		mySetOnActionQuarterFinal();
		mySetOnActionDone();
		mySetOnActionSemiFinal();
		mySetOnActionFinal();
		mySetOnActionOvertime();
		mySetOnActionPenalty();
	}

	public void mySetOnActionAddParticipant() {
		for (Node node : view.getNamesLeftVbox().getChildren()) {
			if (node instanceof TextField)
				((TextField) node).setEditable(false);
		}
		view.mySetOnActionAddParticipant(e -> {
			view.getPrimaryBorderPane().setBottom(null);
			boolean notEmptyName = model.checkIfNameIsWritten(view.getParticipantNameTf());

			if (notEmptyName) {
				for (Node node : view.getNamesLeftVbox().getChildren()) {
					if (node instanceof TextField && ((TextField) node).getText().equals("")) {
						((TextField) node).setText(view.getParticipantName());
						view.getParticipantNameTf().setText("");
						break;
					}
				}
			} else
				view.setBottomTextException("Enter a name first", view.getPrimaryBorderPane());

		});
	}

	public void mySetOnActionStartChampionship() {
		view.mySetOnActionStartChampionship(e -> {
			for (Node node : view.getNamesLeftVbox().getChildren()) {
				participants = model.checkIfNameIsWritten((TextField) node);
				if (!participants) {
					break;
				}
			}
			for (Node node : view.getNamesLeftVbox().getChildren()) {
				notEmpty = model.checkIfNotEmpty((TextField) node);
				if (!notEmpty) {
					break;
				}
			}
			if (participants && notEmpty) {
				sportType = model.checkIfSportChosen(view.getTgl());
				if (sportType) {
					view.getPrimaryStage().close();
					view.nextScene();
					sport = getSelectedSportType();

				} else
					view.setBottomTextException("Choose type of sport", view.getPrimaryBorderPane());
			}

			else
				view.setBottomTextException("Fill all participants names", view.getPrimaryBorderPane());

		});
	}

	public String getSelectedSportType() {
		Toggle tgl = view.getTgl().getSelectedToggle();
		boolean selectedTennis, selectedBasketBall;
		selectedTennis = model.checkSelectedSportType(tgl, view.getTennisRadioButton());
		selectedBasketBall = model.checkSelectedSportType(tgl, view.getBasketBallRadioButton());
		if (selectedTennis)
			return "selectedTennis";
		else if (selectedBasketBall)
			return "selectedBasketBall";
		else
			return "selectedSoccer";

	}

	public void resetTextFieldsInTennisGame() {
		view.getScoreInputTxtField1().setText("");
		view.getScoreInputTxtField2().setText("");
		view.getScoreInputTxtField3().setText("");
		view.getScoreInputTxtField4().setText("");
		view.getScoreInputTxtField5().setText("");
		view.getScoreInputTxtField6().setText("");
		view.getScoreInputTxtField7().setText("");
		view.getScoreInputTxtField8().setText("");
		view.getScoreInputTxtField9().setText("");
		view.getScoreInputTxtField10().setText("");
	}

	public void mySetOnActionQuarterFinal() {
		setOnActionQuarterFinalButton1();
		setOnActionQuarterFinalButton2();
		setOnActionQuarterFinalButton3();
		setOnActionQuarterFinalButton4();
	}

	public void mySetOnActionSemiFinal() {
		setOnActionSemiFinalButton5();
		setOnActionSemiFinalButton6();
	}

	public void mySetOnActionFinal() {
		view.getFinalPlay().setOnAction(event -> {
			boolean written1 = model.checkIfNameIsWritten(view.getSemiFinal1Winner());
			boolean written2 = model.checkIfNameIsWritten(view.getSemiFinal2Winner());
			view.setBottomTextException("", view.getTournamentBorderPane());
			resetTextFieldsInTennisGame();
			if (written1 == false || written2 == false)
				view.setBottomTextException("Not all participants in the final are known", view.getTournamentBorderPane());
			else {
				if (getSelectedSportType().equals("selectedTennis"))
					view.startTennisCompetition(new Stage(), view.getSemiFinal1Winner().getText(), view.getSemiFinal2Winner().getText(),
							new Scene(view.getFinalBorderPane(), 450, 400), view.getFinalBorderPane(), view.getFinalGridPane(), view.getFinalDone());
				if (getSelectedSportType().equals("selectedBasketBall"))
					view.startBasketBallCompetition(new Stage(), view.getSemiFinal1Winner().getText(), view.getSemiFinal2Winner().getText(),
							new Scene(view.getFinalBorderPane(), 450, 400), view.getFinalBorderPane(), view.getFinalGridPane(), view.getFinalDone());
				if (getSelectedSportType().equals("selectedSoccer"))
					view.startSoccerCompetition(new Stage(), view.getSemiFinal1Winner().getText(), view.getSemiFinal2Winner().getText(),
							new Scene(view.getFinalBorderPane(), 450, 400), view.getFinalBorderPane(), view.getFinalGridPane(), view.getFinalDone());
			}
		});
	}

	public void doTournament(String selectedSportType, BorderPane bp, String winner1, String winner2,
			TextField winnerTf, boolean thereIsAWinner, Stage otStg, Scene otScene, BorderPane otBp, GridPane otGp,
			Button otBut) {
		boolean okTxt1, okTxt2, okTxt3, okTxt4, okTxt5, okTxt6, okTxt7, okTxt8, okTxt9, okTxt10,
				threeOrFiveSets = false;
		okTxt1 = model.checkIfNotEmpty(view.getScoreInputTxtField1());
		okTxt2 = model.checkIfNotEmpty(view.getScoreInputTxtField2());
		okTxt3 = model.checkIfNotEmpty(view.getScoreInputTxtField3());
		okTxt4 = model.checkIfNotEmpty(view.getScoreInputTxtField4());
		okTxt5 = model.checkIfNotEmpty(view.getScoreInputTxtField5());
		okTxt6 = model.checkIfNotEmpty(view.getScoreInputTxtField6());
		okTxt7 = model.checkIfNotEmpty(view.getScoreInputTxtField7());
		okTxt8 = model.checkIfNotEmpty(view.getScoreInputTxtField8());
		okTxt9 = model.checkIfNotEmpty(view.getScoreInputTxtField9());
		okTxt10 = model.checkIfNotEmpty(view.getScoreInputTxtField10());
		String str1 = model.checkIfNumbers(view.getScoreInputTxtField1());
		String str2 = model.checkIfNumbers(view.getScoreInputTxtField2());
		String str3 = model.checkIfNumbers(view.getScoreInputTxtField3());
		String str4 = model.checkIfNumbers(view.getScoreInputTxtField4());
		String str5 = model.checkIfNumbers(view.getScoreInputTxtField5());
		String str6 = model.checkIfNumbers(view.getScoreInputTxtField6());
		String str7 = model.checkIfNumbers(view.getScoreInputTxtField7());
		String str8 = model.checkIfNumbers(view.getScoreInputTxtField8());
		String str9 = model.checkIfNumbers(view.getScoreInputTxtField9());
		String str10 = model.checkIfNumbers(view.getScoreInputTxtField10());
		String[] positiveNumbers = new String[] { str1, str2, str3, str4, str5, str6, str7, str8, str9, str10 };
		String excep1 = "All results must be numbers";
		String excep2 = "Score must not be negative";
		if (selectedSportType.equals("selectedTennis")) {
			if (okTxt1 && okTxt2 && okTxt3 && !okTxt4 && !okTxt5 && okTxt6 && okTxt7 && okTxt8 && !okTxt9 && !okTxt10) {
				manageSingle3SetsTennisGame(bp, winner1, winner2, winnerTf, thereIsAWinner, threeOrFiveSets, excep1,
						excep2, positiveNumbers);
			} else if (okTxt1 && okTxt2 && okTxt3 && okTxt4 && okTxt5 && okTxt6 && okTxt7 && okTxt8 && okTxt9
					&& okTxt10) {
				manageSingle5SetsTennisGame(bp, winner1, winner2, winnerTf, thereIsAWinner, threeOrFiveSets, excep1,
						excep2, positiveNumbers);
			} else if (threeOrFiveSets == false)
				view.setBottomTextException("Enter results of 3 or 5 sets", bp);

		} else if (selectedSportType.equals("selectedBasketBall")) {
			if (okTxt1 && okTxt2 && okTxt3 && okTxt4 && okTxt5 && okTxt6 && okTxt7 && okTxt8) {
				manageSingleBasketballGame(bp, winner1, winner2, winnerTf, thereIsAWinner, excep1, excep2,
						positiveNumbers);
			} else
				view.setBottomTextException("Enter result for every quarter", bp);
		} else {
			if (okTxt1 && okTxt2 && okTxt3 && okTxt4) {
				manageSingleSoccerGame(bp, winner1, winner2, winnerTf, thereIsAWinner, excep1, excep2, positiveNumbers,
						otStg, otScene, otBp, otGp, otBut);
			} else
				view.setBottomTextException("Enter results of 2 halfs", bp);
		}
	}

	private void manageSingle3SetsTennisGame(BorderPane bp, String winner1, String winner2, TextField winnerTf,
			boolean thereIsAWinner, boolean threeOrFiveSets, String excep1, String excep2, String[] positiveNumbers) {
		threeOrFiveSets = true;
		if (positiveNumbers[0].equals(excep1) || positiveNumbers[0].equals(excep2) || positiveNumbers[1].equals(excep1)
				|| positiveNumbers[1].equals(excep2) || positiveNumbers[2].equals(excep1)
				|| positiveNumbers[2].equals(excep2) || positiveNumbers[5].equals(excep1)
				|| positiveNumbers[5].equals(excep2) || positiveNumbers[6].equals(excep1)
				|| positiveNumbers[6].equals(excep2) || positiveNumbers[7].equals(excep1)
				|| positiveNumbers[7].equals(excep2)) {
			view.setBottomTextException("All results must be numbers and non negative", bp);
		} else {
			view.setBottomTextException("", bp);
			String winner = model.checkIf3SetsWinner(view.getScoreInputTxtField1(), view.getScoreInputTxtField2(), view.getScoreInputTxtField3(), view.getScoreInputTxtField6(),
					view.getScoreInputTxtField7(), view.getScoreInputTxtField8());
			if (winner.equals("first wins")) {
				winnerTf.setText(winner1);
				if (thereIsAWinner) {
					view.setWinnerMessage(winnerTf.getText() + " is the champion!", view.getTournamentBorderPane());
				}
				view.getStageTennis().close();
			} else if (winner.equals("second wins")) {
				winnerTf.setText(winner2);
				if (thereIsAWinner) {
					view.setWinnerMessage(winnerTf.getText() + " is the champion!", view.getTournamentBorderPane());
				}
				view.getStageTennis().close();
			} else if (winner.equals("there is no winner")) {
				view.setBottomTextException("there is no winner", bp);
			}
		}

	}

	private void manageSingle5SetsTennisGame(BorderPane bp, String winner1, String winner2, TextField winnerTf,
			boolean thereIsAWinner, boolean threeOrFiveSets, String excep1, String excep2, String[] positiveNumbers) {
		threeOrFiveSets = true;
		for (String str : positiveNumbers) {
			if (str.equals(excep1) || str.equals(excep2)) {
				view.setBottomTextException("All results must be numbers and non negative", bp);
				return;
			}
		}
		view.setBottomTextException("", bp);
		String winner = model.checkIf5SetsWinner(view.getScoreInputTxtField1(), view.getScoreInputTxtField2(), view.getScoreInputTxtField3(), view.getScoreInputTxtField4(),
				view.getScoreInputTxtField5(), view.getScoreInputTxtField6(), view.getScoreInputTxtField7(), view.getScoreInputTxtField8(), view.getScoreInputTxtField9(), view.getScoreInputTxtField10());
		if (winner.equals("first wins")) {
			winnerTf.setText(winner1);
			if (thereIsAWinner) {
				view.setWinnerMessage(winnerTf.getText() + " is the champion!", view.getTournamentBorderPane());
			}
			view.getStageTennis().close();
		} else if (winner.equals("second wins")) {
			winnerTf.setText(winner2);
			if (thereIsAWinner) {
				view.setWinnerMessage(winnerTf.getText() + " is the champion!", view.getTournamentBorderPane());
			}
			view.getStageTennis().close();
		} else if (winner.equals("there is no winner")) {
			view.setBottomTextException("there is no winner", bp);
		}
	}

	private void manageSingleBasketballGame(BorderPane bp, String winner1, String winner2, TextField winnerTf,
			boolean thereIsAWinner, String excep1, String excep2, String[] positiveNumbers) {
		if (positiveNumbers[0].equals(excep1) || positiveNumbers[0].equals(excep2) || positiveNumbers[1].equals(excep1)
				|| positiveNumbers[1].equals(excep2) || positiveNumbers[2].equals(excep1)
				|| positiveNumbers[2].equals(excep2) || positiveNumbers[3].equals(excep1)
				|| positiveNumbers[3].equals(excep2) || positiveNumbers[4].equals(excep1)
				|| positiveNumbers[4].equals(excep2) || positiveNumbers[5].equals(excep1)
				|| positiveNumbers[5].equals(excep2) || positiveNumbers[6].equals(excep1)
				|| positiveNumbers[6].equals(excep2) || positiveNumbers[7].equals(excep1)
				|| positiveNumbers[7].equals(excep2)) {
			view.setBottomTextException("All results must be numbers and non negative", bp);
		} else {
			view.setBottomTextException("", bp);
			String winner = model.checkIfBasketWinner(view.getScoreInputTxtField1(), view.getScoreInputTxtField2(), view.getScoreInputTxtField3(),
					view.getScoreInputTxtField4(), view.getScoreInputTxtField5(), view.getScoreInputTxtField6(), view.getScoreInputTxtField7(), view.getScoreInputTxtField8());
			if (winner.equals("first wins")) {
				winnerTf.setText(winner1);
				if (thereIsAWinner) {
					view.setWinnerMessage(winnerTf.getText() + " is the champion!", view.getTournamentBorderPane());
				}
				view.getStageBasket().close();
			} else if (winner.equals("second wins")) {
				winnerTf.setText(winner2);
				if (thereIsAWinner) {
					view.setWinnerMessage(winnerTf.getText() + " is the champion!", view.getTournamentBorderPane());
				}
				view.getStageBasket().close();
			} else if (winner.equals("there is no winner")) {
				view.setBottomTextException("there is no winner", bp);
			}
		}
	}

	private void manageSingleSoccerGame(BorderPane bp, String winner1, String winner2, TextField winnerTf,
			boolean thereIsAWinner, String excep1, String excep2, String[] positiveNumbers, Stage otStg, Scene otScene,
			BorderPane otBp, GridPane otGp, Button otBut) {
		if (positiveNumbers[0].equals(excep1) || positiveNumbers[0].equals(excep2) || positiveNumbers[1].equals(excep1)
				|| positiveNumbers[1].equals(excep2) || positiveNumbers[2].equals(excep1)
				|| positiveNumbers[2].equals(excep2) || positiveNumbers[3].equals(excep1)
				|| positiveNumbers[3].equals(excep2)) {
			view.setBottomTextException("All results must be numbers and non negative", bp);
		} else {
			view.setBottomTextException("", bp);
			String winner = model.checkIfSoccerWinner(view.getScoreInputTxtField1(), view.getScoreInputTxtField2(), view.getScoreInputTxtField3(),
					view.getScoreInputTxtField4());
			if (winner.equals("first wins")) {
				winnerTf.setText(winner1);
				if (thereIsAWinner) {
					view.setWinnerMessage(winnerTf.getText() + " is the champion!", view.getTournamentBorderPane());
				}
				view.getStageSoccer().close();
			} else if (winner.equals("second wins")) {
				winnerTf.setText(winner2);
				if (thereIsAWinner) {
					view.setWinnerMessage(winnerTf.getText() + " is the champion!", view.getTournamentBorderPane());
				}
				view.getStageSoccer().close();
			} else if (winner.equals("there is no winner")) {
				view.getStageSoccer().close();
				resetOverTimeSoccerTextfields();
				view.startSoccerOverTime(otStg, winner1, winner2, otScene, otBp, otGp, otBut);
			}
		}
	}

	public void mySetOnActionDone() {
		mySetOnActionButtonDone1();
		mySetOnActionButtonDone2();
		mySetOnActionButtonDone3();
		mySetOnActionButtonDone4();
		mySetOnActionButtonDone5();
		mySetOnActionButtonDone6();
		mySetOnActionButtonDone7();
	}

	public void mySetOnActionOvertime() {
		mySetOnActionOvertimeButtonDoneOt1();
		mySetOnActionOvertimeButtonDoneOt2();
		mySetOnActionOvertimeButtonDoneOt3();
		mySetOnActionOvertimeButtonDoneOt4();
		mySetOnActionOvertimeButtonDoneOt5();
		mySetOnActionOvertimeButtonDoneOt6();
		mySetOnActionOvertimeButtonDoneOt7();
	}

	public void resetOverTimeSoccerTextfields() {
		view.getScoreInputOverTimeTxtField1().setText("");
		view.getScoreInputOverTimeTxtField2().setText("");
	}

	public void resetPenaltySoccerTextfields() {
		view.getScoreInputPenaltyTxtField1().setText("");
		view.getScoreInputPenaltyTxtField2().setText("");
		view.getScoreInputPenaltyTxtField3().setText("");
		view.getScoreInputPenaltyTxtField4().setText("");
		view.getScoreInputPenaltyTxtField5().setText("");
		view.getScoreInputPenaltyTxtField6().setText("");
		view.getScoreInputPenaltyTxtField7().setText("");
		view.getScoreInputPenaltyTxtField8().setText("");
		view.getScoreInputPenaltyTxtField9().setText("");
		view.getScoreInputPenaltyTxtField10().setText("");
	}

	public void mySetOnActionPenalty() {
		mySetOnActionPenaltyButtonDoneP1();
		mySetOnActionPenaltyButtonDoneP2();
		mySetOnActionPenaltyButtonDoneP3();
		mySetOnActionPenaltyButtonDoneP4();
		mySetOnActionPenaltyButtonDoneP5();
		mySetOnActionPenaltyButtonDoneP6();
		mySetOnActionPenaltyButtonDoneP7();
	}

	private void setOnActionQuarterFinalButton1() {
		view.getQuarterFinal1Play().setOnAction(event -> {
			resetTextFieldsInTennisGame();
			view.setBottomTextException("", view.getTournamentBorderPane());
			view.getMatchGridPane().getChildren().clear();
			view.getExceptionVBox().getChildren().clear();
			if (getSelectedSportType().equals("selectedTennis"))
				view.startTennisCompetition(new Stage(), view.getParticipant1Name().getText(), view.getParticipant2Name().getText(),
						new Scene(view.getQuarterFinal1BorderPane(), 450, 400), view.getQuarterFinal1BorderPane(), view.getQuarterFinal1GridPane(), view.getQuarterFinal1Done());

			else if (getSelectedSportType().equals("selectedBasketBall"))
				view.startBasketBallCompetition(new Stage(), view.getParticipant1Name().getText(), view.getParticipant2Name().getText(),
						new Scene(view.getQuarterFinal1BorderPane(), 450, 400), view.getQuarterFinal1BorderPane(), view.getQuarterFinal1GridPane(), view.getQuarterFinal1Done());
			else {
				view.startSoccerCompetition(new Stage(), view.getParticipant1Name().getText(), view.getParticipant2Name().getText(),
						new Scene(view.getQuarterFinal1BorderPane(), 450, 400), view.getQuarterFinal1BorderPane(), view.getQuarterFinal1GridPane(), view.getQuarterFinal1Done());
			}
		});
	}

	private void setOnActionQuarterFinalButton2() {
		view.getQuarterFinal2Play().setOnAction(event -> {
			resetTextFieldsInTennisGame();
			view.setBottomTextException("", view.getTournamentBorderPane());
			view.getMatchGridPane().getChildren().clear();
			view.getExceptionVBox().getChildren().clear();
			if (getSelectedSportType().equals("selectedTennis"))
				view.startTennisCompetition(new Stage(), view.getParticipant3Name().getText(), view.participant4Name().getText(),
						new Scene(view.getQuarterFinal2BorderPane(), 450, 400), view.getQuarterFinal2BorderPane(), view.getQuarterFinal2GridPane(), view.getQuarterFinal2Done());
			if (getSelectedSportType().equals("selectedBasketBall"))
				view.startBasketBallCompetition(new Stage(), view.getParticipant3Name().getText(), view.participant4Name().getText(),
						new Scene(view.getQuarterFinal2BorderPane(), 450, 400), view.getQuarterFinal2BorderPane(), view.getQuarterFinal2GridPane(), view.getQuarterFinal2Done());
			if (getSelectedSportType().equals("selectedSoccer"))
				view.startSoccerCompetition(new Stage(), view.getParticipant3Name().getText(), view.participant4Name().getText(),
						new Scene(view.getQuarterFinal2BorderPane(), 450, 400), view.getQuarterFinal2BorderPane(), view.getQuarterFinal2GridPane(), view.getQuarterFinal2Done());

		});

	}

	private void setOnActionQuarterFinalButton3() {
		view.getQuarterFinal3Play().setOnAction(event -> {
			resetTextFieldsInTennisGame();
			view.setBottomTextException("", view.getTournamentBorderPane());
			view.getMatchGridPane().getChildren().clear();
			view.getExceptionVBox().getChildren().clear();
			if (getSelectedSportType().equals("selectedTennis"))
				view.startTennisCompetition(new Stage(), view.getParticipant5Name().getText(), view.getParticipant6Name().getText(),
						new Scene(view.getQuarterFinal3BorderPane(), 450, 400), view.getQuarterFinal3BorderPane(), view.getQuarterFinal3GridPane(), view.getQuarterFinal3Done());
			if (getSelectedSportType().equals("selectedBasketBall"))
				view.startBasketBallCompetition(new Stage(), view.getParticipant5Name().getText(), view.getParticipant6Name().getText(),
						new Scene(view.getQuarterFinal3BorderPane(), 450, 400), view.getQuarterFinal3BorderPane(), view.getQuarterFinal3GridPane(), view.getQuarterFinal3Done());
			if (getSelectedSportType().equals("selectedSoccer"))
				view.startSoccerCompetition(new Stage(), view.getParticipant5Name().getText(), view.getParticipant6Name().getText(),
						new Scene(view.getQuarterFinal3BorderPane(), 450, 400), view.getQuarterFinal3BorderPane(), view.getQuarterFinal3GridPane(), view.getQuarterFinal3Done());
		});

	}

	private void setOnActionQuarterFinalButton4() {
		view.getQuarterFinal4Play().setOnAction(event -> {
			resetTextFieldsInTennisGame();
			view.setBottomTextException("", view.getTournamentBorderPane());
			view.getMatchGridPane().getChildren().clear();
			view.getExceptionVBox().getChildren().clear();
			if (getSelectedSportType().equals("selectedTennis"))
				view.startTennisCompetition(new Stage(), view.getParticipant7Name().getText(), view.getParticipant8Name().getText(),
						new Scene(view.getQuarterFinal4BorderPane(), 450, 400), view.getQuarterFinal4BorderPane(), view.getQuarterFinal4GridPane(), view.getQuarterFinal4Done());
			if (getSelectedSportType().equals("selectedBasketBall"))
				view.startBasketBallCompetition(new Stage(), view.getParticipant7Name().getText(), view.getParticipant8Name().getText(),
						new Scene(view.getQuarterFinal4BorderPane(), 450, 400), view.getQuarterFinal4BorderPane(), view.getQuarterFinal4GridPane(), view.getQuarterFinal4Done());
			if (getSelectedSportType().equals("selectedSoccer"))
				view.startSoccerCompetition(new Stage(), view.getParticipant7Name().getText(), view.getParticipant8Name().getText(),
						new Scene(view.getQuarterFinal4BorderPane(), 450, 400), view.getQuarterFinal4BorderPane(), view.getQuarterFinal4GridPane(), view.getQuarterFinal4Done());
		});

	}

	private void setOnActionSemiFinalButton5() {
		view.getSemiFinal1Play().setOnAction(event -> {
			boolean nameWritten1 = model.checkIfNameIsWritten(view.getQuarterFinal1Winner());
			boolean nameWritten2 = model.checkIfNameIsWritten(view.getQuarterFinal2Winner());
			resetTextFieldsInTennisGame();
			view.setBottomTextException("", view.getTournamentBorderPane());
			view.getMatchGridPane().getChildren().clear();
			view.getExceptionVBox().getChildren().clear();
			if (nameWritten1 == false || nameWritten2 == false)
				view.setBottomTextException("Not all participants in this semi final are known", view.getTournamentBorderPane());
			else {
				if (getSelectedSportType().equals("selectedTennis"))
					view.startTennisCompetition(new Stage(), view.getQuarterFinal1Winner().getText(), view.getQuarterFinal2Winner().getText(),
							new Scene(view.getSemiFinal1BorderPane(), 450, 400), view.getSemiFinal1BorderPane(), view.getSemiFinal1GridPane(), view.getSemiFinal1Done());
				if (getSelectedSportType().equals("selectedBasketBall"))
					view.startBasketBallCompetition(new Stage(), view.getQuarterFinal1Winner().getText(), view.getQuarterFinal2Winner().getText(),
							new Scene(view.getSemiFinal1BorderPane(), 450, 400), view.getSemiFinal1BorderPane(), view.getSemiFinal1GridPane(), view.getSemiFinal1Done());
				if (getSelectedSportType().equals("selectedSoccer"))
					view.startSoccerCompetition(new Stage(), view.getQuarterFinal1Winner().getText(), view.getQuarterFinal2Winner().getText(),
							new Scene(view.getSemiFinal1BorderPane(), 450, 400), view.getSemiFinal1BorderPane(), view.getSemiFinal1GridPane(), view.getSemiFinal1Done());

			}
		});

	}

	private void setOnActionSemiFinalButton6() {
		view.getSemiFinal2Play().setOnAction(event -> {
			boolean nameWritten3 = model.checkIfNameIsWritten(view.getQuarterFinal3Winner());
			boolean nameWritten4 = model.checkIfNameIsWritten(view.getQuarterFinal4Winner());
			resetTextFieldsInTennisGame();
			view.setBottomTextException("", view.getTournamentBorderPane());
			if (nameWritten3 == false || nameWritten4 == false)
				view.setBottomTextException("Not all participants in this semi final are known", view.getTournamentBorderPane());
			else {
				if (getSelectedSportType().equals("selectedTennis"))
					view.startTennisCompetition(new Stage(), view.getQuarterFinal3Winner().getText(), view.getQuarterFinal4Winner().getText(),
							new Scene(view.getSemiFinal2BorderPane(), 450, 400), view.getSemiFinal2BorderPane(), view.getSemiFinal2GridPane(), view.getSemiFinal2Done());
				if (getSelectedSportType().equals("selectedBasketBall"))
					view.startBasketBallCompetition(new Stage(), view.getQuarterFinal3Winner().getText(), view.getQuarterFinal4Winner().getText(),
							new Scene(view.getSemiFinal2BorderPane(), 450, 400), view.getSemiFinal2BorderPane(), view.getSemiFinal2GridPane(), view.getSemiFinal2Done());
				if (getSelectedSportType().equals("selectedSoccer"))
					view.startSoccerCompetition(new Stage(), view.getQuarterFinal3Winner().getText(), view.getQuarterFinal4Winner().getText(),
							new Scene(view.getSemiFinal2BorderPane(), 450, 400), view.getSemiFinal2BorderPane(), view.getSemiFinal2GridPane(), view.getSemiFinal2Done());
			}

		});

	}

	private void mySetOnActionButtonDone1() {
		view.getQuarterFinal1Done().setOnAction(e -> {
			if (getSelectedSportType().equals("selectedTennis")) {
				view.getQuarterFinal1Scene().getRoot().setDisable(true);
				doTournament("selectedTennis", view.getQuarterFinal1BorderPane(), view.getParticipant1Name().getText(), view.getParticipant2Name().getText(),
						view.getQuarterFinal1Winner(), false, view.getStgOt(), view.getQuarterFinal1Scene(), view.getQuarterFinal1OverTimeBorderPane(), view.getQuarterFinal1OverTimeGridPane(),
						view.getQuarterFinal1OverTimeDone());
			} else if (getSelectedSportType().equals("selectedBasketBall")) {
				doTournament("selectedBasketBall", view.getQuarterFinal1BorderPane(), view.getParticipant1Name().getText(), view.getParticipant2Name().getText(),
						view.getQuarterFinal1Winner(), false, view.getStgOt(), view.getQuarterFinal1Scene(), view.getQuarterFinal1OverTimeBorderPane(), view.getQuarterFinal1OverTimeGridPane(),
						view.getQuarterFinal1OverTimeDone());
			} else {
				doTournament("selectedSoccer", view.getQuarterFinal1BorderPane(), view.getParticipant1Name().getText(), view.getParticipant2Name().getText(),
						view.getQuarterFinal1Winner(), false, view.getStgOt(), view.getQuarterFinal1Scene(), view.getQuarterFinal1OverTimeBorderPane(), view.getQuarterFinal1OverTimeGridPane(),
						view.getQuarterFinal1OverTimeDone());
			}

		});
	}

	private void mySetOnActionButtonDone2() {
		view.getQuarterFinal2Done().setOnAction(e -> {
			if (getSelectedSportType().equals("selectedTennis")) {
				view.getQuarterFinal2Scene().getRoot().setDisable(true);
				doTournament("selectedTennis", view.getQuarterFinal2BorderPane(), view.getParticipant3Name().getText(), view.participant4Name().getText(),
						view.getQuarterFinal2Winner(), false, view.getStgOt(), view.getQuarterFinal2Scene(), view.getQuarterFinal2OverTimeBorderPane(), view.getQuarterFinal2OverTimeGridPane(),
						view.getQuarterFinal2OverTimeDone());
			}

			if (getSelectedSportType().equals("selectedBasketBall")) {
				doTournament("selectedBasketBall", view.getQuarterFinal2BorderPane(), view.getParticipant3Name().getText(), view.participant4Name().getText(),
						view.getQuarterFinal2Winner(), false, view.getStgOt(), view.getQuarterFinal2Scene(), view.getQuarterFinal2OverTimeBorderPane(), view.getQuarterFinal2OverTimeGridPane(),
						view.getQuarterFinal2OverTimeDone());
			}
			if (getSelectedSportType().equals("selectedSoccer")) {
				doTournament("selectedSoccer", view.getQuarterFinal2BorderPane(), view.getParticipant3Name().getText(), view.participant4Name().getText(),
						view.getQuarterFinal2Winner(), false, view.getStgOt(), view.getQuarterFinal2Scene(), view.getQuarterFinal2OverTimeBorderPane(), view.getQuarterFinal2OverTimeGridPane(),
						view.getQuarterFinal2OverTimeDone());
			}

		});

	}

	private void mySetOnActionButtonDone3() {
		view.getQuarterFinal3Done().setOnAction(e -> {

			if (getSelectedSportType().equals("selectedTennis")) {
				view.getQuarterFinal3Scene().getRoot().setDisable(true);
				doTournament("selectedTennis", view.getQuarterFinal3BorderPane(), view.getParticipant5Name().getText(), view.getParticipant6Name().getText(),
						view.getQuarterFinal3Winner(), false, view.getStgOt(), view.getQuarterFinal3Scene(), view.getQuarterFinal3OverTimeBorderPane(), view.getQuarterFinal3OverTimeGridPane(),
						view.getQuarterFinal3OverTimeDone());
			}
			if (getSelectedSportType().equals("selectedBasketBall")) {
				doTournament("selectedBasketBall", view.getQuarterFinal3BorderPane(), view.getParticipant5Name().getText(), view.getParticipant6Name().getText(),
						view.getQuarterFinal3Winner(), false, view.getStgOt(), view.getQuarterFinal3Scene(), view.getQuarterFinal3OverTimeBorderPane(), view.getQuarterFinal3OverTimeGridPane(),
						view.getQuarterFinal3OverTimeDone());
			}
			if (getSelectedSportType().equals("selectedSoccer")) {
				doTournament("selectedSoccer", view.getQuarterFinal3BorderPane(), view.getParticipant5Name().getText(), view.getParticipant6Name().getText(),
						view.getQuarterFinal3Winner(), false, view.getStgOt(), view.getQuarterFinal3Scene(), view.getQuarterFinal3OverTimeBorderPane(), view.getQuarterFinal3OverTimeGridPane(),
						view.getQuarterFinal3OverTimeDone());
			}
		});
	}

	private void mySetOnActionButtonDone4() {
		view.getQuarterFinal4Done().setOnAction(e -> {

			if (getSelectedSportType().equals("selectedTennis")) {
				view.getQuarterFinal4Scene().getRoot().setDisable(true);
				doTournament("selectedTennis", view.getQuarterFinal4BorderPane(), view.getParticipant7Name().getText(), view.getParticipant8Name().getText(),
						view.getQuarterFinal4Winner(), false, view.getStgOt(), view.getQuarterFinal4Scene(), view.getQuarterFinal4OverTimeBorderPane(), view.getQuarterFinal4OverTimeGridPane(),
						view.getQuarterFinal4OverTimeDone());
			}
			if (getSelectedSportType().equals("selectedBasketBall")) {
				doTournament("selectedBasketBall", view.getQuarterFinal4BorderPane(), view.getParticipant7Name().getText(), view.getParticipant8Name().getText(),
						view.getQuarterFinal4Winner(), false, view.getStgOt(), view.getQuarterFinal4Scene(), view.getQuarterFinal4OverTimeBorderPane(), view.getQuarterFinal4OverTimeGridPane(),
						view.getQuarterFinal4OverTimeDone());
			}
			if (getSelectedSportType().equals("selectedSoccer")) {
				doTournament("selectedSoccer", view.getQuarterFinal4BorderPane(), view.getParticipant7Name().getText(), view.getParticipant8Name().getText(),
						view.getQuarterFinal4Winner(), false, view.getStgOt(), view.getQuarterFinal4Scene(), view.getQuarterFinal4OverTimeBorderPane(), view.getQuarterFinal4OverTimeGridPane(),
						view.getQuarterFinal4OverTimeDone());
			}
		});

	}

	private void mySetOnActionButtonDone5() {
		view.getSemiFinal1Done().setOnAction(e -> {

			if (getSelectedSportType().equals("selectedTennis")) {
				view.getSemiFinal1Scene().getRoot().setDisable(true);
				doTournament("selectedTennis", view.getSemiFinal1BorderPane(), view.getQuarterFinal1Winner().getText(), view.getQuarterFinal2Winner().getText(),
						view.getSemiFinal1Winner(), false, view.getStgOt(), view.getSemiFinal1Scene(), view.getSemiFinal1OverTimeBorderPane(), view.getSemiFinal1OverTimeGridPane(),
						view.getSemiFinal1OverTimeDone());
			}
			if (getSelectedSportType().equals("selectedBasketBall")) {
				doTournament("selectedBasketBall", view.getSemiFinal1BorderPane(), view.getQuarterFinal1Winner().getText(), view.getQuarterFinal2Winner().getText(),
						view.getSemiFinal1Winner(), false, view.getStgOt(), view.getSemiFinal1Scene(), view.getSemiFinal1OverTimeBorderPane(), view.getSemiFinal1OverTimeGridPane(),
						view.getSemiFinal1OverTimeDone());
			}
			if (getSelectedSportType().equals("selectedSoccer")) {
				doTournament("selectedSoccer", view.getSemiFinal1BorderPane(), view.getQuarterFinal1Winner().getText(), view.getQuarterFinal2Winner().getText(),
						view.getSemiFinal1Winner(), false, view.getStgOt(), view.getSemiFinal1Scene(), view.getSemiFinal1OverTimeBorderPane(), view.getSemiFinal1OverTimeGridPane(),
						view.getSemiFinal1OverTimeDone());
			}
		});
	}

	private void mySetOnActionButtonDone6() {
		view.getSemiFinal2Done().setOnAction(e -> {

			if (getSelectedSportType().equals("selectedTennis")) {
				view.getSemiFinal2Scene().getRoot().setDisable(true);
				doTournament("selectedTennis", view.getSemiFinal2BorderPane(), view.getQuarterFinal3Winner().getText(), view.getQuarterFinal4Winner().getText(),
						view.getSemiFinal2Winner(), false, view.getStgOt(), view.getSemiFinal2Scene(), view.getSemiFinal2OverTimeBorderPane(), view.getSemiFinal2OverTimeGridPane(),
						view.getSemiFinal2OverTimeDone());
			}
			if (getSelectedSportType().equals("selectedBasketBall")) {
				doTournament("selectedBasketBall", view.getSemiFinal2BorderPane(), view.getQuarterFinal3Winner().getText(), view.getQuarterFinal4Winner().getText(),
						view.getSemiFinal2Winner(), false, view.getStgOt(), view.getSemiFinal2Scene(), view.getSemiFinal2OverTimeBorderPane(), view.getSemiFinal2OverTimeGridPane(),
						view.getSemiFinal2OverTimeDone());
			}
			if (getSelectedSportType().equals("selectedSoccer")) {
				doTournament("selectedSoccer", view.getSemiFinal2BorderPane(), view.getQuarterFinal3Winner().getText(), view.getQuarterFinal4Winner().getText(),
						view.getSemiFinal2Winner(), false, view.getStgOt(), view.getSemiFinal2Scene(), view.getSemiFinal2OverTimeBorderPane(), view.getSemiFinal2OverTimeGridPane(),
						view.getSemiFinal2OverTimeDone());
			}
		});
	}

	private void mySetOnActionButtonDone7() {
		view.getFinalDone().setOnAction(e -> {

			if (getSelectedSportType().equals("selectedTennis")) {
				view.getFinalScene().getRoot().setDisable(true);
				doTournament("selectedTennis", view.getFinalBorderPane(), view.getSemiFinal1Winner().getText(), view.getSemiFinal2Winner().getText(),
						view.getFinalWinner(), true, view.getStgOt(), view.getFinalScene(), view.getFinalOverTimeBorderPane(), view.getFinalOverTimeGridPane(),
						view.getFinalOverTimeDone());
			}
			if (getSelectedSportType().equals("selectedBasketBall")) {
				doTournament("selectedBasketBall", view.getFinalBorderPane(), view.getSemiFinal1Winner().getText(), view.getSemiFinal2Winner().getText(),
						view.getFinalWinner(), true, view.getStgOt(), view.getFinalScene(), view.getFinalOverTimeBorderPane(), view.getFinalOverTimeGridPane(),
						view.getFinalOverTimeDone());
			}
			if (getSelectedSportType().equals("selectedSoccer")) {
				doTournament("selectedSoccer", view.getFinalBorderPane(), view.getSemiFinal1Winner().getText(), view.getSemiFinal2Winner().getText(),
						view.getFinalWinner(), true, view.getStgOt(), view.getFinalScene(), view.getFinalOverTimeBorderPane(), view.getFinalOverTimeGridPane(),
						view.getFinalOverTimeDone());
			}

		});
	}

	private void mySetOnActionPenaltyButtonDoneP1() {
		view.getQuarterFinal1PenaltyDone().setOnAction(e -> {
			boolean okTxt1, okTxt2, okTxt3, okTxt4, okTxt5, okTxt6, okTxt7, okTxt8, okTxt9, okTxt10;
			okTxt1 = model.checkIfNotEmptyAndInOut(view.getScoreInputPenaltyTxtField1());
			okTxt2 = model.checkIfNotEmptyAndInOut(view.getScoreInputPenaltyTxtField2());
			okTxt3 = model.checkIfNotEmptyAndInOut(view.getScoreInputPenaltyTxtField3());
			okTxt4 = model.checkIfNotEmptyAndInOut(view.getScoreInputPenaltyTxtField4());
			okTxt5 = model.checkIfNotEmptyAndInOut(view.getScoreInputPenaltyTxtField5());
			okTxt6 = model.checkIfNotEmptyAndInOut(view.getScoreInputPenaltyTxtField6());
			okTxt7 = model.checkIfNotEmptyAndInOut(view.getScoreInputPenaltyTxtField7());
			okTxt8 = model.checkIfNotEmptyAndInOut(view.getScoreInputPenaltyTxtField8());
			okTxt9 = model.checkIfNotEmptyAndInOut(view.getScoreInputPenaltyTxtField9());
			okTxt10 = model.checkIfNotEmptyAndInOut(view.getScoreInputPenaltyTxtField10());

			if (okTxt1 && okTxt2 && okTxt3 && okTxt4 && okTxt5 && okTxt6 && okTxt7 && okTxt8 && okTxt9 && okTxt10) {
				view.setBottomTextException("", view.getQuarterFinal1PenaltyBorderPane());
				String winner = model.checkPenaltyWinner(view.getScoreInputPenaltyTxtField1(), view.getScoreInputPenaltyTxtField2(), view.getScoreInputPenaltyTxtField3(),
						view.getScoreInputPenaltyTxtField4(), view.getScoreInputPenaltyTxtField5(), view.getScoreInputPenaltyTxtField6(), view.getScoreInputPenaltyTxtField7(), view.getScoreInputPenaltyTxtField8(),
						view.getScoreInputPenaltyTxtField9(), view.getScoreInputPenaltyTxtField10());
				if (winner.equals("first wins")) {
					view.getQuarterFinal1Winner().setText(view.getParticipant1Name().getText());
					view.getStgP().close();
				}
				if (winner.equals("second wins")) {
					view.getQuarterFinal1Winner().setText(view.getParticipant2Name().getText());
					view.getStgP().close();
				}
				if (winner.equals("there is no winner")) {
					view.setBottomTextException("there is no winner", view.getQuarterFinal1PenaltyBorderPane());
				}
			} else {
				char ch = '"';
				view.setBottomTextException("Type only " + ch + "In" + ch + " or " + ch + "Out" + ch, view.getQuarterFinal1PenaltyBorderPane());
			}
		});
	}

	private void mySetOnActionPenaltyButtonDoneP2() {
		view.getQuarterFinal2PenaltyDone().setOnAction(e -> {
			boolean okTxt1, okTxt2, okTxt3, okTxt4, okTxt5, okTxt6, okTxt7, okTxt8, okTxt9, okTxt10;
			okTxt1 = model.checkIfNotEmptyAndInOut(view.getScoreInputPenaltyTxtField1());
			okTxt2 = model.checkIfNotEmptyAndInOut(view.getScoreInputPenaltyTxtField2());
			okTxt3 = model.checkIfNotEmptyAndInOut(view.getScoreInputPenaltyTxtField3());
			okTxt4 = model.checkIfNotEmptyAndInOut(view.getScoreInputPenaltyTxtField4());
			okTxt5 = model.checkIfNotEmptyAndInOut(view.getScoreInputPenaltyTxtField5());
			okTxt6 = model.checkIfNotEmptyAndInOut(view.getScoreInputPenaltyTxtField6());
			okTxt7 = model.checkIfNotEmptyAndInOut(view.getScoreInputPenaltyTxtField7());
			okTxt8 = model.checkIfNotEmptyAndInOut(view.getScoreInputPenaltyTxtField8());
			okTxt9 = model.checkIfNotEmptyAndInOut(view.getScoreInputPenaltyTxtField9());
			okTxt10 = model.checkIfNotEmptyAndInOut(view.getScoreInputPenaltyTxtField10());
			if (okTxt1 && okTxt2 && okTxt3 && okTxt4 && okTxt5 && okTxt6 && okTxt7 && okTxt8 && okTxt9 && okTxt10) {
				view.setBottomTextException("", view.getQuarterFinal2PenaltyBorderPane());
				String winner = model.checkPenaltyWinner(view.getScoreInputPenaltyTxtField1(), view.getScoreInputPenaltyTxtField2(), view.getScoreInputPenaltyTxtField3(),
						view.getScoreInputPenaltyTxtField4(), view.getScoreInputPenaltyTxtField5(), view.getScoreInputPenaltyTxtField6(), view.getScoreInputPenaltyTxtField7(), view.getScoreInputPenaltyTxtField8(),
						view.getScoreInputPenaltyTxtField9(), view.getScoreInputPenaltyTxtField10());
				if (winner.equals("first wins")) {
					view.getQuarterFinal2Winner().setText(view.getParticipant3Name().getText());
					view.getStgP().close();
				}
				if (winner.equals("second wins")) {
					view.getQuarterFinal2Winner().setText(view.participant4Name().getText());
					view.getStgP().close();
				}
				if (winner.equals("there is no winner")) {
					view.setBottomTextException("there is no winner", view.getQuarterFinal2PenaltyBorderPane());
				}
			} else {
				char ch = '"';
				view.setBottomTextException("Type only " + ch + "In" + ch + " or " + ch + "Out" + ch, view.getQuarterFinal2PenaltyBorderPane());
			}
		});
	}

	private void mySetOnActionPenaltyButtonDoneP3() {
		view.getQuarterFinal3PenaltyDone().setOnAction(e -> {
			boolean okTxt1, okTxt2, okTxt3, okTxt4, okTxt5, okTxt6, okTxt7, okTxt8, okTxt9, okTxt10;
			okTxt1 = model.checkIfNotEmptyAndInOut(view.getScoreInputPenaltyTxtField1());
			okTxt2 = model.checkIfNotEmptyAndInOut(view.getScoreInputPenaltyTxtField2());
			okTxt3 = model.checkIfNotEmptyAndInOut(view.getScoreInputPenaltyTxtField3());
			okTxt4 = model.checkIfNotEmptyAndInOut(view.getScoreInputPenaltyTxtField4());
			okTxt5 = model.checkIfNotEmptyAndInOut(view.getScoreInputPenaltyTxtField5());
			okTxt6 = model.checkIfNotEmptyAndInOut(view.getScoreInputPenaltyTxtField6());
			okTxt7 = model.checkIfNotEmptyAndInOut(view.getScoreInputPenaltyTxtField7());
			okTxt8 = model.checkIfNotEmptyAndInOut(view.getScoreInputPenaltyTxtField8());
			okTxt9 = model.checkIfNotEmptyAndInOut(view.getScoreInputPenaltyTxtField9());
			okTxt10 = model.checkIfNotEmptyAndInOut(view.getScoreInputPenaltyTxtField10());

			if (okTxt1 && okTxt2 && okTxt3 && okTxt4 && okTxt5 && okTxt6 && okTxt7 && okTxt8 && okTxt9 && okTxt10) {
				view.setBottomTextException("", view.getQuarterFinal3PenaltyBorderPane3());
				String winner = model.checkPenaltyWinner(view.getScoreInputPenaltyTxtField1(), view.getScoreInputPenaltyTxtField2(), view.getScoreInputPenaltyTxtField3(),
						view.getScoreInputPenaltyTxtField4(), view.getScoreInputPenaltyTxtField5(), view.getScoreInputPenaltyTxtField6(), view.getScoreInputPenaltyTxtField7(), view.getScoreInputPenaltyTxtField8(),
						view.getScoreInputPenaltyTxtField9(), view.getScoreInputPenaltyTxtField10());
				if (winner.equals("first wins")) {
					view.getQuarterFinal3Winner().setText(view.getParticipant5Name().getText());
					view.getStgP().close();
				}
				if (winner.equals("second wins")) {
					view.getQuarterFinal3Winner().setText(view.getParticipant6Name().getText());
					view.getStgP().close();
				}
				if (winner.equals("there is no winner")) {
					view.setBottomTextException("there is no winner", view.getQuarterFinal3PenaltyBorderPane3());
				}
			} else {
				char ch = '"';
				view.setBottomTextException("Type only " + ch + "In" + ch + " or " + ch + "Out" + ch, view.getQuarterFinal3PenaltyBorderPane3());
			}
		});
	}

	private void mySetOnActionPenaltyButtonDoneP4() {
		view.getQuarterFinal4PenaltyDone().setOnAction(e -> {
			boolean okTxt1, okTxt2, okTxt3, okTxt4, okTxt5, okTxt6, okTxt7, okTxt8, okTxt9, okTxt10;
			okTxt1 = model.checkIfNotEmptyAndInOut(view.getScoreInputPenaltyTxtField1());
			okTxt2 = model.checkIfNotEmptyAndInOut(view.getScoreInputPenaltyTxtField2());
			okTxt3 = model.checkIfNotEmptyAndInOut(view.getScoreInputPenaltyTxtField3());
			okTxt4 = model.checkIfNotEmptyAndInOut(view.getScoreInputPenaltyTxtField4());
			okTxt5 = model.checkIfNotEmptyAndInOut(view.getScoreInputPenaltyTxtField5());
			okTxt6 = model.checkIfNotEmptyAndInOut(view.getScoreInputPenaltyTxtField6());
			okTxt7 = model.checkIfNotEmptyAndInOut(view.getScoreInputPenaltyTxtField7());
			okTxt8 = model.checkIfNotEmptyAndInOut(view.getScoreInputPenaltyTxtField8());
			okTxt9 = model.checkIfNotEmptyAndInOut(view.getScoreInputPenaltyTxtField9());
			okTxt10 = model.checkIfNotEmptyAndInOut(view.getScoreInputPenaltyTxtField10());

			if (okTxt1 && okTxt2 && okTxt3 && okTxt4 && okTxt5 && okTxt6 && okTxt7 && okTxt8 && okTxt9 && okTxt10) {
				view.setBottomTextException("", view.getQuarterFinal4PenaltyBorderPane());
				String winner = model.checkPenaltyWinner(view.getScoreInputPenaltyTxtField1(), view.getScoreInputPenaltyTxtField2(), view.getScoreInputPenaltyTxtField3(),
						view.getScoreInputPenaltyTxtField4(), view.getScoreInputPenaltyTxtField5(), view.getScoreInputPenaltyTxtField6(), view.getScoreInputPenaltyTxtField7(), view.getScoreInputPenaltyTxtField8(),
						view.getScoreInputPenaltyTxtField9(), view.getScoreInputPenaltyTxtField10());
				if (winner.equals("first wins")) {
					view.getQuarterFinal4Winner().setText(view.getParticipant7Name().getText());
					view.getStgP().close();
				}
				if (winner.equals("second wins")) {
					view.getQuarterFinal4Winner().setText(view.getParticipant8Name().getText());
					view.getStgP().close();
				}
				if (winner.equals("there is no winner")) {
					view.setBottomTextException("there is no winner", view.getQuarterFinal4PenaltyBorderPane());
				}
			} else {
				char ch = '"';
				view.setBottomTextException("Type only " + ch + "In" + ch + " or " + ch + "Out" + ch, view.getQuarterFinal4PenaltyBorderPane());
			}
		});
	}

	private void mySetOnActionPenaltyButtonDoneP5() {
		view.getSemiFinal1PenaltyDone().setOnAction(e -> {
			boolean okTxt1, okTxt2, okTxt3, okTxt4, okTxt5, okTxt6, okTxt7, okTxt8, okTxt9, okTxt10;
			okTxt1 = model.checkIfNotEmptyAndInOut(view.getScoreInputPenaltyTxtField1());
			okTxt2 = model.checkIfNotEmptyAndInOut(view.getScoreInputPenaltyTxtField2());
			okTxt3 = model.checkIfNotEmptyAndInOut(view.getScoreInputPenaltyTxtField3());
			okTxt4 = model.checkIfNotEmptyAndInOut(view.getScoreInputPenaltyTxtField4());
			okTxt5 = model.checkIfNotEmptyAndInOut(view.getScoreInputPenaltyTxtField5());
			okTxt6 = model.checkIfNotEmptyAndInOut(view.getScoreInputPenaltyTxtField6());
			okTxt7 = model.checkIfNotEmptyAndInOut(view.getScoreInputPenaltyTxtField7());
			okTxt8 = model.checkIfNotEmptyAndInOut(view.getScoreInputPenaltyTxtField8());
			okTxt9 = model.checkIfNotEmptyAndInOut(view.getScoreInputPenaltyTxtField9());
			okTxt10 = model.checkIfNotEmptyAndInOut(view.getScoreInputPenaltyTxtField10());

			if (okTxt1 && okTxt2 && okTxt3 && okTxt4 && okTxt5 && okTxt6 && okTxt7 && okTxt8 && okTxt9 && okTxt10) {
				view.setBottomTextException("", view.getSemiFinal1PenaltyBorderPane());
				String winner = model.checkPenaltyWinner(view.getScoreInputPenaltyTxtField1(), view.getScoreInputPenaltyTxtField2(), view.getScoreInputPenaltyTxtField3(),
						view.getScoreInputPenaltyTxtField4(), view.getScoreInputPenaltyTxtField5(), view.getScoreInputPenaltyTxtField6(), view.getScoreInputPenaltyTxtField7(), view.getScoreInputPenaltyTxtField8(),
						view.getScoreInputPenaltyTxtField9(), view.getScoreInputPenaltyTxtField10());
				if (winner.equals("first wins")) {
					view.getSemiFinal1Winner().setText(view.getQuarterFinal1Winner().getText());
					view.getStgP().close();
				}
				if (winner.equals("second wins")) {
					view.getSemiFinal1Winner().setText(view.getQuarterFinal2Winner().getText());
					view.getStgP().close();
				}
				if (winner.equals("there is no winner")) {
					view.setBottomTextException("there is no winner", view.getSemiFinal1PenaltyBorderPane());
				}
			} else {
				char ch = '"';
				view.setBottomTextException("Type only " + ch + "In" + ch + " or " + ch + "Out" + ch, view.getSemiFinal1PenaltyBorderPane());
			}
		});
	}

	private void mySetOnActionPenaltyButtonDoneP6() {
		view.getSemiFinal2PenaltyDone().setOnAction(e -> {
			boolean okTxt1, okTxt2, okTxt3, okTxt4, okTxt5, okTxt6, okTxt7, okTxt8, okTxt9, okTxt10;
			okTxt1 = model.checkIfNotEmptyAndInOut(view.getScoreInputPenaltyTxtField1());
			okTxt2 = model.checkIfNotEmptyAndInOut(view.getScoreInputPenaltyTxtField2());
			okTxt3 = model.checkIfNotEmptyAndInOut(view.getScoreInputPenaltyTxtField3());
			okTxt4 = model.checkIfNotEmptyAndInOut(view.getScoreInputPenaltyTxtField4());
			okTxt5 = model.checkIfNotEmptyAndInOut(view.getScoreInputPenaltyTxtField5());
			okTxt6 = model.checkIfNotEmptyAndInOut(view.getScoreInputPenaltyTxtField6());
			okTxt7 = model.checkIfNotEmptyAndInOut(view.getScoreInputPenaltyTxtField7());
			okTxt8 = model.checkIfNotEmptyAndInOut(view.getScoreInputPenaltyTxtField8());
			okTxt9 = model.checkIfNotEmptyAndInOut(view.getScoreInputPenaltyTxtField9());
			okTxt10 = model.checkIfNotEmptyAndInOut(view.getScoreInputPenaltyTxtField10());

			if (okTxt1 && okTxt2 && okTxt3 && okTxt4 && okTxt5 && okTxt6 && okTxt7 && okTxt8 && okTxt9 && okTxt10) {
				view.setBottomTextException("", view.getSemiFinal2PenaltyBorderPane());
				String winner = model.checkPenaltyWinner(view.getScoreInputPenaltyTxtField1(), view.getScoreInputPenaltyTxtField2(), view.getScoreInputPenaltyTxtField3(),
						view.getScoreInputPenaltyTxtField4(), view.getScoreInputPenaltyTxtField5(), view.getScoreInputPenaltyTxtField6(), view.getScoreInputPenaltyTxtField7(), view.getScoreInputPenaltyTxtField8(),
						view.getScoreInputPenaltyTxtField9(), view.getScoreInputPenaltyTxtField10());
				if (winner.equals("first wins")) {
					view.getSemiFinal2Winner().setText(view.getQuarterFinal3Winner().getText());
					view.getStgP().close();
				}
				if (winner.equals("second wins")) {
					view.getSemiFinal2Winner().setText(view.getQuarterFinal4Winner().getText());
					view.getStgP().close();
				}
				if (winner.equals("there is no winner")) {
					view.setBottomTextException("there is no winner", view.getSemiFinal2PenaltyBorderPane());
				}
			} else {
				char ch = '"';
				view.setBottomTextException("Type only " + ch + "In" + ch + " or " + ch + "Out" + ch, view.getSemiFinal2PenaltyBorderPane());
			}
		});
	}

	private void mySetOnActionPenaltyButtonDoneP7() {
		view.getFinalPenaltyDone().setOnAction(e -> {
			boolean okTxt1, okTxt2, okTxt3, okTxt4, okTxt5, okTxt6, okTxt7, okTxt8, okTxt9, okTxt10;
			okTxt1 = model.checkIfNotEmptyAndInOut(view.getScoreInputPenaltyTxtField1());
			okTxt2 = model.checkIfNotEmptyAndInOut(view.getScoreInputPenaltyTxtField2());
			okTxt3 = model.checkIfNotEmptyAndInOut(view.getScoreInputPenaltyTxtField3());
			okTxt4 = model.checkIfNotEmptyAndInOut(view.getScoreInputPenaltyTxtField4());
			okTxt5 = model.checkIfNotEmptyAndInOut(view.getScoreInputPenaltyTxtField5());
			okTxt6 = model.checkIfNotEmptyAndInOut(view.getScoreInputPenaltyTxtField6());
			okTxt7 = model.checkIfNotEmptyAndInOut(view.getScoreInputPenaltyTxtField7());
			okTxt8 = model.checkIfNotEmptyAndInOut(view.getScoreInputPenaltyTxtField8());
			okTxt9 = model.checkIfNotEmptyAndInOut(view.getScoreInputPenaltyTxtField9());
			okTxt10 = model.checkIfNotEmptyAndInOut(view.getScoreInputPenaltyTxtField10());

			if (okTxt1 && okTxt2 && okTxt3 && okTxt4 && okTxt5 && okTxt6 && okTxt7 && okTxt8 && okTxt9 && okTxt10) {
				view.setBottomTextException("", view.getFinalPenaltyBorderPane());
				String winner = model.checkPenaltyWinner(view.getScoreInputPenaltyTxtField1(), view.getScoreInputPenaltyTxtField2(), view.getScoreInputPenaltyTxtField3(),
						view.getScoreInputPenaltyTxtField4(), view.getScoreInputPenaltyTxtField5(), view.getScoreInputPenaltyTxtField6(), view.getScoreInputPenaltyTxtField7(), view.getScoreInputPenaltyTxtField8(),
						view.getScoreInputPenaltyTxtField9(), view.getScoreInputPenaltyTxtField10());
				if (winner.equals("first wins")) {
					view.getFinalWinner().setText(view.getSemiFinal1Winner().getText());
					view.getStgP().close();
					view.setWinnerMessage(view.getFinalWinner().getText() + " is the champion!", view.getTournamentBorderPane());
				}
				if (winner.equals("second wins")) {
					view.getFinalWinner().setText(view.getSemiFinal2Winner().getText());
					view.getStgP().close();
					view.setWinnerMessage(view.getFinalWinner().getText() + " is the champion!", view.getTournamentBorderPane());
				}
				if (winner.equals("there is no winner")) {
					view.setBottomTextException("there is no winner", view.getFinalPenaltyBorderPane());
				}
			} else {
				char ch = '"';
				view.setBottomTextException("Type only " + ch + "In" + ch + " or " + ch + "Out" + ch, view.getFinalPenaltyBorderPane());
			}
		});
	}

	private void mySetOnActionOvertimeButtonDoneOt1() {
		view.getQuarterFinal1OverTimeDone().setOnAction(e -> {
			boolean okTxt1, okTxt2;
			okTxt1 = model.checkIfNotEmpty(view.getScoreInputOverTimeTxtField1());
			okTxt2 = model.checkIfNotEmpty(view.getScoreInputOverTimeTxtField2());
			String str1 = model.checkIfNumbers(view.getScoreInputOverTimeTxtField1());
			String str2 = model.checkIfNumbers(view.getScoreInputOverTimeTxtField2());
			if (okTxt1 && okTxt2) {
				if (str1.equals("All results must be numbers") || str2.equals("All results must be numbers")) {
					view.setBottomTextException("All results must be numbers", view.getQuarterFinal1OverTimeBorderPane());
				} else {
					view.setBottomTextException("", view.getQuarterFinal1OverTimeBorderPane());
					String winner = model.checkIfOvertimeWinner(view.getScoreInputOverTimeTxtField1(), view.getScoreInputOverTimeTxtField2());
					if (winner.equals("first wins")) {
						view.getQuarterFinal1Winner().setText(view.getParticipant1Name().getText());
						view.getStgOt().close();
					}
					if (winner.equals("second wins")) {
						view.getQuarterFinal1Winner().setText(view.getParticipant2Name().getText());
						view.getStgOt().close();
					}
					if (winner.equals("there is no winner")) {
						view.getStgOt().close();
						resetPenaltySoccerTextfields();
						view.startSoccerPenaltyShootoutSoocer(view.getStgP(), view.getParticipant1Name().getText(),
								view.getParticipant2Name().getText(), new Scene(view.getQuarterFinal1PenaltyBorderPane(), 470, 450), view.getQuarterFinal1PenaltyBorderPane(),
								view.getQuarterFinal1PenaltyGridPane(), view.getQuarterFinal1PenaltyDone());
					}
				}
			} else {

				view.setBottomTextException("Enter result of overtime", view.getQuarterFinal1OverTimeBorderPane());
			}
		});
	}

	private void mySetOnActionOvertimeButtonDoneOt2() {
		view.getQuarterFinal2OverTimeDone().setOnAction(e -> {
			boolean okTxt1, okTxt2;
			okTxt1 = model.checkIfNotEmpty(view.getScoreInputOverTimeTxtField1());
			okTxt2 = model.checkIfNotEmpty(view.getScoreInputOverTimeTxtField2());
			String str1 = model.checkIfNumbers(view.getScoreInputOverTimeTxtField1());
			String str2 = model.checkIfNumbers(view.getScoreInputOverTimeTxtField2());
			if (okTxt1 && okTxt2) {
				if (str1.equals("All results must be numbers") || str2.equals("All results must be numbers")) {
					view.setBottomTextException("All results must be numbers", view.getQuarterFinal2OverTimeBorderPane());
				} else {
					view.setBottomTextException("", view.getQuarterFinal2OverTimeBorderPane());
					String winner = model.checkIfOvertimeWinner(view.getScoreInputOverTimeTxtField1(), view.getScoreInputOverTimeTxtField2());
					if (winner.equals("first wins")) {
						view.getQuarterFinal2Winner().setText(view.getParticipant3Name().getText());
						view.getStgOt().close();
					}
					if (winner.equals("second wins")) {
						view.getQuarterFinal2Winner().setText(view.participant4Name().getText());
						view.getStgOt().close();
					}
					if (winner.equals("there is no winner")) {
						view.getStgOt().close();
						resetPenaltySoccerTextfields();
						view.startSoccerPenaltyShootoutSoocer(view.getStgP(), view.getParticipant3Name().getText(),
								view.participant4Name().getText(), new Scene(view.getQuarterFinal2PenaltyBorderPane(), 470, 450), view.getQuarterFinal2PenaltyBorderPane(),
								view.getQuarterFinal2PenaltyGridPane(), view.getQuarterFinal2PenaltyDone());
					}
				}
			} else
				view.setBottomTextException("Enter result of overtime", view.getQuarterFinal2OverTimeBorderPane());

		});
	}

	private void mySetOnActionOvertimeButtonDoneOt3() {
		view.getQuarterFinal3OverTimeDone().setOnAction(e -> {
			boolean okTxt1, okTxt2;
			okTxt1 = model.checkIfNotEmpty(view.getScoreInputOverTimeTxtField1());
			okTxt2 = model.checkIfNotEmpty(view.getScoreInputOverTimeTxtField2());
			String str1 = model.checkIfNumbers(view.getScoreInputOverTimeTxtField1());
			String str2 = model.checkIfNumbers(view.getScoreInputOverTimeTxtField2());
			if (okTxt1 && okTxt2) {
				if (str1.equals("All results must be numbers") || str2.equals("All results must be numbers")) {
					view.setBottomTextException("All results must be numbers", view.getQuarterFinal3OverTimeBorderPane());
				} else {
					view.setBottomTextException("", view.getQuarterFinal3OverTimeBorderPane());
					String winner = model.checkIfOvertimeWinner(view.getScoreInputOverTimeTxtField1(), view.getScoreInputOverTimeTxtField2());
					if (winner.equals("first wins")) {
						view.getQuarterFinal3Winner().setText(view.getParticipant5Name().getText());
						view.getStgOt().close();
					}
					if (winner.equals("second wins")) {
						view.getQuarterFinal3Winner().setText(view.getParticipant6Name().getText());
						view.getStgOt().close();
					}
					if (winner.equals("there is no winner")) {
						view.getStgOt().close();
						resetPenaltySoccerTextfields();
						view.startSoccerPenaltyShootoutSoocer(view.getStgP(), view.getParticipant5Name().getText(),
								view.getParticipant6Name().getText(), new Scene(view.getQuarterFinal3PenaltyBorderPane3(), 470, 450), view.getQuarterFinal3PenaltyBorderPane3(),
								view.getQuarterFinal3PenaltyGridPane(), view.getQuarterFinal3PenaltyDone());
					}
				}
			} else
				view.setBottomTextException("Enter result of overtime", view.getQuarterFinal3OverTimeBorderPane());
		});
	}

	private void mySetOnActionOvertimeButtonDoneOt4() {
		view.getQuarterFinal4OverTimeDone().setOnAction(e -> {
			boolean okTxt1, okTxt2;
			okTxt1 = model.checkIfNotEmpty(view.getScoreInputOverTimeTxtField1());
			okTxt2 = model.checkIfNotEmpty(view.getScoreInputOverTimeTxtField2());
			String str1 = model.checkIfNumbers(view.getScoreInputOverTimeTxtField1());
			String str2 = model.checkIfNumbers(view.getScoreInputOverTimeTxtField2());
			if (okTxt1 && okTxt2) {
				if (str1.equals("All results must be numbers") || str2.equals("All results must be numbers")) {
					view.setBottomTextException("All results must be numbers", view.getQuarterFinal4OverTimeBorderPane());
				} else {
					view.setBottomTextException("", view.getQuarterFinal4OverTimeBorderPane());
					String winner = model.checkIfOvertimeWinner(view.getScoreInputOverTimeTxtField1(), view.getScoreInputOverTimeTxtField2());
					if (winner.equals("first wins")) {
						view.getQuarterFinal4Winner().setText(view.getParticipant7Name().getText());
						view.getStgOt().close();
					}
					if (winner.equals("second wins")) {
						view.getQuarterFinal4Winner().setText(view.getParticipant8Name().getText());
						view.getStgOt().close();
					}
					if (winner.equals("there is no winner")) {
						view.getStgOt().close();
						resetPenaltySoccerTextfields();
						view.startSoccerPenaltyShootoutSoocer(view.getStgP(), view.getParticipant7Name().getText(),
								view.getParticipant8Name().getText(), new Scene(view.getQuarterFinal4PenaltyBorderPane(), 470, 450), view.getQuarterFinal4PenaltyBorderPane(),
								view.getQuarterFinal4PenaltyGridPane(), view.getQuarterFinal4PenaltyDone());
					}
				}
			} else
				view.setBottomTextException("Enter result of overtime", view.getQuarterFinal4OverTimeBorderPane());
		});
	}

	private void mySetOnActionOvertimeButtonDoneOt5() {
		view.getSemiFinal1OverTimeDone().setOnAction(e -> {
			boolean okTxt1, okTxt2;
			okTxt1 = model.checkIfNotEmpty(view.getScoreInputOverTimeTxtField1());
			okTxt2 = model.checkIfNotEmpty(view.getScoreInputOverTimeTxtField2());
			String str1 = model.checkIfNumbers(view.getScoreInputOverTimeTxtField1());
			String str2 = model.checkIfNumbers(view.getScoreInputOverTimeTxtField2());
			if (okTxt1 && okTxt2) {
				if (str1.equals("All results must be numbers") || str2.equals("All results must be numbers")) {
					view.setBottomTextException("All results must be numbers", view.getSemiFinal1OverTimeBorderPane());
				} else {
					view.setBottomTextException("", view.getSemiFinal1OverTimeBorderPane());
					String winner = model.checkIfOvertimeWinner(view.getScoreInputOverTimeTxtField1(), view.getScoreInputOverTimeTxtField2());
					if (winner.equals("first wins")) {
						view.getSemiFinal1Winner().setText(view.getQuarterFinal1Winner().getText());
						view.getStgOt().close();
					}
					if (winner.equals("second wins")) {
						view.getSemiFinal1Winner().setText(view.getQuarterFinal2Winner().getText());
						view.getStgOt().close();
					}
					if (winner.equals("there is no winner")) {
						view.getStgOt().close();
						resetPenaltySoccerTextfields();
						view.startSoccerPenaltyShootoutSoocer(view.getStgP(), view.getQuarterFinal1Winner().getText(),
								view.getQuarterFinal2Winner().getText(), new Scene(view.getSemiFinal1PenaltyBorderPane(), 470, 450), view.getSemiFinal1PenaltyBorderPane(),
								view.getSemiFinal1PenaltyGridPane(), view.getSemiFinal1PenaltyDone());
					}
				}
			} else
				view.setBottomTextException("Enter result of overtime", view.getSemiFinal1OverTimeBorderPane());
		});
	}

	private void mySetOnActionOvertimeButtonDoneOt6() {
		view.getSemiFinal2OverTimeDone().setOnAction(e -> {
			boolean okTxt1, okTxt2;
			okTxt1 = model.checkIfNotEmpty(view.getScoreInputOverTimeTxtField1());
			okTxt2 = model.checkIfNotEmpty(view.getScoreInputOverTimeTxtField2());
			String str1 = model.checkIfNumbers(view.getScoreInputOverTimeTxtField1());
			String str2 = model.checkIfNumbers(view.getScoreInputOverTimeTxtField2());
			if (okTxt1 && okTxt2) {
				if (str1.equals("All results must be numbers") || str2.equals("All results must be numbers")) {
					view.setBottomTextException("All results must be numbers", view.getSemiFinal2OverTimeBorderPane());
				} else {
					view.setBottomTextException("", view.getSemiFinal2OverTimeBorderPane());
					String winner = model.checkIfOvertimeWinner(view.getScoreInputOverTimeTxtField1(), view.getScoreInputOverTimeTxtField2());
					if (winner.equals("first wins")) {
						view.getSemiFinal2Winner().setText(view.getQuarterFinal3Winner().getText());
						view.getStgOt().close();
					}
					if (winner.equals("second wins")) {
						view.getSemiFinal2Winner().setText(view.getQuarterFinal4Winner().getText());
						view.getStgOt().close();
					}
					if (winner.equals("there is no winner")) {
						view.getStgOt().close();
						resetPenaltySoccerTextfields();
						view.startSoccerPenaltyShootoutSoocer(view.getStgP(), view.getQuarterFinal3Winner().getText(),
								view.getQuarterFinal4Winner().getText(), new Scene(view.getSemiFinal2PenaltyBorderPane(), 470, 450), view.getSemiFinal2PenaltyBorderPane(),
								view.getSemiFinal2PenaltyGridPane(), view.getSemiFinal2PenaltyDone());
					}
				}
			} else
				view.setBottomTextException("Enter result of overtime", view.getSemiFinal2OverTimeBorderPane());
		});
	}

	private void mySetOnActionOvertimeButtonDoneOt7() {
		view.getFinalOverTimeDone().setOnAction(e -> {
			boolean okTxt1, okTxt2;
			okTxt1 = model.checkIfNotEmpty(view.getScoreInputOverTimeTxtField1());
			okTxt2 = model.checkIfNotEmpty(view.getScoreInputOverTimeTxtField2());
			String str1 = model.checkIfNumbers(view.getScoreInputOverTimeTxtField1());
			String str2 = model.checkIfNumbers(view.getScoreInputOverTimeTxtField2());
			if (okTxt1 && okTxt2) {
				if (str1.equals("All results must be numbers") || str2.equals("All results must be numbers")) {
					view.setBottomTextException("All results must be numbers", view.getFinalOverTimeBorderPane());
				} else {
					view.setBottomTextException("", view.getFinalOverTimeBorderPane());
					String winner = model.checkIfOvertimeWinner(view.getScoreInputOverTimeTxtField1(), view.getScoreInputOverTimeTxtField2());
					if (winner.equals("first wins")) {
						view.getFinalWinner().setText(view.getSemiFinal1Winner().getText());
						view.getStgOt().close();
						view.setWinnerMessage(view.getFinalWinner().getText() + " is the champion!", view.getTournamentBorderPane());
					}
					if (winner.equals("second wins")) {
						view.getFinalWinner().setText(view.getSemiFinal2Winner().getText());
						view.getStgOt().close();
						view.setWinnerMessage(view.getFinalWinner().getText() + " is the champion!", view.getTournamentBorderPane());
					}
					if (winner.equals("there is no winner")) {
						view.getStgOt().close();
						resetPenaltySoccerTextfields();
						view.startSoccerPenaltyShootoutSoocer(view.getStgP(), view.getSemiFinal1Winner().getText(),
								view.getSemiFinal2Winner().getText(), new Scene(view.getFinalPenaltyBorderPane(), 470, 450), view.getFinalPenaltyBorderPane(),
								view.getFinalPenaltyGridPane(), view.getFinalPenaltyDone());
					}

				}
			} else
				view.setBottomTextException("Enter result of overtime", view.getFinalOverTimeBorderPane());

		});
	}

}
