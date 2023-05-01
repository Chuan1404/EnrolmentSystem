/* 
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/JavaScript.js to edit this template
 */


function deleteArticle(endPoint) {
    if (confirm("Xác nhận xóa?"))
        fetch(endPoint, {
            method: "delete"
        })
                .then(() => {
                    location.reload();
                }
                );
}