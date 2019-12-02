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

        int valueInt;
        try {
            valueInt = 2 * Integer.parseInt(request.getParameter("value"));
            response.setStatus(HttpServletResponse.SC_OK);
        } catch (NumberFormatException | NullPointerException e) {
            valueInt = 0;
            response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
        }

        response.getWriter().println(valueInt);
        response.setContentType("text/html;charset=utf-8");
    }
}
