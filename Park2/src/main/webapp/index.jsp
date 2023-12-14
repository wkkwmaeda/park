<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.util.List"%>
<%@ page import="model.Reservation"%>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>ログイン</title>
    <style>
        body {
            text-align: center;
            margin: 0;
            padding: 0;
            font-family: Arial, sans-serif;
            background-color: #f4f4f4;
        }
        
        h1 {
            font-size: 28px;
            margin-top: 30px;
            color: #0074cc;
        }

        form {
            display: inline-block;
            text-align: left;
            border: 1px solid #ccc;
            padding: 30px;
            border-radius: 10px;
            width: 300px;
            margin: 30px auto;
            background-color: #fff;
        }

        label {
            display: block;
            margin-top: 10px;
            font-size: 18px;
            color: #333;
        }

        input[type="text"],
        input[type="password"] {
            width: calc(100% - 22px);
            padding: 10px;
            font-size: 16px;
            border: 1px solid #ccc;
            border-radius: 5px;
            margin-bottom: 10px;
        }

        input[type="submit"] {
            background-color: #0074cc;
            color: white;
            padding: 10px 20px;
            margin: 10px auto;
            font-size: 18px;
            border: none;
            border-radius: 5px;
            cursor: pointer;
            display: block;
        }

        .header {
            background: #87ceeb;
            color: white;
            padding: 20px 0;
            margin-bottom: 20px;
        }

        .header h1 {
            margin: 0;
            font-size: 28px;
            font-weight: lighter; 
            color: black;
        }
    </style>
</head>
<body>
    <div class="header">
        <h1>駐車場予約システム</h1>
    </div>
    <form action="LoginServlet" method="POST">
        <label for="userID">従業員ID</label>
        <input type="text" name="userID" id="userID" required />
        <br />
        <label for="password">パスワード</label>
        <input type="password" name="password" id="password" required />
        <br />
        <input type="submit" value="ログイン" />
    </form>
</body>
</html>
