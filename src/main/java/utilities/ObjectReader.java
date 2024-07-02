package utilities;

import java.io.FileInputStream;
<<<<<<< HEAD
=======
import java.io.IOException;
>>>>>>> 1ce446e8a820358e076a7a4103cbf40b03a8b707
import java.util.Properties;

public class ObjectReader {
	private static Properties pro;

	public static Properties readObjects(){
		if (pro == null) {
			pro = new Properties();
			try {
				System.out.println("read");
				FileInputStream reader = new FileInputStream(System.getProperty("user.dir")
						+ "\\src\\test\\resources\\objectrepo\\object.properties");
				pro.load(reader);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return pro;

	}
	
	public static String getPhone()
	{
	  return pro.getProperty("phone");
	}
	public static String getEmail()
	{
	  return pro.getProperty("email");
	
	}
	
	public static String emptyCartMsg() {
		return pro.getProperty("emptycartmsg");
	}
	
	public static String searchQuery() {
		return pro.getProperty("searchquery");
	}

	public static String getCoupon() {
		return pro.getProperty("coupon");
	}

	public static String getPinCode() {
		return pro.getProperty("pincode");
	}

	public static CharSequence getAmount() {
		return pro.getProperty("amount");
	}

	public static CharSequence getPharmacyValidate() {
		return pro.getProperty("pharmacyvalidate");
	}

	public static String getRefererEmail() {
		return pro.getProperty("refereremail");
	}
	
	public static String getRefererName() {
		return pro.getProperty("referername");
	}

	public static String getTrackingId() {
		return pro.getProperty("trackingid");
	}

	public static String getInvalidQuery() {
		return pro.getProperty("invalidquery");
	}

	public static String getInvalidResultMsg() {
		return pro.getProperty("invalidsearch");
	}

	public static String buyOneQuery() {
		return pro.getProperty("buyone");
	}

	public static String buy1Assertion() {
		return pro.getProperty("buyoneassertion");
	}

	public static String contactEmail() {
		return pro.getProperty("contactemail");
	}
}

	
