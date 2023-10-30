package dao;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.ParkingSpace;

public class ParkingDatabaseUtil {
    // �f�[�^�x�[�X�ڑ����
	private final static String JDBC_URL =
			"jdbc:mysql://localhost:65534/park?" + 
					"allowPublicKeyRetrieval=true&useSSL=false&characterEncoding=UTF-8&serverTimezone=JST";

			
	private final static String DB_USER = "root";
	private final static String DB_PASS = "";

    // �h���C�o�[�̃��[�h
    static {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            throw new RuntimeException("JDBC�h���C�o�[�̓ǂݍ��݂Ɏ��s���܂����B", e);
        }
    }

    // ���ԏ�̋󂫏󋵂��擾���郁�\�b�h
    public static List<ParkingSpace> getParkingStatus() {
        List<ParkingSpace> parkingSpaceList = new ArrayList<>();

        try (Connection conn = DriverManager.getConnection(JDBC_URL, DB_USER, DB_PASS);
             PreparedStatement pstmt = conn.prepareStatement("SELECT * FROM park")) {

            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                int parkingNumber = rs.getInt("parking_number");
                String carNumber = rs.getString("car_number");
                String status = rs.getString("status");
                String name = rs.getString("name");
                String coDate = rs.getString("co_date");
                parkingSpaceList.add(new ParkingSpace(parkingNumber, carNumber, status, name, coDate));
            }
        } catch (SQLException e) {
            throw new RuntimeException("�f�[�^�x�[�X����̏��擾���ɃG���[���������܂����B", e);
        }

        return parkingSpaceList;
    }
    
    
    public static boolean editParkingSpaceStatus(int parkingNumber, String newCarNumber, String newStatus, String newName, String newCoDate) {
        try (Connection conn = DriverManager.getConnection(JDBC_URL, DB_USER, DB_PASS)) {
            String sql = "UPDATE park SET car_number = ?, status = ?, name = ?, co_date = ? WHERE parking_number = ?";
            PreparedStatement pstmt = conn.prepareStatement(sql);

            // �v���[�X�z���_�ɒl��ݒ�
            pstmt.setString(1, newCarNumber);
            pstmt.setString(2, newStatus);
            pstmt.setString(3, newName);
            pstmt.setString(4, newCoDate);
            pstmt.setInt(5, parkingNumber);

            // �N�G�������s
            int updatedRows = pstmt.executeUpdate();

            // �X�V���ꂽ�s����1�ł���ΐ���
            return updatedRows == 1;
        } catch (SQLException e) {
            e.printStackTrace();
            // �G���[�n���h�����O - ��O�����������ꍇ�̏�����ǉ����܂�
            return false;
        }
    }
    public static ParkingSpace getParkingSpaceInfo(int parkingNumber) {
        ParkingSpace parkingSpace = null;
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;

        try {
            // �f�[�^�x�[�X�ւ̐ڑ�
            conn = DriverManager.getConnection(JDBC_URL, DB_USER, DB_PASS);

            // SQL�N�G���̏���
            String sql = "SELECT car_number, status, name, co_date FROM park WHERE parking_number = ?";
            pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, parkingNumber);

            // �N�G���̎��s
            rs = pstmt.executeQuery();

            // ���ʂ̎擾
            if (rs.next()) {
                String carNumber = rs.getString("car_number");
                String status = rs.getString("status");
                String name = rs.getString("name");
                String coDate = rs.getString("co_date");

                // ParkingSpace�I�u�W�F�N�g�ɐݒ�
                parkingSpace = new ParkingSpace(parkingNumber, carNumber, status, name, coDate);
            }
        } catch (SQLException e) {
            // �G���[�n���h�����O - �f�[�^�x�[�X����̃f�[�^�擾���ɃG���[�����������ꍇ�̏�����ǉ�
            e.printStackTrace();
        } finally {
            // ���\�[�X�̃N���[�Y
            try {
                if (rs != null) rs.close();
                if (pstmt != null) pstmt.close();
                if (conn != null) conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        return parkingSpace;
    }








}
