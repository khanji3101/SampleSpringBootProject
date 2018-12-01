package com.khanji.springboot.constant;

/**
 * 処理別マッピング用URL定数クラス
 *
 * @author khanji
 *
 */
public class UrlConstant {

    /** ユーザ情報URL -> インデックス初期表示 */
    public static final String URL_INIT_INDEX_USERINFO = "/";

    /** ユーザ情報URL -> 登録初期表示 */
    public static final String URL_INIT_REGIST_USERINFO = "initRegistUserInfo";

    /** ユーザ情報URL -> 登録実行 */
    public static final String URL_REGIST_USERINFO = "registUserInfo";

    /** ユーザ情報URL -> 登録確認初期表示 */
    public static final String URL_INIT_REGIST_CONFIRM_USERINFO = "initRegistConfirmUserInfo";

    /** ユーザ情報URL -> 登録確認実行遷移 */
    public static final String URL_EXEC_REGIST_CONFIRM_USERINFO = "execRegistConfirmUserInfo";

    /** ユーザ情報URL -> 編集初期表示 */
    public static final String URL_INIT_EDIT_USERINFO = "initEditUserInfo";

    /** ユーザ情報URL -> 編集実行遷移 */
    public static final String URL_EDIT_USERINFO = "editUserInfo";

    /** ユーザ情報URL -> 編集確認初期表示 */
    public static final String URL_INIT_EDIT_CONFIRM_USERINFO = "initEditConfirmUserInfo";

    /** ユーザ情報URL -> 編集確認実行遷移 */
    public static final String URL_EDIT_CONFIRM_USERINFO = "editConfirmUserInfo";

    /** ユーザ情報URL -> 編集確認完了 */
    public static final String URL_EXEC_EDIT_CONFIRM_USERINFO = "execEditConfirmUserInfo";

    /** ユーザ情報URL -> 削除確認初期表示 */
    public static final String URL_INIT_DELETE_CONFIRM_USERINFO = "initDeleteConfirmUserInfo";

    /** ユーザ情報URL -> 削除確認実行遷移 */
    public static final String URL_EXEC_DELETE_CONFIRM_USERINFO = "execDeleteConfirmUserInfo";
}
