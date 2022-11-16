package String;

public class CatChuoi {
	public static void main(String[] args) {
		String s1 = "thien";
		String s2 = ".vn";

		String s3 = s1 + s2;
		// Ham concat => noi chuoi
		String s4 = s1.concat(s2);
		System.out.println("s3= " + s3);
		System.out.println("s4= " + s4);

		// Ham replace => thay the
		String s5 = "Thien.vn";
		String s6 = s5.replace(".vn", "");
		System.out.println("s6= " + s6);

		// toLowercase
		String s7 = s5.toLowerCase();
		System.out.println("s7= " + s7);

		// toUpperCase
		String s8 = s5.toUpperCase();
		System.out.println("s8= " + s8);

		// trim() => xoa khoang trang du thua o dau chuoi cuoi chuoi
		String s9 = " Xin chao ";
		System.out.println(s9.trim());

		// subString => cat chuoi con
		String s10 = "Xin chao cac ban, minh la Thien";
		String s11 = s10.substring(1);
		String s12 = s10.substring(1, 2);
		System.out.println("s11= " + s11);
		System.out.println("s12= " + s12);
	}
}
