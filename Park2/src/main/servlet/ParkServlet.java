import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/park")
public class ParkServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // 駐車場の利用状況を取得するロジックを呼び出す（ParkDBからデータを取得するなど）
        List<String> parkingStatusList = getParkingStatus();

        // JSPにデータを渡す
        request.setAttribute("parkingStatusList", parkingStatusList);

        // park.jspにフォワード
        request.getRequestDispatcher("park.jsp").forward(request, response);
    }

    private List<String> getParkingStatus() {
        // 駐車場の利用状況をデータベースから取得するロジックを実装する
        // この例では仮のデータを使用する
        List<String> parkingStatusList = new ArrayList<>();
        parkingStatusList.add("空き");
        parkingStatusList.add("利用中");
        // 他の駐車場の状況を追加
        return parkingStatusList;
    }
    
}
