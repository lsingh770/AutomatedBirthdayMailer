package com.java.main;

import java.io.FileInputStream;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.Properties;
import java.util.Random;

public class User {


	public static Object[][] getDetails(){

		//LocalDateTime now = LocalDateTime.now();  
		//System.out.println(now.getMonth()+"  "+ now.getDayOfMonth());
		Date date = new Date();
		//Log.info("Date: "+date);
		
		String currentMONTH = new SimpleDateFormat("MMM").format(date).toUpperCase();
		String currentDAY = new SimpleDateFormat("dd").format(date).replaceAll("^0", ""); System.out.println("Date: " +currentMONTH+": "+currentDAY);
		return ExtentI.columnbasedfilter(System.getProperty("user.dir")+loadProperties().getProperty("File_Path"), "Users", new String[]{"MONTH","DAY"},
				new String[]{currentMONTH,currentDAY}, "FIRST_NAME","EMAIL_ID","DAY");
	
	}
	
	public static Properties loadProperties(){
		Properties prop = new Properties();
		try {
			FileInputStream inputStr = new FileInputStream(System.getProperty("user.dir")+"/com/java/resources/config/constants.properties");
			prop.load(inputStr);
		} catch (Exception e) {
			System.out.println("Error while loading Properties File: ");
			System.out.println(e);
		}
		return prop;
	}
	
	public static void main(String[] args){
		
		Object[][] b= getDetails();
		Properties p = loadProperties();
		
		if(b.length!=0){
			for(int i=0;i<b.length;i++){
				Log.info("People found to wish Birthday, now sending mail.");

				String bodyText="<font face=\"Times New Roman\" size=\"5\" color=\"#2A0EDF\">Dear "+ b[i][0]+",<br><br>"
						+ "<p>"+p.getProperty("MSG_"+new Random().nextInt(6))
						+ "<br>"
						+ "<center><b><font color=\"#157A05\">Happy Birthday</font><font color=\"orange\">&#128578;&#128578;</font></b> .</center></p><br>"
						+ "<img src=\"cid:image\" alt=\"birthday wish image\">"
						+ "<br><br>"
						+ "Regards<br>PVG & CMTeam</font>";
				Log.info("Mail body"+bodyText);
				new SendMail().sendMail(b[i][1].toString(),"Birthday Wishes to "+b[i][0],bodyText);
				}}
		else Log.info("Ooops! There is no one to wish birthday today.");
	}
	
}
