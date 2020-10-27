<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>

<!-- tag-libs -->
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<!-- JSTL -->
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>

<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="description" content="">
    <meta name="author" content="">
    <%@ include file="/WEB-INF/views/admin/layout/include-css.jsp"%>
</head>

<body class="fix-header">
    <!-- ============================================================== -->
    <!-- Preloader -->
    <!-- ============================================================== -->
    <div class="preloader">
        <svg class="circular" viewBox="25 25 50 50">
            <circle class="path" cx="50" cy="50" r="20" fill="none" stroke-width="2" stroke-miterlimit="10" />
        </svg>
    </div>
    <!-- ============================================================== -->
    <!-- Wrapper -->
    <!-- ============================================================== -->
    <div id="wrapper">
        
        <%@ include file="/WEB-INF/views/admin/layout/header.jsp"%>
        
        <!-- Page Content -->
        <!-- ============================================================== -->
        <div id="page-wrapper">
            
            <div class="container-fluid">
                <div class="row bg-title">
                    <div class="col-lg-3 col-md-4 col-sm-4 col-xs-12">
                        <h4 class="page-title">Add Post</h4>
                    </div>
                    <div class="col-lg-9 col-sm-8 col-md-8 col-xs-12">
                        <ol class="breadcrumb">
                            <li><a href="#">Dashboard</a></li>
                            <li class="active">Add Post</li>
                        </ol>
                    </div>
                </div>
                <!-- /.row -->
                <!-- .row -->
                <div class="row">
                    <!-- <div class="col-md-4 col-xs-12">
                        <div class="white-box">
                            <div class="user-bg"> <img width="100%" alt="user" src="/plugins/images/large/img1.jpg">
                                <div class="overlay-box">
                                    <div class="user-content">
                                        <a href="javascript:void(0)"><img src="//plugins/images/users/genu.jpg" class="thumb-lg img-circle" alt="img"></a>
                                        <h4 class="text-white">User Name</h4>
                                        <h5 class="text-white">info@myadmin.com</h5> </div>
                                </div>
                            </div>
                            <div class="user-btm-box">
                                <div class="col-md-4 col-sm-4 text-center">
                                    <p class="text-purple"><i class="ti-facebook"></i></p>
                                    <h1>258</h1> </div>
                                <div class="col-md-4 col-sm-4 text-center">
                                    <p class="text-blue"><i class="ti-twitter"></i></p>
                                    <h1>125</h1> </div>
                                <div class="col-md-4 col-sm-4 text-center">
                                    <p class="text-danger"><i class="ti-dribbble"></i></p>
                                    <h1>556</h1> </div>
                            </div>
                        </div>
                    </div> -->
                    <div class="col-md-12 col-xs-12">
                        <div class="white-box">
                            
                            <!-- F O R M -->
                            <form:form cssClass="form-horizontal form-material" action="/admin/add-post" method="post" modelAttribute="post" enctype="multipart/form-data">
                            	<!-- category -->
                                <div class="form-group">
                                    <label class="col-md-12">Category</label>
                                    <div class="col-md-12">
                                        <!-- <input type="text" placeholder="Category" class="form-control form-control-line">  -->
                                        <form:select class="form-control form-control-line" path="category.id">
											<form:options items="${categories}" itemValue="id" itemLabel="name"/>
										</form:select>
                                    </div>
                                </div>
                                
                                <!-- title -->
                                <div class="form-group">
                                    <label class="col-md-12">Title</label>
                                    <div class="col-md-12">
                                        <form:input path="title" placeholder="Title" cssClass="form-control form-control-line"/> 
                                    </div>
                                </div>
                                
                                <!-- description -->
                                <div class="form-group">
                                    <label class="col-md-12">Description</label>
                                    <div class="col-md-12">
                                        <form:input path="description" placeholder="Description"  cssClass="form-control form-control-line"/> 
                                    </div>
                                </div>
                                
                                <!-- details -->
                                <div class="form-group">
                                    <label class="col-md-12">Details</label>
                                    <div class="col-md-12">
                                        <form:textarea id="details" path="details" placeholder="Details" class="form-control form-control-line"/> 
                                    </div>
                                </div>
                                
                                <!-- details -->
                                <div class="form-group">
                                    <label class="col-md-12">Attachments</label>
                                    <div class="col-md-12">
                                        <input type="file" name="postImages"/> 
                                    </div>
                                </div>
                                
                                <div class="form-group">
                                    <div class="col-sm-12">
                                        <button class="btn btn-success" type="submit">Create Post</button>
                                    </div>
                                </div>
                            </form:form>
                            <!-- // F O R M -->
                            
                        </div>
                    </div>
                </div>
            </div>
            
            <%@ include file="/WEB-INF/views/admin/layout/footer.jsp"%>
        </div>
        <!-- ============================================================== -->
        <!-- End Page Content -->
        <!-- ============================================================== -->
    </div>
    <!-- ============================================================== -->
    <!-- End Wrapper -->
    <!-- ============================================================== -->
    <!-- ============================================================== -->
    <%@ include file="/WEB-INF/views/admin/layout/include-js.jsp"%>
    
    <script type="text/javascript">
    
	 	// ::: for richtext editor
		$(document).ready(function() {
		  $('#details').summernote();
		});
    
    </script>
    
</body>

</html>
