import javafx.animation.RotateTransition;
import javafx.application.Application;
import javafx.scene.effect.DropShadow;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Line;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.scene.transform.Rotate;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.util.Duration;

public class IndianFlag extends Application {
    public void start(Stage primaryStage) throws Exception {

        Text txt = new Text();
        txt.setText(" BHAARAT, BEST COUNTRY IN THE WORLD! \t\t\t\t\t\t\t\t\t\t\t   Jay Hind...");

        txt.setFont(Font.font("Lucida Sans Unicode",FontWeight.BOLD , FontPosture.ITALIC ,28));
//        txt.setFont(Font.font("Impact"),FontWeight.BOLD , FontPosture.ITALIC ,28));

        txt.setFill(Color.BLACK);

        // Making effect for text
        DropShadow ds = new DropShadow();
        ds.setHeight(160);
        ds.setColor(Color.PALEGOLDENROD);
        ds.setWidth(160);
        ds.setOffsetX(10);
        ds.setOffsetY(10);
        ds.setSpread(0.2);
        ds.setRadius(10);
        txt.setEffect(ds);

        Rectangle rec1 = new Rectangle();
        rec1.setHeight(200);
        rec1.setWidth(600);
        rec1.setFill(Color.ORANGE);
        Rectangle rec2 = new Rectangle(600,200,Color.WHITE);
        Rectangle rec3 = new Rectangle(600,200,Color.GREEN);
        Circle c = new Circle(100,Color.BLUE);
        c.setCenterX(0);
        
        // Creating Rotate Animation
        RotateTransition rt = new RotateTransition();
        rt.setByAngle(360);
        rt.setAxis(Rotate.Z_AXIS);
        rt.setDuration(Duration.millis(200));
        rt.setCycleCount(500);

        // Creating Line with Rotation
        Line ln1 = new Line();
        ln1.setFill(Color.BLACK);
        ln1.setStartX(0);
        ln1.setStartY(0);
        ln1.setEndX(150);
        ln1.setEndY(120);
        Line ln2 = new Line(0,0,150,120);
        ln2.setRotate(15);
        Line ln3 = new Line(0,0,150,120);
        ln3.setRotate(30);
        Line ln4 = new Line(0,0,150,120);
        ln4.setRotate(45);
        Line ln5 = new Line(0,0,150,120);
        ln5.setRotate(60);
        Line ln6 = new Line(0,0,150,120);
        ln6.setRotate(75);
        Line ln7 = new Line(0,0,150,120);
        ln7.setRotate(90);
        Line ln8 = new Line(0,0,150,120);
        ln8.setRotate(105);
        Line ln9 = new Line(0,0,150,120);
        ln9.setRotate(120);
        Line ln10 = new Line(0,0,150,120);
        ln10.setRotate(135);
        Line ln11 = new Line(0,0,150,120);
        ln11.setRotate(150);
        Line ln12 = new Line(0,0,150,120);
        ln12.setRotate(165);

//        rt.setNode(ln1);
//        rt.play();
//        rt.setNode(ln1);
//        rt.setNode(ln2);
//        rt.setNode(ln3);
//        rt.setNode(ln4);
//        rt.play();

        VBox root = new VBox();
        StackPane n = new StackPane();

        n.getChildren().addAll(rec2,c,ln1,ln2,ln3,ln4,ln5,ln6,ln7,ln8,ln9,ln10,ln11,ln12);
        root.getChildren().addAll(rec1,n,rec3,txt);

        rec1.widthProperty().bind(root.widthProperty().divide(1));
        rec2.widthProperty().bind(root.widthProperty().divide(1));
        rec3.widthProperty().bind(root.widthProperty().divide(1));

        Scene scene = new Scene(root,600,650);
        primaryStage.setScene(scene);
        primaryStage.setTitle("Indian Flag");
        primaryStage.show();

    }

    public static void main(String[] args) {
        launch(args);
    }
}