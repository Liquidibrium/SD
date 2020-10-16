import java.util.HashSet;
public class NotContains{

       public static int notContains(int[] array) {
		HashSet<Integer> inArray= new HashSet<>();
		   for (int num : array) {
			   if (num > 0) {
				   inArray.add(num);
			   }
		   }
		int num=1;
		int max=Integer.MAX_VALUE;
		while(num<=max && num>0) { // only while(num>0)
			if(!inArray.contains(num)) {
				return num;
			}
			num++;
		}
		return -1;
	}

}