package servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.UserDAO;

@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String userID = request.getParameter("userID");
        String password = request.getParameter("password");

        // ここでデータベースからユーザー情報を検索し、照合します。
        if (UserDAO.authenticateUser(userID, password)) {
            // ログイン成功
            // セッションにユーザー情報を格納するなどの処理を追加
            response.sendRedirect("ParkingStatusServlet");
        } else {
            // ログイン失敗
            request.getRequestDispatcher("WEB-INF/jsp/error.jsp").forward(request, response);
        }
    }
}
