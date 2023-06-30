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
