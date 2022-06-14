package Create.SingleFactory;

public class SimpleFactory {
   public Person createPerson(int type){
       if(type==1){
           return new Student();
       }else if(type==2){
           return new Teacher();
       }else return new Police();
   }
}
