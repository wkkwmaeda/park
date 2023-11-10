package servlet;


import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.ParkingDAO;
import model.Reservation;

@WebServlet("/SearchByParkdateServlet")
public class SearchByParkdateServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String parkdate = request.getParameter("parkdate");

        ParkingDAO dao = new ParkingDAO();
        List<Reservation> searchResults = dao.searchByParkdate(parkdate);

        request.setAttribute("searchResults", searchResults);
        request.getRequestDispatcher("SearchResult.jsp").forward(request, response);
    }
}
