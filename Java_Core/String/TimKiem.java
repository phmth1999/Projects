package String;

public class TimKiem {
	public static void main(String[] args) {
		String s1 = "Xin chao co chu, xin chao cac ban, Xin chao!";
		String s2 = "Xin chao";

		// Ham indexOf
		System.out.println("Vi tri cua s2 trong s1 la: " + s1.indexOf(s2));

		// su dung vi tri bat dau
		System.out.println("Vi tri cua s2 trong s1 la: " + s1.indexOf(s2, 2));

		// Ham lastIndexOf => tim kiem tu phai sang trai
		System.out.println("Vi tri cua s2 trong s1 la: " + s1.lastIndexOf(s2));
	}
}
