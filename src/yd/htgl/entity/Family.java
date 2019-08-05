package yd.htgl.entity;

public class Family {
	//家庭编号
    private String jtbh;
    //姓名
    private String xm;
    //行业
    private String hy;
    //备注
    private String bz;
	public String getJtbh() {
		return jtbh;
	}
	public void setJtbh(String jtbh) {
		this.jtbh = jtbh;
	}
	public String getXm() {
		return xm;
	}
	public void setXm(String xm) {
		this.xm = xm;
	}
	public String getHy() {
		return hy;
	}
	public void setHy(String hy) {
		this.hy = hy;
	}
	public String getBz() {
		return bz;
	}
	public void setBz(String bz) {
		this.bz = bz;
	}
	@Override
	public String toString() {
		return "jtbh=" + jtbh + ", xm=" + xm + ", hy=" + hy + ", bz=" + bz;
	}
    

}
