import javafx.animation.FadeTransition;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.effect.DropShadow;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.util.Duration;

public class View {

	private BorderPane primaryBorderPane = new BorderPane();
	private BorderPane tournamentBorderPane = new BorderPane();
	private BorderPane quarterFinal1BorderPane = new BorderPane();
	private BorderPane quarterFinal2BorderPane = new BorderPane();
	private BorderPane quarterFinal3BorderPane = new BorderPane();
	private BorderPane quarterFinal4BorderPane = new BorderPane();
	private BorderPane semiFinal1BorderPane = new BorderPane();
	private BorderPane semiFinal2BorderPane = new BorderPane();
	private BorderPane finalBorderPane = new BorderPane();
	private BorderPane quarterFinal1OverTimeBorderPane = new BorderPane();
	private BorderPane quarterFinal2OverTimeBorderPane = new BorderPane();
	private BorderPane quarterFinal3OverTimeBorderPane = new BorderPane();
	private BorderPane quarterFinal4OverTimeBorderPane = new BorderPane();
	private BorderPane semiFinal1OverTimeBorderPane = new BorderPane();
	private BorderPane semiFinal2OverTimeBorderPane = new BorderPane();
	private BorderPane finalOverTimeBorderPane = new BorderPane();
	private BorderPane quarterFinal1PenaltyBorderPane = new BorderPane();
	private BorderPane quarterFinal2PenaltyBorderPane = new BorderPane();
	private BorderPane quarterFinal3PenaltyBorderPane = new BorderPane();
	private BorderPane quarterFinal4PenaltyBorderPane = new BorderPane();
	private BorderPane semiFinal1PenaltyBorderPane = new BorderPane();
	private BorderPane semiFinal2PenaltyBorderPane = new BorderPane();
	private BorderPane finalPenaltyBorderPane = new BorderPane();
	public Button quarterFinal1OverTimeDone = new Button("Done");
	public Button quarterFinal2OverTimeDone = new Button("Done");
	public Button quarterFinal3OverTimeDone = new Button("Done");
	public Button quarterFinal4OverTimeDone = new Button("Done");
	public Button semiFinal1OverTimeDone = new Button("Done");
	public Button semiFinal2OverTimeDone = new Button("Done");
	public Button finalOverTimeDone = new Button("Done");
	private Button quarterFinal1Play = new Button("Play a game");
	private Button quarterFinal2Play = new Button("Play a game");
	private Button quarterFinal3Play = new Button("Play a game");
	private Button quarterFinal4Play = new Button("Play a game");
	private Button semiFinal1Play = new Button("Play a game");
	private Button semiFinal2Play = new Button("Play a game");
	private Button finalPlay = new Button("Play a game");
	private Button quarterFinal1Done = new Button("Done");
	private Button quarterFinal2Done = new Button("Done");
	private Button quarterFinal3Done = new Button("Done");
	private Button quarterFinal4Done = new Button("Done");
	private Button semiFinal1Done = new Button("Done");
	private Button semiFinal2Done = new Button("Done");
	private Button finalDone = new Button("Done");
	private Button quarterFinal1PenaltyDone = new Button("Done");
	private Button quarterFinal2PenaltyDone = new Button("Done");
	private Button quarterFinal3PenaltyDone = new Button("Done");
	private Button quarterFinal4PenaltyDone = new Button("Done");
	private Button semiFinal1PenaltyDone = new Button("Done");
	private Button semiFinal2PenaltyDone = new Button("Done");
	private Button finalPenaltyDone = new Button("Done");
	private Button addParticipant = new Button("Add participant");
	private Button startChampionship = new Button("Start Championship");
	private GridPane primaryGridPane = new GridPane();
	private GridPane tournamentGridPane = new GridPane();
	private GridPane matchGridPane = new GridPane();
	private GridPane quarterFinal1GridPane = new GridPane();
	private GridPane quarterFinal2GridPane = new GridPane();
	private GridPane quarterFinal3GridPane = new GridPane();
	private GridPane quarterFinal4GridPane = new GridPane();
	private GridPane semiFinal1GridPane = new GridPane();
	private GridPane semiFinal2GridPane = new GridPane();
	private GridPane finalGridPane = new GridPane();
	private GridPane quarterFinal1OverTimeGridPane = new GridPane();
	private GridPane quarterFinal2OverTimeGridPane = new GridPane();
	private GridPane quarterFinal3OverTimeGridPane = new GridPane();
	private GridPane quarterFinal4OverTimeGridPane = new GridPane();
	private GridPane semiFinal1OverTimeGridPane = new GridPane();
	private GridPane semiFinal2OverTimeGridPane = new GridPane();
	private GridPane finalOverTimeGridPane = new GridPane();
	private GridPane quarterFinal1PenaltyGridPane = new GridPane();
	private GridPane quarterFinal2PenaltyGridPane = new GridPane();
	private GridPane quarterFinal3PenaltyGridPane = new GridPane();
	private GridPane quarterFinal4PenaltyGridPane = new GridPane();
	private GridPane semiFinal1PenaltyGridPane = new GridPane();
	private GridPane semiFinal2PenaltyGridPane = new GridPane();
	private GridPane finalPenaltyGridPane = new GridPane();
	private DropShadow darkBlueDropShadow = new DropShadow(15, Color.DARKBLUE);
	private DropShadow darkRedDropShadow = new DropShadow(15, Color.DARKRED);
	private DropShadow goldenDropShadow = new DropShadow(15, Color.GOLDENROD);
	private Label addParticipantLabel = new Label("Add participant:");
	private RadioButton tennisRadioButton = new RadioButton("Tennis");
	private RadioButton basketBallRadioButton = new RadioButton("Basketball");
	private RadioButton soccerRadioButton = new RadioButton("Soccer");
	private Scene primaryScene = new Scene(primaryBorderPane, 1450, 850);
	private Scene tournamentScene = new Scene(tournamentBorderPane, 1450, 750);
	private Scene quarterFinal1Scene = new Scene(getQuarterFinal1OverTimeBorderPane(), 450, 400);
	private Scene quarterFinal2Scene = new Scene(getQuarterFinal2OverTimeBorderPane(), 450, 400);
	private Scene quarterFinal3Scene = new Scene(getQuarterFinal3OverTimeBorderPane(), 450, 400);
	private Scene quarterFinal4Scene = new Scene(getQuarterFinal4OverTimeBorderPane(), 450, 400);
	private Scene semiFinal1Scene = new Scene(getSemiFinal1OverTimeBorderPane(), 450, 400);
	private Scene semiFinal2Scene = new Scene(getSemiFinal2OverTimeBorderPane(), 450, 400);
	private Scene finalScene = new Scene(getFinalOverTimeBorderPane(), 450, 400);
	private Stage stg = new Stage();
	private Stage stgTennis = new Stage();
	private Stage stgBasket = new Stage();
	private Stage stgSoccer = new Stage();
	private Stage stgP = new Stage();
	private Stage stgOt = new Stage();
	private Text championshipText = new Text("Championship");
	private Text winnerName = new Text();
	private TextField participant1Name = new TextField();
	private TextField participant2Name = new TextField();
	private TextField participant3Name = new TextField();
	private TextField participant4Name = new TextField();
	private TextField participant5Name = new TextField();
	private TextField participant6Name = new TextField();
	private TextField participant7Name = new TextField();
	private TextField participant8Name = new TextField();
	private TextField quarterFinal1Winner = new TextField();
	private TextField quarterFinal2Winner = new TextField();
	private TextField quarterFinal3Winner = new TextField();
	private TextField quarterFinal4Winner = new TextField();
	private TextField semiFinal1Winner = new TextField();
	private TextField semiFinal2Winner = new TextField();
	private TextField finalWinner = new TextField();
	private TextField scoreInputTxtField1 = new TextField();
	private TextField scoreInputTxtField2 = new TextField();
	private TextField scoreInputTxtField3 = new TextField();
	private TextField scoreInputTxtField4 = new TextField();
	private TextField scoreInputTxtField5 = new TextField();
	private TextField scoreInputTxtField6 = new TextField();
	private TextField scoreInputTxtField7 = new TextField();
	private TextField scoreInputTxtField8 = new TextField();
	private TextField scoreInputTxtField9 = new TextField();
	private TextField scoreInputTxtField10 = new TextField();
	private TextField scoreInputOverTimeTxtField1 = new TextField();
	private TextField scoreInputOverTimeTxtField2 = new TextField();
	public TextField scoreInputPenaltyTxtField1 = new TextField();
	public TextField scoreInputPenaltyTxtField2 = new TextField();
	public TextField scoreInputPenaltyTxtField3 = new TextField();
	public TextField scoreInputPenaltyTxtField4 = new TextField();
	public TextField scoreInputPenaltyTxtField5 = new TextField();
	public TextField scoreInputPenaltyTxtField6 = new TextField();
	public TextField scoreInputPenaltyTxtField7 = new TextField();
	public TextField scoreInputPenaltyTxtField8 = new TextField();
	public TextField scoreInputPenaltyTxtField9 = new TextField();
	public TextField scoreInputPenaltyTxtField10 = new TextField();
	private TextField nameInputTxtField = new TextField();
	private ToggleGroup tgl = new ToggleGroup();
	private VBox namesLeftVbox = new VBox(25);
	private VBox sportsRightVbox = new VBox(10);
	private VBox exceptionVBox = new VBox(10);
	private VBox soccerOverTimeVbox = new VBox(10);
	private VBox soccerPenaltyVbox = new VBox(10);

