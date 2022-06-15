$.post(ctx + "/order/order/page", {page: 1, rows: 10, companyName: data.data.companyName}, function (data1) {
    debugger
    if (data1.flag) {
        // layer.msg(data.msg,{icon:1,timeout:2000});
        // data.data
        let xarray1 = [];
        let yarray1 = [];
        for (let i = 0; i < data1.data.length; i++) {
            xarray1.push(data1.data[i].garbageName);
            yarray1.push(data1.data[i].sumRweight);
        }
        // debugger
        console.log(data1);
    }
});

// 百度地图API功能
var map = new BMap.Map("allmap");
map.centerAndZoom(new BMap.Point(116.404, 39.915), 11);
map.enableScrollWheelZoom(true);

var p1 = new BMap.Point(116.301934,39.977552);
var p2 = new BMap.Point(116.508328,39.919141);
var p3 = new BMap.Point(116.365942,39.996165);
var p4 = new BMap.Point(116.408757,39.995704);

var driving = new BMap.DrivingRoute(map, {renderOptions:{map: map, autoViewport: true}});
driving.search(p1, p2,{waypoints:[p3,p4]});//waypoints表示途经点
