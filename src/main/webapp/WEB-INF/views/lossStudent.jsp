<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <%@include file="common.jsp" %>
    <script type="text/javascript" src="/static/js/views/lossStudent.js"></script>
    <title>角色首页</title>
</head>
<body>
<table id="lossStudent_datagrid"></table>
<div id="lossStudent_toolbar">
    <a class="easyui-linkbutton" iconCls="icon-blueEdit" plain="true" data-cmd="edit" id="edit_btn">编辑</a>
    <%--<a class="easyui-linkbutton" iconCls="icon-save" plain="true" data-cmd="view",id="view_btn">查看</a>--%>
    <a class="easyui-linkbutton" iconCls="icon-delete" plain="true" data-cmd="del">删除</a>
    <a class="easyui-linkbutton" iconCls="icon-refreshNet" plain="true" data-cmd="reload">刷新</a>
    <input class="easyui-textbox" name='keyword' prompt="姓名/QQ/电话/班级"/>
    <a class="easyui-linkbutton" iconCls="icon-select" plain="true" data-cmd="lossStudentSearch">查询</a>
    <a class="easyui-linkbutton" iconCls="icon-xls" plain="true"href="/lossstudent_export">导出Excel</a>
</div>
<div id="lossStudent_dialog">
    <form method="post" id="lossStudent_form">
        <input type="hidden" name="id"/>
        <table align="center">
            <tr>
                <td>学生姓名:</td>
                <td><input class="easyui-textbox" name="name" /></td>
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
                <td>上课天数:</td>
                <td><input class="easyui-textbox"  name="fatalisminSchool"/></td>
            </tr>
         <%--   <tr>
                <td>流失班级:</td>
                <td><input name="currentclass.id" class="easyui-combobox"
                           data-options="valueField:'id',textField:'name',url:'schoolclass_combobox',panelHeight:'auto'"/>
                </td>
            </tr>--%>
            <tr>
                <td>流失阶段:</td>
                <td><input class="easyui-textbox" name="losssTage"/></td>
            </tr>
            <tr>
                <td>流失原因:</td>
                <td><input class="easyui-textbox" name="lossCause"/></td>
            </tr>

           <%-- <tr>
                <td>营销人员:</td>
                <td><input class="easyui-combobox" name="marketingman.id"
                           data-options="valueField:'id',textField:'username',url:'/employee_combobox',panelHeight:'auto'"/></td>
            </tr>
            <tr>
                <td>录入人:</td>
                <td><input class="easyui-combobox" name="inputman.id"
                           data-options="valueField:'id',textField:'username',url:'/employee_combobox',panelHeight:'auto'"/></td>
            </tr>--%>
            <tr>
                <td>是否退款:</td>
                <td>
                    <input type="text" name="refundment" class="easyui-combobox"
                           data-options="panelHeight:'auto',valueField:'id',textField:'name',data:[{id:'1',name:'是'},{id:'0',name:'否'}]"/>
                </td>
            </tr>
           <%-- <tr>
                <td>状态:</td>
                <td><input class="easyui-combobox" name="studentstate.id"
                           data-options="valueField:'id',textField:'name',url:'queryDictionaryItemByDictionarySn?cmd=studentstate',panelHeight:'auto'"/>
                </td>
            </tr>--%>
        </table>
    </form>
</div>
<div id="lossStudent_dialog_buttons">
    <a class="easyui-linkbutton" iconCls="icon-blueSave" plain="true" data-cmd="save">保存</a>
    <a class="easyui-linkbutton" iconCls="icon-cnaclebnt" plain="true" data-cmd="cancel">取消</a>
</div>
<%--==============================================查看===============================================================--%>
<%--<div id="lossStudent_dialogView">
    <form method="post" id="lossStudent_formView">
        <input type="hidden" name="id"/>
        <table align="center">
            <tr>
                <td>学生姓名:</td>
                <td><input class="easyui-textbox" name="name" /></td>
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
                <td>上课天数:</td>
                <td><input class="easyui-textbox"  name="fatalisminschool"/></td>
            </tr>
            <tr>
                <td>流失班级:</td>
                <td><input name="currentclass.id" class="easyui-combobox"
                           data-options="valueField:'id',textField:'name',url:'',panelHeight:'auto'"/>
                </td>
            </tr>
            <tr>
                <td>流失阶段:</td>
                <td><input class="easyui-textbox" name="lossstage"/></td>
            </tr>
            <tr>
                <td>流失原因:</td>
                <td><input class="easyui-textbox" name="losscause"/></td>
            </tr>
            <tr>
                <td>经办人:</td>
                <td><input class="easyui-combobox" name="handlerperson.id"
                           data-options="valueField:'id',textField:'username',url:'',panelHeight:'auto'"/></td>
            </tr>
            <tr>
                <td>营销人员:</td>
                <td><input class="easyui-combobox" name="marketingman.id"
                           data-options="valueField:'id',textField:'username',url:'',panelHeight:'auto'"/></td>
            </tr>
            <tr>
                <td>录入人:</td>
                <td><input class="easyui-combobox" name="inputman.id"
                           data-options="valueField:'id',textField:'username',url:'',panelHeight:'auto'"/></td>
            </tr>
            <tr>
                <td>是否退款:</td>
                <td>
                    <input type="text" name="refundment" class="easyui-combobox"
                           data-options="panelHeight:'auto',valueField:'id',textField:'name',data:[{id:'true',name:'是'},{id:'false',name:'否'}]"/>
            </tr>
            <tr>
                <td>状态:</td>
                <td><input class="easyui-combobox" name="studentstate.id"
                           data-options="valueField:'id',textField:'name',url:'queryDictionaryItemByDictionarySn?cmd=studentstate',panelHeight:'auto'"/>
                </td>
            </tr>
        </table>
    </form>--%>
</div>
<div id="lossStudent_dialog_buttonsView">
    <a class="easyui-linkbutton" iconCls="icon-cancel" plain="true" data-cmd="cancelView">关闭</a>
</div>
</body>
</html>