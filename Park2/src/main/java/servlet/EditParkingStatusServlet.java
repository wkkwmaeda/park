package servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.ParkingDatabaseUtil;
import model.ParkingSpace;

@WebServlet("/EditParkingStatusServlet")
public class EditParkingStatusServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    int parkingNumber;
    
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // URL パラメータから駐車場番号を取得
        int parkingNumber = Integer.parseInt(request.getParameter("parkingNumber"));

        // 駐車場番号から現在の状態をデータベースから取得
        ParkingSpace currentParkingSpace = ParkingDatabaseUtil.getParkingSpaceInfo(parkingNumber);

        // 取得した状態をリクエスト属性に設定
        request.setAttribute("parkingNumber", currentParkingSpace.getParkingNumber());
        request.setAttribute("currentCarNumber", currentParkingSpace.getCarNumber());
        request.setAttribute("currentStatus", currentParkingSpace.getStatus());
        request.setAttribute("currentName", currentParkingSpace.getName());
        request.setAttribute("currentCoDate", currentParkingSpace.getCoDate());

        // Edit.jsp にフォワード
        request.getRequestDispatcher("/WEB-INF/jsp/Edit.jsp").forward(request, response);
        
        
    }
    
    

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // フォームから送信されたデータを取得
		/*
		 * if (parkingNumberParam == null || parkingNumberParam.isEmpty()) { //
		 * パラメータが空の場合、エラーメッセージを設定し、エラーページにフォワード request.setAttribute("errorMessage",
		 * "駐車場番号が指定されていません。");
		 * request.getRequestDispatcher("WEB-INF/jsp/error.jsp").forward(request,
		 * response); return; }
		 */
    	
    	request.setCharacterEncoding("UTF-8");

        int parkingNumber = Integer.parseInt(request.getParameter("parkingNumber"));
        String newCarNumber = request.getParameter("newCarNumber");
        String newStatus = request.getParameter("newStatus");
        String newName = request.getParameter("newName");
        String newCoDate = request.getParameter("newCoDate");

        // 駐車場の状態を更新する DAO メソッドを呼び出す
        boolean isSuccess = ParkingDatabaseUtil.editParkingSpaceStatus(parkingNumber, newCarNumber, newStatus, newName, newCoDate);

        if (isSuccess) {
            // 更新が成功した場合の処理
            response.sendRedirect("WEB-INF/jsp/park.jsp"); // 更新後のページにリダイレクト
        } else {
            // 更新が失敗した場合の処理
            // エラーメッセージをセットしてエラーページにフォワードするなどの処理を追加
        }
    }
}