<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>spa.jsp</title>
</head>
<body>

	<h3>회원등록</h3>
	<form name="addForm" action="memberInsertUseAjax.do" method="post">
		아이디 : <input type="text" name="id"><br>
		이름 : <input type="text" name="name"><br>
		이메일 : <input type="email" name="mail"><br>
		비밀번호 : <input type="password" name="pwd"><br>
		<input type="submit" value="저장">
	</form>
	
	<table border="1">
		<thead>
			<tr><th>아이디</th><th>이름</th><th>이메일</th><th>비밀번호</th></tr>
		</thead>
		<tbody id="list">
		</tbody>
		
	</table>
	<script>
		
		// form 전송이벤트 실행.	
		document.forms.addForm.onsubmit = function(e) {
			// 기본기능 차단.
			e.preventDefault();
			
			// url = memberInsertUseAjax.do
			let url = document.forms.addForm.getAttribute('action');
			
			let id = document.forms.addForm.id.value;
			let name = document.forms.addForm.name.value;
			let pwd = document.forms.addForm.pwd.value;
			let mail = document.forms.addForm.mail.value;
			let param = 'id='+id+'&name='+name+'&pwd='+pwd+'&mail='+mail;
			
			
			let addAjx = new XMLHttpRequest();
			
			addAjx.open('post', url);
			addAjx.setRequestHeader('Content-type', 'application/x-www-form-urlencoded');
			addAjx.send(param);
			addAjx.onload = function() {
				console.log(addAjx.responseText);
				let data = JSON.parse(addAjx.responseText); // json -> object
				// tbody 태그의 id(list)
				document.getElementById('list').append(makeTr(data))
			}
			
		}
	
	
		<!-- Ajax (비동기방식처리) -->
		let i = 0;
		let xhtp = new XMLHttpRequest(); // 비동기 방식처리
		xhtp.open('get', 'memberJson.do');
		xhtp.send();
		xhtp.onreadystatechange = callBackThree;
		
		let fields = ['id', 'name', 'mail', 'pwd'];
		function callBackThree() {
			if (this.readyState == 4 && this.status == 200) {
				let data = JSON.parse(this.responseText) // json -> javascript 의 object 로 파싱
				console.log(data)
				
				let tbody = document.getElementById('list');
				
				for (let obj of data) {
					makeTr(obj);
					
					tbody.append(tr);
				}
			}
		}
		
		function makeTr(obj) {
			// tr, td, td, td, td
			let tr = document.createElement('tr');
			
			for (let f of fields) {
				let td = document.createElement('td');
				td.innerText = obj[f];
				tr.append(td);
			}
		}
		
		
		
		function callBackTwo() {
			if (this.readyState == 4 && this.status == 200) {
				let data = JSON.parse(this.responseText) // json -> javascript 의 object 로 파싱
				console.log(data)
				
				let ul = document.createElement('ul');
				for (let obj of data) {
					let li = document.createElement('li');
					li.innerHTML = obj.name + ', ' + obj.age;
					ul.append(li);
				}
				console.log(ul);
				document.querySelector('body').append(ul);
			}
		}
		
		function callBackOne() {
			if (this.readyState == 4 && this.status == 200) {
				let data = JSON.parse(this.responseText) // json -> javascript 의 object 로 파싱
				console.log(data)
				
				let name = document.createElement('p');
				name.innerText = data.name;
				let age = document.createElement('p');
				age.innerText = data.age;
				
				document.querySelector('body').append(name, age);
			}
		}
		
		
		
		
		

	</script>

</body>
</html>