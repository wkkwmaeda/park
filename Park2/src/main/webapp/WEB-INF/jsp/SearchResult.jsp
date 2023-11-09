<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.util.List" %>
<%@ page import="model.Reservation" %>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Parking Search Results</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            margin: 20px;
        }
        h1 {
            text-align: center;
        }
        table {
            width: 100%;
            border-collapse: collapse;
        }
        th, td {
            border: 1px solid #000;
            padding: 8px;
            text-align: center;
        }
        th {
            background-color: #f2f2f2;
        }
        tr:nth-child(even) {
            background-color: #f9f9f9;
        }
    </style>
</head>
<body>
    <h1>Parking Search Results</h1>

    <table>
        <!-- 表ヘッダ -->
        <tr>
            <th>ID</th>
            <th>Car Number</th>
            <th>Customer ID</th>
            <th>name</th>
            <th>Parking Date</th>
            <!-- 他のフィールドの表ヘッダ（必要に応じて追加） -->
        </tr>

        <!-- 検索結果表示 -->
        <c:forEach var="reservation" items="${searchResults}">
            <tr>
                <td>${reservation.reserv_id}</td>
                <td>${reservation.carnum}</td>
                <td>${reservation.cuid}</td>
                <td>${reservation.getCuname()}</td>
                <td>${reservation.parkdate}</td>
                <!-- 他のフィールドの情報表示（必要に応じて追加） -->
            </tr>
        </c:forEach>
    </table>
    <form action="ParkingStatusServlet" method="post">
            <input type="submit" name="button1" value="一覧へ戻る">
    </form>
</body>
</html>
