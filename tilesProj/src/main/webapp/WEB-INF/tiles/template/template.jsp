<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles" %>    
<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="utf-8" />
        <meta http-equiv="X-UA-Compatible" content="IE=edge" />
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no" />
        <meta name="description" content="" />
        <meta name="author" content="" />
        <title>Dashboard - SB Admin</title>
        <link href="https://cdn.jsdelivr.net/npm/simple-datatables@latest/dist/style.css" rel="stylesheet" />
        <link href="sb_admin/css/styles.css" rel="stylesheet" />
        <script src="https://use.fontawesome.com/releases/v6.1.0/js/all.js" crossorigin="anonymous"></script>
    </head>
    <body class="sb-nav-fixed">
    
    
    	<!-- 헤더 시작 -->
		<tiles:insertAttribute name="head"></tiles:insertAttribute>
        <!-- 헤더 끝 -->
        
        
        <div id="layoutSidenav">
        
        	<!-- 메뉴 시작 -->
			<tiles:insertAttribute name="menu"></tiles:insertAttribute>
            <!-- 메뉴 끝 -->
            
            
            <div id="layoutSidenav_content">
            	<!-- 홈 시작 -->
            	<tiles:insertAttribute name="body"></tiles:insertAttribute>
            	<!-- 홈 끝 -->
                
            	<!-- 푸터 시작 -->
            	<tiles:insertAttribute name="foot"></tiles:insertAttribute>
            	<!-- 푸터 끝 -->

                
            </div>
        </div>
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js" crossorigin="anonymous"></script>
        <script src="sb_admin/js/scripts.js"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/Chart.js/2.8.0/Chart.min.js" crossorigin="anonymous"></script>
        <script src="sb_admin/assets/demo/chart-area-demo.js"></script>
        <script src="sb_admin/assets/demo/chart-bar-demo.js"></script>
        <script src="https://cdn.jsdelivr.net/npm/simple-datatables@latest" crossorigin="anonymous"></script>
        <script src="sb_admin/js/datatables-simple-demo.js"></script>
        <script src="sb_admin/assets/demo/chart-pie-demo.js"></script>
    </body>
</html>
