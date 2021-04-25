package com.longsheng.xueqiao.admin.config;

public class ErrorConfig {
	public static final int USERNAME_INVALID= 1001;
	public static final String USERNAME_INVALID_MSG = "userName invaild";

	public static final int USER_NOT_FOUND = 1007;
	public static final String USER_NOT_FOUND_MSG = "User data not found";

	public static final int EMAIL_NOT_VALID = 1022;
	public static final String EMAIL_NOT_VALID_MSG = "email not valid";

	public static final int USERNAME_CANNOT_MODIFY = 1025;
	public static final String USERNAME_CANNOT_MODIFY_MSG = "userName can't be changed";

	public static final int ALREADY_FRIENDS = 1031;
	public static final String ALREADY_FRIENDS_MSG = "friend already in Friends";

	public static final int ACCOUNT_OR_PASSWORD_ERROR = 1034;
	public static final String ACCOUNT_OR_PASSWORD_ERROR_MSG = "account or password invalid, login fail";
	
	public static final int SESSION_TIMEOUT = 1035;
	public static final String SESSION_TIMEOUT_MSG = "login has been timeout.";
	
	public static final int USERNAME_CHANGE_ONLY_ONCE = 1036;
	public static final String USERNAME_CHANGE_ONLY_ONCE_MSG = "user name can be changed only once.";
	
	public static final int NICKNAME_NOT_NULL = 1040;
	public static final String NICKNAME_NOT_NULL_MSG = "nickName can't be null";
	
	public static final int NOT_ADDSELF_FRIEND = 1041;
	public static final String NOT_ADDSELF_FRIEND_MSG = "Can't add yourself as friend";
	
	public static final int FRINEDACCOUNT_INVALID = 1044;
	public static final String FRINEDACCOUNT_INVALID_MSG = "friendAccount invaild";
	
	public static final int ACCOUNT_NOT_EXIST = 1045;
	public static final String ACCOUNT_NOT_EXIST_MSG = "account not exist";
	
	public static final int PASSWORD_EMPTY = 1054;
	public static final String PASSWORD_EMPTY_MSG = "password can not be empty";
	
	public static final int PASSWORD_ERROR = 1058;
	public static final String PASSWORD_ERROR_MSG = "password error";
	
	public static final int METHODNAME_EMPTY = 1062;
	public static final String METHODNAME_EMPTY_MSG = "Web method name required.";
	
	public static final int ILLEGAL_ARUGUMENT = 1063;
	public static final String ILLEGAL_ARUGUMENT_MSG = "Illegal Argument! ";
	
	public static final int EMAIL_PATTERN_ERROR = 1064;
	public static final String EMAIL_PATTERN_ERROR_MSG = "Email pattern error.";
	
	public static final int METHOD_NOT_FOUND = 1066;
	public static final String METHOD_NOT_FOUND_MSG = "Web method name not found";
	
	public static final int TARGET_IN_RELATIONSHIP = 1069;
	public static final String TARGET_IN_RELATIONSHIP_MSG = "Target is in relationship.";
	
	public static final int USER_IN_RELATIONSHIP = 1070;
	public static final String USER_IN_RELATIONSHIP_MSG = "User is in relationship.";
	
	public static final int TARGET_HAS_COUPLE_APPLY = 1071;
	public static final String TARGET_HAS_COUPLE_APPLY_MSG = "Target has couple apply.";
	
	public static final int USER_HAS_COUPLE_APPLY = 1072;
	public static final String USER_HAS_COUPLE_APPLY_MSG = "User has couple apply.";
	
	public static final int COUPLE_APPLY_NOT_FOUND = 1073;
	public static final String COUPLE_APPLY_NOT_FOUND_MSG = "Couple apply not found.";
	
	public static final int COUPLE_NOT_FOUND = 1074;
	public static final String COUPLE_NOT_FOUND_MSG = "Couple not found.";
	
	public static final int TELEPHONE_ERROR = 1075;
	public static final String TELEPHONE_ERROR_MSG = "Telephone not valid";
	
	public static final int SIGN_UP_INPUT_ERROR = 1076;
	public static final String SIGN_UP_INPUT_ERROR_MSG = "Telephone and Email empty.";
	
	public static final int EMPTY_USER_IMAGE = 1200;
	public static final String EMPTY_USER_IMAGE_MSG = "Empty User Image.";
	
	public static final int IMAGE_CAN_NOT_STORE = 1201;
	public static final String IMAGE_CAN_NOT_STORE_MSG = "Image can not store, maybe format error";
	
	public static final int IMAGE_TOO_BIG = 1202;
	public static final String IMAGE_TOO_BIG_MSG = "Image is too big!";
	
}
