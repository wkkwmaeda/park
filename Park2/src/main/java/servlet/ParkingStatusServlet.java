package servlet;
import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.ParkingDatabaseUtil;
import model.ParkingSpace;

@WebServlet("/ParkingStatusServlet")
public class ParkingStatusServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // 駐車場の空き状況を取得するロジックを実行
    	
    	System.out.println("データベースからデータを取得します。");
    	List<ParkingSpace> parkingSpace = ParkingDatabaseUtil.getParkingStatus();
    	System.out.println("取得したデータ数: " + parkingSpace.size());
    	
    	for (ParkingSpace space : parkingSpace) {
    	    System.out.println("駐車場番号: " + space.getParkingNumber() + ", 状態: " + space.getStatus());
    	}
    


        // 結果をリクエスト属性に設定
        request.setAttribute("parkingSpace", parkingSpace);

        // JSP ページにフォワード
        request.getRequestDispatcher("/WEB-INF/jsp/park.jsp").forward(request, response);
    }
}
