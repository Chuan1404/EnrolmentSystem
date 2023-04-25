/* 
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/JavaScript.js to edit this template
 */

function addComments(endpoint) {
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
                                <div class="media-body">
                                    <div class="row">
                                        <div class="col-8 d-flex">
                                            <h5>${c.userId.name}</h5>
                                            <span>- ${moment(c.createdDate).locale("vi").fromNow()}</span>
                                        </div>

                                        <div class="col-4">

                                            <div class="pull-right reply">

                                                <a href="#"><span><i class="fa fa-reply"></i> reply</span></a>

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

    });
}


