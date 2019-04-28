<%--
  Created by IntelliJ IDEA.
  User: shmilyshirley
  Date: 2018-12-19
  Time: 15:44
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>notnull</title>
</head>
<script language="JavaScript" type="text/javascript">
    function GetDateStr(AddDayCount) {
        var dd = new Date();
        dd.setDate(dd.getDate()+AddDayCount);//获取AddDayCount天后的日期
        var y = dd.getFullYear();
        var m = dd.getMonth()+1;//获取当前月份的日期
        var d = dd.getDate();
        return y+"-"+m+"-"+d;
    }
    // document.write("前天："+GetDateStr(-2));
    // document.write("<br />今天："+GetDateStr(0));
    // document.write("<br />明天："+GetDateStr(1));
    // document.write("<br />后天："+GetDateStr(2));
    // document.write("<br />大后天："+GetDateStr(3));
    document.write("昨日："+GetDateStr(-1)+" 的记录已存在！！！");
</script>

<body>

</body>
</html>
