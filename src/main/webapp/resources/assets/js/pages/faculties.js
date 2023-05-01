/* 
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/JavaScript.js to edit this template
 */


function deleteFaculty(endpoint) {
    if (confirm('Xác nhận xóa ?'))
        fetch(endpoint, {
            method: "delete"
        }).then(() => {
            window.location.reload();
        });
    
}


