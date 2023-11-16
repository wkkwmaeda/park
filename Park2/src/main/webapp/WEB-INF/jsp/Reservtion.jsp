<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>予約フォーム</title>

    <!-- カレンダー表示のために追加 -->
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/fullcalendar/3.10.0/fullcalendar.min.css" />
    <script src="https://code.jquery.com/jquery-3.3.1.min.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/moment.js/2.22.2/moment.min.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/fullcalendar/3.10.0/fullcalendar.min.js"></script>

    <script>
        $(document).ready(function() {
            var startDate, endDate;
            var today = moment(); // 今日の日付

            // カレンダーの初期化
            $('#calendar').fullCalendar({
                selectable: true,
                validRange: {
                    start: today.format('YYYY-MM-DD'), // 今日以降の日付から選択可能
                },
                select: function(start, end, jsEvent, view) {
                    startDate = start;
                    endDate = end;

                    // カレンダーが選択された日付を隠しフィールドに設定
                    $('#checkInDate').val(startDate.format('YYYY-MM-DD'));
                    $('#checkOutDate').val(endDate.format('YYYY-MM-DD'));

                    alert('チェックイン: ' + startDate.format('YYYY-MM-DD') + '\nチェックアウト: ' + endDate.format('YYYY-MM-DD'));
                }
            });
        });
    </script>
</head>
<body>
<form id="reservationForm" action="ReservResultServlet" method="post">
    <!-- 名前入力フォーム -->
    名前: <input type="text" name="name" required><br>

    <!-- 電話番号入力フォーム -->
    電話番号: <input type="tel" name="tel" required><br>
    
    <!-- 車両番号入力フォーム -->
    車両番号: <input type="text" name="carNumber" required><br>
    
    <!-- カレンダー表示領域 -->
    <div id="calendar"></div><br>
    
    <!-- チェックイン日とチェックアウト日を保持する隠しフィールド -->
    <input type="hidden" id="checkInDate" name="checkInDate">
    <input type="hidden" id="checkOutDate" name="checkOutDate">
    
    <!-- 予約ボタンと戻るボタン -->
    <input type="submit" name="button2" value="予約">
</form>
<form action="Return" method="post">
    <input type="submit" name="button2" value="メインメニューへ戻る">
</form>
</body>
</html>
