package servlet;


import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.ParkingDAO;
import model.Reservation;


@WebServlet("/SearchByParkdateServlet")

public class SearchByParkdateServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String Parkdate = request.getParameter("Parkdate"); // ���N�G�X�g����carnum���擾

        ParkingDAO dao = new ParkingDAO(); // ���Ȃ��̃f�[�^�A�N�Z�X�N���X���C���X�^���X��

        List<Reservation> searchResults = dao.searchByCarNum(carnum); // carnum�Ō���

        // �������ʂ����N�G�X�g�����ɃZ�b�g
        request.setAttribute("searchResults", searchResults);
        request.setAttribute("searchBy", "carnum"); // �������@�����ʂ��邽�߂̑�����ݒ�

        // JSP�Ƀt�H���[�h
        request.getRequestDispatcher("WEB-INF/jsp/SearchResult.jsp").forward(request, response);
    }
}
