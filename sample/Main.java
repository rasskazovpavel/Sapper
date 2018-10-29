package sample;

import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;

import static sample.Generator.generate;

public class Main extends Application {
    private static ArrayList<Cell> cells = new ArrayList<>();
    private static ArrayList<Button> buttons = new ArrayList<>();
    private static final int tableSize = 16;
    private static final  int buttonSize = 24;
    private static String res[] = {
            "exposed", "number1", "number2", "number3", "number4", "number5", "number6", "number7",
            "number8","blank", "flag", "hitmine", "mine", "wrongmine"
    };



    @Override
    public void start(Stage primaryStage) throws Exception {


        List<Integer> bombs = generate(20);

        for (int i = 0; i < tableSize * tableSize; i++) {
            buttons.add(new Button());
            cells.add(new Cell(buttons.get(i), false));
        }

        for(int k: bombs){
            cells.get(k).setBomb(true);
        }
        for (int i = 0; i < tableSize * tableSize; i++) {
            setPic(i, res[9]);

            buttons.get(i).setMinSize(buttonSize,buttonSize);
            buttons.get(i).setMaxSize(buttonSize,buttonSize);
            buttons.get(i).setOnMouseClicked((MouseEvent event) -> {

                if(event.getButton().equals(MouseButton.SECONDARY)){
                    try {
                        leftClick(event.getSceneX(), event.getSceneY());
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
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

    public static void setPic(int n, String res) {
        File file = new File( "resources/" + res + ".png");
        try {
            cells.get(n).getButton()
                    .setGraphic(
                            new ImageView(
                                    new Image(new FileInputStream(file))));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

    }

    public static void recOpen(int num) {
        if (!cells.get(num).isOpen() && !cells.get(num).isFlag())
            if (calcBombs(num) == 0) {
                cells.get(num).setOpen(true);
                setPic(num, res[0]);
                {
                    switch (num) {
                        case 0:
                            recOpen(num + 1);
                            recOpen(num + tableSize);
                            recOpen(num + tableSize + 1);
                            break;
                        case tableSize - 1:
                            recOpen(num - 1);
                            recOpen(num + tableSize);
                            recOpen(num + tableSize - 1);
                            break;
                        case tableSize * (tableSize - 1):
                            recOpen(num + 1);
                            recOpen(num - tableSize);
                            recOpen(num - tableSize + 1);
                            break;
                        case tableSize * tableSize - 1:
                            recOpen(num - 1);
                            recOpen(num - tableSize);
                            recOpen(num - tableSize - 1);
                            break;
                        default:
                            if (num <= 8) {
                                recOpen(num - 1);
                                recOpen(num + 1);
                                recOpen(num + tableSize - 1);
                                recOpen(num + tableSize);
                                recOpen(num + tableSize + 1);
                            } else if (num > tableSize * (tableSize - 1) && num < tableSize * tableSize - 1) {
                                recOpen(num - 1);
                                recOpen(num + 1);
                                recOpen(num - tableSize - 1);
                                recOpen(num - tableSize);
                                recOpen(num - tableSize + 1);
                            } else if (num % tableSize == 0) {
                                recOpen(num + 1);
                                recOpen(num - tableSize);
                                recOpen(num + tableSize);
                                recOpen(num - tableSize + 1);
                                recOpen(num + tableSize + 1);
                            } else if (num % tableSize == tableSize - 1) {
                                recOpen(num - 1);
                                recOpen(num + tableSize);
                                recOpen(num + tableSize - 1);
                                recOpen(num - tableSize);
                                recOpen(num - tableSize - 1);
                            } else {
                                recOpen(num + 1);
                                recOpen(num - 1);
                                recOpen(num + tableSize - 1);
                                recOpen(num + tableSize + 1);
                                recOpen(num + tableSize);
                                recOpen(num - tableSize - 1);
                                recOpen(num - tableSize);
                                recOpen(num - tableSize + 1);
                            }
                    }
                }        }
            else {
                setPic(num, "number" + calcBombs(num));
                cells.get(num).setOpen(true);
            }
    }

    public static int calcBombs(int num) {
        int k = 0;
        switch (num) {
            case 0:
                k += cells.get(num + 1).intBomb() + cells.get(num + tableSize).intBomb()
                        +cells.get(num + tableSize + 1).intBomb();
                break;
            case tableSize - 1:
                k += cells.get(num - 1).intBomb() + cells.get(num + tableSize).intBomb()
                        +cells.get(num + tableSize - 1).intBomb();
                break;
            case tableSize * (tableSize - 1):
                k += cells.get(num + 1).intBomb() + cells.get(num - tableSize).intBomb()
                        +cells.get(num - tableSize + 1).intBomb();
                break;
            case tableSize * tableSize - 1:
                k += cells.get(num - 1).intBomb() + cells.get(num - tableSize).intBomb()
                        +cells.get(num - tableSize - 1).intBomb();
                break;
            default:
                if (num >= 1 && num <=8)
                    k+= cells.get(num - 1).intBomb() + cells.get(num + 1).intBomb()
                            + cells.get(num + tableSize - 1).intBomb() + cells.get(num + tableSize).intBomb()
                            + cells.get(num + tableSize + 1).intBomb();
                else
                if (num > tableSize * (tableSize - 1) && num < tableSize * tableSize - 1)
                    k+= cells.get(num - 1).intBomb() + cells.get(num + 1).intBomb()
                            + cells.get(num - tableSize - 1).intBomb() + cells.get(num - tableSize).intBomb()
                            + cells.get(num - tableSize + 1).intBomb();
                else
                if (num % tableSize == 0)
                    k+= cells.get(num + 1).intBomb() + cells.get(num + tableSize).intBomb()
                            + cells.get(num - tableSize).intBomb() + cells.get(num - tableSize + 1).intBomb()
                            + cells.get(num + tableSize + 1).intBomb();
                else
                if (num % tableSize == tableSize - 1)
                    k+= cells.get(num - 1).intBomb() + cells.get(num + tableSize).intBomb()
                            + cells.get(num - tableSize).intBomb() + cells.get(num - tableSize - 1).intBomb()
                            + cells.get(num + tableSize - 1).intBomb();
                else
                    k+= cells.get(num + 1).intBomb() + cells.get(num - 1).intBomb()
                            + cells.get(num + tableSize).intBomb() + cells.get(num + tableSize + 1).intBomb()
                            + cells.get(num + tableSize - 1).intBomb() + cells.get(num - tableSize).intBomb()
                            + cells.get(num - tableSize + 1).intBomb() + cells.get(num - tableSize - 1).intBomb();

        }
        return k;
    }

    public static void rigthClick(double x, double y) {

        int numX = (int) (x / buttonSize) + 1;
        int numY = (int) (y / buttonSize);
        int number = numX + numY * (tableSize) - 1;


        if(cells.get(number).isBomb()){
            setPic(number, res[12]);
            Group group1 = new Group();
            Stage stage = new Stage();
            Scene scene = new Scene(group1, 400, 400 );
            stage.setTitle("GameOver");
            stage.setScene(scene);
            stage.show();
        }
        else {
            setPic(number, res[0]);
            recOpen(number);
        }
    }


    public static void leftClick(double x, double y) throws Exception {

        int numX = (int) (x / buttonSize) + 1;
        int numY = (int) (y / buttonSize);
        int number = numX + numY * (tableSize) - 1;

        if(!cells.get(number).isOpen())
            if (cells.get(number).isFlag()) {
                setPic(number, res[9]);
                cells.get(number).setFlag(false);
            }
            else {
                setPic(number, res[10]);
                cells.get(number).setFlag(true);
            }
    }
}

