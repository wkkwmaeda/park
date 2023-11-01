package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.ParkingDAO;

public class ParkingStatusServlet extends HttpServlet {
    
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        // フォームから送信されたデータを取得
        String customerID = request.getParameter("customerId");
        String carNumber = request.getParameter("carNumber");

        // ユーザー認証を行う
        String[] userInfo = ParkingDAO.authenticateUser(customerID, carNumber);

        if (userInfo != null) {
            // ユーザーが認証された場合の処理
            out.println("<h1>Welcome, " + userInfo[0] + "!</h1>");
            out.println("<p>Your car number: " + userInfo[1] + "</p>");
            // 他の処理を追加
        } else {
            // 認証失敗時の処理
            out.println("<h1>Authentication failed. Please check your credentials.</h1>");
        }
    }
}
