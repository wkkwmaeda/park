package servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.ParkingDAO;

public class ParkingStatusServlet extends HttpServlet {
    
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	
        // フォームから送信されたデータを取得
        String customerID = request.getParameter("customerId");
        String carNumber = request.getParameter("carNumber");

        // ユーザー認証を行う
        String[] userInfo = ParkingDAO.authenticateUser(customerID, carNumber);

        if (userInfo != null) {
        	//ログイン結果画面にフォワード
    		RequestDispatcher dispatcher = request.getRequestDispatcher("WEB-INF/jsp/Edit.jsp");
    		dispatcher.forward(request, response);
        } else {
        	// ログイン失敗
            request.getRequestDispatcher("WEB-INF/jsp/error.jsp").forward(request, response);
        }
    }
}
