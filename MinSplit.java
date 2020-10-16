
import java.util.HashSet;
import java.util.LinkedList;
public class MinSplit{
    static final int[] arr = { 1, 5, 10, 20, 50 };

	private static int minSplit(int amount) {
		if (amount < 0)return -1;
		if (amount == 0)return 0;
		LinkedList<Integer> que = new LinkedList<>(); // for using Breadth-first search
		HashSet<Integer> seen = new HashSet<>(); // save already seen numbers
		que.add(amount);// push at the end
		int level = 0; // same as number of changes
		int size;// size of queue per level of amount
		seen.add(amount);// not necessary
		while (!que.isEmpty()) {
			size = que.size();
			while (size > 0) {
				int curr = que.poll();// get front number
				for (int i = arr.length - 1; i >= 0; i--) {// iterate over array of money in descending order
					int next = curr - arr[i];
					if (next == 0) {
						return level + 1;
					} else if (next > 0) {
						if (!seen.contains(next)) {
							que.add(next);
							seen.add(next);
						}
					}
				}
				size--;
			}
			level++;
		}
		return -1;
	}
}