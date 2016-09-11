package by.training.webapplication.service.command;

import by.training.webapplication.model.ObjPortfolio;
import by.training.webapplication.service.PortfolioService;

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
    public String execute(HttpServletRequest request) throws IOException {
        String page = "/jsp/portfolio.jsp";
        if(request.getSession().getAttribute("obj")==null) {
            List<ObjPortfolio> objOfPortfolio = getPortfolioService().outputAllObj();
            request.getSession().setAttribute("obj", objOfPortfolio);
            if(objOfPortfolio.size()%3==0) {
                request.getSession().setAttribute("delimCount", objOfPortfolio.size() / 3);
            }else{
                request.getSession().setAttribute("delimCount", objOfPortfolio.size() / 3 + 1);
            }
        }else if(request.getParameter("transit")==null){

            List<ObjPortfolio> lst = (List<ObjPortfolio>) request.getSession().getAttribute("obj");
            List<ObjPortfolio> lstTypeObj = new ArrayList<>();
            String genreType = request.getParameter("type");
            if(genreType!=null){
                request.getSession().setAttribute("type", genreType);
                for (ObjPortfolio o:lst) {
                    if(o.getObjGenre().equals(request.getParameter("type"))){
                        lstTypeObj.add(o);

                    }
                }
                request.getSession().setAttribute("objbygenre", lstTypeObj);

                if(lstTypeObj.size()%3==0) {
                    request.getSession().setAttribute("delimCount", lstTypeObj.size() / 3);
                }else{
                    request.getSession().setAttribute("delimCount", lstTypeObj.size() / 3 + 1);
                }
            }else
            {
                request.getSession().setAttribute("type", "");
                if(lst.size()%3==0) {
                    request.getSession().setAttribute("delimCount", lst.size() / 3);
                }else{
                    request.getSession().setAttribute("delimCount", lst.size() / 3 + 1);
                }
            }
        }
        request.getSession().setAttribute("i", request.getParameter("i"));
        return page;
    }

    public PortfolioService getPortfolioService() {
        if (portfolioService == null) {
            portfolioService = new PortfolioService();
        }
        return portfolioService;
    }
}
