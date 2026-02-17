package com.test.collection;

import java.util.HashSet;
import java.util.Set;
public class Exp1 {
	public static void main(String args[]) {
		Set<Integer> set = new HashSet<>();
		set.add(1234);
		for(Integer no : set) {
			System.out.println(no);
		}
	}
}
//Serialization - converting object to stream of bytes
//ByteStream
//	FileInputStream
//	FileOutputStream
//	BufferedInputStream
//	BufferedOutputStream
//CharacterStream
//	FileReader
//	FileWriter
//	BufferedWriter
	

//super classs of all classes - Object
//Exceptions - java.lang
//CGI - Sequential execution of request, creates cgi shell for each request
//Servlet - Single object created , Each request goes to that object, lifeycle - init(), service(), destroy()