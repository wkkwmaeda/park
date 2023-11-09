package servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.ParkingDAO;
import model.Reservation;

@WebServlet("/parkingStatus")
public class ParkingStatusServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ParkingDAO parkingDAO = new ParkingDAO();
        List<Reservation> reservations = parkingDAO.getAllReservations();

        // Set the retrieved reservations as an attribute in the request
        request.setAttribute("reservations", reservations);

        // Forward the data to the JSP page for rendering
        request.getRequestDispatcher("Park.jsp").forward(request, response);
    }
}
