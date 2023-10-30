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
    // データベース接続情報
	private final static String JDBC_URL =
			"jdbc:mysql://localhost:65534/park?" + 
					"allowPublicKeyRetrieval=true&useSSL=false&characterEncoding=UTF-8&serverTimezone=JST";

			
	private final static String DB_USER = "root";
	private final static String DB_PASS = "";

    // ドライバーのロード
    static {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            throw new RuntimeException("JDBCドライバーの読み込みに失敗しました。", e);
        }
    }

    // 駐車場の空き状況を取得するメソッド
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
            throw new RuntimeException("データベースからの情報取得中にエラーが発生しました。", e);
        }

        return parkingSpaceList;
    }
    
    
    public static boolean editParkingSpaceStatus(int parkingNumber, String newCarNumber, String newStatus, String newName, String newCoDate) {
        try (Connection conn = DriverManager.getConnection(JDBC_URL, DB_USER, DB_PASS)) {
            String sql = "UPDATE park SET car_number = ?, status = ?, name = ?, co_date = ? WHERE parking_number = ?";
            PreparedStatement pstmt = conn.prepareStatement(sql);

            // プレースホルダに値を設定
            pstmt.setString(1, newCarNumber);
            pstmt.setString(2, newStatus);
            pstmt.setString(3, newName);
            pstmt.setString(4, newCoDate);
            pstmt.setInt(5, parkingNumber);

            // クエリを実行
            int updatedRows = pstmt.executeUpdate();

            // 更新された行数が1であれば成功
            return updatedRows == 1;
        } catch (SQLException e) {
            e.printStackTrace();
            // エラーハンドリング - 例外が発生した場合の処理を追加します
            return false;
        }
    }
    public static ParkingSpace getParkingSpaceInfo(int parkingNumber) {
        ParkingSpace parkingSpace = null;
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;

        try {
            // データベースへの接続
            conn = DriverManager.getConnection(JDBC_URL, DB_USER, DB_PASS);

            // SQLクエリの準備
            String sql = "SELECT car_number, status, name, co_date FROM park WHERE parking_number = ?";
            pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, parkingNumber);

            // クエリの実行
            rs = pstmt.executeQuery();

            // 結果の取得
            if (rs.next()) {
                String carNumber = rs.getString("car_number");
                String status = rs.getString("status");
                String name = rs.getString("name");
                String coDate = rs.getString("co_date");

                // ParkingSpaceオブジェクトに設定
                parkingSpace = new ParkingSpace(parkingNumber, carNumber, status, name, coDate);
            }
        } catch (SQLException e) {
            // エラーハンドリング - データベースからのデータ取得中にエラーが発生した場合の処理を追加
            e.printStackTrace();
        } finally {
            // リソースのクローズ
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
