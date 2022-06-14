package 代理;


import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class JDKProxy {
    public static void main(String[] args) {
        //代理的真实对象
        LoginImp loginImp = new LoginImp();
        InvocationHandlerImpl handler = new InvocationHandlerImpl(loginImp);
        ClassLoader loader = loginImp.getClass().getClassLoader();
        Class<?>[] interfaces = loginImp.getClass().getInterfaces();
        //增强的LoginImp
        Login loginProxy = (Login)Proxy.newProxyInstance(loader, interfaces, handler);
        loginProxy.fun();
    }

}

class InvocationHandlerImpl implements InvocationHandler{
    private Object subject;

    public InvocationHandlerImpl(Object subject) {
        this.subject = subject;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("登陆前验证？");
        System.out.println("Method:" + method);

        //当代理对象调用真实对象的方法时，其会自动的跳转到代理对象关联的handler对象的invoke方法来进行调用
        Object returnValue = method.invoke(subject, args);

        //在代理真实对象后我们也可以添加一些自己的操作
        System.out.println("在调用之后，我要干点啥呢？");
        System.out.println(returnValue);
        return returnValue;
    }
}

interface Login{
    public String fun();
}

class LoginImp implements Login {
    public String fun(){
        System.out.println("B");
        return "OKOK";
    }
}
