package MiniGameTaiXiu;

import java.text.NumberFormat;
import java.util.Locale;
import java.util.Random;
import java.util.Scanner;

public class TaiXiu {
	public static void main(String[] args) {
		double taiKhoanNguoiChoi = 5000;
		Scanner sc = new Scanner(System.in);

		Locale lc = new Locale("vi", "VN");
//		NumberFormat numf = NumberFormat.getInstance(lc);
		NumberFormat numf = NumberFormat.getCurrencyInstance(lc);

		int luachon = 1;
		do {
			System.out.println("-----Moi ban chon-----");
			System.out.println("CHon (1) de tiep tuc choi.");
			System.out.println("CHon phim (0) de thoat.");
			luachon = sc.nextInt();

			if (luachon == 1) {
				System.out.println("***Bat dau***");
				System.out.println("***Tai khoan cua ban:***" + numf.format(taiKhoanNguoiChoi) + "Ban muon cuoc bao nhieu?");

				// Dat cuoc
				double datCuoc = 0;
				do {
					System.out.println("Dat cuoc (0<so tien cuoc<=" + numf.format(taiKhoanNguoiChoi) + ":");
					datCuoc = sc.nextDouble();
				} while (datCuoc <= 0 || datCuoc > taiKhoanNguoiChoi);

				// Chon tai xiu
				int luaChonTaiXiu = 0;
				do {
					System.out.println("Chon 1 tai hoac 2 xiu");
					luaChonTaiXiu = sc.nextInt();
				} while (luaChonTaiXiu != 1 && luaChonTaiXiu != 2);

				// Tung xuc xac
				Random xucXac1 = new Random();
				Random xucXac2 = new Random();
				Random xucXac3 = new Random();

				int giaTri1 = xucXac1.nextInt(5) + 1;
				int giaTri2 = xucXac1.nextInt(5) + 1;
				int giaTri3 = xucXac1.nextInt(5) + 1;
				int tong = giaTri1 + giaTri2 + giaTri3;

				// Tinh toan ket qua
				System.out.println("Ket qua:" + giaTri1 + " - " + giaTri2 + " - " + giaTri3);
				if (tong == 3 || tong == 18) {
					taiKhoanNguoiChoi -= datCuoc;
					System.out.println("Tong la: " + tong + " => Nha cai an het, ban da thua!");
					System.out.println("Tai khoan cua ban la: " + numf.format(taiKhoanNguoiChoi));

				} else if (tong >= 4 && tong <= 10) {
					System.out.println("Tong la: " + tong + " => Xiu");
					if (luaChonTaiXiu == 2) {
						System.out.println("Ban da thang cuoc");
						taiKhoanNguoiChoi += datCuoc;
						System.out.println("Tai khoan cua ban la: " + numf.format(taiKhoanNguoiChoi));
					} else {
						System.out.println("Ban da thua cuoc");
						taiKhoanNguoiChoi -= datCuoc;
						System.out.println("Tai khoan cua ban la: " + numf.format(taiKhoanNguoiChoi));
					}

				} else {
					System.out.println("Tong la: " + tong + " => Tai");
					if (luaChonTaiXiu == 1) {
						System.out.println("Ban da thang cuoc");
						taiKhoanNguoiChoi += datCuoc;
						System.out.println("Tai khoan cua ban la: " + numf.format(taiKhoanNguoiChoi));
					} else {
						System.out.println("Ban da thua cuoc");
						taiKhoanNguoiChoi -= datCuoc;
						System.out.println("Tai khoan cua ban la: " + numf.format(taiKhoanNguoiChoi));
					}
				}
			}

		} while (luachon != 0);

	}
}
