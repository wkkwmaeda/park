<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Insert title here</title>

    <!-- カレンダー表示のために追加 -->
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/fullcalendar/3.10.0/fullcalendar.min.css" />
    <script src="https://code.jquery.com/jquery-3.3.1.min.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/moment.js/2.22.2/moment.min.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/fullcalendar/3.10.0/fullcalendar.min.js"></script>

    <script>
        $(document).ready(function() {
            // カレンダーの初期化
            $('#calendar').fullCalendar({
                // カレンダーの設定
                // ここに任意の設定を追加できます
            });
        });
    </script>
</head>
<body>
    <!-- 車両番号検索フォーム -->
    <form action="SearchByCarNumServlet" method="POST">
        Car Number: <input type="text" name="carnum">
    </form>

    <!-- 駐車日付検索フォーム -->
    <form action="SearchByParkdateServlet" method="POST">
        Park Date: <input type="text" name="parkdate">
    </form>

    <!-- カレンダー表示領域 -->
    <div id="calendar"></div>
</body>
</html>
