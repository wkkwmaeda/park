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
        // ���ԏ�̋󂫏󋵂��擾���郍�W�b�N�����s
    	
    	System.out.println("�f�[�^�x�[�X����f�[�^���擾���܂��B");
    	List<ParkingSpace> parkingSpace = ParkingDatabaseUtil.getParkingStatus();
    	System.out.println("�擾�����f�[�^��: " + parkingSpace.size());
    	
    	for (ParkingSpace space : parkingSpace) {
    	    System.out.println("���ԏ�ԍ�: " + space.getParkingNumber() + ", ���: " + space.getStatus());
    	}
    


        // ���ʂ����N�G�X�g�����ɐݒ�
        request.setAttribute("parkingSpace", parkingSpace);

        // JSP �y�[�W�Ƀt�H���[�h
        request.getRequestDispatcher("/WEB-INF/jsp/park.jsp").forward(request, response);
    }
}
