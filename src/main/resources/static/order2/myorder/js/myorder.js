let tableIns;
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
            userId:data3.data.userId
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
            let data = res.data;
            console.log(data);
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
            , {field: 'userName', title: '用户名称', hide: true}
            , {field: 'state', title: '订单状态'}
            , {field: 'gname', title: '垃圾名'}
            , {field: 'weight', title: '预约重量'}
            , {field: 'hname', title: '地点名称'}
            , {field: 'address', title: '详细地址'}
            , {field: 'gotime', title: '上门时间'}
            , {field: 'gotimes', title: '上门时间段'}
            , {field: 'late', title: '订单延期情况'}
            , {field: 'companyName', title: '公司名'}
            , {field: 'companyTel', title: '公司电话'}
            , {field: 'rweight', title: '实际重量（kg）'}
            , {field: 'money', title: '交易金额（元）'}
            , {field: 'description', title: '备注'}
            , {field: 'ordertime', title: '下单时间'}
            , {fixed: 'right',width:300, title: '操作', toolbar: '#userTableBarDemo', hide: true}
        ]]
        , defaultToolbar: ['', '', '']
        , page: true
        , height: height
        , cellMinWidth: 80
    });
// console.log(data.data);
            // debugger
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
                query.where = {state: queryByGarbageName};
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