<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>   
<!DOCTYPE html>
<html>
	<head>
	<meta charset="UTF-8">
	<meta name="viewpoint" content="width=device-width, initial-scale=1.0">
	<link rel ="stylesheet" type="text/css" href="../stylesheet/text_entry_area.css">
	<script type="text/javascript" src="../javascript/main_txt_dt.js"></script>
	<title>Data Entry</title>
	</head>
	<body>
		<h1>Software Engineering Test Data Entry</h1>
		<br>
		<h2>Process Definition </h2>
		<br>
		<div class="content-entry">
			<form class="frmcontent-entry" method="get" action="../CourseEntrySevlet">
				<input type="text" placeholder="Enter the section title." class="text-title-content" id="text-title-content" name="text-title-content" required></input><br>
				<textarea placeholder="Type the text for the title above." class="text-content-detail" id="txt-content-detail"name="txt-content-detail" required></textarea><br>
				<input type="submit" value="Submit"></input>
			</form>
		</div>
		<script>
			const textarea= document.querySelector("textarea");
			textarea.addEventListener("keyup", e =>{				
			textarea.style.height="85px";
			let scHeight =e.target.scrollHeight;
			textarea.style.height = `${scHeight}px`;
		});
		</script>		
	</body>
</html>