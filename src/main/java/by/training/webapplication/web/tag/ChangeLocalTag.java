package by.training.webapplication.web.tag;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.TagSupport;
import java.io.IOException;

/**
 * Created by Tanya on 16.08.2016.
 */
public class ChangeLocalTag extends TagSupport {
    private String local;

    public void setLocal(String local){
        this.local = local;
    }
    @Override
    public int doStartTag() throws JspException {

        String setLocal = "<a href=\"/controller?command=expressionlanguage&local=" + local + "\">";

        String flagImg ="";
        if(local.equals("en_US")){
            flagImg = "<img src=\"/images/english_flag.gif\" alt=\"EN\">";
        }else if(local.equals("ru_RU")){
            flagImg = "<img src=\"/images/russian_flag.gif\" alt=\"RU\">";
        }
        try{
            JspWriter out = pageContext.getOut();
            out.write(setLocal+flagImg+"</a>");
        }catch (IOException e){

        }
        return SKIP_BODY;
    }



    @Override
    public int doEndTag() throws JspException {
        return EVAL_PAGE;
    }
}
