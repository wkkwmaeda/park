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

@WebServlet("/SearchByParkdateServlet")
public class SearchByNameServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String cuname = request.getParameter("cuname");

        ParkingDAO dao = new ParkingDAO();
        List<Reservation> searchResults = dao.searchByName(cuname);

        request.setAttribute("searchResults", searchResults);
        request.getRequestDispatcher("SearchResult.jsp").forward(request, response);
    }
}
