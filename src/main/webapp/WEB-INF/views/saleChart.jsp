<%@ page contentType="text/html; charset=UTF-8" language="java" %>
<html>
<head>
    <title>工资管理</title>
    <%@include file="common.jsp"%>
    <script type="text/javascript" src="/static/js/views/saleChart.js"></script>
</head>
<body>
    <table id="saleChart_datagrid"></table>
    <div id="saleChart_dialog">
        <form id="saleChart_form" method="post">
            <input type="hidden" name="id">
            <div align="center" style="margin-top: 10px">
                <tr>
                    <td>
                        <select  name="realname" class="easyui-combobox"
                                 data-options="
						 width:150,
						 label:'所有员工:',
						 labelPosition:'top',
						 valueField:'id',
						 textField:'realname',
						 url:'/employee/payList'
						">
                        </select>

                    </td>
                    <td>
                        <input type="date" name="saleDate" class="easyui-datebox" data-options="label:'日期:',labelPosition:'top', width:150">
                    </td>
                </tr>

        <tr>
            <td>
                <select  name="dept.id" class="easyui-combobox"
                         data-options="
						 width:150,
						 label:'所属部门:',
						 labelPosition:'top',
						 valueField:'id',
						 textField:'name',
						 url:'/department/selectListForEmployeeForm'
						">
                </select>
            </td>
            <td><input type="text" name="livesubsidy" class="easyui-textbox" data-options="label:'补贴:',labelPosition:'top', width:150"></td>
        </tr>
        <tr>
            <td><input type="text" name="workday" class="easyui-textbox" data-options="label:'工作时间:',labelPosition:'top', width:150"></td>
            <td><input type="text" name="totalworkday" class="easyui-textbox" data-options="label:'全勤:',labelPosition:'top', width:150"></td>
        </tr>
        <tr>
            <td><input type="text" name="socialsecurity" class="easyui-textbox" data-options="label:'社保:',labelPosition:'top', width:150"></td>
            <td><input type="text" name="actualsalary" class="easyui-textbox" data-options="label:'实际工资:',labelPosition:'top', width:150"></td>
        </tr>
        <tr>
            <td><input type="text" name="saleAmount" class="easyui-textbox" data-options="label:'工资:',labelPosition:'top', width:150"></td>
            <td><input type="text" name="remarks" class="easyui-textbox" data-options="label:'备注:',labelPosition:'top', width:150"></td>

        </tr>



        </div>

        </form>
    </div>
    <!--顶部的按钮-->
    <div id="saleChart_datagrid_tb">
        <div>
            <a class="easyui-linkbutton" iconCls="icon-newAdd" plain="true" data-cmd="add">新增</a>
            <a class="easyui-linkbutton" iconCls="icon-blueEdit" plain="true" data-cmd="edit">编辑</a>
            <a class="easyui-linkbutton" iconCls="icon-refreshNet" plain="true" data-cmd="reload">刷新 </a>
        </div>
        <div id="searchBtn">
            <input class="easyui-searchbox">
        </div>
        <div>
            开始日期:<input id="beginDate" class="easyui-datebox">
            结束日期:<input id="endDate" class="easyui-datebox">
            <a class="easyui-linkbutton" iconCls="icon-select" plain="true" data-cmd="searchDate">搜索</a>
        </div>
    </div>
    <div id="saleChart_dialog_bt">
        <a class="easyui-linkbutton" iconCls="icon-blueSave" plain="true" data-cmd="save">保存</a>
        <a class="easyui-linkbutton" iconCls="icon-cnaclebnt" plain="true" data-cmd="cancel">取消</a>
    </div>
</body>
</html>
