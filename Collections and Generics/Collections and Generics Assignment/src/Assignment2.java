import java.util.HashMap;
import java.util.Map;
import java.util.LinkedHashMap;
import static java.util.stream.Collectors.*;
import java.util.Comparator;
import static java.util.Map.Entry.*;

public class Assignment2 {

	public static void main(String[] args) {
		 String[] input = {"abc","xyz","pqr","xyz","pqr","pqr"};
		 Map<String, Integer> map = new HashMap<String, Integer>();
		 for(int i=0; i<input.length; i++)
		 {
			 if (map.get(input[i]) != null) {
				 map.put(input[i], map.get(input[i]) + 1);
			 }
			 else {
				 map.put(input[i], 1);
			 }
		 }		 
		 map = map.entrySet().stream().sorted(comparingByValue(Comparator.reverseOrder())).collect(toMap(e -> e.getKey(), e -> e.getValue(), (e1, e2) -> e2,LinkedHashMap::new));
		 System.out.println(map.keySet());
	}
}
