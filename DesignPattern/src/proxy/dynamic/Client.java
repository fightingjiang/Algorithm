package proxy.dynamic;

public class Client {
    public static void main(String[] args) {
        TeacherDao teacherDao = new TeacherDao();
        ITeacherDao proxyInstance = (ITeacherDao)new ProxyFactory(teacherDao).getProxyInstance();
        proxyInstance.teach();

    }
}
