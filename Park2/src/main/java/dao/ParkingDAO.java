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
    public static String[] authenticateUser(String customerID, String carNumber) {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        String[] userInfo = new String[2]; // ユーザー情報を保持する配列

        try {
            conn = DriverManager.getConnection(JDBC_URL, DB_USER, DB_PASS);

            // データベースに対するクエリ作成
            String sql = "SELECT cuid, carnum FROM customer WHERE cuid = ? AND carnum = ?";
            stmt = conn.prepareStatement(sql);
            stmt.setString(1, customerID);
            stmt.setString(2, carNumber);

            rs = stmt.executeQuery();

            if (rs.next()) {
                // ユーザーが見つかった場合はユーザー情報を配列に格納して返す
                userInfo[0] = rs.getString("cuid"); // customerIdを取得してuserInfo[0]に格納
                userInfo[1] = rs.getString("carnum"); // carNumberを取得してuserInfo[1]に格納
                return userInfo;
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

        return null; // ユーザーが見つからなかった場合はnullを返す
    }
}