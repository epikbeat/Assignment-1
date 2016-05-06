package ClassProvider;
import TestClass.*;


public class Testcase {

	public static void main(String[] args) {
		
		DynamicClassProvider.register("Trident", "M1", ClassForTest1.class.getName()); 
 		DynamicClassProvider.register("Trident", "M2", ClassForTest2.class.getName()); 
 		DynamicClassProvider.register("Trident", "M3", ClassForTest3.class.getName()); 
 		DynamicClassProvider.register("Trident", "M4", ClassForTest4.class.getName());
 		 
 		/*Test 1 
 		Normal */
 		
 		System.out.println("Normal"); 
 		{ 
 			Object object1 = DynamicClassProvider.newInstance("Trident", "M1"); 
 			if(object1 != null){
 				((IPrintable)object1).printName(); 
 			}
 		} 
 		
 		 
 		/*Test 2 
 		Cache */
 		
 		System.out.println("Cache"); 
 		{ 
 			Object object2 = DynamicClassProvider.newInstance("Trident", "M2"); 
 			if(object2 != null){
 				((IPrintable)object2).printName(); 
 			}
 			Object object3 = DynamicClassProvider.newInstance("Trident", "M2"); 
 			if(object3 != null){
 				((IPrintable)object3).printName(); 
 			}
 		} 
 		
 		 
 		/*Test 3 
 		Overwriting */
 		
 		System.out.println("Overwriting"); 
 		{ 
 			Object object4 = DynamicClassProvider.newInstance("Trident", "M3"); 
 			if(object4 != null){
 				((IPrintable)object4).printName(); 
 			}
 			DynamicClassProvider.register("Trident", "M3", ClassForTest4.class.getName());	
			Object object5 = DynamicClassProvider.newInstance("Trident", "M3"); 
 			if(object5 != null){ ((IPrintable)object5).printName(); 
 			
 			}
		} 
 		
 	} 
 } 
