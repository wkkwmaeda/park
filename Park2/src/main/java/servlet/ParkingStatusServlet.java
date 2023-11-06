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
    	
        // �t�H�[�����瑗�M���ꂽ�f�[�^���擾
        String customerID = request.getParameter("customerId");
        String carNumber = request.getParameter("carNumber");

        // ���[�U�[�F�؂��s��
        String[] userInfo = ParkingDAO.authenticateUser(customerID, carNumber);

        if (userInfo != null) {
        	//���O�C�����ʉ�ʂɃt�H���[�h
    		RequestDispatcher dispatcher = request.getRequestDispatcher("WEB-INF/jsp/Edit.jsp");
    		dispatcher.forward(request, response);
        } else {
        	// ���O�C�����s
            request.getRequestDispatcher("WEB-INF/jsp/error.jsp").forward(request, response);
        }
    }
}
