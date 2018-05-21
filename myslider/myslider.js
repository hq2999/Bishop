(function($){

	var myslider = function (el, config) {
		var timerId;
		
		el.on("dragstart",function(){return false});
		
		if(config.size==undefined) config.size=1;
		if(config.showDot==undefined) config.showDot=true;
		
		
		if(config.width==undefined) config.width=300;
		if(config.height==undefined) config.height=200;

		el.css({
			overflow: 'hidden',
			width: config.width*config.size + "px",
			height: config.height + "px"
		});

		var belt_temp = el.find('div').eq(0);
		var belt = belt_temp.clone();
		belt_temp.hide();
		
		el.append(belt);
		
		belt.css({
			position: 'relative',
			width: '10000px'
		});
	
		var item = belt.children();
		
		var itemLL;
		
		function Node(element){
			this.element = element;
			this.next = null;
			this.prev = null;
			this.ix = 0;
		}
		
		for(var i=0;i<item.length;i++){
			var p1,p2;
			$(item[i]).attr("ix", i+1);
			if(i==0) {
				p1 = new Node(item[i]);
				p1.ix=i+1
				p2 = p1;
				itemLL = p1;
			} else {
				p1 = new Node(item[i]);
				p2.next = p1;
				p1.prev = p2;
				p2=p1;
			}
		}
		
		p2.next = itemLL;
		itemLL.prev = p2;

		item.css({
			float:'left',
			width:config.width + "px"
		});
		
		for(var i=0;i<item.length;i++){
			belt.prepend($(itemLL.prev.element).clone());
			itemLL = itemLL.prev;
		}

		for(var i=0;i<item.length;i++){
			belt.append($(itemLL.element).clone());
			itemLL = itemLL.next;
		}

		belt.css({
			left: -item.length*config.width + "px"
		});
		
		if(config.showDot && config.size==1){
			for(var i=0;i<item.length;i++){
				el.append("<div class='dot noselect' style='top:" + (el[0].offsetTop+config.height-60) + "px;left:" + (el[0].offsetLeft - 200 + config.width*config.size + 15*i) + "px;z-index:2' ></div>");
				
			}
			el.find(".dot").on("dragstart",function(){return false});
			
			el.find(".dot").each(function(i){
				$(this).on("mousedown", function(e){
					moveTo(i+1);
					e=e||window.event;
					e.stopPropagation();
                                        clearInterval(timerId);
				})
			})
			
			el.find(".dot").on("mouseup", function(e){
				e=e||window.event;
				e.stopPropagation();
				timerId = setTimer();
			})
			
			el.find(".dot:eq(0)").css({'background-color':'rgba(0,0,0,.7)'});
		}

		el.find(".side-btn").on("dragstart",function(){return false});
		
		var x = 0;
		var offset = 0;
		var index = 0;
		var mx1 = 0;
		var mx2 = 0;
		var pos1;
		var pos2;
		var cur_index = 0;
		
		el.on('mousedown', function (e) {
			e = e || window.event;

			mx1 = e.screenX;
			pos1 = belt.position();
	
			clearInterval(timerId);

			$(document).on('mousemove', function (e) {
				e = e || window.event;
				pos2 = belt.position();
				mx2 = e.screenX;
				offset = mx2 - mx1;
				
				if(Math.abs(offset)<=10) offset = 0
				
				if(offset>0){
					index = Math.ceil(offset/config.width);
				} else if(offset<0) {
					index = Math.ceil(offset/config.width)-1;
				}
				
				belt.css({
					left: (mx2 - mx1 - item.length*config.width) + "px"
				});
			});
                        
                        
                        
                        $(document).on('mouseup', function (e){

                            $(document).off('mousemove');
                            $(document).off('mouseup');
                            if(index>0){
                                    for(var i=0;i<index;i++){
                                            belt.prepend($(itemLL.prev.element).clone());
                                            itemLL = itemLL.prev;
                                            belt.children(':last').remove();
                                    }

                                    belt.css({
                                            left: -item.length*config.width - (config.width - (offset%config.width)) + "px"
                                    });



                            } else if(index<0){
                                    for(var i=0;i>index;i--){
                                            belt.append($(itemLL.element).clone());
                                            itemLL = itemLL.next;
                                            belt.children(':first').remove();
                                    }

                                    belt.css({
                                            left: -(item.length-1)*config.width + offset%config.width + "px"
                                    });
                            }

                            cur_index = belt.children(":eq(" + item.length + ")").attr('ix');


                            belt.stop().animate({
                                    left: -item.length*config.width + "px"
                            });	
                            switchDot();

                            timerId = setTimer();

                            index = 0;
                    });    
		});
                
		if(config.showSideBtn){
			el.append("<div class='side-btn noselect'>&lt</div>");
			el.append("<div class='side-btn noselect'>&gt</div>");
			
			var lbtn = el.find(".side-btn").eq(0);
			var rbtn = el.find(".side-btn").eq(1);
			
			lbtn.css({
				top:  (el[0].offsetTop + config.height / 2 - lbtn.height()/2) + "px",
				left: el[0].offsetLeft + "px"
			});
			
			rbtn.css({
				top: (el[0].offsetTop + config.height / 2 - lbtn.height()/2) + "px",
				left: (el[0].offsetLeft + config.width*config.size-rbtn.width()) + "px"
			});
			
			lbtn.on('mousedown', function(e){
				prev(e);
				clearInterval(timerId);
			});
			
			
			lbtn.on('mouseup', function(e){
				stopEvent(e);
				timerId = setTimer();
			});
			
			rbtn.on('mousedown', function(e){
				next(e);
				clearInterval(timerId);
			});
			
			rbtn.on('mouseup', function(e){
				stopEvent(e);
				timerId = setTimer();
			});
		}
		
		function stopEvent(e) {
			e=e||window.event;
			e.stopPropagation();
		}
		
		function prev(e) {
			e=e||window.event;
			
			if(e!=undefined) e.stopPropagation();
			
			belt.css({
                            left: - (item.length-1)*config.width + "px"
			});

			belt.append($(itemLL.element).clone());
			itemLL=itemLL.next;
			belt.find("div:eq(0)").remove();
			
			cur_index = belt.find(">div:eq(" + item.length +")").attr('ix');
			
			belt.stop().animate({
				left: -item.length*config.width + "px"
			});
			switchDot();
		}
		
		function next(e) {
			e=e||window.event;
			e.stopPropagation();
			if(e!=undefined) e.stopPropagation();
			
			belt.css({
				left:  - (item.length+1)*config.width + "px"
			});
			
			belt.prepend($(itemLL.prev.element).clone());
			itemLL = itemLL.prev;
			belt.find("div:last").remove();
			
			belt.stop().animate({
				left:  - item.length*config.width + "px",
			});	
			
			
			cur_index = belt.find(">div:eq(" + item.length + ")").attr('ix');
			switchDot();
			
		}

		function moveTo(n){
			var i = 0 ;
			while(cur_index!=n && i<item.length){
				prev();
				i=i+1;
			}
		}
		
		function setTimer(){
			if(config.time*1>0){
				return setInterval(prev, config.time*1000);
			}
		}
		
		
		function switchDot(){
			el.find(".dot").each(function(i){
				if(cur_index==i+1){
					$(this).css({'background-color':'rgba(0,0,0,.7)'});
				} else {
					$(this).css({'background-color':'rgba(0,0,0,.2)'});
				}
			});
		}
		
		timerId = setTimer();
	}

	$.fn.extend({
		myslider: function (config) {
			new myslider($(this), config)
		}
	})

})(jQuery)


/*

    $('#textboard').myslider({
        width: 750,
        height:400,
        time:10,
        size:1,
        showDot:true,
    });

*/