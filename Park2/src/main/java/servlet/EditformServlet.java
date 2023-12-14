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
            // �X�V���������s�i�K�؂ȃR�[�h���L�q�j

            // �X�V������������Edit.jsp�ɑJ��
            request.getRequestDispatcher("WEB-INF/jsp/Edit.jsp").forward(request, response);
        } catch (Exception e) {
            e.printStackTrace();
            // �X�V���������s�����ꍇ�̃G���[�n���h�����O
            request.getRequestDispatcher("WEB-INF/jsp/error.jsp").forward(request, response);
        }
    }
}
