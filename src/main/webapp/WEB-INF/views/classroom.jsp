<%@ page contentType="text/html; charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="utf-8"/>
    <title>班级管理</title>
    <%@include file="common.jsp"%>
    <script type="text/javascript" src="/static/js/views/classroom.js"></script>
</head>
<body>
<table id="classroom_data"></table>
<div id="classroom_tb">
    <div>
        <a class="easyui-linkbutton" iconCls="icon-newAdd" plain="true" data-cmd="add">新增</a>
        <a class="easyui-linkbutton" iconCls="icon-blueEdit" plain="true" data-cmd="edit">編輯</a>
        <a class="easyui-linkbutton" iconCls="icon-delete" plain="true" data-cmd="del">刪除</a>
        <a class="easyui-linkbutton" iconCls="icon-refreshNet" plain="true" data-cmd="reload">刷新</a>
    </div>
</div>
<div id="classroom_dialog" style="padding-top: 10px">
    <form id="classroomForm" method="post">
        <input type="hidden" name="id">
        <table align="center">
            <tr>
                <td>名称:</td>
                <td><input name="name" type="text" class="easyui-textbox" required="required"></td>
            </tr>
            <tr>
                <td>班主任:</td>
                <td><input name="classTeacher.id" id="classroom_teacher"></td>
            </tr>
            <tr>
                <td>学院:</td>
                <td><input name="institute.id" id="classroom_institute"></td>
            </tr>
        </table>
    </form>
</div>
<div id="classroom_bnt">
    <div>
        <a class="easyui-linkbutton" iconCls="icon-save" plain="true" data-cmd="save">保存</a>
        <a class="easyui-linkbutton" iconCls="icon-cancel" plain="true" data-cmd="cancel">取消</a>
    </div>
</div>

</body>
</html>
