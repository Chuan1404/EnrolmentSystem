/* 
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/JavaScript.js to edit this template
 */

let icon = document.getElementById("chatbox-icon");
let chatbox = document.getElementById("chatbox-popup");
let closeBtn = chatbox.getElementsByClassName("close-icon")[0];

animate();
console.log("here");

var stompClient = Stomp.over(new SockJS('http://localhost:8080/EnrolmentSystem/chat'));
stompClient.connect({}, function (frame) {
    console.log('Connected: ' + frame);
    stompClient.subscribe('/topic/messages', function (message) {
        console.log(message);
    });
});

function animate() {
    icon.addEventListener("click", function () {
        chatbox.classList.toggle("hidden");
    })
    closeBtn.addEventListener("click", function () {
        chatbox.classList.toggle("hidden");
    })
}

function sendMessage() {
    var message = document.getElementById('message').value;
    stompClient.send("/app/chat", {}, JSON.stringify({'message': message}));
}
