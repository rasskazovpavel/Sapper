package resources;

public class Click {
    public int getClicked(){
        if (!isOpen){
            if (/*левая кнопка*/ && this.isMarked){
                this.isOpen = true;

                if(this.state == -1){
                    this.state = -2;
                    return -1;
                }
                if(this.state == 0){
                    return 1;
                }

            }else if /*правая кнопка*/{
                this.isMarked = !this.isMarked;
            }
        }
        return 0;
    }
}
