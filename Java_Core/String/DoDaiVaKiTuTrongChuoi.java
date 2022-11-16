package String;

import java.util.Scanner;

public class DoDaiVaKiTuTrongChuoi {
	public static void main(String[] args) {
		String s;
		Scanner sc = new Scanner(System.in);

		System.out.println("Nhap vap mot chuoi ki tu: ");
		s = sc.nextLine();
		System.out.println("------");

		// Ham length() => lay do dai chuoi
		System.out.println("Do dai chuoi la= " + s.length());

		// Ham charAt(vi tri) => lay ra mot ki tu tai vi tri
		int doDai = s.length();
		for (int i = 0; i < doDai; i++) {
			System.out.println("vi tri tai i= " + i + " la: " + s.charAt(i));
		}

		// Ham getChars(vi tri bat dau, vi tri ket thuc, mang luu du lieu, vi tri bat dau luu cua mang)
		char[] arr = new char[10];
		s.getChars(2, 4, arr, 0);
		for (int i = 0; i < arr.length; i++) {
			System.out.println("gai tri cua mang tai i= " + i + " la: " + arr[i]);
		}
		
		//Ham getBytes
		byte[] arrByte=s.getBytes();
		for (byte b : arrByte) {
			System.out.println(b);
		}
	}
}
