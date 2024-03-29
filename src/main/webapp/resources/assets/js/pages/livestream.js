/* 
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/JavaScript.js to edit this template
 */


window.onload = function () {
    let startDate = document.getElementById("startDate");
    let duration = document.getElementById("duration");
    let startQuestionTime = document.getElementById("startQuestionTime");
    let questionDuration = document.getElementById("questionDuration");
    startDate.onchange = function (e) {
        duration.disabled = false;
        duration.classList.remove("disable")
    }

    duration.onchange = function (e) {
        startQuestionTime.classList.remove("disable");

        let sdate = new Date(startDate.value);
        startQuestionTime.min = sdate.getHours() + ":" + sdate.getMinutes();

        let edate = new Date(sdate.getTime() + Number(e.target.value) * 60000);
        startQuestionTime.max = edate.getHours() + ":" + edate.getMinutes();
    }

    startQuestionTime.onchange = function (e) {
        questionDuration.classList.remove("disable")

        let hour = e.target.value.split(":")[0];
        let minute = e.target.value.split(":")[1];


        let sdate = new Date(startDate.value);
        let edate = new Date(sdate.getTime() + Number(duration.value) * 60000);

        sdate.setHours(Number(hour))
        sdate.setMinutes(Number(minute))
        questionDuration.max = (edate.getTime() - sdate.getTime()) / 60000;

    }
}
function deleteLivestream(endPoint) {
    if (confirm("Xác nhận xóa?"))
        fetch(endPoint, {
            method: "delete"
        })
                .then(() => {
                    location.reload();
                }
                );
}