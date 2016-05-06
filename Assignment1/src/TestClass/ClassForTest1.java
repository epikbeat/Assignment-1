package TestClass;

import ClassProvider.IPrintable; 

 
public class ClassForTest1 implements IPrintable{ 
	
	@Override public void printName() {
		
		System.out.println(this.getClass().getName());
		
		} 
 } 