	public View(Stage primaryStage) { // Start Scene
		stg = primaryStage;
		darkBlueDropShadow.setOffsetX(3);
		darkBlueDropShadow.setOffsetY(3);
		namesLeftVbox.getChildren().addAll(participant1Name, participant2Name, participant3Name, participant4Name, participant5Name, participant6Name, participant7Name, participant8Name);
		sportsRightVbox.getChildren().addAll(tennisRadioButton, basketBallRadioButton, soccerRadioButton);
		tennisRadioButton.setToggleGroup(tgl);
		basketBallRadioButton.setToggleGroup(tgl);
		soccerRadioButton.setToggleGroup(tgl);
		initText();
		initTextFields();
		initBorderPane();
		initGridPane();
		primaryStage.setScene(primaryScene);
		primaryStage.setTitle("Championship");
		primaryStage.show();
		primaryStage.setAlwaysOnTop(true);
	}

	public void nextScene() { // Tournament Scene
		setEffectsOnButtons();
		setEffectsOnTextFields();
		addChildrenToGridPane2();
		this.tournamentBorderPane.setTop(championshipText);
		this.tournamentBorderPane.setMargin(championshipText, new Insets(1, 1, 100, 650));
		this.tournamentBorderPane.setCenter(tournamentGridPane);
		this.stg.setScene(tournamentScene);
		this.stg.setTitle("Championship Tournament");
		this.stg.show();
		this.stg.setAlwaysOnTop(true);
	}

	public void startTennisCompetition(Stage stage, String player1Name, String player2Name, Scene scene,
			BorderPane bPane, GridPane gPane, Button but) {
		Text txt = new Text("Tennis Game");
		txt.setFill(Color.BLACK);
		txt.setFont(Font.font("Tahoma", FontWeight.NORMAL, 30));
		txt.setEffect(darkBlueDropShadow);
		Label lbl1 = new Label(player1Name);
		Label lbl2 = new Label(player2Name);
		this.stgTennis = stage;
		initTennisTextFields();
		maintainTennisGridPane(gPane, but, lbl1, lbl2);
		maintainTennisBorderPane(bPane, txt, gPane);
		this.exceptionVBox.setPadding(new Insets(0, 0, 0, 170));
		scene.setRoot(bPane);
		stage.setScene(scene);
		stage.setTitle("Tennis game between " + player1Name + " and " + player2Name);
		stage.show();
		stage.setAlwaysOnTop(true);
	}

	public void startBasketBallCompetition(Stage stage, String player1Name, String player2Name, Scene scene,
			BorderPane bPane, GridPane gPane, Button but) {
		Text txt = new Text("Basketball Game");
		txt.setFill(Color.BLACK);
		txt.setFont(Font.font("Tahoma", FontWeight.NORMAL, 30));
		txt.setEffect(darkBlueDropShadow);
		Label lbl1 = new Label(player1Name);
		Label lbl2 = new Label(player2Name);
		this.stgBasket = stage;
		initBasketBallTextFields();
		maintainBasketBallGridPane(gPane, lbl1, lbl2, but);
		maintainBasketBallBorderPane(bPane, gPane, txt);
		this.exceptionVBox.setPadding(new Insets(0, 0, 0, 170));
		scene.setRoot(bPane);
		stage.setScene(scene);
		stage.setTitle("Basketball game between " + player1Name + " and " + player2Name);
		stage.show();
		stage.setAlwaysOnTop(true);
	}

