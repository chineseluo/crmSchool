<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>收费报表</title>
<%@include file="common.jsp" %>
	<script type="text/javascript" src="/static/Hchart/highcharts.js"></script>
	<script type="text/javascript" src="/static/Hchart/highcharts-3d.js"></script>
<script type="text/javascript" src="/static/js/views/chargeChart.js"></script>
</head>
<body>
	<!-- 数据表格 -->
	<table id="chargeChart_datagrid">

	</table>


	<!-- 数据表格CRUD按钮 -->
	<div id="chargeChart_datagrid_tb">
		<div>

			日期:<input name="qo.beginDate" class="easyui-datebox" />
			---<input name="qo.endDate" class="easyui-datebox" />
			分组类型:
			<select id="grouping" class="easyui-combobox" name="groupbyCon" style="width:130px;" >
				<option value="1">按销售人员分</option>
				<option value="2">按学科分</option>
				<option value="3">按年分</option>
				<option value="4">按月分</option>
			</select>
			<a class="easyui-linkbutton" id="searchBtn" >快查</a>




			<%--<a class="easyui-linkbutton" id="barHighChart" iconCls="icon-select"  >柱状图报表</a>--%>
			<%--<a class="easyui-linkbutton" id="pieHighChart" iconCls="icon-select"  >饼状图报表</a>--%>

		</div>
		</div>
	</div>
</body>
</html>