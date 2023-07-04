/* popup open, close */

// 평가 작성 오픈
function popupOpenFeedBack(title, dataName) {
  const pathString = window.location.pathname;
  const memberIdUrl = pathString.replace('/member/','');
  // popup html 태그 추가
  let popupBox = document.createElement('div');
  const popupStart = '<div class="popup-bg"></div><div class="popup-wrapper popup-' + dataName + '"><h5 class="popup-title">' + title + '</h5><div class="write-wrapper"><form action="/board/add" method="post" id="popup-form">';
  const selectMember = '<input type="hidden" name="memberId" value="' + memberIdUrl + '"><select name="role"><option value="조원">조원</option><option value="조장">조장</option></select><select name="name"><option value="김경규">김경규</option><option value="문소희">문소희</option><option value="배진환">배진환</option><option value="이정원">이정원</option></select>';
  const popupEnd = '<textarea name="content" placeholder="내용을 입력하세요."></textarea><button type="submit" class="btn-submit type-square type-block-one type-submit">등록</button></div><button type="button" onclick="popupClose();" class="btn-close type-transparent type-ico type-circle">닫기</button></form></div>';

  popupBox.setAttribute('id', 'popup');
  if(dataName == 'board'){ // 피드백 작성 시 작성자 선택 추가
    popupBox.innerHTML = popupStart + selectMember + popupEnd;
  } else {
    popupBox.innerHTML = popupStart + popupEnd;
  }
  // 2023.06.29 button class 정리, innerHTML 리팩토링, dataName이 board일 때 멤버 선택 select 추가, moon
  document.body.appendChild(popupBox);

  // popup 배경 클릭시에도 닫기
  const popupBg = document.querySelector('#popup .popup-bg');
  popupBg.addEventListener("click", popupClose);
}

// 방명록 작성 오픈
function popupOpen(title) {
  // popup html 태그 추가
  let popupBox = document.createElement('div');
  popupBox.setAttribute('id', 'popup');
  popupBox.innerHTML = '<div class="popup-bg"></div><div class="popup-wrapper"><h5 class="popup-title">' + title + '</h5><div class="write-wrapper"><form action="/comment/add" method="post"><textarea name="content" placeholder="내용을 입력하세요."></textarea><button type="submit" class="btn-submit type-square type-block-one type-submit">등록</button></div><button type="button" onclick="popupClose();" class="btn-close type-transparent type-ico type-circle">닫기</button></form></div>';
  document.body.appendChild(popupBox);

  // popup 배경 클릭시에도 닫기
  const popupBg = document.querySelector('#popup .popup-bg');
  popupBg.addEventListener("click", popupClose);
}

// 수정폼 열기: 방명록
function popupModifyOpen(title, id, content, date) {
  console.log(id+" "+content+" "+date);
  // popup html 태그 추가
  let popupBox = document.createElement('div');
  popupBox.setAttribute('id', 'popup');
  popupBox.innerHTML = '<div class="popup-bg"></div><div class="popup-wrapper"><h5 class="popup-title">' + title + '</h5><div class="write-wrapper"><form><input type="hidden" id="up_id" name="id" value='+id+'><input type="hidden" id="up_date" name="date" value='+date+'><textarea id="up_content">'+content+'</textarea><button type="submit" onclick="popupModify();" class="btn-submit type-square type-block-one type-submit">등록</button></div><button type="button" onclick="popupClose();" class="btn-close type-transparent type-ico type-circle">닫기</button></form></div>';
  // 2023.06.29 button class 정리, type 추가, input type=hidden form 안으로 이동, moon
  document.body.appendChild(popupBox);

  // popup 배경 클릭시에도 닫기
  const popupBg = document.querySelector('#popup .popup-bg');
  popupBg.addEventListener("click", popupClose);
}

function popupModify() {
    let data = {
            id : document.getElementById('up_id').value,
            content : document.getElementById('up_content').value,
            date : document.getElementById('up_date').value,
    };
    httpRequest = new XMLHttpRequest();
    httpRequest.open("POST","/comment/update", true);
    httpRequest.responseType = "json";
    httpRequest.setRequestHeader("Content-Type","application/json");
    httpRequest.send(JSON.stringify(data));
    // 타이머
    setTimeout(function(){
        window.location.href="/";
    }, 300);

    // popup 배경 클릭시에도 닫기
    popupClose();
}

// 수정폼 열기: 피드백
function popupModifyFeedback(title, dataName, id, role, name, content) {
const pathString = window.location.pathname;
  const memberIdUrl = pathString.replace('/member/','');
  // popup html 태그 추가
  let popupBox = document.createElement('div');
  popupBox.setAttribute('id', 'popup');
  const start ='<div class="popup-bg"></div><div class="popup-wrapper popup-' + dataName + '"><h5 class="popup-title">' + title + '</h5><div class="write-wrapper"><form action="/' + dataName + '/update" method="post" id="popup-form"><input type="hidden" id="up_id" name="id" value=' + id + '><input type="hidden" name="memberId" value="' + memberIdUrl + '" id="up_memberId"><select name="role" id="up_role"><option value="조원">조원</option><option value="조장">조장</option></select><select name="name" id="up_name">';
  let main;
  if(name=='김경규') {
    main = '<option value="김경규" selected>김경규</option><option value="문소희">문소희</option><option value="배진환">배진환</option><option value="이정원">이정원</option></select>';
  } else if(name == '문소희') {
    main = '<option value="김경규">김경규</option><option value="문소희" selected>문소희</option><option value="배진환">배진환</option><option value="이정원">이정원</option></select>';
  } else if(name=='배진환') {
    main = '<option value="김경규">김경규</option><option value="문소희">문소희</option><option value="배진환" selected>배진환</option><option value="이정원">이정원</option></select>';
  } else {
    main = '<option value="김경규">김경규</option><option value="문소희">문소희</option><option value="배진환">배진환</option><option value="이정원" selected>이정원</option></select>';
  }
  const end = '<textarea name="content" id="up_content">'+content+'</textarea><button type="submit" class="btn-submit type-square type-block-one type-submit">등록</button></div><button type="button" onclick="popupClose();" class="btn-close type-transparent type-ico type-circle">닫기</button></form></div>';
   popupBox.innerHTML = start+main+end;
  document.body.appendChild(popupBox);

  // popup 배경 클릭시에도 닫기
  const popupBg = document.querySelector('#popup .popup-bg');
  popupBg.addEventListener("click", popupClose);
}

function popupClose() {
  const popupElement = document.getElementById("popup");
  popupElement.remove();
  // location.href="/"; 삭제, moon: popup 닫을 때마다 페이지 최상단으로 이동하는건 사용자 경험 측면에서 좋지 않아보여요
}
