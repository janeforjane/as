package servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "MyResServlet", urlPatterns = "/myResServlet")

public class ResServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        req.setCharacterEncoding("UTF-8");
//        resp.setCharacterEncoding("UTF-8");
        resp.setContentType("UTF-8");

//        String somethingFromForm = req.getParameter("user-string");
        String parameter = req.getParameter("user-string");
        byte[] bytes = parameter.getBytes("ISO-8859-1");
        String s1 = new String(bytes, "UTF-8");

        System.out.println("Строка --- " + s1);


        if (isInt(s1)) { // целое число

            int s2 = Integer.parseInt(s1) + 3;
//            s2 = s2 + 3;

            req.setAttribute("increasedNumberFromForm", s2);

            this.getServletContext().getRequestDispatcher("/increaseNumberForm.jsp").forward(req,resp);

        } else {

            String [] strings = s1.split("[ .,;_:]");

            int blockCount = 0;

            for (int i = 0; i < strings.length; i++) {

                if (strings[i].equals("")) {

                }else blockCount++;

            }


            req.setAttribute("somethingFromForm", s1);
            req.setAttribute("numberOfWords", blockCount);

            this.getServletContext().getRequestDispatcher("/convertedString.jsp").forward(req,resp);


        }


//        this.getServletContext().getRequestDispatcher("/testServlet.jsp").forward(req,resp);


    }


    public static boolean isInt(String str) {
        try {
            Integer.parseInt(str);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }
}


