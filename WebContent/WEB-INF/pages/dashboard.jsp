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
				Formats a JSON string/file with your desired indentation level creating an object tree with color highlights. You can now clearly identify object constructs (objects, arrays and members). The JSON tree that is created can be navigated by collapsing the individual nodes one at a time if desired.
				</p>
				<p>
					<strong>*Files bigger than 1 meg will not be formatted to a tree structure for performance reason. They will instead be formatted to a plain text format.</strong>
				</p>
				<p>
					If you want to learn more about JSON, jump to the <a href="#json-explained">JSON Explained</a> section of this page.
				</p>
				<div class="form-wrapper">
					<form id="form" enctype="multipart/form-data" method="post" action="#">					
						<div class="title first"><span class="option">Option 1:</span> <span class="option-text">Copy-paste your JSON string here</span></div>
						<textarea rows="" cols="" id="inputString" name="inputString"></textarea>
						<div class="title"><span class="option">Option 2:</span> <span class="option-text">Or type in the URL to your JSON file</span></div>
						<input type="text" id="inputUrl" name="inputUrl" value=""/>
						<div class="title"><span class="option">Indentation level:</span></div>
						<select id="indent" name="indent" tabindex="-1">
							<option  value="2spaces">2 spaces per indent level</option>
							<option selected="selected" value="3spaces">3 spaces per indent level</option>
							<option  value="4spaces">4 spaces per indent level</option>
							<option  value="compact">Compact (1 line)</option>
							<option  value="javascript">JavaScript escaped</option>
							<option  value="tabs">Tab delimited</option>
						</select>
						<div class="title"><span class="option">Force output to new window:</span></div>
						<select id="forceNewWindow" name="forceNewWindow">
							<option selected="selected" value="false">No</option>
							<option  value="true">Yes</option>
						</select>						
						<div class="buttons">
							<button class="btn primary" id="formatButton" title="Format the JSON into a tree" onclick="formatter.submit();return false;">FORMAT JSON</button>
						</div>
					</form>
				</div>
				<div id="ad-output" class="ad-wrapper">
				ad
				</div>	
											
				<h2 id="json-explained" class="section-title">JSON Explained</h2>
				<h3>What is JSON?</h3>
				<p class="space">
					JSON stands for "JavaScript Object Notation" and is pronounced "Jason" (like in the Friday the 13th movies). It's meant to be a human-readable and compact solution to represent a complex data structure and facilitate data-interchange between systems.
				</p>
				<h3>Why use JSON?</h3>
				<p class="space">
					There are tons of reasons why you would want to use JSON:
					<ul>
						<li>It's human readable... if it's properly formatted :-P</li>
						<li>It's compact because it doesn't use a full markup structure, unlike XML</li>
						<li>It's easy to parse, especially in JavaScript</li>
						<li>A gazillion JSON libraries are available for most programming languagues</li>
						<li>The data structure is easy to understand even if you're an idiot</li>
					</ul>
				</p>
				<h3>The JSON format</h3>
				<p class="space">
					There are just a few rules that you need to remember:
					<ul>
						<li>Objects are encapsulated within opening and closing brackets { }</li>
						<li>An empty object can be represented by { }</li>
						<li>Arrays are encapsulated within opening and closing square brackets [ ]</li>
						<li>An empty array can be represented by [ ]</li>
						<li>A member is represented by a key-value pair</li>
						<li>The key of a member should be contained in double quotes. (JavaScript does not require this. JavaScript and some parsers will tolerate single-quotes)</li>
						<li>Each member should have a unique key within an object structure</li>
						<li>The value of a member must be contained in double quotes if it's a string (JavaScript and some parsers will tolerates single-quotes)</li>
						<li>Boolean values are represented using the true or false literals in lower case</li>
						<li>Number values are represented using double-precision floating-point format. Scientific notation is supported</li>
						<li>Numbers should not have leading zeroes</li>
						<li>"Offensive"" characters in a string need to be escaped using the backslash character</li>
						<li>Null values are represented by the null literal in lower case</li>
						<li>Other object types, such as dates, are not properly supported and should be converted to strings. It becomes the responsability of the parser/client to manage this.</li>
						<li>Each member of an object or each array value must be followed by a comma if it's not the last one</li>
						<li>The common extension for json files is '.json'</li>
						<li>The mime type for json files is 'application/json'</li>
					</ul>
					Example:
					<div style="padding-top:15px;">
						<code class="json">
							<span collapseid="1" class="json-open-bracket">{</span><span class="json-collapse-1"><br>
							<span class="json-indent">&nbsp;&nbsp;&nbsp;</span><span class="json-property">"anObject"</span><span class="json-semi-colon">: </span><span collapseid="2" class="json-open-bracket">{</span><span class="json-collapse-2"><br>
							<span class="json-indent">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</span><span class="json-property">"numericProperty"</span><span class="json-semi-colon">: </span><span class="json-value">-122</span><span class="json-comma">,</span><br>
							<span class="json-indent">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</span><span class="json-property">"stringProperty"</span><span class="json-semi-colon">: </span><span class="json-value">"An offensive \" is problematic"</span><span class="json-comma">,</span><br>
							<span class="json-indent">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</span><span class="json-property">"nullProperty"</span><span class="json-semi-colon">: </span><span class="json-value">null</span><span class="json-comma">,</span><br>
							<span class="json-indent">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</span><span class="json-property">"booleanProperty"</span><span class="json-semi-colon">: </span><span class="json-value">true</span><span class="json-comma">,</span><br>
							<span class="json-indent">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</span><span class="json-property">"dateProperty"</span><span class="json-semi-colon">: </span><span class="json-value">"2011-09-23"</span><br>
							<span class="json-indent">&nbsp;&nbsp;&nbsp;</span></span><span collapseid="2" class="json-close-bracket">}</span><span class="json-comma">,</span><br>
							<span class="json-indent">&nbsp;&nbsp;&nbsp;</span><span class="json-property">"arrayOfObjects"</span><span class="json-semi-colon">: </span><span collapseid="3" class="json-open-bracket">[</span><span class="json-collapse-3"><br>
							<span class="json-indent">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</span><span collapseid="4" class="json-open-bracket">{</span><span class="json-collapse-4"><br>
							<span class="json-indent">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</span><span class="json-property">"item"</span><span class="json-semi-colon">: </span><span class="json-value">1</span><br>
							<span class="json-indent">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</span></span><span collapseid="4" class="json-close-bracket">}</span><span class="json-comma">,</span><br>
							<span class="json-indent">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</span><span collapseid="5" class="json-open-bracket">{</span><span class="json-collapse-5"><br>
							<span class="json-indent">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</span><span class="json-property">"item"</span><span class="json-semi-colon">: </span><span class="json-value">2</span><br>
							<span class="json-indent">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</span></span><span collapseid="5" class="json-close-bracket">}</span><span class="json-comma">,</span><br>
							<span class="json-indent">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</span><span collapseid="6" class="json-open-bracket">{</span><span class="json-collapse-6"><br>
							<span class="json-indent">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</span><span class="json-property">"item"</span><span class="json-semi-colon">: </span><span class="json-value">3</span><br>
							<span class="json-indent">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</span></span><span collapseid="6" class="json-close-bracket">}</span><br>
							<span class="json-indent">&nbsp;&nbsp;&nbsp;</span></span><span collapseid="3" class="json-close-bracket">]</span><span class="json-comma">,</span><br>
							<span class="json-indent">&nbsp;&nbsp;&nbsp;</span><span class="json-property">"arrayOfIntegers"</span><span class="json-semi-colon">: </span><span collapseid="7" class="json-open-bracket">[</span><span class="json-collapse-7"><br>
							<span class="json-indent">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</span><span class="json-value">1</span><span class="json-comma">,</span><br>
							<span class="json-indent">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</span><span class="json-value">2</span><span class="json-comma">,</span><br>
							<span class="json-indent">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</span><span class="json-value">3</span><span class="json-comma">,</span><br>
							<span class="json-indent">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</span><span class="json-value">4</span><span class="json-comma">,</span><br>
							<span class="json-indent">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</span><span class="json-value">5</span><br>
							<span class="json-indent">&nbsp;&nbsp;&nbsp;</span></span><span collapseid="7" class="json-close-bracket">]</span><br>
							<span class="json-indent"></span></span><span collapseid="1" class="json-close-bracket">}</span>
						</code>
					</div>
				</p>
				<h3>JSON in JavaScript</h3>
				<p>
					Because JSON derives from JavaScript, you can parse a JSON string simply by invoking the eval() function. The JSON string needs to be wrapped by parenthesis, else it will not work! This is the #1 problem when programmers first start to manipulate JSON strings. That being said, DON'T do this!				
				</p>
				<p>
					<strong>Example using the 'dangerous' eval():</strong>
					<code class="prettyprint">
						&lt;script type="text/language"&gt;<br/>
						<br/>
						&nbsp;&nbsp;&nbsp;// A valid json string<br/>
						&nbsp;&nbsp;&nbsp;var someJsonString = '{"someProperty":"someValue"}';<br/>
						<br/>
						&nbsp;&nbsp;&nbsp;// jsonObject will contain a valid JavaScript object<br/>
						&nbsp;&nbsp;&nbsp;var jsonObject = eval(<strong>'('</strong> + someJsonString + <strong>')'</strong>);<br/>
						<br/>
						&nbsp;&nbsp;&nbsp;// Will display the string 'someValue'<br/>
						&nbsp;&nbsp;&nbsp;alert(jsonObject.someProperty);<br/>
						<br/>
						&lt;/script&gt;<br/>
					</code>
				</p>
				<p>
					As pointed out by M. Clement at <a href="http://inimino.org/~inimino/blog/">Inimino</a>, a better and more secure way of parsing a JSON string
					is to make use of <a href="https://developer.mozilla.org/en/JavaScript/Reference/Global_Objects/JSON/parse">JSON.parse()</a>. The eval() function leaves the door open to all JS expressions potentially creating side effects or security issues, whereas 
					JSON.parse() limits itself to just parsing JSON. JSON.parse() is available natively in <a href="http://caniuse.com/#feat=json">most recent browsers</a>. If you need to support older browser, 
					make use of an external JavaScript library such as <a href="https://github.com/douglascrockford/JSON-js/">Douglas Crockford's json2.js</a>.					
				</p>
				<p>
					<strong>Example using JSON.parse():</strong>
					<code class="prettyprint">
						&lt;script type="text/language"&gt;<br/>
						<br/>
						&nbsp;&nbsp;&nbsp;// A valid json string<br/>
						&nbsp;&nbsp;&nbsp;var someJsonString = '{"someProperty":"someValue"}';<br/>
						<br/>
						&nbsp;&nbsp;&nbsp;// jsonObject will contain a valid JavaScript object<br/>
						&nbsp;&nbsp;&nbsp;var jsonObject = JSON.parse(someJsonString);<br/>
						<br/>
						&nbsp;&nbsp;&nbsp;// Will display the string 'someValue'<br/>
						&nbsp;&nbsp;&nbsp;alert(jsonObject.someProperty);<br/>
						<br/>
						&lt;/script&gt;<br/>
					</code>
				</p>
				<p>
					If you want to create a JSON string representation of your JavaScript object, make use of the <a href="https://developer.mozilla.org/en/JavaScript/Reference/Global_Objects/JSON/stringify">JSON.stringify()</a> function.					 
				</p>
				<p>
					<strong>Example using JSON.stringify():</strong>
					<code class="prettyprint">
						&lt;script type="text/language"&gt;<br/>
						<br/>
						&nbsp;&nbsp;&nbsp;// A valid json string<br/>
						&nbsp;&nbsp;&nbsp;var someObject = {};<br/>
						&nbsp;&nbsp;&nbsp;someObject.someProperty = "someValue";<br/>
						<br/>
						&nbsp;&nbsp;&nbsp;// jsonString now contains a JSON string representation of someObject<br/>
						&nbsp;&nbsp;&nbsp;var jsonString = JSON.stringify(someObject);<br/>
						<br/>
						&nbsp;&nbsp;&nbsp;// Will display the string '{"someProperty":"someValue"}'<br/>
						&nbsp;&nbsp;&nbsp;alert(jsonString);<br/>
						<br/>
						&lt;/script&gt;<br/>
					</code>
				</p>
				<p>
					You can also create JavaScript objects using the JSON syntax directly in your code.
				</p>
				<p class="space">
					<strong>Example of creating a JavaScript object using 'JSON' syntax</strong>:
					<code class="prettyprint">
						&lt;script type="text/language"&gt;<br/>
						<br/>
						&nbsp;&nbsp;&nbsp;// jsonObject is a valid JavaScript object that can be used on the fly<br/>
						&nbsp;&nbsp;&nbsp;var jsonObject = { someProperty : "someValue" };<br/>
						<br/>
						&nbsp;&nbsp;&nbsp;// Will display the string 'someValue'<br/>
						&nbsp;&nbsp;&nbsp;alert(jsonObject.someProperty);<br/>
						<br/>
						&lt;/script&gt;<br/>
					</code>
				</p>
				<h3>Programming languages and JSON</h3>
				<p>
					The website JSON.org maintains an extensive list of JSON libraries and they are categorized in programming languages. Unfortunately, there are so many libraries out there that it's very hard to chose one! Note that VERY few JSON libraries have strict adherence to the JSON specification and this can lead to parsing problems between systems.
				</p>
				<p class="space">
					These are my recommended JSON libraries:
					<ul>
						<li><strong>C++:</strong>&nbsp;<a href="http://jsoncpp.sourceforge.net/">JsonCpp</a></li>
						<li><strong>C# (.Net):</strong>&nbsp;<a href="http://james.newtonking.com/pages/json-net.aspx">Json.NET</a></li>
						<li><strong>JAVA:</strong>&nbsp;<a href="http://code.google.com/p/json-smart/">JSON.smart</a>,<a href="http://json-lib.sourceforge.net/">JSON-lib</a></li>
					</ul>
				</p>
				<h3>Other useful JSON resources</h3>
				<p>
					<ul>
						<li><a href="http://json.org/">JSON.org</a> - Excellent overall explanation and list of many JSON libraries</li>
						<li><a href="http://en.wikipedia.org/wiki/JSON">Wikipedia</a> - Brief explanation of JSON</li>
						<li><a href="http://www.theserverside.net/tt/articles/showarticle.tss?id=Json">TheServerSide.net</a> - A list of JSON resource guide on TheServerSide.com</li>
					</ul>
				</p>
			</div>
			<div style="margin:auto;text-align:center;">
				ad
			</div>
			<footer>
	<p>&copy; FreeFormatter.com 2011-2012</p>
</footer>
		</div><!--end content-->


<jsp:include page="footer.jsp" />