package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ParkingDAO {
    // �f�[�^�x�[�X�ւ̐ڑ����
    private static final String DRIVER_NAME = "com.mysql.cj.jdbc.Driver";
    private static final String JDBC_URL = "jdbc:mysql://localhost:65534/parking?useSSL=false&characterEncoding=UTF-8&serverTimezone=JST";
    private static final String DB_USER = "root";
    private static final String DB_PASS = "pass";

    static {
        try {
            Class.forName(DRIVER_NAME);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException("JDBC�h���C�o�[�̓ǂݍ��݂Ɏ��s���܂����B", e);
        }
    }

    // ���[�U�[�̔F�؂��s�����\�b�h
    public static String[] authenticateUser(String customerID, String carNumber) {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        String[] userInfo = new String[2]; // ���[�U�[����ێ�����z��

        try {
            conn = DriverManager.getConnection(JDBC_URL, DB_USER, DB_PASS);

            // �f�[�^�x�[�X�ɑ΂���N�G���쐬
            String sql = "SELECT cuid, carnum FROM customer WHERE cuid = ? AND carnum = ?";
            stmt = conn.prepareStatement(sql);
            stmt.setString(1, customerID);
            stmt.setString(2, carNumber);

            rs = stmt.executeQuery();

            if (rs.next()) {
                // ���[�U�[�����������ꍇ�̓��[�U�[����z��Ɋi�[���ĕԂ�
                userInfo[0] = rs.getString("cuid"); // customerId���擾����userInfo[0]�Ɋi�[
                userInfo[1] = rs.getString("carnum"); // carNumber���擾����userInfo[1]�Ɋi�[
                return userInfo;
            }
        } catch (SQLException e) {
            e.printStackTrace(); // �G���[���o��
        } finally {
            try {
                if (rs != null) rs.close();
                if (stmt != null) stmt.close();
                if (conn != null) conn.close();
            } catch (SQLException e) {
                e.printStackTrace(); // �G���[���o��
            }
        }

        return null; // ���[�U�[��������Ȃ������ꍇ��null��Ԃ�
    }
}