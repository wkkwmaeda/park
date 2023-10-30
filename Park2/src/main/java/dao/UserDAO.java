package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UserDAO {
    // ���̃��\�b�h�ƃt�B�[���h
	
	private final static String url = "jdbc:mysql://localhost:65534/park?" + 
			"allowPublicKeyRetrieval=true&useSSL=false&characterEncoding=UTF-8&serverTimezone=JST";

	private final static String dbUser = "root";
	private final static String dbPassword = "";
    
    static {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            throw new RuntimeException("JDBC�h���C�o�[�̓ǂݍ��݂Ɏ��s���܂����B", e);
        }
    }


    public static boolean authenticateUser(String userID, String password) {
        // �f�[�^�x�[�X�ڑ����i�K�؂ɐݒ肵�Ă��������j
        
        // �f�[�^�x�[�X�ڑ��I�u�W�F�N�g
        Connection conn = null;
        // SQL�X�e�[�g�����g
        PreparedStatement stmt = null;
        // ���ʃZ�b�g
        ResultSet rs = null;

        try {
            // �f�[�^�x�[�X�ɐڑ�
            conn = DriverManager.getConnection(url, dbUser, dbPassword);

            // SQL�N�G�����쐬�i�e�[�u�����A�J�������͓K�؂ɕύX���Ă��������j
            String sql = "SELECT * FROM user WHERE user_id = ? AND password = ?";
            stmt = conn.prepareStatement(sql);
            stmt.setString(1, userID);
            stmt.setString(2, password);

            // �N�G�������s
            rs = stmt.executeQuery();

            // ���ʂ����݂���ꍇ�́A�F�ؐ����Ƃ݂Ȃ�
            if (rs.next()) {
                return true;
            }
        } catch (SQLException e) {
            // �G���[�n���h�����O
            e.printStackTrace();
        } finally {
            // ���\�[�X�̃N���[�Y
            try {
                if (rs != null) rs.close();
                if (stmt != null) stmt.close();
                if (conn != null) conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        return false; // �F�؎��s
    }
}
