//Deposit Dropdown

const depositDropdown = document.querySelector(".deposit-dropdown");
const transferDropdown = document.querySelector(".transfer-dropdown");
const withdrawDropdown = document.querySelector(".withdraw-dropdown");
const depositToggle = document.querySelector(".deposit-toggle");
const transferToggle = document.querySelector(".transfer-toggle");
const withdrawToggle = document.querySelector(".withdraw-toggle");

depositToggle.addEventListener("click", () => {
  if (depositDropdown.style.scale == "1") {
    depositDropdown.style.scale = "0";
    transferDropdown.style.scale = "0";
    withdrawDropdown.style.scale = "0";
  } else {
    depositDropdown.style.scale = "1";
    transferDropdown.style.scale = "0";
    withdrawDropdown.style.scale = "0";
  }
});

transferToggle.addEventListener("click", () => {
  if (transferDropdown.style.scale == "1") {
    depositDropdown.style.scale = "0";
    transferDropdown.style.scale = "0";
    withdrawDropdown.style.scale = "0";
  } else {
    depositDropdown.style.scale = "0";
    transferDropdown.style.scale = "1";
    withdrawDropdown.style.scale = "0";
  }
});

withdrawToggle.addEventListener("click", () => {
  if (withdrawDropdown.style.scale == "1") {
    depositDropdown.style.scale = "0";
    transferDropdown.style.scale = "0";
    withdrawDropdown.style.scale = "0";
  } else {
    depositDropdown.style.scale = "0";
    transferDropdown.style.scale = "0";
    withdrawDropdown.style.scale = "1";
  }
});
