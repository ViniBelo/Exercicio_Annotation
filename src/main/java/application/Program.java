package application;

import Annotations.Transaction;
import services.UserService;

import java.lang.reflect.Method;

public class Program {
    public static void main(String[] args) {
        UserService service = new UserService();
        Method[] methods = null;

        for (Method method: service.getClass().getMethods()) {
            if (method.isAnnotationPresent(Transaction.class)) {
                System.out.println("Iniciando execução do método " + method.getName() + "." + service.getClass().getName());
                System.out.println("Finalizando execução do método "
                        + method.getName() + "." + service.getClass().getName()
                        + " com " + service.findUser(0));
                System.out.println("Iniciando execução do método " + method.getName() + "." + service.getClass().getName());
                System.out.println("Finalizando execução do método "
                        + method.getName() + "." + service.getClass().getName()
                        + " com " + service.findUser(1));
            }
        }
    }
}
