package proxies;

import Annotations.Transaction;
import factories.interfaces.UserFactory;

import java.lang.reflect.Method;
import java.util.UUID;

public class ProxyUser implements UserFactory {
    private final UserFactory userFactory;

    public ProxyUser (UserFactory userFactory) {
        this.userFactory = userFactory;
    }

    @Override
    public UUID createUser(String name) {
        try {
            Method method = userFactory.getClass().getDeclaredMethod("createUser", String.class);
            if (method.isAnnotationPresent(Transaction.class)) {
                System.out.println("Iniciando execução do método " +
                        method.getName() +
                        "." +
                        method.getDeclaringClass().getName());
                try {
                    var id = userFactory.createUser(name);
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
                }
            }
        } catch (NoSuchMethodException e) {
            System.out.println();
        }
        return null;
    }
}
