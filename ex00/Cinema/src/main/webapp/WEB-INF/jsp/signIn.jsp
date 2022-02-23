<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Login user</title>
    <link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
</head>
<body>
<div class="w3-panel">
    <div class="" align="center">
        <h3>Lets sign in!</h3>
        <form method="post" class="w3-container w3-card-4 w3-light-grey w3-text-blue w3-margin" style="width: 30%">

            <div class="w3-row w3-section">
                <div class="w3-col" style="width:50px"><i class="w3-xxlarge fa fa-envelope-o"></i></div>
                <div class="w3-rest">
                    <input class="w3-input w3-border" name="email" type="text" placeholder="Email">
                </div>
            </div>

            <div class="w3-row w3-section">
                <div class="w3-col" style="width:50px"><i class="w3-xxlarge fa fa-phone"></i></div>
                <div class="w3-rest">
                    <input class="w3-input w3-border" name="password" type="password" placeholder="Password">
                </div>
            </div>

            <button type="submit" class="w3-button w3-block w3-section w3-cyan w3-ripple w3-padding">Sign In</button>
        </form>
    </div>
</div>
<div class="w3-padding" align="center">
    <button onclick="location.href='/'" class="w3-button w3-pale-blue w3-block w3-section w3-padding"
            style="width: 30%">Back to main menu
    </button>
</div>
</body>
</html>

