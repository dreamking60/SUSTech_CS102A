package ViewAndCtrl;

import Enum.Operation;
import Enum.Square;
import Model.FourMode;
import Model.GameState;
import Model.TwoMode;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.*;
import javafx.scene.input.MouseButton;
import javafx.scene.layout.*;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.paint.Color;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import javafx.util.Pair;

import java.io.*;


public class Main extends Application {
    public static final int SQUARE_SIZE = 50;
    public static final int SQUARE_PADDING = 2;
    GameState gameState;
    private GraphicsContext boardPen;
    private GraphicsContext squarePen;
    public static Stage primaryStage;
    @Override
    public void start(Stage primaryStage) throws Exception{
        String media_URL = getClass().getResource("/resources/bgMusic.mp3").toString();
        Media media2 = new Media(media_URL);
        MediaPlayer mp2 = new MediaPlayer(media2);
        mp2.setCycleCount(MediaPlayer.INDEFINITE);
        this.primaryStage = primaryStage;
        VBox vbox = new VBox();
        vbox.setBackground(new Background(new BackgroundFill(Color.color(0.7607843f, 0.7607843f, 0.7627451f), CornerRadii.EMPTY, Insets.EMPTY)));
        Canvas board = new Canvas(16 * SQUARE_SIZE, 16 * SQUARE_SIZE);
        boardPen = board.getGraphicsContext2D();
        boardPen.setLineWidth(SQUARE_SIZE);
        boardPen.setStroke(Color.GRAY);

        Canvas squares = new Canvas(16 * SQUARE_SIZE, 16 * SQUARE_SIZE);
        squarePen = board.getGraphicsContext2D();

        Menu menu = new Menu("File");
        MenuItem load = new MenuItem("load");
        MenuItem save = new MenuItem("save");

        load.setOnAction(event -> {
            FileChooser fileChooser = new FileChooser();
            fileChooser.setTitle("Open Resource File");
            File file = fileChooser.showOpenDialog(primaryStage);
            if (file.canRead()) {
                try {
                    ObjectInputStream ois = new ObjectInputStream(new FileInputStream(file));
                    GameState gameState = (GameState)ois.readObject();
                    if (!GameState.check(gameState)) {
                        Alert alert = new Alert(Alert.AlertType.INFORMATION);
                        alert.setTitle("Error!");
                        alert.setContentText("Error!");

                        alert.show();
                        return;
                    }
                    this.gameState = gameState;
                    updateView();
                } catch (IOException | ClassNotFoundException e) {
                    e.printStackTrace();
                }
            }
        });

        save.setOnAction(event -> {
            if (!GameState.check(gameState)) {
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("Error!");
                alert.setContentText("Error!");

                alert.show();
                return;
            }
            FileChooser fileChooser = new FileChooser();
            fileChooser.setTitle("Save Resource File");
            File file = fileChooser.showSaveDialog(primaryStage);

            try {
                ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(file));
               oos.writeObject(gameState);
            } catch (IOException e) {
                e.printStackTrace();
            }
        });
        menu.getItems().addAll(load,save);
        MenuBar menuBar = new MenuBar(menu);
        vbox.getChildren().addAll(menuBar,new Pane(board,squares));

        primaryStage.setTitle("Halma");
        primaryStage.setScene(new Scene(vbox, 16 * SQUARE_SIZE, 16 * SQUARE_SIZE + 25));
        mp2.play();

        primaryStage.show();
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Game Mode");
        alert.setContentText("do you want play with two player?");
        alert.showAndWait()
                .ifPresent(buttonType -> {
                    if (ButtonType.OK == buttonType)
                        gameState = new TwoMode();
                    else
                        gameState = new FourMode();
                });

        updateView();
        squares.setOnMouseClicked(event -> {
            int x = (int) event.getX()/SQUARE_SIZE;
            int y = (int) event.getY()/SQUARE_SIZE;
            System.out.print("x = "+x);
            System.out.println(" ,y = "+y);
            if (event.getButton() == MouseButton.SECONDARY ) {
                if (gameState.operation != null)
                    gameState.nextTurn();

                updateView();
                return;
            }

            if (gameState.turn == gameState.squareStore[x][y] && gameState.operation == null) {
                gameState.select = new Pair<>(x, y);
            } else {
                if (gameState.select != null) {
                    if (gameState.inOpposingCamp() && !gameState.inOpposingCamp(x,y))
                        return;

                    if (gameState.canJump(x, y)) {
                        if (gameState.operation == null || gameState.operation == Operation.Jump) {
                            gameState.operation = Operation.Jump;
                            gameState.op(x,y);
                        }
                    } else if (gameState.canMove(x, y)) {
                        if (gameState.operation == null) {
                            gameState.operation = Operation.Move;
                            gameState.op(x,y);
                        }
                    }
                }
            }

            updateView();
        });

    }

    private void updateView() {
        primaryStage.setTitle(gameState.turn.toString());
        squarePen.clearRect(0,0,16 * SQUARE_SIZE,16 * SQUARE_SIZE);
        // paint board;
        for (int row = 0, x ,y = 25; row < 16; row++,y+=50) {
            if (row%2 == 0)
                x = 25;
            else
                x = 75;

            for (int i = 0; i < 8; i++,x+=100) {
                boardPen.strokeLine(x,y,x,y);
            }
        }
        for (int x = 0; x < 16; x++) {
            for (int y = 0; y < 16; y++) {
                if (gameState.squareStore[x][y] == null)
                    continue;

                if (gameState.squareStore[x][y] == Square.Black)
                    squarePen.setFill(Color.BLACK);
                else if (gameState.squareStore[x][y] == Square.White)
                    squarePen.setFill(Color.WHITE);
                else if (gameState.squareStore[x][y] == Square.Red)
                    squarePen.setFill(Color.RED);
                else
                    squarePen.setFill(Color.GREEN);

                squarePen.fillOval(x * 50 + SQUARE_PADDING, y * 50 + SQUARE_PADDING, SQUARE_SIZE - SQUARE_PADDING * 2, SQUARE_SIZE - SQUARE_PADDING * 2);
                if (gameState.select != null && gameState.select.equals(new Pair<>(x,y))) {
                    int size = 7;
                    squarePen.setFill(Color.CHOCOLATE);
                    squarePen.fillOval(x * 50 + SQUARE_PADDING * size, y * 50 + SQUARE_PADDING * size, SQUARE_SIZE - SQUARE_PADDING * 2 * size, SQUARE_SIZE - SQUARE_PADDING * 2 * size);
                }
            }
        }
    }

    public static void main(String[] args) {
        launch(args);
    }
}

