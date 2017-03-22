package com.test;

import org.apache.jmeter.engine.StandardJMeterEngine;
import org.apache.jmeter.save.SaveService;
import org.apache.jmeter.util.JMeterUtils;
import org.apache.jorphan.collections.HashTree;
import java.io.FileInputStream;
import org.junit.Assert;
import org.junit.Test;

public class CloudJMeterPerfomanceTest {

    
	public CloudJMeterPerfomanceTest(){
		
			JMeterUtils.setJMeterHome("/root/apache-jmeter-3.1");
			//JMeterUtils.loadJMeterProperties("/root/apache-jmeter-3.1/bin/jmeter.properties");
		        JMeterUtils.loadJMeterProperties("/var/lib/jenkins/workspace/App_Exec_CloudTesting/jmeter.properties");
			
			
			JMeterUtils.initLogging();// you can comment this line out to see extra log messages of i.e. DEBUG level
			JMeterUtils.initLocale();
		
	}
	
	
	@Test
    public void test() {
		
		
		try{
		       StandardJMeterEngine jmeter = new StandardJMeterEngine();

			// Initialize Properties, logging, locale, etc.
			
			//JMeterUtils.setJMeterHome("/root/apache-jmeter-3.1");
			//JMeterUtils.loadJMeterProperties("/root/apache-jmeter-3.1/bin/jmeter.properties");
			
			
			//JMeterUtils.initLogging();// you can comment this line out to see extra log messages of i.e. DEBUG level
			//JMeterUtils.initLocale();

			// Initialize JMeter SaveService
			SaveService.loadProperties();

			// Load existing .jmx Test Plan
			FileInputStream in = new FileInputStream("/root/apache-jmeter-3.1/bin/PizzaOrder.jmx");
			HashTree testPlanTree = SaveService.loadTree(in);
			in.close();

			// Run JMeter Test
			
			System.out.println("testPlanTree::::"+testPlanTree);
			jmeter.configure(testPlanTree);
			System.out.println("JMeter Test Run Start...");
			jmeter.run(); 
		}catch(Exception ex){
			System.out.println("Exception in JMeter Test::-"+ex.getMessage());
			ex.printStackTrace();
		}  



	   }



         
	   
	   
	     

							
							
	}
	
	


