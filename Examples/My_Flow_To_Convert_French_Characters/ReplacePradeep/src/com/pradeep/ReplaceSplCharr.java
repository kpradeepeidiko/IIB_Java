package com.pradeep;

public class ReplaceSplCharr {

	public static String replaceChar(String ss)
	{
		String s = ss;
		
		String d[] = {"*","&","!","@","#","$","^","%","(",")","å","â","ã","ä","å","æ","ç","è","é","ê","ë","ì","í","î","ï","ð","ñ","ò","ó","ô","õ","ö","ø","ù","ú","û","ü","ý","þ","ÿ","à","À","Â","Ä","Æ","Ç","È","É"};
		String i[] = {"8","7","4","3","9","5","2","6","9","0","a","a","a","a","a","a","c","e","e","e","e","i","i","i","i","o","n","o","o","o","o","o","o","u","u","u","u","y","p","y","a","A","A","A","AE","C","E","E"};
	
		int length = d.length;
		//System.out.println(length);
		int j = 0;
	
		//String newString = "";
		while(j < length)
		{
			
			
			//Pattern p = Pattern.compile("[^a-z0-9 </>]", Pattern.CASE_INSENSITIVE);
			//Matcher m = p.matcher(s);
			String currChar = d[j];
			String newValue = i[j];
			if(s.contains(currChar))
			{
				 s = s.replace(currChar,newValue);
				//System.out.println("replaced String is "+newString);
			}
			j = j + 1;
			//s = newString;
		}
		
		s=s.replace("4[CDATA", "![CDATA");
	return s;
	}
}
