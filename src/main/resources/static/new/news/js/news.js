layui.use(['element', 'form', 'table', 'layer', 'laydate', 'tree', 'util'], function () {

    $.post(ctx + "/info/infonews/page", {page: 1, rows: 10, sidx: 'newTime', sord: 'desc'}, function (data) {
        if (data.flag) {
            //debugger
            for (let i = 0; i < data.data.rows.length; i++) {
                let $div = $('<div class="border1"></div>');
                $div.append('<div class="date"><div class="date1" ">' + data.data.rows[i].newTime.split(' ')[0].split('-')[2] + '</div><div>'+data.data.rows[i].newTime.split(' ')[0].split('-')[0]+'/'+data.data.rows[i].newTime.split(' ')[0].split('-')[1]+'</div></div>');
                $div.append('<div class="title">' + data.data.rows[i].newTitle + '</div>');

                $('<div class="button"><button class="button1">查看详情</button></div>').click(function(){
                    layer.open({
                        type: 1,
                        title: data.data.rows[i].newTitle,
                        area: ['700px', '500px'],
                        content: data.data.rows[i].newText,
                        btn: ['确定'],
                        btn1: function (index) {
                            layer.close(index);
                        },
                    });
                }).appendTo($div);
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