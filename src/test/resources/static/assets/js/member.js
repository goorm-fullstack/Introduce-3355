// 멤버 삭제 시 경고창
function onDelete(id){
    let isDelete = confirm("삭제하시겠습니까?");
    if(isDelete){
        location.href = "/member/delete?id=" + id;
    }
}