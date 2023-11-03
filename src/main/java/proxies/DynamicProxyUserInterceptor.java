package proxies;

import Annotations.Transaction;
import factories.interfaces.UserFactory;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class DynamicProxyUserInterceptor implements InvocationHandler {
    UserFactory userFactory;

    public DynamicProxyUserInterceptor(UserFactory userFactory) {
        this.userFactory = userFactory;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        if (method.isAnnotationPresent(Transaction.class)) {
            System.out.println("Iniciando execução do método " +
                    method.getName() +
                    "." +
                    method.getDeclaringClass().getName());
            try {
                var id = method.invoke(userFactory, args);
                System.out.println("Finalizando execução do método " +
                        method.getName() +
                        "." +
                        method.getDeclaringClass().getName() +
                        " com sucesso");
                return id;
            } catch (Exception e) {
                System.out.println("Finalizando execução do método " +
                        method.getName() +
                        "." +
                        method.getDeclaringClass().getName() +
                        " com erro");
                return null;
            }
        } else {
            return method.invoke(userFactory, args);
        }
    }
}
