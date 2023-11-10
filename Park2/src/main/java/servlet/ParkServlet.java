
package servlet;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/ParkServlet")
public class ParkServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // リクエストをpark.jspにフォワード
        RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/park.jsp");
        dispatcher.forward(request, response);
    }
}