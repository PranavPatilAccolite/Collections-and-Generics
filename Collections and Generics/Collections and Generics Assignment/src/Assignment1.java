import java.util.Map;
import java.util.TreeMap;

public class Assignment1 {
	public static void main(String[] args) {
		Map<Character, Integer> map = new TreeMap<Character, Integer>();
		String s = "Hello, my dear friend. How are you?";
		s = s.toUpperCase();
		for (int i = 0; i < s.length(); i++) {
		    if (s.charAt(i) > 64 && s.charAt(i) < 91){
			    if (map.get(s.charAt(i)) != null) {
			        map.put(s.charAt(i), map.get(s.charAt(i)) + 1);
			    }
			    else {
			    	map.put(s.charAt(i), 1);
			   }
		    }
		}
		for (Character key:map.keySet()){
			System.out.print(key+ "\t");
			for(int i=0; i<map.get(key); i++){
				System.out.print("#");
			}
			System.out.println();
		}
	}
}
