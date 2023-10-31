<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>ログインペテン師maeda</title>
    <style>
        body {
            text-align: center;
        }
        
        h1 {
            font-size: 24px;
        }

        form {
            display: inline-block;
            text-align: left;
            border: 1px solid #ccc;
            padding: 20px;
            border-radius: 10px;
            width: 300px;
            margin: 0 auto;
        }

        label {
            display: block;
            margin-top: 10px;
            font-size: 18px;
        }

        input[type="text"],
        input[type="password"] {
            width: 95%;
            padding: 10px;
            font-size: 16px;
            border: 1px solid #ccc;
            border-radius: 5px;
        }

        input[type="submit"] {
            background-color: #0074cc;
            color: white;
            padding: 10px 20px;
            margin: 10px;
            font-size: 18px;
            border: none;
            border-radius: 5px;
            
            cursor: pointer;
        }
    </style>
</head>
<body>
    <h1>駐車場予約システムtinko</h1>
    <form action="LoginServlet" method="POST">
        <label for="userID">従業員ID:</label>
        <input type="text" name="userID" id="userID" required />
        <br />
        <label for="password">パスワード:</label>
        <input type="password" name="password" id="password" required />
        <br />
        <input type="submit" value="ログイン" />
    </form>
</body>
</html>
