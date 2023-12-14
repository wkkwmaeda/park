package servlet;

import dao.ParkingDAO;
import model.Reservation;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/SearchServlet")
public class SearchServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // �t�H�[������̃p�����[�^���擾
        String carnum = request.getParameter("carnum");
        String parkdate = request.getParameter("parkdate");
        String cuname = request.getParameter("cuname");

        // DAO���g���Č������s��
        ParkingDAO parkingDAO = new ParkingDAO();
        List<Reservation> reservations = parkingDAO.searchByMultipleConditions(carnum, parkdate, cuname);

        // �������ʂ����N�G�X�g�ɃZ�b�g
        request.setAttribute("reservations", reservations);

        // ���ʂ�\������JSP�Ƀt�H���[�h
        request.getRequestDispatcher("WEB-INF/jsp/SearchResult.jsp").forward(request, response);
    }
}
