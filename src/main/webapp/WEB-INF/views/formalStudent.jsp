<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <%@include file="common.jsp" %>
    <script type="text/javascript" src="/static/js/views/formalStudent.js"></script>
    <title>正式学员首页</title>
</head>
<body>
<table id="formalStudent_datagrid"></table>
<div id="formalStudent_toolbar">
    <a class="easyui-linkbutton" iconCls="icon-blueEdit" plain="true" data-cmd="edit" id="edit_btn">编辑</a>
    <%--<a class="easyui-linkbutton" iconCls="icon-save" plain="true" data-cmd="view",id="view_btn">查看</a>--%>
    <%--<a class="easyui-linkbutton" iconCls="icon-cancel" plain="true" data-cmd="del"  id="del_btn">删除</a>--%>
    <a class="easyui-linkbutton" iconCls="icon-refreshNet" plain="true" data-cmd="reload">刷新</a>
    <input class="easyui-textbox" name='keyword' prompt="姓名/QQ/电话/班级"/>
    <a class="easyui-linkbutton" iconCls="icon-select" plain="true" data-cmd="formalSearch">查询</a>
    <a class="easyui-linkbutton" iconCls="icon-xls" plain="true" href="/formalStudent/export">导出Excel</a>
    <a class="easyui-linkbutton" iconCls="icon-blueEdit" plain="true" data-cmd="classTransfer">转班</a>
    <a class="easyui-linkbutton" iconCls="icon-blueEdit" plain="true" data-cmd="loss">流失</a>
    <a class="easyui-linkbutton" iconCls="icon-blueEdit" plain="true" data-cmd="dropOut">休学</a>
    <a class="easyui-linkbutton" iconCls="icon-blueEdit" plain="true" data-cmd="payment">付款</a>
    <%--<a class="easyui-linkbutton" iconCls="icon-edit" plain="true" data-cmd="loan">贷款</a>--%>
    <a class="easyui-linkbutton" iconCls="icon-blueEdit" plain="true" data-cmd="inform">通知</a>
    <input name="currentclass.id" class="easyui-combobox" prompt="请选择班级" id="searchClass"
           data-options="valueField:'name',textField:'name',url:'',panelHeight:'auto'" />
    <a class="easyui-linkbutton" iconCls="icon-select" plain="true" data-cmd="fastSearch"></a>
</div>
<div id="formalStudent_dialog">
    <form method="post" id="formalStudent_form">
        <input type="hidden" name="id"/>
        <table align="center">
            <tr>
                <td>真实姓名:</td>
                <td><input class="easyui-textbox" name="name" /></td>
            </tr>
          <tr>
                <td>营销人员:</td>
                <td><input class="easyui-combobox" name="marketingMan.id"
                           data-options="valueField:'id',textField:'username',url:'/employee/queryEmpByRoleSn?sn=SALEMAN',panelHeight:'auto'"/></td>
            </tr>
            <tr>
                <td>总学费:</td>
                <td><input class="easyui-textbox" name="totalTuition"/></td>
            </tr>
            <tr>
                <td>待缴学费:</td>
                <td><input class="easyui-textbox" disabled="disabled"  name="dueTuition"/></td>
            </tr>
            <tr>
                <td>已付学费:</td>
                <td><input class="easyui-textbox" name="defraiedTuition"/></td>
            </tr>
            <tr>
                <td>缴费状态:</td>
                <td><input class="easyui-combobox" name="payState.id"
                           data-options="valueField:'id',textField:'name',url:'/systemDictionaryItem/payList?sn=payState',panelHeight:'auto'"/></td>
            </tr>
          <%--  <tr>
                <td>入学时间:</td>
                <td><input class="easyui-datebox" name="trainStartTime"/></td>
            </tr>--%>
            <tr>
                <td>学校:</td>
                <td><input class="easyui-textbox" name="schoolOrTrainOrganization"/></td>
            </tr>
            <tr>
                <td>QQ:</td>
                <td><input class="easyui-textbox" name="qq"/></td>
            </tr>
            <tr>
                <td>电话:</td>
                <td><input class="easyui-textbox" name="telephone"/></td>
            </tr>
          <%--  <tr>
                <td>所在班级:</td>
                <td><input name="currentClass.id" class="easyui-combobox" id="currentclass_combobox"
                           data-options="valueField:'id',textField:'name',url:'',panelHeight:'auto'"/>
                </td>
            </tr>
            <tr>
                <td>付款方式:</td>
                <td><input class="easyui-combobox" name="payWay.id"
                           data-options="valueField:'id',textField:'name',url:'',panelHeight:'auto'"/></td>
            </tr>
            <tr>
                <td>状态:</td>
                <td><input class="easyui-combobox" name="studentState.id"
                           data-options="valueField:'id',textField:'name',url:'',panelHeight:'auto'"/>
                </td>
            </tr>
            <tr>
                <td>通知:</td>
                <td><input class="easyui-combobox" name="inform"
                           data-options="valueField:'id',textField:'name',url:'',panelHeight:'auto'"/>
                </td>
            </tr>--%>
        </table>
    </form>
</div>
<div id="formalStudent_dialog_buttons">
    <a class="easyui-linkbutton" iconCls="icon-save" plain="true" data-cmd="save">保存</a>
    <a class="easyui-linkbutton" iconCls="icon-cancel" plain="true" data-cmd="cancel">取消</a>
