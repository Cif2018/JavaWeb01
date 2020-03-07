package com.test;

import java.util.ArrayList;

public class CheckCredentials {

	public static void main(String[] args) throws ClassNotFoundException {
		// TODO Auto-generated method stub
		
		CheckCredentials cc=new CheckCredentials();
		
		System.out.println(cc.confirm("admin", "adminpass"));
		
	}

	public static boolean confirm(String name, String passwd) throws ClassNotFoundException {
		
		String[] theTableColumns = new String[2];
		theTableColumns[0] = "user";
		theTableColumns[1] = "password";
		
		ReadDataFromDB rdfdb=new ReadDataFromDB();
		ArrayList<String[]> upAL=rdfdb.read(
				Login.pathLocation, "usersDB",
				"usersAndPasswords", theTableColumns);
		
		try {
			for (String[] up:upAL) {
				if (name.equals(up[0]) && passwd.equals(up[1])) {
					return true;
				}
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		

		return false;

//		try {
//			if (name.equals("admin") && passwd.equals("adminpass")) {
//				return true;
//			}
//			if (name.equals("cip") && passwd.equals("cippass")) {
//				return true;
//			} else {
//				return false;
//			}
//		} catch (Exception e) {
//			// TODO: handle exception
//			return false;
//		}

	}
}
