package Collection.Map;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeMap;

//Map thi co key va value
//hashMap khong sap xep theo thu tu
//treeMap sap xep theo thu tu

public class TuDien {
	private Map<String, String> duLieu = new TreeMap<String, String>();
	// private Map<String, String> duLieu = new HashMap<String, String>();

	public String themTu(String tuKhoa, String yNghia) {
		return this.duLieu.put(tuKhoa, yNghia);
	}

	public String xoaTu(String tuKhoa) {
		return this.duLieu.remove(tuKhoa);
	}

	public String traTu(String tuKhoa) {
		String kq = this.duLieu.get(tuKhoa);
		return kq;
	}

	public void inTuKhoa() {
		Set<String> tapHopTuKhoa = this.duLieu.keySet();
		System.out.println(Arrays.toString(tapHopTuKhoa.toArray()));
	}

	public int laySoLuong() {
		return this.duLieu.size();
	}

	public void xoaTatCa() {
		this.duLieu.clear();
	}

	public static void main(String[] args) {
		TuDien t = new TuDien();

		int luaChon = 0;
		Scanner sc = new Scanner(System.in);

		do {
			System.out.println("----------------");
			System.out.println("Menu");
			System.out.println("1.Them tu \n" + "2.Xoa tu \n" + "3.Tim y nghia tu khoa \n" + "4.In dnah sach tu khoa \n"
					+ "5.In ra so luong tu \n" + "6.Xoa tat ca");
			luaChon = sc.nextInt();
			sc.nextLine();
			if (luaChon == 1) {
				System.out.println("Nhap tu khoa: ");
				String tuKhoa = sc.nextLine();
				System.out.println("Nhap vao y nghia: ");
				String yNghia = sc.nextLine();
				t.themTu(tuKhoa, yNghia);
			} else if (luaChon == 2 || luaChon == 3) {
				System.out.println("Nhap tu khoa: ");
				String tuKhoa = sc.nextLine();
				if (luaChon == 2) {
					t.xoaTu(tuKhoa);
				} else {
					System.out.println("y nghia tu: " + t.traTu(tuKhoa));
				}
			} else if (luaChon == 4) {
				t.inTuKhoa();
			} else if (luaChon == 5) {
				System.out.println("So luong tu khoa: " + t.laySoLuong());
			} else if (luaChon == 6) {
				t.xoaTatCa();
			}
		} while (luaChon != 0);
	}
}
