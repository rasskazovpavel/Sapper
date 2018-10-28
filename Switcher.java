package resources;

import resources.Cell;

public class Switcher extends Cell {
    public int getSwitched(){
        if(this.isMarked){
            if (this.isOpen && this.state!=- 1 ){
                //перечёркнутый флаг
            }
            //в другом случае обычный флаг
        }else if (!this.isOpen){
            //закрытая клетка
        }else{
            switch (state){
                case -2:
                    //взрыв
                case -1:
                    //бомба
                case 0:
                    //рядом нет бомб, надо открывать соседние клетки
                case 1:
                    //рядом 1 бомба
                case 2:
                    //рядом 2 бомбы
                case 3:
                    //рядом 3 бомбы
                case 4:
                    //рядом 4 бомб
                case 5:
                    //рядом 5 бомб
                case 6:
                    //рядом 6 бомб
                case 7:
                    //рядом 7 бомб
                case 8:
                    //рядом 8 бомб
            }
        }
    }


