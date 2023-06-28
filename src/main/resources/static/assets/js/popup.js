/* popup open, close */

function popupOpen(title) {
  // popup html 태그 추가
  let popupBox = document.createElement('div');
  popupBox.setAttribute('id', 'popup');
  popupBox.innerHTML = '<div class="popup-bg"></div><div class="popup-wrapper"><h5 class="popup-title">' + title + '</h5><div class="write-wrapper"><form action="/comment/add" method="post"><textarea name="content" placeholder="내용을 입력하세요."></textarea><button type="submit" class="btn-submit type-square type-block-one type-submit type-bg-black">등록</button></div><button type="button" onclick="popupClose();" class="btn-close type-transparent type-ico type-circle">닫기</button></form></div>';
  document.body.appendChild(popupBox);

  // popup 배경 클릭시에도 닫기
  const popupBg = document.querySelector('#popup .popup-bg');
  popupBg.addEventListener("click", popupClose);
}

// 수정폼 열기
function popupModifyOpen(title, id, content, date) {
  console.log(id+" "+content+" "+date);
  // popup html 태그 추가
  let popupBox = document.createElement('div');
  popupBox.setAttribute('id', 'popup');
  popupBox.innerHTML = '<div class="popup-bg"><input type="hidden" id="up_id" name="id" value='+id+'><input type="hidden" id="up_date" name="date" value='+date+'></div><div class="popup-wrapper"><h5 class="popup-title">' + title + '</h5><div class="write-wrapper"><form><textarea id="up_content">'+content+'</textarea><button class="btn-submit" onclick="popupModify();" type-square type-block-one type-submit type-bg-black">등록</button></div><button type="button" onclick="popupClose();" class="btn-close type-transparent type-ico type-circle">닫기</button></form></div>';
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
    httpRequest.open("PUT","/comment/update", true);
    httpRequest.responseType = "json";
    httpRequest.setRequestHeader("Content-Type","application/json");
    httpRequest.send(JSON.stringify(data));

    // popup 배경 클릭시에도 닫기
    popupClose();
}

function popupClose() {
  const popupElement = document.getElementById("popup");
  popupElement.remove();
  location.href="/";
}
