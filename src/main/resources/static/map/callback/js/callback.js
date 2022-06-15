let tableIns,price;
layui.use(['element', 'form', 'table', 'layer', 'laydate', 'tree', 'util'], function () {
    let table = layui.table;
    let form = layui.form;//select、单选、复选等依赖form
    let element = layui.element; //导航的hover效果、二级菜单等功能，需要依赖element模块
    let laydate = layui.laydate;
    tree = layui.tree;
    let height = 400;

    //用户列表
    $.post(ctx + "/sys/sysUser/getUser", {
        loginName: window.parent.loginName
    }, function (data3) {
        if (data3.flag) {
            console.log(data3);
            // debugger
    tableIns = table.render({
        elem: '#userTable'
        , url: ctx + '/order/order22/page'
        , method: 'POST'
        //请求前参数处理
        , request: {
            pageName: 'page' //页码的参数名称，默认：page
            , limitName: 'rows' //每页数据量的参数名，默认：limit

        }
        ,where:{
            companyId:data3.data.companyId,
            state: '已接收',
            gotime:getNowFormatDate(),
        }
        , response: {
            statusName: 'flag' //规定数据状态的字段名称，默认：code
            , statusCode: true //规定成功的状态码，默认：0
            , msgName: 'msg' //规定状态信息的字段名称，默认：msg
            , countName: 'records' //规定数据总数的字段名称，默认：count
            , dataName: 'rows' //规定数据列表的字段名称，默认：data
        }
        //响应后数据处理
        , parseData: function (res) { //res 即为原始返回的数据
            var data = res.data;
            console.log(data);
            //debugger
            return {
                "flag": res.flag, //解析接口状态
                "msg": res.msg, //解析提示文本
                "records": data.records, //解析数据长度
                "rows": data.rows //解析数据列表
            };
        }
        , toolbar: '#userTableToolbarDemo'
        , title: '订单列表'
        , cols: [[
            {field: 'orderId', title: 'orderId', hide: true}
            , {field: 'userName', title: '用户名称'}
            , {field: 'late', title: '订单延期情况'}
            , {field: 'state', title: '订单状态'}
            , {field: 'gname', title: '垃圾名'}
            , {field: 'weight', title: '预约重量'}
            , {field: 'hname', title: '地点名称'}
            , {field: 'address', title: '详细地址'}
            , {field: 'gotime', title: '上门时间'}
            , {field: 'gotimes', title: '上门时间段'}
            , {field: 'description', title: '备注'}
            , {field: 'ordertime', title: '下单时间'}
            , {field: 'companyName', title: '公司名', hide: true}
            , {field: 'companyTel', title: '公司电话', hide: true}
            , {field: 'rweight', title: '实际重量（kg）', hide: true}
            , {field: 'money', title: '交易金额（元）', hide: true}
            , {fixed: 'right',width:80, title: '操作', toolbar: '#userTableBarDemo'}
        ]]
        , defaultToolbar: ['', '', '']
        , page: true
        , height: height
        , cellMinWidth: 80
    });

        }
    });


    //头工具栏事件
    table.on('toolbar(test)', function (obj) {
        switch (obj.event) {
            case 'addData':
                //重置操作表单
                $("#userForm")[0].reset();
                let nowTime = commonUtil.getNowTime();
                $("input[name='createTime']").val(nowTime);
                $("input[name='updateTime']").val(nowTime);
                $("input[name='lastChangePwdTime']").val(nowTime);
                $("input[name='lastLoginTime']").val(nowTime);

                $("input[name='loginName']").removeAttr("readonly");

                form.render();
                loadMenuTree();
                loadAuthorityTree();
                layer.msg("请填写右边的表单并保存！");
                break;
            case 'query':
                let queryByGarbageName = $("#queryByGarbageName").val();
                let query = {
                    page: {
                        curr: 1 //重新从第 1 页开始
                    }
                    , done: function (res, curr, count) {
                        //完成后重置where，解决下一次请求携带旧数据
                        // this.where = {};
                    }
                };
                if (!queryByGarbageName) {
                    queryByGarbageName = "";
                }
                //设定异步数据接口的额外参数
                query.where = {gname: queryByGarbageName};
                tableIns.reload(query);
                $("#queryByGarbageName").val(queryByGarbageName);
                break;
            case 'reload':
                tableInsOnLine.reload();
                break;
        }
    });

    //监听行工具事件
    table.on('tool(test)', function (obj) {
        let data = obj.data;
        //删除
        if (obj.event === 'del') {
            layer.confirm('确认删除吗？', function (index) {
                //向服务端发送删除指令
                $.delete(ctx + "/sys/sysUser/delete/" + data.userId, {}, function (data) {
                    tableIns.reload();
                    layer.close(index);
                })
            });
        }

        //延期
        else if (obj.event === 'lateOrder') {

            layer.open({
                type:1,
                title:"订单延期",
                area:['500px','300px'],
                content:$("#lateOrder1"),
                btn:['确定','取消'],
                btn1:function(index){
                    let gotime1=parseInt(data.gotimes.substring(6,8));
                    let gotime2=parseInt(data.gotimes.substring(9,11));
                    // console.log(gotime1);
                    // console.log(gotime2);
                    // debugger
                    let timelate=$("#late").val();
                    let time1=gotime1*60+gotime2+parseInt(timelate);
                    let num2=time1%60;
                    let num1=(time1-num2)/60;
                    if(num2==0){
                        num2='00';
                    }
                    // debugger
                    let late1='延时'+timelate+'分钟，预计将于'+num1+':'+num2+'到达';
                    console.log(late1);
                    //debugger
                          $.post(ctx + "/order/order2/save", {
                            orderId:data.orderId,
                            late:late1,
                              rweight:data.rweight,
                              money:data.money,
                              state:data.state,
                              companyId:data.companyId,
                              userId:data.userId,
                              gid:data.gid,
                              hid:data.hid,
                              gotimes:data.gotimes,
                              gotime:data.gotime,
                              weight:data.weight,
                              address:data.address,
                              description:data.description,
                              ordertime:data.ordertime
                        }, function (data1) {
                            if(data1.flag){
                                layer.msg("操作成功", {icon: 1, time: 2000}, function () {});
                                tableIns.reload();
                            }
                            layer.close(index);
                        });
                },

                btn2:function(index){
                    layer.close(index);
                }
            });
        }
        //完成订单
        else if(obj.event === 'finishOrder'){

            $.post(ctx + "/info/infogarbage/receivegarbage", {gname:data.garbageName}, function (data1) {
                if(data1.flag){
                    // let rweight = $("#rweight");
                    // $("#price").val(data1.price*rweight);
                    price = data1.data.gprice;
                }
            });
            // debugger

            layer.open({
                type:1,
                title:"确认交易",
                area:['500px','300px'],
                content:$("#finishOrder1"),
                btn:['确定','取消'],
                btn1:function(index){

                    $.post(ctx + "/order/order/save", {
                        orderId:data.orderId,
                        rweight:$("#rweight").val(),
                        money:$("#price").val(),
                        state:'已完成'
                    }, function (data1) {
                        if(data1.flag){
                            // let rweight = $("#rweight");
                            // $("#price").val(data1.price*rweight);
                            layer.msg("操作成功");
                        }
                        layer.close(index);
                    });
                },
                btn2:function(index){
                    layer.close(index);
                }
            });





            return;
            //debugger
            // let data1 ={
            //     state:'已完成',
            //     orderId:data.orderId,
            //     //companyName:window.parent.loginName
            // };
            // $.post(ctx + "/order/order/save", data1, function (data2) {
            //
            //     if (!data2.flag) {
            //         layer.msg(data2.msg, {icon: 2, time: 2000}, function () {
            //         });
            //         return;
            //     }
            // });
        }
        //编辑
        else if (obj.event === 'edit') {
            //回显操作表单
            $("#userForm").form(data);
            $("input[name='loginName']").attr("readonly","readonly");

            form.render();
            loadMenuTree();
            loadAuthorityTree();
        }

    });


});
$("#rweight").on('input',function (){
    $("#price").val($(this).val()*price)
});
function getNowFormatDate() {
    let date = new Date();
    let seperator1 = "-";
    let year = date.getFullYear();
    let month = date.getMonth() + 1;
    let strDate = date.getDate();
    if (month >= 1 && month <= 9) {
        month = "0" + month;
    }
    if (strDate >= 0 && strDate <= 9) {
        strDate = "0" + strDate;
    }
    let currentdate = year + seperator1 + month + seperator1 + strDate;
    return currentdate;
}