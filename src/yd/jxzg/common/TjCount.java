package yd.jxzg.common;

public class TjCount {
private String dm;
    private String mc;
    private String title;
    private String bl1;
    private String bl2;
    private String bl3;
    private String bl4;
    private String bl5;
    private String bl6;
    private String bl7;
    private String bl8;
    private String bl9;
    private String bl10;
private Integer zcount;
private Integer xcount;
private Double zj;
private Double mj;
private String param1;

public String getParam1() {
	return param1;
}
public void setParam1(String param1) {
	this.param1 = param1;
}
public String getBl7() {
	return bl7;
}
public void setBl7(String bl7) {
	this.bl7 = bl7;
}
public String getBl8() {
	return bl8;
}
public void setBl8(String bl8) {
	this.bl8 = bl8;
}
public String getBl9() {
	return bl9;
}
public void setBl9(String bl9) {
	this.bl9 = bl9;
}
public String getBl10() {
	return bl10;
}
public void setBl10(String bl10) {
	this.bl10 = bl10;
}
public String getBl4() {
	return bl4;
}
public void setBl4(String bl4) {
	this.bl4 = bl4;
}
public String getBl5() {
	return bl5;
}
public void setBl5(String bl5) {
	this.bl5 = bl5;
}
public String getBl6() {
	return bl6;
}
public void setBl6(String bl6) {
	this.bl6 = bl6;
}
public String getDm() {
	return dm;
}
public void setDm(String dm) {
	this.dm = dm;
}
public String getMc() {
	return mc;
}
public void setMc(String mc) {
	this.mc = mc;
}
public Integer getZcount() {
	return zcount;
}
public void setZcount(Integer zcount) {
	this.zcount = zcount;
}
public Integer getXcount() {
	return xcount;
}
public void setXcount(Integer xcount) {
	this.xcount = xcount;
}
public TjCount(String dm, String mc, Integer zcount, Integer xcount) {
	super();
	this.dm = dm;
	this.mc = mc;
	this.zcount = zcount;
	this.xcount = xcount;
}
public TjCount() {
	super();
	// TODO Auto-generated constructor stub
}
public String getTitle() {
	return title;
}
public void setTitle(String title) {
	this.title = title;
}
public String getBl1() {
	return bl1;
}
public void setBl1(String bl1) {
	this.bl1 = bl1;
}
public String getBl2() {
	return bl2;
}
public void setBl2(String bl2) {
	this.bl2 = bl2;
}
public String getBl3() {
	return bl3;
}
public void setBl3(String bl3) {
	this.bl3 = bl3;
}

public TjCount(String title, String bl1, String bl2, String bl3) {
	super();
	this.title = title;
	this.bl1 = bl1;
	this.bl2 = bl2;
	this.bl3 = bl3;
}
public TjCount(String title) {
	super();
	this.title = title;
}
public TjCount(String title, String bl1) {
	super();
	this.title = title;
	this.bl1 = bl1;
}
public TjCount(String title, String bl1,String bl2) {
	super();
	this.title = title;
	this.bl1 = bl1;
	this.bl2 = bl2;
}
public TjCount(String mc, Integer zcount) {
	super();
	this.mc = mc;
	this.zcount = zcount;
}
public TjCount(String dm, String mc, Integer zcount) {
	super();
	this.dm = dm;
	this.mc = mc;
	this.zcount = zcount;

}

public TjCount(String dm, String mc, Double zj) {
	super();
	this.dm = dm;
	this.mc = mc;
	this.zj = zj;
}
public Double getZj() {
	return zj;
}
public void setZj(Double zj) {
	this.zj = zj;
}
public Double getMj() {
	return mj;
}
public void setMj(Double mj) {
	this.mj = mj;
}
public TjCount(String mc, Double zj) {
	super();
	this.mc = mc;
	this.zj = zj;
}

public TjCount(Double mj,String mc) {
	super();
	this.mc = mc;
	this.mj = mj;
}
public TjCount(String mc, Integer zcount, Integer xcount) {
	super();
	this.mc = mc;
	this.zcount = zcount;
	this.xcount = xcount;
}

}
