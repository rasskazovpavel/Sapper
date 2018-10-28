package sample;

import javafx.scene.control.Button;

public class Cell extends Button {
    private Button button;
    private boolean isBomb;//является ли бомбой
    private boolean isOpen;//открыта ли клетка
    private boolean isFlag;//отмечена ли флагом


    public int intBomb() {
        return isBomb ? 1 : 0;
    }

    public void setBomb(boolean bomb) {
        isBomb = bomb;
    }

    public boolean isBomb() {
        return isBomb;
    }

    public boolean isOpen() {
        return isOpen;
    }

    public void setOpen(boolean open) {
        isOpen = open;
    }

    public void setFlag(boolean flag) {
        isFlag = flag;
    }

    public boolean isFlag() {
        return isFlag;
    }

    public Button getButton() {
        return button;
    }

    public Cell(Button button, boolean isBomb) {
        this.button = button;
        this.isBomb = isBomb;
        this.isOpen = false;
        this.isFlag = false;
    }
}
