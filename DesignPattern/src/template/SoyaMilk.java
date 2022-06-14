package template;

public abstract class SoyaMilk {
    final void make(){
        select();
        addCondiments();
        soak();
        beat();
    }

    //子类重写的方法定义为抽象方法

    private void select()  {
        System.out.println("step1 ending...  ");
    }

    abstract void addCondiments() ;

    private void soak() {
        System.out.println("step3:wait for 1 hour");
    }

    private void beat() {
        System.out.println("step4:select one");
    }
}
