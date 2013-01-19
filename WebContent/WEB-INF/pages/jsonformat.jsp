<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<jsp:include page="header.jsp" />
<jsp:include page="left.jsp" /> 

		<div class="content">
			<div class="content-inner">
				<h1>JSON 格式化工具</h1>
				<p>
				格式化JSON字符串是开发者经常遇到的问题，JSON 在线格式化工具能够方便快捷的帮你完成这个任务。
				</p>
				<p>
					如果你希望了解更多关于json的知识，请访问 <a href="#json-explained">JSON 教程</a> .
				</p>
				<div class="form-wrapper">
					<form id="form" >					
						<div class="title first"><span class="option">可选方法一:</span> <span class="option-text">将JSON字符串复制-粘贴在下面文本框中</span></div>
						<textarea rows="" cols="" id="inputString" name="inputString"></textarea>
						<div class="title"><span class="option">可选方法二:</span> <span class="option-text">输入JSON文件对应的URL</span></div>
						<input type="text" id="inputUrl" name="inputUrl" value=""/>
						<div class="buttons">
							<input type="button" class="btn primary" id="formatButton"  value="格式化JSON" />
						</div>
					</form>
					<h2>格式化结果：</h2>
					<div class="result"><pre></pre></div>
				</div>
			</div> 
		</div><!--end content--> 
<jsp:include page="footer.jsp" />
<script type="text/javascript" >
$(document).ready(function(){
  $("#formatButton").click(function(){
     var inputString = $("#inputString").val();
	 var inputUrlVal = $("#inputUrl").val();
		$.ajax({
		  type: "POST",
		  url: "${pageContext.request.contextPath}/jsonformat.do",
		  cache: false,
		  data: { sourceType: "json", input: inputString,inputUrl: inputUrlVal},
		  success: function(response) {
			$('.result pre').html(response);
		  }
		});
  });
});
</script>