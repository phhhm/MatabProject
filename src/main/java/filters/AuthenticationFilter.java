package filters;



import dal.dao.UserDao;
import dal.dao.UserDaoImp;
import dal.entities.UserEntity;

import javax.inject.Inject;
import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.lang.annotation.Annotation;
import java.sql.SQLException;
import java.util.Enumeration;

@WebFilter(filterName = "authenticationFilter", urlPatterns = "/*")
public class AuthenticationFilter implements Filter {

    @Inject
    private UserDao userDao;

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest httpServletRequest = (HttpServletRequest) servletRequest;
        HttpServletResponse httpServletResponse = (HttpServletResponse) servletResponse;


        if (httpServletRequest.getPathInfo().trim().contains("user/login"))
            filterChain.doFilter(httpServletRequest, httpServletResponse);
        else{
            filterChain.doFilter(httpServletRequest, httpServletResponse);
//            Enumeration<String> headers = httpServletRequest.getHeaders("Access-Control-Request-Headers");
//            while (headers.hasMoreElements()){
//                String header = headers.nextElement();
//                System.out.println(header);
//                if (header.trim().equals("user-id")){
//
//                }
//            }
//            String userId = httpServletRequest.getHeader("user-id");
//            try {
//                UserEntity userEntity = userDao.get(Long.parseLong(userId));
//                if (userEntity != null){
//                    filterChain.doFilter(httpServletRequest, httpServletResponse);
//                }else{
//                    PrintWriter writer = httpServletResponse.getWriter();
//                    writer.write("user authentication failed");
//                }
//
//            } catch (SQLException e) {
//                e.printStackTrace();
//                PrintWriter writer = httpServletResponse.getWriter();
//                writer.write("user authentication failed");
//            }
        }

    }

    @Override
    public void destroy() {

    }
}
