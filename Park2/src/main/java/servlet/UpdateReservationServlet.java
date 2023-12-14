package servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.ParkingDAO;

import java.io.IOException;

@WebServlet("/UpdateReservationServlet")
public class UpdateReservationServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        try {
            // フォームから送信されたデータを取得
            int reservationId = Integer.parseInt(request.getParameter("reservationId"));
            String carNumber = request.getParameter("carnum");
            String parkDate = request.getParameter("parkdate");

            // ParkingDAOのインスタンスを作成
            ParkingDAO parkingDAO = new ParkingDAO();

            // editReservationメソッドを呼び出してデータベースを更新
            parkingDAO.editReservation(reservationId, carNumber, parkDate);

            // 更新後、リダイレクトまたは他の処理を行う
            request.getRequestDispatcher("WEB-INF/jsp/park.jsp").forward(request, response);
        } catch (Exception e) {
            e.printStackTrace();
            // エラーが発生した場合の処理を行ってください
            request.getRequestDispatcher("WEB-INF/jsp/error.jsp").forward(request, response);
        }
    }
}
