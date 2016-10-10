package by.training.webapplication.service.command;

import javax.servlet.http.HttpServletRequest;
import java.util.Enumeration;

/**
 * Created by Tanya on 15.08.2016.
 */
public class ExprLangCommand implements ActionCommand {

    @Override
    public String execute(HttpServletRequest request) {
        String page = null;

//
//            Enumeration<String> n = request.getHeaderNames();
//                    while(n.hasMoreElements()){
//                        String name = n.nextElement();
//                        String value = request.getHeader(name);
//                        System.out.println(name + ": " + value);
//
//            }
//        try {
//            page = new URL(command.getHeader("referer")).getPath();
//        } catch (MalformedURLException e) {
//            e.printStackTrace();
//        }
//        System.out.println(page);

        request.getSession().setAttribute("local",request.getParameter("local"));

        return request.getContextPath() + "/index.jsp";
    }
}
