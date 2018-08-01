function BaseComponent($view,url) {
    let baseModel = null;
    let itemModel = null;
    let tempItemId = null;  //记录当前显示的item的base的id
    init();

    function init() {
        $view.find("addBaseForm").on("submit",(e)=>{
            e.preventDefault();
            let obj = $(e.target).serializeObject();
            //  console.log(obj);
            myAjax(url+"bases","POST",obj,(nc)=>{
                baseModel.push(nc);
                render();
            })
        })


        $view.find("addItemForm").on("submit",(e)=>{
            e.preventDefault();
            let obj = $(e.target).serializeObject();
            //  console.log(obj);
            myAjax(url+"items","POST",obj,(nc)=>{
                itemModel.push(nc);
                renderSub();
            })
        })

        //初始化加载base的内容，item的内容等待具体base被点击时才加载
        myAjax(url+"bases","GET",null,(bases)=>{
            baseModel = bases;
            render();
        })

    }

    function render() {
        let $tbody=$view.find("#baseList tbody");
        $tbody.empty();
        baseModel.forEach((base)=>{
            $("<tr>")
                .append($("<td>").text(base.id))
                .append($("<td>").text(base.baseName))
                .append($("<td>")
                    .append($("<button>").text("删除")
                        .on("click",(e)=>{deleteBase(base)})))
                .on("dblclick",(e)=>{                    //双击之后出发item数据获取、视图渲染
                    myAjax(url+"items"+base.id,"GET",null,(items)=>{
                        itemModel = items;
                        tempItemId = base.id;
                        renderSub();
                    })
                })
                .appendTo($tbody)
        })

    }

    function renderSub() {
        let $tbody=$view.find("#itemList tbody");
        $tbody.empty();
        itemModel.forEach((item)=>{
            $("<tr>")
                .append($("<td>").text(item.id))
                .append($("<td>").text(item.itemName))
                .append($("<td>").text(item.itemNum))
                .append($("<td>").text(item.base))
                .append($("<td>")
                    .append($("<button>").text("删除")
                        .on("click",(e)=>{deleteItem(item)})))
                .appendTo($tbody)
        })

    }

    function deleteBase(base) {
        myAjax(url+"bases"+base.id,"DELETE",null,(msg)=>{
            if (msg.error){
                alert("删除异常");
            }
            else{
                let index = baseModel.indexOf(base);
                baseModel.splice(index,1);
                render();
                if (tempItemId==base.id){    //检测到被删除的base的item正在显示，删除试图

                }
            }
        })
    }
    function deleteItem(item) {

    }

}

$(function () {
    BaseComponent($("#app"),"base/");
})