package study.web.stringtest;

import org.apache.commons.lang3.StringUtils;

public class StringTest {
	public static void main(String[] args) {
		
		String s= null;
		String s1 = "";
		String s2 = "      ";
		
		System.out.println(StringUtils.isEmpty(s));//true
		System.out.println(StringUtils.isEmpty(s1));//true
		System.out.println(StringUtils.isEmpty(s2));

		System.out.println(StringUtils.isNoneEmpty(s));//false
		System.out.println(StringUtils.isNoneEmpty(s1));//false
		System.out.println(StringUtils.isNoneEmpty(s2));//true
		System.out.println("****************************");
		
		System.out.println(StringUtils.isBlank(s));//true
		System.out.println(StringUtils.isBlank(s1));//true
		System.out.println(StringUtils.isBlank(s2));//true
		
		System.out.println(StringUtils.isNoneBlank(s));//false
		System.out.println(StringUtils.isNoneBlank(s1));//false
		System.out.println(StringUtils.isNoneBlank(s2));//false
		
	}

}
