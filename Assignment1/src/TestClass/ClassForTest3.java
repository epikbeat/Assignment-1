package TestClass;

import ClassProvider.IPrintable; 

 
public class ClassForTest3 implements IPrintable{ 
	
	@Override public void printName() {
		
		System.out.println(this.getClass().getName());
		
		} 
 } 

