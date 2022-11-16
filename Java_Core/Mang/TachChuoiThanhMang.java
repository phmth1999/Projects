package Mang;

import java.util.Arrays;

public class TachChuoiThanhMang {
	public static void main(String[] args) {
		String s = "Xin chao cac ban, tui la Peter";

		String[] a = s.split(" ");
		System.out.println(Arrays.toString(a));

		String[] b = s.split(",");
		System.out.println(Arrays.toString(b));

		String s3 = "Nguyen Van A";
		String[] c = s3.split(" ");
		System.out.println(Arrays.toString(c));
		System.out.println("Ten: " + c[c.length-1]);

	}
}
