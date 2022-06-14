package proxy.staticproxy;

public class TeacherDaoProxy implements ITeacherDao{

    private ITeacherDao teacher;

    public TeacherDaoProxy(ITeacherDao teacher) {
        this.teacher = teacher;
    }

    @Override
    public void teach() {
        System.out.println("ох╠╦©н");
        teacher.teach();
        System.out.println("об©н...");


    }
}
