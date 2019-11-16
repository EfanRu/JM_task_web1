package servlets;

import util.PageGenerator;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class MultServlet extends HttpServlet {

    public void doGet(HttpServletRequest request,
          HttpServletResponse response) throws ServletException, IOException {

//        Map<String, Object> pageVariables = createPageVariablesMap(request);
        Map<String, Object> pageVariables = new HashMap<>();
//        pageVariables.put("Answer", request.getParameter("value").toString());

        int valueInt;
        try {
            String valueStr = request.getParameterMap().get("value")[0];
            valueInt = Integer.parseInt(valueStr);
            valueInt *= 2;
            response.setStatus(HttpServletResponse.SC_OK);
        } catch (NumberFormatException | NullPointerException e) {
            valueInt = 0;
            response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
        }
        pageVariables.put("Value", valueInt);


        response.getWriter().println("<!DOCTYPE html>\n" +
                "<html xmlns=\"http://www.w3.org/1999/xhtml\">\n" +
                "<head>\n" +
                "    <meta charset=\"UTF-8\"/>\n" +
                "    <title>answer</title>\n" +
                "</head>\n" +
                "<body>\n" +
                "\n" +
                "<p>Value: " + valueInt + " </p>\n" +
                "\n" +
                "</body>\n" +
                "</html>\n" +
                "\n");

        response.setContentType("text/html;charset=utf-8");
        response.setStatus(HttpServletResponse.SC_OK);

    }
//
//    private static Map<String, Object> createPageVariablesMap(HttpServletRequest request) {
//        Map<String, Object> pageVariables = new HashMap<>();
//        pageVariables.put("method", request.getMethod());
//        pageVariables.put("URL", request.getRequestURL().toString());
//        return pageVariables;
//    }
}