</div>
<%--===============================================查看========================================================--%>
<div id="formalStudent_dialogView">
    <form method="post" id="formalStudent_formView">
        <input type="hidden" name="id"/>
        <table align="center">
            <tr>
                <td>真实姓名:</td>
                <td><input class="easyui-textbox" name="name" disabled="disabled"/></td>
            </tr>
            <tr>
                <td>营销人员:</td>
                <td><input class="easyui-combobox" name="marketingman.id" disabled="disabled"
                           data-options="valueField:'id',textField:'username',url:'',panelHeight:'auto'"/></td>
            </tr>
            <tr>
                <td>总学费:</td>
                <td><input class="easyui-textbox" name="totaltuition" disabled="disabled"/></td>
            </tr>
            <tr>
                <td>待缴学费:</td>
                <td><input class="easyui-textbox" name="duetuition" disabled="disabled"/></td>
            </tr>
            <tr>
                <td>已付学费:</td>
                <td><input class="easyui-textbox" name="defraiedtuition" disabled="disabled"/></td>
            </tr>
            <tr>
                <td>缴费状态:</td>
                <td><input class="easyui-combobox" name="paystate.id" disabled="disabled"
                           data-options="valueField:'id',textField:'name',url:'',panelHeight:'auto'"/></td>
            </tr>
            <tr>
                <td>入学时间:</td>
                <td><input class="easyui-datebox" name="trainstarttime" disabled="disabled"/></td>
            </tr>
            <tr>
                <td>学校:</td>
                <td><input class="easyui-textbox" name="schoolortrainorganization" disabled="disabled"/></td>
            </tr>
            <tr>
                <td>QQ:</td>
                <td><input class="easyui-textbox" name="qq" disabled="disabled"/></td>
            </tr>
            <tr>
                <td>电话:</td>
                <td><input class="easyui-textbox" name="telephone" disabled="disabled"/></td>
            </tr>
            <tr>
                <td>所在班级:</td>
                <td><input name="currentclass.id" class="easyui-combobox" disabled="disabled"
                           data-options="valueField:'id',textField:'name',url:'',panelHeight:'auto'"/>
                </td>
            </tr>
            <tr>
                <td>付款方式:</td>
                <td><input class="easyui-combobox" name="payway.id" disabled="disabled"
                           data-options="valueField:'id',textField:'name',url:'',panelHeight:'auto'"/></td>
            </tr>
            <tr>
                <td>状态:</td>
                <td><input class="easyui-combobox" name="studentstate.id" disabled="disabled"
                           data-options="valueField:'id',textField:'name',url:'',panelHeight:'auto'"/>
                </td>
            </tr>
            <tr>
                <td>通知:</td>
                <td><input class="easyui-textbox" name="inform" disabled="disabled"/></td>
            </tr>
        </table>
    </form>
</div>
<div id="formalStudent_dialog_buttonsView">
    <a class="easyui-linkbutton" iconCls="icon-cnaclebnt" plain="true" data-cmd="cancelView">关闭</a>
</div>
<%--==============================================转班===============================================================--%>
<div id="formalStudent_dialog_classTransfer">
    <form method="post" id="formalStudent_form_classTransfer">
        <input type="hidden" name="id" id="classTransfer_id"/>
        <input type="hidden" name="beforeClass.id" id="beforeClass"/>
        <table align="center">
            <tr>
                <td>原来的班级:</td>
                <td><input name="currentClass_name" type="text" disabled="disabled"/>
                </td>
            </tr>
            <tr>
                <td>需要转到的班级:</td>
                <td><input name="currentClass.id" class="easyui-combobox"
                           data-options="valueField:'id',textField:'name',url:'classroom/payList',panelHeight:'auto'"/>
                </td>
            </tr>
        </table>
    </form>
</div>
<div id="formalStudent_dialog_buttonsclassTransfe">
    <a class="easyui-linkbutton" iconCls="icon-blueSave" plain="true" data-cmd="save_classTransfer">确定</a>
    <a class="easyui-linkbutton" iconCls="icon-cnaclebnt" plain="true" data-cmd="cancel_classTransfer">取消</a>
</div>
<%--==============================================付款===============================================================--%>
<div id="formalStudent_dialog_payment">
    <form method="post" id="formalStudent_form_payment">
        <input type="hidden" name="id" id="payment_id"/>
        <table align="center">
            <tr>
                <td>总学费:</td>
                <td><input class="easyui-textbox" name="totalTuition" readonly="readonly" /></td>
            </tr>
            <tr>
                <td>待缴学费:</td>
                <td><input class="easyui-textbox" name="dueTuition"  readonly="readonly"  /></td>
            </tr>
            <tr>
                <td>已付学费:</td>
                <td><input class="easyui-textbox" name="defraiedTuition"  readonly="readonly"/></td>
            </tr>
            <tr>
                <td>付款:</td>
                <td><input class="easyui-textbox" name="payment"/></td>
            </tr>
        </table>
    </form>
</div>
<div id="formalStudent_dialog_buttons_payment">
    <a class="easyui-linkbutton" iconCls="icon-blueSave" plain="true" data-cmd="save_payment">保存</a>
    <a class="easyui-linkbutton" iconCls="icon-cnaclebnt" plain="true" data-cmd="cancel_payment">取消</a>
</div>
</body>
</html>