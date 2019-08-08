/**
 * 
 */
package com.sci.services.customerservice.constants;

/**
 * @author mn259
 *
 */
public class CustomerQueryConstants {
	
	public static final String GET_ALL_CUSTOMERS = "select customer.CUSTOMER_ID, customer.USER_ID, customer.ACTIVE_FLAG, customer.CUSTOMER_ID_NUM,customer.CUSTOMER_DOB,"+" user.FIRST_NAME, user.MIDDLE_NAME, user.LAST_NAME, userDetails.EMAIL, userDetails.PHONE,"
	+" userLoginInfo.ROLE_ID, userLoginInfo.USERNAME, userLoginInfo.PASSWORD ,address.BUILDING_NAME,address.STREET_NAME, address.CITY, address.STATE"+" from customer_details_tbl as customer, user_details_tbl as userDetails,  "
	+	" user_login_info_tbl as userLoginInfo, user_tbl as user, address_details_tbl as address"+" where customer.USER_ID = userDetails.USER_ID"
	+" and customer.USER_ID = user.USER_ID"+" and customer.USER_ID = userLoginInfo.USER_ID"+" and userDetails.ADDRESS_DETAILS_ID = address.ADDRESS_DETAILS_ID";
	
	public static final String GET_CUSTOMER_ID ="select customer.CUSTOMER_ID, customer.USER_ID, customer.ACTIVE_FLAG, customer.CUSTOMER_ID_NUM,"+
	" user.FIRST_NAME, user.MIDDLE_NAME, user.LAST_NAME, userDetails.EMAIL, userDetails.PHONE,"+
	" userLoginInfo.ROLE_ID, address.BUILDING_NAME, address.STREET_NAME, address.CITY, address.STATE "+
	" from customer_details_tbl as customer, user_details_tbl as userDetails,"+
	" user_login_info_tbl as userLoginInfo, user_tbl as user, address_details_tbl as address"+
	" where customer.USER_ID = userDetails.USER_ID"+
	" and customer.USER_ID = user.USER_ID"+
	" and customer.USER_ID = userLoginInfo.USER_ID"+
	" and userDetails.ADDRESS_DETAILS_ID = address.ADDRESS_DETAILS_ID"+
	" and customer.CUSTOMER_ID = ";
	public static final String CREATE_SQL = "INSERT INTO user_tbl(first_name, last_name,middle_name,active_flag,last_modified_datetime) VALUES (?,?,?,?,?)";
	public static final String SELECT_SQL = "SELECT user_id, first_name, last_name, middle_name,active_flag,last_modified_datetime FROM user_tbl e " + "WHERE user_id = ?";
	
	public static final String SELECT_CUSTOMER_DETAILS_SQL = "SELECT CUSTOMER_ID FROM customer_details_tbl cdt " + "WHERE user_id = ?";
	public static final String UPDATE_CUSTOMER_DETAILS_SQL = "UPDATE customer_details_tbl set CUSTOMER_DOB=?, ACTIVE_FLAG=?,LAST_MODIFIED_DATETIME=?, CUSTOMER_ID_NUM=? where CUSTOMER_ID =?";
	
	public static final String SELECT_USRLOGIN_SQL = "SELECT user_login_id FROM user_login_info_tbl e " + "WHERE user_id = ?";
	public static final String UPDATE_USERLOGIN_SQL = "UPDATE user_login_info_tbl set user_id=?, role_id=?,active_flag=?,last_modified_datetime=? where user_login_id =?";
	
	public static final String USER_ADDR_SQL = "SELECT address_details_id FROM user_details_tbl ae " + "WHERE user_id = ?";
	public static final String UPDATE_ADDR_SQL ="UPDATE address_details_tbl set building_name=?, street_name=?,city=?, state=?,active_flag=?,last_modified_datetime=? where address_details_id =?";
	
	
	public static final String USER_DTLS_SQL = "SELECT user_details_id FROM user_details_tbl ae " + "WHERE user_id = ?";
	public static final String UPDATE_USER_DTLS ="UPDATE user_details_tbl set user_id=?,email=?,phone=?,active_flag=?,last_modified_datetime=? where user_details_id =?";
	
	public static final String SELECT_USER_SQL = "SELECT user_id FROM user_tbl e " + "WHERE user_id = ?";
	public static final String UPDATE_USER_SQL = "UPDATE user_tbl set first_name=?, last_name=?,middle_name=?, active_flag=?,last_modified_datetime=? where user_id =?";
	
	public static final String CREATE_USER_LOGIN_SQL = "UPDATE user_login_info_tbl set active_flag=?,last_modified_datetime=? where user_id =?";
	
	public static final String CUSTOMER_LOGIN_SQL = "UPDATE customer_details_tbl set active_flag=?,last_modified_datetime=? where customer_id =?";
	
	public static final String CREATE_CUSTOMER_DETAILS_SQL = "INSERT INTO customer_details_tbl(customer_dob,user_id,active_flag,last_modified_datetime,customer_id_num) VALUES (?,?,?,?,?)";
	
	public static final String CREATE_USERDETAILS_SQL = "INSERT INTO user_details_tbl(user_id, email, phone,fax, address_details_id, active_flag, last_modified_datetime) VALUES (?,?,?,?,?,?,?)";
	public static final String USERDETAILS_SQL = "SELECT user_id, address_details_id, user_details_id FROM user_details_tbl e " + "WHERE user_details_id = ?";
	
	public static final String CREATE_USERLOGIN_SQL = "INSERT INTO user_login_info_tbl(user_id, role_id,username, password,active_flag,last_modified_datetime) VALUES (?,?,?,?,?,?)";
	public static final String USER_LOGIN_SQL = "SELECT user_id, user_login_id,role_id,username FROM user_login_info_tbl e " + "WHERE user_login_id = ?";
	
	public static final String CREATE_ADDRDTL_SQL = "INSERT INTO address_details_tbl(building_name, street_name,city, state,active_flag,last_modified_datetime) VALUES (?, ?, ?,?,?,?)";
	public static final String USERADDR_SQL = "SELECT address_details_id FROM address_details_tbl ae " + "WHERE address_details_id = ?";
}