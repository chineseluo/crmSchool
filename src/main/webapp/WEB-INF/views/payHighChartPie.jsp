<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Title</title>
    <%@include file="common.jsp"%>
    <script src="/static/echart/echarts-all.js"></script>
</head>
<body>
    <!-- 为ECharts准备一个具备大小（宽高）的Dom -->
    <div id="main" style="height:560px;width:580px"></div>
    <script type="text/javascript">
        // 路径配置
        var myChart = echarts.init(document.getElementById('main'));
        console.log(${groupList});
        option = {
            title:{
                text:"销售报表",
                subtext:'按照${typeName}分组',
                x:'center'
            },
            tooltip : {
                trigger: 'item',
                formatter: "{a} <br/>{b} : {c} ({d}%)"
            },
            legend: {
                orient : 'vertical',
                x : 'left',
                data:${xValues}
            },
            toolbox: {
                show : true,
                feature : {
                    mark : {show: true},
                    dataView : {show: true, readOnly: false},
                    magicType : {
                        show: true,
                        type: ['pie', 'funnel'],
                        option: {
                            funnel: {
                                x: '25%',
                                width: '30%',
                                funnelAlign: 'left',
                                max:1000

                            }
                        }
                    },
                    restore : {show: true},
                    saveAsImage : {show: true}
                }
            },
            calculable : true,
            series : [
                {
                    name:"销售金额",
                    type:'pie',
                    radius : '55%',
                    center: ['50%', '60%'],
                    data:${groupList}
                }
            ]
        };

        myChart.setOption(option)
    </script>
    </body>
    </html>