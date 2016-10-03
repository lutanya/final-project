package by.training.webapplication.service.command;

import by.training.webapplication.model.ObjPortfolio;
import by.training.webapplication.model.Photo;

import by.training.webapplication.service.ObjectService;

import by.training.webapplication.service.exception.CommandException;
import by.training.webapplication.service.exception.LogicException;

import static by.training.webapplication.service.command.ActionFactory.logger;

import javax.mail.Session;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.Part;
import java.io.*;

import java.nio.file.Files;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Enumeration;
import java.util.List;
import java.util.stream.Collectors;


/**
 * Created by Tanya on 26.09.2016.
 */
public class EditingPortfCommand implements ActionCommand {
    private static final String PARAM_NAME_OBJECT = "nm";
    private static final String PARAM_GENRE_OBJECT = "genre";
    private static final String PARAM_OBJECT_INFO = "description";
    private ObjectService objectService;


    @Override
    public String execute(HttpServletRequest request) throws CommandException {
        List<ObjPortfolio> lst = (List<ObjPortfolio>) request.getSession().getAttribute("obj");
        List<ObjPortfolio> genreType = new ArrayList<ObjPortfolio>();
        if(!request.getSession().getAttribute("objbygenre").equals("")) {
             genreType = (List<ObjPortfolio>) request.getSession().getAttribute("objbygenre");
        }
        String page="";
        switch (request.getParameter("action")) {
            case "remove": {
                request.setAttribute("remove", true);
                if (request.getParameterValues("obj[]") != null) {
                    String[] removeObjects = request.getParameterValues("obj[]");

                    int delim;
                    for (String elem : removeObjects) {
                        try {
                            List<Photo> photos;
                            if(getObjectService().removeObj(elem)) {

                                //int delimCurrent = (Integer) request.getSession().getAttribute("i");
                                ServletContext context = request.getSession().getServletContext();
                                String realContextPath = context.getRealPath(request.getContextPath());
                                for (int i = 0; i < lst.size(); i++) {
                                    if (lst.get(i).getId() == Integer.parseInt(elem)) {
                                        if (lst.get(i).isFirst() && (i + 1) != lst.size())
                                            lst.get(i + 1).setFirst(true);
                                        if (lst.get(i).isLast() && i != 0) lst.get(i - 1).setLast(true);
                                        photos=lst.get(i).getObjPhoto();
                                        for(int j = 0; j<photos.size();j++){

                                            new File(realContextPath + photos.get(j).getFotoUrl()).delete();
                                        }
                                        lst.remove(i);
                                    }
                                }
                                if (genreType != null) {
                                    for (int i = 0; i < genreType.size(); i++) {
                                        if (genreType.get(i).getId() == Integer.parseInt(elem)) {
                                            genreType.remove(i);
                                        }
                                    }
                                }
                            }
                        } catch (LogicException e) {
                            logger.error(e);
                        }
                    }




                    if (!genreType.isEmpty()){
                                if (genreType.size() % 3 == 0) {
                                    request.getSession().setAttribute("delimCount", genreType.size() / 3);
                                    delim = genreType.size() / 3;
                                } else {
                                    delim = genreType.size() / 3 + 1;
                                    request.getSession().setAttribute("delimCount", genreType.size() / 3 + 1);
                                }





                        }else{
                        if (lst.size() % 3 == 0) {
                            request.getSession().setAttribute("delimCount", lst.size() / 3);
                            delim = lst.size() / 3;
                        } else {
                            request.getSession().setAttribute("delimCount", lst.size() / 3 + 1);
                            delim = lst.size() / 3 + 1;
                        }

                    }
                    if(request.getSession().getAttribute("numberofpage").equals(delim+1)){
                        request.getSession().setAttribute("i",(delim-1)*3);
                    }
                    request.getSession().setAttribute("objbygenre", genreType);
                    request.getSession().setAttribute("obj", lst);
                    }

                page = "/jsp/portfolio.jsp";
                break;
            }
            case "add": {
                ObjPortfolio obj = new ObjPortfolio();
                Photo photo;
                obj.setObjName(request.getParameter(PARAM_NAME_OBJECT));
                obj.setObjGenre(request.getParameter(PARAM_GENRE_OBJECT));
                obj.setObjInfo(request.getParameter(PARAM_OBJECT_INFO));
                try {
                    //проверка пришел ли запрос в multipart формате
                    if (isMultipartFormat(request)) {
                        String fileName = "";
                        String tempFile = "";
                        if ("POST".equalsIgnoreCase(request.getMethod())) {
                            try {
                                for (Part part : request.getParts()) {
                                    if (part.getName().equals("photo[]")) {
                                        for (String cd : part.getHeader("content-disposition").split(";")) {
                                            if (cd.trim().startsWith("filename")) {
                                                fileName = cd.substring(cd.indexOf('=') + 1).trim()
                                                        .replace("\"", "");
                                            }
                                        }


                                        if (!fileName.isEmpty()) {
                                            photo = new Photo();
                                            ServletContext context = request.getSession().getServletContext();
                                            String realContextPath = context.getRealPath(request.getContextPath());
                                            tempFile = realContextPath + "images/" + fileName;
                                            File file = new File(tempFile);
                                            try (InputStream input = part.getInputStream()) {
                                                Files.copy(input, file.toPath());
                                                photo.setFotoUrl("/images/" + fileName);
                                                obj.addObjPhoto(photo);
                                            }



                                        }
                                    }
                                }
                            } catch (IOException | ServletException e) {
                                e.printStackTrace();
                            }
                        }
                    }
                } catch (Exception e) {
                    System.out.println(e.toString());
                }

                try {
                    if(getObjectService().addObject(obj)){
                        request.setAttribute("addObj","true");
                        lst.add(obj);
                        request.getSession().setAttribute("obj", lst);
                        request.setAttribute("work", obj);
                    }

                } catch (LogicException e) {
                    logger.error(e);
                }
                page = "/jsp/addnewobj.jsp";
                break;
            }
            case "edit":{
                request.setAttribute("edit", true);
                if (request.getParameter("objectoedit") != null) {
                    request.setAttribute("workedit",request.getParameter("objectoedit"));
                    page = "/jsp/addnewobj.jsp";
                }else {
                    page = "/jsp/portfolio.jsp";
                }
                break;
            }
        }
        return page;
    }

    //функция, проверяющая пришел ли запрос в формате multipart
    private boolean isMultipartFormat(HttpServletRequest request) {
        String temptype = request.getContentType();
        if (temptype.indexOf("multipart/form-data") != -1) return true;
        else return false;
    }

    //функция, сохраняющая пришедший файл на диск
    private void saveFile(String tempFile, HttpServletRequest request) {

        try {
            FileInputStream fin = new FileInputStream(tempFile);
            FileOutputStream fos = new FileOutputStream(request.getContextPath() + "/images/" + request.getParameter(PARAM_NAME_OBJECT));
            byte[] buffer = new byte[fin.available()];
            // считываем буфер
            fin.read(buffer, 0, buffer.length);
            // записываем из буфера в файл
            fos.write(buffer, 0, buffer.length);
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }

    public ObjectService getObjectService() {
        if (objectService == null) {
            objectService = new ObjectService();
        }
        return objectService;
    }

}
