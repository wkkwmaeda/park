<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.util.List" %>
<%@ page import="model.Reservation" %>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Parking Search Results</title>
    <style>
        body {
            font-family: 'Arial', sans-serif;
            margin: 0;
            padding: 0;
            background-color: #f4f4f4;
        }
        header {
            background-color: #333;
            color: white;
            text-align: center;
            padding: 1em;
        }
        h1 {
            text-align: center;
            color: #333;
        }
        table {
            width: 80%;
            margin: 20px auto;
            border-collapse: collapse;
            background-color: white;
            box-shadow: 0 0 20px rgba(0, 0, 0, 0.1);
        }
        th, td {
            border: 1px solid #ddd;
            padding: 12px;
            text-align: center;
        }
        th {
            background-color: #333;
            color: white;
        }
        tr:nth-child(even) {
            background-color: #f9f9f9;
        }
        form {
            text-align: center;
            margin-top: 20px;
        }
        input[type="submit"] {
            background-color: #333;
            color: white;
            padding: 10px 20px;
            border: none;
            cursor: pointer;
            font-size: 16px;
        }
    </style>
</head>
<body>
    <header>
        <h1>Parking Search Results</h1>
    </header>

    <table>
        <!-- 表ヘッダ -->
        <tr>
            <th>ID</th>
            <th>Car Number</th>
            <th>Customer ID</th>
            <th>Name</th>
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
         <input type="submit" name="button1" value="戻る">
    </form>
