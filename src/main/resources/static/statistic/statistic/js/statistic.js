$.post(ctx + "/info/infocompany/findSysUserCompanyByLoginName", {loginName: window.parent.loginName}, function (data) {

    if(data.flag){
        // layer.msg(data.msg,{icon:1,timeout:2000});
        // data.data
        $.post(ctx + "/companygarbage/companygarbage/statistic", {companyName: data.data.companyName}, function (data1) {
            // debugger
            if(data1.flag){
                // layer.msg(data.msg,{icon:1,timeout:2000});
                // data.data
                let xarray1 = [];
                let yarray1 = [];
                for(let i = 0 ; i < data1.data.length ; i++){
                    xarray1.push(data1.data[i].garbageName);
                    yarray1.push(data1.data[i].sumRweight);
                }
                // debugger
                console.log(data1);
            }
        });
        $.post(ctx + "/companycommunityrweight/companycommunityrweight/findCompanyCommunityRweightsByCompanyName", {companyName: data.data.companyName}, function (data2) {
             // debugger
            if(data2.flag) {
                // layer.msg(data.msg,{icon:1,timeout:2000});
                // data.data
                let xarray2 = [];
                let yarray2 = [];

                for (let i = 0; i < data2.data.length; i++) {
                    xarray2.push(data2.data[i].comName);
                    yarray2.push(data2.data[i].sumRweight);
                }
                console.log(data2);
                // debugger push({name:['221'],age:77})
            }
        });
    }
});
