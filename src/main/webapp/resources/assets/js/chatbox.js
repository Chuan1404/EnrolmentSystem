/* 
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/JavaScript.js to edit this template
 */

window.onload = () => {
    let chatbox = document.getElementById("chatbox-popup");
    let closeBtn = chatbox.getElementsByClassName("close-icon")[0];
    closeBtn.addEventListener("click", function () {
        chatbox.classList.remove("hidden");
    })

}
function iconClicked() {
    let chatbox = document.getElementById("chatbox-popup");
    chatbox.classList.toggle("hidden");
    var socket = new SockJS('/ws');
    console.log(socket)
}

