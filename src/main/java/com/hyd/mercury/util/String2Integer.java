package com.hyd.mercury.util;

import java.util.regex.Pattern;

public class String2Integer {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
	}
	
	
	public static boolean isNumber(String string) {
        if (string == null)
            return false;
        Pattern pattern = Pattern.compile("^-?\\d+(\\.\\d+)?$");
        return pattern.matcher(string).matches();
    }

}
