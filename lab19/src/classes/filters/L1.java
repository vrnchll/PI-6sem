package classes.filters;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

public class L1 implements ServletContextListener{

    public void contextInitialized(ServletContextEvent se) {
        System.out.println("L1:contextCreated");
    }

    public void contextDestroyed(ServletContextEvent se) {
        System.out.println("L1:contextDestroyed");
    }

}