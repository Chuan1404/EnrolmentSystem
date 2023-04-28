/* 
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/JavaScript.js to edit this template
 */

function addComment(endpoint) {
    fetch(endpoint, {
        method: "POST",
        body: JSON.stringify({
            "content": document.getElementById("comment-content").value
        }),
        headers: {
            "Content-Type": "application/json"
        }
    }).then(res => res.json()).then(d => {
        let c = document.getElementById('comment');
        c.innerHTML += `<div class="media mt-5">
                                <img class="mr-3 rounded-circle" alt="User Avatar" src="${d.userId.avatar}" />
                                <div class="media-body">
                                    <div class="row">
                                        <div class="col-8 d-flex">
                                            <h5>${d.userId.name}</h5>
                                            <span>- ${moment(d.createdDate).locale("vi").fromNow()}</span>
                                        </div>

                                        <div class="col-4">

                                            <div class="pull-right reply">

                                                <button><span><i class="fa fa-reply"></i> reply</span></button>

                                            </div>

                                        </div>
                                    </div>		
                                    ${d.content}
                                </div>
                            </div>`;
    });
}

function loadComments(endpoint) {
    fetch(endpoint).then(res => res.json()).then(data => {
        let cont = "";
        for (let c of data) {
            let repl = "";
            let replies = c.commentsCollection;
            if (replies.length !== 0)
            {
                for (let r of c.commentsCollection) {
                    repl += `           <div class="media mt-3">
                                        <a class="pr-3" href="#"><img class="rounded-circle" alt="Bootstrap Media Another Preview" src="${r.userId.avatar}" /></a>
                                        <div class="media-body">
                                            <div class="row">
                                                <div class="col-12 d-flex">
                                                    <h5>${r.userId.name}</h5>
                                                    <span>- ${moment(r.createdDate).locale("vi").fromNow()}</span>
                                                </div>
                                            </div>
                                            ${r.content}
                                        </div>
                                    </div>`;
                }
            }

            cont += `<div class="media mt-5">
                                <img class="mr-3 rounded-circle" alt="User Avatar" src="${c.userId.avatar}" />
                                <div class="media-body" cmt="${c.id}">
                                
                                    <div class="row">
                                        <div class="col-8 d-flex">
                                            
                                            <h5>${c.userId.name}</h5>
                                            <span>- ${moment(c.createdDate).locale("vi").fromNow()}</span>
                                        </div>

                                        <div class="col-4">

                                            <div class="pull-right reply">
                                                
                                                <button class="btn btn-primary btn-repl"><span><i class="fa fa-reply"></i> reply</span></button>
                                                
                                            </div>

                                        </div>
                                    </div>		
                                    ${c.content}
                                    ${repl}
                                </div>
                            </div>`;
        }
        let comment = document.getElementById('comment');
        comment.innerHTML = cont;
        let replies = document.getElementsByClassName('btn-repl');
        let authorized = true;
        fetch('http://localhost:8080/EnrolmentSystem/api/curr-user').
                then(res => { return res.json();}).then(data => {
                    if (!data){
                        for (let el of replies) {
                            el.style.display = "none";
                            authorized = false;
                        }
                    }
        });
        
        if (authorized === false) return;
        for (let rep of replies) {
            let body = rep.closest('.media-body');
            
            rep.addEventListener("click", function () {
                let curr = document.getElementById('reply-box');
                if (curr !== null) {
                    curr.parentElement.removeChild(curr);
                }
                body.innerHTML += `<div class="container text-dark mt-5" id="reply-box">
        <div class="row">
            <div class="col-12">
                <div class="card">
                    <div class="d-flex flex-start w-100">
                        <div class="w-100">
                            <div class="form-outline">
                                <label class="form-label" for="reply-content">Reply to this comment</label>

                                <textarea class="form-control" id="reply-content" rows="2" name="reply-content"></textarea>
                            </div>
                            <div class="d-flex justify-content-between mt-3">
                                
                                <button type="button" class="btn btn-danger" onclick="addReply('${endpoint}/${body.getAttribute("cmt")}/reply')">
                                    Send <i class="fas fa-long-arrow-alt-right ms-1"></i>
                                </button>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
    `;
            }, {once: false});
            
        }
    });
}

function addReply(endpoint) {
    fetch(endpoint, {
        method: "POST",
        body: JSON.stringify({
            "content": document.getElementById('reply-content').value
        }),
        headers: {
            "Content-Type": "application/json"
        }
    }).then(res => res.json()).then(() => {
        window.location.reload();
    });
}
    





