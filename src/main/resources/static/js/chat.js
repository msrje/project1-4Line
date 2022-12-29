/**
 * 
 */
var stompClient = null;
$(function(){
	$("#question").keyup(menuClicked(el));
});
function openChat(el){
	$(el).hide();
	$("#chat-disp").show();
	connect();
}
function showMessage(message) {
    $("#chat-content").append(message);
}

function connect() {
    var socket = new SockJS('/my-websocket');
    stompClient = Stomp.over(socket);
    stompClient.connect({}, function (frame) {
        
        console.log('Connected: ' + frame);
        //브라우저에서 메시지를 수신하려면 STOMP 클라이언트가 먼저 대상을 구독
        //subscribe()방법을 사용하여 대상에 가입
        //2개의 필수 인수를 사용. destination목적지에 해당하는 문자열, callback,
        stompClient.subscribe('/topic/greetings', function (botMessage) {
            showMessage(JSON.parse(botMessage.body).message);
        });
        //서버가 토픽을 발행시키면 자동수신
        stompClient.subscribe('/topic/message', function (botMessage) {
            showMessage(JSON.parse(botMessage.body).message);
        });
        stompClient.send("/app/hello", {}, JSON.stringify({'name': 'guest'}));
        //stompClient.subscribe('/topic/message', onmessage);
    });
}

function inputTagString(text){
	//var text =$(el).text();
	var now = new Date();
	var ampm = (now.getHours()>11)?"오후":"오전";
	var time = ampm + now.getHours()%12+":"+now.getMinutes();
	var message = `
		<div class="msg user flex">
			<div class="message">
				<div class="part">
					<p>${text}</p>
				</div>
				<div class="time">${time}</div>
			</div>
		</div>
	`;
	return message;
}

function menuClicked(el){
	var text= $(el).text().trim();
	var message = inputTagString(text);
	showMessage(message);
	stompClient.send("/app/message", {}, JSON.stringify({'content': text}));
}

function questionKeyUp(event){
	if(event.keyCode!=13)return;
	btnMsgSendClicked();
}

function btnMsgSendClicked(){
	var text= $("#question").val().trim();
	if(text==""|| text.length<2)return;
	
	var message = inputTagString(text);
	showMessage(message);
	$("#question").val("");
	stompClient.send("/app/message", {}, JSON.stringify({'content': text}));
}