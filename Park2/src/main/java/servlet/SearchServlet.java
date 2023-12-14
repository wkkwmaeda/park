package servlet;

import dao.ParkingDAO;
import model.Reservation;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/SearchServlet")
public class SearchServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // フォームからのパラメータを取得
        String carnum = request.getParameter("carnum");
        String parkdate = request.getParameter("parkdate");
        String cuname = request.getParameter("cuname");

        // DAOを使って検索を行う
        ParkingDAO parkingDAO = new ParkingDAO();
        List<Reservation> reservations = parkingDAO.searchByMultipleConditions(carnum, parkdate, cuname);

        // 検索結果をリクエストにセット
        request.setAttribute("reservations", reservations);

        // 結果を表示するJSPにフォワード
        request.getRequestDispatcher("WEB-INF/jsp/SearchResult.jsp").forward(request, response);
    }
}
