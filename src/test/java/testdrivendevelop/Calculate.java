package testdrivendevelop;

import java.util.ArrayList;
import java.util.List;

public class Calculate {
	
	private List<String> list;
	
	public void firstList() {
		
		list = new ArrayList<>();
		list.add("JAVA");
		list.add("C Sharp");
		list.add("Python");
		System.out.println("Original " + list);
		
		CalculateUtil cal = new CalculateUtil(list);
		cal.manipulateList();
		
		System.out.println("After " + list);
		
	}
	
	
}

class CalculateUtil{
	
	private List<String> list;
	
	public CalculateUtil(List<String> list) {
		this.list = list;
	}
	
	public void manipulateList() {
		
		System.out.println(list.get(0));
	}
	
}