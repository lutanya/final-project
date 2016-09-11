package by.training.webapplication.web.filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import java.io.IOException;

/**
 * Created by Tanya on 01.08.2016.
 */
@WebFilter("/controller")
public class EncodingFilter implements Filter {
    private final static String ENCODING = "UTF-8";
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        String encoding = servletRequest.getCharacterEncoding();
        if(!ENCODING.equalsIgnoreCase(encoding)){
            servletResponse.setCharacterEncoding(ENCODING);
            servletRequest.setCharacterEncoding(ENCODING);
        }
        filterChain.doFilter(servletRequest,servletResponse);
    }

    @Override
    public void destroy() {

    }
}
