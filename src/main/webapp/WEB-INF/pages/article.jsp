<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<div class="col-md-10 col-xs-9" id="content">
    ${article.content}
</div>

<!-- Button trigger modal -->
<button type="button" class="btn btn-primary tiny-trigger" data-toggle="modal" data-target="#textEditorModal">
  
</button>

<!-- Modal -->
<div class="modal fade" id="textEditorModal" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
  <div class="modal-dialog" role="document">
    <div class="modal-content">
      <div class="modal-header">
        <h5 class="modal-title" id="exampleModalLabel">Modal title</h5>
        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
          <span aria-hidden="true">&times;</span>
        </button>
      </div>
        
      <div class="modal-body">
          <textarea id="content"></textarea>
      </div>
      <div class="modal-footer">
        <button type="button" class="btn btn-secondary" data-dismiss="modal">Close</button>
        <button type="button" class="btn btn-primary">Save changes</button>
      </div>
    </div>
  </div>
</div>


<!--tinyMCE Script-->
<script src="https://cdn.tiny.cloud/1/k1axj96tsxicv9u7v1kk5aefos69iixy7mcu2bpmyqcp41ap/tinymce/6/tinymce.min.js"
referrerpolicy="origin"></script>
<script src="https://code.jquery.com/jquery-3.6.4.min.js"
integrity="sha256-oP6HI9z1XaZNBrJURtCoUT5SUnxFr8s3BzRl+cbzUq8=" crossorigin="anonymous"></script>
<script>
            document.addEventListener('focusin', (e) => {
                if (e.target.closest(".tox-tinymce, .tox-tinymce-aux, .moxman-window, .tam-assetmanager-root") !== null) {
                    e.stopImmediatePropagation();
                }
            });
            const modalBody = document.querySelector(".modal-body");
            const tinyt = document.querySelector(".tiny-trigger");
//            const tinyBoard = document.createElement("textarea");
            
//            tinyBoard.setAttribute("name", "content");
//            tinyBoard.id = "content";
            const content = document.querySelector('#content');
            tinyt.addEventListener("click", () => {
                
//                modalBody.append(tinyBoard);

                tinymce.init({
                    
                    selector: "textarea#content",
                    setup: (editor) => {
                        editor.on('init', (e) => {
                            editor.setContent(content.innerHTML);
                        });
                    }
                });
             
            });
            content.innerHTML = tinymce.get('content').getContent();
//            const tinySave = document.querySelector("#tinysave");
//            tinySave.addEventListener("click", () => {
//                content.innerHTML = tinymce.get('content').getContent();
//                $('#staticBackdrop').modal('hide');
//                modalBody.removeChild(tinyBoard);
//                tinymce.get('content').remove();
//                
//            });



</script>



