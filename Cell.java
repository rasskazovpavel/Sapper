package resources;

import javafx.scene.control.Button;

public class Cell extends Button {
    private int x;//- координата клетки по x
    private int y;// - координата клетки по y
    private int state;//-2 - взорванная бомба, -1 - бомба, 0..8 - количество бомб в соседних клетках
    private Button button;
    private boolean isOpen;//открыта ли клетка
    private boolean isMarked;//отмечена ли флагом

    public Cell (int x, int y, int state){
        this.x = x;
        this.y = y;
        this.state = state;
        this.button = new Button();
        this.isMarked = isMarked;
        this.isOpen = isOpen;
    }
}
