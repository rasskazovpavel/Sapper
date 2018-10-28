package sample;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("sample.fxml"));
        primaryStage.setTitle("Minesweeper");
        primaryStage.setScene(new Scene(root, 300, 275));
        primaryStage.show();
    }

    public int getClickedLeft() {
        if (!isOpen) {
            if (this.isMarked) {
                this.isOpen = true;

                if (this.state == -1) {
                    this.state = -2;
                    return -1;
                }
                if (this.state == 0) {
                    return 1;
                }

            }
            return 0;
        }
    }

    public int getClickedRight() {
        if (!isOpen) {
            this.isMarked = !this.isMarked;
        }
        return 0;
    }
    public static void main(String[] args) {
        launch(args);
    }
}
