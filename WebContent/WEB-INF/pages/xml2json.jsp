<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<jsp:include page="header.jsp" />
<jsp:include page="left.jsp" /> 

		<div class="content">
			<div class="content-inner">
				<h1>XML转JSON工具</h1>
				<p>
				XML转JSON是开发者经常遇到的问题，XML转JSON工具能够方便快捷的帮你完成这个任务。
				</p>
				<p>
					如果你希望了解更多关于xml和json的知识，请访问 <a href="#json-explained">XML 教程</a>，<a href="#json-explained">JSON 教程</a> .
				</p>
				<div class="form-wrapper">
					<form id="form" >					
						<div class="title first"><span class="option">可选方法一:</span> <span class="option-text">将XML字符串复制-粘贴在下面文本框中</span></div>
						<textarea rows="" cols="" id="inputString" name="inputString"></textarea>
						<div class="title"><span class="option">可选方法二:</span> <span class="option-text">输入XML文件对应的URL</span></div>
						<input type="text" id="inputUrl" name="inputUrl" value=""/>
						<div class="buttons">
							<input type="button" class="btn primary" id="transButton"  value="XML转JSON" />
						</div>
					</form>
					<h2>转换结果JSON：</h2>
					<div class="result"><pre></pre></div>
				</div>
			</div> 
		</div><!--end content--> 
<jsp:include page="footer.jsp" />
<script type="text/javascript" >
$(document).ready(function(){
  $("#transButton").click(function(){
     var inputString = $("#inputString").val();
	 var inputUrlVal = $("#inputUrl").val();
	 console.time("ajax");
		$.ajax({
		  type: "POST",
		  url: "${pageContext.request.contextPath}/xml2json.do",
		  cache: false,
		  data: { sourceType: "xml2json", input: inputString,inputUrl: inputUrlVal},
		  success: function(response) {
			$('.result pre').html(response);
			console.timeEnd("ajax");
		  }
		});
		console.log(response);
  });
});
</script>
