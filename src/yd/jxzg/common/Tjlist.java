package yd.jxzg.common;

import java.util.List;

public class Tjlist {
private String nf;
private List<TjCount> tjList;
public String getNf() {
	return nf;
}
public void setNf(String nf) {
	this.nf = nf;
}
public List<TjCount> getTjList() {
	return tjList;
}
public void setTjList(List<TjCount> tjList) {
	this.tjList = tjList;
}
public Tjlist() {
	super();
	// TODO Auto-generated constructor stub
}
public Tjlist(String nf, List<TjCount> tjList) {
	super();
	this.nf = nf;
	this.tjList = tjList;
}

}
