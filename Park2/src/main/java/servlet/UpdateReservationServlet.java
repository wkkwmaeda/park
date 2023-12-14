package servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.ParkingDAO;

import java.io.IOException;

@WebServlet("/UpdateReservationServlet")
public class UpdateReservationServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        try {
            // �t�H�[�����瑗�M���ꂽ�f�[�^���擾
            int reservationId = Integer.parseInt(request.getParameter("reservationId"));
            String carNumber = request.getParameter("carnum");
            String parkDate = request.getParameter("parkdate");

            // ParkingDAO�̃C���X�^���X���쐬
            ParkingDAO parkingDAO = new ParkingDAO();

            // editReservation���\�b�h���Ăяo���ăf�[�^�x�[�X���X�V
            parkingDAO.editReservation(reservationId, carNumber, parkDate);

            // �X�V��A���_�C���N�g�܂��͑��̏������s��
            request.getRequestDispatcher("WEB-INF/jsp/park.jsp").forward(request, response);
        } catch (Exception e) {
            e.printStackTrace();
            // �G���[�����������ꍇ�̏������s���Ă�������
            request.getRequestDispatcher("WEB-INF/jsp/error.jsp").forward(request, response);
        }
    }
}
