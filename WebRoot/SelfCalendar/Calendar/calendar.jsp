<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <meta charset="UTF-8">
    <link rel="stylesheet" type="text/css" href="SelfCalendar/Css/selfcalendar.css" />
    <script type="text/javascript" src="SelfCalendar/Js/selfcalendar.js"></script>
  </head>
  <body>
     <table id="superTable" style="background-color:white">
    <thead>
      <tr>
        <td align="left" colspan="2"><input type="button" class="lastYearCalendar" value="y-" style="width:30px"/><input type="button" class="lastCurrentCalendar" value="m-" style="width:30px"/></td>
        <td colspan="3" align="center"><span id="CalendarSpan"></span></td>
        <td align="right" colspan="2"><input type="button" class="nextYearCalendar" value="y+" style="width:30px"/><input type="button" class="nextCurrentCalendar" value="m+" style="width:30px"/></td>
      </tr>
    </thead>
    <tbody id="calendarbody">
      <tr>
        <td class="weekdayCalendar">Sun</td><td class="weekdayCalendar">Mon</td><td class="weekdayCalendar">Tue</td><td class="weekdayCalendar">Wed</td><td class="weekdayCalendar">Thu</td><td class="weekdayCalendar">Fri</td><td class="weekdayCalendar">Sat</td>
      </tr>
      <tr>
        <td colspan="7" align="right" id="btntd"><input type="hidden" id="dayCheck" value=""/><input type="hidden" value="" id="current_time"/><input type="button" value="确定" class="subOk" style="background-color:#CCF"><input type="button" class="subOk" value="取消"></td>
      </tr>
    </tbody>
    </table>
  </body>
</html>
