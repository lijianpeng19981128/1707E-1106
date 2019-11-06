<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link href="/resources/css/css.css" rel="stylesheet">
<script type="text/javascript" src="/resources/js/jquery-1.8.2.min.js"></script>
<title>Insert title here</title>
</head>

<body>
<form action="list" method="post">
电影名<input type="text" name="mname">
上映时间<input type="date" name="startTime">
<input type="date" name="endTime"><br><br>
导演<input type="text" name="author">
价格<input type="text" name="minPrice">
<input type="text" name="maxPrice"><br><br>
年代<select name="year">
<option value="0">请选择</option>
<option value="2017">2017</option>
<option value="2018">2018</option>
<option value="2019">2019</option>
</select>
时长<input type="text" name="mintime">
<input type="text" name="maxtime"><br><br>
<input type="submit" value="查询">

<table>
<tr>
<td>
<input type="button" value="全选" onclick="qx()">
<input type="button" value="反选" onclick="fx()">
<input type="button" value="批删" onclick="ps()">
</td>
<td>电影名</td>
<td>导演</td>
<td>票价</td>
<td><a href="/list?method=${method=='asc'?'desc':'asc' }&name=start">上映时间</a></td>
<td><a href="/list?method=${method=='asc'?'desc':'asc' }&name=longtime">时长</a></td>
<td>类型</td>
<td><a href="/list?method=${method=='asc'?'desc':'asc' }&name=year">年代</a></td>
<td>区域</td>
<td>状态</td>
<td>操作</td>
</tr>

<c:forEach items="${pg.list }" var="l">
<tr>
<td><input type="checkbox" class="ck" value="${l.mid }"></td>
<td>${l.mname }</td>
<td>${l.author }</td>
<td>${l.price }</td>
<td>${l.start }</td>
<td>${l.longtime }</td>
<td>${l.kind }</td>
<td>${l.year }</td>
<td>${l.addr }</td>
<td>${l.type }</td>
<td><a href="/update?mid=${l.mid }&type=${l.type }"><input type="button" value="下架"></a>
</td>
</tr>
</c:forEach>
<tr>
<td colspan="100">
<button name="pageNum" value="1">首页</button>
<button name="pageNum" value="${pg.prePage==0?1:pg.prePage }">上一页</button>
<button name="pageNum" value="${pg.nextPage==0?pa.pages:pg.nextPage }">下一页</button>
<button name="pageNum" value="${pg.pages }">尾页</button>
</td>
</tr>
</table>
</form>
<script type="text/javascript">
function qx() {
	$(".ck").attr("checked",true);
}
function fx() {
	$(".ck").each(function() {
		this.checked=!this.checked;
	})
}
function ps() {
	var mids=[];
	 $(".ck:checked").each(function() {
		mids= this.value;
	});
	 alert("aa");
	$.post(
	  "delet",
	  {mids:mids},
	  function (msg) {
		if(msg>0){
			alert("删除成功");
			location="list";
		}else{
			alert("删除失败");
		}
	}
	
	)
}


</script>
</body>
</html>