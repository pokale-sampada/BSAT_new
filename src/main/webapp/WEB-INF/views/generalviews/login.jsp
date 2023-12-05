<!DOCTYPE html>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<html lang="en">

<head>
    <title>BSAT R3</title>
    <!-- HTML5 Shim and Respond.js IE10 support of HTML5 elements and media queries -->
    <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
    <!--[if lt IE 10]>
      <script src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>
      <script src="https://oss.maxcdn.com/libs/respond.js/1.4.2/respond.min.js"></script>
      <![endif]-->
    <!-- Meta -->
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0, user-scalable=0, minimal-ui">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="description" content="#">
    <meta name="keywords" content="Admin , Responsive, Landing, Bootstrap, App, Template, Mobile, iOS, Android, apple, creative app">
    <meta name="author" content="#">
    <!-- Favicon icon -->
    <link rel="icon" href="files\assets\images\favicon.ico" type="image/x-icon">
    <!-- Google font--><link href="https://fonts.googleapis.com/css?family=Open+Sans:400,600,800" rel="stylesheet">
    <!-- Required Fremwork -->
    <link rel="stylesheet" type="text/css" href="files\bower_components\bootstrap\css\bootstrap.min.css">
    <!-- themify-icons line icon -->
    <link rel="stylesheet" type="text/css" href="files\assets\icon\themify-icons\themify-icons.css">
    <!-- ico font -->
    <link rel="stylesheet" type="text/css" href="files\assets\icon\icofont\css\icofont.css">
    <!-- Style.css -->
    <link rel="stylesheet" type="text/css" href="files\assets\css\style.css">
 <!--   <title>BSAT bot</title> -->
    <!--Import Google Icon Font-->
    <link href="https://fonts.googleapis.com/icon?family=Material+Icons" rel="stylesheet">
    <!--Import materialize.css-->
    <link rel="stylesheet" type="text/css" href="resources/static/css/style.css">
    <!--Main css-->
    <link rel="stylesheet" type="text/css" href="resources/static/css/materialize.min.css">
    <link href="https://fonts.googleapis.com/icon?family=Material+Icons" rel="stylesheet">
    <!--Let browser know website is optimized for mobile-->
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <script>
        var n = Math.floor(Math.random() * 1000000000);
        window.localStorage.setItem("username", n);
        console.log("Random number " + Math.random());
        console.log("XYZ generating user id ");
        console.log("generated  no is " + n);
    </script>
    
</head>

<body class="fix-menu">
  <div class="container">

        <!-- <div class="widget" id="widget" style="background-image:url('./static/img/background_berger1.png');"> -->
        <div class="widget" id="widget">
            <div class="chat_header">

                <!--Add the name of the bot here -->
                <span style="color:white;margin-left: 105px;">
                  <img class="omfysLogo" src="./static/img/berger.png"><name>BSAT Digital Assistant </name></img></span>
                <span style="color:white;margin-right: 5%;float:right;margin-top:4px;font-size: 4%;">
                  <i class="material-icons" id = "close">call_received</i>
                  <i onclick='javascript:window.parent.Close();' id = "closeb"class="material-icons">close</i>
               
               </span>
            </div>

            <!--Chatbot contents goes here -->
            <div class="chats" id="chats">
                <div class="clearfix"></div>
            </div>
            <!--user typing indicator -->
            <div class="keypad">
                <input type="text" id="keypad" class="usrInput browser-default" placeholder="Type a message..." autocomplete="off" required>
            </div><i class="material-icons" id="send1" onclick="enter();">send</i>
        </div>
    </div>
    <!--bot widget -->
    <div class="profile_div" id="profile_div">
        <img class="imgProfile" src="resources/static/img/userAvatar.jpg" />
    </div>
    <!--JavaScript at end of body for optimized loading-->
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
    <script type="text/javascript" src="resources/static/js/materialize.min.js"></script>
    <!--Main Script -->
    <script type="text/javascript" src="resources/static/js/script.js"></script>
    <script>
        document.onload = send('hi');
        popmsg = "Ask BSAT Digital Assitant."
        popup(popmsg)
    </script>
    	
