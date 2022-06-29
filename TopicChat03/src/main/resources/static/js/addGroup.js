/**
 * 
 */

// 入力画面の入力値のチェックを行った後で、
// 引数で指定されたパスでサブミットする
function checkInputAndSubmit(path){
    if(!checkInput()){
        return;
    }
    formSubmit(path);
}

 // 引数で指定されたパスでサブミットする
function formSubmit(path){
    if(!path){
        alert('パスを指定してください');
        return;
    }
    let form = document.getElementsByTagName('form')[0];
    if(!form){
        alert('フォームが取得できませんでした');
        return;
    }
    form.action = path;
    form.method = "post";
    form.submit();
}

// 入力画面の入力値のチェックを行う
function checkInput(){
    let group_id = document.getElementById('group_id');
    let groupname = document.getElementById('groupname');
    if(group_id.value == ''){
        alert('グループIDを入力してください。');
        group_id.focus();
        return false;
    }
    if(!group_id.value.match(/^[A-Za-z0-9]*$/)){
        alert('グループIDは半角英数で入力してください')
        group_id.focus();
        return false;
    }
    
    if(groupname.value == ''){
        alert('グループ名を入力してください。');
        groupname.focus();
        return false;
    }
    
	return true;
}

function test(path){
	let form = document.getElementsByTagName('form')[0];
	if(!form){
        alert('フォームが取得できませんでした');
        return;
    }
    alert(form);
	form.action = path;
	form.method = "get";
	form.submit();
}