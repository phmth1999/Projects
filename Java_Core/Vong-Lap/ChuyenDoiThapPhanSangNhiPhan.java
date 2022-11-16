package main;

import java.util.Scanner;

public class ChuyenDoiThapPhanSangNhiPhan {
	public static void main(String[] args) {
		int n;
		Scanner sc = new Scanner(System.in);

		System.out.println("nhap vao so thap phan: ");
		n = sc.nextInt();

		String nhiPhan = "";
		while (n > 0) {
			nhiPhan = n % 2 + nhiPhan;
			n = n / 2;
		}
		System.out.println("so nhi phan cua: " + n + " la: " + nhiPhan);
	}
}
