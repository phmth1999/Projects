package Mang;

import java.util.Arrays;

public class TimKiem {
	public static int[] reverse(int[] x) {
		int[] rs = new int[x.length];
		int index = 0;
		for (int i = x.length - 1; i >= 0; i--) {
			rs[index] = x[i];
			index++;
		}
		return rs;
	}

	public static void main(String[] args) {
		int[] a = new int[] { 1, 8, 2, 6, 4, 3, 7, 9 };
		int[] b = new int[] { 5 };
		System.out.println("a ban dau: " + Arrays.toString(a));

		// Ham sap xep tang dan
		Arrays.sort(a);
		System.out.println("a sau khi sap xep: " + Arrays.toString(a));

		// Ham tim kiem binarySearch chi tim duoc khi mang da duoc sap xep
		System.out.println(Arrays.binarySearch(a, 4));
		System.out.println(Arrays.binarySearch(a, -1));

		// Ham dien gia tri
		Arrays.fill(b, 5);
		System.out.println("b sau khi dien gia tri: " + Arrays.toString(b));

		//

	}
}
