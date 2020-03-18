package Proxy.dynamicproxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class DynamicProxy implements InvocationHandler{

	private Object obj;

	public Object bind(Object obj) {
		this.obj = obj;
		return Proxy.newProxyInstance(obj.getClass().getClassLoader(), obj.getClass().getInterfaces(),this);
	}
	
	@Override
	public Object invoke(Object proxy, Method method, Object[] args)
			throws Throwable {
		Object result = null;
		try {
			validateUser();
			System.out.println("׼����ʼ���ã�");

			result = method.invoke(obj,args); 
			if(method.getName().equalsIgnoreCase("sayHello1")){
				System.out.println("������sayHello1������");
			}
		}catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}

	private void validateUser() {
		System.out.println("validateUser....");
	}
	

}
