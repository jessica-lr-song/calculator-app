import javafx.application.Application;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.StackPane;
import javafx.scene.shape.Circle;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class Calculator extends Application {
    @FXML
    private Text display;

    double memory = 0;
    char operation = '+';

    @Override
    public void start(Stage primaryStage) throws Exception {
        primaryStage.setTitle("TI Calculator");
        primaryStage.setResizable(false);
        Parent root = new FXMLLoader(getClass().getResource("calculator.fxml")).load();
        Scene scene = new Scene(root);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public void initialize() {
        System.out.println("Initializing Calculator");
        display.setText("0");
    }

    @FXML
    public void digitPressed(MouseEvent event) {
        String digit = ((Text)(((StackPane)((Circle)event.getSource()).getParent()).getChildren().get(1))).getText();
        System.out.println("Digit Pressed: " + digit);

        if (display.getText().equals("0")){
            display.setText(""); // like you are adding nothing in place of 0
        }
        display.setText(display.getText() + digit);

    }

    @FXML
    public void signChanged(MouseEvent event) {
        if(display.getText().startsWith("-")){
            display.setText(display.getText().substring(1));
        }
        else if(!display.getText().equals("0")){
            display.setText("-" + display.getText());
        }

    }

    @FXML
    public void dotPressed(MouseEvent event) {
        if (!display.getText().contains(".")) {
            display.setText(display.getText() + ".");
        }
    }

    @FXML
    public void clearPressed(MouseEvent event) {

    }

    @FXML
    public void operationPressed(MouseEvent event) {
        String op = ((Text) (((StackPane) ((Circle) event.getSource()).getParent()).getChildren().get(1))).getText();
        operation = op.charAt(0);
        System.out.println("Operation Pressed: " + operation);

    }

    @FXML
    public void equalsPressed(MouseEvent event) {
        double number = Double.parseDouble(display.getText());

        if(operation == '+'){
            display.setText(memory + number + "");
        }
        else if(operation == '-'){
            display.setText(memory - number + "");
        }
        else if(operation == '*'){
            display.setText(memory * number + "");
        }
        else if(operation == '/'){
            display.setText(memory / number + "");
        }
    }

    public static void main(String[] args) {
        launch(args);
    }

}
