package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UserDAO {
	
	//�ڑ�
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

    public static boolean authenticateUser(String userID, String password) {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;

        try {
            conn = DriverManager.getConnection(JDBC_URL, DB_USER, DB_PASS);

            String sql = "SELECT * FROM user WHERE user_id = ? AND password = ?";
            stmt = conn.prepareStatement(sql);
            stmt.setString(1, userID);
            stmt.setString(2, password); // �n�b�V�������邱�Ƃ���������܂�

            rs = stmt.executeQuery();

            if (rs.next()) {
                return true;
            }
        } catch (SQLException e) {
            e.printStackTrace(); // �K�؂ȃG���[�n���h�����O��ǉ����邱�Ƃ��������Ă�������
        } finally {
            try {
                if (rs != null) rs.close();
                if (stmt != null) stmt.close();
                if (conn != null) conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        return false;
    }
}
