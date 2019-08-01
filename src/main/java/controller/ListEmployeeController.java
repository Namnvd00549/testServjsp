package controller;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class ListEmployeeController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        ListEmployeeController.register(Employee.class);
        List<Employee> list = ofy().load().type(Employee.class).list();
        req.setAttribute("list", list);
        req.getRequestDispatcher("/employee/list.jsp").forward(req, resp);
    }
}
