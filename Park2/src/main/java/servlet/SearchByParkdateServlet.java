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

public class SearchByParkdateServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String Parkdate = request.getParameter("Parkdate"); // リクエストからcarnumを取得

        ParkingDAO dao = new ParkingDAO(); // あなたのデータアクセスクラスをインスタンス化

        List<Reservation> searchResults = dao.searchByCarNum(carnum); // carnumで検索

        // 検索結果をリクエスト属性にセット
        request.setAttribute("searchResults", searchResults);
        request.setAttribute("searchBy", "carnum"); // 検索方法を識別するための属性を設定

        // JSPにフォワード
        request.getRequestDispatcher("WEB-INF/jsp/SearchResult.jsp").forward(request, response);
    }
}
