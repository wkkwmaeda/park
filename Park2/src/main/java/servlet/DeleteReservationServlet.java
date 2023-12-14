package servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.ParkingDAO;

@WebServlet("/DeleteReservationServlet")
public class DeleteReservationServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // �폜�{�^�����N���b�N���ꂽ�s��ID���擾
        int reservationId = Integer.parseInt(request.getParameter("reservationId"));

        // DAO���g���ăf�[�^�x�[�X����폜
        ParkingDAO parkingDAO = new ParkingDAO();
        parkingDAO.deleteReservation(reservationId);

        // �폜��A���_�C���N�g�܂��͑��̏������s��
        RequestDispatcher dispatcher = request.getRequestDispatcher("WEB-INF/jsp/deleteResult.jsp");
        dispatcher.forward(request, response);
    }
}
