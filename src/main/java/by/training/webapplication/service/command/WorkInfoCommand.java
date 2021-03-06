package by.training.webapplication.service.command;

import by.training.webapplication.model.ObjPortfolio;
import by.training.webapplication.service.command.manager.ConfigurationManager;
import by.training.webapplication.service.exception.CommandException;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Tanya on 09.09.2016.
 */
public class WorkInfoCommand implements ActionCommand {
    @Override
    public String execute(HttpServletRequest request) {
        boolean exit = false;
        String page = ConfigurationManager.getProperty("path.page.worksinfo");
        int id = Integer.parseInt(request.getParameter("id"));
        String genre = request.getParameter("genre");
        /*if(request.getSession().getAttribute("local")==null){
            request.getSession().setAttribute("localRu",true);
            request.getSession().setAttribute("localEn",false);
        }else if(request.getSession().getAttribute("local").equals("ru_RU")){
            request.getSession().setAttribute("localRu",true);
            request.getSession().setAttribute("localEn",false);
        }
        else{
            request.getSession().setAttribute("localEn",true);
            request.getSession().setAttribute("localRu",false);
        }*/
        int i = -1;
        if (request.getSession().getAttribute("worksByGenre") == null) {
            ArrayList<ObjPortfolio> lst = (ArrayList<ObjPortfolio>) request.getSession().getAttribute("obj");
            List<ObjPortfolio> workList = new ArrayList<>();
            while (!exit) {
                i++;
                if (lst.get(i).getId() == id) {
                    request.setAttribute("work", lst.get(i));
                    exit = true;
                }
            }
            for (ObjPortfolio elemList : lst) {
                if (elemList.getObjGenre().equals(genre)) {
                    workList.add(elemList);
                }
            }
            workList.get(0).setFirst(true);
            workList.get(workList.size() - 1).setLast(true);
            request.getSession().setAttribute("worksByGenre", workList);
        } else {
            ArrayList<ObjPortfolio> workList = (ArrayList<ObjPortfolio>) request.getSession().getAttribute("worksByGenre");
            ArrayList<ObjPortfolio> lst = (ArrayList<ObjPortfolio>) request.getSession().getAttribute("obj");
            if (!workList.get(0).getObjGenre().equals(genre)) {
                workList = new ArrayList<>();
                for (ObjPortfolio elemList : lst) {
                    if (elemList.getObjGenre().equals(genre)) {
                        workList.add(elemList);
                    }
                }
                request.getSession().setAttribute("worksByGenre", workList);
                workList.get(0).setFirst(true);
                workList.get(workList.size() - 1).setLast(true);
            }
                while (!exit) {
                    i++;
                    if (workList.get(i).getId() == id) {
                        if (request.getParameter("show").equals("previous")) {
                            request.setAttribute("work", workList.get(i - 1));
                        } else if (request.getParameter("show").equals("next")) {
                            request.setAttribute("work", workList.get(i + 1));
                        } else {
                            request.setAttribute("work", workList.get(i));
                        }
                        exit = true;
                    }
                }
            }
        return page;
    }
}