	public void startSoccerCompetition(Stage stage, String player1Name, String player2Name, Scene scene,
			BorderPane bPane, GridPane gPane, Button but) {
		Text txt = new Text("Soccer Game");
		txt.setFill(Color.BLACK);
		txt.setFont(Font.font("Tahoma", FontWeight.NORMAL, 30));
		txt.setEffect(darkBlueDropShadow);
		Label lbl1 = new Label(player1Name);
		Label lbl2 = new Label(player2Name);
		this.stgSoccer = stage;
		initSoccerTextFields();
		maintainSoccerGridPane(gPane, lbl1, lbl2, but);
		maintainSoccerBorderPane(bPane, gPane, txt);
		this.exceptionVBox.setPadding(new Insets(0, 0, 0, 170));
		scene.setRoot(bPane);
		stage.setScene(scene);
		stage.setTitle("Soccer game between " + player1Name + " and " + player2Name);
		stage.show();
		stage.setAlwaysOnTop(true);
	}

	private void maintainSoccerOverTimeGridPane(GridPane gPane, Label player1Name, Label player2Name, Button but) {
		gPane.setPadding(new Insets(0, 0, 0, 130));
		gPane.setVgap(30);
		gPane.setHgap(20);
		gPane.add(player1Name, 0, 1);
		gPane.add(player2Name, 0, 2);
		gPane.add(scoreInputOverTimeTxtField1, 1, 1);
		gPane.add(scoreInputOverTimeTxtField2, 1, 2);
		gPane.add(new Label("Overtime"), 0, 0);
		gPane.add(but, 1, 3);
	}

	private void maintainSoccerOverTimeBorderPane(BorderPane bPane, GridPane gPane, Text txt) {
		bPane.setTop(txt);
		bPane.setAlignment(txt, Pos.TOP_CENTER);
		bPane.setMargin(txt, new Insets(5, 0, 80, 0));
		bPane.setCenter(gPane);
		bPane.setBottom(this.soccerOverTimeVbox);
		bPane.setMargin(this.soccerOverTimeVbox, new Insets(5, 0, 0, 0));
	}

	public void startSoccerOverTime(Stage stage, String player1Name, String player2Name, Scene scene, BorderPane bPane,
			GridPane gPane, Button but) {
		Text txt = new Text("Soccer Game");
		txt.setFill(Color.BLACK);
		txt.setFont(Font.font("Tahoma", FontWeight.NORMAL, 30));
		txt.setEffect(darkBlueDropShadow);
		Label lbl1 = new Label(player1Name);
		Label lbl2 = new Label(player2Name);
		this.stgOt = stage;
		this.scoreInputOverTimeTxtField1.setPrefWidth(50);
		this.scoreInputOverTimeTxtField2.setPrefWidth(50);
		this.soccerOverTimeVbox.setPadding(new Insets(0, 0, 0, 170));
		maintainSoccerOverTimeGridPane(gPane, lbl1, lbl2, but);
		maintainSoccerOverTimeBorderPane(bPane, gPane, txt);
		scene.setRoot(bPane);
		stage.setScene(scene);
		stage.setTitle("Overtime between " + player1Name + " and " + player2Name);
		stage.show();
		stage.setAlwaysOnTop(true);

	}

	public void startSoccerPenaltyShootoutSoocer(Stage stage, String player1Name, String player2Name, Scene scene,
			BorderPane bPane, GridPane gPane, Button but) {
		Text txt = new Text("Soccer Game");
		txt.setFill(Color.BLACK);
		txt.setFont(Font.font("Tahoma", FontWeight.NORMAL, 30));
		txt.setEffect(darkBlueDropShadow);
		Label lbl1 = new Label(player1Name);
		Label lbl2 = new Label(player2Name);
		Label lbl3 = new Label("In\\Out");
		Label lbl4 = new Label("In\\Out");
		Label lbl5 = new Label("In\\Out");
		Label lbl6 = new Label("In\\Out");
		Label lbl7 = new Label("In\\Out");
		initSoccerPenaltyTextFields();
		maintainSoccerPenaltyGridPane(gPane, lbl1, lbl2, lbl3, lbl4, lbl5, lbl6, lbl7, but);
		maintainSoccerPenaltyBorderPane(bPane, gPane, txt);
		this.stgP = stage;
		this.soccerPenaltyVbox.setPadding(new Insets(0, 0, 0, 170));
		scene.setRoot(bPane);
		stage.setScene(scene);
		stage.setTitle("Penalty shootout between " + player1Name + " and " + player2Name);
		stage.show();
		stage.setAlwaysOnTop(true);
	}

	public void setBottomTextException(String str, BorderPane bp) {
		Text txt = new Text(str);
		txt.setFill(Color.RED);
		if (bp == quarterFinal1BorderPane || bp == quarterFinal2BorderPane || bp == quarterFinal3BorderPane
				|| bp == quarterFinal4BorderPane || bp == semiFinal1BorderPane || bp == semiFinal2BorderPane
				|| bp == finalBorderPane || bp == quarterFinal1OverTimeBorderPane
				|| bp == quarterFinal2OverTimeBorderPane || bp == quarterFinal3OverTimeBorderPane
				|| bp == quarterFinal4OverTimeBorderPane || bp == semiFinal1OverTimeBorderPane
				|| bp == semiFinal2OverTimeBorderPane || bp == finalOverTimeBorderPane
				|| bp == quarterFinal1PenaltyBorderPane || bp == quarterFinal2PenaltyBorderPane
				|| bp == quarterFinal3PenaltyBorderPane || bp == quarterFinal4PenaltyBorderPane
				|| bp == semiFinal1PenaltyBorderPane || bp == semiFinal2PenaltyBorderPane
				|| bp == finalPenaltyBorderPane) {
			txt.setFont(Font.font("Tahoma", 20));
		} else
			txt.setFont(Font.font("Tahoma", 30));
		bp.setAlignment(txt, Pos.CENTER);
		bp.setMargin(txt, new Insets(12, 12, 12, 12));
		bp.setBottom(txt);
	}

