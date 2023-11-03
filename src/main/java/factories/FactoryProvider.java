package factories;

import factories.interfaces.UserFactory;
import proxies.DynamicProxyUser;
import proxies.ProxyUser;
import utils.ProxyOptions;
import utils.UserRoles;

public class FactoryProvider {
    public static UserFactory getFactory(ProxyOptions options, UserRoles roles) {
        switch (options) {
            case DEFAULT -> {
                switch (roles) {
                    case ADMINISTRATOR -> {
                        return new ProxyUser(new AdminFactory());
                    }
                    case COMMON -> {
                        return new ProxyUser(new CommonFactory());
                    }
                }
            }
            case DYNAMIC -> {
                switch (roles) {
                    case ADMINISTRATOR -> {
                        return new DynamicProxyUser(new AdminFactory());
                    }
                    case COMMON -> {
                        return new DynamicProxyUser(new CommonFactory());
                    }
                }
            }
        };
        return null;
    }
}
