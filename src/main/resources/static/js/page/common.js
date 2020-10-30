function go_link(key){
    if(key=='policy'){
        login();
    }
    location.href=key
}

function login(){
    var loginForm = document.loginForm;
    var regular_emp_num = loginForm.regular_emp_num.value;
    var password = loginForm.password.value;

    if(!regular_emp_num || !password){
        alert("지원번호와 비밀번호를 모두 입력해주세요.")
    }else{
        loginForm.submit();
    }
}