	public void setWinnerMessage(String str, BorderPane bp) {
		Text txt = new Text(str);
		txt.setFill(Color.GOLD);
		txt.setFont(Font.font("Tahoma", 70));
		bp.setAlignment(txt, Pos.CENTER);
		bp.setMargin(txt, new Insets(12, 12, 12, 12));
		bp.setBottom(txt);
		setWinName(txt);
		fadeTransition();
	}

	public void fadeTransition() {
		FadeTransition fade = new FadeTransition();
		fade.setDuration(Duration.millis(800));
		fade.setNode(getWinName());
		fade.setFromValue(1);
		fade.setToValue(0.1);
		fade.setCycleCount(1000);
		fade.setAutoReverse(true);
		fade.play();
	}

	private void initSoccerPenaltyTextFields() {
		this.scoreInputPenaltyTxtField1.setPrefWidth(50);
		this.scoreInputPenaltyTxtField2.setPrefWidth(50);
		this.scoreInputPenaltyTxtField3.setPrefWidth(50);
		this.scoreInputPenaltyTxtField4.setPrefWidth(50);
		this.scoreInputPenaltyTxtField5.setPrefWidth(50);
		this.scoreInputPenaltyTxtField6.setPrefWidth(50);
		this.scoreInputPenaltyTxtField7.setPrefWidth(50);
		this.scoreInputPenaltyTxtField8.setPrefWidth(50);
		this.scoreInputPenaltyTxtField9.setPrefWidth(50);
		this.scoreInputPenaltyTxtField10.setPrefWidth(50);
	}

	private void maintainSoccerPenaltyGridPane(GridPane gPane, Label player1Name, Label player2Name, Label lbl3,
			Label lbl4, Label lbl5, Label lbl6, Label lbl7, Button but) {
		gPane.setPadding(new Insets(0, 0, 0, 20));
		gPane.setVgap(30);
		gPane.setHgap(20);
		gPane.add(player1Name, 0, 2);
		gPane.add(player2Name, 0, 3);
		gPane.add(lbl3, 1, 1);
		gPane.add(lbl4, 2, 1);
		gPane.add(lbl5, 3, 1);
		gPane.add(lbl6, 4, 1);
		gPane.add(lbl7, 5, 1);
		gPane.add(this.scoreInputPenaltyTxtField1, 1, 2);
		gPane.add(this.scoreInputPenaltyTxtField2, 2, 2);
		gPane.add(this.scoreInputPenaltyTxtField3, 3, 2);
		gPane.add(this.scoreInputPenaltyTxtField4, 4, 2);
		gPane.add(this.scoreInputPenaltyTxtField5, 5, 2);
		gPane.add(this.scoreInputPenaltyTxtField6, 1, 3);
		gPane.add(this.scoreInputPenaltyTxtField7, 2, 3);
		gPane.add(this.scoreInputPenaltyTxtField8, 3, 3);
		gPane.add(this.scoreInputPenaltyTxtField9, 4, 3);
		gPane.add(this.scoreInputPenaltyTxtField10, 5, 3);
		gPane.add(new Label("Penalty"), 0, 0);
		gPane.add(new Label("1st"), 1, 0);
		gPane.add(new Label("2nd"), 2, 0);
		gPane.add(new Label("3rd"), 3, 0);
		gPane.add(new Label("4th"), 4, 0);
		gPane.add(new Label("5th"), 5, 0);
		gPane.add(but, 3, 4);

	}

	private void maintainSoccerPenaltyBorderPane(BorderPane bPane, GridPane gPane, Text txt) {
		bPane.setTop(txt);
		bPane.setAlignment(txt, Pos.TOP_CENTER);
		bPane.setMargin(txt, new Insets(5, 0, 80, 0));
		bPane.setCenter(gPane);
		bPane.setBottom(soccerPenaltyVbox);
		bPane.setMargin(soccerPenaltyVbox, new Insets(5, 0, 0, 0));
		bPane.setBottom(soccerPenaltyVbox);
		bPane.setMargin(soccerPenaltyVbox, new Insets(5, 0, 0, 0));
	}

	private void initSoccerTextFields() {
		this.scoreInputTxtField1.setPrefWidth(50);
		this.scoreInputTxtField2.setPrefWidth(50);
		this.scoreInputTxtField3.setPrefWidth(50);
		this.scoreInputTxtField4.setPrefWidth(50);
	}

	private void maintainSoccerGridPane(GridPane gPane, Label player1Name, Label player2Name, Button but) {
		gPane.setPadding(new Insets(0, 0, 0, 130));
		gPane.setVgap(30);
		gPane.setHgap(20);
		gPane.add(player1Name, 0, 1);
		gPane.add(player2Name, 0, 2);
		gPane.add(scoreInputTxtField1, 1, 1);
		gPane.add(scoreInputTxtField2, 2, 1);
		gPane.add(scoreInputTxtField3, 1, 2);
		gPane.add(scoreInputTxtField4, 2, 2);
		gPane.add(new Label("Half"), 0, 0);
		gPane.add(new Label("1st"), 1, 0);
		gPane.add(new Label("2nd"), 2, 0);
		gPane.add(but, 1, 3);
	}

	private void maintainSoccerBorderPane(BorderPane bPane, GridPane gPane, Text txt) {
		bPane.setTop(txt);
		bPane.setAlignment(txt, Pos.TOP_CENTER);
		bPane.setMargin(txt, new Insets(5, 0, 80, 0));
		bPane.setCenter(gPane);
		bPane.setBottom(exceptionVBox);
		bPane.setMargin(exceptionVBox, new Insets(5, 0, 0, 0));
		bPane.setBottom(exceptionVBox);
		bPane.setMargin(exceptionVBox, new Insets(5, 0, 0, 0));
	}

	private void initBasketBallTextFields() {
		this.scoreInputTxtField1.setPrefWidth(50);
		this.scoreInputTxtField2.setPrefWidth(50);
		this.scoreInputTxtField3.setPrefWidth(50);
		this.scoreInputTxtField4.setPrefWidth(50);
		this.scoreInputTxtField5.setPrefWidth(50);
		this.scoreInputTxtField6.setPrefWidth(50);
		this.scoreInputTxtField7.setPrefWidth(50);
		this.scoreInputTxtField8.setPrefWidth(50);
	}

