<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.util.List" %>
<%@ page import="model.ParkingSpace" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>駐車場状態編集</title>
</head>
<body>
    <h1>駐車場状態編集</h1>
    <form action="EditParkingStatusServlet" method="POST">
        <input type="hidden" name="parkingNumber" value="${parkingNumber}" />
        <label for="currentCarNumber">現在の車番:</label>
        <input type="text" name="newCarNumber" id="newCarNumber" value="${currentCarNumber}" />
        <br />
        <label for="newStatus">新しい状態:</label>
        <select name="newStatus" id="newStatus">
            <option value="Vacant" ${currentStatus == 'Vacant' ? 'selected' : ''}>Vacant</option>
            <option value="Occupied" ${currentStatus == 'Occupied' ? 'selected' : ''}>Occupied</option>
        </select>
        <br />
        <label for="newName">新しい名前:</label>
        <input type="text" name="newName" id="newName" value="${currentName}" />
        <br />
        <label for="newCoDate">新しいC/O日:</label>
        <input type="text" name="newCoDate" id="newCoDate" value="${currentCoDate}" />
        <br />
        <input type="submit" value="更新" />
    </form>
</body>
</html>
