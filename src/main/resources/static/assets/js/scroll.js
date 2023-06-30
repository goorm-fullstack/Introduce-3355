/* index scroll, go to top button event */

/* index scroll action */
let indexscroll = document.getElementsByClassName('btn-scroll');

function mainScroll() {
  var aboutPosition = document.getElementById('about-group').offsetTop - 90;
  let scrollInterval = window.setInterval(function() {
    if(window.scrollY < aboutPosition){
      document.body.scrollTop = window.scrollY + 10;
      document.documentElement.scrollTop = window.scrollY + 10;
    } else {
      clearInterval(scrollInterval);
    }
  }, 5);
}

/* go to top scroll action */
// Get the button
let scrollBtn = document.getElementById('btn-to-top');

// When the user scrolls down 40px from the top of the document, show the button
window.onscroll = function() {scrollFunction()};

function scrollFunction() {
  if (document.body.scrollTop > 40 || document.documentElement.scrollTop > 40) {
    scrollBtn.classList.remove('displaynone');
  } else {
    scrollBtn.classList.add('displaynone');
  }
}

// When the user clicks on the button, scroll to the top of the document
function topFunction() {
  let topInterval = window.setInterval(function() {
    if(window.scrollY != 0){
      document.body.scrollTop = window.scrollY - 50;
      document.documentElement.scrollTop = window.scrollY - 50;
    } else {
      clearInterval(topInterval);
    }
  }, 10);
}
