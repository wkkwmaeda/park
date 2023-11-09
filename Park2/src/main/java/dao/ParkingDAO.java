package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.Reservation;

public class ParkingDAO {
    // ... (既存のコード)
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

    // reservationテーブルから全情報を取得するメソッド
    public List<Reservation> getAllReservations() {
        List<Reservation> reservations = new ArrayList<>();
        String query = "SELECT * FROM reservation";

        try (Connection connection = DriverManager.getConnection(JDBC_URL, DB_USER, DB_PASS);
             PreparedStatement preparedStatement = connection.prepareStatement(query);
             ResultSet resultSet = preparedStatement.executeQuery()) {

            while (resultSet.next()) {
                // テーブルから取得した情報をReservationオブジェクトにマッピングしてリストに追加
                int id = resultSet.getInt("id");
                String carnum = resultSet.getString("carnum");
                int cuid = resultSet.getInt("cuid");
                String parkdate = resultSet.getString("parkdate");
                // 他のカラムの取得も同様に行う

                // Reservationオブジェクトを生成してリストに追加
                Reservation reservation = new Reservation(id, carnum, cuid, parkdate);
                reservations.add(reservation);
            }
        } catch (SQLException e) {
            // エラーハンドリング
            e.printStackTrace(); // エラーの詳細を出力（実際のシステムでは適切なエラーハンドリングを行うこと）
        }

        return reservations;
    }
}
