package find;

public class SeqFind extends Find{
    @Override
    public int contains(int[]n,int num) {
        int index=-1;
        for (int i=0;i<n.length;i++){
            if(num==n[i]){
                index=i;
                break;
            }
        }



        return index;
    }
}
