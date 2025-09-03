document.getElementById("insertFormBtn").addEventListener("click", () => {
    locationProcess("/board/insertForm");
});

//document.addEventListener('click', (e) => {
//    const target = e.target.closest('.goDetail');
//    if(!target) return;
//
//    const tr = target.closest('tr');
//    const boardNumber = tr.dataset.num;
//
//    locationProcess(`/board/${boardNumber}`);
//});

//const keyword = document.querySelector("#keyword");
//const search = document.querySelector("#search");

//let value = "";
//let regex;
//
//const highlightKeyword = function(element, keyword, regex) {
//    const html = element.innerHTML;
//    element.innerHTML = html.replace(regex, `<span class='board-required'>${keyword}</span>`);
//};

//const searchKeyword = function() {
//    const word = keyword.value.trim();
//    const searchData = search.value;
//
//    if(word !== "" && searchData !== "b_content") {
//        const value = (searchData === "b_title") ? ".list tr td.goDetail"
//        : (searchData === "b_name") ? ".list tr td.name" : "";
//        const elements = document.querySelectorAll(value);
//        console.log(elements);
//
//        const regex = new RegExp(word, "gi");
//        elements.forEach((el) => {
//            highlightKeyword(el, word, regex);
//        });
//    }
//};

//document.getElementById("keyword").addEventListener("keydown", function (event) {
//    if (event.key === "Enter") {
//        event.preventDefault();
//    }
//});

//document.getElementById("searchBtn").addEventListener("click", function () {
//    if (!chkData("#keyword", "검색어를")) return;
//    formSubmit("searchForm", "get", "/board/boardList");
//});

//document.getElementById("allSearchBtn").addEventListener("click", function () {
//    locationProcess("/board/boardList");
//});

// 초기 실행
//searchKeyword();

document.querySelectorAll(".goDetail").forEach(function (element) {
    element.addEventListener("click", function () {
        const tr = this.closest("tr");
        const no = tr.dataset.no;
        locationProcess(`/board/${no}`);
    });
});