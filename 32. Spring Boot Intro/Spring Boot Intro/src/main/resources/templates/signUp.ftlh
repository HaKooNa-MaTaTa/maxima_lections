<!DOCTYPE html>
<#import "spring.ftl" as spring/>
<head>
    <meta charset="UTF-8">
    <title><@spring.message 'page.signUp.title'/></title>
    <style>
        .error {
            color: red;
        }
    </style>
</head>
<body>
<h1><@spring.message 'page.signUp.header'/></h1>
<h2><@spring.message 'page.signUp.description'/></h2>
<form action="/signUp" method="post">
    <@spring.bind path="signUpForm"/>
    <label for="firstName"><@spring.message 'page.signUp.label.firstName'/></label>
    <#assign i18Tooltip><@spring.message 'page.signUp.placeholder.firstName'/></#assign>
    <@spring.formInput "signUpForm.firstName" "placeholder=${i18Tooltip}"/>
    <@spring.showErrors "<br>" "error"/>
    <br>
    <br>
    <label for="lastName"><@spring.message 'page.signUp.label.lastName'/></label>
    <#assign i18Tooltip><@spring.message 'page.signUp.placeholder.lastName'/></#assign>
    <@spring.formInput "signUpForm.lastName" "placeholder=${i18Tooltip}"/>
    <@spring.showErrors "<br>" "error"/>
    <br>
    <br>
    <label for="email"><@spring.message 'page.signUp.label.email'/></label>
    <#assign i18Tooltip><@spring.message 'page.signUp.placeholder.email'/></#assign>
    <@spring.formInput "signUpForm.email" "placeholder=${i18Tooltip}"/>
    <@spring.showErrors "<br>" "error"/>
    <br>
    <br>
    <label for="password"><@spring.message 'page.signUp.label.password'/></label>
    <#assign i18Tooltip><@spring.message 'page.signUp.placeholder.password'/></#assign>
    <@spring.formInput "signUpForm.password" "placeholder=${i18Tooltip}"/>
    <@spring.showErrors "<br>" "error"/>
    <input type="submit" value="Sign Up">
</form>
</body>
