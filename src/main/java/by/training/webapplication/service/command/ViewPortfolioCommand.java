package by.training.webapplication.service.command;

import by.training.webapplication.model.ObjPortfolio;
import by.training.webapplication.service.PortfolioService;
import by.training.webapplication.service.exception.CommandException;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Tanya on 08.09.2016.
 */
public class ViewPortfolioCommand implements ActionCommand{

    private PortfolioService portfolioService;

    @Override
    public String execute(HttpServletRequest request) throws CommandException {
        String page = "/jsp/portfolio.jsp";
        if(request.getSession().getAttribute("local")==null){
            request.getSession().setAttribute("localRu",true);
            request.getSession().setAttribute("localEn",false);
        }else if(request.getSession().getAttribute("local").equals("ru_RU")){
            request.getSession().setAttribute("localRu",true);
            request.getSession().setAttribute("localEn",false);
        }else{
            request.getSession().setAttribute("localEn",true);
            request.getSession().setAttribute("localRu",false);
        }
        if(request.getSession().getAttribute("obj")==null) {
            List<ObjPortfolio> objOfPortfolio = getPortfolioService().outputAllObj();
            request.getSession().setAttribute("obj", objOfPortfolio);
            request.getSession().setAttribute("objbygenre", "");
            page="/jsp/main.jsp";
            setCountPages(objOfPortfolio.size(),request);
        }else {

if(request.getParameter("start")!=null){
    page = "/jsp/main.jsp";
}
            if (request.getParameter("transit") == null) {
                List<ObjPortfolio> lst = (List<ObjPortfolio>) request.getSession().getAttribute("obj");
                List<ObjPortfolio> lstTypeObj = new ArrayList<>();
                String genreType = request.getParameter("type");
                if (genreType != null) {
                    request.getSession().setAttribute("type", genreType);
                    for (ObjPortfolio o : lst) {
                        if (o.getObjGenre().equals(request.getParameter("type"))) {
                            lstTypeObj.add(o);

                        }
                    }
                    lstTypeObj.get(0).setFirst(true);
                    lstTypeObj.get(lstTypeObj.size() - 1).setLast(true);
                    request.getSession().setAttribute("objbygenre", lstTypeObj);
                    setCountPages(lstTypeObj.size(), request);
                } else {
                    request.getSession().setAttribute("type", "");
                    setCountPages(lst.size(), request);

                }
            }
        }
       if(request.getParameter("all")!=null){
            request.getSession().setAttribute("objbygenre", "");}

        int i = Integer.parseInt(request.getParameter("i"));
        request.getSession().setAttribute("i", i);
        request.getSession().setAttribute("numberofpage", (int)(i+3)/3);

        return page;
    }

    private PortfolioService getPortfolioService() {
        if (portfolioService == null) {
            portfolioService = new PortfolioService();
        }
        return portfolioService;
    }

    private void setCountPages(int listSize,HttpServletRequest request){
        if(listSize%3==0) {
            request.getSession().setAttribute("delimCount", listSize / 3);
        }else{
            request.getSession().setAttribute("delimCount", listSize / 3 + 1);
        }
    }
}
