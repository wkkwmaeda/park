package servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.ParkingDAO;

@WebServlet("/DeleteReservationServlet")
public class DeleteReservationServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // 削除ボタンがクリックされた行のIDを取得
        int reservationId = Integer.parseInt(request.getParameter("reservationId"));

        // DAOを使ってデータベースから削除
        ParkingDAO parkingDAO = new ParkingDAO();
        parkingDAO.deleteReservation(reservationId);

        // 削除後、リダイレクトまたは他の処理を行う
        RequestDispatcher dispatcher = request.getRequestDispatcher("WEB-INF/jsp/deleteResult.jsp");
        dispatcher.forward(request, response);
    }
}
