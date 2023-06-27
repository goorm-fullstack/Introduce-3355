/* index scroll, go to top button event */

/* go to top scroll action */
// Get the button
let scrollBtn = document.getElementById("btn-to-top");

// When the user scrolls down 40px from the top of the document, show the button
window.onscroll = function() {scrollFunction()};

function scrollFunction() {
  if (document.body.scrollTop > 40 || document.documentElement.scrollTop > 40) {
    scrollBtn.classList.remove("displaynone");
  } else {
    scrollBtn.classList.add("displaynone");
  }
}

// When the user clicks on the button, scroll to the top of the document
function topFunction() {
  setTimeout(function() {
    document.body.scrollTop = 0;
    document.documentElement.scrollTop = 0;
  }, 10);
}