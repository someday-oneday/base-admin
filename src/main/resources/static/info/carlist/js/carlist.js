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
        , url: ctx + '/sys/carCompanyGarbage/page'
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
            // debugger
            let data = res.data;
            return {
                "flag": res.flag, //解析接口状态
                "msg": res.msg, //解析提示文本
                "records": data.records, //解析数据长度
                "rows": data.rows //解析数据列表
            };
        }
        , toolbar: '#userTableToolbarDemo'
        , title: '车辆列表'
        , cols: [[
            {field: 'carId', title: '车辆id', hide: true}
            , {field: 'carName', title: '车辆名'}
            , {field: 'carLoad', title: '车辆载重（kg）'}
            , {field: 'carNumber', title: '车辆数目'}
            , {field: 'companyId', title: '所属单位id', hide: true}
            , {field: 'companyName', title: '所属单位名称'}
            , {field: 'companyTel', title: '单位电话', hide: true}
            , {field: 'companyBusiness', title: '单位业务', hide: true}
            , {field: 'gid', title: '垃圾id', hide: true}
            , {field: 'gname', title: '处理垃圾类型'}
            , {field: 'gprice', title: '垃圾单价（元）', hide: true}
            , {field: 'gdescribe', title: '垃圾描述', hide: true}
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
                $.post(ctx + "/info/company1/list", {}, function (data2) {
                    if(data2.flag){
                        // debugger
                        // layer.msg(data.msg,{icon:1,timeout:2000});
                        // data.data
                        $('#selectCompany1').empty();
                        for(let i = 0 ; i < data2.data.length ; i ++){
                            $('#selectCompany1').append(' <option value="'+data2.data[i].companyId+'">'+data2.data[i].companyName+'</option>');
                        }
                    }
                });
                $.post(ctx + "/info/infogarbage/list", {}, function (data3) {
                    if(data3.flag){
                        // debugger
                        // layer.msg(data.msg,{icon:1,timeout:2000});
                        // data.data
                        $('#selectGarbage1').empty();
                        for(let i = 0 ; i < data3.data.length ; i ++){
                            $('#selectGarbage1').append(' <option value="'+data3.data[i].gid+'">'+data3.data[i].gname+'</option>');
                        }
                    }
                });
                layer.open({
                    type: 1,
                    title: "新增车辆",
                    area: ['500px', '300px'],
                    content: $("#addCarCompany1"),
                    btn: ['确定', '取消'],
                    btn1: function (index) {

                        $.post(ctx + "/info/infocar/save", {
                            // carId: data.carId,
                            carName:$("#carname1").val(),
                            companyId:$("#selectCompany1").val(),
                            carLoad: $("#weight1").val(),
                            carNumber: $("#number1").val(),
                            gid:$("#selectGarbage1").val()
                        }, function (data1) {
                            if (data1.flag) {
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
                query.where = {companyName: queryByGarbageName};
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
                $.delete(ctx + "/info/infocar/delete/" + data.carId, {}, function (data) {
                    layer.msg("删除成功", {icon: 1,time: 2000}, function () {});
                    tableIns.reload();
                })
            });
        }
        //修改
        else if(obj.event === 'editCarCompany') {
            $.post(ctx + "/info/company1/list", {}, function (data2) {
                if(data2.flag){
                    // debugger
                    // layer.msg(data.msg,{icon:1,timeout:2000});
                    // data.data
                    $('#selectCompany').empty();
                    for(let i = 0 ; i < data2.data.length ; i ++){
                        $('#selectCompany').append(' <option value="'+data2.data[i].companyId+'">'+data2.data[i].companyName+'</option>');
                    }
                }
            });
            $.post(ctx + "/info/infogarbage/list", {}, function (data3) {
                if(data3.flag){
                    // debugger
                    // layer.msg(data.msg,{icon:1,timeout:2000});
                    // data.data
                    $('#selectGarbage').empty();
                    for(let i = 0 ; i < data3.data.length ; i ++){
                        $('#selectGarbage').append(' <option value="'+data3.data[i].gid+'">'+data3.data[i].gname+'</option>');
                    }
                }
            });
            console.log(data);
            // debugger
            $("#carname").val(data.carName);
            $("#weight").val(data.carLoad);
            $("#number").val(data.carNumber);
            // $("#selectCompany").val(data.companyId);
            // $("#selectGarbage").val(data.gid);

            layer.open({
                type: 1,
                title: "修改车辆",
                area: ['500px', '300px'],
                content: $("#editCarCompany1"),
                btn: ['确定', '取消'],
                btn1: function (index) {

                    $.post(ctx + "/info/infocar/save", {
                        carId: data.carId,
                        carName:$("#carname").val(),
                        companyId:$("#selectCompany").val(),
                        carLoad: $("#weight").val(),
                        carNumber: $("#number").val(),
                        gid:$("#selectGarbage").val()
                    }, function (data1) {
                        if (data1.flag) {
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