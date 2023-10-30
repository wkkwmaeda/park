package servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.ParkingDatabaseUtil;
import model.ParkingSpace;

@WebServlet("/EditParkingStatusServlet")
public class EditParkingStatusServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    int parkingNumber;
    
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // URL �p�����[�^���璓�ԏ�ԍ����擾
        int parkingNumber = Integer.parseInt(request.getParameter("parkingNumber"));

        // ���ԏ�ԍ����猻�݂̏�Ԃ��f�[�^�x�[�X����擾
        ParkingSpace currentParkingSpace = ParkingDatabaseUtil.getParkingSpaceInfo(parkingNumber);

        // �擾������Ԃ����N�G�X�g�����ɐݒ�
        request.setAttribute("parkingNumber", currentParkingSpace.getParkingNumber());
        request.setAttribute("currentCarNumber", currentParkingSpace.getCarNumber());
        request.setAttribute("currentStatus", currentParkingSpace.getStatus());
        request.setAttribute("currentName", currentParkingSpace.getName());
        request.setAttribute("currentCoDate", currentParkingSpace.getCoDate());

        // Edit.jsp �Ƀt�H���[�h
        request.getRequestDispatcher("/WEB-INF/jsp/Edit.jsp").forward(request, response);
        
        
    }
    
    

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // �t�H�[�����瑗�M���ꂽ�f�[�^���擾
		/*
		 * if (parkingNumberParam == null || parkingNumberParam.isEmpty()) { //
		 * �p�����[�^����̏ꍇ�A�G���[���b�Z�[�W��ݒ肵�A�G���[�y�[�W�Ƀt�H���[�h request.setAttribute("errorMessage",
		 * "���ԏ�ԍ����w�肳��Ă��܂���B");
		 * request.getRequestDispatcher("WEB-INF/jsp/error.jsp").forward(request,
		 * response); return; }
		 */
    	
    	request.setCharacterEncoding("UTF-8");

        int parkingNumber = Integer.parseInt(request.getParameter("parkingNumber"));
        String newCarNumber = request.getParameter("newCarNumber");
        String newStatus = request.getParameter("newStatus");
        String newName = request.getParameter("newName");
        String newCoDate = request.getParameter("newCoDate");

        // ���ԏ�̏�Ԃ��X�V���� DAO ���\�b�h���Ăяo��
        boolean isSuccess = ParkingDatabaseUtil.editParkingSpaceStatus(parkingNumber, newCarNumber, newStatus, newName, newCoDate);

        if (isSuccess) {
            // �X�V�����������ꍇ�̏���
            response.sendRedirect("WEB-INF/jsp/park.jsp"); // �X�V��̃y�[�W�Ƀ��_�C���N�g
        } else {
            // �X�V�����s�����ꍇ�̏���
            // �G���[���b�Z�[�W���Z�b�g���ăG���[�y�[�W�Ƀt�H���[�h����Ȃǂ̏�����ǉ�
        }
    }
}