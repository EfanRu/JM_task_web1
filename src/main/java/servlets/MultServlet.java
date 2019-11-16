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
        System.out.println(request.getParameter("Value"));
        response.getWriter().println(request.getParameter("Value"));
        response.setContentType("text/html;charset=utf-8");
        response.setStatus(HttpServletResponse.SC_OK);
    }
}
