jQuery.fn.extend({

	    acp : function(option){
	        
	        var focus=false;
	        var in_listpanel=false;
	        var _id = $(this).attr('id');
	        var max_page = 1;
	        var page = option.page;
	        
	        var _obj = $(this);
	        
	        var delay_flag;
	        
	        var ico_base64 = 'data:image/png;base64,iVBORw0KGgoAAAANSUhEUgAAAAoAAAAICAYAAADA+m62AAAACXBIWXMAA';
	        ico_base64 += 'A7EAAAOxAGVKw4bAAAAIGNIUk0AAHolAACAgwAA+f8AAIDpAAB1MAAA6mAAADqYAAAXb5JfxUYAAACW';
	        ico_base64 += 'SURBVHjadM4hD0FRHIbx9yh3U0Q04W7inU8gircokqaKJIpNVGSiZLcrgiD6CL4B8cRHOP8zO9u94W3'
	        ico_base64 += 'PfnsFb84TITWsOPACBAz9fUW3IZxXX4CdQnxd1KqmAbmFzOpU005AW4ADMritE/WvjQHFsAPk/rH9FK';
	        ico_base64 += 'l2BPoxbFmYwWZ0KROtZ5DiR4WQgX/uWQZtaogD3G8AK6q+4xe0sxoAAAAASUVORK5CYII=';
       
	        _obj.css('background', '#fff url(' + ico_base64 + ') no-repeat ' + (_obj.outerWidth()-15) + 'px '+ (_obj.height()/2-3) +'px');
	        
	        
	        var item_data = [];
	        
	        if(option.offline){
	        	item_data = option.data;
	        	for(var i=0;i<item_data.length;i++){
	        		item_data[i] = item_data[i];
	        		item_data[i]['index'] = i;
	        	}
	        }
	        
	        function goPage(page){

	            var url = option.url + "?";
	            	url += option.per_page_str + '=' + option.per_page;
	            	url += "&" + option.page_str + '=' + page;
	            	url += "&" + option.param_str + '=' + _obj.val();
	            	
	            $.post(url, option.params,
					
	            	function(data){
			            $("#span_page_"+_id).text(page);
			            $("#span_max_page_"+_id).text(data.maxPage);
			            max_page = data.maxPage;
			            $("#list_data_" + _id).empty();
                        
			            if(option.empty_notice && data.data.length==0){
			            	show_empty_notice();
                            return;
			            }
			            
			            
			            for(var i=0;i<data.data.length;i++){
			            	var _item_html = option.display(data.data[i]);
			            	_item_html = _item_html.replace(new RegExp(_obj.val()), "<span class='keyword'>" + _obj.val() + "</span>");
			            	var _data_html = '<tr><td>' + _item_html + '<td></tr>';
			            	$("#list_data_" + _id).append(_data_html);
			            
			            	
			            }

			            $("#list_data_" + _id +" tr").on("click", function(){
			                if(option.afterClick){
			                	_obj.val(option.afterClick(data.data[$(this).index()]));
			                } else {
			                	_obj.val($(this).text());
			                }
			                
			                _acp_list.hide();
			            });
						
					}, "json");

	        }
	        
	        
	        function previous_page() {
	            var e = window.event||arguments[0];
	            if(page>1){
	                page = page - 1;
	            }
	            
	            goPage(page);
	            
	            e.stopPropagation();
	        }
	        
	        function next_page(){
	            var e = window.event||arguments[0];
	            if(page < max_page){
	                page = page  + 1;
	            }
	            
	            goPage(page);
	            
	            e.stopPropagation();
	        }
	        
	        function first_page() {
	            var e = window.event||arguments[0];
	            page=1;
	            goPage(1);
	            e.stopPropagation();
	        }
	        
	        function last_page(){
	            var e = window.event||arguments[0];
	            page=max_page;
	            goPage(max_page);
	            e.stopPropagation();
	        }
	        
	        function show_offline_item(){
                $("#empty_notice_" + _id).empty();
	        	var filter_field = option.filter_field;
                var empty = true;
        		for(var i=0;i<item_data.length;i++){
        			 for(var j=0;j<filter_field.length;j++){
        				 if(item_data[i][filter_field[j]].match(new RegExp("^" + _obj.val() + ".*"))){
                            empty = false;
	        				var _item_html = option.display(item_data[i]);
	 		            	_item_html = _item_html.replace(new RegExp(_obj.val()), "<span class='keyword'>" + _obj.val() + "</span>");
	 		            	var _data_html = '<tr><td>' + _item_html + '</td><td style="display:none">' + item_data[i]['index'] + '</td></tr>';
	 		            	$("#list_data_" + _id).append(_data_html);
	 		            	
	 		            	 $("#list_data_" + _id +" tr").on("click", function(){
	 			                if(option.afterClick){
	 			                	_obj.val(option.afterClick(item_data[$(this).find('td:eq(1)').text()]));
	 			                } else {
	 			                	_obj.val($(this).text());
	 			                }
	 			                
	 			                _acp_list.hide();
	 			            });

	        			 }
        			 }
	            }
                
                 if(option.empty_notice && empty){
                    show_empty_notice();
                    return;
                 }
	        }
	       
            function show_empty_notice(){
                $("#empty_notice_" + _id).empty();
                $("#empty_notice_" + _id).append(option.empty_notice);
            }
           
	        var _html_panellist = "";
	        _html_panellist += "<div class='acp_list' id='acp_list_" + _id + "' style='display:none;overflow-y:scroll'>";
	        _html_panellist += "<table class='list_data' id='list_data_" + _id + "'  cellspacing='0' cellpadding='0'>"
	        _html_panellist += "</table>"
	        
	        _html_panellist += "<div id='empty_notice_" + _id + "'>"
		    _html_panellist += "</div>"
	        
		    _html_panellist += "<div class='list_bar'>";
	        _html_panellist += "<div class='list_bar_item'><a id='a_first_page_" + _id + "'  href='javascript:void(0)'  title='首页'> 首页 </a></div>";
	        _html_panellist += "<div class='list_bar_item'><a id='a_previous_page_" + _id + "' href='javascript:void(0)' title='上一页'> 上一页 </a></div>";
	        _html_panellist += "<div class='list_bar_item'><a id='a_next_page_" + _id + "' href='javascript:void(0)' title='下一页'> 下一页 </a></div>";
	        _html_panellist += "<div class='list_bar_item'><a id='a_last_page_" + _id + "' href='javascript:void(0)' title='尾页'> 尾页 </a></div>";
	        _html_panellist += "</div>";
	        
	       	_html_panellist += "<div class='list_footer'>";
	        _html_panellist += "<div>第<span id='span_page_" + _id + "' ></span>页，共<span id='span_max_page_" + _id + "'></span>页</div>";
	        _html_panellist += "</div>";
	        _html_panellist += "</div>";
	      
	        
	        var _acp_list = $(_html_panellist);
	        
	        
	        _acp_list.appendTo(document.body);
	        
	        $("#acp_list_" + _id).on("click", function(){
	            var e = window.event||arguments[0];
	            e.stopPropagation();
	        });
	        
	        _acp_list.height(option.height);
	        
	        $("#a_first_page_" + _id).on("click", first_page);
	        $("#a_previous_page_" + _id).on("click", previous_page);
	        $("#a_next_page_" + _id).on("click", next_page);
	        $("#a_last_page_" + _id).on("click", last_page);
	       
	        
	        if(option.autoLoad==true){
	        	if(option.offline){
	        		show_offline_item();
	        	} else {
	        		goPage(1);
	        	}
	        }
	        
	        _obj.on("focus", function(){
	            focus=true;
	            _acp_list.show();
	            _acp_list.width(_obj.outerWidth());
	            //_acp_list.height(100);
	            var _text_offset = _obj.offset();
	            _text_offset.top = _text_offset.top + _obj.outerHeight() - 1;
	            _acp_list.offset(_text_offset);
	        });
	        
	         _obj.on("blur", function(){
	            
	            focus=false;
	            
	            if(in_listpanel==false){
	                _acp_list.hide();
	            }
	            
	        });
	        
	         
	         
	        _obj.on("keyup", function(){
	        	var e = window.event||arguments[0];
	        	var code = e.keyCode;

	        	if(option.offline){
	        		$("#list_data_" + _id).empty();
	        		show_offline_item();
	        	} else {
	        		if(delay_flag) {
		                clearTimeout(delay_flag);
		            }
	        	    page=1;
	        	    delay_flag = setTimeout(function(){goPage(1)},option.delay);
	        	}
	        });

	        _acp_list.on("mousemove",function(){
	            in_listpanel = true;
	        });
	        
	        _acp_list.on("mouseout",function(){
	            in_listpanel = false;
	        });
	        
	        $(document).on("click", function(){
	            if(focus==false){
	                _acp_list.hide();
	            }
	        });
	    }
	 
	});