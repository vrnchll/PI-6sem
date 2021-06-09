package classes.filters;
import javax.servlet.http.HttpSessionAttributeListener;
import javax.servlet.http.HttpSessionBindingEvent;

public class L2 implements HttpSessionAttributeListener {
    public void attributeAdded(HttpSessionBindingEvent e) {
        System.out.println("L2:attributeAdded:AtributeName= "
                +e.getName());
    }
    public void attributeRemoved(HttpSessionBindingEvent e) {
        System.out.println("L2:attributeRemoved:AtributeName= "
                +e.getName());
    }
    public void attributeReplaced(HttpSessionBindingEvent e) {
        System.out.println("L2:attributeReplaced:AtributeName="
                +e.getName());
    }
} 