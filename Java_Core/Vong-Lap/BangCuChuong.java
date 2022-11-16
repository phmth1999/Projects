package main;

public class BangCuChuong {
public static void main(String[] args) {
	for (int i = 2; i <= 9; i++) {
		System.out.println("bang cu chuong "+i);
		for (int j = 1; j <=10; j++) {
//			if(i>5){
//				continue;
//			}
//			if(i>5){
//				break;
//			}
//			if(i>5){
//				return;
//			}
			System.out.println(i+" x "+j+" = "+(i*j));
		}
	}
}
}
