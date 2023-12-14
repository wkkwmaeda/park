package servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/EditformServlet")
public class EditformServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        try {
            // 更新処理を実行（適切なコードを記述）

            // 更新が成功したらEdit.jspに遷移
            request.getRequestDispatcher("WEB-INF/jsp/Edit.jsp").forward(request, response);
        } catch (Exception e) {
            e.printStackTrace();
            // 更新処理が失敗した場合のエラーハンドリング
            request.getRequestDispatcher("WEB-INF/jsp/error.jsp").forward(request, response);
        }
    }
}
