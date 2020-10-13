package servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "MyServlet", urlPatterns = "/myServlet")

public class HelloServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

//        String name = req.getParameter("name");
//        PrintWriter writer = resp.getWriter();
//        writer.write("Hello" + name);


        String newName = req.getParameter("name");
        String s = newName.toUpperCase();

        req.setAttribute("nameAttribute", s);

        this.getServletContext().getRequestDispatcher("/helloServlet.jsp").forward(req,resp);

    }
}
