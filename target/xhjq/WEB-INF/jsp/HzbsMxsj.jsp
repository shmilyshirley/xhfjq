<%--
  Created by IntelliJ IDEA.
  User: shmilyshirley
  Date: 2018-12-18
  Time: 16:27
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>HzbsMxsj</title>
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
    document.write(">>>>>>>>>>>> "+GetDateStr(-1)+" 的杭州办事明细数据记录插入成功 <<<<<<<<<<<<");
    document.write("<br/>    >>>>>>>>>>>>>>>>>>>>>「每天」插入一次即可 <<<<<<<<<<<<<<<<<<<<<    ");
</script>
<body>

</body>
</html>
