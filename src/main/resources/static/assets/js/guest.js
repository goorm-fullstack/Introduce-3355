/* index guest book */

/* slider */
let guestPrevBtn = document.getElementById('guest-prev');
let guestNextBtn = document.getElementById('guest-next');

let guestContainer = document.querySelector('#guest-list-wrapper ul');
let guestList = document.querySelectorAll('#guest-list-wrapper ul li');

let currentIdx = 0; // 현재 슬라이드 인덱스
const slideCount = guestList.length; // 슬라이드 개수
const moveWidth = 205; // 슬라이드 이동 간격(li width + margin)

/* 방명록 슬라이드 */
function moveSlide(num) {
  guestContainer.style.left = (-num * moveWidth) + 'px';
  currentIdx = num;
}

/* 이전 방명록 보기 */
function guestPrev() {
  if(currentIdx != 0) moveSlide(currentIdx-1);
  else alert('처음 페이지입니다.');
}

/* 다음 방명록 보기 */
function guestNext() {
  if(currentIdx != (slideCount-3)) moveSlide(currentIdx+1);
  else alert('마지막 페이지입니다.');
}


/* write */
let guestWriteBtn = document.querySelector('#guest-book .btn-write');
let guestModifyBtn = document.querySelectorAll('#guest-list-wrapper .btn-modify');
let guestDeleteBtn = document.querySelectorAll('#guest-list-wrapper .btn-delete');

function guestDelete(id) {
  if(confirm('삭제하시겠습니까?')) {
        let data = {
            id : id,
        };
        httpRequest = new XMLHttpRequest();
        httpRequest.open("DELETE","/comment/delete", true);
        httpRequest.responseType = "json";
        httpRequest.setRequestHeader("Content-Type","application/json");
        httpRequest.send(JSON.stringify(data));
        location.href="/";
  }
}

function guestWrite() {
  popupOpen('방명록 작성하기');
}

function guestModify(id, content, date) {
  popupModifyOpen('방명록 수정하기', id, content, date);
}