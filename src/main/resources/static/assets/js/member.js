const feedback = document.querySelector("#feedback1");
const roleName = document.querySelector(".role-name");
const date = document.querySelector(".date");
const modifyBtn = document.querySelector(".btn-feedback-modify");
const feedbackInput = document.querySelector("#feedbackContent1");
const roleNameInput = document.querySelector("#roleName1");
const dateInput = document.querySelector("#date1");
const form = document.querySelector("#feedbackForm");

function onEdit() {
  if (!feedback.isContentEditable) {
    feedback.contentEditable = "true";
    roleName.contentEditable = "true";
    date.contentEditable = "true";
  } else {
    feedback.contentEditable = "false";
    feedbackInput.setAttribute("value", feedback.innerText);
    roleName.contentEditable = "false";
    roleNameInput.setAttribute("value", roleName.innerText);
    date.contentEditable = "false";
    dateInput.setAttribute("value", date.innerText);
    form.submit();
  }
}

modifyBtn.addEventListener("click", onEdit);
