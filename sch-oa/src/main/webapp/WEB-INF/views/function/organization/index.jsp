<%@ page language="java" contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
  <head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    
    <title>组织管理</title>
    
	<meta name="viewport" content="width=device-width, initial-scale=1.0" />
	<script src="${pageContext.request.contextPath}/static/js/ext/ext-all.js"></script>
	<script src="${pageContext.request.contextPath}/static/js/ext/ext-debug-w-comments.js"></script>
	<script src="${pageContext.request.contextPath}/static/js/ext/ext-debug.js"></script>
	<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/respirces/css/ext-all.css" />
	<script type="text/javascript">
			var str = "${result}";
			var data = eval("(" + str + ")");
			alert(str);
			var pageNo =  "${pageNo}";  
			var pageTotal = "${pageTotal}";
			var pageSize = "${pageSize}";
			var total = "${total}";			
	</script>
	<script src="index.js"></script>
  </head>
  
  <body>
    	<div id="searchPanel"></div>
		<div id="grid"></div>
  </body>
</html>
