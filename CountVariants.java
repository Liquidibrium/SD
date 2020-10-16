

public class CountVariants{
   public  static int countVariants(int stairsCount) {
		if(stairsCount==0)return 0;
		if(stairsCount == 1)return 1;
		if(stairsCount<0)stairsCount=-stairsCount;// wrong input
//		return countVariants(stearsCount-1)+countVariants(stearsCount-2);
		int[] arr= new int[stairsCount];
		arr[0]=1;// 1st stair
		arr[1]=2;// 2nd stair
		for(int i = 2; i <stairsCount; i++) {
			arr[i]=arr[i-1]+arr[i-2];
		}
		return arr[stairsCount-1];
	}
}