<!-- 	End of ChatBot UI code -->
    <!-- Pre-loader start -->
    <div class="theme-loader">
        <div class="ball-scale">
            <div class='contain'>
                <div class="ring"><div class="frame"></div></div>
                <div class="ring"><div class="frame"></div></div>
                <div class="ring"><div class="frame"></div></div>
                <div class="ring"><div class="frame"></div></div>
                <div class="ring"><div class="frame"></div></div>
                <div class="ring"><div class="frame"></div></div>
                <div class="ring"><div class="frame"></div></div>
                <div class="ring"><div class="frame"></div></div>
                <div class="ring"><div class="frame"></div></div>
                <div class="ring"><div class="frame"></div></div>
            </div>
        </div>
    </div>
    <!-- Pre-loader end -->

    <section class="login-block">
        <!-- Container-fluid starts -->
        <div class="container">
            <div class="row">
                <div class="col-sm-12">
                    <!-- Authentication card start -->
                    
                        <form class="md-float-material form-material" name ="login-form" action="berger_login" method="post">
                            <div class="text-center">
                                <!-- <img src="files\assets\images\OmfysLogo.png" alt="logo.png"> -->
                                <h3 class="text-center" style="color: white;">Business Scheme Automation Tool</h3>
                            </div>
                            <div class="auth-box card">
                                <div class="card-block">
                                    <div class="row m-b-20">
                                        <div class="col-md-12 text-center">
                                           <!--  <h3 class="text-center">Sign In</h3> -->
                                           <img src="files\assets\images\OmfysLogo.png" alt="logo.png">
                                        </div>
                                    </div>
                                    <div class="form-group form-primary">
                                    <spring:bind path="kwm_users.user_name">
                                        <input type="text" id="username" name="${status.expression}" class="form-control" required="" placeholder="Your Email Address">
                                        <span class="form-bar"></span>
                                       </spring:bind>
                                    </div>
                                    <div class="form-group form-primary">
                                    <spring:bind path="kwm_users.password">
                                        <input type="password" name="${status.expression}" class="form-control" required="" placeholder="Password">
                                        <span class="form-bar"></span>
                                    </spring:bind>
                                    </div>
                                    <div class="row m-t-25 text-left">
                                        <div class="col-12">
                                            <div class="checkbox-fade fade-in-primary d-">
                                                <label>
                                                    <input type="checkbox" value="">
                                                    <span class="cr"><i class="cr-icon icofont icofont-ui-check txt-primary"></i></span>
                                                    <span class="text-inverse">Remember me</span>
                                                </label>
                                            </div>
                                            <div class="forgot-phone text-right f-right">
                                                <a href="resetpassotp" class="text-right f-w-600"> Forgot Password throughOTP?</a>
                                            </div>
                                            <div class="forgot-phone text-right f-right">
                                                <a href="resetpass" class="text-right f-w-600"> Forgot Password?</a>
                                            </div>
                                        </div>
                                    </div>
                                    <div class="row m-t-30">
                                        <div class="col-md-12">
                                            <button type="submit" onKeyPress="submitOnEnter(this, event)" value="Login" 
                                            class="btn btn-primary btn-md btn-block waves-effect waves-light text-center m-b-20">Sign in</button>
                                        </div>
                                    </div>
                                  <!--   <hr> -->
                                  <!--   <div class="row">
                                        <div class="col-md-10">
                                            <p class="text-inverse text-left m-b-0">Thank you.</p>
                                            <p class="text-inverse text-left"><a href="index-1.htm"><b class="f-w-600">Back to website</b></a></p>
                                        </div>
                                        <div class="col-md-2">
                                            <img src="files\assets\images\auth\Logo-small-bottom.png" alt="small-logo.png">
                                        </div>
                                    </div> -->
                                </div>
                            </div>
                        </form>
                        <!-- end of form -->
                </div>
                <!-- end of col-sm-12 -->
            </div>
            <!-- end of row -->
        </div>
        <!-- end of container-fluid -->
    </section>
    <!-- Warning Section Starts -->
    <!-- Older IE warning message -->
    <!--[if lt IE 10]>
