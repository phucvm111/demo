<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">

    <head>
        <meta charset="UTF-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link rel="icon" href="/ATKD_Project/homepage/assets/image/logo2-removebg-preview.png">
        <title>ATKD ChildCare - Child Register</title>
        <link rel="stylesheet" href="/ATKD_Project/homepage/parent/css/parenthome.css">
        <link rel="stylesheet" href="/ATKD_Project/homepage/parent/css/childprofile.css">
        <script src="https://kit.fontawesome.com/67b5c45612.js" crossorigin="anonymous"></script>
        <script src="js/childdetails.js"></script>
        <link rel="stylesheet" href="/ATKD_Project/homepage/parent/css/childdetails.css">
        <link rel="stylesheet" href="/ATKD_Project/homepage/parent/css/childregister.css">
        <style>

        </style>
    </head>

    <body>
        <!-- Link to Add child to database -->

        <div class="wrapper">
            <div class="home">
                <div class="left-side-menu">
                    <div class="vertical-menu">
                        <div class="user-welcome">
                            <img class="user-img" src="/ATKD_Project/homepage/parent/img/userImg/dummy-user-img.png" style="width: 80px; height: 80px;" alt="">
                            <p>${sessionScope.account.firstName} ${sessionScope.account.lastName}</p>
                        </div>
                        <div class="menu-item-container">
                            <ul class="item-lists">
                                <li class="menu-item">
                                    <a href="/ATKD_Project/homepage/childdetailservlet">Child Information</a>
                                </li>
                                <li class="menu-item">
                                    <a href="/ATKD_Project/homepage/parent/parentprofile.jsp">Parent Information</a>
                                </li>
                                <li class="menu-item  current1">
                                    <a href="/ATKD_Project/homepage/parent/childregister.jsp">Child Register</a>
                                </li>
                            </ul>
                        </div>
                        <div style="border-top: 3px solid gray;"></div>
                        <div style="position: absolute;margin-top: 1vh; margin-left: 40px">
                            <input type="button" class="log-out_button" onclick="window.location.replace('/ATKD_Project/homepage/logout')" value="Log out"/>
                        </div>
                    </div>
                </div>
                <!-- Form add -->
                <c:if test="${classlist.isEmpty()}">
                    <div class="nochild">
                        <h1>There is no class available right now !</h1>
                        <br><!-- comment -->
                        <h1>Please wait until a class is available to register</h1> 
                    </div>
                </c:if>
                <c:if test="${!classlist.isEmpty()}">
                    <form action="/ATKD_Project/homepage/childregister" method="POST">
                        <div class="child-register">
                            <div class="page-content">
                                <div class="kid-register">
                                    <div class="kid-register_content">
                                        <div class="kindergartner-register" >Kindergartner Register</div>
                                        <div style="width: 80%;height: auto; margin-left: 10%; padding-top: 0;padding-bottom: 0; margin-top: 40px">
                                            <div class="mb-3">
                                                <div class="content-item wrap-input100 validate-input">
                                                    <div class="item-title">
                                                        <strong>Child first name</strong>
                                                    </div>
                                                    <label for="exampleFormControlInput1" class="form-label"></label>
                                                    <input type="text" class="class content-item" id="ChildFirstName" name="ChildFirstName" pattern="[a-zA-Z]+" title="Alphabetical letters only" required="">
                                                    <span class="focus-input100"></span>
                                                </div>
                                            </div>
                                            <span class="invalid" id="fnameinvalid1" style="display: none;margin-left: 12%" >Name cannot contain
                                                numeric characters !</span>
                                            <span class="invalid" id="fnameinvalid2" style="display: none;margin-left: 12%">Name cannot contain
                                                special characters !</span>
                                            <div class="mb-3">
                                                <div class="content-item wrap-input100 validate-input">
                                                    <div class="item-title">
                                                        <strong>Child last name</strong>
                                                    </div>
                                                    <label for="exampleFormControlInput1" class="form-label"></label>
                                                    <input type="text" class="class content-item" id="ChildLastName" name="ChildLastName" pattern="[a-zA-Z]+" title="Alphabetical letters only" required="">
                                                    <span class="focus-input100"></span>
                                                </div>
                                            </div>
                                            <span class="invalid" id="lnameinvalid1" style="display: none;margin-left: 12%" >Name cannot contain
                                                numeric characters !</span>
                                            <span class="invalid" id="lnameinvalid2" style="display: none;margin-left: 12%">Name cannot contain
                                                special characters !</span>
                                            <div class="mb-3">
                                                <div class="content-item">
                                                    <div class="item-title">
                                                        <strong>DOB</strong>
                                                    </div>
                                                    <label for="exampleFormControlInput1" class="form-label"></label>
                                                    <input type="date" class="class content-item" id="exampleFormControlInput1" name="DOB" required="">     
                                                </div>
                                            </div>
                                            <div class="mb-3">
                                                <div class="content-item">
                                                    <div class="gender">
                                                        <strong>Gender</strong>
                                                    </div>

                                                    <div class="rdCheck" style="display: flex;padding-left: 30px">

                                                        <div class="form-check">
                                                            <div class="img-gender" >
                                                                <img src="/ATKD_Project/homepage/parent/img/userImg/images.jpg" alt="">
                                                                <p style="padding-top: 10px;padding-left: 10px;padding-right: 10px">
                                                                    Male
                                                                </p>
                                                                <input class="form-check-input" type="radio" value="male" name="flexRadioDefault" id="flexRadioDefault1" checked>
                                                            </div>
                                                        </div>
                                                    </div>
                                                    <div class="form-check" style="padding-left: 80px">
                                                        <div class="img-gender">
                                                            <img src="/ATKD_Project/homepage/parent/img/userImg/download.png" alt="">
                                                            <p style="padding-top: 10px;padding-left: 10px;padding-right: 10px">
                                                                Female
                                                            </p>
                                                            <input class="form-check-input" type="radio" value="female" name="flexRadioDefault" id="flexRadioDefault2">
                                                        </div>
                                                    </div>     
                                                </div>
                                            </div>
                                            <div class="mb-3">
                                                <div class="content-item">
                                                    <div class="item-title">
                                                        <strong>Choose desired class : </strong>
                                                    </div>

                                                    <select name="register_classid" id="register_classid" class="class content-item">
                                                        <c:forEach items="${classlist}" var="c">
                                                            <option value="${c.getClass_id()}">
                                                            <h1>${c.getClass_name()}</h1>
                                                            </option>
                                                        </c:forEach>
                                                    </select>  
                                                </div>
                                            </div>
                                            <div class="mb-6" style="margin-top: 30px; margin-bottom: 30px; padding-left: 250px ">
                                                <input type="button" class="button" onclick="openPopup()" value="Confirm"/>
                                                <div class="popup" id="popup">
                                                    <img src="/ATKD_Project/homepage/parent/img/icon/tick.png">
                                                    <h2>Confirm registration ?</h2>
                                                    <input type="button" class="cancel_button" onclick="closePopup()" value="Cancel">
                                                    <input style="margin-left: 60px;" type="submit" class="confirm_button"  value="Confirm">
                                                </div>    
                                            </div>
                                        </div>
                                    </div>
                                </div>       
                            </div>
                        </div>
                    </form>
                </div>
            </div>
            <!-- <script src="agu.js"></script> -->
            <script>
                let popup = document.getElementById("popup");

                function openPopup() {
                    popup.classList.add("open-popup");
                }
                function closePopup() {
                    popup.classList.remove("open-popup");
                }
            </script>
            <script>
            var fname = document.getElementById("ChildFirstName");
            var lname = document.getElementById("ChildLastName");
            
            fname.onkeyup = function () {
                var numbers = /[0-9]/g;
                if (fname.value.match(numbers)) {
                    document.getElementById("fnameinvalid1").style.display = "block";
                } else {
                    document.getElementById("fnameinvalid1").style.display = "none";
                }
                var specs = /[ `!@#$%^&*()_+\-=\[\]{};':"\\|,.<>\/?~]/;
                if (fname.value.match(specs)) {
                    document.getElementById("fnameinvalid2").style.display = "block";
                } else {
                    document.getElementById("fnameinvalid2").style.display = "none";
                }
            }

            lname.onkeyup = function () {
                var numbers = /[0-9]/g;
                if (lname.value.match(numbers)) {
                    document.getElementById("lnameinvalid1").style.display = "block";
                } else {
                    document.getElementById("lnameinvalid1").style.display = "none";
                }
                var specs = /[ `!@#$%^&*()_+\-=\[\]{};':"\\|,.<>\/?~]/;
                if (lname.value.match(specs)) {
                    document.getElementById("lnameinvalid2").style.display = "block";
                } else {
                    document.getElementById("lnameinvalid2").style.display = "none";
                }
            }

            
        </script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"
                integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous">
        </script>
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"></script>
        </c:if>
    </body>




</html>

















