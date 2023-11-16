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
            var startDate, endDate;

            // カレンダーの初期化
            $('#calendar').fullCalendar({
                // カレンダーの設定
                selectable: true, // 日付選択を有効にする
                select: function(start, end, jsEvent, view) {
                    // カレンダーが選択されたときの処理
                    startDate = start;
                    endDate = end;
                    
                    alert('チェックイン: ' + startDate.format('YYYY-MM-DD') + '\nチェックアウト: ' + endDate.format('YYYY-MM-DD'));
                    
                    // ここで選択された日付を使った追加の処理を実行することができます
                }
            });
        });
    </script>
</head>
<body>
<form action="ReservServlet" method="post">
    <!-- 顧客ID入力フォーム -->
    顧客ID: <input type="text" name="customerID"><br>
    
    <!-- 車両番号入力フォーム -->
    車両番号: <input type="text" name="carNumber"><br>
        
    <!-- 予約ボタンと戻るボタン -->
    <input type="submit" name="button2" value="予約">
    
    <!-- カレンダー表示領域 -->
    <div id="calendar"></div><br>

</form>
<form action="Return" method="post">
    <input type="submit" name="button2" value="メインメニューへ戻る">
</form>
</body>
</html>
