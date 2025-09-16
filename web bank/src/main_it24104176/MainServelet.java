package main_it24104176;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/main")
class MainServlet extends HttpServlet {

    protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        String page = req.getParameter("page");

        switch (page) {
            case "scheduled":
                // Check if deletion parameters are present
                String id = req.getParameter("id");
                String date = req.getParameter("date");

                if (id != null && date != null) {
                    ScheduledTransaction.deleteTransaction(getServletContext(), id, date);
                }

                req.getRequestDispatcher("scheduled.jsp").forward(req, res);
                break;

            case "create":
                req.getRequestDispatcher("create.jsp").forward(req, res);
                break;

            case "paybill":
                req.getRequestDispatcher("paybill.jsp").forward(req, res);
                break;
        }
    }
}


