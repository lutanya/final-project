package by.training.webapplication.web.tag;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.TagSupport;
import java.io.IOException;
import java.util.GregorianCalendar;

/**
 * Created by Tanya on 08.08.2016.
 */
public class InfoTimeTag extends TagSupport {

    @Override
    public int doStartTag() throws JspException {
        GregorianCalendar gc = new GregorianCalendar();
        String time = "<hr/>Time : <b> " + gc.getTime() + "</b><hr/>";
        try{
            JspWriter out = pageContext.getOut();
            out.write(time);
        }catch (IOException e){

        }
        return SKIP_BODY;
    }

    @Override
    public int doEndTag() throws JspException {
        return EVAL_PAGE;
    }


}
