package KeThuaVaAbstract;

public class Test {
public static void main(String[] args) {
	HangSanXuat h1= new HangSanXuat("A", "Viet Nam");
	HangSanXuat h2= new HangSanXuat("B", "Hoa Ky");
	HangSanXuat h3= new HangSanXuat("C", "Y");
	
	MayBay p1 = new MayBay("May Bay", h1, "Xang");
	PhuongTienDiChuyen p2 = new XeOto("Xe Oto", h2, "Dau");
	PhuongTienDiChuyen p3 = new XeDap("Xe Dap", h3);
	
	System.out.println("Lay hang san xuat phuong tien "+p1.loaiPhuongTien+" la: "+p1.layTenHangSanXuat());
	p1.BatDau();
	p1.catCanh();
	System.out.println("Van toc cua "+p1.loaiPhuongTien+" la:"+p1.layVanToc());
	p1.haCanh();
	p1.DungLai();
	System.out.println("------");
	System.out.println("Lay hang san xuat phuong tien "+p2.loaiPhuongTien+" la: "+p2.layTenHangSanXuat());
	p2.BatDau();
	System.out.println("Van toc cua "+p2.loaiPhuongTien+" la:"+p2.layVanToc());
	p2.DungLai();
	System.out.println("------");
	System.out.println("Lay hang san xuat phuong tien "+p3.loaiPhuongTien+" la: "+p3.layTenHangSanXuat());
	p3.BatDau();
	System.out.println("Van toc cua "+p3.loaiPhuongTien+" la:"+p3.layVanToc());
	p3.DungLai();
}
}
