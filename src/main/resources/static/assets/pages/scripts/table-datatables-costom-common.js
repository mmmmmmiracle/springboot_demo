var TableDatatablesManaged = function () {

	var getAddButtonCodes = function(buttonText,buttonURL) {
    if(!(stringIsNullOrEmpty(buttonText)||stringIsNullOrEmpty(buttonURL))){
      return "<div class=\"btn-group\"><button id=\"sample_editable_1_new\" class=\"btn sbold yellow-gold\" onclick=\"javascript:window.location.href='"+buttonURL+"'\" href='#detail' data-toggle='modal'>"+buttonText+"<i class=\"fa fa-plus\"></i></button></div></div>";
    }
  }

  var initTable1 = function (myTableDatatablesManaged) {

    var table = $('#sample_1');

        // begin first table
        table.dataTable({

            // Internationalisation. For more info refer to http://datatables.net/manual/i18n
            "language": {
              "aria": {
                "sortAscending": ": 从小到大排序",
                "sortDescending": ": 从大到小排序"
              },
              "emptyTable": "暂无数据",
              "info": "显示 _START_ 到 _END_ 记录 共计_TOTAL_条记录",
              "infoEmpty": "未找到相关数据",
              "infoFiltered": "(从 _MAX_ 条记录中过滤)",
              "lengthMenu": "每页显示 _MENU_ 记录",
              "search": "搜索:",
              "zeroRecords": "未找到匹配数据",
              "paginate": {
                "previous":"上一页",
                "next": "下一页",
                "last": "末页",
                "first": "首页"
              }
            },

            buttons: myTableDatatablesManaged["buttons"],
            autoWidth:      true,
            scrollY:        true,
            deferRender:    true,
            scroller:       myTableDatatablesManaged['scroller'],
            deferRender:    true,
            scrollX:        myTableDatatablesManaged['scrollX'],
            scrollCollapse: true,      
            autoWidth:      true,

            "info": myTableDatatablesManaged['info'],

            "bStateSave": true,

            "searching": myTableDatatablesManaged["searching"],

            "paging": myTableDatatablesManaged["paging"],

            "dom": "<'row' <'col-md-12'B>><'row'<'col-md-6 col-sm-12'l><'col-md-6 col-sm-12'f>r><'table-scrollable't><'row'<'col-md-5 col-sm-12'i><'col-md-7 col-sm-12'p>>", 

            "lengthMenu": [
            [5, 10, 15, 20, -1],
            ["5条", "10条", "15条", "20条", "全部"]
            ],

            "pageLength": 10,

            "pagingType": "bootstrap_full_number",
            
            "order": [
            [0, "asc"]
            ], 

            "bFilter": true,

            "bSort": false,

            initComplete: function () {
             var api = this.api();
             api.columns().indexes().flatten().each(function (i) {
               var column = api.column(i);
               if ($(column.footer()).hasClass("need-select-filter")) {
                 var $span = $('<span class="addselect"></span>').appendTo($(column.footer()))
                 var select = $('<select class="form-control form-filter input-sm"><option value="">全部</option></select>')
                 .appendTo($(column.footer()))
                 .on('click', function (evt) {
                   evt.stopPropagation();
                   var val = $.fn.dataTable.util.escapeRegex(
                     $(this).val()
                     );
                   column
                   .search(val ? '^' + val + '$' : '', true, false)
                   .draw();
                 });
                 column.data().unique().sort().each(function (d, j) {
                   function delHtmlTag(str) {
                               return str.replace(/<[^>]+>/g, "");//去掉html标签
                             }

                             d = delHtmlTag(d)
                             select.append('<option value="' + d + '">' + d + '</option>')
                             $span.append(select)
                           });

               }
             });

           }

         });

        var tableWrapper = jQuery('#sample_1_wrapper');

      }
      
      return {

        //main function to initiate the module
        init: function (myTableDatatablesManaged) {
          if (!jQuery().dataTable) {
            return;
          }

          if(!myTableDatatablesManaged.hasOwnProperty("autoWidth")){
            myTableDatatablesManaged["autoWidth"]=true;
          }

          if(!myTableDatatablesManaged.hasOwnProperty("search")){
            myTableDatatablesManaged["search"]=true;
          }

          if(!myTableDatatablesManaged.hasOwnProperty("paging")){
            myTableDatatablesManaged["paging"]=true;
          }

          if(!myTableDatatablesManaged.hasOwnProperty("scrollX")){
            myTableDatatablesManaged["scrollX"]=false;
          }

          if(!myTableDatatablesManaged.hasOwnProperty("scroller")){
            myTableDatatablesManaged["scroller"]=false;
          }

          if(!myTableDatatablesManaged.hasOwnProperty("info")){
            myTableDatatablesManaged["info"]=true;
          }

          if(myTableDatatablesManaged["buttons"]=="simplify"){
            myTableDatatablesManaged["buttons"]= [{ extend: 'copy', className: 'btn dark btn-outline', text: '复制' },{ extend: 'excel', className: 'btn green btn-outline ', text: '导出EXCEL' }];
          }else{
            myTableDatatablesManaged["buttons"]= [{ extend: 'copy', className: 'btn dark btn-outline' , text: '复制'},{ extend: 'excel', className: 'btn green btn-outline ', text: '导出EXCEL' }];
          }

          initTable1(myTableDatatablesManaged);

          if(myTableDatatablesManaged["paging"]==true){
            $("#sample_1_length").before(getAddButtonCodes(myTableDatatablesManaged['addButtonText'],myTableDatatablesManaged['addButtonURL']));
          }else{
            $("#sample_1_wrapper").before(getAddButtonCodes(myTableDatatablesManaged['addButtonText'],myTableDatatablesManaged['addButtonURL']));
            if(myTableDatatablesManaged['addButtonText']==''&&myTableDatatablesManaged['addButtonURL']==''){
              $(".portlet.light .dataTables_wrapper .dt-buttons").css("margin-top","-64px");              
            }else{
              $(".portlet.light .dataTables_wrapper .dt-buttons").css("margin-top","-94px");                
            }
          }        
        },

        configDatatables: function(type,url=""){
            switch(type)
            {
              case 'commonListView':
                    return {"addButtonText":"","addButtonURL":url,"searching":false,"paging":false,"info":false};
                break;
              case 'scrollListView':
                    return {"addButtonText":"","addButtonURL":url,"buttons":"simplify","searching":false,"paging":false,"scrollX":true,"scroller":true,"info":false};
                break;
              case 'dictionaryListView':
                    return {"addButtonText":"创建记录","addButtonURL":url,"buttons":"default","searching":true,"paging":true,"scrollX":true,"scroller":false,"info":true};
                break;                
              default:
                break;
            }
        }
      };
    }();

