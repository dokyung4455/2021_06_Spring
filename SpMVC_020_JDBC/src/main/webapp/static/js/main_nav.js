document.addEventListener("DOMContentLoaded", () => {
  const nav = document.querySelector("nav#main_nav");

  nav.addEventListener("click", (e) => {
    let tagName = e.target.tagName;
    if (tagName === "LI") {
      let menuText = e.target.textContent;

      // `` backTit : 역 작은 따옴표
      let urlPath = `${rootPath}`;
      if (menuText === "HOME") {
        urlPath += `/`;
      } else if (menuText === "도서정보") {
        urlPath += `/books`;
      } else if (menuText === "출판사정보") {
        urlPath += `/comp`;
      } else if (menuText === "저자정보") {
        urlPath += `/author`;
      } else if (menuText === "로그인") {
        urlPath += `/member/login`;
      } else if (menuText === "회원가입") {
        urlPath += `/member/join`;
      } else if (menuText === "로그아웃") {
        urlPath += "/member/logout";
      } else if (e.target.id === "mypage") {
        urlPath += "/member/mypage";
      }
      location.href = urlPath;
    }
  });
});
