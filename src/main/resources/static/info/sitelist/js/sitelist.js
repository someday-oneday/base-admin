let tableIns;
layui.use(['element', 'form', 'table', 'layer', 'laydate', 'tree', 'util'], function () {
    let table = layui.table;
    let form = layui.form;//select、单选、复选等依赖form
    let element = layui.element; //导航的hover效果、二级菜单等功能，需要依赖element模块
    let laydate = layui.laydate;
    tree = layui.tree;
    let height = 400;

    //用户列表
    tableIns = table.render({
        elem: '#userTable'
        , url: ctx + '/sys/siteGarbage/page'
        , method: 'POST'
        //请求前参数处理
        , request: {
            pageName: 'page' //页码的参数名称，默认：page
            , limitName: 'rows' //每页数据量的参数名，默认：limit

        }
        // ,where:{
        //     //userName:window.parent.loginName
        //     state: '未接收'
        // }
        , response: {
            statusName: 'flag' //规定数据状态的字段名称，默认：code
            , statusCode: true //规定成功的状态码，默认：0
            , msgName: 'msg' //规定状态信息的字段名称，默认：msg
            , countName: 'records' //规定数据总数的字段名称，默认：count
            , dataName: 'rows' //规定数据列表的字段名称，默认：data
        }
        //响应后数据处理
        , parseData: function (res) { //res 即为原始返回的数据
            console.log(res.data.rows);
            var data = res.data;
            return {
                "flag": res.flag, //解析接口状态
                "msg": res.msg, //解析提示文本
                "records": data.records, //解析数据长度
                "rows": data.rows //解析数据列表
            };
        }
        , toolbar: '#userTableToolbarDemo'
        , title: '垃圾回收处理站列表'
        , cols: [[
            {field: 'siteId', title: '垃圾回收处理站id', hide: true}
            , {field: 'siteName', title: '垃圾回收处理站名'}
            , {field: 'siteDescription', title: '站点描述'}
            , {field: 'siteLat', title: '纬度'}
            , {field: 'siteLng', title: '经度'}
            , {field: 'gid', title: '垃圾id', hide: true}
            , {field: 'gname', title: '回收处理垃圾种类'}
            , {field: 'gid', title: '垃圾描述', hide: true}
            , {fixed: 'right', width: 150, title: '操作', toolbar: '#userTableBarDemo'}
        ]]
        , defaultToolbar: ['', '', '']
        , page: true
        , height: height
        , cellMinWidth: 80
    });


    //头工具栏事件
    table.on('toolbar(test)', function (obj) {
        switch (obj.event) {
            case 'addData':
                $.post(ctx + "/info/infogarbage/list", {}, function (data2) {
                    if(data2.flag){
                        console.log(data2);
                        // debugger
                        // layer.msg(data.msg,{icon:1,timeout:2000});
                        // data.data
                        $('#selectGarbage1').empty();
                        for(let i = 0 ; i < data2.data.length ; i ++){
                            $('#selectGarbage1').append(' <option value="'+data2.data[i].gid+'">'+data2.data[i].gname+'</option>');
                        }
                    }
                });

                layer.open({
                    type: 1,
                    title: "新增垃圾回收处理站",
                    area: ['500px', '350px'],
                    content: $("#addHouse1"),
                    btn: ['确定', '取消'],
                    btn1: function (index) {
                        //console.log(data.hid);
                        // debugger
                        $.post(ctx + "/info/infosite/save", {
                            // hid: data.hid,
                            siteDescription:$("#siteDescription1").val(),
                            siteName:$("#siteName1").val(),
                            siteLat: $("#lat1").val(),
                            siteLng: $("#lng1").val(),
                            siteGarbageId:$("#selectGarbage1").val()
                        }, function (data1) {
                            if (data1.flag) {
                                console.log(data1);
                                // debugger
                                // let rweight = $("#rweight");
                                // $("#price").val(data1.price*rweight);
                                layer.msg("新增成功", {icon: 1,time: 2000}, function () {});
                                tableIns.reload();
                            }
                            layer.close(index);
                        });
                    },
                    btn2: function (index) {
                        layer.close(index);
                    }
                });
                // return;
                break;

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
        console.log(data);
        //debugger
        if (obj.event === 'del') {
            layer.confirm('确认删除吗？', function (index) {
                //向服务端发送删除指令
                $.delete(ctx + "/info/infosite/delete/" + data.siteId, {}, function (data) {
                    layer.msg("删除成功", {icon: 1,time: 2000}, function () {});
                    tableIns.reload();
                    layer.close(index);
                })
            });
        }
        //修改
        else if(obj.event === 'editSite') {
            $.post(ctx + "/info/infogarbage/list", {}, function (data2) {
                if(data2.flag){
                    //console.log(data2);
                    //debugger
                    // layer.msg(data.msg,{icon:1,timeout:2000});
                    // data.data
                    $('#selectGarbage').empty();
                    for(let i = 0 ; i < data2.data.length ; i ++){
                        $('#selectGarbage').append(' <option value="'+data2.data[i].gid+'">'+data2.data[i].gname+'</option>');
                    }
                }
            });

            console.log(data);
            $("#siteName").val(data.siteName);
            $("#lat").val(data.siteLat);
            $("#lng").val(data.siteLng);
            $("#siteDescription").val(data.siteDescription);
            layer.open({
                type: 1,
                title: "修改垃圾回收处理站",
                area: ['500px', '350px'],
                content: $("#editSite1"),
                btn: ['确定', '取消'],
                btn1: function (index) {
                    console.log(data.siteId);
                    console.log($("#siteName").val());
                    console.log($("#lat").val());
                    console.log($("#lng").val());
                    console.log($("#selectGarbage").val());
                    debugger
                    $.post(ctx + "/info/infosite/save", {
                        siteId: data.siteId,
                        siteDescription:$("#siteDescription").val(),
                        siteName:$("#siteName").val(),
                        siteLat: $("#lat").val(),
                        siteLng: $("#lng").val(),
                        siteGarbage:$("#selectGarbage").val()
                    }, function (data4) {
                        if (data4.flag) {
                            console.log(data4);
                            debugger
                            // let rweight = $("#rweight");
                            // $("#price").val(data1.price*rweight);
                            layer.msg("修改成功", {icon: 1,time: 2000}, function () {});
                            tableIns.reload();
                        }
                        layer.close(index);
                    });
                },
                btn2: function (index) {
                    layer.close(index);
                }
            });
            return;
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