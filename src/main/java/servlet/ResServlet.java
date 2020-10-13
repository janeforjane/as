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


//        String somethingFromForm = req.getParameter("user-string");
        String s1 = req.getParameter("user-string");


        if (isInt(s1)) { // целое число

            int s2 = Integer.parseInt(s1) + 3;
//            s2 = s2 + 3;

            req.setAttribute("increasedNumberFromForm", s2);

            this.getServletContext().getRequestDispatcher("/increaseNumberForm.jsp").forward(req,resp);

        } else { // строка

//            int blockCount = s1.split(" ").length;

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


//        this.getServletContext().getRequestDispatcher("/resServlet.jsp").forward(req,resp);


    }

    public static boolean isNumeric(String str) {
        try {
            Double.parseDouble(str);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    public static boolean isInt(String str) {
        try {
            Integer.parseInt(str);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    public static boolean isInteger(double i) {

        if (i % 1 == 0) {

            return true;
        } else {
            return false;
        }

    }
}


