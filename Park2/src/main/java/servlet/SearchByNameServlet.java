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

@WebServlet("/SearchByNameServlet")
public class SearchByNameServlet extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
    	String cuname = request.getParameter("cuname");

        ParkingDAO dao = new ParkingDAO();
        List<Reservation> searchResults = dao.searchByName(cuname);

        request.setAttribute("searchResults", searchResults);
        request.getRequestDispatcher("WEB-INF/jsp/SearchResult.jsp").forward(request, response);
    }
}
