package TestClass;

import ClassProvider.IPrintable; 

 
public class ClassForTest2 implements IPrintable{ 
	
	@Override public void printName() {
		
		System.out.println(this.getClass().getName());
		
		} 
 } 

