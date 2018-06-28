<%@ page contentType="text/html; charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="utf-8"/>
    <title>Title</title>
    <link href="/static/css/fullcalendar.css" rel="stylesheet">
    <%@ include file="common.jsp" %>
    <script type="text/javascript" src="/static/js/jquery-ui-1.10.2.custom.min.js"></script>
    <script type="text/javascript" src="/static/js/fullcalendar.min.js"></script>
    <script type="text/javascript" src="/static/js/views/selfDate.js"></script>
</head>
<body>
<div id='calendar'>
    <div id="addDialog">
        <form id="addForm" method="post">
            <input type="hidden" name="id">
            <table align="center">
                <tr>
                    <td colspan="2">任务说明<input name="title" class="easyui-textbox"
                                               data-options="multiline:true,required:true"
                                               style="width:300px;height:60px"></td>
                </tr>
                <tr>
                    <td>开始时间<input id="start" class="easyui-datetimebox" name="start"
                                   data-options="required:true,showSeconds:false" style="width:150px">
                    </td>
                    <td>结束时间<input class="easyui-datetimebox" name="end"
                                   data-options="showSeconds:false" style="width:150px">
                    </td>
                </tr>
                <tr>
                    <td>
                        颜色<input class="easyui-combobox" name="color"  data-options="
                                                        valueField: 'color',
                                                        textField: 'text',
                                                        data: [{
                                                            color: '#FF0000',
                                                            text: '红色'
                                                        },{
                                                            color: '#0000FF',
                                                            text: '蓝色'
                                                        },{
                                                            color: '#008000',
                                                            text: '绿色'
                                                        }]" style="width: 150px" />


                    </td>
                    <td>
                        URL<input name="url" class="easyui-textbox" style="width:150px">
                    </td>
                </tr>
            </table>
        </form>
    </div>
    <div id="editDialog"></div>
</div>
<div id="addBnt">
    <a class="easyui-linkbutton" iconCls="icon-blueSave" plain="true" data-cmd="save">保存</a>
    <a id="removeDate" class="easyui-linkbutton" iconCls="icon-delete" plain="true" data-cmd="remove">删除</a>
    <a class="easyui-linkbutton" iconCls="icon-cancelAudit" plain="true" data-cmd="cancel">取消</a>
</div>
</body>
</html>
