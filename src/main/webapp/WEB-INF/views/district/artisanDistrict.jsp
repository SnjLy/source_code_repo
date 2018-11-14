<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--suppress ALL --%>
<%--
  Created by IntelliJ IDEA.
  User: yehao
  Date: 2018/9/18
  Time: 下午1:44
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=gb2312"/>
    <meta name="viewport" content="width=device-width, initial-scale=1.0,
    maximum-scale=1.0, minimum-scale=1.0, user-scalable=no">
    <title>手艺人分布图</title>
    <style type="text/css">
        body, html {
            width: 100%;
            height: 100%;
            margin: 0;
            font-family: "微软雅黑";
        }

        #allmap {
            height: 100%;
            width: 100%;
        }

        #r-result {
            width: 100%;
            font-size: 14px;
            line-height: 20px;
        }
    </style>
    <script type="text/javascript" src="http://api.map.baidu.com/api?v=2.0&ak=KsGMXCk1t4D3nljli0WY23j6">

    </script>
    <script type="text/javascript" src="http://lbsyun.baidu.com/jsdemo/data/points-sample-data.js"></script>
</head>
<body>
<div id="allmap"></div>
<%--<div id="r-result">--%>
    <%--<input type="button" value="批量反地址解析" onclick="bdGEO(0)" />点我--%>
    <%--<div id="result"></div>--%>
<%--</div>--%>
</body>
</html>
<script type="text/javascript">
    // 百度地图API功能
    var map = new BMap.Map("allmap", {});                        // 创建Map实例
    map.centerAndZoom(new BMap.Point(105.000, 38.000), 5);     // 初始化地图,设置中心点坐标和地图级别
    map.enableScrollWheelZoom();                        //启用滚轮放大缩小
    if (document.createElement('canvas').getContext) {  // 判断当前浏览器是否支持绘制海量点
        var points = [];  // 添加海量点数据
      <%--for (var i = 0; i < ${}; i++) {--%>
            <%--points.push(new BMap.Point(data.data[i][0], data.data[i][1]));--%>
        <%--}--%>
        <c:forEach items="${artisans}" var="district" varStatus="status">
        var point${status.count} = new BMap.Point(${district.longitude}, ${district.latitude});
        points.push(point${status.count});
        </c:forEach>

        var options = {
            size: BMAP_POINT_SIZE_NORMAL,
            shape: BMAP_POINT_SHAPE_STAR,
            color: '#d340c3'
        };
        var pointCollection = new BMap.PointCollection(points, options);  // 初始化PointCollection
        pointCollection.addEventListener('click', function (e) {
            alert('单击点的坐标为：' + e.point.lng + ',' + e.point.lat);  // 监听点击事件
        });
        map.addOverlay(pointCollection);  // 添加Overlay
    } else {
        alert('请在chrome、safari、IE8+以上浏览器查看本示例');
    }



    <%--var map = new BMap.Map("allmap");--%>
    <%--var index = 0;--%>
    <%--var myGeo = new BMap.Geocoder();--%>
    <%--var adds = [];--%>
    <%----%>
    <%--<c:forEach items="${artisans}" var="district" varStatus="status">--%>
    <%--var point${status.count} = new BMap.Point(${district.longitude}, ${district.latitude});--%>
    <%--map.centerAndZoom(point${status.count}, 12);--%>
    <%--map.enableScrollWheelZoom(true);--%>
    <%--adds[${status.count}] = point${status.count};--%>
    <%--var marker${status.count} = new BMap.Marker(point${status.count});--%>
    <%--marker${status.count}.setLabel(new BMap.Label("地址${district.address}", {offset: new BMap.Size(20, -10)}));--%>
    <%--map.addOverlay(marker${status.count});--%>
    <%--marker${status.count}.addEventListener("click",--%>
        <%--function () {--%>
            <%--alert("手艺人${district.artisanId}");--%>
        <%--}--%>
    <%--);--%>
    <%--</c:forEach>--%>



</script>
