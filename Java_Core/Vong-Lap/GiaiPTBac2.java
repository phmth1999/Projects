package main;

import java.util.Scanner;

//ax^2+bx+c=0
public class GiaiPTBac2 {
	public static void main(String[] args) {
		double a, b, c, x1, x2, delta;
		Scanner sc = new Scanner(System.in);

		System.out.println("nhap vao a = ");
		a = sc.nextDouble();
		System.out.println("nhap vao b = ");
		b = sc.nextDouble();
		System.out.println("nhap vao c = ");
		c = sc.nextDouble();

		delta = Math.pow(b, 2) - 4 * a * c;

		if (a == 0) {
			System.out.println("nhap du lieu sai");
		} else if (delta < 0) {
			System.out.println("pt vo nghiem");
		} else if (delta == 0) {
			x1 = -b / (2 * a);
			System.out.println("pt co nghiem kep x1=x2=" + x1);
		} else {
			x1 = (-b + Math.sqrt(delta)) / (2 * a);
			x2 = (-b - Math.sqrt(delta)) / (2 * a);
			System.out.println("pt co nghiem");
			System.out.println("x1= " + x1);
			System.out.println("x2= " + x2);
		}
	}

}
