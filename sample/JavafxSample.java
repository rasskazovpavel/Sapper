package sample;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import java.io.FileInputStream;
import java.util.ArrayList;

public class JavafxSample extends Application {
    private static ArrayList<Cell> cells = new ArrayList<>();
    private static ArrayList<Button> buttons = new ArrayList<>();
    private static final int tableSize = 16;
    private static final  int buttonSize = 24;




    @Override
    public void start(Stage primaryStage) throws Exception {





        for (int i = 0; i < tableSize * tableSize; i++) {
            buttons.add(new Button());
            cells.add(new Cell(buttons.get(i), false));
        }


        for (int i = 0; i < tableSize * tableSize; i++) {
            buttons.get(i).setGraphic(
                    new ImageView(
                    new Image(
                    new FileInputStream("D:\\JavaProjects\\Minesweeper\\src\\resourses\\blank.png"))));

            buttons.get(i).setMinSize(buttonSize,buttonSize);
            buttons.get(i).setMaxSize(buttonSize,buttonSize);
            buttons.get(i).setOnMouseClicked((MouseEvent event) -> {

                if(event.getButton().equals(MouseButton.SECONDARY)){
                    leftClick(event.getSceneX(), event.getSceneY());
                }

                if(event.getButton().equals(MouseButton.PRIMARY)){
                    rigthClick(event.getSceneX(), event.getSceneY());
                }
            });

        }



        GridPane gridPane = new GridPane();
        for (int i = 0; i < tableSize * tableSize; i++)
            gridPane.add(buttons.get(i), i % tableSize, i / tableSize);



        Scene scene = new Scene(gridPane, buttonSize * tableSize, buttonSize * tableSize);
        primaryStage.setTitle("Sample Application");
        primaryStage.setScene(scene);
        primaryStage.show();
    }


    public static void rigthClick(double x, double y) {

        int numX = (int) (x / buttonSize) + 1;
        int numY = (int) (y / buttonSize);
        int number = numX + numY * (tableSize) - 1;

        buttons.get(number);
        System.out.println(number+ " ");



    }

    public static void leftClick(double x, double y) {
        int numX = (int) (x / buttonSize) + 1;
        int numY = (int) (y / buttonSize);
        int number = numX + numY * (tableSize) - 1;

        buttons.get(number);
    }
}
