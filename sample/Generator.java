package sample;

import java.util.ArrayList;
import java.util.List;
public class Generator {
    public static List<Integer> generate(int amountOfBombs){
        List<Integer> randomNumbers = new ArrayList<Integer>();
        for  (int i = 0; i <= amountOfBombs; i++) {
            randomNumbers.add((int)(Math.random() * 256));
        }
        return randomNumbers;
    }
}