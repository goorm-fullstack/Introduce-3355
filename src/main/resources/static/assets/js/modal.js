// 일단은 사용하지 않는 스크립트입니다.
const btn = document.getElementById('add-comment-popup');
const modal = document.getElementById('editModal');
const closeBtn = document.getElementById('closeBtn');
const submitBtn = document.getElementById('submitBtn');

const btn1 = document.getElementById('update-comment-popup');
const modal1 = document.getElementById('updateModal');
const closeBtn1 = document.getElementById('up_closeBtn');
const submitBtn1 = document.getElementById('updateBtn');
const deleteBtn = document.getElementById('deleteBtn');

btn.onclick = function() {
  modal.style.display = 'block';
}
closeBtn.onclick = function() {
  modal.style.display = 'none';
}

submitBtn.onclick = function() {
    modal.style.display = 'none';
    location.href="/";
}
window.onclick = function(event) {
  if (event.target == modal) {
    modal.style.display = "none";
  }
}

function openModal(id, password, content, date) {
    document.getElementById('up_id').value = id;
    document.getElementById('up_date').innerHTML = date;
    document.getElementById('up_password').value = password;
    document.getElementById('up_content').value = content;
    modal1.style.display = 'block';
}

closeBtn1.onclick = function() {
  modal1.style.display = 'none';
}

submitBtn1.onclick = function() {
    let data = {
        id : document.getElementById('up_id').value,
        password : document.getElementById('up_password').value,
        content : document.getElementById('up_content').value,
        date : document.getElementById('up_date').innerHTML,
    };
    httpRequest = new XMLHttpRequest();
    httpRequest.open("PUT","/comment/update", true);
    httpRequest.responseType = "json";
    httpRequest.setRequestHeader("Content-Type","application/json");
    httpRequest.send(JSON.stringify(data));
    modal1.style.display = 'none';
    location.href="/";
}

deleteBtn.onclick = function() {
    let data = {
        id : document.getElementById('up_id').value,
    };
    httpRequest = new XMLHttpRequest();
    httpRequest.open("DELETE","/comment/delete", true);
    httpRequest.responseType = "json";
    httpRequest.setRequestHeader("Content-Type","application/json");
    httpRequest.send(JSON.stringify(data));
    modal1.style.display = 'none';
    location.href="/";
}

window.onclick = function(event) {
  if (event.target == modal1) {
    modal1.style.display = "none";
  }
}