package servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.ParkingDAO;

@WebServlet("/ParkingStatusServlet")
public class ParkingStatusServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	
        // �t�H�[�����瑗�M���ꂽ�f�[�^���擾
    	String reservationID = request.getParameter("reserv_id");
    	String carNumber = request.getParameter("carNumber");
        String customerID = request.getParameter("cuid");
        String parkDate = request.getParameter("parkdate");
        
        if (reservationID != null) {
        	//�ꗗ��ʂɃt�H���[�h
    		RequestDispatcher dispatcher = request.getRequestDispatcher("WEB-INF/jsp/park.jsp");
    		dispatcher.forward(request, response);
        } else {
        	// �Ȃ������s
            request.getRequestDispatcher("WEB-INF/jsp/error.jsp").forward(request, response);
        }
    }
}
