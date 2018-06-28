<%@ page contentType="text/html; charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="utf-8"/>
    <title>支出管理</title>
    <%@ include file="common.jsp" %>
    <script type="text/javascript" src="/static/js/views/pay.js"></script>
</head>
<body>
<table id="pay_data"></table>
<div id="pay_tb">
    <div>
        <a class="easyui-linkbutton" iconCls="icon-newAdd" plain="true" data-cmd="add">新增</a>
        <a class="easyui-linkbutton" iconCls="icon-blueEdit" plain="true" data-cmd="edit">編輯</a>
        <a class="easyui-linkbutton" iconCls="icon-delete" plain="true" data-cmd="del">刪除</a>
        <a class="easyui-linkbutton" iconCls="icon-refreshNet" plain="true" data-cmd="reload">刷新</a>
        <a class="easyui-linkbutton" iconCls="icon-select" plain="true" data-cmd="advOpen">高级查询</a>
        <a class="easyui-linkbutton" iconCls="icon-audit" plain="true" data-cmd="audit">审核</a>
        <a class="easyui-linkbutton" iconCls="icon-cancelAudit" plain="true" data-cmd="cancelAudit">取消审核</a>
        <a class="easyui-linkbutton" iconCls="icon-xls" plain="true" data-cmd="downloadJxl">下载表格</a>
    </div>
</div>
<div id="advDialog">
    <form id="advForm">
        <table align="center" style="text-align: right">
            <tr>
                <td>
                    支出时间：
                </td>
                <td>
                    <input id="advPayDate" class= "easyui-datebox">
                </td>
                <td>
                    支出金额：
                </td>
                <td>
                    <input id="advPayMoney" type= "text" class= "easyui-textbox">
                </td>
            </tr>
            <tr>
                <td>
                    出纳人：
                </td>
                <td>
                    <input id="advCashierId" class= "easyui-combobox">
                </td>
                <td>
                    经手人：
                </td>
                <td>
                    <input id="advBrokerageId" class= "easyui-combobox">
                </td>
            </tr>
            <tr>
                <td>
                    支付方式：
                </td>
                <td>
                    <input id="advPayModeId" class= "easyui-combobox">
                </td>
                <td>
                    学科：
                </td>
                <td>
                    <input id="advSubjectId"  class= "easyui-combobox">
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
<div id="pay_dialog">
    <form id="payForm" method="post">
        <input type="hidden" name="id">
        <table align="center" style="text-align: right">
            <tr>
                <td>
                    支出时间：
                </td>
                <td>
                    <input name="payDate" type= "text" class= "easyui-datebox">
                </td>
                <td>
                    支出金额：
                </td>
                <td>
                    <input name="payMoney" type= "text" class= "easyui-textbox">
                </td>
            </tr>
            <tr>
                <td>
                    支出说明：
                </td>
                <td>
                    <input name="info" type= "text" class= "easyui-textbox">
                </td>
                <td>
                    出纳人：
                </td>
                <td>
                    <input name="cashier.id" id="pay_cashier" class= "easyui-combobox">
                </td>
            </tr>
            <tr>
                <td>
                    经手人：
                </td>
                <td>
                    <input name="brokerage.id" id="pay_brokerage" class= "easyui-combobox">
                </td>
                <td>
                    支付方式：
                </td>
                <td>
                    <input name="payMode.id" id="pay_mode" class= "easyui-combobox">
                </td>
            </tr>
            <tr>
                <td>
                    支付类型：
                </td>
                <td>
                    <input name="payType.id" id="pay_type" class= "easyui-combobox" >
                </td>
                <td>
                    支出小类：
                </td>
                <td>
                    <input name="paySmall.id" id="pay_small" class= "easyui-combobox">
                </td>
            </tr>
            <tr>
                <td>
                    支票号码：
                </td>
                <td>
                    <input name="billNumber" type= "text" class= "easyui-textbox">
                </td>
                <td>
                    共享金额：
                </td>
                <td>
                    <input name="shareCost" type= "text" class= "easyui-textbox">
                </td>
            </tr>
            <tr>
                <td>
                    共享类型：
                </td>
                <td>
                    <input name="shareType.id" id="pay_shareType" class= "easyui-combobox" >
                </td>
                <td>
                    学科：
                </td>
                <td>
                    <input name="subject.id" id="pay_subject" class= "easyui-combobox">
                </td>
            </tr>
        </table>
    </form>
</div>
<div id="pay_bnt">
    <div>
        <a class="easyui-linkbutton" iconCls="icon-blueSave" plain="true" data-cmd="save">保存</a>
        <a class="easyui-linkbutton" iconCls="icon-cnaclebnt" plain="true" data-cmd="cancel">取消</a>
    </div>
</div>
</body>
</html>
