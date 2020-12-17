<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<!-- include libraries(jQuery, bootstrap) -->
<link href="http://netdna.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.css" rel="stylesheet">
<script src="http://cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.js"></script> 
<script src="http://netdna.bootstrapcdn.com/bootstrap/3.3.5/js/bootstrap.js"></script> 
<!-- include summernote css/js-->
<link href="https://cdnjs.cloudflare.com/ajax/libs/summernote/0.8.11/summernote-bs4.css" rel="stylesheet">
<script src="https://cdnjs.cloudflare.com/ajax/libs/summernote/0.8.11/summernote-bs4.js"></script>
<!-- include summernote-ko-KR -->
<script src="/resources/js/summernote-ko-KR.js"></script>
<link href="https://fonts.googleapis.com/css?family=Nanum+Gothic" rel="stylesheet">
<title>글쓰기</title>

<script>
$(document).ready(function() {
     $('#summernote').summernote({
           placeholder: 'content',
           minHeight: 370,
           maxHeight: null,
           focus: true, 
           lang : 'ko-KR'
     });
   });
</script>
<script>
function goWrite(frm) {
   var title = frm.title.value;
   var writer = frm.writer.value;
   var review = frm.review.value;
   
   if (title.trim() == ''){
      alert("제목을 입력해주세요");
      return false;
   }
   if (writer.trim() == ''){
      alert("작성자를 입력해주세요");
      return false;
   }
   if (review.trim() == ''){
      alert("내용을 입력해주세요");
      return false;
   }
   frm.submit();
}
</script>
</head>   

<body>
<h2 style="text-align: center;">글 작성</h2><br><br><br>

<div style="width: 60%; margin: auto;">
   <form method="post" action="/write">
      <input type="text" name="writer" style="width: 20%; width:530px;
    margin-bottom:8px; line-height:18px; padding:2px 5px; -webkit-border-radius: 5px; -moz-border-radius: 5px;
    border-radius: 5px; border:1px solid #CCC;" placeholder="작성자"/><br>
      <input type="text" name="title" style="width: 40%; width:530px;
    margin-bottom:5px; line-height:18px; padding:2px 5px; -webkit-border-radius: 5px;
    -moz-border-radius: 5px; border-radius: 5px; border:1px solid #CCC;" placeholder="제목"/>
      <br><br> 
      <textarea id="summernote" name="review " style="border-radius: 12px;"></textarea>
      <input id="subBtn" type="button" value="글 작성" style= "float: right; " onclick="goWrite(this.form)"/ border-radius>
   </form>
</div>

</body>
</html>