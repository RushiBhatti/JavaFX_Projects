import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;
import java.io.IOException;

public class TicTacToe extends Application {
    private Button[][] buttons;
    private Boolean[][] check;
    Boolean bl = true;
    Boolean isPlay = true;

    @Override
    public void start(Stage stage) throws IOException {
        stage.setTitle("Tic Tac Toe");

        GridPane gridPane = new GridPane();
        gridPane.setPadding(new Insets(10));
        gridPane.setHgap(10);
        gridPane.setVgap(10);

        buttons = new Button[3][3];
        check = new Boolean[3][3];

        for (int row = 0; row < 3; row++) {
            for (int col = 0; col < 3; col++) {
                Button button = new Button();
                button.setPrefSize(100, 100);
                gridPane.add(button, col, row);
                buttons[row][col] = button;
                check[row][col] = false;
            }
        }

        for (int row = 0; row < 3; row++) {
            for (int col = 0; col < 3; col++) {
                int r = row;
                int c = col;
                Button button = buttons[row][col];
                buttons[row][col].setOnAction(event -> {
                    if(isPlay){
                        if(bl && !check[r][c]){
                            button.setText("X");
                            bl = !bl;
                            check[r][c] = true;
                        }
                        else if(!check[r][c]){
                            button.setText("O");
                            bl = !bl;
                            check[r][c] = true;
                        }

                        for (int i = 0; i < 3; i++) {
                            // Check rows
                            if (buttons[i][0].getText().equals(buttons[i][1].getText())
                                    && buttons[i][0].getText().equals(buttons[i][2].getText())
                                    && !buttons[i][0].getText().isEmpty()) {
                                System.out.println("Player " + buttons[i][0].getText() + " wins!");
                                isPlay = false;
                            }
                            // Check columns
                            if (buttons[0][i].getText().equals(buttons[1][i].getText())
                                    && buttons[0][i].getText().equals(buttons[2][i].getText())
                                    && !buttons[0][i].getText().isEmpty()) {
                                System.out.println("Player " + buttons[0][i].getText() + " wins!");
                                isPlay = false;
                            }
                        }

                        // Check diagonals
                        if (buttons[0][0].getText().equals(buttons[1][1].getText())
                                && buttons[0][0].getText().equals(buttons[2][2].getText())
                                && !buttons[0][0].getText().isEmpty()) {
                            System.out.println("Player " + buttons[0][0].getText() + " wins!");
                            isPlay = false;
                        }
                        if (buttons[0][2].getText().equals(buttons[1][1].getText())
                                && buttons[0][2].getText().equals(buttons[2][0].getText())
                                && !buttons[0][2].getText().isEmpty()) {
                            System.out.println("Player " + buttons[0][2].getText() + " wins!");
                            isPlay = false;
                        }
                    }

                });
            }
        }



        Rectangle rec = new Rectangle(330 , 250);
        Label label = new Label();

        // ReSet functionality not added for now!
        Button btn = new Button("ReSet");

        rec.setFill(Color.WHITE);
        VBox vbox = new VBox(new StackPane(rec , new VBox(label ,btn )),gridPane);
        Scene scene = new Scene(vbox, 330, 540);
        stage.setTitle("Tic Tac Toe");
        stage.setScene(scene);
        stage.show();
    }



    public static void main(String[] args) {
        launch();
    }
}