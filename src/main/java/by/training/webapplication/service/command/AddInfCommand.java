package by.training.webapplication.service.command;

import by.training.webapplication.model.ObjPortfolio;
import by.training.webapplication.model.Photo;
import by.training.webapplication.model.User;
import by.training.webapplication.service.AuthService;
import by.training.webapplication.service.command.manager.ConfigurationManager;
import by.training.webapplication.service.exception.CommandException;
import by.training.webapplication.web.validator.Validator;

import javax.servlet.http.HttpServletRequest;
import java.io.*;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;

/**
 * Created by Tanya on 26.09.2016.
 */
public class AddInfCommand implements ActionCommand {
    private static final String PARAM_NAME_OBJECT = "nm";
    private static final String PARAM_GENRE_OBJECT = "genre";
    private static final String PARAM_OBJECT_INFO = "description";
    @Override
    public String execute(HttpServletRequest request) throws CommandException {
        ObjPortfolio obj = new ObjPortfolio();
        Photo photo = new Photo();
        String page = "/jsp/addnewobj.jsp";

        Enumeration<String> headernam = request.getParameterNames();
        while (headernam.hasMoreElements())
            System.out.println(headernam.nextElement());

        obj.setObjName(request.getParameter(PARAM_NAME_OBJECT));
        obj.setObjGenre(request.getParameter(PARAM_GENRE_OBJECT));
        obj.setObjInfo(request.getParameter(PARAM_OBJECT_INFO));
        try {
            //проверка пришел ли запрос в multipart формате
            if (isMultipartFormat(request)) {

                //разбор формата multipart и помещение информации из запроса в поля объекта
                //класса PostData
               // PostData multidata = new PostData(request);

                //извлечение посланной информации

                String tempFile = request.getParameter("photo");

                if (tempFile != null) saveFile(tempFile,request);

                //ну и дальше какая-то генерация ответа кленту...

            }
        }
catch(Exception e)
            {
                System.out.println(e.toString());
            }

        return page;
    }

        //функция, проверяющая пришел ли запрос в формате multipart
        private boolean isMultipartFormat(HttpServletRequest request)
        {
            String temptype=request.getContentType();
            if(temptype.indexOf("multipart/form-data")!=-1) return true;
            else return false;
        }

        //функция, сохраняющая пришедший файл на диск
        private void saveFile(String tempFile, HttpServletRequest request)
        {

                try
                {
                    FileInputStream fin=new FileInputStream(tempFile);
                    FileOutputStream fos=new FileOutputStream(request.getContextPath()+"/images/"+request.getParameter(PARAM_NAME_OBJECT));
                    byte[] buffer = new byte[fin.available()];
                    // считываем буфер
                    fin.read(buffer, 0, buffer.length);
                    // записываем из буфера в файл
                    fos.write(buffer, 0, buffer.length);
                }
                catch(IOException ex){
                    System.out.println(ex.getMessage());
                }
        }

}
