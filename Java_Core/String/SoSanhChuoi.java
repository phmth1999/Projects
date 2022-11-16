package String;

public class SoSanhChuoi {
	public static void main(String[] args) {
		String s1 = "thien";
		String s2 = "Thien";
		String s3 = "thien";

		// Ham equals => so sanh 2 chuoi giong nhau, co phan biet chu hoa chu thuong
		System.out.println("s1 so sanh s2: " + s1.equals(s2));
		System.out.println("s1 so sanh s3: "+s1.equals(s3));

		// Ham equalsIgnoreCase => so sanh 2 chuoi giong nhau, khong phan biet chu hoa chu thuong
		 System.out.println("s1 so sanh s2: "+s1.equalsIgnoreCase(s2));
		 System.out.println("s1 so sanh s3: "+s1.equalsIgnoreCase(s3));

		// Ham compareTo => so sanh > < = ,co phan biet chu hoa chu thuong
		String sv1 = "Nguyen Van A";
		String sv2 = "Nguyen Van B";
		String sv3 = "Nguyen Van";
		String sv4 = "Nguyen Van A";
		String sv5 = "Nguyen Van a";

		 System.out.println("sv1 so sanh sv2: " + sv1.compareTo(sv2));
		 System.out.println("sv1 so sanh sv2: " + sv1.compareTo(sv3));
		 System.out.println("sv1 so sanh sv2: " + sv1.compareTo(sv4));
		 System.out.println("sv1 so sanh sv2: " + sv1.compareTo(sv5));

		// Ham compareToIsgncoreCase => so sanh > < = ,khong phan biet chu hoa chu thuong
		 System.out.println("sv1 so sanh sv2: " +sv1.compareToIgnoreCase(sv2));
		 System.out.println("sv1 so sanh sv2: " +sv1.compareToIgnoreCase(sv3));
		 System.out.println("sv1 so sanh sv2: " +sv1.compareToIgnoreCase(sv4));
		 System.out.println("sv1 so sanh sv2: " +sv1.compareToIgnoreCase(sv5));

		// Ham regionMatches => so sanh mot doan
		String r1 = "thien";
		String r2 = "ie";
		boolean check = r1.regionMatches(2, r2, 0, 2);
		 System.out.println(check);

		// Ham startWith => kiem tra chuoi bat dau
		String sdt = "0378348419";

		 System.out.println(sdt.startsWith("037"));
		 System.out.println(sdt.startsWith("038"));

		// Ham endWith => kiem tra chuoi ket thuc
		String tenFile1 = "a.JPG";
		String tenFile2 = "a.PDF";

		if (tenFile1.endsWith("JPG")) {
			System.out.println("File hinh anh");
		} else if (tenFile1.endsWith("PDF")) {
			System.out.println("File PDF");
		}
	}
}
