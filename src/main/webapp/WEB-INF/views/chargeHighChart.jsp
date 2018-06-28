<%@ page contentType="text/html; charset=UTF-8" language="java" %>
<%@include file="common.jsp"%>
<script type="text/javascript" src="/static/Hchart/highcharts.js"></script>
<script type="text/javascript" src="/static/Hchart/highcharts-3d.js"></script>
<head>
    <title>报表</title>
    <script type="text/javascript">
        $(function () {
            $('#container').highcharts({
                title: {
                    text: '销售报表分析',
                    x: -20 //center
                },
                subtitle: {
                    text: '<font>按照${typeName}分组</font>',
                    x: -20
                },
                xAxis: {
                    categories: ${xValues}
                },
                yAxis: {
                    title: {
                        text: '金额 (元)'
                    },
                    plotLines: [{
                        value: 0,
                        width: 1,
                        color: '#fe040e'
                    }]
                },
                tooltip: {
                    valueSuffix: '元'
                },
                legend: {
                    layout: 'vertical',
                    align: 'right',
                    verticalAlign: 'middle',
                    borderWidth: 0
                },
                series: [{
                    name: '销售金额',
                    data:${yValues}
                }]
            });
        });
    </script>
</head>
<body>


<div id="container" style="height: 400px"></div>

</body>
</html>
