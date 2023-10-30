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

        // �����Ńf�[�^�x�[�X���烆�[�U�[�����������A�ƍ����܂��B
        if (UserDAO.authenticateUser(userID, password)) {
            // ���O�C������
            // �Z�b�V�����Ƀ��[�U�[�����i�[����Ȃǂ̏�����ǉ�
            response.sendRedirect("ParkingStatusServlet");
        } else {
            // ���O�C�����s
            request.getRequestDispatcher("WEB-INF/jsp/error.jsp").forward(request, response);
        }
    }
}
