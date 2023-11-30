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
        String pi = request.getParameter("pi");
        String po = request.getParameter("po");

        // Save data in session
        request.getSession().setAttribute("cuname", cuname);
        request.getSession().setAttribute("tel", tel);
        request.getSession().setAttribute("carNumber", carNumber);
        request.getSession().setAttribute("pi", pi);
        request.getSession().setAttribute("po", po);

        // Create ParkingDAO instance
        ParkingDAO parkingDAO = new ParkingDAO();

        try {
            // Attempt to create reservation
            parkingDAO.createReservation(cuname, tel, carNumber, pi, po);

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
