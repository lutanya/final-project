package by.training.webapplication.web.tag;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspTagException;
import javax.servlet.jsp.tagext.TagSupport;
import java.io.IOException;

/**
 * Created by Tanya on 05.09.2016.
 */
public class ViewObjectTag extends TagSupport {
    private int blockCount;


    public int getBlockCount() {
        return blockCount;
    }

    public void setBlockCount(int blockCount) {
        this.blockCount = blockCount;
    }

    @Override
    public int doStartTag() throws JspException {
        int k = 0;
        for (int i = 1; i <= blockCount; i++) {
            try {

                pageContext.getOut().write("<a href=\"/controller?command=viewportfolio&i=" + k + "&transit=false\"/><input type=\"submit\" value=\"" + i + "\">");
                k+=3;

            } catch (IOException e) {
                throw new JspTagException(e.getMessage());
            }

        }
        return SKIP_BODY;
    }

    @Override
    public int doEndTag() throws JspException {

        return EVAL_PAGE;
    }


}
