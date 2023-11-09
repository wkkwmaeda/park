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
    // ... (�����̃R�[�h)
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

    // reservation�e�[�u������S�����擾���郁�\�b�h
    public List<Reservation> getAllReservations() {
        List<Reservation> reservations = new ArrayList<>();
        String query = "SELECT * FROM reservation";

        try (Connection connection = DriverManager.getConnection(JDBC_URL, DB_USER, DB_PASS);
             PreparedStatement preparedStatement = connection.prepareStatement(query);
             ResultSet resultSet = preparedStatement.executeQuery()) {

            while (resultSet.next()) {
                // �e�[�u������擾��������Reservation�I�u�W�F�N�g�Ƀ}�b�s���O���ă��X�g�ɒǉ�
                int id = resultSet.getInt("id");
                String carnum = resultSet.getString("carnum");
                int cuid = resultSet.getInt("cuid");
                String parkdate = resultSet.getString("parkdate");
                // ���̃J�����̎擾�����l�ɍs��

                // Reservation�I�u�W�F�N�g�𐶐����ă��X�g�ɒǉ�
                Reservation reservation = new Reservation(id, carnum, cuid, parkdate);
                reservations.add(reservation);
            }
        } catch (SQLException e) {
            // �G���[�n���h�����O
            e.printStackTrace(); // �G���[�̏ڍׂ��o�́i���ۂ̃V�X�e���ł͓K�؂ȃG���[�n���h�����O���s�����Ɓj
        }

        return reservations;
    }
}