	private void maintainBasketBallGridPane(GridPane gPane, Label player1Name, Label player2Name, Button but) {
		gPane.setPadding(new Insets(0, 0, 0, 20));
		gPane.setVgap(30);
		gPane.setHgap(20);
		gPane.add(player1Name, 0, 1);
		gPane.add(player2Name, 0, 2);
		gPane.add(this.scoreInputTxtField1, 1, 1);
		gPane.add(this.scoreInputTxtField2, 2, 1);
		gPane.add(this.scoreInputTxtField3, 3, 1);
		gPane.add(this.scoreInputTxtField4, 4, 1);
		gPane.add(this.scoreInputTxtField5, 1, 2);
		gPane.add(this.scoreInputTxtField6, 2, 2);
		gPane.add(this.scoreInputTxtField7, 3, 2);
		gPane.add(this.scoreInputTxtField8, 4, 2);
		gPane.add(new Label("Quarter"), 0, 0);
		gPane.add(new Label("1st"), 1, 0);
		gPane.add(new Label("2nd"), 2, 0);
		gPane.add(new Label("3rd"), 3, 0);
		gPane.add(new Label("4th"), 4, 0);
		gPane.add(but, 3, 3);
	}

	private void maintainBasketBallBorderPane(BorderPane bPane, GridPane gPane, Text txt) {
		bPane.setTop(txt);
		bPane.setAlignment(txt, Pos.TOP_CENTER);
		bPane.setMargin(txt, new Insets(5, 0, 80, 0));
		bPane.setCenter(gPane);
		bPane.setBottom(this.exceptionVBox);
		bPane.setMargin(this.exceptionVBox, new Insets(5, 0, 0, 0));
		bPane.setBottom(this.exceptionVBox);
		bPane.setMargin(this.exceptionVBox, new Insets(5, 0, 0, 0));
	}

	private void initTennisTextFields() {
		scoreInputTxtField1.setPrefWidth(50);
		scoreInputTxtField2.setPrefWidth(50);
		scoreInputTxtField3.setPrefWidth(50);
		scoreInputTxtField4.setPrefWidth(50);
		scoreInputTxtField5.setPrefWidth(50);
		scoreInputTxtField6.setPrefWidth(50);
		scoreInputTxtField7.setPrefWidth(50);
		scoreInputTxtField8.setPrefWidth(50);
		scoreInputTxtField9.setPrefWidth(50);
		scoreInputTxtField10.setPrefWidth(50);
	}

	private void maintainTennisGridPane(GridPane gPane, Button but, Label player1Name, Label player2Name) {
		gPane.setPadding(new Insets(0, 0, 0, 20));
		gPane.setVgap(30);
		gPane.setHgap(20);
		gPane.add(player1Name, 0, 1);
		gPane.add(player2Name, 0, 2);
		gPane.add(scoreInputTxtField1, 1, 1);
		gPane.add(scoreInputTxtField2, 2, 1);
		gPane.add(scoreInputTxtField3, 3, 1);
		gPane.add(scoreInputTxtField4, 4, 1);
		gPane.add(scoreInputTxtField5, 5, 1);
		gPane.add(scoreInputTxtField6, 1, 2);
		gPane.add(scoreInputTxtField7, 2, 2);
		gPane.add(scoreInputTxtField8, 3, 2);
		gPane.add(scoreInputTxtField9, 4, 2);
		gPane.add(scoreInputTxtField10, 5, 2);
		gPane.add(new Label("Set"), 0, 0);
		gPane.add(new Label("1st"), 1, 0);
		gPane.add(new Label("2nd"), 2, 0);
		gPane.add(new Label("3rd"), 3, 0);
		gPane.add(new Label("4th"), 4, 0);
		gPane.add(new Label("5th"), 5, 0);
		gPane.add(but, 3, 3);
	}

	private void maintainTennisBorderPane(BorderPane bPane, Text txt, GridPane gPane) {
		bPane.setTop(txt);
		bPane.setAlignment(txt, Pos.TOP_CENTER);
		bPane.setMargin(txt, new Insets(5, 0, 80, 0));
		bPane.setCenter(gPane);
		bPane.setBottom(this.exceptionVBox);
		bPane.setMargin(this.exceptionVBox, new Insets(5, 0, 0, 0));
		bPane.setBottom(this.exceptionVBox);
		bPane.setMargin(this.exceptionVBox, new Insets(5, 0, 0, 0));
	}

	private void setEffectsOnButtons() {
		this.quarterFinal3Play.setEffect(darkBlueDropShadow);
		this.quarterFinal2Play.setEffect(darkRedDropShadow);
		this.quarterFinal3Play.setEffect(darkBlueDropShadow);
		this.quarterFinal4Play.setEffect(darkRedDropShadow);
		this.semiFinal1Play.setEffect(darkBlueDropShadow);
		this.semiFinal2Play.setEffect(darkRedDropShadow);
		this.finalPlay.setEffect(darkBlueDropShadow);
	}

	private void setEffectsOnTextFields() {
		this.participant3Name.setEffect(darkRedDropShadow);
		this.participant4Name.setEffect(darkRedDropShadow);
		this.participant7Name.setEffect(darkRedDropShadow);
		this.participant8Name.setEffect(darkRedDropShadow);
		this.quarterFinal1Winner.setEffect(darkBlueDropShadow);
		this.quarterFinal2Winner.setEffect(darkBlueDropShadow);
		this.quarterFinal3Winner.setEffect(darkRedDropShadow);
		this.quarterFinal4Winner.setEffect(darkRedDropShadow);
		this.semiFinal1Winner.setEffect(darkBlueDropShadow);
		this.semiFinal2Winner.setEffect(darkBlueDropShadow);
		this.finalWinner.setEffect(goldenDropShadow);
	}

