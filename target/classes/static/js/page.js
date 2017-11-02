$(function () {
    $('#test').bind('click', function () {

        $.ajax({
            url: '/ag/all',
            type: "GET",
            contentType: 'application/json;charset=utf-8',
            data: "json",
            cache: false,
            beforeSend: function () {
                $("#list").html('加载中...');
            }, //加载执行方法
            error: function () {
                alert("error");
            },  //错误执行方法
            //成功执行方法
            success: function (response) {
                $("#list").html('');
                var json = eval(response); //数组
                console.log(json);//可以在控制台查看打印的data值
                $.each(json, function (index, item) {
                    //循环获取数据
                    var time = json[index].time;
                    $("#list").append(" <li value = "+time+">"+time+"</li>");

                   // addLi(time);
                   // $("#list").html($("#list").html() + time + " <br/> ");
                });
            }
        });
    });

    $('#test1').bind('click', function () {

        var list = document.getElementsByTagName("li");
        //alert(list.length);
        //给每个li绑定事件
        for (var i = 0; i < list.length; i++) {
            //alert(i);
            list[i].onclick = function () {
                document.location ="detail.html?username="+$(this).text();
            }
        }

    });

    function addLi(username) {
        var li_1 = document.createElement("li");
        li_1.setAttribute("class", "newLi");
        addSpan(li_1, username);
        addDelBtn(li_1);
        document.getElementById("J_List").appendChild(li_1);
    }
    //为姓名或邮箱等添加span标签，好设置样式
    function addSpan(li,text){
        var span_1=document.createElement("span");
        span_1.innerHTML=text;
        li.appendChild(span_1);
    }
    //添加删除按钮及设置删除按钮的样式及添加点击事件
    function addDelBtn(li){
        var span_1=document.createElement("span");
        var btn=document.createElement("button");
        btn.setAttribute("type","button");
        btn.setAttribute("class","delBtn");
        btn.setAttribute("onclick","delBtnData(this)");
        btn.innerHTML="删除";
        span_1.appendChild(btn);
        li.appendChild(span_1);
    }
    //为删除按钮添加删除节点功能
    function delBtnData(obj){
        var ul=document.getElementById("J_List");
        var oLi=obj.parentNode.parentNode;
        //obj.parentNode指删除按钮的span层
        //obj.parentNode.parentNode为li层
        ul.removeChild(oLi);
    }

});