$('.need-conform-bootbox-delete').click(function(){

    // bootbox.setDefaults("locale","zh_CN");
    // bootbox.confirm("确定删除?", function(result) {
    // });

     var printItemCheckbox = $(this).parent().prev().find(".print-item-checkbox");

    if(printItemCheckbox.attr("data-receive-enter-receipt")==1||printItemCheckbox.attr("data-reject-exit-receipt")==1){
        bootbox.alert("已打印凭证的单据不能删除");
        return
    }



    var that = $(this);
    var text = that.attr('data-text');
    bootbox.setDefaults("locale", "zh_CN");
    bootbox.confirm(text, function (result) {
        if(result==true){
        var id = that.parent().attr('data-pid');
        console.log(id);

        $.post('/index.php/Home/purchase/detail', {
            id: id,

        }, function (data) {
            if (data.ret == 1) {
                if (data.msg) {
                    alert(data.msg);
                }
            } else {
                alert(data.msg);
                return false;
            }
            if(data.url){
                window.location.href=  data.url;
            }else {
                window.location.reload();
            }
        }, 'json');
      }
    });
});

$('.need-conform-bootbox-disable').click(function(){
    // bootbox.setDefaults("locale","zh_CN");
    // bootbox.confirm("确定停用?", function(result) {
    // });
    var that = $(this);
    var text = that.attr('data-text');
    bootbox.setDefaults("locale", "zh_CN");
    bootbox.confirm(text, function (result) {
        if(result==true){
            var id = that.parent().attr('data-pid');
            var fieldname = that.attr('data-fieldname');
            var afterchange = that.attr("data-value");
            var tablename = that.attr("data-tablename");
            $.post(url, {
                id: id,
                fieldname: fieldname,
                afterchange: afterchange,
                tablename:tablename
            }, function (data) {
                if (data.ret == 1) {
                    if (data.msg) {
                        alert(data.msg);
                    }
                } else {
                    alert(data.msg);
                    return false;
                }
                if(data.url){
                    window.location.href=  data.url;
                }else {
                    window.location.reload();
                }
            }, 'json');
        }
    });
});
