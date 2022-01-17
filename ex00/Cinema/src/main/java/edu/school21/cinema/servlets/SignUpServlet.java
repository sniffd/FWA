package edu.school21.cinema.servlets;

import edu.school21.cinema.services.UsersService;
import org.springframework.context.ApplicationContext;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;


@WebServlet("/signUp")
public class SignUpServlet extends HttpServlet {

//    private UsersService usersService;

//    @Override
//    public void init(ServletConfig config) throws ServletException {
//        ServletContext context = config.getServletContext();
//        ApplicationContext springContext = (ApplicationContext) context.getAttribute("springContext");
////        this.usersService = springContext.getBean(UsersService.class);
//    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        RequestDispatcher requestDispatcher = req.getRequestDispatcher("jsp/signUp.jsp");
        requestDispatcher.forward(req, resp);
//        PrintWriter wr = resp.getWriter();
//        wr.println("hello signup");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        String name = req.getParameter("name");
//        String password = req.getParameter("pass");
//        User user = new User(name, password);
//        Model model = Model.getInstance();
//        model.add(user);
//
//        req.setAttribute("userName", name);
        doGet(req, resp);
    }
}
