var sessionId;

var webSocket = new WebSocket('ws://localhost:8888/momsbay/websocket');

webSocket.onerror = function(event) {
  onError(event)
};
webSocket.onopen = function(event) {
  onOpen(event)
};
webSocket.onmessage = function(event) {
  onMessage(event)
};
webSocket.onclose = function(event) {
	onClose(event) 
};

function onMessage(event) {
	var data = JSON.parse(event.data);
	switch(data.type)
    {
       case "messageSend":
    	   console.log('messageSend 받음');
    	   setTimeout(function() { // db에서 조회하는 시간을 맞추기 위해 1.5초 딜레이
	    	   getNewMessage(); //새 메세지 올때마다 상단 쪽지 받은 메세지 갱신
	    	   
	           var thisPageUrl=window.location.pathname;
	           if(thisPageUrl=="/momsbay/message/getTotalMessageList.do" || thisPageUrl=="/momsbay/message/getReceiveMessageList.do"){
	        	   location.reload();
	           }
    	   },1500);
           break;
       case "messageRead":
    	   console.log('messageRead 받음');
    	   setTimeout(function() { // db에서 조회하는 시간을 맞추기 위해 1.5초 딜레이
	           var thisPageUrl=window.location.pathname;
	           if(thisPageUrl=="/momsbay/message/getSendMessageList.do"){
	        	   location.reload();
	           }
    	   },1500);
           break;
    }
}
function onOpen(event) {
    console.log('연결성공');
}
function onClose(event) {
	console.log('연결해제');
}
function onError(event) {
  alert(event.data);
}
function messageSend() {
	var data = {
				"type" : "messageSend" 
				};
	var jsonData = JSON.stringify(data);
	webSocket.send(jsonData);
	console.log('messageSend 보냄');
}

function messageRead() {
	var data = {
			"type" : "messageRead" 
			};
	var jsonData = JSON.stringify(data);
	webSocket.send(jsonData);
	console.log('messageRead 보냄');
}

// 상단 메뉴바 쪽지에 받은 메세지 표시하기 위한 ajax
function getNewMessage(){
	$.ajax({
		url:'/momsbay/message/getReceiveMessageListAPI.do',
		type:'post',
		data:{receiveId:sessionId,status:'0'},
		success:function(data){
			var count=data.count;
			$('#message-header').text(count+' 개의 새로운 쪽지가 있습니다.');
			
			if(data.count>0){
				$('#message-badge').text(count);
				$.each(data.list,function(i,value){
					var str='';
					str+="<div class='li-hover'>";
					str+="<a href='" + "/momsbay/message/detail_message.do?messageNo=" +value.messageNo+ "&messageType=receive"+ "'>";
					str+="<span class='pull-right'>"+value.regdate.substring(0,value.regdate.length-3)+"</span><br>";
					str+="<span class='pull-left'>"+value.memberVO.id+"</span>";
					var title=value.title;
					if(title.length>5){
						title=title.substr(0,5)+'...';
					}
					str+="<span class='pull-right'>"+title+"</span>";
					str+="</a>";
					str+="</div>";
					$('#message-body').append(str);
				});
			} else{
				$('#message-badge').text('');
				$('#message-body').text('새로운 쪽지가 없습니다.')
			}
		}
	})
}