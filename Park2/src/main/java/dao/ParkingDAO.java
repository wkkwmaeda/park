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
                // ���̃J�����̎擾�����l�ɍs��

                // Reservation�I�u�W�F�N�g�𐶐����ă��X�g�ɒǉ�
                Reservation reservation = new Reservation(id /*, ���̃J�����̒l */);
                reservations.add(reservation);
            }
        } catch (SQLException e) {
            // �G���[�n���h�����O
            e.printStackTrace(); // �G���[�̏ڍׂ��o�́i���ۂ̃V�X�e���ł͓K�؂ȃG���[�n���h�����O���s�����Ɓj
        }

        return reservations;
    }
}
