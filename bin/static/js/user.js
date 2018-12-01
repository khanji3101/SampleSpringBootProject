/**
 * フォーム遷移処理
 * @param formName フォーム名
 * @param actionPath マッピングパス
 * @param params フォーム値
 * @returns
 */
function forward(formName, actionPath, params) {

	//フォームのアクション設定
	document.forms[formName].action = actionPath;

	//パラメータ設定
	for (var i = 0; i < params.length; i++) {
		var element = document.createElement("input");
		element.type = "hidden";
		element.name = params[i][0];
		element.value = params[i][1];
		document.forms[formName].appendChild(element);
	}

	document.forms[formName].submit();

}