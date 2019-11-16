package servlets;

import util.PageGenerator;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

        public class MainServlet extends HttpServlet {

    public void doGet(HttpServletRequest request,
                      HttpServletResponse response) throws ServletException, IOException {

        Map<String, Object> pageVariables = createPageVariablesMap(request);
        pageVariables.put("message", "");

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

        response.getWriter().println(new PageGenerator().getPage("page.html", pageVariables));

        response.setContentType("text/html;charset=utf-8");
        response.setStatus(HttpServletResponse.SC_OK);
    }

    private static Map<String, Object> createPageVariablesMap(HttpServletRequest request) {
        Map<String, Object> pageVariables = new HashMap<>();
        pageVariables.put("method", request.getMethod());
        pageVariables.put("URL", request.getRequestURL().toString());
        return pageVariables;
    }
}
