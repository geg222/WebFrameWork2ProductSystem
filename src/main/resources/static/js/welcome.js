

document.addEventListener("DOMContentLoaded", function () {
  const greeting = document.querySelector("#greeting");
  if (greeting) {
    greeting.addEventListener("mouseover", function () {
      greeting.style.color = "#4caf50";
    });

    greeting.addEventListener("mouseout", function () {
      greeting.style.color = "";
    });
  }
});