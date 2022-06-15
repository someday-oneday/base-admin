let tableIns;
layui.use(['element', 'form', 'table', 'layer', 'laydate', 'tree', 'util'], function () {
    let table = layui.table;
    let form = layui.form;//select、单选、复选等依赖form
    let element = layui.element; //导航的hover效果、二级菜单等功能，需要依赖element模块
    let laydate = layui.laydate;
    tree = layui.tree;
    let height = 400;


    $.post(ctx + "/sys/sysUser/getUser", {
        loginName: window.parent.loginName
    }, function (data3) {
        if (data3.flag) {
            console.log(data3);
            $.post(ctx + "/order/order2/list", {
                gotime: getNowFormatDate(),
                companyId:data3.data.companyId,
            }, function (data2) {
                if (data2.flag) {
                    console.log(data2);
                     //debugger
                    // let arrayLength = data2.data.length;
                    $.post(ctx + "/info/infogarbage/list", {
                    }, function (data1) {
                        if (data1.flag) {
                            console.log(data1);
                            //debugger
                            // let arrayLength = data2.data.length;

                            let garbagenumber1 = new Array(data1.data.length);//垃圾id
                            let garbagenumber2 = new Array(data1.data.length);//垃圾估重
                            let garbagenumber3 = new Array(data1.data.length);//垃圾车载重（默认载重1000kg）
                            let garbagenumber4 = new Array(data1.data.length);//推荐垃圾车数量
                            let garbagenumber5 = new Array(data1.data.length);//垃圾名
                            let garbagenumber6 = new Array(data1.data.length);//垃圾车名
                            for (let i=0;i<data1.data.length;i++){
                                garbagenumber1[i]=data1.data[i].gid;
                                garbagenumber2[i]=0;
                                garbagenumber3[i]=1000;
                                garbagenumber4[i]=0;
                                garbagenumber5[i]=data1.data[i].gname;
                            }
                            for(let i=0;i<data2.data.length;i++){
                                for(let j=0;j<data1.data.length;j++){
                                    if(data2.data[i].gid === garbagenumber1[j]){
                                        garbagenumber2[j]+=findGarbageWeight(data2.data[i].weight);
                                    }
                                }
                            }


                            $.post(ctx + "/info/infocar/list", {
                                companyId: data3.data.companyId,
                            }, function (data4) {
                                if (data4.flag) {
                                    console.log(data4);
                                    let car1=new Array(data4.data.length);//垃圾id
                                    let car2= new Array(data4.data.length);//垃圾车载重
                                    let car3= new Array(data4.data.length);//垃圾车名
                                    for (let i=0;i<data4.data.length;i++){
                                        car1[i]=data4.data[i].gid;
                                        car2[i]=data4.data[i].carLoad;
                                        car3[i]=data4.data[i].carName;
                                    }
                                    for(let i=0;i<data1.data.length;i++){
                                        for(let j=0;j<data4.data.length;j++){
                                            if(garbagenumber1[i] === car1[j]){
                                                garbagenumber3[i]=car2[j];
                                                garbagenumber6[i]=car3[j];
                                            }
                                        }
                                    }
                                    for(let i=0;i<data1.data.length;i++){
                                        if(garbagenumber2[i] !== '0'){
                                            let cars1=garbagenumber2[i]%garbagenumber3[i];
                                            let cars2=(garbagenumber2[i]-cars1)/garbagenumber3[i];
                                            if(cars1 !== '0'){
                                                cars2=cars2+1;
                                                console.log(cars1);
                                                console.log(cars2);
                                                // debugger
                                            }
                                            garbagenumber4[i]=cars2;
                                        }

                                    }
                                    console.log(garbagenumber1);
                                    console.log(garbagenumber2);
                                    console.log(garbagenumber3);
                                    console.log(garbagenumber4);
                                    console.log(garbagenumber5);
                                    console.log(garbagenumber6);
                                    for (let i=0;i<data1.data.length;i++){
                                        if (garbagenumber2[i]) {
                                            if (garbagenumber6[i]) {
                                                let $div = $('<div class="border1" ></div>');
                                                $div.append('<div class="date2" >'+ garbagenumber4[i]+'辆 载重'+ garbagenumber3[i]+'kg '+ garbagenumber6[i] +'（'+garbagenumber5[i]+garbagenumber2[i]+'kg）</div>');
                                                // $div.append('<div class="date1" >' + garbagenumber5[i] + garbagenumber2[i] + 'kg</div>');
                                                $div.appendTo($("#main"));

                                            }else {
                                                let $div = $('<div class="border1" ></div>');
                                                $div.append('<div class="date2" >需要增加' + garbagenumber4[i]+'辆 载重'+garbagenumber3[i] + 'kg '+garbagenumber5[i] +'类型的回收车('+garbagenumber5[i]+garbagenumber2[i]+'kg）</div>');
                                                // $div.append('<div class="date1" >' + garbagenumber5[i]+ garbagenumber2[i] + 'kg</div>');
                                                $div.appendTo($("#main"));

                                            }
                                        }
                                    }

                                    //debugger
                                }
                            });
                        }
                    });
                }
            });
        }
    });


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
function findGarbageWeight(weight){
    let gar1='不足5kg';
    let gar2='5-10kg';
    let gar3='10-20kg';
    let gar4='20-50kg';
    let gar5='5kg以上';
    if(weight === gar1){
        return 5;
    }else if (weight === gar2){
        return 10;
    }else if (weight === gar3){
        return  20;
    }else if (weight === gar4){
        return 50;
    }else
        return 80;
}