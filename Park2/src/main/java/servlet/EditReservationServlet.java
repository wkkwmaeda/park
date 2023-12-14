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

@WebServlet("/ParkingStatusServlet")
public class EditReservationServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ParkingDAO parkingDAO = new ParkingDAO();
        List<Reservation> reservations = parkingDAO.getAllReservations();
        
        System.out.println(reservations);

        // Set the retrieved reservations as an attribute in the request
        request.setAttribute("reservations", reservations);

        // Forward the data to the JSP page for rendering
        request.getRequestDispatcher("WEB-INF/jsp/park.jsp").forward(request, response);
    }
}
