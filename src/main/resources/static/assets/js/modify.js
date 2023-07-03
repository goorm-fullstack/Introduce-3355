// 프로필 사진 불러오기 기능

const profile = document.querySelector("#profile");
const input = document.querySelector("#profile-input");
const preview = document.querySelector(".profile-img");
const value = document.querySelector("#profileSrc");

function readImage(input) {
  if (input.files && input.files[0]) {
    const reader = new FileReader();
    reader.onload = (e) => {
      preview.src = e.target.result;
      profile.value = input.value;
    };
    reader.readAsDataURL(input.files[0]);
  }
}

input.addEventListener("change", (e) => {
  readImage(e.target);
});

// 멤버 정보 수정 시 기존 내용 유지 기능
const checkBoxs = document.querySelectorAll(".check");
const langs = document.querySelectorAll(".langs");
window.onload = function check(){
    for(let i = 0; i < checkBoxs.length; i++){
        let checkBox = checkBoxs.item(i);
        for(let j = 0; j < langs.length; j++){
            let lang = langs.item(j);
            if(checkBox.value === lang.value) checkBox.checked="true";
        }
    }
}