	private void addChildrenToGridPane2() {
		this.tournamentGridPane.setPadding(new Insets(0, 0, 0, 20));
		this.tournamentGridPane.setVgap(1);
		this.tournamentGridPane.setHgap(60);
		this.tournamentGridPane.add(participant1Name, 0, 0);
		this.tournamentGridPane.add(participant2Name, 0, 2);
		this.tournamentGridPane.add(participant3Name, 0, 4);
		this.tournamentGridPane.add(participant4Name, 0, 6);
		this.tournamentGridPane.add(participant5Name, 0, 8);
		this.tournamentGridPane.add(participant6Name, 0, 10);
		this.tournamentGridPane.add(participant7Name, 0, 12);
		this.tournamentGridPane.add(participant8Name, 0, 14);
		this.tournamentGridPane.add(quarterFinal1Play, 1, 1);
		this.tournamentGridPane.add(quarterFinal2Play, 1, 5);
		this.tournamentGridPane.add(quarterFinal3Play, 1, 9);
		this.tournamentGridPane.add(quarterFinal4Play, 1, 13);
		this.tournamentGridPane.add(quarterFinal1Winner, 2, 1);
		this.tournamentGridPane.add(quarterFinal2Winner, 2, 5);
		this.tournamentGridPane.add(quarterFinal3Winner, 2, 9);
		this.tournamentGridPane.add(quarterFinal4Winner, 2, 13);
		this.tournamentGridPane.add(semiFinal1Play, 3, 3);
		this.tournamentGridPane.add(semiFinal2Play, 3, 11);
		this.tournamentGridPane.add(semiFinal1Winner, 4, 3);
		this.tournamentGridPane.add(semiFinal2Winner, 4, 11);
		this.tournamentGridPane.add(finalPlay, 5, 7);
		this.tournamentGridPane.add(finalWinner, 6, 7);
	}

	public void mySetOnActionAddParticipant(EventHandler<ActionEvent> event) {
		addParticipant.setOnAction(event);
	}

	public void mySetOnActionStartChampionship(EventHandler<ActionEvent> event) {
		startChampionship.setOnAction(event);
	}

	public void mySetOnActionQuarterFinal(EventHandler<ActionEvent> event) {
		quarterFinal1Play.setOnAction(event);
		quarterFinal2Play.setOnAction(event);
		quarterFinal3Play.setOnAction(event);
		quarterFinal4Play.setOnAction(event);
	}

	public void mySetOnActionSemiFinal(EventHandler<ActionEvent> event) {
		semiFinal1Play.setOnAction(event);
		semiFinal2Play.setOnAction(event);
	}

	public void mySetOnActionFinal(EventHandler<ActionEvent> event) {
		finalPlay.setOnAction(event);
	}

	public void mySetOnActionDone(EventHandler<ActionEvent> event) {
		quarterFinal1Done.setOnAction(event);
		quarterFinal2Done.setOnAction(event);
		quarterFinal3Done.setOnAction(event);
		quarterFinal4Done.setOnAction(event);
		semiFinal1Done.setOnAction(event);
		semiFinal2Done.setOnAction(event);
		finalDone.setOnAction(event);
	}

	public void mySetOnActionOvertime(EventHandler<ActionEvent> event) {
		quarterFinal1OverTimeDone.setOnAction(event);
		quarterFinal2OverTimeDone.setOnAction(event);
		quarterFinal3OverTimeDone.setOnAction(event);
		quarterFinal4OverTimeDone.setOnAction(event);
		semiFinal1OverTimeDone.setOnAction(event);
		semiFinal2OverTimeDone.setOnAction(event);
		finalOverTimeDone.setOnAction(event);
	}

	public void mySetOnActionPenalty(EventHandler<ActionEvent> event) {
		quarterFinal1PenaltyDone.setOnAction(event);
		quarterFinal2PenaltyDone.setOnAction(event);
		quarterFinal3PenaltyDone.setOnAction(event);
		quarterFinal4PenaltyDone.setOnAction(event);
		semiFinal1PenaltyDone.setOnAction(event);
		semiFinal2PenaltyDone.setOnAction(event);
		finalPenaltyDone.setOnAction(event);
	}

	private void initText() {
		this.championshipText.setFill(Color.BLACK);
		this.championshipText.setFont(Font.font("Tahoma", FontWeight.NORMAL, 35));
		this.championshipText.setEffect(darkBlueDropShadow);
	}

	private void initTextFields() {
		this.participant1Name.setEffect(darkBlueDropShadow);
		this.participant2Name.setEffect(darkBlueDropShadow);
		this.participant3Name.setEffect(darkBlueDropShadow);
		this.participant4Name.setEffect(darkBlueDropShadow);
		this.participant5Name.setEffect(darkBlueDropShadow);
		this.participant6Name.setEffect(darkBlueDropShadow);
		this.participant7Name.setEffect(darkBlueDropShadow);
		this.participant8Name.setEffect(darkBlueDropShadow);
	}

	private void initBorderPane() {
		this.primaryBorderPane.setLeft(namesLeftVbox);
		this.primaryBorderPane.setTop(championshipText);
		this.primaryBorderPane.setMargin(championshipText, new Insets(1, 1, 100, 650));
		this.primaryBorderPane.setPadding(new Insets(0, 0, 0, 20));
		this.primaryBorderPane.setCenter(primaryGridPane);
		this.primaryBorderPane.setMargin(primaryGridPane, new Insets(200, 0, 0, 400));
		this.primaryBorderPane.setRight(sportsRightVbox);
		this.primaryBorderPane.setMargin(sportsRightVbox, new Insets(200, 100, 200, 100));
	}

	private void initGridPane() {
		this.primaryGridPane.add(addParticipantLabel, 0, 0);
		this.primaryGridPane.add(nameInputTxtField, 2, 0);
		this.primaryGridPane.add(startChampionship, 2, 2);
		this.primaryGridPane.add(addParticipant, 0, 2);
		this.primaryGridPane.setVgap(5);
		this.primaryGridPane.setHgap(5);
	}

	public String getParticipantName() {
		return nameInputTxtField.getText();
	}

	public TextField getParticipantNameTf() {
		return nameInputTxtField;
	}

	public VBox getExceptionVBox() {
		return exceptionVBox;
	}

	public VBox getSoccerPenaltyVbox() {
		return soccerPenaltyVbox;
	}

	public BorderPane getQuarterFinal1OverTimeBorderPane() {
		return quarterFinal1OverTimeBorderPane;
	}

	public BorderPane getQuarterFinal2OverTimeBorderPane() {
		return quarterFinal2OverTimeBorderPane;
	}

