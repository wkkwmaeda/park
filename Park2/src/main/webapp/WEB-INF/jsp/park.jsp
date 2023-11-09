<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.util.List" %>
<%@ page import="model.ParkingSpace" %>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Parking Status</title>
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
    <h1>Parking Reservations</h1>
    <table>
        <tr>
            <th>ID</th>
            <th>Car Number</th>
            <th>Customer ID</th>
            <th>name</th>
            <th>Parking Date</th>
            <!-- Add other table headers for additional fields if present -->
        </tr>
        <c:forEach var="reservation" items="${reservations}">
            <tr>
                <td>${reservation.reserv_id}</td>
                <td>${reservation.carnum}</td>
                <td>${reservation.cuid}</td>
                <td>${reservation.getCuname()}</td>
                <td>${reservation.parkdate}</td>
                <!-- Add additional table data for other fields if present -->
            </tr>
        </c:forEach>
    </table>
</body>
</html>
