<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>メニューー</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            background-color: #f4f4f4;
            margin: 0;
            padding: 0;
            display: flex;
            justify-content: center;
            align-items: center;
            height: 100vh;
        }
        .button-container {
            display: flex;
            flex-direction: column;
            align-items: center;
            margin-top: 20px;
        }
        .button-container form {
            margin-bottom: 15px;
        }
        .button-container input[type="submit"] {
            padding: 12px 25px;
            margin: 8px 0;
            background-color: #3498db;
            color: white;
            border: none;
            border-radius: 5px;
            cursor: pointer;
            transition: background-color 0.3s;
        }
        .button-container input[type="submit"]:hover {
            background-color: #2980b9;
        }
    </style>
</head>
<body>
    <div class="button-container">
        <form action="ReservServlet" method="post">
            <input type="submit" name="button1" value="予約">
        </form>
        <form action="ParkingStatusServlet" method="post">
            <input type="submit" name="button2" value="駐車場一覧">
        </form>
        <form action="index.jsp" method="post">
            <input type="submit" name="button3" value="ログアウト">
        </form>
    </div>
</body>
</html>
