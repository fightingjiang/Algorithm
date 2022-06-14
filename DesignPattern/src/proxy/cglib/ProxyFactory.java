package proxy.cglib;

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

public class ProxyFactory implements MethodInterceptor {

	private Object target;
	//ά��һ��Ŀ�����

	//������������һ��������Ķ���
	public ProxyFactory(Object target) {
		this.target = target;
	}

	//����һ���������:  �� target ����Ĵ������
	public Object getProxyFactory(){
		Enhancer enhancer = new Enhancer();

		enhancer.setSuperclass(target.getClass());

		enhancer.setCallback(this);

		return enhancer.create();
	}

	//��д  intercept �����������Ŀ�����ķ���
	@Override
	public Object intercept(Object o, Method method, Object[] args, MethodProxy methodProxy) throws Throwable {
		// TODO Auto-generated method stub
		System.out.println("Cglib����ģʽ ~~ ��ʼ");
		Object returnVal = method.invoke(target, args);
		System.out.println("Cglib����ģʽ ~~ �ύ");
		return returnVal;
	}
}
