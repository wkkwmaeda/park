<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.util.List" %>
<%@ page import="model.ParkingSpace" %>


<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Parking Status</title>
</head>
<body>
    <h1>Parking Reservations</h1>
    <table border="1">
        <tr>
            <th>ID</th>
            <th>Car Number</th>
            <th>Customer ID</th>
            <th>Parking Date</th>
            <!-- Add other table headers for additional fields if present -->
        </tr>
        <c:forEach var="reservation" items="${reservations}">
            <tr>
                <td>${reservation.reserv_id}</td>
                <td>${reservation.carnum}</td>
                <td>${reservation.cuid}</td>
                <td>${reservation.parkdate}</td>
                <!-- Add additional table data for other fields if present -->
            </tr>
        </c:forEach>
    </table>
</body>