	public BorderPane getQuarterFinal3OverTimeBorderPane() {
		return quarterFinal3OverTimeBorderPane;
	}

	public BorderPane getQuarterFinal4OverTimeBorderPane() {
		return quarterFinal4OverTimeBorderPane;
	}

	public BorderPane getSemiFinal1OverTimeBorderPane() {
		return semiFinal1OverTimeBorderPane;
	}

	public BorderPane getSemiFinal2OverTimeBorderPane() {
		return semiFinal2OverTimeBorderPane;
	}

	public BorderPane getFinalOverTimeBorderPane() {
		return finalOverTimeBorderPane;
	}

	public BorderPane getPrimaryBorderPane() {
		return primaryBorderPane;
	}

	public BorderPane getTournamentBorderPane() {
		return tournamentBorderPane;
	}

	public BorderPane getQuarterFinal1PenaltyBorderPane() {
		return quarterFinal1PenaltyBorderPane;
	}

	public BorderPane getQuarterFinal2PenaltyBorderPane() {
		return quarterFinal2PenaltyBorderPane;
	}

	public BorderPane getQuarterFinal3PenaltyBorderPane3() {
		return quarterFinal3PenaltyBorderPane;
	}

	public BorderPane getQuarterFinal4PenaltyBorderPane() {
		return quarterFinal4PenaltyBorderPane;
	}

	public BorderPane getSemiFinal1PenaltyBorderPane() {
		return semiFinal1PenaltyBorderPane;
	}

	public BorderPane getSemiFinal2PenaltyBorderPane() {
		return semiFinal2PenaltyBorderPane;
	}

	public BorderPane getFinalPenaltyBorderPane() {
		return finalPenaltyBorderPane;
	}

	public GridPane getQuarterFinal1PenaltyGridPane() {
		return quarterFinal1PenaltyGridPane;
	}

	public GridPane getQuarterFinal2PenaltyGridPane() {
		return quarterFinal2PenaltyGridPane;
	}

	public GridPane getQuarterFinal3PenaltyGridPane() {
		return quarterFinal3PenaltyGridPane;
	}

	public GridPane getQuarterFinal4PenaltyGridPane() {
		return quarterFinal4PenaltyGridPane;
	}

	public GridPane getSemiFinal1PenaltyGridPane() {
		return semiFinal1PenaltyGridPane;
	}

	public GridPane getSemiFinal2PenaltyGridPane() {
		return semiFinal2PenaltyGridPane;
	}

	public GridPane getFinalPenaltyGridPane() {
		return finalPenaltyGridPane;
	}

	public GridPane getMatchGridPane() {
		return matchGridPane;
	}

	public VBox getNamesLeftVbox() {
		return namesLeftVbox;
	}

	public Stage getPrimaryStage() {
		return stg;
	}

	public Scene getTournamentScene() {
		return tournamentScene;
	}

	public ToggleGroup getTgl() {
		return tgl;
	}

	public RadioButton getTennisRadioButton() {
		return tennisRadioButton;
	}

	public RadioButton getBasketBallRadioButton() {
		return basketBallRadioButton;
	}

	public RadioButton getSoccerRadioButton() {
		return soccerRadioButton;
	}

	public TextField getScoreInputTxtField1() {
		return scoreInputTxtField1;
	}

	public TextField getScoreInputTxtField2() {
		return scoreInputTxtField2;
	}

	public TextField getScoreInputTxtField3() {
		return scoreInputTxtField3;
	}

	public TextField getScoreInputTxtField4() {
		return scoreInputTxtField4;
	}

	public TextField getScoreInputTxtField5() {
		return scoreInputTxtField5;
	}

	public TextField getScoreInputTxtField6() {
		return scoreInputTxtField6;
	}

	public TextField getScoreInputTxtField7() {
		return scoreInputTxtField7;
	}

	public TextField getScoreInputTxtField8() {
		return scoreInputTxtField8;
	}

	public TextField getScoreInputTxtField9() {
		return scoreInputTxtField9;
	}

	public TextField getScoreInputTxtField10() {
		return scoreInputTxtField10;
	}

	public TextField getScoreInputOverTimeTxtField1() {
		return scoreInputOverTimeTxtField1;
	}

	public TextField getScoreInputOverTimeTxtField2() {
		return scoreInputOverTimeTxtField2;
	}

	public VBox getSoccerOverTimeVbox() {
		return soccerOverTimeVbox;
	}

	public GridPane getQuarterFinal1GridPane() {
		return quarterFinal1GridPane;
	}

	public GridPane getQuarterFinal2GridPane() {
		return quarterFinal2GridPane;
	}

	public GridPane getQuarterFinal3GridPane() {
		return quarterFinal3GridPane;
	}

	public GridPane getQuarterFinal4GridPane() {
		return quarterFinal4GridPane;
	}

	public GridPane getSemiFinal1GridPane() {
		return semiFinal1GridPane;
	}

	public GridPane getSemiFinal2GridPane() {
		return semiFinal2GridPane;
	}

	public GridPane getFinalGridPane() {
		return finalGridPane;
	}

	public GridPane getQuarterFinal1OverTimeGridPane() {
		return quarterFinal1OverTimeGridPane;
	}

	public GridPane getQuarterFinal2OverTimeGridPane() {
		return quarterFinal2OverTimeGridPane;
	}

	public GridPane getQuarterFinal3OverTimeGridPane() {
		return quarterFinal3OverTimeGridPane;
	}

	public GridPane getQuarterFinal4OverTimeGridPane() {
		return quarterFinal4OverTimeGridPane;
	}

	public GridPane getSemiFinal1OverTimeGridPane() {
		return semiFinal1OverTimeGridPane;
	}

	public GridPane getSemiFinal2OverTimeGridPane() {
		return semiFinal2OverTimeGridPane;
	}

	public GridPane getFinalOverTimeGridPane() {
		return finalOverTimeGridPane;
	}

	public BorderPane getQuarterFinal1BorderPane() {
		return quarterFinal1BorderPane;
	}

	public BorderPane getQuarterFinal2BorderPane() {
		return quarterFinal2BorderPane;
	}

	public BorderPane getQuarterFinal3BorderPane() {
		return quarterFinal3BorderPane;
	}

	public BorderPane getQuarterFinal4BorderPane() {
		return quarterFinal4BorderPane;
	}

