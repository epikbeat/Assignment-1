package ClassProvider;
import java.util.Map;
import java.util.WeakHashMap;


public class DynamicClassProvider {
	
	static Map<Pair<String, String>, String> m_cls= new WeakHashMap<Pair<String,String>, String>();
	static Map<Pair<String,String>, Class<?>> m_cashe= new WeakHashMap<Pair<String,String>, Class<?>>();
	
	
	//각각의 정보 등록
	
	public static void register(String nick, String creator,String path){
		Pair<String, String> newPair = new Pair<String, String>(nick, creator);
		if(m_cls.put(newPair, path) != null){
			
			
			try{
				
				m_cashe.put(newPair, Class.forName(path));
				
			}catch (ClassNotFoundException e){
				e.printStackTrace();
			}
			
		
		}
					
		
	}
	
	/*별명 과 creator 입력 받고 클래스를 m_cache에서 먼저 찾는다
	캐시에 Testclass의 정보가 있는지 확인
	Testclass instance Object를 반환한다.*/
	 
	public static Object newInstance(String nick, String creator){
		
		Pair<String, String> pair = new Pair<String, String>(nick, creator);
		Object object = null;
		String classPath = null;
		Class<?> identicalClassType = null;
		
		try { 
			 			
			 			if( ((identicalClassType = m_cashe.get(pair)) != null)) { 
			 				
			 				System.out.print("found in cache : "); 			 				
			 				return (Object) identicalClassType.newInstance(); 
			 			
			 			} 
			 
			 
			 			 
			 			
			 			if((classPath = m_cls.get(pair)) != null){
			 				
			 				object = (Object) (Class.forName(classPath)).newInstance(); 
			 				System.out.print("found in class map : "); 
			 				
			 			} 
						else {
							System.out.println("Warning : not registered pair"); 
						}
			 			 
			 			 
			 			if(object != null && classPath != null){ 
			 				
			 				identicalClassType = Class.forName(classPath); 
			 				m_cashe.put(pair, identicalClassType); 
			 				
			 			} 
					} catch (InstantiationException e) {e.printStackTrace();
					} catch (IllegalAccessException e) {e.printStackTrace(); 
			  		} catch (ClassNotFoundException e) {e.printStackTrace();			 					 				  		
			  		} 
			 
			 
			 		return object;
					
 		
		
	}

}
