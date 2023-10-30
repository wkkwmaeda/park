import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/park")
public class ParkServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // ���ԏ�̗��p�󋵂��擾���郍�W�b�N���Ăяo���iParkDB����f�[�^���擾����Ȃǁj
        List<String> parkingStatusList = getParkingStatus();

        // JSP�Ƀf�[�^��n��
        request.setAttribute("parkingStatusList", parkingStatusList);

        // park.jsp�Ƀt�H���[�h
        request.getRequestDispatcher("park.jsp").forward(request, response);
    }

    private List<String> getParkingStatus() {
        // ���ԏ�̗��p�󋵂��f�[�^�x�[�X����擾���郍�W�b�N����������
        // ���̗�ł͉��̃f�[�^���g�p����
        List<String> parkingStatusList = new ArrayList<>();
        parkingStatusList.add("��");
        parkingStatusList.add("���p��");
        // ���̒��ԏ�̏󋵂�ǉ�
        return parkingStatusList;
    }
    
}
