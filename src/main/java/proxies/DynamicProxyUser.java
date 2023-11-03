package proxies;

import Annotations.Transaction;
import factories.interfaces.UserFactory;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;
import java.util.UUID;

public class DynamicProxyUser implements UserFactory {
    UserFactory userFactory;

    public DynamicProxyUser(UserFactory userFactory) {
        this.userFactory = userFactory;
    }

    @Override
    @Transaction
    public UUID createUser(String name) {
        InvocationHandler handler = new DynamicProxyUserInterceptor(userFactory);
        UserFactory proxy = (UserFactory) Proxy.newProxyInstance(userFactory.getClass().getClassLoader(), new Class[]{UserFactory.class}, handler);
        return proxy.createUser(name);
    }
}
