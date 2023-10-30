package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UserDAO {
    // 他のメソッドとフィールド
	
	private final static String url = "jdbc:mysql://localhost:65534/park?" + 
			"allowPublicKeyRetrieval=true&useSSL=false&characterEncoding=UTF-8&serverTimezone=JST";

	private final static String dbUser = "root";
	private final static String dbPassword = "";
    
    static {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            throw new RuntimeException("JDBCドライバーの読み込みに失敗しました。", e);
        }
    }


    public static boolean authenticateUser(String userID, String password) {
        // データベース接続情報（適切に設定してください）
        
        // データベース接続オブジェクト
        Connection conn = null;
        // SQLステートメント
        PreparedStatement stmt = null;
        // 結果セット
        ResultSet rs = null;

        try {
            // データベースに接続
            conn = DriverManager.getConnection(url, dbUser, dbPassword);

            // SQLクエリを作成（テーブル名、カラム名は適切に変更してください）
            String sql = "SELECT * FROM user WHERE user_id = ? AND password = ?";
            stmt = conn.prepareStatement(sql);
            stmt.setString(1, userID);
            stmt.setString(2, password);

            // クエリを実行
            rs = stmt.executeQuery();

            // 結果が存在する場合は、認証成功とみなす
            if (rs.next()) {
                return true;
            }
        } catch (SQLException e) {
            // エラーハンドリング
            e.printStackTrace();
        } finally {
            // リソースのクローズ
            try {
                if (rs != null) rs.close();
                if (stmt != null) stmt.close();
                if (conn != null) conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        return false; // 認証失敗
    }
}
