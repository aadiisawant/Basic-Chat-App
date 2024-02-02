$(document).ready(e=>{
	$("#login").click(()=>{
		
		let name = $("#name-value").val()
		localStorage.setItem("name",name)
		$("#name-title").text(`Welcome, ${name}`)
		connect();
		$("#name-value").val('')
	})
	
	$("#send").click(()=>{
		
		sendMessage();
	})
	
	$("#logout").click(()=>{
		localStorage.removeItem("name");
		stompClient.disconnect()
		$("#name-form").removeClass("d-none")
		$("#chat-room").addClass("d-none")
	})
	
	$("#showhistory").click(()=>{
		fetchChatHistory();
	})
})

var stompClient=null;

function connect(){
	let socket = new SockJS("/server1")
	stompClient = Stomp.over(socket)
	stompClient.connect({},function(frame){
		console.log("connected: "+frame)
		$("#name-form").addClass('d-none')
		$("#chat-room").removeClass('d-none')
		
		//subscribe
		stompClient.subscribe("/topic/return-to",function(response){
			showMessage(JSON.parse(response.body))
		})
	})
}
function showMessage(message){
	console.log("ShowMessage")
	/*$("#message-container-table").prepend(`<tr><td><b>${message.name} : </b>${message.content} </td><td><span class="timestamp">${message.timestamp}</span></td></tr>`)*/
	$("#message-container-table").prepend(`
    <tr class="message-row">
        <td class="user-info">
            <b>${message.name}:</b>
        </td>
        <td class="message-content">
            ${message.content}
        </td>
        <td class="timestamp">
            ${message.timestamp}
        </td>
    </tr>
`);

}
function sendMessage(){
	var msg = $("#message-value").val()
	const timestamp1 = new Date().toLocaleTimeString()
	let jsonObj = {
		
		name:localStorage.getItem("name"),
		content:msg,
		timestamp : timestamp1
	}
	stompClient.send("/app/message",{},JSON.stringify(jsonObj))
	$("#message-value").val('')
}

function fetchChatHistory(){
	$.ajax({
        url: "/chathistory/getchat", 
        type: "GET",
        dataType: "json",
        success: function (data) {
            displayChatHistory(data);
        },
        error: function (error) {
            console.error("Error fetching chat history:", error);
        },
    });
}

function displayChatHistory(chatHistory) {
   
    $("#message-container-table").empty();

    chatHistory.forEach((message) => {
        showMessage(message);
    });
}