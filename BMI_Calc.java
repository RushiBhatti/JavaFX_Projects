import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class BMI_Calc extends Application {
    @Override
    public void start(Stage stage) throws Exception {

        GridPane gp = new GridPane();

        Text t1 = new Text("Enter Weight (KG) : ");
        Text t2 = new Text("Enter Height (Feet) : ");
        Text msgUnderWeight = new Text("You are UnderWeight!");
        Text msgHealthy = new Text("You are Healthy!");
        Text msgOverWeight = new Text("You are OverWeight!");
        Text msgObesity = new Text("Obesity Range!");

        msgUnderWeight.setFont(Font.font("Lucida Sans Unicode",FontWeight.BOLD , FontPosture.REGULAR ,20));
        msgHealthy.setFont(Font.font("Lucida Sans Unicode",FontWeight.BOLD , FontPosture.REGULAR ,20));
        msgOverWeight.setFont(Font.font("Lucida Sans Unicode",FontWeight.BOLD , FontPosture.REGULAR ,20));
        msgObesity.setFont(Font.font("Lucida Sans Unicode",FontWeight.BOLD , FontPosture.REGULAR ,20));

        t1.setFill(Color.DARKCYAN);
        t2.setFill(Color.DARKGREEN);
//        t1.setStroke(Color.BLACK);
//        t2.setStroke(Color.BLACK);

        TextField tf1 = new TextField();
        TextField tf2 = new TextField();

        Button b = new Button("Calculate BMI");
        b.setOnMouseClicked(mouseEvent -> {
            String weight = tf1.getText();
            String height = tf2.getText();
            double s = (Double.parseDouble(height) * 0.305) * (Double.parseDouble(height) * 0.305);
            double BMI = Double.parseDouble(weight) / s;
            Text t4 = new Text("Your BMI is : " + BMI);
            t4.setStroke(Color.MIDNIGHTBLUE);

            if (BMI < 18.5) {
                gp.add(msgUnderWeight, 1, 4);
                gp.add(t4, 1, 5);
                gp.setStyle("-fx-background-color: grey;");
            } else if (BMI >= 18.5 && BMI < 24.9) {
                gp.add(msgHealthy, 1, 4);
                gp.add(t4, 1, 5);
                gp.setStyle("-fx-background-color: yellow;");
            } else if (BMI >= 24.9 && BMI < 29.9) {
                gp.add(msgOverWeight, 1, 4);
                gp.add(t4, 1, 5);
                gp.setStyle("-fx-background-color: pink;");
            } else {
                gp.add(msgObesity, 1, 4);
                gp.add(t4, 1, 5);
                gp.setStyle("-fx-background-color: red;");
            }

        });

        gp.setHgap(10);
        gp.setVgap(10);
        gp.setAlignment(Pos.TOP_CENTER);
        gp.setPadding(new Insets(30));
        gp.add(t1,0,1);
        gp.add(t2,0,2);
        gp.add(tf1,1,1);
        gp.add(tf2,1,2);
        gp.add(b,1,3);


        Scene scene = new Scene(gp,600,600);

        stage.setScene(scene);
        stage.setTitle("BMI Calculator");
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}