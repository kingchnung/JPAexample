document.getElementById("file").addEventListener("change", function(){
    chkFile(this);
});


document.getElementById("boardUpdateBtn").addEvnetListener("click", function(){
    if(!chkData("#title", "제목을")) return;
     else if (!chkData("#content", "내용을")) return;
     else {
        formFileSubmit("updateForm", "post", "/board/boardUpdate");
    }
});

