<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <%@include file="common.jsp" %>
    <script type="text/javascript" src="/static/js/views/upOrDownClass.js"></script>
    <title>角色首页</title>
</head>
<body>
<table id="upOrDownClass_datagrid"></table>
<div id="upOrDownClass_toolbar">
    <%--<a class="easyui-linkbutton" iconCls="icon-edit" plain="true" data-cmd="edit" id="edit_btn">编辑</a>--%>
    <%--<a class="easyui-linkbutton" iconCls="icon-save" plain="true" data-cmd="view",id="view_btn">查看</a>--%>
    <%--<a class="easyui-linkbutton" iconCls="icon-cancel" plain="true" data-cmd="del">删除</a>--%>
    <a class="easyui-linkbutton" iconCls="icon-refreshNet" plain="true" data-cmd="reload">刷新</a>
    <input class="easyui-textbox" name='keyword' prompt="姓名/QQ/电话"/>
    <a class="easyui-linkbutton" iconCls="icon-select" plain="true" data-cmd="upOrDownSearch">查询</a>
    <a class="easyui-linkbutton" iconCls="icon-xls" plain="true" href="/upOrDownClass/export">导出Excel</a>
</div>
<%--<div id="upOrDownClass_dialog">
    <form method="post" id="upOrDownClass_form">
        <input type="hidden" name="id"/>
        <table align="center">
            <tr>
                <td>学生姓名:</td>
                <td><input class="easyui-textbox" name="name" /></td>
            </tr>
            <tr>
                <td>总学费:</td>
                <td><input class="easyui-textbox"  name="totalTuition"/></td>
            </tr>
            <tr>
                <td>销售流水:</td>
                <td><input class="easyui-textbox" name="marketStream"/></td>
            </tr>
            <tr>
                <td>其他费用:</td>
                <td><input class="easyui-textbox" name="otherTuition"/></td>
            </tr>
            <tr>
                <td>升班/留级时间:</td>
                <td><input class="easyui-datebox" name="trainStartTime"/></td>
            </tr>
            <tr>
                <td>QQ:</td>
                <td><input class="easyui-textbox" name="qq"/></td>
            </tr>
            <tr>
                <td>联系电话:</td>
                <td><input class="easyui-textbox" name="telephone"/></td>
            </tr>
            <tr>
                <td>以前的班级:</td>
                <td><input name="beforeClass.id" class="easyui-combobox"
                           data-options="valueField:'id',textField:'name',url:'schoolclass_combobox',panelHeight:'auto'"/>
                </td>
            </tr>
            <tr>
                <td>流入的班级:</td>
                <td><input name="flowclass.id" class="easyui-combobox" id="flowclass_combobox"
                           data-options="valueField:'id',textField:'name',url:'schoolclass_combobox',panelHeight:'auto'"/>
                </td>
            </tr>
            <tr>
                <td>营销人员:</td>
                <td><input class="easyui-combobox" name="marketingman.id"
                           data-options="valueField:'id',textField:'username',url:'/employee_combobox',panelHeight:'auto'"/></td>
            </tr>
            <tr>
                <td>状态:</td>
                <td><input class="easyui-combobox" name="studentstate.id"
                           data-options="valueField:'id',textField:'name',url:'queryDictionaryItemByDictionarySn?cmd=studentstate',panelHeight:'auto'"/>
                </td>
            </tr>
        </table>
    </form>
</div>--%>
<%--<div id="upOrDownClass_dialog_buttons">
    <a class="easyui-linkbutton" iconCls="icon-save" plain="true" data-cmd="save">保存</a>
    <a class="easyui-linkbutton" iconCls="icon-cancel" plain="true" data-cmd="cancel">取消</a>
</div>
&lt;%&ndash;=======--%>=======================================查看===============================================================--%>
<%--<div id="upOrDownClass_dialogView">
    <form method="post" id="upOrDownClass_formView">
        <input type="hidden" name="id"/>
        <table align="center">
            <tr>
                <td>学生姓名:</td>
                <td><input class="easyui-textbox" name="name" disabled="disabled"/></td>
            </tr>
            <tr>
                <td>总学费:</td>
                <td><input class="easyui-textbox"  name="totaltuition" disabled="disabled"/></td>
            </tr>
            <tr>
                <td>销售流水:</td>
                <td><input class="easyui-textbox" name="marketstream" disabled="disabled"/></td>
            </tr>
            <tr>
                <td>其他费用:</td>
                <td><input class="easyui-textbox" name="othertuition" disabled="disabled"/></td>
            </tr>
            <tr>
                <td>升班/留级时间:</td>
                <td><input class="easyui-datebox" name="trainstarttime" disabled="disabled"/></td>
            </tr>
            <tr>
                <td>QQ:</td>
                <td><input class="easyui-textbox" name="qq" disabled="disabled"/></td>
            </tr>
            <tr>
                <td>联系电话:</td>
                <td><input class="easyui-textbox" name="telephone" disabled="disabled"/></td>
            </tr>
            <tr>
                <td>以前的班级:</td>
                <td><input name="beforeClass.id" class="easyui-combobox" disabled="disabled"
                           data-options="valueField:'id',textField:'name',url:'classroom/selectAll',panelHeight:'auto'"/>
                </td>
            </tr>
            <tr>
                <td>流入的班级:</td>
                <td><input name="flowcClass.id" class="easyui-combobox" disabled="disabled"
                           data-options="valueField:'id',textField:'name',url:'classroom/selectAll',panelHeight:'auto'"/>
                </td>
            </tr>
            <tr>
                <td>营销人员:</td>
                <td><input class="easyui-combobox" name="marketingman.id" disabled="disabled"
                           data-options="valueField:'id',textField:'username',url:'/employee_combobox',panelHeight:'auto'"/></td>
            </tr>
            <tr>
                <td>状态:</td>
                <td><input class="easyui-combobox" name="studentstate.id" disabled="disabled"
                           data-options="valueField:'id',textField:'name',url:'queryDictionaryItemByDictionarySn?cmd=studentstate',panelHeight:'auto'"/>
                </td>
            </tr>
        </table>
    </form>
</div>--%>
<div id="upOrDownClass_dialog_buttonsView">
    <a class="easyui-linkbutton" iconCls="icon-cancel" plain="true" data-cmd="cancelView">关闭</a>
</div>
</body>
</html>