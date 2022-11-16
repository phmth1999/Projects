package Collection.HangDoi;

import java.util.Scanner;
import java.util.Stack;

public class hangDoiStack {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		Stack<String> stackChuoi = new Stack<String>();

		// stackChuoi.push("giatri") => dua gia tri vao stack
		// stackChuoi.pop() => lay gia tri ra, xoa khoi stack
		// stackChuoi.peek() => lay gia tri ra, nhung khong xoa khoi stack
		// stackChuoi.clear() => xoa tat ca cac phan tu trong stack
		// stackChuoi.contains("giatri") => xac dinh gia tri co ton tai trong stack hay khong
		// stackChuoi.size() => do lon cua stack

		// vi tri dao nguoc chuoi
		System.out.println("Nhap vao chuoi: ");
		String s = sc.nextLine();

		for (int i = 0; i < s.length(); i++) {
			stackChuoi.push(s.charAt(i) + "");
		}
		System.out.println("Chuoi dao nguoc: ");
		for (int i = 0; i < s.length(); i++) {
			System.out.print(stackChuoi.pop());
		}
		System.out.println();
		// vi du chuyen tu thap phan sang nhi phan
		Stack<Integer> stackSoDu = new Stack<Integer>();
		System.out.println("Nhap 1 so nguyen duong tu ban phim: ");
		int x = sc.nextInt();
		while (x > 0) {
			int soDu = x % 2;
			stackSoDu.push(soDu);
			x = x / 2;
		}
		System.out.println("SO nhi phan la: ");
		int n = stackSoDu.size();
		for (int i = 0; i < n; i++) {
			System.out.print(stackSoDu.pop());
		}
	}
}
