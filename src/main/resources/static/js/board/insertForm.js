//document.getElementById("boardInsertBtn").addEventListener("click", () => {
//    if(!chkData("#boardName", "작성자명을")) return;
//    else if(!chkData("#boardTitle", "제목을")) return;
//    else if(!chkData("#boardContent", "내용을")) return;
//    else if(!chkData("#boardPasswd", "비밀번호를")) return;
//    else {
//        formSubmit("insertForm", "post", "/board/boardInsert");
//    }
//});
//
//document.getElementById("boardCancelBtn").addEventListener("click", () => {
//    formReset("insertForm");
//});
//
//document.getElementById("boardListBtn").addEventListener("click", () => {
//    locationProcess("/board/boardList");
//});

document.getElementById("file").addEventListener("change", function() {
    chkFile(this);
});

document.getElementById("boardInsertBtn").addEventListener("click", () => {
    const file = document.getElementById("#file");
    if(!chkData("#name", "작성자명을")) return;
    else if(!chkData("#title", "제목을")) return;
    else if(!chkData("#content", "내용을")) return;
//    else if(!chkData("#file", "파일을")) return; 필수요소일때
    else {
        formFileSubmit("insertForm", "post", "/board/boardInsert");
    }
});