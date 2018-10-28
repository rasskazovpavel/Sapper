package sample;

import javafx.scene.control.Button;

public class Cell extends Button {
    private Button button;
    private boolean isBomb;//является ли бомбой
    private boolean isOpen;//открыта ли клетка
    private boolean isMarked;//отмечена ли флагом


    public boolean isBomb() {
        return isBomb;
    }

    public boolean isOpen() {
        return isOpen;
    }

    public void setOpen(boolean open) {
        isOpen = open;
    }

    public void setMarked(boolean marked) {
        isMarked = marked;
    }

    public boolean isMarked() {
        return isMarked;
    }

    public Button getButton() {
        return button;
    }

    public Cell(Button button, boolean isBomb) {
        this.button = button;
        this.isBomb = isBomb;
        this.isOpen = false;
        this.isMarked = false;
    }
}