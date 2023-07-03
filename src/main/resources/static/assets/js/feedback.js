let feedbackWriteBtn = document.querySelector('.feedbacks .btn-write');
let feedbackModifyBtn = document.querySelectorAll('.feedbacks .btn-modify');
let feedbackDeleteBtn = document.querySelectorAll('.feedbacks .btn-delete');

function feedbackWrite() {
    popupOpenFeedBack('피드백 작성하기', 'board');
}

function feedbackModify(id, role, name, content) {
  popupModifyFeedback('피드백 수정하기', 'board', id, role, name, content);
}

function feedbackDelete(id) {
  const memberId = document.getElementById('memberId').value;
  if(confirm('삭제하시겠습니까?')) {
        let data = {
            id : id,
        };
        httpRequest = new XMLHttpRequest();
        httpRequest.open("DELETE","/board/delete", true);
        httpRequest.responseType = "json";
        httpRequest.setRequestHeader("Content-Type","application/json");
        httpRequest.send(JSON.stringify(data));
         setTimeout(function(){
            window.location.href="/member/"+memberId;
         }, 300);
  }
}
