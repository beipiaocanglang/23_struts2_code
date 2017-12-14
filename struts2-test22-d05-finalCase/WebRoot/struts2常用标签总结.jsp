<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s" %>
<html>
	<head>
		<title>struts2标签学习</title>
  </head>
  <body>
  	<!-- 
		s:property标签把value的值，所对应的内容输出到浏览器上
		注意：
			value的值是OGNL表达式而不是字符串，会去contextMap中查找数据
			如果想要输出的结果是字符串，请加引号(如果加上引号，可以操作字符串所拥有的方法)
	 -->
	<s:property value=""/>
	
	<!--  
		s:a标签:
			作用：和超链接标签是一样的。并且可以和s:url互换
			namespace属性可以不写，或者写成空
		使用s:url或s:a标签比号标签的好处：
			例如：当动作类的后缀发生改变时s:url或s:a标签都可以正常使用，而a标签就不能使用了
	-->
	<s:a action="action1" namespace=""></s:a>

	<!--  
		s:url标签:
			作用：是把指定路径存入contextMap中
			属性：
				action：直接写动作名称。不用再写${pageContext.request.contextPath}
				namespace：指定动作所在的名称空间，如果该动作是在默认名称空间下可以不写(根据struts.xml中package标签中是否有namespace属性决定)
				var：取值是一个普通字符串。把var的取值当做key，把action的取值当做value，存入contextMap中，在别的标签上可以直接使用${属性名}来获取存入map中的var值
	-->
	<s:url action="action1" var="action1_url"></s:url>
	
	<!--  
		默认生成3行、每行30个字符的文本输入域，超过制定的数字个数后 会出现滚动条
	-->
	<s:textarea  name="remark" cols="30" rows="3" id="userAction_save_do_remark" cssStyle="WIDTH: 96%" label="自我介绍" value="%{remark}"/>

	<!-- 
		s:form标签是struts2框架的表单标签。它里面常用有4个属性
			action：请求的地址。不用再写前面的EL那段
			namespace：动作所在的名称空间
			method：请求的方式.strut2框架表单默认的请求方式就是post。框架只解决了post方式的中文乱码问题。
			enctype：编码表单的类型。文件上传时所需的
	-->
	<s:form action="userRegister" namespace="/P1" method="POST" enctype="multipart/form-data"></s:form>
	
	 <!--  
		s:date标签：
			作用：格式化输出日期
			属性：
				name：取值是一个OGNL表达式。指定的是要转换的日期对象
				format：指定转换的格式
				var：取值是一个普通的字符串。把var的值当做key，把转换好的日期当成value，存入contextMap中
	 -->
	<s:date name="birthday" format="yyyy-MM-dd" var="sbirthday"/>
	
	<!--  
		s:iterator标签
			作用:用于迭代集合,在页面中显示
			属性:
				value：取值是一个OGNL表达式
				var：取值就是一个普通的字符串
					使用了该属性：会把var的值当做key，把当前遍历的元素当做value，存入ContextMap中（存到大Map）
					没有使用该属性：会把当前遍历的元素，压入栈顶
				begin：遍历开始的索引
				end：遍历的结束索引
				step：步长。for(int i=0;i<size;i=i+step)
				status：遍历的计数器对象。该属性只会存在于contextMap中  <s:property value="#vs"/>  ${vs}
					getIndex：当前遍历元素的索引位置。从0开始
					getCount：当前遍历元素的序号。从1开始
					isOdd：是否是奇数
					isEven：是否是偶数
					isFirst：是否是第一个元素
					isLast：是否是最后一个元素
	-->
	<!--会把var的值当做key，把当前遍历的元素当做value，存入ContextMap中（存到大Map），所以获取值时key.value-->
	<s:iterator value="students" var="s">
		<tr>
			<td><s:property value="#s.name"/></td>
			<td><s:property value="#s.age"/></td>
		</tr>
	</s:iterator>
	<!--没有使用var属性：会把当前遍历的元素，压入栈顶,取值时直接写属性名称即可-->
	<s:iterator value="students">
		<tr>
			<td><s:property value="name"/></td>
			<td><s:property value="age"/></td>
		</tr>
	</s:iterator>
	<!-- 隔行变色 -->
	<s:iterator value="students" status="vs">
		<tr bgcolor="${vs.odd?'red':'blue'}"><!--是奇数：设置成红色、不是奇数：设置成蓝色-->
			<td>${name}</td><!--这种方式也可以取出数据，struts2对EL的改变对域的查找顺序page-request-valueStack-->
			<td>${age}</td>
		</tr>
	</s:iterator>
	
	<!--  
		下来框选项
	-->
	<s:select list="{'研究生','本科','专科','高中','初中','小学'}" value="%{education}" name="education" headerKey="" headerValue="--选择学历--"/>
	<s:select list="#{'BJ':'北京','SH':'上海','SZ':'苏州'}" headerKey="" headerValue="---请选择---"  name="city" label="城市"/>
	
	<!-- 复选框 -->
	<s:checkbox name="married" label="已婚" value="true"/>
	
	<!--  
		作用:生成多个复选框。依据list属性中的元素个数。
		属性：
			list：取值是一个OGNL表达式。
	-->
	<s:checkboxlist list="{'看电影','旅游','健身','购物','睡觉'}" value="hobby.split(', ')" label="爱好" name="hobby"/>
	
	<!-- 
		在页面上如果动作类执行错误时可以使用此标签进行回显错误 
	-->
	<s:actionerror value=""/>
	
	<!-- 
		在页面上如果字段错误时可以使用此标签进行回显错误 
	-->
	<s:fielderror value=""/>
	
	<!--  
		密码输入框标签
		showPassword：设置密码回显
		label：显示在页面上的内容
	-->
	<s:password name="logonPwd" label="密码" value="%{logonPwd}" showPassword="true"/>
	
	<!-- 
		1、操作集合对象
		s:radio标签的list属性取值是一个OGNL表达式。
		{'男','女'}就相当于创建了一个List集合，里面包含了两个元素 
		例如：
			<input type="radio" name="gender" id="gender男" value="男"><label for="gender男">男</label>
			<input type="radio" name="gender" id="gender女" value="女"><label for="gender女">女</label>
	 -->
	 <!--  
		#{'male':'男','female':'女'}就相当于创建了一个map。冒号左侧的作为key，冒号右侧的作为value。
		在生成浏览器识别的html标签时：
			会把map的key给html标签的value赋值
			把map的value作为文本显示在页面上
		例如：
			<input type="radio" name="gender" id="gendermale" value="male"><label for="gendermale">男</label>
			<input type="radio" name="gender" id="genderfemale" value="female"><label for="genderfemale">女</label>
	-->
	<s:radio list="#{'male':'男','female':'女'}" name="gender" label="性别"></s:radio>
	<s:radio list="{'男','女'}" name="gender" value="%{gender}"/>
	
	<!--  
		提交按钮标签
		属性：
			value：显示到页面的内容
			theme：可以设置struts2的默认主题
	-->
	<s:submit value="注册" theme="simple"/>
	
	<!--  
		调试标签
			可以查看contextMap中的数据
	-->
	<s:debug />
	
	<%--
		作用：
			进行条件判断。
		属性：
			test里面的内容是一个逻辑运算，返回的结果应该是一个布尔类型值。
			可以使用常量运算，还可以是OGNL表达式的逻辑 运算
			
			test的取值可以是OGNL表达式，但是只能在ValueStack中取值
			
	--%>
	<s:if test="name == null">
		用户名没有了
	</s:if>
	<s:else ></s:else>
	<s:elseif test="#name == 'test'">
		是一个测试用户
	</s:elseif>	

	
	<!--  
		多用于文件上传时使用
		属性：
			name：实体中属性
			label：显示在页面上的按钮名字
	-->
	<s:file name="photo" label="照片"></s:file>
	<s:file name="upload" size="30" id="userAction_save_do_upload"></s:file><!-- 文件上传 -->


	 <!-- 
	 	s:param标签:
		作用:是给s:url或者s:a添加请求参数
		属性：
			name:参数的名称
			value：参数的值.它的取值是一个OGNL表达式.
			可以在result标签、a标签、url标签、action标签等中使用 
		例如：
			<s:a action="findUserById">
				传入当前要查看的用户id
				<s:param name="userID" value="userID"/>
				<img src="${pageContext.request.contextPath}/images/button_view.gif" border="0" style="CURSOR: hand">
			</s:a>
	-->
	<s:param name="" value="" ></s:param>
	
	<!--  
		添加了<s:token/>标签后会生成一个隐藏域，域中包含一个令牌(随机数)
		例如：
			<input type="hidden" name="struts.token.name" value="token">
			<input type="hidden" name="token" value="5PNA6QV286WMU9ZTJT1F5Q542S01NEWG">
		在struts2的防止表单重复提交时使用过
	-->
	<s:token/>
  </body>
</html>
