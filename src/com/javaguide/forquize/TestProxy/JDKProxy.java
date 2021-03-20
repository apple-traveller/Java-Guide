package com.javaguide.forquize.TestProxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * @author EDZ
 * @description JDKProxy
 * @date 2020/9/23 14:35
 */
public class JDKProxy {
    /**
     * 要被代理的目标对象
     */
    private A target;

    public JDKProxy(A target){
        this.target = target;
    }

    /**
     * 创建代理类
     */
    public ExInterface createProxy(){
        return (ExInterface) Proxy.newProxyInstance(target.getClass().getClassLoader(), target.getClass().getInterfaces(), new InvocationHandler() {
            @Override
            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                if("execute".equals(method.getName())){
                    //调用前验证权限
                    System.out.println("已通过权限校验");
                    //调用目标对象的方法
                    Object result = method.invoke(target, args);
                    //记录日志数据
                    System.out.println("日志打印...");
                    return result;
                }
                return method.invoke(target,args);
            }
        });
    }

//    @Override
//    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
//
//    }

    //测试验证
    public static void main(String args[]){
        A a=new A();
        //创建JDK代理
        JDKProxy jdkProxy=new JDKProxy(a);
        //创建代理对象
        ExInterface proxy=jdkProxy.createProxy();
        //执行代理对象方法
        proxy.execute();
    }
}
