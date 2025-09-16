package main_it24104176;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/main")
public class MainServelet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        String page = req.getParameter("page");

        switch (page) {
            case "scheduled":
                String id = req.getParameter("id");
                String date = req.getParameter("date");
                if (id != null && date != null) {
                    ScheduledTransaction.deleteTransaction(getServletContext(), id, date);
                }
                req.getRequestDispatcher("/WEB-INF/it24104176/scheduled.jsp").forward(req, res);
                break;

            case "create":
                req.getRequestDispatcher("/WEB-INF/it24104176/create.jsp").forward(req, res);
                break;

            case "paybill":
                req.getRequestDispatcher("/WEB-INF/it24104176/paybill.jsp").forward(req, res);
                break;

            case "verify":
                String acc = req.getParameter("acc");
                String amt = req.getParameter("amt");
                String transDate = req.getParameter("date");
                String name = req.getParameter("name");
                String bank = req.getParameter("bank");
                String reason = req.getParameter("reason");
                String type = req.getParameter("type");

                try {
                    if (acc != null && name != null) {
                        CreateTransaction.saveTransaction(getServletContext(), acc, amt, transDate, name, bank, reason);
                    } else if (type != null) {
                        PayBill.saveBill(type, amt);
                    } else {
                        res.getWriter().println("Missing required parameters.");
                        return;
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                    res.getWriter().println("Error saving data: " + e.getClass().getSimpleName() + " - " + e.getMessage());
                    return;
                }

                req.getRequestDispatcher("/WEB-INF/it24104176/verify.jsp").forward(req, res);
                break;

            case "confirm":
                res.sendRedirect("index.jsp");
                break;

            default:
                res.getWriter().println("Invalid page selection.");
        }
    }
}
