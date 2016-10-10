package by.training.webapplication.web.servlet;

import javax.servlet.http.HttpServletRequest;
import java.util.Enumeration;
import java.util.HashMap;

/**
 * Created by Tanya on 04.10.2016.
 */
public class SessionRequestContent {
    private HashMap<String, Object> requestAttributes;
    private HashMap<String,String> requestParameters;
    private HashMap<String, Object> sessionAttributes;

    public SessionRequestContent(HttpServletRequest request){
        extractValues(request);
    }

    public void extractValues(HttpServletRequest request){
        String header;
        Enumeration<String> paramNames =  request.getParameterNames();
        Enumeration<String> attribNames =  request.getAttributeNames();
        while (paramNames.hasMoreElements()){
            header = paramNames.nextElement();
            requestParameters.put(header,request.getParameter(header));
        }
        while (attribNames.hasMoreElements()){
            header = attribNames.nextElement();
            requestAttributes.put(header,request.getAttribute(header));
        }
        while (attribNames.hasMoreElements()){
            header = attribNames.nextElement();
            sessionAttributes.put(header,request.getSession().getAttribute(header));
        }
    }

    public void insertAttributes(HttpServletRequest request){

    }

}
