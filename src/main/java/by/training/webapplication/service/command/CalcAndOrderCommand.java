package by.training.webapplication.service.command;

import by.training.webapplication.model.Order;
import by.training.webapplication.service.util.OrderUtil;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.Enumeration;

/**
 * Created by Tanya on 08.09.2016.
 */
public class CalcAndOrderCommand implements ActionCommand {
    private final static String PARAM_NAME_KIND_OF_WORK = "kindofwork";
    private final static String PARAM_NAME_OBJECT_SQUARE = "square";
    private final static String PARAM_NAME_STAGE = "stage[]";
    private final static String PARAM_NAME_REDUCTION_OF_TERMS = "redterm[]";
    private final static String PARAM_NAME_OVERHAUL = "ohaul";
    private final static String PARAM_NAME_TYPE_OF_PROJ = "tprojec[]";

    @Override
    public String execute(HttpServletRequest request) throws IOException {
        String page = "/jsp/services.jsp";
        Order order = new Order();
        Enumeration<String> param = request.getParameterNames();
            if(request.getParameter(PARAM_NAME_KIND_OF_WORK) != null && !request.getParameter(PARAM_NAME_OBJECT_SQUARE).equals("")){
             order.setKindOfWork(request.getParameter(PARAM_NAME_KIND_OF_WORK));
            order.setSquareOfObj(Float.parseFloat(request.getParameter(PARAM_NAME_OBJECT_SQUARE)));
            while (param.hasMoreElements()) {
                switch (param.nextElement()) {
                    case PARAM_NAME_STAGE: {
                        String[] stages = request.getParameterValues(PARAM_NAME_STAGE);
                        for (String s : stages) {
                            order.setStage(Byte.parseByte(s));
                        }
                        break;
                    }
                    case PARAM_NAME_OVERHAUL: {
                        order.setOverhaul(Boolean.parseBoolean(request.getParameter(PARAM_NAME_OVERHAUL)));
                        break;
                    }
                    case PARAM_NAME_REDUCTION_OF_TERMS: {
                        String[] redterms = request.getParameterValues(PARAM_NAME_REDUCTION_OF_TERMS);
                        for (String s : redterms) {
                            order.setReductionOfTerms(Byte.parseByte(s));
                        }
                        break;
                    }
                    case PARAM_NAME_TYPE_OF_PROJ: {
                        String[] types = request.getParameterValues(PARAM_NAME_REDUCTION_OF_TERMS);
                        for (String s : types) {
                            order.setTypeOfProject(Float.parseFloat(s));
                        }
                        break;
                    }
                }
            }
            OrderUtil.calculate(order);
        }

        return page;
    }
}