	public BorderPane getSemiFinal1BorderPane() {
		return semiFinal1BorderPane;
	}

	public BorderPane getSemiFinal2BorderPane() {
		return semiFinal2BorderPane;
	}

	public BorderPane getFinalBorderPane() {
		return finalBorderPane;
	}

	public Button getQuarterFinal1Play() {
		return quarterFinal1Play;
	}

	public Button getQuarterFinal2Play() {
		return quarterFinal2Play;
	}

	public Button getQuarterFinal3Play() {
		return quarterFinal3Play;
	}

	public Button getQuarterFinal4Play() {
		return quarterFinal4Play;
	}

	public Button getSemiFinal1Play() {
		return semiFinal1Play;
	}

	public Button getSemiFinal2Play() {
		return semiFinal2Play;
	}

	public Button getFinalPlay() {
		return finalPlay;
	}

	public Button getQuarterFinal1Done() {
		return quarterFinal1Done;
	}

	public Button getQuarterFinal2Done() {
		return quarterFinal2Done;
	}

	public Button getQuarterFinal3Done() {
		return quarterFinal3Done;
	}

	public Button getQuarterFinal4Done() {
		return quarterFinal4Done;
	}

	public Button getSemiFinal1Done() {
		return semiFinal1Done;
	}

	public Button getSemiFinal2Done() {
		return semiFinal2Done;
	}

	public Button getFinalDone() {
		return finalDone;
	}

	public Button getQuarterFinal1OverTimeDone() {
		return quarterFinal1OverTimeDone;
	}

	public Button getQuarterFinal2OverTimeDone() {
		return quarterFinal2OverTimeDone;
	}

	public Button getQuarterFinal3OverTimeDone() {
		return quarterFinal3OverTimeDone;
	}

	public Button getQuarterFinal4OverTimeDone() {
		return quarterFinal4OverTimeDone;
	}

	public Button getSemiFinal1OverTimeDone() {
		return semiFinal1OverTimeDone;
	}

	public Button getSemiFinal2OverTimeDone() {
		 return semiFinal2OverTimeDone;
	}

	public Button getFinalOverTimeDone() {
		return finalOverTimeDone;
	}

	public Button getQuarterFinal1PenaltyDone() {
		return quarterFinal1PenaltyDone;
	}

	public Button getQuarterFinal2PenaltyDone() {
		return quarterFinal2PenaltyDone;
	}

	public Button getQuarterFinal3PenaltyDone() {
		return quarterFinal3PenaltyDone;
	}

	public Button getQuarterFinal4PenaltyDone() {
		return quarterFinal4PenaltyDone;
	}

	public Button getSemiFinal1PenaltyDone() {
		return semiFinal1PenaltyDone;
	}

	public Button getSemiFinal2PenaltyDone() {
		return semiFinal2PenaltyDone;
	}

	public Button getFinalPenaltyDone() {
		return finalPenaltyDone;
	}

	public TextField getParticipant1Name() {
		return participant1Name;
	}

	public TextField getParticipant2Name() {
		return participant2Name;
	}

	public TextField getParticipant3Name() {
		return participant3Name;
	}

	public TextField participant4Name() {
		return participant4Name;
	}

	public TextField getParticipant5Name() {
		return participant5Name;
	}

	public TextField getParticipant6Name() {
		return participant6Name;
	}

	public TextField getParticipant7Name() {
		return participant7Name;
	}

	public TextField getParticipant8Name() {
		return participant8Name;
	}

	public TextField getQuarterFinal1Winner() {
		return quarterFinal1Winner;
	}

	public TextField getQuarterFinal2Winner() {
		return quarterFinal2Winner;
	}

	public TextField getQuarterFinal3Winner() {
		return quarterFinal3Winner;
	}

	public TextField getQuarterFinal4Winner() {
		return quarterFinal4Winner;
	}

	public TextField getSemiFinal1Winner() {
		return semiFinal1Winner;
	}

	public TextField getSemiFinal2Winner() {
		return semiFinal2Winner;
	}

	public TextField getFinalWinner() {
		return finalWinner;
	}

	public TextField getScoreInputPenaltyTxtField1() {
		return scoreInputPenaltyTxtField1;
	}

	public TextField getScoreInputPenaltyTxtField2() {
		return scoreInputPenaltyTxtField2;
	}

	public TextField getScoreInputPenaltyTxtField3() {
		return scoreInputPenaltyTxtField3;
	}

	public TextField getScoreInputPenaltyTxtField4() {
		return scoreInputPenaltyTxtField4;
	}

	public TextField getScoreInputPenaltyTxtField5() {
		return scoreInputPenaltyTxtField5;
	}

	public TextField getScoreInputPenaltyTxtField6() {
		return scoreInputPenaltyTxtField6;
	}

	public TextField getScoreInputPenaltyTxtField7() {
		return scoreInputPenaltyTxtField7;
	}

	public TextField getScoreInputPenaltyTxtField8() {
		return scoreInputPenaltyTxtField8;
	}

	public TextField getScoreInputPenaltyTxtField9() {
		return scoreInputPenaltyTxtField9;
	}

	public TextField getScoreInputPenaltyTxtField10() {
		return scoreInputPenaltyTxtField10;
	}

	public Stage getStageTennis() {
		return stgTennis;
	}

	public Stage getStageBasket() {
		return stgBasket;
	}

	public Stage getStageSoccer() {
		return stgSoccer;
	}

	public Stage getStgOt() {
		return stgOt;
	}

	public Stage getStgP() {
		return stgP;
	}

	public void setWinName(Text txt) {
		winnerName = txt;
	}

	public Text getWinName() {
		return winnerName;
	}

	public Text winnerName(Text txt) {
		return txt;
	}

	public Scene getQuarterFinal1Scene() {
		return quarterFinal1Scene;
	}

	public Scene getQuarterFinal2Scene() {
		return quarterFinal2Scene;
	}

	public Scene getQuarterFinal3Scene() {
		return quarterFinal3Scene;
	}

	public Scene getQuarterFinal4Scene() {
		return quarterFinal4Scene;
	}

	public Scene getSemiFinal1Scene() {
		return semiFinal1Scene;
	}

	public Scene getSemiFinal2Scene() {
		return semiFinal2Scene;
	}

	public Scene getFinalScene() {
		return finalScene;
	}
}
