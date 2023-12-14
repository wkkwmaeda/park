<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.util.List"%>
<%@ page import="model.Reservation"%>

<!-- 以下は必要に応じて追加のimport文を追加してください -->

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Edit Reservation</title>
</head>
<body>

<h1>Edit Reservation</h1>

<form action="UpdateReservationServlet" method="post">
    <input type="hidden" name="reservationId" value="${param.reservationId}">

    <!-- 予約情報の編集フォーム -->
    <!-- 必要なフォーム項目（Car Number、Customer ID、Name、Parking Dateなど）を適宜追加 -->
    Car Number: <input type="text" name="carnum" value="${reservation.carnum}">
    Customer ID: <input type="text" name="cuid" value="${reservation.cuid}">
    Name: <input type="text" name="cuname" value="${reservation.getCuname()}">
    Parking Date: <input type="text" name="parkdate" value="${reservation.parkdate}">

    <input type="submit" value="更新">
</form>

</body>
</html>
