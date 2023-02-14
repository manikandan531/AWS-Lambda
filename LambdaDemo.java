package Lambda;

import java.util.ArrayList;
import java.util.List;

public class LambdaDemo 
{
	public static void main(String[] args) 
	{
	List<String> nameList = new ArrayList<>();
	
	nameList.add("mani");
	nameList.add("naveen");
	nameList.add("ragu");
	nameList.add("abi");
	
	//printName(NameList);
	
	nameList.forEach((name) -> System.out.println(name));
	
	}
	
	/*
	 * public static void printName(List<String> nameList) { for(int i=0;i<
	 * nameList.size();i++) { System.out.println(nameList.get(i)); } }
	 */
}