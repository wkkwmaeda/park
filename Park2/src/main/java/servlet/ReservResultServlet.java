package servlet;

import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.ParkingDAO;

@WebServlet("/ReservResultServlet")
public class ReservResultServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // Retrieve form data
        String cuname = request.getParameter("cuname");
        String tel = request.getParameter("tel");
        String carNumber = request.getParameter("carNumber");
        String checkInDate = request.getParameter("checkInDate");
        String checkOutDate = request.getParameter("checkOutDate");

        // Save data in session
        request.getSession().setAttribute("cuname", cuname);
        request.getSession().setAttribute("tel", tel);
        request.getSession().setAttribute("carNumber", carNumber);
        request.getSession().setAttribute("checkInDate", checkInDate);
        request.getSession().setAttribute("checkOutDate", checkOutDate);

        // Create ParkingDAO instance
        ParkingDAO parkingDAO = new ParkingDAO();

        try {
            // Attempt to create reservation
            parkingDAO.createReservation(cuname, tel, carNumber, checkInDate, checkOutDate);

            // Forward to ReserctionResult.jsp on success
            RequestDispatcher dispatcher = request.getRequestDispatcher("WEB-INF/jsp/ReservtionResult.jsp");
            dispatcher.forward(request, response);
        } catch (Exception e) {
            e.printStackTrace(); // Add proper logging

            // Forward to error.jsp on failure
            RequestDispatcher dispatcher = request.getRequestDispatcher("WEB-INF/jsp/error.jsp");
            dispatcher.forward(request, response);
        }
    }
}
