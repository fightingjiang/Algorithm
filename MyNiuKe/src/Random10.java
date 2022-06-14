import java.util.Random;

public class Random10 {

    public int random10(){
        int row,col,idx;
        do{
            row = random7();
            col = random7();
            idx = row+(col-1)*7;
        }while (idx>40);
        return 1+(idx-1)%10;
    }

    public int random7(){
        return new Random().nextInt(6)+1;
    }
}
