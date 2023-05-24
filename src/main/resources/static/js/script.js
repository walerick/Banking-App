// NAV
const navLinks = document.querySelector(".nav-links");
const hamburger = document.querySelector(".hamburger");
const hamburgerClose = document.querySelector(".hamburger-close");
const overlay = document.querySelector(".overlay");

hamburger.addEventListener("click", mobileMenu);

function mobileMenu() {
  // overlay.classList.toggle("active");
  overlay.style.height = "100%";
}

hamburgerClose.addEventListener("click", () => {
  overlay.style.height = "0%";
});

// MODELS

const personal = document.querySelector(".personal");
const personalDropdown = document.querySelector(".personal-dropdown");

const business = document.querySelector(".business");
const businessDropdown = document.querySelector(".business-dropdown");

const developer = document.querySelector(".developer");
const developerDropdown = document.querySelector(".developer-dropdown");

personal.addEventListener("click", () => {
  if (personalDropdown.style.scale === "1") {
    personalDropdown.style.scale = "0";
    businessDropdown.style.scale = "0";
    developerDropdown.style.scale = "0";
  } else {
    personalDropdown.style.scale = "1";
    businessDropdown.style.scale = "0";
    developerDropdown.style.scale = "0";
  }
});

business.addEventListener("click", () => {
  if (businessDropdown.style.scale === "1") {
    businessDropdown.style.scale = "0";
    personalDropdown.style.scale = "0";
    developerDropdown.style.scale = "0";
  } else {
    personalDropdown.style.scale = "0";
    businessDropdown.style.scale = "1";
    developerDropdown.style.scale = "0";
  }
});

developer.addEventListener("click", () => {
  if (developerDropdown.style.scale === "1") {
    developerDropdown.style.scale = "0";
    businessDropdown.style.scale = "0";
    personalDropdown.style.scale = "0";
  } else {
    personalDropdown.style.scale = "0";
    businessDropdown.style.scale = "0";
    developerDropdown.style.scale = "1";
  }
});

const wuraBtn = document.querySelector(".wura-btn");
const wura = document.querySelector(".wura");
const wuraVid = document.querySelector(".wura-vid");
const wuraPlayButton = document.querySelector(".wura-play-button");
const mayokunPlayButton = document.querySelector(".mayokun-play-button");

const mayokunBtn = document.querySelector(".mayokun-btn");
const mayokun = document.querySelector(".mayokun");
const mayokunVid = document.querySelector(".mayokun-vid");

const wandeImg = document.querySelector(".wande-img");
const wandeBtn = document.querySelector(".wande-btn");

const whyCowrywise = document.querySelector(".why-cowrywise");

wuraBtn.addEventListener("click", () => {
  wuraVid.style.scale = "1";
  wandeImg.style.scale = "0";
  mayokun.style.scale = "0";
});

wuraPlayButton.addEventListener("click", () => {
  wuraVid.play();
  wuraPlayButton.style.opacity = 0;
});

mayokunBtn.addEventListener("click", () => {
  mayokun.style.scale = "1";
  wuraVid.style.scale = "0";
  wandeImg.style.scale = "0";
});

mayokunPlayButton.addEventListener("click", () => {
  mayokunVid.play();
  mayokunPlayButton.style.opacity = 0;
});

wandeBtn.addEventListener("click", () => {
  wandeImg.style.scale = "1";
  wuraVid.style.scale = "0";
  mayokun.style.scale = "0";
});

// SLIDE IN TEXT
const animateText = document.querySelector(".animate-text").children;

const animateTextLen = animateText.length;
let index = 0;

const textInTimer = 3000,
  textOutTimer = 2800;

function animatedText() {
  for (let i = 0; i < animateTextLen; i++) {
    animateText[i].classList.remove("text-in", "text-out");
  }
  animateText[index].classList.add("text-in");

  setTimeout(function () {
    animateText[index].classList.add("text-out"), textOutTimer;
  });

  setTimeout(function () {
    if (index == animateTextLen - 1) {
      index = 0;
    } else {
      index++;
    }
    animatedText();
  }, textInTimer);
}

window.onload = animatedText;
