layui.use(['element', 'form', 'table', 'layer', 'laydate', 'tree', 'util'], function () {

    $.post(ctx + "/info/infomessage/page", {page: 1, rows: 5, sidx: 'newTime', sord: 'desc'}, function (data) {
        if (data.flag) {
            //debugger
            for (let i = 0; i < data.data.rows.length; i++) {
                let $div = $('<div class="border1" ></div>');
                $div.append('<div class="date" ><div class="username">'+ data.data.rows[i].userName+'</div><div class="date1"> '+data.data.rows[i].mtime.split(' ')[0].split('-')[0]+'.'+data.data.rows[i].mtime.split(' ')[0].split('-')[1]+'.'+data.data.rows[i].mtime.split(' ')[0].split('-')[2] +'</div></div>');
                $div.append('<div class="title" >' + data.data.rows[i].mcontent + '</div>');
                $div.appendTo($("#main"));
            }
            // layer.msg(data.msg,{icon:1,timeout:2000});
            // data.data

        }
    });


})
// let data=[{
//     id:1,
//     title:"标题1",
//     date:'2022-03-29'
// },{id:2,
//     title:"标题2",
//     date:'2022-03-29'},{id:3,
//     title:"标题3",
//     date:'2022-03-29'}];
// for(let i=0,button1; i< data.length;i++){
//     let $div=$('<div></div>');
//     $div.append('<span>'+data[i].title+'</span>');
//     $div.append('<button onclick="">查看详情</button>');
//     $div.appendTo($("#main"));
// }
function checkContent(e) {
    debugger
    layer.open({
        type: 1,
        title: "公告",
        area: ['700px', '500px'],
        content: e.getAttribute('data-content'),
        btn: ['确定', '取消'],
        btn1: function (index) {
            layer.close(index);
        },
        btn2: function (index) {
            layer.close(index);
        }
    });
}

function comment(){
    let commentForm = $("#form_message").serializeObject();
    console.log(commentForm);
    console.log(window.parent.loginName);
    // debugger
    $.post(ctx + "/sys/sysUser/getUser", {
        loginName: window.parent.loginName
    }, function (data3) {
        if (data3) {
                console.log(data3);
                console.log(data3.data.userName);
                debugger
                commentForm.userName = data3.data.userName;
                console.log(commentForm);
            }
        });
    $.post(ctx + "/info/infomessage/saveMessage", commentForm, function (data1) {
        if (data1) {
            console.log(data1);
            debugger
            // let rweight = $("#rweight");
            // $("#price").val(data1.price*rweight);
            layer.msg("发布成功", {icon: 1, time: 2000}, function () {
            });
        }
    });
    // $.post(ctx + "/info/infomessage/saveMessage", commentForm, function (data) {
    //     debugger
    //     if(data.flag){
    //         layer.msg("评论成功！",{icon:1,timeout:2000});
    //     }
    // });
}