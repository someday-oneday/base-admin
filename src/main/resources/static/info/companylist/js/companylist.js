let tableIns;
layui.use(['element', 'form', 'table', 'layer', 'laydate', 'tree', 'util'], function () {
    let table = layui.table;
    let form = layui.form;//select、单选、复选等依赖form
    let element = layui.element; //导航的hover效果、二级菜单等功能，需要依赖element模块
    let laydate = layui.laydate;
    tree = layui.tree;
    let height = 400;
    // $.ajax({
    //     type:"GET",
    //     url:ctx + '/info/infocompany/companylist',
    //     dataType:"json",
    //     success:function(data){
    //         //debugger
    //     },
    //     error:function(jqXHR){
    //         console.log("Error: "+jqXHR.status);
    //     }
    // });
    //用户列表
    tableIns = table.render({
        elem: '#userTable'
        , url: ctx + '/info/infocompany/page'
        , method: 'POST'
        //请求前参数处理
        , request: {
            pageName: 'page' //页码的参数名称，默认：page
            , limitName: 'rows' //每页数据量的参数名，默认：limit

        }
        ,where:{
        //     //userName:window.parent.loginName
        //     state: '未接收'

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
            {field: 'userId', title: 'ID', hide: true}
            , {field: 'userName', title: '用户名称'}
            , {field: 'loginName', title: '登录名'}
            , {field: 'valid', title: '是否允许登录系统（软删除）', hide: true}
            , {field: 'limitMultiLogin', title: '是否允许多人在线', hide: true}
            , {field: 'limitedIp', title: '限制允许登录的IP集合', hide: true}
            , {field: 'expiredTime', title: '账号失效时间', hide: true}
            , {field: 'lastChangePwdTime', title: '最近修改密码时间', hide: true}
            , {field: 'createTime', title: '创建时间', hide: true}
            , {field: 'updateTime', title: '更新时间', hide: true}
            , {field: 'companyId', title: '公司id'}
            , {field: 'companyName', title: '公司名'}
            , {field: 'companyBusiness', title: '公司业务'}
            , {field: 'companyTel', title: '公司电话'}
            , {fixed: 'right', title: '操作', toolbar: '#userTableBarDemo'}
        ]]
        , defaultToolbar: ['', '', '']
        , page: true
        , height: height
        , cellMinWidth: 80
    });


    //头工具栏事件
    table.on('toolbar(test)', function (obj) {
        switch (obj.event) {
            case 'receiveOrder':
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
                query.where = {garbageName: queryByGarbageName};
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
                    layer.msg("删除成功", {icon: 1,time: 2000}, function () {});
                    tableIns.reload();
                    layer.close(index);
                })
            });
        }
        //编辑
        else if (obj.event === 'edit') {
            //回显操作表单
            $("#userForm").form(data);
            $("input[name='loginName']").attr("readonly", "readonly");

            form.render();
            loadMenuTree();
            loadAuthorityTree();
        }

    });


});