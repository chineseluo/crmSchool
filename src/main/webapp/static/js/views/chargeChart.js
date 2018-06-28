$(function(){
	/*
	 * 抽取所有需要用得元素.
	 */
	var chargeChartDatagrid;
	chargeChartDatagrid = $("#chargeChart_datagrid");
	/*
	 * 初始化数据表格 
	 */
	chargeChartDatagrid.datagrid({
		url:"/chargeChart/list",
		fit:true,
		rownumbers:true,
		singleSelect:true,
		striped:true,
		fitColumns:true,
		toolbar:'#chargeChart_datagrid_tb',
        columns:[
            [
    		{field:'groupType',align:'center',width:10,title:'分组类型'},
    		{field:'totalAmount',align:'center',width:10,title:'总金额'},
            ]
        ]

	});

	/*
	 * 对页面按钮进行统一监听
	 */
	$("a[data-cmd]").on("click",function(){
		var cmd = $(this).data("cmd");
		if(cmd){
			cmdObj[cmd]();
		}
	});




		$("#pieHighChart").on("click",function () {
            var groupbyCon = $("#grouping").val();
            window.showModalDialog("chargeChart/chartPie?groupbyCon=" + groupbyCon ,
                "", "dialogHeight:600px;dialogWidth:680px;")
        })
		$("#barHighChart").on("click",function () {
            var groupbyCon = $("#grouping").val();
            window.showModalDialog("chargeChart/chartBar?groupbyCon=" + groupbyCon ,
                "", "dialogHeight:600px;dialogWidth:680px;")
        })


        $("#searchBtn").linkbutton({
        text:'快查',
        iconCls:'icon-select',
        onClick:function(){

            var beginDate = $("[name='qo.beginDate']").val();
            var endDate = $("[name='qo.endDate']").val();
            var groupbyCon = $("#grouping").val();
            console.log(groupbyCon);

            chargeChartDatagrid.datagrid("load",{

                "groupbyCon":groupbyCon,
                "beginDate":beginDate,
                "endDate":endDate,

            });
        }



    })


});