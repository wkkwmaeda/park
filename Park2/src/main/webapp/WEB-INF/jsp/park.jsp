<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.util.List" %>
<%@ page import="model.ParkingSpace" %>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>駐車場空き状況</title>
    <style>
        table {
            width: 80%;
            margin: auto;
            border-collapse: collapse;
        }

        th, td {
            padding: 10px;
            text-align: center;
        }

        th {
            background-color: #f2f2f2;
        }

        tr:nth-child(even) {
            background-color: #f2f2f2;
        }
    </style>
</head>
<body>
    <h1 style="text-align: center;">駐車場予約一覧</h1>
    <table>
        <tr>
            <th>顧客ID</th>
            <th>車番</th>
            
            <th>名前</th>
            <th>C/O日</th>
            <th>編集</th> <!-- 新たに追加 -->
        </tr>
        
        <c:forEach items="${parkingSpace}" var="space">
            <tr>
                
                <td>${space.carNumber}</td>
                
                <td>${space.name}</td>
                <td>${space.coDate}</td>
                <td>
                <a href="EditParkingStatusServlet?parkingNumber=${space.parkingNumber}">変更</a>
                <a href="EditParkingStatusServlet?parkingNumber=${space.parkingNumber}">取消</a>
                </td>
            </tr>
        </c:forEach>
    </table>
</body>
</html>
