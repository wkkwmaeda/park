package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ParkingDAO {
	// データベースへの接続情報
    private static final String DRIVER_NAME = "com.mysql.cj.jdbc.Driver";
    private static final String JDBC_URL = "jdbc:mysql://localhost:65534/parking?useSSL=false&characterEncoding=UTF-8&serverTimezone=JST";
    private static final String DB_USER = "root";
    private static final String DB_PASS = "pass";

    static {
        try {
            Class.forName(DRIVER_NAME);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException("JDBCドライバーの読み込みに失敗しました。", e);
        }
    }

    // ユーザーの認証を行うメソッド
    public static boolean authenticateUser(String customerID, String carNumber) {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;

        try {
            conn = DriverManager.getConnection(JDBC_URL, DB_USER, DB_PASS);

            // データベースに対するクエリ作成
            String sql = "SELECT * FROM customer WHERE cuid = ? AND carnum = ?";
            stmt = conn.prepareStatement(sql);
            stmt.setString(1, customerID);
            stmt.setString(2, carNumber);

            rs = stmt.executeQuery();

            if (rs.next()) {
                return true; // ユーザーが見つかった場合はtrueを返す
            }
        } catch (SQLException e) {
            e.printStackTrace(); // エラーを出力
        } finally {
            try {
                if (rs != null) rs.close();
                if (stmt != null) stmt.close();
                if (conn != null) conn.close();
            } catch (SQLException e) {
                e.printStackTrace(); // エラーを出力
            }
        }

        return false; // ユーザーが見つからなかった場合はfalseを返す
    }
}
