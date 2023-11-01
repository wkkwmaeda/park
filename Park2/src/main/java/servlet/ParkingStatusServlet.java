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

        // �t�H�[�����瑗�M���ꂽ�f�[�^���擾
        String customerID = request.getParameter("customerId");
        String carNumber = request.getParameter("carNumber");

        // ���[�U�[�F�؂��s��
        String[] userInfo = ParkingDAO.authenticateUser(customerID, carNumber);

        if (userInfo != null) {
            // ���[�U�[���F�؂��ꂽ�ꍇ�̏���
            out.println("<h1>Welcome, " + userInfo[0] + "!</h1>");
            out.println("<p>Your car number: " + userInfo[1] + "</p>");
            // ���̏�����ǉ�
        } else {
            // �F�؎��s���̏���
            out.println("<h1>Authentication failed. Please check your credentials.</h1>");
        }
    }
}
