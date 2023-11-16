package servlet;

import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/ReservServlet")
public class ReservServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // Retrieve form data
        String customerID = request.getParameter("customerID");
        String carNumber = request.getParameter("carNumber");
        String checkInDate = request.getParameter("checkInDate");
        String checkOutDate = request.getParameter("checkOutDate");

        // Save data in session
        request.getSession().setAttribute("customerID", customerID);
        request.getSession().setAttribute("carNumber", carNumber);
        request.getSession().setAttribute("checkInDate", checkInDate);
        request.getSession().setAttribute("checkOutDate", checkOutDate);

        // Forward to ReserctionResult.jsp
        RequestDispatcher dispatcher = request.getRequestDispatcher("WEB-INF/jsp/ReserctionResult.jsp");
        dispatcher.forward(request, response);
    }
}
