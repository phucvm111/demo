<%-- 
    Document   : adminAccountUpdate
    Created on : Jun 24, 2022, 4:32:23 PM
    Author     : win
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<!DOCTYPE html>
<!--=== Coding by CodingLab | www.codinglabweb.com === -->
<html lang="en">

    <head>
        <meta charset="UTF-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">

        <!----======== CSS ======== -->
        <link rel="stylesheet" href="admin/account/css/style.css">
        <link rel="stylesheet" href="admin/account/boot/bootstrap.min.css">
        <link rel="stylesheet" href="admin/account/boot/bootstrap.css">
        <!----===== Iconscout CSS ===== -->
        <link rel="stylesheet" href="https://unicons.iconscout.com/release/v4.0.0/css/line.css">

        <!--<title>Admin Dashboard Panel</title>-->
    </head>

    <body>
        <form action="updateaccount?ida=${requestScope.s.getAccountID()}" method="POST">
            <nav>
                <div class="logo-name">
                    <div class="logo-image">
                        <img src="images/logo.jpg" alt="">
                    </div>

                    <span class="logo_name"><a href="listaccount" style="text-decoration: none;color: black">Admin Page</a></span>
                </div>

                <div class="menu-items">
                    <ul class="nav-links">
                        <li><a href="listaccount">
                                <i class="uil uil-estate"></i>
                                <span class="link-name">Account</span>
                            </a></li>                
                        <li><a href="listkinder">
                                <i class="uil uil-chart"></i>
                                <span class="link-name">Kindergartner</span>
                            </a></li>
                        <li><a href="#">
                                <i class="uil uil-thumbs-up"></i>
                                <span class="link-name">Class</span>
                            </a></li>
                        <li><a href="#">
                                <i class="uil uil-comments"></i>
                                <span class="link-name">Schedule</span>
                            </a></li>
                        <!--                        <li><a href="#">
                                                        <i class="uil uil-share"></i>
                                                        <span class="link-name">Attendance</span>
                                                    </a></li>-->
                    </ul>

                    <ul class="logout-mode">
                        <li><a href="#">
                                <i class="uil uil-signout"></i>
                                <span class="link-name">Logout</span>
                            </a></li>
                        </li>
                    </ul>
                </div>
            </nav>

            <div class="dashboard">

                <div class="dash-lefttop">
                    <img src="https://i.pinimg.com/originals/72/45/fb/7245fb0ca786bb4a98fb8465e437c5bb.jpg" alt="">
                    <a href="#">User</a>
                </div>

                <div class="form-title" style="text-align: center;font-size: 50px;">Update Account</div>
                <div class="form-content" style="width: 80%;height: auto; margin-left: 10%; padding-top: 0;padding-bottom: 0;">

                    <div class="mb-3">
                        <label for="exampleFormControlInput1" class="form-label">First Name</label>
                        <input type="text" class="form-control" id="exampleFormControlInput1" name="txtFirstName" value="${s.firstName}" >
                    </div>
                    <div class="mb-3">
                        <label for="exampleFormControlInput1" class="form-label">Last Name</label>
                        <input type="text" class="form-control" id="exampleFormControlInput1" name="txtLastName" value="${s.lastName}">
                    </div>
                    <div class="rdCheck" style="display: flex">
                        <div class="form-check">
                            <label for="exampleFormControlInput1" class="form-label">Gender</label>
                            <input type="radio" name="gender" 

                                   <c:if test = "${s.gender}">
                                       checked=""
                                   </c:if>    
                                   value="male" />Male
                            <input type="radio" name="gender" 

                                   <c:if test = "${!s.gender}">
                                       checked=""
                                   </c:if>    
                                   value="female" />Female 
                            <br/>
                        </div>


                    </div>

                    <div class="mb-3">
                        <label for="exampleFormControlInput1" class="form-label">Email</label>
                        <input type="email" class="form-control" id="exampleFormControlInput1" name="txtEmail" value="${s.email}" placeholder="name@example.com" readonly="">
                    </div>
                    <div class="mb-3">
                        <label for="exampleFormControlInput1" class="form-label">Pass Word</label>
                        <input type="password" class="form-control" name="txtPassword" value="${s.password}" id="exampleFormControlInput1">
                    </div>

                    <div class="mb-3">
                        <label for="exampleFormControlInput1" class="form-label">DOB</label>
                        <input type="date" name="dob" value="${s.dob}"/>(yyyy-MM-dd)<br/>
                    </div>
                    <div class="mb-3">
                        <label for="exampleFormControlInput1" class="form-label">Number Phone</label>
                        <input type="text" class="form-control" id="exampleFormControlInput1" name="txtPhone" value="${s.phoneNumber}" placeholder="name@example.com">
                    </div>
                    <div class="mb-3">
                        <label for="exampleFormControlInput1" class="form-label">Address</label>
                        <input type="text" class="form-control" id="exampleFormControlInput1" name="ttAddress" value="${s.address}" placeholder="HN, Vietnam">
                    </div>
                    <div class="mb-3">
                        <label for="exampleFormControlInput1" class="form-label">Image</label>
                        <input type="text" class="form-control" id="exampleFormControlInput1" name="txtImg" value="${s.img}">
                    </div>
                    <div class="mb-3">
                        <label for="exampleFormControlInput1" class="form-label">Role</label>
                        <input value="${s.role.roleID}" name="slRole" type="hidden"/>
                        <input type="text" class="form-control" id="exampleFormControlInput1" name="role" value="${s.role.roleName}" readonly="">
<!--                        <select class="form-select" name="slRole" aria-label="Default select example">
                            <option value="0" selected>All</option>
                            
                            <c:forEach items="${requestScope.listR}" var="role">
                                <option 
                                    <c:if test="${role.roleID eq s.role.roleID}">selected=""</c:if>

                                        value="${role.roleID}">${role.roleName}</option>
                            </c:forEach>
                        </select>-->
                    </div>



                    <div class="d-grid gap-2 d-md-block" style="margin-top: 30px; margin-bottom: 30px; ;">
                        <input type="submit" value="Save"/>
                    </div>

                </div>
            </div>
        </div>
    </form>

    <!-- <script src="agu.js"></script> -->
</body>

</html>
