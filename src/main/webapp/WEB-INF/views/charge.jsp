<%@ page contentType="text/html; charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="utf-8"/>
    <title>收费管理</title>
    <%@ include file="common.jsp"%>
    <script type="text/javascript" src="/static/js/views/charge.js"></script>
</head>
<body>
<table id="charge_data"></table>
<div id="charge_tb">
    <div>
        <a class="easyui-linkbutton" iconCls="icon-newAdd" plain="true" data-cmd="add">新增</a>
        <a class="easyui-linkbutton" iconCls="icon-blueEdit" plain="true" data-cmd="edit">編輯</a>
        <a class="easyui-linkbutton" iconCls="icon-delete" plain="true" data-cmd="del">刪除</a>
        <a class="easyui-linkbutton" iconCls="icon-select" plain="true" data-cmd="advOpen">高级查询</a>
        <a class="easyui-linkbutton" iconCls="icon-refreshNet" plain="true" data-cmd="reload">刷新</a>
        <a class="easyui-linkbutton" iconCls="icon-xls" plain="true" data-cmd="download">导出表格</a>
    </div>
</div>
<div id="advDialog">
    <form id="advForm">
        <table align="center" style="text-align: right">
            <tr>
                <td>
                    学员：
                </td>
                <td>
                    <input  id="studentId" class= "easyui-combobox">
                </td>
                <td>
                    收费时间：
                </td>
                <td>
                    <input id="chargeDate" type= "text" class= "easyui-datebox" >
                </td>
            </tr>
            <tr>
                <td>
                    收费金额：
                </td>
                <td>
                    <input id="chargeMoney" type= "text" class= "easyui-textbox" >
                </td>
                <td>
                    班级：
                </td>
                <td>
                    <input id="classroomId"  class= "easyui-combobox" >
                </td>
            </tr>
            <tr>
                <td>
                    收款人：
                </td>
                <td>
                    <input id="payeeId"  class= "easyui-combobox">
                </td>
                <td>
                    学科：
                </td>
                <td>
                    <input id="subjectId" class= "easyui-combobox">
                </td>
            </tr>
        </table>
    </form>
</div>
<div id="adv_bnt">
    <div>
        <div>
            <a class="easyui-linkbutton" iconCls="icon-select" plain="true" data-cmd="advSelect">查询</a>
            <a class="easyui-linkbutton" iconCls="icon-clear_net" plain="true" data-cmd="advClear">清空</a>
            <a class="easyui-linkbutton" iconCls="icon-cnaclebnt" plain="true" data-cmd="advCancel">取消</a>
        </div>
    </div>
</div>
<div id="charge_dialog">
    <form id="chargeForm" method="post">
        <input type="hidden" name="id">
        <table align="center" style="text-align: right">
            <tr>
                <td>
                    学员：
                </td>
                <td>
                    <input name="student.id" id="charge_student" class= "easyui-combobox">
                </td>
                <td>
                    收费时间：
                </td>
                <td>
                    <input name="chargeDate" type= "text" class= "easyui-datebox">
                </td>
            </tr>
            <tr>
                <td>
                    收费金额：
                </td>
                <td>
                    <input name="chargeMoney" type= "text" class= "easyui-textbox">
                </td>
                <td>
                    班级：
                </td>
                <td>
                    <input name="classroom.id" id="charge_classroom" class= "easyui-combobox" >
                </td>
            </tr>
            <tr>
                <td>
                    收款人：
                </td>
                <td>
                    <input name="payee.id" id="charge_payee" class= "easyui-combobox">
                </td>
                <td>
                    收款方式：
                </td>
                <td>
                    <input name="chargeType.id" id="charge_type" class= "easyui-combobox">
                </td>
            </tr>
            <tr>
                <td>
                    收款单号：
                </td>
                <td>
                    <input name="billNumber" type= "text" class= "easyui-textbox">
                </td>
                <td>
                    是否开票：
                </td>
                <td style="text-align: left">
                    <input id="ticket" name="ticket" class="easyui-switchbutton" data-options="onText:'是',offText:'否'">
                </td>
            </tr>
            <tr>
                <td>
                    学科：
                </td>
                <td>
                    <input name="subject.id" id="charge_subject" class= "easyui-combobox">
                </td>
                <td>
                    备注：
                </td>
                <td>
                    <input name="remark" type= "text" class= "easyui-textbox">
                </td>
            </tr>
            <tr>
                <td>
                    营销人：
                </td>
                <td>
                    <input name="marketing.id" id="charge_marketing" class= "easyui-combobox" >
                </td>
                <td>
                    班级变动：
                </td>
                <td>
                    <input name="classChange" type= "text" class= "easyui-textbox">
                </td>
            </tr>
        </table>
    </form>
</div>
<div id="charge_bnt">
    <div>
        <a class="easyui-linkbutton" iconCls="icon-blueSave" plain="true" data-cmd="save">保存</a>
        <a class="easyui-linkbutton" iconCls="icon-cnaclebnt" plain="true" data-cmd="cancel">取消</a>
    </div>
</div>

</body>
</html>
