package classes;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.*;
import java.io.IOException;

public class Name extends TagSupport {
    static String in = "<label>Name&nbsp &nbsp&nbsp</label>"
            + "<input name =\"name\" type = \"text\" width = \"150\" "
            + " maxlength= \"30\" ";
    public String value = "";
    public String getValue() {
        return value;
    }
    public void setValue(String value) {
        this.value = value;
    }
    public int doStartTag() throws JspException {
        JspWriter out = pageContext.getOut();
        try {
            out.print(in + (this.value.equals("")
                    ?" "
                    : "value =\""+this.value+"\" />" ));
        } catch (IOException e) {
            System.out.println("stafftag.classes.Name: " + e);
        }
        return SKIP_BODY;
    }
}