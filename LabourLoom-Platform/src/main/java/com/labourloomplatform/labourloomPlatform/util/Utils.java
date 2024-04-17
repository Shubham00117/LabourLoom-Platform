package com.labourloomplatform.labourloomPlatform.util;

import com.labourloomplatform.labourloomPlatform.entity.Customer;
import com.labourloomplatform.labourloomPlatform.entity.Worker;

public class Utils {
	
	public static void checkStatus(Worker worker) {
		
		
		if(!worker.getStatus().name().equals("ACTIVE")) {
			throw new RuntimeException("Invalid worker ID");
		}
		
		
	}
	
 public static void checkStatusC(Customer customer) {
		
		
		if(!customer.getStatus().name().equals("ACTIVE")) {
			throw new RuntimeException("Invalid worker ID");
		}
		
		
	}
	

	

}
