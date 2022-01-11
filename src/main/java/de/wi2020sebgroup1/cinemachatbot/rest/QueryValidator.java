package de.wi2020sebgroup1.cinemachatbot.rest;

import java.util.ArrayList;

import org.apache.commons.validator.GenericValidator;

public class QueryValidator {
	
	public static ArrayList<Month> months = new ArrayList<>();
	
	public static boolean isNumeric(String s) {
		return s.matches("[+-]?\\d*(\\.\\d+)?");
	}
	
	public static String transformDate(String s) {
		
		String date = new String(s);

		months.add(new Month("Januar", "01"));
		months.add(new Month("January", "01"));
		months.add(new Month("Februar", "02"));
		months.add(new Month("February", "02"));
		months.add(new Month("März", "03"));
		months.add(new Month("Maerz", "03"));
		months.add(new Month("March", "03"));
		months.add(new Month("April", "04"));
		months.add(new Month("Mai", "05"));
		months.add(new Month("May", "05"));
		months.add(new Month("Juni", "06"));
		months.add(new Month("Juno", "06"));
		months.add(new Month("June", "06"));
		months.add(new Month("Juli", "07"));
		months.add(new Month("July", "07"));
		months.add(new Month("August", "08"));
		months.add(new Month("September", "09"));
		months.add(new Month("Oktober", "10"));
		months.add(new Month("October", "10"));
		months.add(new Month("November", "11"));
		months.add(new Month("Dezember", "12"));
		months.add(new Month("December", "12"));
		months.add(new Month("januar", "01"));
		months.add(new Month("january", "01"));
		months.add(new Month("februar", "02"));
		months.add(new Month("february", "02"));
		months.add(new Month("märz", "03"));
		months.add(new Month("maerz", "03"));
		months.add(new Month("march", "03"));
		months.add(new Month("april", "04"));
		months.add(new Month("mai", "05"));
		months.add(new Month("may", "05"));
		months.add(new Month("juni", "06"));
		months.add(new Month("juno", "06"));
		months.add(new Month("june", "06"));
		months.add(new Month("juli", "07"));
		months.add(new Month("july", "07"));
		months.add(new Month("august", "08"));
		months.add(new Month("september", "09"));
		months.add(new Month("oktober", "10"));
		months.add(new Month("october", "10"));
		months.add(new Month("november", "11"));
		months.add(new Month("dezember", "12"));
		months.add(new Month("december", "12"));
		
		date = date.trim();
		
		for(Month m : months) {
			date = date.replace(m.getName(), m.getNr());
		}

		date = date.replace(". ", "-");
		date = date.replace(".  ", "-");
		date = date.replace(".   ", "-");
		date = date.replace(" ", "-");
		date = date.replace("  ", "-");
		date = date.replace("   ", "-");
		date = date.replace("/", "-");
		date = date.replace("\\", "-");
		date = date.replace("st", "");
		date = date.replace("nd", "");
		date = date.replace("rd", "");
		date = date.replace("th", "");
		
		return date;
		
	}
	
	public static boolean isDate(String s) {
		
		String date = new String(s);
		date = transformDate(date);
		
		if(isAmericanDate(date) || isEuropeanDate(date) || isAsianDate(date))
			return true;
		
		return false;
	}
	
	private static boolean isAsianDate(String s) {
		return GenericValidator.isDate(s, "yyyy-MM-dd", false) || isAsianDateNoYear(s);
	}
	
	private static boolean isEuropeanDate(String s) {
		return GenericValidator.isDate(s, "dd-MM-yyyy", false) || isEuropeanDateNoYear(s);
	}
	
	private static boolean isAmericanDate(String s) {
		return GenericValidator.isDate(s, "MM-dd-yyyy", false);
	}
	
	private static boolean isAsianDateNoYear(String s) {
		return GenericValidator.isDate(s, "MM-dd", false);
	}
	
	private static boolean isEuropeanDateNoYear(String s) {
		return GenericValidator.isDate(s, "dd-MM", false);
	}
	
	public static boolean isEmail(String s) {
		return GenericValidator.isEmail(s);
	}
	
	public static boolean contains(String query, String... compare) {
		
		boolean contains = false;
		
		for(String s : compare) {
			
			if(query.toLowerCase().contains(s.toLowerCase()))
				contains = true;
			
		}
		
		return contains;
		
	}
	
	public static double similarity(String s1, String s2) {
		
        String longer = s1, shorter = s2;
        if (s1.length() < s2.length()) {
            longer = s2; shorter = s1;
        }
        int longerLength = longer.length();
        if (longerLength == 0)
        	return 1.0;
        return (longerLength - editDistance(longer, shorter)) / (double) longerLength;
 
    }
    	
    public static int editDistance(String s1, String s2) {
        s1 = s1.toLowerCase();
        s2 = s2.toLowerCase();
 
        int[] costs = new int[s2.length() + 1];
        for (int i = 0; i <= s1.length(); i++) {
            int lastValue = i;
            for (int j = 0; j <= s2.length(); j++) {
                if (i == 0)
                    costs[j] = j;
                else {
                    if (j > 0) {
                        int newValue = costs[j - 1];
                        if (s1.charAt(i - 1) != s2.charAt(j - 1))
                            newValue = Math.min(Math.min(newValue, lastValue),
                                    costs[j]) + 1;
                        costs[j - 1] = lastValue;
                        lastValue = newValue;
                    }
                }
            }
            if (i > 0)
                costs[s2.length()] = lastValue;
        }
        return costs[s2.length()];
    }
    
    public static boolean somewhereRoughlyContains(String query, String compare) {
    	int poss = query.length() - compare.length() + 1;
    	boolean contains = false;
    	for(int i = 0; i<poss; i++) {
    		String s = query.substring(i, i+compare.length());
    		if(similarity(s, compare) > 0.7) 
    			contains = true;
    	}
    	return contains;
    }
	
}