<div class="ie-warning">
    <h1>Warning!!</h1>
    <p>You are using an outdated version of Internet Explorer, please upgrade <br/>to any of the following web browsers to access this website.</p>
    <div class="iew-container">
        <ul class="iew-download">
            <li>
                <a href="http://www.google.com/chrome/">
                    <img src="../files/assets/images/browser/chrome.png" alt="Chrome">
                    <div>Chrome</div>
                </a>
            </li>
            <li>
                <a href="https://www.mozilla.org/en-US/firefox/new/">
                    <img src="../files/assets/images/browser/firefox.png" alt="Firefox">
                    <div>Firefox</div>
                </a>
            </li>
            <li>
                <a href="http://www.opera.com">
                    <img src="../files/assets/images/browser/opera.png" alt="Opera">
                    <div>Opera</div>
                </a>
            </li>
            <li>
                <a href="https://www.apple.com/safari/">
                    <img src="../files/assets/images/browser/safari.png" alt="Safari">
                    <div>Safari</div>
                </a>
            </li>
            <li>
                <a href="http://windows.microsoft.com/en-us/internet-explorer/download-ie">
                    <img src="../files/assets/images/browser/ie.png" alt="">
                    <div>IE (9 & above)</div>
                </a>
            </li>
        </ul>
    </div>
    <p>Sorry for the inconvenience!</p>
</div>
<![endif]-->
    <!-- Warning Section Ends -->
    <script type="text/javascript">
		$(document).ready(function() {

			var daydiff = ${diffDays};
			if (daydiff > 31) {
				alert("Your Password is Expired, Please Contact with Admin");
			}
		});

		function submitOnEnter(inputElement, event) {
			if (event.keyCode == 13) {
				ValidateLogOn();
			}
		}

		function ValidateLogOn() {

			var userName = document.getElementById('username').value;
			var password = document.getElementById('password').value;

			if (userName == "") {
				alert("Enter Username.");
			} else if (password == "") {
				alert("Enter Password.");
			} else 
				if(userName == "aribha" && password == "Welcome@123")
				var forms = document.getElementById('login-form');
				forms.submit();
			}
		}
	</script>
	<script>
		var ab = ${ab};
		if (ab == 5) {
			document.getElementById("myAlert").style.display = "block";
		}
	</script>
    <!-- Required Jquery -->
    <script type="text/javascript" src="files\bower_components\jquery\js\jquery.min.js"></script>
    <script type="text/javascript" src="files\bower_components\jquery-ui\js\jquery-ui.min.js"></script>
    <script type="text/javascript" src="files\bower_components\popper.js\js\popper.min.js"></script>
    <script type="text/javascript" src="files\bower_components\bootstrap\js\bootstrap.min.js"></script>
    <!-- jquery slimscroll js -->
    <script type="text/javascript" src="files\bower_components\jquery-slimscroll\js\jquery.slimscroll.js"></script>
    <!-- modernizr js -->
    <script type="text/javascript" src="files\bower_components\modernizr\js\modernizr.js"></script>
    <script type="text/javascript" src="files\bower_components\modernizr\js\css-scrollbars.js"></script>
    <!-- i18next.min.js -->
    <script type="text/javascript" src="files\bower_components\i18next\js\i18next.min.js"></script>
    <script type="text/javascript" src="files\bower_components\i18next-xhr-backend\js\i18nextXHRBackend.min.js"></script>
    <script type="text/javascript" src="files\bower_components\i18next-browser-languagedetector\js\i18nextBrowserLanguageDetector.min.js"></script>
    <script type="text/javascript" src="files\bower_components\jquery-i18next\js\jquery-i18next.min.js"></script>
    <script type="text/javascript" src="files\assets\js\common-pages.js"></script>
<!-- Global site tag (gtag.js) - Google Analytics -->
<script async="" src="https://www.googletagmanager.com/gtag/js?id=UA-23581568-13"></script>
<script>
  window.dataLayer = window.dataLayer || [];
  function gtag(){dataLayer.push(arguments);}
  gtag('js', new Date());

  gtag('config', 'UA-23581568-13');
</script>
</body>

</html>
