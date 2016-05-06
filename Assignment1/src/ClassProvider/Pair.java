package ClassProvider;



public class Pair<T1,T2> {	
	T1 t1;
	T2 t2;
	
	private volatile int hashCode;
	
	public Pair(T1 t1,T2 t2){
		this.t1 = t1;
		this.t2 = t2;
	}
	
	
	
	
	@Override public int hashCode() { 
	 		int result = hashCode; 
	 		 
	 		if(result == 0){ 
	 			result = 17; 
	 			result = 31 * result + t1.hashCode(); 
	 			result = 31 * result + t2.hashCode(); 
	 			
	 			hashCode = result;
	 		} 
	 		 
	 		return result; 
	 	}
	
	//equals 재정의
	
	@Override public boolean equals(Object object) { 
	 		boolean result = false; 
	 		if(object instanceof Pair){
	 			
	 			Pair<?, ?> pr = (Pair<?, ?>) object; 
	 			result = ((object instanceof Pair) &&  pr.t1.equals(t1) && pr.t2.equals(t2));
	 			
	 		} 
	 		return result; 
	 	}


}
