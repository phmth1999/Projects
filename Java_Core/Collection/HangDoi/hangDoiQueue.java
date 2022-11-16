package Collection.HangDoi;

import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

public class hangDoiQueue {
	public static void main(String[] args) {
//		Queue<String> danhSachSV = new LinkedList<String>();
		PriorityQueue<String> danhSachSV = new PriorityQueue<String>();
		
		danhSachSV.offer("d");
		danhSachSV.offer("a");
		danhSachSV.offer("b");
		danhSachSV.offer("c");
		
System.out.println(danhSachSV);
//		while (true) {
//			String ten=danhSachSV.poll(); //lay ra va xoa
//			if(ten==null){
//				break;
//			}
//			//peek => lay ra nhung khong xoa
//			System.out.println(ten);
//			
//		}
	}
}
