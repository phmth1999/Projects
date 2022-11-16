package KeThuaVaAbstract;

public class XeDap extends PhuongTienDiChuyen{

	public XeDap(String loaiPhuongTien, HangSanXuat hangSanXuat) {
		super(loaiPhuongTien, hangSanXuat);
	}

	@Override
	public double layVanToc() {
		return 20;
	}

}
