public class ThietBi {
    private String maThietBi;
    private String tenThietBi;
    private LoaiThietBi loai;
    private PhongBan phongBan;

    public ThietBi(String maThietBi, String tenThietBi, LoaiThietBi loai, PhongBan phongBan) {
        this.maThietBi = maThietBi;
        this.tenThietBi = tenThietBi;
        this.loai = loai;
        this.phongBan = phongBan;
    }

    public String getMaThietBi() {
        return maThietBi;
    }

    public void setMaThietBi(String maThietBi) {
        this.maThietBi = maThietBi;
    }

    public String getTenThietBi() {
        return tenThietBi;
    }

    public void setTenThietBi(String tenThietBi) {
        this.tenThietBi = tenThietBi;
    }

    public LoaiThietBi getLoai() {
        return loai;
    }

    public void setLoai(LoaiThietBi loai) {
        this.loai = loai;
    }

    public PhongBan getPhongBan() {
        return phongBan;
    }

    public void setPhongBan(PhongBan phongBan) {
        this.phongBan = phongBan;
    }

    @Override
    public String toString() {
        return String.format(
            "ThietBi{maThietBi='%s', tenThietBi='%s', loai=%s, phongBan=%s}",
            maThietBi, tenThietBi, loai, phongBan
        );
    }
}
