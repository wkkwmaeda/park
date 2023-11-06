<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html><html>
<head>
<meta charset="UTF-8">
<title>メニュー</title>
<style>
    .button-container {
        display: flex;
        flex-direction: column; /* ボタンを垂直に配置  */
        align-items: center; /* ボタンを中央に配置 */
        margin-top: 20px; /* 適宜調整 */
    }
    .button-container input[type="submit"] {
        padding: 15px 30px; /* ボタンのパディングを調整して大きくする */
        margin: 10px 0; /* ボタン間の間隔を調整 */
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
