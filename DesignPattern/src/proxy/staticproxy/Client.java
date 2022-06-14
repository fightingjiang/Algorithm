package proxy.staticproxy;


public class Client {
    public static void main(String[] args) {
        TeacherDao teacherDao = new TeacherDao();
        TeacherDaoProxy teacher = new TeacherDaoProxy(teacherDao);
        teacher.teach();
    }
}
