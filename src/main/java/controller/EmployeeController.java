package controller;

import com.sun.net.httpserver.HttpsServer;
import enity.Employee;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class EmployeeController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("/employee/create.jsp").forward(req,resp);

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Employee employee = new Employee();
        employee.setFullName(req.getParameter("FullName"));
        employee.setAddress(req.getParameter("Address"));

        employee.setBirthday(req.getParameter("Birthday"));

        employee.setPosition(req.getParameter("Position"));
        employee.setDepartment(req.getParameter("Department"));

        employee.setEmployeeRef(Ref.create(employee));

        ofy().save().entity(employee).now();
        resp.sendRedirect("/employee/list");
    }
}
