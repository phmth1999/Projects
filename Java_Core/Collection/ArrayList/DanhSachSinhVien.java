package Collection.ArrayList;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class DanhSachSinhVien {
	private ArrayList<SinhVien> ds;

	public DanhSachSinhVien() {
		this.ds = new ArrayList<SinhVien>();
	}

	public DanhSachSinhVien(ArrayList<SinhVien> ds) {
		this.ds = ds;
	}

	// 1. Them sinh vien vao dnah sach.
	public void themSinhVien(SinhVien sv) {
		this.ds.add(sv);
	}

	// 2. In danh sach sinh vien ra man hinh.
	public void inDanhSachSinhVien() {
		for (SinhVien sinhVien : ds) {
			System.out.println(sinhVien);
		}
	}

	// 3. Kiem tra danh sach co rong hay khong.
	public boolean kiemTraDanhSachRong() {
		return this.ds.isEmpty();
	}

	// 4. Lay ra so luong sinh vien trong danh sach.
	public int laySoLuongSinhVien() {
		return this.ds.size();
	}

	// 5.Lam rong danh sach sinh vien.
	public void lamRongDanhSach() {
		this.ds.removeAll(ds);
	}

	// 6. Kiem tra sinh vien co ton tai trong danh sach sinh vien hay khong, dua
	// tren ma sinh vien.
	public boolean kiemTraTonTai(SinhVien sv) {
		return this.ds.contains(sv);
	}

	// 7. Xoa mot sinh vien ra khoi danh sach dua tren ma sinh vien.
	public boolean xoaSinhVien(SinhVien sv) {
		return this.ds.remove(sv);
	}

	// 8. Tim kiem tat ca sinh vien dua tren Ten nhap tu ban phim.
	public void timSinhVien(String ten) {
		for (SinhVien sinhVien : ds) {
			if (sinhVien.getHoVaTen().indexOf(ten) >= 0) {
				System.out.println(sinhVien);
			}
		}
	}

	// 9. Xuat ra danh sach sinh vien co diem tu cao toi thap.
	public void sapXepSinhVienGiamDanTheoDiem() {
		Collections.sort(this.ds, new Comparator<SinhVien>() {

			@Override
			public int compare(SinhVien o1, SinhVien o2) {
				if (o1.getDiemTB() < o2.getDiemTB()) {
					return 1;
				} else if (o1.getDiemTB() > o2.getDiemTB()) {
					return -1;
				} else {
					return 0;
				}
			}
		});
	}

}
