package com.lty.newApp;

public class Constants {
	public final static int SPLASH_DISPLAY_LENGHT = 4000; // 登陆等待延迟4秒 

	public static final String APP_ID="com.lty.newapp";//应用程序ID
	

	public static final String CHARSET = "utf-8";
	
	public static final String SERVER_URL="http://litianyun.nat123.net:1622/TestServer/api.jsp";

	public static final String DateTime="2014年8月23日 17:44";//设置时间
	
	public static final int RESULT_STATUS_SUCCESS = 1; //成功
	public static final int RESULT_STATUS_FAIL = 0; //失败
	public static final int RESULT_STATUS_INVALID_TOKEN = 2;
	
	public static final String KEY_ACTION = "action";
	public static final String KEY_STATUS = "status";// 状态KEy
	public static final String ACTION_GET_CODE = "send_pass"; // 报文头，获取短信验证码
	public static final String ACTION_VERIFICATION_CODE = "verification_code"; // 报文头，验证短信验证码
	public static final String ACTION_SGIN = "sgin"; // 报文头，注册
	public static final String ACTION_LOGN = "logn"; // 报文头，登陆
	public static final String KEY_CODE = "code";
	
	public static final String KEY_TRANS_CODE="key_trans_code"; // 交易码
	public static final String KEY_TRANS_TYPE ="key_trans_type"; // 交易类型
	public static final String KEY_RETURN_CODE ="key_return_code"; // 响应码
	public static final String KEY_RETURN_MESSAGE ="key_return_message"; // 响应信息
	public static final String KEY_MOBILE_NUMBER ="key_mobile_number"; // 手机号码
	public static final String KEY_PASSWORD="key_password";// 登陆密码
	public static final String KEY_CUS_ID="key_cus_id";
	// oneday刷新返回报文
	public static final String KEY_TOKEN="key_token";// token缓存验证码KEY
	public static final String KEY_USER_NAME="key_user_name";//用户名
	public static final String KEY_USER_CSID="key_user_csid";//用户ID
	public static final String KEY_USER_HEAD="key_user_head";//用户头像
	public static final String KEY_ONEDAY_ID="key_oneday_id";//对应oneday流水ID
	public static final String KEY_ONEDAY_TODAY_ID = "key_oneday_today_id";// 当日流水ID
	public static final String KEY_ONEDAY_TIME="key_oneday_time";//对应oneday发表时间
	public static final String KEY_ONEDAY_PLACE="key_oneday_place";//对应oneday发表地点
	public static final String KEY_ONEDAY_DATE="key_oneday_date";//对应oneday发表日期
	public static final String KEY_ONEDAY_TITLE="key_oneday_title";//对应oneday发表标题
	public static final String KEY_ONEDAY_NUM="key_oneday_num";//对应oneday发表期数
	public static final String KEY_ONEDAY_PRAISE_NUM="key_oneday_praise_num";//对应oneday获得赞总数
	public static final String KEY_ONEDAY_DISCUSSION_NUM="key_oneday_discussion_num";//对应oneday获得讨论总数
	public static final String KEY_ONEDAY_CONTENT="key_oneday_content";//对应oneday内容
	public static final String KEY_ONEDAY_IMG="key_oneday_img";//对应oneday图片
	public static final String KEY_ONEDAY_HEAD_INFO = "key_oneday_head_info";// oneday头部信息
	public static final String KEY_ONEDAY_BODY_INFO = "key_oneday_body_info";// oneday主体信息

	
	public static final String ACTION_TRANS_CODE_201="201"; // 交易码 用户登陆请求
	public static final String ACTION_TRANS_CODE_801="801"; // 交易码 刷新oneday信息
	public static final String ACTION_RETURN_CODE_0="0"; // 响应码 0成功
	public static final String ACTION_TRANS_TYPE_REQUEST="request"; // 交易类型 请求
	public static final String ACTION_RESPONSE="response"; // 交易类型，返回信息
	public static final String ACTION_RETURN_CODE_5 ="5"; // 服务器响应超时，请重新连接
	public static final String ACTION_RETURN_MESSAGE_5 ="服务器响应超时，请重新连接"; // 响应信息
	public static final String ACTION_RETURN_CODE_10 ="10"; // 服务器响应异常
	public static final String ACTION_RETURN_MESSAGE_10 ="程序异常"; // 响应信息
	public static final String ACTION_RETURN_CODE_11 ="11"; // 服务器响应异常
	public static final String ACTION_RETURN_MESSAGE_11 ="服务器响应异常"; // 服务器响应异常




}
