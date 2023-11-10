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

        // ...（他の既存のコードはそのまま）
        
        public List<Reservation> getAllReservations() {
            List<Reservation> reservations = new ArrayList<>();
            String query = "SELECT * FROM reservation";

            try (Connection connection = DriverManager.getConnection(JDBC_URL, DB_USER, DB_PASS);
                 PreparedStatement preparedStatement = connection.prepareStatement(query);
                 ResultSet resultSet = preparedStatement.executeQuery()) {

                while (resultSet.next()) {
                    int reserv_id = resultSet.getInt("reserv_id");
                    String carnum = resultSet.getString("carnum");
                    int cuid = resultSet.getInt("cuid");
                    String parkdate = resultSet.getString("parkdate");

                    String cuname = getCustomerNameById(cuid, connection); // 顧客名を取得

                    // 予約オブジェクトを生成し、顧客名を設定
                    Reservation reservation = new Reservation(reserv_id, carnum, cuid, cuname, parkdate);
                    reservations.add(reservation);
                }
            } catch (SQLException e) {
                e.printStackTrace(); // 適切なエラーハンドリングが必要です
            }

            return reservations;
        }

        // 顧客IDに基づいて顧客名を取得するメソッド
        private String getCustomerNameById(int cuid, Connection connection) {
            String cuname = "";
            String customerQuery = "SELECT cuname FROM customer WHERE cuid = ?";
            try (PreparedStatement customerStatement = connection.prepareStatement(customerQuery)) {
                customerStatement.setInt(1, cuid);
                ResultSet customerResult = customerStatement.executeQuery();

                if (customerResult.next()) {
                    cuname = customerResult.getString("cuname");
                }
            } catch (SQLException e) {
                e.printStackTrace(); // 適切なエラーハンドリングが必要です
            }
            return cuname;
        } 
        
        
        public List<Reservation> searchByCarNum(String carnum) {
            List<Reservation> reservations = new ArrayList<>();
            try (Connection connection = DriverManager.getConnection(JDBC_URL, DB_USER, DB_PASS)) {
                String query = "SELECT * FROM reservation WHERE carnum = ?";
                try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
                    preparedStatement.setString(1, carnum);

                    try (ResultSet resultSet = preparedStatement.executeQuery()) {
                        while (resultSet.next()) {
                            int reserv_id = resultSet.getInt("reserv_id");
                            String carNumber = resultSet.getString("carnum");
                            int customerId = resultSet.getInt("cuid");
                            String parkDate = resultSet.getString("parkdate");
                            String customerName = getCustomerNameById(customerId, connection); // 顧客名を取得
                            Reservation reservation = new Reservation(reserv_id, carNumber, customerId, customerName, parkDate);
                            reservations.add(reservation);
                        }
                    }
                }
            } catch (SQLException e) {
                e.printStackTrace(); // 適切なエラーハンドリングを行ってください
            }
            return reservations;
        }
        
        public List<Reservation> searchByParkdate(String parkdate) {
            List<Reservation> reservations = new ArrayList<>();
            try (Connection connection = DriverManager.getConnection(JDBC_URL, DB_USER, DB_PASS)) {
                String query = "SELECT * FROM reservation WHERE carnum = ?";
                try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
                    preparedStatement.setString(1, parkdate);

                    try (ResultSet resultSet = preparedStatement.executeQuery()) {
                        while (resultSet.next()) {
                            int reserv_id = resultSet.getInt("reserv_id");
                            String carNumber = resultSet.getString("carnum");
                            int customerId = resultSet.getInt("cuid");
                            String parkDate = resultSet.getString("parkdate");
                            String customerName = getCustomerNameById(customerId, connection); // 顧客名を取得
                            Reservation reservation = new Reservation(reserv_id, carNumber, customerId, customerName, parkDate);
                            reservations.add(reservation);
                        }
                    }
                }
            } catch (SQLException e) {
                e.printStackTrace(); // 適切なエラーハンドリングを行ってください
            }
            return reservations;
        }
        
        public List<Reservation> searchByName(String cuname) {
            List<Reservation> reservations = new ArrayList<>();
            try (Connection connection = DriverManager.getConnection(JDBC_URL, DB_USER, DB_PASS)) {
                String query = "SELECT * FROM reservation WHERE carnum = ?";
                try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
                    preparedStatement.setString(1, cuname);

                    try (ResultSet resultSet = preparedStatement.executeQuery()) {
                        while (resultSet.next()) {
                            int reserv_id = resultSet.getInt("reserv_id");
                            String carNumber = resultSet.getString("carnum");
                            int customerId = resultSet.getInt("cuid");
                            String parkDate = resultSet.getString("parkdate");
                            String customerName = getCustomerNameById(customerId, connection); // 顧客名を取得
                            Reservation reservation = new Reservation(reserv_id, carNumber, customerId, customerName, parkDate);
                            reservations.add(reservation);
                        }
                    }
                }
            } catch (SQLException e) {
                e.printStackTrace(); // 適切なエラーハンドリングを行ってください
            }
            return reservations;
        }

    }



      

