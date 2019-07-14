$(function () {
    $("#jqGrid").jqGrid({
        url: 'sys/generator/list',
        datatype: "json",
        colModel: [			
			{ label: '表名', name: 'tableName', width: 100, key: true },
			{ label: '表备注', name: 'tableComment', width: 100 },
			{ label: '创建时间', name: 'createTime', width: 100 }
        ],
		viewrecords: true,
        height: 385,
        rowNum: 10,
		rowList : [10,30,50,100,200],
        rownumbers: true, 
        rownumWidth: 25, 
        autowidth:true,
        multiselect: true,
        pager: "#jqGridPager",
        jsonReader : {
            root: "page.list",
            page: "page.currPage",
            total: "page.totalPage",
            records: "page.totalCount"
        },
        prmNames : {
            page:"page", 
            rows:"limit", 
            order: "order"
        },
        gridComplete:function(){
        	//隐藏grid底部滚动条
        	$("#jqGrid").closest(".ui-jqgrid-bdiv").css({ "overflow-x" : "hidden" }); 
        }
    });
});

var vm = new Vue({
	el:'#rrapp',
	data:{
		q:{
			tableName: null
		}
	},
	methods: {
		query: function () {
			$("#jqGrid").jqGrid('setGridParam',{ 
                postData:{'tableName': vm.q.tableName},
                page:1 
            }).trigger("reloadGrid");
		},
		generator: function() {
			var tableNames = getSelectedRows();
			if(tableNames == null){
				return ;
			}
            $.ajax({
                type: "get",
                url: "sys/generator/code?tables=" + tableNames.join(),
                dataType: "json",
                async: false,
                success: function (data) {
                    if (data.result) {
                        parent.layer.alert(data.msg, {icon: 1}, function (index) {
                            location.reload(true);
                            parent.layer.close(index);
                        });
                    } else {
                        parent.layer.alert(data.msg, {icon: 2}, function (index) {
                            location.reload(true);
                            parent.layer.close(index);
                        });
                    }
                },
                error: function () {
                    parent.layer.alert("服务器异常", {icon: 2}, function (index) {
                        location.reload(true);
                        parent.layer.close(index);
                    });
                }
            });
		}
	}
});

