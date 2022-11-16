package Collection.Set;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Random;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

//Set khong trung phan tu
//hashSet khong sap xep theo thu tu
//treeSet sap xep theo thu tu

public class RutThamTrungThuong {
	Set<String> thungPhieuDuThuong = new HashSet<String>();
//	 Set<String> thungPhieuDuThuong = new TreeSet<String>();

	public boolean themPhieu(String giaTri) {
		return this.thungPhieuDuThuong.add(giaTri);
	}

	public boolean xoaPhieu(String giaTri) {
		return this.thungPhieuDuThuong.remove(giaTri);
	}

	public boolean kiemTraPhieuTonTai(String giaTri) {
		return this.thungPhieuDuThuong.contains(giaTri);
	}

	public void xoaTatCaPhieu() {
		this.thungPhieuDuThuong.clear();
	}

	public int laySoLuong() {
		return this.thungPhieuDuThuong.size();
	}

	public String rutPhieu() {
		String kq = "";
		Random rd = new Random();
		int viTri = rd.nextInt(this.thungPhieuDuThuong.size());
		kq = (String) this.thungPhieuDuThuong.toArray()[viTri];
		return kq;
	}

	public void inTatCa() {
		System.out.println(Arrays.toString(this.thungPhieuDuThuong.toArray()));
	}

	public static void main(String[] args) {
		RutThamTrungThuong rt = new RutThamTrungThuong();
		int luaChon = 0;
		Scanner sc = new Scanner(System.in);
		do {
			System.out.println("-------------");
			System.out.println("Menu: ");
			System.out.println("1.Them ma so du thuong");
			System.out.println("2.Xoa ma so du thuong");
			System.out.println("3.Kiem tra ma so du thuong co ton tai hay khong");
			System.out.println("4.Xoa tat ca phieu du thuong");
			System.out.println("5.So luong phieu");
			System.out.println("6.Rut tham trung thuong");
			System.out.println("7.In tat ca");
			System.out.println("0.Thoat khoi chuong trinh");
			luaChon = sc.nextInt();
			sc.nextLine();
			if (luaChon == 1 || luaChon == 2 || luaChon == 3) {
				System.out.println("Nhap vao ma phieu du thuong: ");
				String giaTri = sc.nextLine();
				if (luaChon == 1) {
					rt.themPhieu(giaTri);
				} else if (luaChon == 2) {
					rt.xoaPhieu(giaTri);
				} else {
					System.out.println("Ket qua kiem tra: " + rt.kiemTraPhieuTonTai(giaTri));
				}
			} else if (luaChon == 4) {
				rt.xoaTatCaPhieu();
			} else if (luaChon == 5) {
				System.out.println("So luong phieu: " + rt.laySoLuong());
			} else if (luaChon == 6) {
				System.out.println("Ma trung thuong: " + rt.rutPhieu());
			} else if (luaChon == 7) {
				System.out.println("Cac ma phieu du thuong: ");
				rt.inTatCa();
			}

		} while (luaChon != 0);

	}
}
