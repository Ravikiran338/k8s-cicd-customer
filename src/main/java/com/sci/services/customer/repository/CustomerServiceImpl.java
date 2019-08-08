/**
 * @author Jaya Prakash Manne
 *
 */
package com.sci.services.customer.repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.davidmoten.rx.jdbc.Database;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.sci.services.customer.model.AddressBean;
import com.sci.services.customer.model.Customer;
import com.sci.services.customer.model.LoginInfoBean;
import com.sci.services.customer.model.Status;
import com.sci.services.customer.model.UserBean;
import com.sci.services.customer.model.UserPojo;
import com.sci.services.customerservice.constants.CustomerQueryConstants;
import com.sci.services.customerservice.constants.CustomerServiceConstants;
import com.sci.services.util.CustomerServiceUtil;
import com.sci.services.util.DatabaseUtil;

import io.reactivex.Flowable;
import io.reactivex.functions.Function;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class CustomerServiceImpl implements CustomerService {
	private static final Logger LOGGER = LoggerFactory.getLogger(CustomerServiceImpl.class);
	CustomerServiceUtil util = CustomerServiceUtil.getInstance();

	// =========================================================================

	/*
	 * public CustomerServiceImpl() throws Exception {
	 * DriverManager.registerDriver(new com.mysql.jdbc.Driver()); Connection
	 * connection = DriverManager.getConnection(
	 * "jdbc:mysql://182.74.133.92:3306/micro_banking_dev?user=sciitdev&password=welcome@1"
	 * ); NonBlockingConnectionPool pool =
	 * Pools.nonBlocking().maxPoolSize(Runtime.getRuntime().availableProcessors() *
	 * 5).connectionProvider(ConnectionProvider.from(connection)).build(); this.db =
	 * Database.from(pool); }
	 */

	// =========================================================================
	
	public Flux<Customer> getAll() {
		/* select customer.CUSTOMER_ID, customer.USER_ID, customer.ACTIVE_FLAG,
		 * customer.CUSTOMER_ID_NUM, user.FIRST_NAME, user.MIDDLE_NAME,
		 * user.LAST_NAME, userDetails.EMAIL, userDetails.PHONE,
		 * userLoginInfo.ROLE_ID, address.BUILDING_NAME, address.STREET_NAME,
		 * address.CITY, address.STATE from customer_details_tbl as customer,
		 * user_details_tbl as userDetails, user_login_info_tbl as
		 * userLoginInfo, user_tbl as user, address_details_tbl as address where
		 * customer.USER_ID = userDetails.USER_ID and customer.USER_ID =
		 * user.USER_ID and customer.USER_ID = userLoginInfo.USER_ID and
		 * userDetails.ADDRESS_DETAILS_ID = address.ADDRESS_DETAILS_ID
		 */
		/*
		 * StringBuffer getAllCustomersSQL = new
		 * StringBuffer("select customer.CUSTOMER_ID, customer.USER_ID, customer.ACTIVE_FLAG, customer.CUSTOMER_ID_NUM,customer.CUSTOMER_DOB,"
		 * ); getAllCustomersSQL.
		 * append(" user.FIRST_NAME, user.MIDDLE_NAME, user.LAST_NAME, userDetails.EMAIL, userDetails.PHONE,"
		 * ); getAllCustomersSQL.
		 * append(" userLoginInfo.ROLE_ID, userLoginInfo.USERNAME, userLoginInfo.PASSWORD ,address.BUILDING_NAME,address.STREET_NAME, address.CITY, address.STATE"
		 * ); getAllCustomersSQL.
		 * append(" from customer_details_tbl as customer, user_details_tbl as userDetails,  "
		 * ); getAllCustomersSQL.
		 * append(" user_login_info_tbl as userLoginInfo, user_tbl as user, address_details_tbl as address"
		 * );
		 * getAllCustomersSQL.append(" where customer.USER_ID = userDetails.USER_ID");
		 * getAllCustomersSQL.append(" and customer.USER_ID = user.USER_ID");
		 * getAllCustomersSQL.append(" and customer.USER_ID = userLoginInfo.USER_ID");
		 * getAllCustomersSQL.
		 * append(" and userDetails.ADDRESS_DETAILS_ID = address.ADDRESS_DETAILS_ID");
		 */
		
		Database db = DatabaseUtil.getInstance().getDatabase();
		Flowable<Customer> customerFlowable = db.select(CustomerQueryConstants.GET_ALL_CUSTOMERS).get(rs -> {
			Customer customer = new Customer();
			customer.setCustomerId(rs.getInt("CUSTOMER_ID"));
			customer.setUserId(rs.getInt("USER_ID"));
			customer.setUserId(rs.getInt("USER_ID"));
			customer.setActiveFlag(rs.getString("ACTIVE_FLAG"));
			customer.setCustomerIdNum(rs.getString("CUSTOMER_ID_NUM"));
			customer.setFirstName(rs.getString("FIRST_NAME"));
			customer.setMiddleName(rs.getString("MIDDLE_NAME"));
			customer.setLastName(rs.getString("LAST_NAME"));
			customer.setEmail(rs.getString("EMAIL"));
			customer.setPhone(rs.getString("PHONE"));
			customer.setRoleId(rs.getInt("ROLE_ID"));
			customer.setCustomerDob(rs.getDate("CUSTOMER_DOB"));
			
			LoginInfoBean userbean  = new LoginInfoBean();
			userbean.setUsername(rs.getString("USERNAME"));
			userbean.setPassword(rs.getString("PASSWORD"));
			customer.setUserLoginInfo(userbean);
			
			AddressBean address = new AddressBean();
			address.setBuildingName(rs.getString("BUILDING_NAME"));
			address.setStreet(rs.getString("STREET_NAME"));
			address.setCity(rs.getString("CITY"));
			address.setState(rs.getString("STATE"));
			address.setActiveFlag(rs.getString("ACTIVE_FLAG"));
			customer.setAddress(address);
			return customer;
		});
		return Flux.from(customerFlowable);
	}

	// =========================================================================
	
	@Override
	public Flux<Customer> getCustomer(Integer customerId) {
		/* select customer.CUSTOMER_ID, customer.USER_ID, customer.ACTIVE_FLAG,
		 * customer.CUSTOMER_ID_NUM, user.FIRST_NAME, user.MIDDLE_NAME,
		 * user.LAST_NAME, userDetails.EMAIL, userDetails.PHONE,
		 * userLoginInfo.ROLE_ID, address.BUILDING_NAME, address.STREET_NAME,
		 * address.CITY, address.STATE from customer_details_tbl as customer,
		 * user_details_tbl as userDetails, user_login_info_tbl as
		 * userLoginInfo, user_tbl as user, address_details_tbl as address where
		 * customer.USER_ID = userDetails.USER_ID and customer.USER_ID =
		 * user.USER_ID and customer.USER_ID = userLoginInfo.USER_ID and
		 * userDetails.ADDRESS_DETAILS_ID = address.ADDRESS_DETAILS_ID
		 * and customer.CUSTOMER_ID = 12
		 */
		/*
		 * StringBuffer getAllCustomersSQL = new
		 * StringBuffer("select customer.CUSTOMER_ID, customer.USER_ID, customer.ACTIVE_FLAG, customer.CUSTOMER_ID_NUM,"
		 * ); getAllCustomersSQL.
		 * append(" user.FIRST_NAME, user.MIDDLE_NAME, user.LAST_NAME, userDetails.EMAIL, userDetails.PHONE,"
		 * ); getAllCustomersSQL.
		 * append(" userLoginInfo.ROLE_ID, address.BUILDING_NAME, address.STREET_NAME, address.CITY, address.STATE "
		 * ); getAllCustomersSQL.
		 * append(" from customer_details_tbl as customer, user_details_tbl as userDetails,"
		 * ); getAllCustomersSQL.
		 * append(" user_login_info_tbl as userLoginInfo, user_tbl as user, address_details_tbl as address"
		 * );
		 * getAllCustomersSQL.append(" where customer.USER_ID = userDetails.USER_ID");
		 * getAllCustomersSQL.append(" and customer.USER_ID = user.USER_ID");
		 * getAllCustomersSQL.append(" and customer.USER_ID = userLoginInfo.USER_ID");
		 * getAllCustomersSQL.
		 * append(" and userDetails.ADDRESS_DETAILS_ID = address.ADDRESS_DETAILS_ID");
		 * getAllCustomersSQL.append(" and customer.CUSTOMER_ID = "+customerId);
		 */
		Database db = DatabaseUtil.getInstance().getDatabase();
		Flowable<Customer> customerFlowable = db.select(CustomerQueryConstants.GET_CUSTOMER_ID+customerId).get(rs -> {
			Customer customer = new Customer();
			customer.setCustomerId(rs.getInt("CUSTOMER_ID"));
			customer.setUserId(rs.getInt("USER_ID"));
			customer.setActiveFlag(rs.getString("ACTIVE_FLAG"));
			customer.setCustomerIdNum(rs.getString("CUSTOMER_ID_NUM"));
			customer.setFirstName(rs.getString("FIRST_NAME"));
			customer.setMiddleName(rs.getString("MIDDLE_NAME"));
			customer.setLastName(rs.getString("LAST_NAME"));
			customer.setEmail(rs.getString("EMAIL"));
			customer.setPhone(rs.getString("PHONE"));
			customer.setRoleId(rs.getInt("ROLE_ID"));
			
			AddressBean addressBean = new AddressBean();
			addressBean.setBuildingName(rs.getString("BUILDING_NAME"));
			addressBean.setStreet(rs.getString("STREET_NAME"));
			addressBean.setBuildingName(rs.getString("BUILDING_NAME"));
			addressBean.setCity(rs.getString("CITY"));
			addressBean.setState(rs.getString("STATE"));
			customer.setAddress(addressBean);
			
			return customer;
		});
		return Flux.from(customerFlowable);
	}

	// =========================================================================
	
	public Mono<Status> createCustomer(Mono<UserBean> monoUser) {
		Database db = DatabaseUtil.getInstance().getDatabase();
		LOGGER.info("START of the method : createCustomer, ");
		Mono<UserPojo> newMonoUser = createUserInfo(monoUser);
		Mono<UserPojo> newAddressUser = executeAddressMono(newMonoUser);
		Mono<UserPojo> newMonoLoginUser = executeUserLoginMono(newAddressUser);
		Mono<UserPojo> newMonoUserDetails = executeUserDetailsMono(newMonoLoginUser);
		return executeCustomerDetailsMono (newMonoUserDetails, db);
	}

	// =========================================================================
	
	private Mono<UserPojo> createUserInfo(Mono<UserBean> monoUser) {
		Database db = DatabaseUtil.getInstance().getDatabase();
		Mono<UserPojo> newMonoUser = monoUser.flatMap(newUser -> {
			Flowable<Integer> userId = db.update(CustomerQueryConstants.CREATE_SQL)
				.parameters(newUser.getFirstName(), newUser.getLastName(), newUser.getMiddleName(),CustomerServiceConstants.YES, new Date())
				.returnGeneratedKeys().getAs(Integer.class);
			Flowable<UserPojo> userFlowable = db.select(CustomerQueryConstants.SELECT_SQL).parameterStream(userId).get(rs -> {
				return prepareUserPojo(newUser, rs);
			});
			return Mono.from(userFlowable);
		});
		return newMonoUser;
	}

	//=========================================================================
	
	private Mono<UserPojo> executeAddressMono(Mono<UserPojo> newMonoUser) {
		Database db = DatabaseUtil.getInstance().getDatabase();
		
		Mono<UserPojo> newAddressUser = newMonoUser.flatMap(user -> {
			Flowable<Integer> userAddrId = db.update(CustomerQueryConstants.CREATE_ADDRDTL_SQL)
	        	.parameters(user.getAddress().getBuildingName(),
		     	user.getAddress().getStreet(), user.getAddress().getCity(),
			    user.getAddress().getState(), CustomerServiceConstants.YES,new Date())
	            .returnGeneratedKeys().getAs(Integer.class);
			Flowable<UserPojo> userLoginFlowable = db.select(CustomerQueryConstants.USERADDR_SQL).parameterStream(userAddrId).get(rs -> {
				user.setAddressId(rs.getString("address_details_id"));
				return user;
			});
			return Mono.from(userLoginFlowable);
		});
		return newAddressUser;
	}
	
	//=========================================================================
	
	private Mono<UserPojo> executeUserLoginMono(Mono<UserPojo> newAddressUser) {
		Database db = DatabaseUtil.getInstance().getDatabase();
		
		Mono<UserPojo> newMonoLoginUser = newAddressUser.flatMap(user -> {
			Flowable<Integer> userLoginId = db.update(CustomerQueryConstants.CREATE_USERLOGIN_SQL).parameters(user.getUserId(), user.getRoleId(),
				user.getUsername(), user.getPassword(), CustomerServiceConstants.YES, new Date())
				.returnGeneratedKeys().getAs(Integer.class);
			Flowable<UserPojo> userLoginFlowable = db.select(CustomerQueryConstants.USER_LOGIN_SQL).parameterStream(userLoginId).get(rs -> {
				return user;
			});
			return Mono.from(userLoginFlowable);
		});
		return newMonoLoginUser;
	}

	//=========================================================================
	
	private Mono<UserPojo> executeUserDetailsMono(Mono<UserPojo> newMonoUser) {
		Database db = DatabaseUtil.getInstance().getDatabase();
		
		Mono<UserPojo> newMonoDetailsUser = newMonoUser.flatMap(user -> {
			Flowable<Integer> userDetailsId = db.update(CustomerQueryConstants.CREATE_USERDETAILS_SQL).parameters(user.getUserId(), user.getEmail(), user.getPhone(),user.getFax(), user.getAddressId(),"Y", new Date())
				.returnGeneratedKeys().getAs(Integer.class);
			Flowable<UserPojo> userDetailsFlowable = db.select(CustomerQueryConstants.USERDETAILS_SQL).parameterStream(userDetailsId).get(rs -> {
				return user;
			});
			return Mono.from(userDetailsFlowable);
		});
		return newMonoDetailsUser;
	}

	//=========================================================================
	
	private Mono<Status> executeCustomerDetailsMono(Mono<UserPojo> newMonoLoginUser,Database db) {
				
		Mono<Status> newMonoUserDtls = newMonoLoginUser.flatMap(customer -> {
			DateFormat dateFormat = new SimpleDateFormat("DD/MM/YYYY");
			Flowable<Integer> customerId = null;
			try {
				customerId = db.update(CustomerQueryConstants.CREATE_CUSTOMER_DETAILS_SQL).parameters(customer.getCustomerDOB(), customer.getUserId(), CustomerServiceConstants.YES, new Date(), customer.getCustomerIdNumber()).counts();
				
			} catch (Exception e) {
				e.printStackTrace();
			}
			Flowable<Status> result = customerId.map(new Function<Integer,Status>() {
				@Override
				public Status apply(Integer count) throws Exception {
					Status status = null;
					if (count > 0) {
						status = util.prepareStatus("00",CustomerServiceConstants.SUCCESS) ;
					} else{
						status = util.prepareStatus("99",CustomerServiceConstants.FAILED) ;
					}
					return status;
				}
            });
			return Mono.from(result);
		});
		return newMonoUserDtls;
	}

	//=========================================================================
	
	private UserPojo prepareUserPojo(UserBean newUser, ResultSet rs) throws SQLException {
		LOGGER.info("START of the method : prepareUserPojo");
		UserPojo user = new UserPojo();
		user.setUserId(rs.getString("user_id"));
		user.setFirstName(rs.getString("first_name"));
		user.setLastName(rs.getString("last_name"));
		user.setMiddleName(rs.getString("middle_name"));
		user.setActiveFlag(rs.getString("active_flag"));
		user.setLastModified(rs.getString("last_modified_datetime"));
		  user.setUsername(newUser.getUsername());
		  user.setPassword(newUser.getPassword());
		user.setPhone(newUser.getPhone());
		user.setEmail(newUser.getEmail());
		user.setFax(newUser.getFax());
		user.setRoleId(newUser.getRoleId());
		user.setAddress(newUser.getAddress());
		user.setCustomerActiveFlag(newUser.getCustomerActiveFlag());
		user.setCustomerDOB(newUser.getCustomerDob());
		user.setCustomerIdNumber(newUser.getCustomerIdNum());
		return user;
	}
	
	//=========================================================================

	
	public Mono<Status> deactivateCustomer(Mono<UserBean> monoCustUserBean) {
		Mono<Integer> customerDeactivateCount = deactivateCustomerDetails(monoCustUserBean);
		Mono<Integer> userDeactivateCount = deactivateUserDetails(monoCustUserBean);
		Flowable<Status> result = Flowable.zip(customerDeactivateCount, userDeactivateCount, (customerDCount, userDCount) -> {
			Status status = new Status();
			if (customerDCount > 0 && userDCount > 0) {
				status = util.prepareStatus("00", CustomerServiceConstants.SUCCESS) ;
			} else{
				status = util.prepareStatus("99", CustomerServiceConstants.FAILED) ;
			}
			return status;
		});
		return Mono.from(result);
	}
	
	//=========================================================================
	
	private Mono<Integer> deactivateCustomerDetails(Mono<UserBean> monoCustUserBean) {
		Database db = DatabaseUtil.getInstance().getDatabase();
		Mono<Integer> loginInfoCount = monoCustUserBean.flatMap(userBean -> {
			Flowable<Integer> updatedCount = db.update(CustomerQueryConstants.CUSTOMER_LOGIN_SQL)
				.parameters(CustomerServiceConstants.NO, new Date(), userBean.getCustomerId()).counts();
			return Mono.from(updatedCount);
		});
		return loginInfoCount;
	}

	//=========================================================================
	
	private Mono<Integer> deactivateUserDetails(Mono<UserBean> monoCustUserBean) {
		Database db = DatabaseUtil.getInstance().getDatabase();
		
		Mono<Integer> loginInfoCount = monoCustUserBean.flatMap(userBean -> {
			Flowable<Integer> updatedCount = db.update(CustomerQueryConstants.CREATE_USER_LOGIN_SQL)
				.parameters(CustomerServiceConstants.NO, new Date(), userBean.getUserId()).counts();
			return Mono.from(updatedCount);
		});
		return loginInfoCount;
	}
	
	//=========================================================================
	
	public Mono<Status> updateCustomer(Mono<UserBean> userBean){
		Mono<Integer> userCount = updateUserInfo(userBean);
		Mono<Integer> loginInfoCount = updateUserLoginInfo(userBean);
		Mono<Integer> addressCount = updateUserAddress(userBean);
		Mono<Integer> usrDtlsCount = updateUserDetails(userBean);
		Mono<Integer> custDtlsCount = updateCustomerDetails(userBean);
		
		Flowable<Status> result = Flowable.zip( loginInfoCount,  userCount , addressCount, usrDtlsCount, custDtlsCount ,(infoCount,  usrCount ,addrCount,userDtlsCount, customerDtlsCount ) -> {
			Status status = new Status();
					if (infoCount > 0 && usrCount > 0 && addrCount >0 && userDtlsCount> 0 && customerDtlsCount
															  > 0
															 ) {
				status = util.prepareStatus("00", CustomerServiceConstants.SUCCESS) ;
			} else{
				status = util.prepareStatus("99", CustomerServiceConstants.FAILED) ;
			}
			return status;
		});
		return Mono.from(result);
	}
	
	//=========================================================================
	
	private Mono<Integer> updateUserInfo(Mono<UserBean> userBean) {
		Database db = DatabaseUtil.getInstance().getDatabase();
		
		Mono<Integer> userCount = userBean.flatMap(user -> {
			Flowable<Integer> updatedCount = db.select(CustomerQueryConstants.SELECT_USER_SQL).parameter(user.getUserId()).getAs(Integer.class)
				.flatMap(userId -> db.update(CustomerQueryConstants.UPDATE_USER_SQL).parameters(user.getFirstName(), user.getLastName(), 
				user.getMiddleName(),user.getActiveFlag(), new Date(),userId).counts());
			return Mono.from(updatedCount);
		});
		return userCount;
	}
	//=========================================================================
	
	private Mono<Integer> updateUserDetails(Mono<UserBean> userBean) {
		Database db = DatabaseUtil.getInstance().getDatabase();
		
		Mono<Integer> usrDtlsCount = userBean.flatMap(loginUser -> {
			Flowable<Integer> updatedCount = db.select(CustomerQueryConstants.USER_DTLS_SQL).parameter(loginUser.getUserId()).getAs(Integer.class)
				.flatMap(userLoginId ->db.update(CustomerQueryConstants.UPDATE_USER_DTLS)
				.parameters(loginUser.getUserId(), loginUser.getEmail(), loginUser.getPhone(),loginUser.getActiveFlag(),new Date(),userLoginId).counts());
			return Mono.from(updatedCount);
		});
		return usrDtlsCount;
	}
	//=========================================================================
	
	private Mono<Integer> updateUserAddress(Mono<UserBean> userBean) {
		Database db = DatabaseUtil.getInstance().getDatabase();
		
		
		Mono<Integer> addressCount = userBean.flatMap(addressUser -> {
			Flowable<Integer> updatedCount = db.select(CustomerQueryConstants.USER_ADDR_SQL).parameter(addressUser.getUserId())
				.getAs(Integer.class)
				.flatMap(addressId -> db.update(CustomerQueryConstants.UPDATE_ADDR_SQL)
					.parameters(addressUser.getAddress().getBuildingName(),
					    addressUser.getAddress().getStreet(), addressUser.getAddress().getCity(),
					    addressUser.getAddress().getState(), addressUser.getAddress().getActiveFlag(),
					    new Date(), addressId).counts());
			return Mono.from(updatedCount);
		});
		return addressCount;
	}

	//=========================================================================
	
	private Mono<Integer> updateUserLoginInfo(Mono<UserBean> userBean) {
		Database db = DatabaseUtil.getInstance().getDatabase();
		
		Mono<Integer> loginInfoCount = userBean.flatMap(loginUser -> {
			Flowable<Integer> updatedCount = db.select(CustomerQueryConstants.SELECT_USRLOGIN_SQL).parameter(loginUser.getUserId()).getAs(Integer.class)
				.flatMap(userLoginId ->db.update(CustomerQueryConstants.UPDATE_USERLOGIN_SQL)
				.parameters(loginUser.getUserId(), 3, loginUser.getActiveFlag(), new Date(),userLoginId).counts());
			return Mono.from(updatedCount);
		});
		return loginInfoCount;
	}
	//=========================================================================
	
	private Mono<Integer> updateCustomerDetails(Mono<UserBean> userBean) {
		Database db = DatabaseUtil.getInstance().getDatabase();
		DateFormat dateFormat = new SimpleDateFormat("DD/MM/YYYY");
		Mono<Integer> customerDetailsCount = userBean.flatMap(cUser -> {
			Flowable<Integer> updatedCount = db.select(CustomerQueryConstants.SELECT_CUSTOMER_DETAILS_SQL).parameter(cUser.getUserId()).getAs(Integer.class)
				.flatMap(customerDetailsId ->db.update(CustomerQueryConstants.UPDATE_CUSTOMER_DETAILS_SQL)
				.parameters(cUser.getCustomerDob(), cUser.getCustomerActiveFlag(), new Date(), cUser.getCustomerIdNum(), customerDetailsId).counts());
			return Mono.from(updatedCount);
		});
		return customerDetailsCount;
	}
	//=========================================================================
}