package Collection.HangDoi;

import java.util.ArrayDeque;
import java.util.Deque;

public class hangDoiDeque {
	public static void main(String[] args) {
		Deque<String> danhSachSV = new ArrayDeque<String>();

		danhSachSV.offer("a");
		danhSachSV.offer("c");
		danhSachSV.offer("b");
		danhSachSV.offer("d");
		danhSachSV.offerFirst("0");
		danhSachSV.offerLast("1");

		while (true) {
			String ten = danhSachSV.poll(); // lay ra va xoa
			if (ten == null) {
				break;
			}
			// peek => lay ra nhung khong xoa
			System.out.println(ten);

		}
	}
}
