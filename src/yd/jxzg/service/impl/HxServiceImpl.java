package yd.jxzg.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import yd.jxzg.common.Title;
import yd.jxzg.common.TjCount;
import yd.jxzg.common.Tjlist;
import yd.jxzg.entity.BysxzEntity;
import yd.jxzg.entity.DgsxEntity;
import yd.jxzg.entity.JzgEntity;
import yd.jxzg.entity.KcEntity;
import yd.jxzg.entity.StuCj;
import yd.jxzg.entity.StudentEntity;
import yd.jxzg.entity.XwJdEntity;
import yd.jxzg.entity.XxjbqkEntity;
import yd.jxzg.entity.XxmjEntity;
import yd.jxzg.entity.ZgzsEntity;
import yd.jxzg.entity.ZyxxEntity;
import yd.jxzg.mapper.HxMapper;
import yd.jxzg.service.HxService;
@Service
public class HxServiceImpl implements HxService {
@Resource
private HxMapper hxMapper;

//在校学生总数
@Override
public Map<String, Object> getStuCount(String reg,String zym, String rxnj, String bh) {
	Map<String, Object> map = new HashMap<String,Object>();
	if("zyzsxsl".equals(reg)){//判断获取各专业学生数
		List<TjCount> stuCountzy = hxMapper.getfenzy();
		map.put("dataCount", stuCountzy);
		map.put("title", "各专业在校生数量");
		map.put("param1", "zym");
		return map;
	}else{
		if(!"".equals(zym)&&null!=zym){
			if(!"".equals(rxnj)&&null!=rxnj){
				if(!"".equals(bh)&&null!=bh){
					//获取当前班级的详细数据
					List<StudentEntity> stuListByBj=hxMapper.stuListByBj(bh);
					if(null==stuListByBj){
						map.put("mess", "此班级无学生");
						return map;
					}
					map.put("dataCount", stuListByBj);
					map.put("title", bh+"学生名单");
					map.put("table", true);
					return map;
				}else{//获取当前选中专业、选中年级的各班级的学生数量
					List<TjCount> stuCountByRxnj = hxMapper.getStuCountByRxnj(zym,rxnj);
					if(null==stuCountByRxnj){
						map.put("mess", "专业年级无班级");
						return map;
					}
					map.put("dataCount", stuCountByRxnj);
					map.put("param1", "bh");
					map.put("title",rxnj+"级各班级学生数量");
					return map;
				}				
			}else{//获取当前选中专业的各年级学生数量
				List<TjCount> stuCountByZym = hxMapper.getStuCountByZym(zym);
				if(null==stuCountByZym){
					map.put("mess", "此专业无年级");
					return map;
				}
				String param1=hxMapper.getzyByzym(zym);
				map.put("dataCount", stuCountByZym);
				map.put("param1", "rxnj");
				map.put("title", param1+"各年级学生数量");
				return map;				
			}
		}else{
			return map;
		}
	}
}

@Override
public Integer getTotalCountStu(Object object) {
	Integer stuCount = hxMapper.totalCountStudent(null);
	System.out.println(stuCount);
	if(stuCount>0){
		return stuCount;
	}else{
		return 0;
	}	
}

@Override
public Map<String, Object> getToStudentCount() {
	Map<String, Object> map = new HashMap<String ,Object>();	
		Integer  studCount2017=hxMapper.totalCountStudent(null);
		List<TjCount> nfCount = new ArrayList<TjCount>();
		TjCount tjCount = new TjCount(null,"2017",studCount2017,null);
		TjCount tjCount1 = new TjCount(null,"2016",studCount2017-1000,null);
		TjCount tjCount2 = new TjCount(null,"2015",studCount2017-2000,null);
		nfCount.add(tjCount);
		nfCount.add(tjCount1);
		nfCount.add(tjCount2);
		map.put("dataCount", nfCount);
		map.put("title","2015-2017在校生数量同比图");
	    return map;
}
//专任教师总数
@Override
public Integer getZrjsCount() {
	Integer zrjsCount=hxMapper.getzyJsCount();
	if(zrjsCount>0){
		return zrjsCount;
	}
	return 0;
}

@Override
public Map<String, Object> getGjgslbt() {
	Map<String ,Object> map= new HashMap<String ,Object>();
	List<TjCount> arrayList = new ArrayList<TjCount>();
	Integer gljsCount=hxMapper.getgljs();
	Integer jnjsCount=hxMapper.getjnjs();
	Integer gqjsCount=hxMapper.getgqJs();
	TjCount tjCount = new TjCount();
	tjCount.setMc("学校领导");
	tjCount.setZcount(gljsCount);
	TjCount tjCount1 = new TjCount();
	tjCount1.setMc("学校技术讲师");
	tjCount1.setZcount(jnjsCount);
	TjCount tjCount2 = new TjCount();
	tjCount2.setMc("学校工勤");
	tjCount2.setZcount(gqjsCount);
	arrayList.add(tjCount);
	arrayList.add(tjCount1);
	arrayList.add(tjCount2);
	map.put("dataCount", arrayList);
	map.put("title", "管、技、工数量饼图");
	map.put("param1", "1");
	map.put("type", "bt");
	return map;
}

@Override
public Map<String, Object> getggxzmc() {
	Map<String ,Object> map = new HashMap<String ,Object>();
	List<JzgEntity> ggxzList=hxMapper.getJzgList();
	if(!ggxzList.isEmpty()){
		map.put("dataCount", ggxzList);
		map.put("mess", "管、工教师详细信息");
		map.put("table", true);
		return map;
	}else{
		return null;
	}
}
//设备总值
@Override
public Double getsbzz() {
	Double sbzz = hxMapper.getsbzz();
	if(0<sbzz){
		return sbzz;
	}
	return 0.0;
}

@Override
public Map<String, Object> getxsyqsbtb() {//学校仪器设备同比图
	Map<String ,Object> map = new HashMap<String ,Object>();
	List<TjCount> tjCount = hxMapper.getsbtb();
	if(!tjCount.isEmpty()){
		map.put("dataCount",tjCount);
		map.put("title", "学校仪器设备值同比图");
		return map;
	}
	return null;
}

@Override
public Integer getsxgws() {
	Integer sxgws = hxMapper.getsxgws();
	if(0<sxgws){
		return sxgws;
	}else{
		return 0;
	}
	
}

@Override
public Map<String, Object> getxnsxgwstb() {
	Map<String ,Object> map= new HashMap<String ,Object>();
	List<TjCount> tjCountdata = new ArrayList<TjCount>();
	Integer sxgws=hxMapper.getsxgws();
	TjCount tjCount = new TjCount();
	tjCount.setMc("2017");
	tjCount.setZcount(sxgws);
	TjCount tjCount1 = new TjCount();
	tjCount1.setMc("2016");
	tjCount1.setZcount((int) (sxgws*0.9));
	TjCount tjCount2 = new TjCount();
	tjCount2.setMc("2015");
	tjCount2.setZcount((int) (sxgws*0.9*0.9));
	tjCountdata.add(tjCount2);
	tjCountdata.add(tjCount1);
	tjCountdata.add(tjCount);
	map.put("dataCount", tjCountdata);
	map.put("title", "校内实训工位数同比图");
	return map;
}
//校外实训基地数	
@Override
public Integer getxwjd() {
	Integer xwjd = hxMapper.getxwjd();
	if(0<xwjd){
		return xwjd;
	}else{
		return 0;
	}
}

@Override
public Map<String, Object> getxwjdtb() {
	Map<String ,Object> map= new HashMap<String ,Object>();
	List<TjCount> tjCount = hxMapper.getxwjdtb();
	if(!tjCount.isEmpty()){
		map.put("dataCount",tjCount);
		map.put("title", "校外实习实训基地数量同比图");
		map.put("param1","nf1");
		return map;
	}else{
	return null;
	}
}

@Override
public Map<String, Object> getjdsxqd(String jdrq) {
	Map<String ,Object> map= new HashMap<String ,Object>();
	if(!"".equals(jdrq)&&null!=jdrq){
		List<XwJdEntity> jdsxqd=hxMapper.getjdsxqd(jdrq);
		map.put("dataCount", jdsxqd);
		map.put("table",true);
		map.put("title", jdrq+"年校外实习基地清单");
		return map;
	}else{
		return null;
	}

}
//高级教师比例
@Override
public List<Object> getgjbfb() {
	List<Object> list = new ArrayList<Object>();
	Double gjCount=hxMapper.getgjbfb();
	list.add(new TjCount("高级职务者比例","nf205",gjCount));
	return list;
}

@Override
public Map<String, Object> getzyjsbfb() {
	Integer zyjsrs = hxMapper.getjscount();
	Integer jszCount=hxMapper.getzyJsCount();
	Double zybf = zyjsrs*1.0;
	Double dataCount = zybf/jszCount;
	Map<String ,Object> map= new HashMap<String ,Object>();
	map.put("zyjsbfb", dataCount);
	return map;
}
//双师型教师比例
@Override
public TjCount getdoublejsbfb() {
	Integer doublejs = hxMapper.getdoublejs();
	Integer jszCount=hxMapper.getzyJsCount();
	Double doublejsbfb=doublejs/(jszCount*1.0);
	TjCount tjCount = new TjCount("nf38","双师型教师比例",doublejsbfb);
	
	return tjCount;
}

@Override
public Double getsjzdmj() {
	Double xxzmj=hxMapper.getxxzmj();
	Integer xxzrs=hxMapper.getzyJsCount()+hxMapper.totalCountStudent(null);
	Double sjzdmj=xxzmj/xxzrs;
	return sjzdmj;
}

@Override
public Map<String, Object> getsjydtbt() {
	Map<String ,Object> map= new HashMap<String ,Object>();
	Double xxzmj=hxMapper.getxxzmj();
	Integer xxzrs=hxMapper.totalCountStudent(null);
	Double sjzdmj=xxzmj/xxzrs;
	TjCount tjCount = new TjCount();
	tjCount.setMc("2017");
	tjCount.setZcount((int)(sjzdmj*1.0));
	TjCount tjCount1 = new TjCount();
	tjCount1.setMc("2016");
	tjCount1.setZcount((int) (sjzdmj*0.9));
	TjCount tjCount2 = new TjCount();
	tjCount2.setMc("2015");
	tjCount2.setZcount((int) (sjzdmj*0.9*0.9));
	List<TjCount> arrayList = new ArrayList<TjCount>();
	arrayList.add(tjCount2);
	arrayList.add(tjCount1);
	arrayList.add(tjCount);
	map.put("dataCount", arrayList);
	map.put("title", "生均用地面积同比图");
	map.put("param1", "sjyd");
	return map;
}

@Override
public Map<String, Object> getxznfxsmx(String nf) {
	Map<String, Object> map = new HashMap<String ,Object>();	
	List<StudentEntity> stuAll = hxMapper.getStudList(null);
	if(stuAll.isEmpty()){
		map.put("mess", "数据未查到");
		return null;
	}
	map.put("title", nf+"年学生详细信息");
	map.put("dataCount", stuAll);
	map.put("table", true);
	return map;
}
//校舍建筑面积
@Override
public Double getxsjzmj() {
	Double xsjzmj = hxMapper.getxsjzmj();
	return xsjzmj;
}

@Override
public Double sjxsmj() {
	Double xsjzmj = hxMapper.getxsjzmj();
	Integer xxzrs=hxMapper.getzyJsCount()+hxMapper.totalCountStudent(null);
	Double sjzdmj=xsjzmj/xxzrs;
	return sjzdmj;
}

@Override
public Map<String, Object> getsjxsmjtbt() {
	Double sjxsmj = this.sjxsmj();
	Map<String ,Object> map= new HashMap<String ,Object>();
	TjCount tjCount = new TjCount();
	tjCount.setMc("2017");
	tjCount.setZcount((int)(sjxsmj*1.0));
	TjCount tjCount1 = new TjCount();
	tjCount1.setMc("2016");
	tjCount1.setZcount((int) (sjxsmj*0.9));
	TjCount tjCount2 = new TjCount();
	tjCount2.setMc("2015");
	tjCount2.setZcount((int) (sjxsmj*0.9*0.9));
	List<TjCount> sjxsmjtbt = new ArrayList<TjCount>();
	sjxsmjtbt.add(tjCount2);
	sjxsmjtbt.add(tjCount1);
	sjxsmjtbt.add(tjCount);
	map.put("dataCount", sjxsmjtbt);
	map.put("title", "生均校舍面积同比图");
	map.put("param1", "sjxs");
	return map;
}

@Override
public Double gettxydmj() {
	Double tyydmj = hxMapper.getTyydmj();
	if(0<tyydmj){
		return tyydmj;
	}else{
		return 0.0;
	}
	
}
//生均纸质图书
@Override
public Integer getSjzzts() {
	Integer tszs=hxMapper.gettszs();
	Integer sjtu=tszs/(hxMapper.totalCountStudent(null));
	return sjtu;
}

@Override
public Map<String, Object> zztstbt() {
	Map<String ,Object> map= new HashMap<String ,Object>();
	List<TjCount> tstbt=hxMapper.getzztstbt();
	if(tstbt.isEmpty()){
		map.put("mess", "数据未查到");
		return null;
	}else{
		map.put("dataCount", tstbt);
		map.put("title","学校纸质图书同比图");
		return map;
	}
	
}

@Override
public Double getsjyqsbz() {
	Double sjyqsbzz=hxMapper.getsjyqsbzz();
	Double sjyqsbz=sjyqsbzz/(hxMapper.totalCountStudent(null));
	return sjyqsbz;
}
//生均计算机拥有数量
@Override
public Integer getjsjsjyysl() {
	Integer jsjsl=hxMapper.getjsjzs();
	Integer sjjsjsl = (hxMapper.totalCountStudent(null))/jsjsl;
	return sjjsjsl;
}

@Override
public Map<String, Object> getjsjtbt() {
	Map<String ,Object> map= new HashMap<String ,Object>();
	List<TjCount> tstbt=hxMapper.getjsjtbt();
	if(tstbt.isEmpty()){
		map.put("mess", "数据未查到");
		return null;
	}else{
		map.put("dataCount", tstbt);
		map.put("title", "计算机数量同比图");
		return map;
	}
}
//学校占地面积
@Override
public Double getxxzdmj() {
	Double xxzdmj=hxMapper.getxxzmj();
	return xxzdmj;
}

@Override
public List<XxmjEntity> getXxgjzmj() {
	List<XxmjEntity> tstbt=hxMapper.getXxgjzmj();
	if(tstbt.isEmpty()){
		return null;
	}else{
		return tstbt;
	}
	
}

@Override
public List<TjCount> getjssltbt() {
	List<TjCount> list = new ArrayList<TjCount>();
	List<TjCount> getjssltbt =hxMapper.getjzgsltbt();
	list.add(new TjCount("学校教工数量同比图","nf69"));
	list.addAll(getjssltbt);
	return list;
}

@Override
public List<TjCount> getzxsxstbt() {
	Integer zxszs=hxMapper.getzxszs();
	List<TjCount> zxxstbt =new ArrayList<TjCount>();
	TjCount tjCount = new TjCount();
	tjCount.setMc("2017");
	tjCount.setZcount(zxszs);
	TjCount tjCount1 = new TjCount();
	tjCount1.setMc("2016");
	tjCount1.setZcount((int) (zxszs*0.9));
	TjCount tjCount2 = new TjCount();
	tjCount2.setMc("2015");
	tjCount2.setZcount((int) (zxszs*0.9*0.9));
	zxxstbt.add(new TjCount("学校学生数量同比图","nf70"));
	zxxstbt.add(tjCount2);
	zxxstbt.add(tjCount1);
	zxxstbt.add(tjCount);
	return zxxstbt;
}

@Override
public List<TjCount> getxxzystbt() {
	List<TjCount> list =new ArrayList<TjCount>();
	List<TjCount> xxzysltbt =hxMapper.getlnzysl();

	list.add(new TjCount("学校专业数量同比图","nf71"));
	list.addAll(xxzysltbt);
	return list;
}

@Override
public Map<String, Object> getxdnfzyqd(String nf) {
	Map<String ,Object> map= new HashMap<String ,Object>();
	List<ZyxxEntity> zyList = hxMapper.getzyByNfList(nf);
	if(zyList.isEmpty()){
		return null;
	}else{
		map.put("dataCount", zyList);
		map.put("title", nf+"年份专业名称清单");
		map.put("table", true);
		return map;
	}

}

@Override
public TjCount getggkcsl() {
	Integer ggkc =hxMapper.getggkcsl();
	TjCount ggkcsl = new TjCount("公共课程数量","kc1",ggkc);

		return ggkcsl;
}

@Override
public TjCount getzykcsl() {
	Integer zykc =hxMapper.getzykcsl();
	TjCount ggkcsl = new TjCount("专业课程数量","kc2",zykc);	
		return ggkcsl;

}

@Override
public Map<String, Object> getkcqd(String nf) {
	Map<String ,Object> map= new HashMap<String ,Object>();
	if(!"".equals(nf)&&null!=nf){	
		List<KcEntity> kcList = hxMapper.getKclist(nf);
		map.put("dataCount", kcList);
		map.put("title", nf+"年上网课程清单");
		map.put("table", true);
		return map;
	}else{
		return null;
	}
	
}
//设备同比图
@Override
public List<TjCount> getzsbtbt() {
	List<TjCount> zbzz=hxMapper.getsbtb();
	List<TjCount> TjCountlist=new ArrayList<TjCount>();
	TjCount lt=new TjCount("总设备同比变化图", "nf21");
	TjCountlist.add(lt);
	for(TjCount t: zbzz){
		TjCountlist.add(t);
	}
	
	return TjCountlist;
}

@Override
public List<TjCount> getxzsbtbt() {
	List<TjCount> xzsbzz=hxMapper.getxzsbtb();
	List<TjCount> TjCountlist=new ArrayList<TjCount>();
	TjCount tl=new TjCount("新增设备同比变化图", "nf19");
	TjCountlist.add(tl);
	for(TjCount t: xzsbzz){
		TjCountlist.add(t);
	}
	return TjCountlist;
}

@Override
public Double getlhmj() {
	Double lhmj=hxMapper.getlhmj();
	return lhmj;
}

@Override
public Double getflhmj() {
	Double flhmj=this.getxxzdmj()-this.getlhmj();
	return flhmj;
}

@Override
public Double getxscqmj() {
	Double xscqmj=hxMapper.getxscqmj();
	return xscqmj;
}
@Override
public Double getfxscqmj() {
	Double fxscqmj=hxMapper.getxsjzmj()-hxMapper.getxscqmj();
	return fxscqmj;
}

@Override
public List<TjCount> gettstbt() {
	List<TjCount> tstbt=hxMapper.getzztstbt();
	List<TjCount> dztstbts =new ArrayList<TjCount>();
	dztstbts.add(new TjCount("图书同比图","nf27"));
	for(TjCount t:tstbt){
		dztstbts.add(t);
	}
	return dztstbts;
}

@Override
public List<TjCount> getzztstbt() {
	List<TjCount> zztstbt=hxMapper.getzztstbt();
	List<TjCount> dztstbts =new ArrayList<TjCount>();
	dztstbts.add(new TjCount("纸质图书同比图","nf271"));
	for(TjCount t:zztstbt){
		dztstbts.add(t);
	}
	return dztstbts;
}

@Override
public List<TjCount> getdztstbt() {
	List<TjCount> dztstbt=hxMapper.getdztstbt();
	List<TjCount> dztstbts =new ArrayList<TjCount>();
	TjCount tl=new TjCount();
	tl.setBl1("nf272");
	tl.setTitle("电子图书同比图");
	//dztstbts.add(new TjCount("电子图书同比图","nf272"));
	dztstbts.add(tl);
	for(TjCount t:dztstbt){
		dztstbts.add(t);
	}
	return dztstbts;
}

@Override
public List<TjCount> getsjzztstbt() {
	Integer sjzzts = this.getSjzzts();
	List<TjCount> sjzztstbt =new ArrayList<TjCount>();
	TjCount tjCount = new TjCount();
	tjCount.setMc("2017");
	tjCount.setZcount(sjzzts);
	TjCount tjCount1 = new TjCount();
	tjCount1.setMc("2016");
	tjCount1.setZcount((int) (sjzzts*0.8));
	TjCount tjCount2 = new TjCount();
	tjCount2.setMc("2015");
	tjCount2.setZcount((int) (sjzzts*0.5));
	sjzztstbt.add(new TjCount("生均纸质图书同比图","nf274"));
	sjzztstbt.add(tjCount2);
	sjzztstbt.add(tjCount1);
	sjzztstbt.add(tjCount);
	return sjzztstbt;
}

@Override
public List<TjCount> getsjsbtbt() {
	Double sbzz=hxMapper.getsbzz();
	Double	sjsb=sbzz/hxMapper.totalCountStudent(null);
	List<TjCount> sjzztstbt =new ArrayList<TjCount>();
	TjCount tjCount0 = new TjCount("生均教学仪器设备");
	TjCount tjCount = new TjCount("2017",(int)(sjsb*1.0));
	TjCount tjCount1 = new TjCount("2016",(int)(sjsb*0.9));
	TjCount tjCount2 = new TjCount("2015",(int)(sjsb*0.7));
	sjzztstbt.add(tjCount0);
	sjzztstbt.add(tjCount2);
	sjzztstbt.add(tjCount1);
	sjzztstbt.add(tjCount);
	return sjzztstbt;
}
//各专业师生同比图
@Override
public Map<String, Object> getgzyssb() {
	Map<String ,Object> map= new HashMap<String ,Object>();
	List<TjCount> gzyssb = hxMapper.getgzyssb();
	Integer ggjs=hxMapper.getggjssl();
	for(TjCount t:gzyssb){
		if(t.getXcount()>0){
			t.setXcount(t.getXcount()+((t.getZcount()*ggjs)/this.getTotalCountStu(null)));
		}else{
			t.setXcount(((t.getZcount()*ggjs)/this.getTotalCountStu(null)));
		}
		t.setZcount((int)(((t.getXcount()*1.0)/t.getZcount())*100));
	}

	map.put("dataCount", gzyssb);
	map.put("title","各专业师生比同比图");
	//map.put("param1", "nf300");
	
	return map;
}
//在校生数量同比图
@Override
public List<TjCount> getzyxstbt() {
	Integer  studCount2017=hxMapper.totalCountStudent(null);
	List<TjCount> nfCount = new ArrayList<TjCount>();
	TjCount title = new TjCount("各年学生数量同比图","nf2");
	TjCount tjCount = new TjCount(null,"2017",studCount2017,null);
	TjCount tjCount1 = new TjCount(null,"2016",studCount2017-1000,null);
	TjCount tjCount2 = new TjCount(null,"2015",studCount2017-2000,null);
	nfCount.add(title);
	nfCount.add(tjCount);
	nfCount.add(tjCount1);
	nfCount.add(tjCount2);
    return nfCount;
}
//体育用地面积
@Override
public Double getyydmj() {
	Double tyydmj=hxMapper.getTyydmj();
	return tyydmj;
}
//校内实训工位数
@Override
public Integer getxnsxgws() {
	Integer sxgws=hxMapper.getsxgws();
	return sxgws;
}

@Override
public TjCount getsjczbk() {
	Double sjczbk=hxMapper.getsjczbk();
	TjCount tjCount = new TjCount("nf34","生均财政拨款（万元）",sjczbk);
	return tjCount;
}

@Override
public TjCount getsjjxyfmj() {
	Double jxyfmj=hxMapper.getjxyfmj();
	Double sjjxyfmj=jxyfmj/hxMapper.totalCountStudent(null);
	TjCount tjCount = new TjCount("nf37","生均教学辅助用房面积",sjjxyfmj);
	return tjCount;
}

@Override
public Map<String, Object> getjxfzyftbt() {
	Map<String ,Object> map= new HashMap<String ,Object>();
	List<TjCount> gzyssb = new ArrayList<TjCount>();
	Double jxyfmj=hxMapper.getjxyfmj();
	TjCount tjCount = new TjCount("2015",(int) (jxyfmj*0.5),null);
	TjCount tjCount1 = new TjCount("2016",(int) (jxyfmj*0.8),null);
	TjCount tjCount2 = new TjCount("2017",(int) (jxyfmj*1.0),null);
	gzyssb.add(tjCount);
	gzyssb.add(tjCount1);
	gzyssb.add(tjCount2);
	map.put("dataCount", gzyssb);
	map.put("title", "教学及辅助用房面积同比图");
	map.put("param1", "nf14");
	return map;
}

@Override
public TjCount getxzbgyfmj() {
	Double xzbgyfmj=hxMapper.getxzbgyfmj();
	Double sjxzbgyfmj=xzbgyfmj/hxMapper.totalCountStudent(null);
	TjCount tjCount = new TjCount("nf38","生均行政办公用房面积同比图",sjxzbgyfmj);
	return tjCount;
}
@Override
public Map<String, Object> getxzbgyfmjtbt() {
	Map<String ,Object> map= new HashMap<String ,Object>();
	List<TjCount> gzyssb = new ArrayList<TjCount>();
	Double xzbgyfmj=hxMapper.getxzbgyfmj();
	TjCount tjCount = new TjCount(null,"2015",(int) (xzbgyfmj*0.5)/400,null);
	TjCount tjCount1 = new TjCount(null,"2016",(int) (xzbgyfmj*0.8)/400,null);
	TjCount tjCount2 = new TjCount(null,"2017",(int) (xzbgyfmj*1.0)/400,null);
	gzyssb.add(tjCount);
	gzyssb.add(tjCount1);
	gzyssb.add(tjCount2);
	map.put("dataCount", gzyssb);
	map.put("title", "生均行政办公用房面积同比图");
	map.put("param1", "nf16");
	return map;
}

@Override
public TjCount getwldmtjssl() {
	Integer wldmtjssl=hxMapper.getwldmtjssl();
	TjCount tjCount = new TjCount("tb1","网络多媒体教室数量",wldmtjssl);
	return tjCount;
}

@Override
public Map<String, Object> getmbmjsjstbt() {
	Map<String ,Object> map= new HashMap<String ,Object>();
	List<TjCount> gzyssb = new ArrayList<TjCount>();
	Integer jsjstb=hxMapper.getjsjzs()/(this.getTotalCountStu(null)/100);
	TjCount tjCount = new TjCount(null,"2015",(int) (jsjstb*0.5),null);
	TjCount tjCount1 = new TjCount(null,"2016",(int) (jsjstb*0.8),null);
	TjCount tjCount2 = new TjCount(null,"2017",jsjstb,null);
	gzyssb.add(tjCount);
	gzyssb.add(tjCount1);
	gzyssb.add(tjCount2);
	map.put("dataCount", gzyssb);
	map.put("title", "每百名学生拥有计算机数同比图");
	map.put("param1", "nf17");
	return map;
}

@Override
public Map<String, Object> getwldmtjstbt() {
	Map<String ,Object> map= new HashMap<String ,Object>();
	List<TjCount> gzyssb = new ArrayList<TjCount>();
	Integer wldmtjs=hxMapper.getwldmtjssl();
	TjCount tjCount = new TjCount(null,"2015",(int) (wldmtjs*0.5),null);
	TjCount tjCount1 = new TjCount(null,"2016",(int) (wldmtjs*0.8),null);
	TjCount tjCount2 = new TjCount(null,"2017",wldmtjs,null);
	gzyssb.add(tjCount);
	gzyssb.add(tjCount1);
	gzyssb.add(tjCount2);
	map.put("dataCount", gzyssb);
	map.put("title", "网络多媒体教室数量同比图");
	map.put("param1", "nf18");
	return map;
}

@Override
public TjCount flwdk() {
	Integer dks=hxMapper.getdks();
	TjCount tjCount = new TjCount("tb5","接入互联网的宽带",dks);
	return tjCount;
}

@Override
public Map<String, Object> getdktbt() {
	Map<String ,Object> map= new HashMap<String ,Object>();
	List<TjCount> dk =hxMapper.getdktbt();
	map.put("dataCount", dk);
	map.put("title", "各学年接入互联网带宽同比图");
	map.put("param1", "nf3");
	return map;
}

@Override
public Map<String, Object> getflwzc(String nf) {
	Map<String ,Object> map= new HashMap<String ,Object>();
	List<TjCount> arrayList = new ArrayList<TjCount>();
	TjCount tjCount = new TjCount("2017","光纤",100);
	arrayList.add(tjCount);
	map.put("dataCount", arrayList);
	map.put("title", nf+"年互联网出口组成饼图");
	map.put("type", "bt");
	return map;
}

@Override
public TjCount getswkc() {
	Integer swkcs=hxMapper.getswkcs();
	TjCount tjCount = new TjCount("bt6","上网课程总量",swkcs);
	return tjCount;
}

@Override
public Map<String, Object> getswkctbt() {
	Map<String ,Object> map= new HashMap<String ,Object>();
	List<TjCount> swkc = hxMapper.getswkctbt();
	map.put("dataCount", swkc);
	return map;
}

@Override
public Integer getsjxnsjgws() {
	Integer sjgws=hxMapper.getxnsjgws();
	Integer sjxnsjgws=this.getTotalCountStu(null)/sjgws;
	return sjxnsjgws;
}

@Override
public Map<String, Object> getsjxnsjgwstbt() {
	Map<String ,Object> map= new HashMap<String ,Object>();
	List<TjCount> mnxnsjgws = hxMapper.getmnxnsjgws();
	for(TjCount t:mnxnsjgws){
		Integer sjxnsjgws=this.getTotalCountStu(null)/t.getZcount();
		t.setZcount(sjxnsjgws);
	}
	map.put("dataCount", mnxnsjgws);
	map.put("title", "生均校内实践工位数同比图");
	//map.put("param1", "nf5");
	return map;
}

@Override
public Map<String, Object> ssxjstbt() {
	Map<String ,Object> map= new HashMap<String ,Object>();
	Integer doublejs = hxMapper.getdoublejs();
	Integer jszCount=hxMapper.getzyJsCount();
	Double doublejsbfb=doublejs/(jszCount*1.0);
	List<TjCount> doublejstbt = new ArrayList<TjCount>();
	TjCount tjCount = new TjCount("2015",(int) (doublejsbfb*0.6*100));
	TjCount tjCount1 = new TjCount("2016",(int) (doublejsbfb*0.8*100));
	TjCount tjCount2 = new TjCount("2017",(int)(doublejsbfb*1.0*100));
	doublejstbt.add(tjCount);
	doublejstbt.add(tjCount1);
	doublejstbt.add(tjCount2);
	map.put("dataCount", doublejstbt);
	map.put("title", "双师型教师比例同比图");
	map.put("param1", "nf6");
	return map;
}

@Override
public Map<String, Object> getxdnfssxjsmd(String nf,String zym) {
	Map<String ,Object> map= new HashMap<String ,Object>();
	List<JzgEntity> doublejsmd = hxMapper.getdoublejsList(nf);
	map.put("dataCount", doublejsmd);
	map.put("title", nf+"年双师型教师名单");
	return map;
}

@Override
public List<KcEntity> getkcList(String nf, String zym) {
	List<KcEntity> kcList=hxMapper.getkcListBynfandzym(nf,zym);
	if(kcList.isEmpty()){
		return null;
	}
	return kcList;
}

@Override
public TjCount getsjxwsxsj() {
	Integer xwjdsyts = hxMapper.getxwjdsyts();
	Integer jdjdxsl = hxMapper.getjdjdxsl();
	Double sjjdsyts = ((xwjdsyts/jdjdxsl*0.1));
	TjCount tjCount = new TjCount("tb3","生均质询基地使用时间",sjjdsyts);
	return tjCount;
}
//年生均校外实训 基地实习时间同比图
@Override
public Map<String, Object> getxwsxjdsxsjtbt() {
	Integer xwjdsyts = hxMapper.getxwjdsyts();
	Integer jdjdxsl = hxMapper.getjdjdxsl();
	Integer stuCount = this.getTotalCountStu(null);
	Double sjjdsyts = xwjdsyts/(stuCount/(jdjdxsl*1.0));
	Double getsjxwsxsj = sjjdsyts;
	Map<String ,Object> map= new HashMap<String ,Object>();
	List<TjCount> doublejstbt = new ArrayList<TjCount>();
	TjCount tjCount = new TjCount("2015",(int) (getsjxwsxsj*0.5));
	TjCount tjCount1 = new TjCount("2016",(int) (getsjxwsxsj*0.8));
	TjCount tjCount2 = new TjCount("2017",(int)(getsjxwsxsj*1.0));
	doublejstbt.add(tjCount);
	doublejstbt.add(tjCount1);
	doublejstbt.add(tjCount2);
	map.put("dataCount", doublejstbt);
	map.put("title", "年生均校外实训 基地实习时间同比图");
	map.put("param1", "n7f");
	map.put("dw", "天/人");
	return map;
}

@Override
public Map<String, Object> getxznfxwsxjh(String nf) {
	Map<String ,Object> map= new HashMap<String ,Object>();
	List<XwJdEntity> doublejstbt = hxMapper.getjdsxqd(nf);
	map.put("dataCount", doublejstbt);
	map.put("title", "选择年份校外实训基地实习计划表");
	return map;
}

@Override
public TjCount getqyddpyxs() {
	Double qyddpyxs = 2000/(this.getTotalCountStu(null)*1.0);
	TjCount tjCount = new TjCount("tb4","企业订单培养学生所占比例",qyddpyxs);
	return tjCount;
}

@Override
public TjCount getqyzfjzkc() {
	Double jsjkzj=500000.0;
	TjCount tjCount = new TjCount("企业支付年教师讲课数",jsjkzj);
	return tjCount;
}
//年支付企业兼职教师薪酬同比图
@Override
public Map<String, Object> getnzfqyjzjstbt() {
	Map<String ,Object> map= new HashMap<String ,Object>();
	List<TjCount> list = new ArrayList<TjCount>();
	TjCount tjCount = new TjCount("2017",5000000);
	TjCount tjCount1 = new TjCount("2016",4516000);
	TjCount tjCount2 = new TjCount("2015",3980000);
	list.add(tjCount2);
	list.add(tjCount1);
	list.add(tjCount);
	map.put("dataCount", list);
	map.put("title", "年支付企业兼职教师课酬同比图");
	map.put("param1", "nf8");
	return map;
}

@Override
public TjCount getnzrzyjssjsj() {
	Integer jssjzs=hxMapper.getjssjsj();
	TjCount tjCount = new TjCount("实践天数",jssjzs);
	return tjCount;
}
//教师实践时间同比图
@Override
public Map<String, Object> getzyjssjtbt() {
	Map<String ,Object> map= new HashMap<String ,Object>();
	List<TjCount> list = new ArrayList<TjCount>();
	Integer jssjzs=hxMapper.getjssjsj();
	TjCount tjCount = new TjCount("2017",jssjzs);
	TjCount tjCount1 = new TjCount("2016",jssjzs-50);
	TjCount tjCount2 = new TjCount("2015",jssjzs-100);
	list.add(tjCount2);
	list.add(tjCount1);
	list.add(tjCount);
	map.put("dataCount", list);
	map.put("title", "年专任专业教师企业实践时间同比图");
	map.put("param1", "nf9");
	return map;
}

@Override
public TjCount getqytgxnsjjusbz() {
	Integer qytgxnsjjusbz=150;
   TjCount tjCount = new TjCount("企业提供的校内实践教学设备值","万元",qytgxnsjjusbz);
	return tjCount;
}
//企业提供的校内实践教学设备值同比图
@Override
public Map<String, Object> getqytgxnsjjxsbtbt() {
	TjCount tjCount = new TjCount("万元","2017",2000);
	TjCount tjCount1 = new TjCount("万元","2016",1500);
	TjCount tjCount2 = new TjCount("万元","2015",1800);
	Map<String ,Object> map= new HashMap<String ,Object>();
	List<TjCount> list = new ArrayList<TjCount>();
	list.add(tjCount2);
	list.add(tjCount1);
	list.add(tjCount);
	map.put("dataCount", list);
	map.put("title", "企业提供的校内实践教学设备值同比图");
	map.put("param1", "nf10");
	return map;
}

@Override
public List<TjCount> getbysjsjkstgl() {
	Double jskstgl = hxMapper.getbysjsjlsl();
	TjCount tjCount = new TjCount("毕业生考试通过率","zym1",jskstgl);
	List<TjCount> byszydata = new ArrayList<TjCount>();
	byszydata.add(tjCount);
	List<TjCount> byszy = hxMapper.getbyszy();
	for(TjCount t:byszy){
		byszydata.add(t);
	}
	return byszydata;
}

@Override
public Map<String, Object> getbysjsjkstgltbt(String zymc) {
	List<TjCount> list = hxMapper.getbysjsjkstgltbt(zymc);
	Map<String ,Object> map= new HashMap<String ,Object>();
	map.put("title", "毕业生计算机等级考试通过率同比图");
	map.put("dataCount", list);
	map.put("param1", "nf11");
	return map;
}

@Override
public TjCount getbyszyzgzshql() {
	Integer byssl = hxMapper.getbyssl();
	Integer hqzyzgzssl = hxMapper.getzyzgzshql();
	Double zgzshql = hqzyzgzssl/(byssl*1.0);
	TjCount tjCount = new TjCount("毕业生职业资格证书获取率","zym6",zgzshql);
	return tjCount;
}

@Override
public Map<String, Object> getbyszgzshqtbt(String zymc) {
	List<TjCount> list = hxMapper.getbyszgzshqtbt(zymc);
	Map<String ,Object> map= new HashMap<String ,Object>();
	map.put("dataCount", list);
	map.put("title", "毕业生职业资格证书获取率同比图");
	map.put("param1", "nf12");
	return map;
}

@Override
public Map<String, Object> getxznfzgzsmx(String nf,String zymc) {
	List<ZgzsEntity> zgzList=hxMapper.getzgzList(nf,zymc);
	Map<String ,Object> map= new HashMap<String ,Object>();
	map.put("dataCount", zgzList);
	map.put("title", "毕业生职业资格证书获取情况明细");
	map.put("table", true);
	return map;
}
//应届生就业率
@Override
public TjCount getzjjyl() {
	Double jyl=hxMapper.getzjjyl();
	TjCount tjCount1 = new TjCount("zjjyl","直接就业率",jyl);
	return tjCount1;
}
@Override
public Map<String ,Object> getzjjyltbt() {
	Map<String ,Object> map= new HashMap<String ,Object>();
	List<TjCount> list = new ArrayList<TjCount>();
	Double jyl=hxMapper.getzjjyl();
	TjCount tjCount = new TjCount("2017",(int)(jyl*100));
	TjCount tjCount1 = new TjCount("2016",(int)(jyl*0.9*100));
	TjCount tjCount2 = new TjCount("2015",(int)(jyl*0.7*100));
	list.add(tjCount2);
	list.add(tjCount1);
	list.add(tjCount);
	map.put("dataCount", list);
	map.put("param1", "nf13");
	map.put("title", "直接就业率同比图");
	return map;
}

@Override
public Map<String, Object> getjysmx(String nf) {
	Map<String ,Object> map= new HashMap<String ,Object>();
	List<ZgzsEntity> zglist=hxMapper.getzgzLi(nf);
	map.put("dataCount", zglist);
	map.put("title", nf+"直接就业情况明细表");
	map.put("table", true);
	return map;
}
//各专业学生数量柱形图
@Override
public List<TjCount> getgzyxsslbt() {
	List<TjCount> list = new ArrayList<TjCount>();
	TjCount tjCount = new TjCount();
	tjCount.setTitle("各专业学生数量同比图");
	tjCount.setParam1("zym");
	list.add(tjCount);
	List<TjCount> gzy=hxMapper.getfenzy();
	for(TjCount t:gzy){
		list.add(t);
	}
	return list;
}

@Override
public Map<String, Object> getgzyzxssltbt(String zym) {
	Map<String ,Object> map= new HashMap<String ,Object>();
	Integer zyxssl = hxMapper.getzyzxssltbt(zym);
	TjCount tjCount = new TjCount("2017",zyxssl);
	TjCount tjCount1 = new TjCount("2016",zyxssl*0.8);
	TjCount tjCount3 = new TjCount("2015",zyxssl*0.5);
	List<TjCount> zyxssls=new ArrayList<TjCount>();
	zyxssls.add(tjCount3);
	zyxssls.add(tjCount1);
	zyxssls.add(tjCount);
	List<TjCount> zyxq=hxMapper.getstuzy();
	map.put("dataCount1",zyxq);
	map.put("dataCount", zyxssls);
	map.put("title", "在校生数量同比图");
	map.put("param1", "njAndzym");
	return map;
}

@Override
public Map<String, Object> getxdxnxdzyxsmd(String nf, String zym) {
	Map<String ,Object> map= new HashMap<String ,Object>();
	List<StudentEntity> stuListbyZyNf = hxMapper.getstuListbyZyNf(nf,zym);
	List<TjCount> njList=hxMapper.getnjlist();
	map.put("dataCount1", njList);
	map.put("dataCount", stuListbyZyNf);
	map.put("title", "选中年份选择专业学生名单");
	return map;
}

@Override
public List<TjCount> getbxxy() {
	List<TjCount> zgy=hxMapper.getstuzy();
	for(TjCount z:zgy){
		int x=50+(int)(Math.random()*40);
		z.setXcount(x);
	}
	return zgy;
}

@Override
public List<TjCount> getjgsltbt() {
	List<TjCount> zyxssls=new ArrayList<TjCount>();
	zyxssls.add(new TjCount("xxjgtbt"));
	List<TjCount> jgsltbt=this.getjssltbt();
	
		zyxssls.addAll(jgsltbt);
	return zyxssls;
}

@Override
public List<TjCount> getzxstb() {
	List<TjCount> zxxssls=new ArrayList<TjCount>();
	zxxssls.add(new TjCount("zxsslbtt1"));
	List<TjCount> zxstbt=this.getzxsxstbt();
	for(TjCount t:zxstbt){
		zxxssls.add(t);
	}
	return zxxssls;
}

@Override
public List<TjCount> getxxzystbt1() {
	List<TjCount> getxxzystbt = this.getxxzystbt();
	return getxxzystbt;
}

@Override
public List<TjCount> getsjGwstbt() {
	List<TjCount> zxzysls=new ArrayList<TjCount>();
	TjCount tl=new TjCount("生均校内实践工位数同比图","nf73");
	zxzysls.add(tl);
	List<TjCount> mnxnsjgws = hxMapper.getmnxnsjgws();
	for(TjCount t:mnxnsjgws){
		Integer sjxnsjgws=this.getTotalCountStu(null)/t.getZcount();
		t.setZcount(sjxnsjgws);
		zxzysls.add(t);
	}
	return zxzysls;
}
@Override
public Map<String, Object> getssbtbt(){
	Map<String ,Object> map= new HashMap<String ,Object>();
	Integer zrjsCount = this.getZrjsCount();
	Integer totalCountStu = this.getTotalCountStu(null);
	Integer ssb=totalCountStu/zrjsCount;
	TjCount tjCount = new TjCount("2017",ssb*1);
	TjCount tjCount1 = new TjCount("2016",ssb*2);
	TjCount tjCount3 = new TjCount("2015",ssb*3);
	List<TjCount> zyxssls=new ArrayList<TjCount>();
	zyxssls.add(tjCount3);
	zyxssls.add(tjCount1);
	zyxssls.add(tjCount);
	map.put("dataCount", zyxssls);
	map.put("title", "生师比同比图");
	//map.put("param1", "nf32");
	return map;
}

@Override
public TjCount getfzyfmj() {
	Double fzyfzmj=hxMapper.getfzyfmj();
	TjCount fzyfz = new TjCount("辅助用房总面积","nf24",fzyfzmj);
	
	return fzyfz;
}

@Override
public Map<String, Object> getgjxfzyfmjqd() {
	Map<String ,Object> map= new HashMap<String ,Object>();
	List<XxmjEntity> ggzyfmj=hxMapper.getggzyfmj();
	map.put("dataCount", ggzyfmj);
	map.put("title", "各个辅助用房面积");
	map.put("table", true);
	return map;
}

@Override
public TjCount getshyfmj() {
	Double ghyfmj=hxMapper.getshyfzmj();
	TjCount ghyfzmj = new TjCount("生活用房总面积","nf26",ghyfmj);
	return ghyfzmj;
}

@Override
public Map<String, Object> getgshyfmjqd() {
	Map<String ,Object> map= new HashMap<String ,Object>();
	List<XxmjEntity> gshyfmj=hxMapper.getgshyfmj();
	map.put("dataCount", gshyfmj);
	map.put("title", "各个生活用房面积清单");
	map.put("table", true);
	return map;
}
@Override
public List<TjCount> gettysbtbt() {
	List<TjCount> zyxssls=new ArrayList<TjCount>();
	zyxssls.add(new TjCount("通用设备同比图","nf28"));
	zyxssls.add(new TjCount("2015",this.getsbzz()*0.6*0.6));
	zyxssls.add(new TjCount("2016",this.getsbzz()*0.6*0.8));
	zyxssls.add(new TjCount("2017",this.getsbzz()*0.6));
	return zyxssls;
}
@Override
public List<TjCount> getzysbtbt() {
	List<TjCount> zyxssls=new ArrayList<TjCount>();
	zyxssls.add(new TjCount("专业设备同比图","nf29"));
	zyxssls.add(new TjCount("2015",this.getsbzz()*0.4*0.6));
	zyxssls.add(new TjCount("2016",this.getsbzz()*0.4*0.8));
	zyxssls.add(new TjCount("2017",this.getsbzz()*0.4));
	return zyxssls;
}

@Override
public List<TjCount> getdkzztbt() {
	List<TjCount> dkzztbt=new ArrayList<TjCount>();
	dkzztbt.add(new TjCount("带宽增长同比图","nf30"));
	dkzztbt.add(new TjCount("2015",10));
	dkzztbt.add(new TjCount("2016",10));
	dkzztbt.add(new TjCount("2017",10));
	return dkzztbt;
}

@Override
public List<XxjbqkEntity> getxznfdkckmx(String nf) {
	List<XxjbqkEntity> kdxxjbqk=hxMapper.getkdxxjbqk(nf);
	return kdxxjbqk;
}

@Override
public List<TjCount> getwlxxjdzztbt() {
	List<TjCount> wlxxjd=hxMapper.getwlxxjd();
	List<TjCount> zyxssls=new ArrayList<TjCount>();
	zyxssls.add(new TjCount("网络信息节点增长同比图","nf31"));
	for(TjCount t:wlxxjd){
		zyxssls.add(t);
	}
	return zyxssls;
}

@Override
public List<TjCount> getxznfwlxxjdfb(String nf) {
	List<TjCount> jffb=hxMapper.getxxjdfb(nf);
	return jffb;
}

@Override
public TjCount getsjsbz() {
	Double sjsbz=this.getsbzz()/this.getTotalCountStu(null);
	TjCount tjCount = new TjCount("生均设备值","nf33",sjsbz);
	return tjCount;
}

@Override
public List<TjCount> getsjczbktbt() {
	List<TjCount> sjczbktbt=hxMapper.getsjczbktbt();
	return sjczbktbt;
}

@Override
public List<TjCount> getswkctbt1() {
	List<TjCount> swkctbt=hxMapper.getswkctbt();
	List<TjCount> zyxssls=new ArrayList<TjCount>();
	zyxssls.add(new TjCount("上网课程同比图","nf37"));
	for(TjCount t:swkctbt){
		zyxssls.add(t);
	}
	return zyxssls;
}

@Override
public TjCount getmbmjsjstbt1() {
	Integer getjsjsjyysl = this.getjsjsjyysl();
	TjCount tjCount1 = new TjCount("tb2","每百名拥有计算机数量",100/getjsjsjyysl);
	return tjCount1;
}

@Override
public TjCount getssbl() {
	Double ssbl=this.getTotalCountStu(null)/(this.getZrjsCount()*1.0);
	TjCount tjCount = new TjCount("tb3","生师比",ssbl);
	return tjCount;
}

@Override
public List<TjCount> getbxzjf() {
	List<TjCount> bxzjf=new ArrayList<TjCount>();
	List<TjCount> bxjf=hxMapper.getlnbxzjf();
	TjCount title = new TjCount("办学总经费同比变化图","nf46");
	bxzjf.add(title);
    bxzjf.addAll(bxjf);
	return bxzjf;
}

@Override
public List<TjCount> getjfly(String nf) {
	List<TjCount> jfly=hxMapper.getjfly(nf);
	return jfly;
}

@Override
public List<TjCount> getsjjftbt() {
	List<TjCount> bxzjf=hxMapper.getsjjftbt();
	return bxzjf;
}

@Override
public List<TjCount> getzyjftbt() {
	List<TjCount> zxjf=new ArrayList<TjCount>();
	List<TjCount> zyjftbt=hxMapper.getzyjftbt();
	TjCount title = new TjCount("万元","专项经费同比图","nf39");
	zxjf.add(title);
	zxjf.addAll(zyjftbt);
	return zxjf;
}

@Override
public List<TjCount> getxdnzyjfmx(String nf) {
	List<TjCount> zyjf=hxMapper.getzyjfmx(nf);
	return zyjf;
}

@Override
public List<Object> getjfkzdjt() {
	List<Object> jfkzdjt=new ArrayList<Object>();
	List<TjCount> lnjflzdjt=hxMapper.getjfkzdjt();
	TjCount title = new TjCount("经费开支分类堆积柱状图","nf41");
	jfkzdjt.add(title);
	for(TjCount t:lnjflzdjt){
		Tjlist tjlist = new Tjlist();
		List<TjCount> zfzc=hxMapper.getjfzscd(t.getMc());
		tjlist.setNf(t.getMc());
		tjlist.setTjList(zfzc);
		jfkzdjt.add(tjlist);
	}
	
	return jfkzdjt;
}

@Override
public List<TjCount> getxdnfdjflbt(String nf) {
	List<TjCount> lnkzsj1=hxMapper.getxdnfdjflbt(nf);
	return lnkzsj1;
}

@Override
public List<TjCount> getxdnfdjflmx(String nf, String lb) {
	List<TjCount> xdnfdjflmx = hxMapper.getxdnfdjflmx(nf,lb);
	return xdnfdjflmx;
}

@Override
public List<TjCount> getjxtrjetbt() {
	List<TjCount> jxtrjetbt=hxMapper.getjxsbtrjetbt();
	List<TjCount> lnkzsj1=new ArrayList<TjCount>();
	lnkzsj1.add(new TjCount("教学设备同比变化图","nf43"));
	for(TjCount t : jxtrjetbt){
		lnkzsj1.add(t);
	}
	return lnkzsj1;
}

@Override
public List<TjCount> getbxjfzcbt() {
	List<TjCount> bxjfzcbt = hxMapper.getbxjfzcbt();
	List<TjCount> lnkzsj1=new ArrayList<TjCount>();
	lnkzsj1.add(new TjCount("nf49","办学经费支出分类饼图"));
	for(TjCount t : bxjfzcbt){
		lnkzsj1.add(t);
	}
	return lnkzsj1;
}

@Override
public List<Object> getjssltbdjt(String zymc) {
	Integer zrfjzjssl=hxMapper.getzrfjz(zymc);
	Integer jzjssl=hxMapper.getjzjssl(zymc);
	TjCount title = new TjCount("教职工同比饼图","nf47","djt");
	
	TjCount tjCount = new TjCount("兼职",zrfjzjssl);
	TjCount tjCount1 = new TjCount("专任",jzjssl);
	List<TjCount> z1=new ArrayList<TjCount>();
	z1.add(tjCount);
	z1.add(tjCount1);
	Tjlist jtlist=new Tjlist("2017",z1);
	
	TjCount tjCount2 = new TjCount("兼职",zrfjzjssl-10);
	TjCount tjCount3 = new TjCount("专任",jzjssl-8);
	List<TjCount> z2=new ArrayList<TjCount>();
	z2.add(tjCount2);
	z2.add(tjCount3);
	Tjlist jtlist1=new Tjlist("2016",z2);
	
	TjCount tjCount4 = new TjCount("兼职",zrfjzjssl-15);
	TjCount tjCount5 = new TjCount("专任",jzjssl-10);
	List<TjCount> z3=new ArrayList<TjCount>();
	z3.add(tjCount4);
	z3.add(tjCount5);
	Tjlist jtlist2=new Tjlist("2015",z3);
	List<Object> list = new ArrayList<Object>();
	list.add(title);
	list.add(jtlist2);
	list.add(jtlist1);
	list.add(jtlist);
	return list;
}
@Override
public List<JzgEntity> getxznfzjzjs(String nf, String zym) {
	// TODO Auto-generated method stub
	List<JzgEntity> jzgs=hxMapper.getxznfzjzjs(zym, nf);
	return jzgs;
}

@Override
public List<TjCount> getzylist() {
	List<TjCount> jzsl=hxMapper.getzyList();
	return jzsl;
}

@Override
public List<TjCount> getzyjsbl() {
	Integer zyjsrs = hxMapper.getjscount();
	Integer jszCount=hxMapper.getzyJsCount();
	Double zybf = zyjsrs*1.0;
	Double dataCount = zybf/jszCount;
	List<TjCount> zyjsbl=new ArrayList<TjCount>();
	zyjsbl.add(new TjCount("专业教师占专任教师比例","nf48"));
	zyjsbl.add(new TjCount("2017",dataCount));
	zyjsbl.add(new TjCount("2016",dataCount));
	zyjsbl.add(new TjCount("2015",dataCount));
	return zyjsbl;
}

@Override
public List<TjCount> getssxjstbtzy(String zym) {
	Integer doublejs = hxMapper.getdoublejs();
	Integer jszCount=hxMapper.getzyJsCount();
	Double doublejsbfb=doublejs/(jszCount*1.0);
	List<TjCount> doublejstbt = new ArrayList<TjCount>();
	TjCount tjCount = new TjCount("2015",(int) (doublejsbfb*0.6*100));
	TjCount tjCount1 = new TjCount("2016",(int) (doublejsbfb*0.8*100));
	TjCount tjCount2 = new TjCount("2017",(int)(doublejsbfb*1.0*100));
	doublejstbt.add(tjCount);
	doublejstbt.add(tjCount1);
	doublejstbt.add(tjCount2);
	return doublejstbt;
}

@Override
public List<Object> getgjsfzysltbt() {
	Integer sfzysltbt = hxMapper.getsfzysltbt();
	List<Object> gjsfzytbt = new ArrayList<Object>();
	gjsfzytbt.add(new Title("国家示范专业数量同比图","nf51"));
	gjsfzytbt.add(new TjCount("2015",sfzysltbt-2));
	gjsfzytbt.add(new TjCount("2016",sfzysltbt-1));
	gjsfzytbt.add(new TjCount("2017",sfzysltbt));	
	return gjsfzytbt;
}

@Override
public List<ZyxxEntity> getsfzylist(String nf) {
	List<ZyxxEntity> sfzylist=hxMapper.getsfzylist(nf);
	return sfzylist;
}

@Override
public List<Object> szdzysltbt() {
	Integer szdsl = hxMapper.getszdzysl();
	List<Object> gjsfzytbt = new ArrayList<Object>();
	gjsfzytbt.add(new Title("省重点专业数量同比图","nf520"));
	gjsfzytbt.add(new TjCount("2015",szdsl-2));
	gjsfzytbt.add(new TjCount("2016",szdsl-1));
	gjsfzytbt.add(new TjCount("2017",szdsl));
	return gjsfzytbt;
}

@Override
public List<ZyxxEntity> getxzszdzymd(String nf) {
	List<ZyxxEntity> xzszdzymd=hxMapper.getxzszdzymd(nf);
	return xzszdzymd;
}

@Override
public List<Object> sppzysltbt() {
	Integer sppzysltbt=hxMapper.sppzysl();
	List<Object> gjsfzytbt = new ArrayList<Object>();
	gjsfzytbt.add(new Title("市品牌专业数量同比图","nf521"));
	gjsfzytbt.add(new TjCount("2015",sppzysltbt-2));
	gjsfzytbt.add(new TjCount("2016",sppzysltbt-1));
	gjsfzytbt.add(new TjCount("2017",sppzysltbt));
	return gjsfzytbt;
}

@Override
public List<TjCount> getlhflmj() {
	TjCount tjCount = new TjCount("绿化面积",this.getlhmj());
	TjCount tjCount1 = new TjCount("非绿化面积",this.getflhmj());
	List<TjCount> list = new ArrayList<TjCount>();
	list.add(new TjCount("绿化/非绿化面积","nf53"));
	list.add(tjCount);
	list.add(tjCount1);
	return list;
}

@Override
public List<TjCount> getxscfqmj() {
	TjCount tjCount = new TjCount("校舍学校产权面积",this.getxscqmj());
	TjCount tjCount1 = new TjCount("校舍非学校产权面积",this.getfxscqmj());
	List<TjCount> list = new ArrayList<TjCount>();
	list.add(new TjCount("校舍学校/非学校产权面积","nf54"));
	list.add(tjCount);
	list.add(tjCount1);
	return list;
}

@Override
public TjCount getxzbgyf() {
	Double xzbgyfmj=hxMapper.getxzbgyfmj();
	TjCount tjCount1 = new TjCount("行政办公用房面积","bg2",xzbgyfmj);
	return tjCount1;
}

@Override
public TjCount getjzzz() {
	Double jgzz=hxMapper.getjgzzmj();
	TjCount tjCount1 = new TjCount("教工住宅用房面积","bg3",jgzz);
	return tjCount1;
}
@Override
public TjCount getqtmj() {
	Double qtmj=hxMapper.getqtmj();
	TjCount tjCount1 = new TjCount("行政办公用房面积","bg4",qtmj);
	return tjCount1;
}

@Override
public List<KcEntity> getggkcqd() {
	List<KcEntity> ggkclist=hxMapper.getggkcqd();
	return ggkclist;
}

@Override
public List<KcEntity> getzykcqd() {
	List<KcEntity> zykclist=hxMapper.getzykcqd();
	return zykclist;
}

@Override
public List<ZyxxEntity> getxzszymd(String nf) {
	List<ZyxxEntity> xzszymd = hxMapper.getxzszymd(nf);
	return xzszymd;
}

@Override
public List<Object> getqttszytbt() {
	Integer szysl=hxMapper.getzysl();
	Integer qttszysl=szysl-hxMapper.getszdzysl()-hxMapper.sppzysl()-hxMapper.getsfzysltbt();
	List<Object> gjsfzytbt = new ArrayList<Object>();
	gjsfzytbt.add(new Title("其他特色专业数量同比图","nf52"));
	gjsfzytbt.add(new TjCount("2015",qttszysl-5));
	gjsfzytbt.add(new TjCount("2016",qttszysl-3));
	gjsfzytbt.add(new TjCount("2017",qttszysl));
	return gjsfzytbt;
}

@Override
public List<ZyxxEntity> getxznfqtzymd(String nf) {
	List<ZyxxEntity> xznfqtzymd = hxMapper.getqttszymd(nf);
	return xznfqtzymd;
}

@Override
public List<Object> getkcList1(String nf, String zym) {
	List<KcEntity> kcList=hxMapper.getkcList1(nf,zym);
	Title title = new Title("课程清单","nf57",null,true);
	List<TjCount> kczy = hxMapper.getkczy();
	List<TjCount> kcnj = hxMapper.getkcxn();
	List<Object> list = new ArrayList<Object>();
	list.add(title);
	list.add(kcList);
	list.add(kczy);
	list.add(kcnj);
	return list;
}

@Override
public List<Object> getjpkctbt() {
	List<TjCount> jpkc = hxMapper.getjpkctbt();
	Title title = new Title("精品课程数量同比图","nf58");
	List<Object> list = new ArrayList<Object>();
	list.add(title);
	list.add(jpkc);
	return list;
}

@Override
public List<KcEntity> getjpkcqd(String nf) {
	List<KcEntity> jpkcqd=hxMapper.getjpkcqd(nf);
	return jpkcqd;
}

@Override
public List<Object> getxztxkctbt() {
	List<TjCount> lnxzttkc=hxMapper.getlnxzttkc();
	Title title = new Title("新增淘汰课程同比图","nf59");
	List<Object> list = new ArrayList<Object>();
	list.add(title);
	list.add(lnxzttkc);
	return list;
}

@Override
public List<KcEntity> getxzttkclist(String nf) {
	List<KcEntity> jpkcqd=hxMapper.getxzttkcqd(nf);
	return jpkcqd;
}

@Override
public List<Object> getzxkctbt() {
	List<TjCount> zxkcstbt=hxMapper.getgnzxkcsl();
	Title title = new Title("在线教学课程数量同比图","nf60");
	List<Object> list = new ArrayList<Object>();
	list.add(title);
	list.add(zxkcstbt);
	return list;
}

@Override
public List<KcEntity> getnfzxkcqd(String nf) {
	List<KcEntity> jpkcqd=hxMapper.getxzttkcqd(nf);
	return jpkcqd;
}

@Override
public List<Object> getxssltbtcx(String lb, String nf, String zym, String dqmc) {
	Integer stusl=hxMapper.getstusl(lb,nf,zym,dqmc);
	TjCount tjCount = new TjCount("2017",stusl);
	TjCount tjCount1 = new TjCount("2016",stusl-50);
	TjCount tjCount2 = new TjCount("2015",stusl-100);
	List<Object> list = new ArrayList<Object>();
	list.add(new Title("学生数量同比图","nf61"));
	list.add(tjCount2);
	list.add(tjCount1);
	list.add(tjCount);

	return list;
}

@Override
public List<StudentEntity> getxsmd(String lb, String nf, String zym, String dqmc) {
	List<StudentEntity> stulist=hxMapper.getstumd(lb,nf,zym,dqmc);
	return stulist;
}

@Override
public List<TjCount> dqlist() {
	List<TjCount> dqlist=hxMapper.getdqlist();
	return dqlist;
}
@Override
public List<TjCount> stunj() {
	List<TjCount> stunj = hxMapper.getnjlist();
	return stunj;
}
@Override
public List<TjCount> getstuzy() {
	List<TjCount> stuzy=hxMapper.getstuzy();
	return stuzy;
}
@Override
public List<TjCount> pycc() {
	List<TjCount> pycc=hxMapper.getpycc();
	return pycc;
}

@Override
public List<Object> getstujkzs(String lb, String nf, String zym, String dqmc) {
	Double hg=5000*1.0/hxMapper.getstusl(lb,nf,zym,dqmc);
	TjCount tjCount = new TjCount("2017",hg);
	TjCount tjCount1 = new TjCount("2016",hg*0.9);
	TjCount tjCount2 = new TjCount("2015",hg*0.8);
	List<Object> stuslList = new ArrayList<Object>();
	stuslList.add(new Title("学生体质合格率同比图","nf56"));
	stuslList.add(tjCount2);
	stuslList.add(tjCount1);
	stuslList.add(tjCount);
	return stuslList;
}

@Override
public List<Object> getstujkqd(String lb, String nf, String zym, String dqmc) {
	List<TjCount> tzql=hxMapper.getstujkqd();
	List<Object> list = new ArrayList<Object>();
	list.addAll(tzql);
	return list;
}

@Override
public List<Object> getlnzsrstbt(String zym) {
	Integer zsrs=hxMapper.getxxzssl();
	TjCount tjCount = new TjCount("2017",zsrs);
	TjCount tjCount1 = new TjCount("2016",zsrs-10);
	TjCount tjCount2 = new TjCount("2015",zsrs-15);
	List<Object> stuslList = new ArrayList<Object>();
	stuslList.add(new Title("历年招生人数同比变化图","nf63"));
	stuslList.add(tjCount2);
	stuslList.add(tjCount1);
	stuslList.add(tjCount);
	return stuslList;
}

@Override
public List<Object> getxzzsmd(String nf,String zymc) {
	List<StudentEntity> stulist=hxMapper.getstuByZy(nf, zymc, null);
	List<Object> list = new ArrayList<Object>();
	list.addAll(stulist);
	return list;
}

@Override
public List<Object> getdjtbt(String lb) {
	List<TjCount> djsl=hxMapper.getgndjsl(lb);
	if("管".equals(lb)){
		for(TjCount t:djsl){
			t.setZcount((int)(t.getZcount()*0.3));
		}
	}if("技".equals(lb)){
		for(TjCount t:djsl){
			t.setZcount((int)(t.getZcount()*0.5));
		}
	}if("工".equals(lb)){
		for(TjCount t:djsl){
			t.setZcount((int)(t.getZcount()*0.2));
		}
	}
	List<Object> stuslList = new ArrayList<Object>();
	stuslList.add(new Title("党建同比图","nf337"));
	stuslList.addAll(djsl);
	return stuslList;
}
@Override
public List<TjCount> getgjg() {
	List<TjCount> lx=new ArrayList<TjCount>();
	TjCount tjCount = new TjCount("管");
	TjCount tjCount1 = new TjCount("技");
	TjCount tjCount2 = new TjCount("工");
	lx.add(tjCount);
	lx.add(tjCount1);
	lx.add(tjCount2);
	return lx;
}
@Override
public List<Object> getjyltbt() {
	TjCount jyqk=hxMapper.getjyqktbt();
	List<TjCount> jyqktbt=new ArrayList<TjCount>();
	Double jyl = jyqk.getXcount()*1.0/jyqk.getZcount();
	jyqktbt.add(new TjCount(jyqk.getMc(),jyl));
	jyqktbt.add(new TjCount("2016",jyl*0.9));
	jyqktbt.add(new TjCount("2015",jyl*0.8));
	List<Object> list = new ArrayList<Object>();
	list.add(new Title("就业率同比图","nf64"));
	list.add(jyqktbt);
	return list;
}

@Override
public List<TjCount> getxznfjyl(String nf) {
	List<TjCount> gzyjyl=hxMapper.getgzyjyl();
	//List<Object> list = new ArrayList<Object>();
	//list.add(new Title(nf+"年份各专业就业柱状图","nf65"));
	//list.add(gzyjyl);
	return gzyjyl;
}

@Override
public List<Object> getjyxsmd(String nf, String zymc) {
	List<TjCount> jyxsmd = hxMapper.getjyxsmd(nf,zymc);
	List<Object> list = new ArrayList<Object>();
	list.add(jyxsmd);
	return list;
}

@Override
public List<Object> gethzqytbt(String zymc) {
	List<TjCount> hzqysl=hxMapper.gethzqysl(zymc);
	List<TjCount> zylist=hxMapper.getzylist2();
	List<Object> list = new ArrayList<Object>();
	list.add(new Title("合作企业同比图","nf65"));
	list.add(hzqysl);
	list.add(zylist);
	return list;
}

@Override
public List<TjCount> xzqyjytbt(String mc) {
	Integer qyxss=hxMapper.getqyxssl(mc);
	List<TjCount> jyqktbt=new ArrayList<TjCount>();
	jyqktbt.add(new TjCount("2017",qyxss));
	jyqktbt.add(new TjCount("2016",qyxss*2));
	jyqktbt.add(new TjCount("2015",qyxss*3));
//	List<Object> list = new ArrayList<Object>();
//	list.add(jyqktbt);
	return jyqktbt;
}

@Override
public List<TjCount> getxzqyjymd(String mc, String nf) {
	List<TjCount> qyjymd=hxMapper.getqyjymd(mc,nf);
	//List<Object> list = new ArrayList<Object>();
	//list.add(qyjymd);
	return qyjymd;
}
@Override
public List<Object> getzjxsslpm(String nf){
	List<TjCount> qyjymd=hxMapper.getzjxsslpm(nf);
	List<Object> list = new ArrayList<Object>();
	list.add(new Title("在籍学生排名","nf339"));
	list.addAll(qyjymd);
	return list;
}
@Override
public List<TjCount> getgxnxsrs(String zymc){
	List<TjCount> xnxsmd=hxMapper.getgxnxsrs(zymc);
	
	return xnxsmd;
}
@Override
public List<TjCount> getzynjxsdbt(String nf, String zymc) {
	List<TjCount> gnjxssl=hxMapper.getgnjxssl(nf,zymc);
//	List<Object> list = new ArrayList<Object>();
//	list.add(gnjxssl);
	return gnjxssl;
}

@Override
public List<TjCount> getbjxssl(String nf, String zymc) {
	List<TjCount> gbjxssl=hxMapper.getbjxssl( nf, zymc);
//	List<Object> list = new ArrayList<Object>();
//	list.add(gbjxssl);
	return gbjxssl;
}

@Override
public List<StudentEntity> getgbjxsmd(String bh) {
	List<StudentEntity> stuList=hxMapper.stuListByBj(bh);
//	List<Object> list = new ArrayList<Object>();
//	list.add(stuList);
	return stuList;
}

@Override
public List<Object> getxslspm(String zymc) {
	List<TjCount> xslssl=hxMapper.getxslssl(zymc);
	List<Object> list = new ArrayList<Object>();
	list.add(new Title("学生流失数量排名","nf67"));
	list.addAll(xslssl);
	list.add(new TjCount("2015",50));
	list.add(new TjCount("2017",30));
	return list;
}

@Override
public List<Object> getxzxslsnjfbt(String nf, String zymc) {
	List<TjCount> lsnjxssl=hxMapper.getlsnjxssl(nf,zymc);
	List<Object> list = new ArrayList<Object>();
	list.add(new Title(nf+zymc+"各年级学生流失数量","nf72"));
	list.addAll(lsnjxssl);
	return list;
}

@Override
public List<Object> getzyjnpx(String zymc) {
	List<TjCount> zypxpm=hxMapper.getzypxpm(zymc);
	List<Object> list = new ArrayList<Object>();
	list.add(new Title("专业技能培训人次排名","nf342"));
	list.addAll(zypxpm);
	return list;
}

@Override
public List<Object> getggkcpjcjpm(String zymc, String kcmc, String nf) {
	List<TjCount> bjpjcj=hxMapper.getbjpjcj(zymc,kcmc,nf);
	List<Object> list = new ArrayList<Object>();
	list.add(new Title(nf+zymc+kcmc+"各班级学生成绩排名","nf77"));
	list.add(bjpjcj);
	return list;
}

@Override
public List<Object> getcjqgpm(String zymc,String kcmc) {
	List<Object> list=new ArrayList<Object>();
	list.add(new TjCount("2015","68"));
	list.add(new TjCount("2016","60"));
	list.add(new TjCount("2017","50"));
	return list;
}

@Override
public List<Object> getcjqgpm(String zymc, String kcmc, String nf) {
	List<StuCj> cjList=hxMapper.getcjList(zymc, kcmc,nf);
	List<Object> list = new ArrayList<Object>();
	list.add(cjList);
	return list;
}

@Override
public List<Object> gethqzsbl(String nf) {
	List<TjCount> hqzsbl=hxMapper.gethqzsbl(nf);
	List<Object> list = new ArrayList<Object>();
	list.add(new Title("获取证书学生比例排名","nf80"));
	list.add(hqzsbl);
	return list;
}

@Override
public List<Object> getlnzshqtbt(String zym) {
	Integer hqzyzgzssl = hxMapper.getzyzgzshlqlbyzy(zym);
	TjCount tjCount = new TjCount("2017",hqzyzgzssl);
	TjCount tjCount1 = new TjCount("2016",hqzyzgzssl-8);
	TjCount tjCount2 = new TjCount("2015",hqzyzgzssl-5);
	List<Object> list=new ArrayList<Object>();

	list.add(tjCount2);
	list.add(tjCount1);
	list.add(tjCount);
	
	return list;
}

@Override
public List<ZgzsEntity> gethqzsxsmx(String zym, String nf) {
	List<ZgzsEntity> hqzsxs=hxMapper.gethqzsxs(zym,nf);
//	List<Object> list=new ArrayList<Object>();
//	list.add(hqzsxs);
	return hqzsxs;
}

@Override
public List<Object> getzyjsbl2(String zymc) {
	List<Object> list = new ArrayList<Object>();
	list.add(this.getzyjsbl());
	return list;
}

@Override
public List<Object> getssxjstbtzy1(String zym) {
	List<Object> list = new ArrayList<Object>();
	list.add(new Title("双师型教师比例同比图分专业","nf83"));
	list.addAll(this.getssxjstbtzy(zym));
	return list;
}

@Override
public List<Object> getzjjssl(String nf) {
	List<TjCount> zjjssl=hxMapper.getzjjssl(nf);
	List<Object> list=new ArrayList<Object>();
	list.add(new Title("中级以上教师数量同比图","nf84"));
	list.addAll(zjjssl);
	
	return list;
}

@Override
public List<Object> getgzypjxc(String nf) {
	List<TjCount> pjxcpm = hxMapper.getzyxcpm(nf);
	List<Object> list=new ArrayList<Object>();
	list.add(new Title("平均薪资排名(元)","nf85"));
	list.add(pjxcpm);
	return list;
}

@Override
public List<TjCount> getxzzyxztbt(String zymc) {
	List<TjCount> zyxztbt=hxMapper.getzyxztbt(zymc);
//	List<Object> list=new ArrayList<Object>();
//	list.add(zyxztbt);
	return zyxztbt;
}

@Override
public List<BysxzEntity> getbysxzmx(String nf, String zymc) {
	List<BysxzEntity> bysxzmx=hxMapper.getbysxzmx(nf,zymc);
//	List<Object> list=new ArrayList<Object>();
//	list.add(bysxzmx);
	return bysxzmx;
}
@Override
public List<TjCount> getbysjymx(String nf, String zymc) {
	List<TjCount> bysxzmx=hxMapper.getbysjymx(nf,zymc);
	return bysxzmx;
}
@Override
public List<Object> getgzyjylpm(String nf) {
	List<TjCount>  jylpm = hxMapper.getgzyjylpm(nf);
	List<Object> list=new ArrayList<Object>();
	list.add(new Title("各专业就业率","nf88"));
	list.add(jylpm);
	return list;
}

@Override
public List<Object> getxzzyjyl(String zymc) {
	List<TjCount> jyltbt=hxMapper.getzyjytbt(zymc);
	List<Object> list=new ArrayList<Object>();
	list.add(jyltbt);
	return list;
}

@Override
public List<Object> getxzzyjyl(String nf, String zymc) {
	List<BysxzEntity> bysjymx=hxMapper.getbysxzmx(nf,zymc);
	List<Object> list=new ArrayList<Object>();
	list.add(bysjymx);
	return list;
}

@Override
public List<Object> gebysmyd(String nf) {
	List<TjCount> bysmyd=hxMapper.getbysmydpm(nf);
	List<Object> list=new ArrayList<Object>();
	list.add(new Title(nf+"毕业生满意度排名","nf245"));
	list.addAll(bysmyd);
	return list;
}

@Override
public List<Object> getsjgwpm() {
	List<TjCount> sjgwpm=hxMapper.getsjgwpm();
	List<Object> list=new ArrayList<Object>();
	list.add(new Title("生均工位数排名","nf90"));
	list.add(sjgwpm);
	return list;
}

@Override
public List<Object> getsbjepm() {
	List<TjCount> sbjepm=hxMapper.getsbjepm();
	List<Object> list=new ArrayList<Object>();
	list.add(new Title("设备金额排名","nf92"));
	list.addAll(sbjepm);
	return list;
}

@Override
public List<Object> getkyslpm(String nf) {
	List<TjCount> kyslpm=hxMapper.getkyslpm(nf);
	List<Object> list=new ArrayList<Object>();
	list.add(new Title(nf+"各专业科研数量排名","nf94"));
	list.addAll(kyslpm);
	return list;
}

@Override
public List<Object> getxwjdslpm(String nf) {
	List<TjCount> xwjdpm=hxMapper.getxwjdslpm(nf);
	List<Object> list=new ArrayList<Object>();
	list.add(new Title(nf+"各专业校外实训基地数量排名","nf95"));
	list.addAll(xwjdpm);
	return list;
}

@Override
public List<Object> getxzjdmx(String nf, String zymc) {
	List<XwJdEntity> xwjdmx= hxMapper.getxwjdmx(nf,zymc);
	List<Object> list=new ArrayList<Object>();
	list.addAll(xwjdmx);
	return list;
}

@Override
public List<Object> getxssltbzzt() {
	List<Object> list=new ArrayList<Object>();
	List<TjCount> xssltbt=hxMapper.getxssltbt();
	list.add(new Title("新生数量同比图","nf601"));
	list.addAll(xssltbt);
	return list;
}

@Override
public List<Object> getzyyxsslbt(String nf) {
	List<TjCount> gzyxssl=hxMapper.getgzyxssl(nf);
	List<Object> list=new ArrayList<Object>();
	list.addAll(gzyxssl);
	return list;
}

@Override
public List<Object> getxzxsmx(String nf, String zymc,String lb) {
	List<StudentEntity> xsmx=  hxMapper.getstuByZy(nf,zymc,lb);
	List<Object> list=new ArrayList<Object>();
	list.addAll(xsmx);
	return list;
}

@Override
public List<Object> getxszyfbt() {
	List<TjCount> gzyxssl=hxMapper.getxszysl();
	List<Object> list=new ArrayList<Object>();
	list.add(new Title("新生专业分布图","nf96"));
	list.addAll(gzyxssl);
	return list;
}

@Override
public List<Object> getlnzyxssl(String zymc) {
	List<TjCount> lnzyxssl=hxMapper.getlnzyxssl(zymc);
	List<Object> list=new ArrayList<Object>();
	list.addAll(lnzyxssl);
	return list;
}

@Override
public List<Object> getxsjyflfb() {
	List<TjCount> xsjyflfb=hxMapper.getxsjyflfb();
	List<Object> list=new ArrayList<Object>();
	list.add(new Title("新生教育分类分布","nf99"));
	list.addAll(xsjyflfb);
	return list;
}

@Override
public List<Object> getlxxstbt(String lb) {
	List<TjCount> xzflxstbt=hxMapper.getxzflxstbt(lb);
	List<Object> list=new ArrayList<Object>();
	list.addAll(xzflxstbt);
	return list;
}

@Override
public List<TjCount> getbjlist() {
	List<TjCount> bjlist=hxMapper.getbjlist();
	return bjlist;
}

@Override
public List<Object> getagegb(String bh, String zymc) {
	List<TjCount> agefb=hxMapper.getstuage(bh,zymc);
	List<Object> list=new ArrayList<Object>();
	list.add(new Title("年龄分布","nf101"));
	list.add(agefb);
	return list;
}

@Override
public List<Object> getnlfbmx(String bh, String zymc,String aged) {
	List<StudentEntity> xsnlfb=hxMapper.getstuagefb(bh,zymc,aged);
	List<Object> list=new ArrayList<Object>();
	list.add(xsnlfb);
	return list;
}

@Override
public List<Object> getxsxbfb(String bh, String zymc) {
	List<TjCount> xsxbfb=hxMapper.getxsxbfb(bh,zymc);
	List<Object> list=new ArrayList<Object>();
	list.add(new Title("性别分布","nf103"));
	list.add(xsxbfb);
	return list;
}

@Override
public List<Object> getxbxsmx(String bh, String zymc, String lb) {
	List<StudentEntity> xbxsmx=hxMapper.getxbxsmx(bh,zymc,lb);
	List<Object> list=new ArrayList<Object>();
	list.add(xbxsmx);
	return list;
}

@Override
public List<Object> getssmzfb(String bh, String zymc) {
	List<TjCount> ssmzfb=hxMapper.getssmzfb(bh,zymc);
	List<Object> list=new ArrayList<Object>();
	list.add(new Title("少数民族分布","nf105"));
	list.add(ssmzfb);
	return list;
}

@Override
public List<Object> getssmzmx(String bh, String zymc, String lb) {
	List<StudentEntity> ssmzmx=hxMapper.getssmzmx(bh,zymc,lb);
	List<Object> list=new ArrayList<Object>();
	list.add(ssmzmx);
	return list;
}
@Override
public List<Object> getxssyzl( String zymc) {
	List<TjCount> xssyzl=hxMapper.getxssyzl(zymc);
	List<Object> list=new ArrayList<Object>();
	list.add(new Title("生源质量","nf107"));
	list.add(xssyzl);
	return list;
}

@Override
public List<Object> getxzcjmx(String bh, String zymc, String lb) {
	List<StuCj> xzcjmx=hxMapper.getxzcjmx(bh,zymc,lb);
	List<Object> list=new ArrayList<Object>();
	list.add(xzcjmx);
	return list;
}
@Override
public List<Object> getdxsslbl(String zymc){
	List<Object> xsslbl=new ArrayList<Object>();
	xsslbl.add(new Title("定向生数量同比变化图","nf108"));
	xsslbl.add(new TjCount("2015",0.3));
	xsslbl.add(new TjCount("2016",0.3));
	xsslbl.add(new TjCount("2017",0.4));
	return xsslbl;
}
@Override
public List<Object> getdxssl(String zymc){
	List<Object> xssl=new ArrayList<Object>();
	xssl.add(new Title("定向生数量同比变化图","nf109"));
	xssl.add(new TjCount("2015",800));
	xssl.add(new TjCount("2016",850));
	xssl.add(new TjCount("2017",900));
	return xssl;
}

@Override
public List<Object> getdxsmx(String nf, String zymc) {
	List<StudentEntity> dxslist=hxMapper.getdxsmx(nf,zymc);
	List<Object> xssl=new ArrayList<Object>();
	xssl.addAll(dxslist);
	return xssl;
}

@Override
public List<Object> getrxqdtbt() {
	List<Object> list=new ArrayList<Object>();
	List<TjCount> lnrxqd=hxMapper.getrxqdtbt();
	list.add(new Title("入学渠道同比变化图","nf104"));
	list.addAll(lnrxqd);
	return list;
}

@Override
public List<Object> getgzyrxqd(String mc) {
	List<TjCount> gxyrxqd=hxMapper.getgrxqdtbt(mc);
	List<Object> xssl=new ArrayList<Object>();
	xssl.add(gxyrxqd);
	return xssl;
}
@Override
public List<Object> getzyqdxsmd(String zymc, String mc){
	List<TjCount> zyqdxsmd=hxMapper.getzyqdxsmd(zymc,mc);
	List<Object> xssl=new ArrayList<Object>();
	xssl.add(zyqdxsmd);
	return xssl;
}
@Override
public List<Object> getbdrytbt(String lb, String zymc) {
	List<TjCount> bdrytbt = hxMapper.getbdry(lb,zymc);
	List<Object> xssl=new ArrayList<Object>();
	xssl.addAll(bdrytbt);
	return xssl;
}
//毕业生资格证书获取率同比图
@Override
public List<TjCount> getbyszy1() {
	List<TjCount> byszy1=hxMapper.getbyszy();
	return byszy1;
}

@Override
public List<Object> getlndkjy(String zymc) {
	List<TjCount> lndkjysl=hxMapper.getdkjysl(zymc);
	List<Object> xssl=new ArrayList<Object>();
	xssl.add(new Title("历年对口就业数量","nf110"));
	xssl.add(lndkjysl);
	return xssl;
}

@Override
public List<Object> getlndkjybl(String zymc) {
	List<TjCount> lndkjybl=hxMapper.getlndkjybl(zymc);
	List<Object> xssl=new ArrayList<Object>();
	xssl.add(new Title("历年对口就业数量比例","nf112"));
	xssl.add(lndkjybl);
	return xssl;
}

@Override
public List<Object> getdkjyxsmx(String nf, String zymc) {
	List<ZgzsEntity> dkjy=hxMapper.getdkjyxsmx(nf,zymc);
	List<Object> xssl=new ArrayList<Object>();
	xssl.add(dkjy);
	return xssl;
}

@Override
public List<Object> getghypxb(String zymc) {
	List<TjCount> ghyxssl=hxMapper.getghypx(zymc);
	List<Object> list=new ArrayList<Object>();
	list.add(new Title("各行业就业排名","nf113",null,true));
	list.add(ghyxssl);
	return list;
}

@Override
public List<Object> getxzhytbt(String lb) {
	List<TjCount> xzhytbt = hxMapper.hyjytbt(lb);
	List<Object> xssl=new ArrayList<Object>();
	xssl.add(xzhytbt);
	return xssl;
}

@Override
public List<Object> gethyjymx(String lb) {
	List<ZgzsEntity> hyjymx=hxMapper.gethyjymx(lb);
	List<Object> xssl=new ArrayList<Object>();
	xssl.add(hyjymx);
	return xssl;
}

@Override
public List<Object> getsxxxpm(String zymc, String nf) {
	List<TjCount> sxxxpm=hxMapper.getsxxxpm(zymc,nf);
	List<Object> list=new ArrayList<Object>();
	list.add(new Title("升学学校排名","nf114",null,true));
	list.add(sxxxpm);
	return list;
}

@Override
public List<Object> getlnsxxxtbt(String mc) {
	List<TjCount> lnsxsl=hxMapper.getlnsxsl(mc);
	List<Object> xssl=new ArrayList<Object>();
	xssl.add(lnsxsl);
	return xssl;
}

@Override
public List<Object> getxzxxsxmx(String nf, String mc) {
	List<ZgzsEntity> xzxxsxmx=hxMapper.getxzxxsxmx(nf,mc);
	List<Object> list=new ArrayList<Object>();
	list.add(xzxxsxmx);
	return list;
}

@Override
public List<Object> getjyqdbt() {
	List<TjCount> jyqdsl=hxMapper.getjyqdbt();
	List<Object> list=new ArrayList<Object>();
	list.add(new Title("就业渠道饼图","nf117",null,"bt"));
	list.add(jyqdsl);
	return list;
}

@Override
public List<Object> getxzqdlntbt(String mc) {
	List<TjCount> lnjyqdjysl=hxMapper.getqdlnjysl(mc);
	List<Object> list=new ArrayList<Object>();
	list.add(lnjyqdjysl);
	return list;
}

@Override
public List<Object> getxzqdjymx(String mc, String nf) {
	List<ZgzsEntity> qdjymx=hxMapper.getqdjymx(mc,nf);
	List<Object> list=new ArrayList<Object>();
	list.add(qdjymx);
	return list;
}

@Override
public List<TjCount> getdgsxqy() {
	List<TjCount> dgsxqy=hxMapper.getdgsxqy();
	return dgsxqy;
}

@Override
public List<Object> getdgsxrs(String zymc, String mc) {
	List<TjCount> lndgsxrs=hxMapper.getlndgsxrs(zymc,mc);
	List<Object> list=new ArrayList<Object>();
	list.add(new Title("历年顶岗实习同比图","nf119"));
	list.add(lndgsxrs);
	return list;
}

@Override
public List<Object> getdgsxmx(String mc, String zymc, String nf) {
	List<DgsxEntity> dgsxmx=hxMapper.getdgsxmx(nf,zymc,mc);
	List<Object> list=new ArrayList<Object>();
	list.add(dgsxmx);
	return list;
}

@Override
public List<Object> getdghlytbt(String zymc, String mc) {
	List<TjCount> dgsxly=hxMapper.getdgsxhly(zymc,mc);
	List<Object> list=new ArrayList<Object>();
	list.add(new Title("历年顶岗实训后录用同比图","nf120"));
	list.add(dgsxly);
	return list;
}

@Override
public List<Object> getdgsxlymx(String mc, String zymc, String nf) {
	List<DgsxEntity> dgsxhlymx=hxMapper.getdgsxhymx(mc,zymc,nf);
	List<Object> list=new ArrayList<Object>();
	list.add(dgsxhlymx);
	return list;
}

@Override
public List<Object> getdglylbht(String zymc, String mc) {
	List<TjCount> lndglyl=hxMapper.getlndglyl(zymc,mc);
	List<Object> list=new ArrayList<Object>();
	list.add(new Title("历年顶岗实训后录率同比变化图","nf121"));
	list.add(lndglyl);
	return list;
}

@Override
public List<Object> getghzqyjy(String mc) {
	List<TjCount> ghzqyjy=hxMapper.getghzqyjy(mc);
	List<Object> list=new ArrayList<Object>();
	list.add(new Title("各合作企业就业人数同比变化图","nf122"));
	list.add(ghzqyjy);
	return list;
}

@Override
public List<Object> getxzqyjymx(String mc, String nf) {
	List<DgsxEntity> xzqyjymx=hxMapper.getxzqyjymx(mc,nf);
	List<Object> list=new ArrayList<Object>();
	list.add(xzqyjymx);
	return list;
}

@Override
public List<TjCount> getjyszy() {
	List<TjCount> jyszy=hxMapper.getjyszy();
	return jyszy;
}

@Override
public List<Object> getbydyfbt(String zymc) {
	List<TjCount> jydysl=hxMapper.getjydysl(zymc);
	List<Object> list=new ArrayList<Object>();
	list.add(new Title("各区域就业分布图","nf123"));
	list.add(jydysl);
	return list;
}

@Override
public List<Object> getxdyjytbt(String zymc, String mc) {
	List<TjCount> gdybyssl=hxMapper.getxdyjysl(zymc,mc);
	List<Object> list=new ArrayList<Object>();
	list.add(gdybyssl);
	return list;
}

@Override
public List<Object> getbysdymx(String zymc, String mc, String nf) {
	List<ZgzsEntity> bysdymx = hxMapper.getbysdymx(zymc,mc,nf);
	List<Object> list=new ArrayList<Object>();
	list.add(bysdymx);
	return list;
}

@Override
public List<Object> getdwmyd(String zymc) {
	List<TjCount> dwmyd = hxMapper.getdwmyd(zymc);
	List<Object> list=new ArrayList<Object>();
	list.add(new Title("用人单位满意度","nf125"));
	list.add(dwmyd);
	return list;
}

@Override
public List<Object> getgqymydmx(String nf) {
	List<TjCount> gqymydmc=hxMapper.getgqymydmx(nf);
	List<Object> list=new ArrayList<Object>();
	list.add(gqymydmc);
	return list;
}

@Override
public List<Object> getbysxzfb(String lb, String nf, String zymc) {
	List<TjCount> bysxzfb=hxMapper.getbysxzfb(lb,nf,zymc);
	List<Object> list=new ArrayList<Object>();
	list.add(new Title("毕业生薪资分布图","nf126"));
	list.add(bysxzfb);
	return list;
}

@Override
public List<Object> getxzbfxzmx(String lb, String nf, String zymc, String dg) {
	List<ZgzsEntity> xzm=hxMapper.getxzbfxzmx(lb,nf,zymc,dg);
	List<Object> list=new ArrayList<Object>();
	list.addAll(xzm);
	return list;
}

@Override
public List<Object> lnbysxcbht(String lb, String zymc) {
	List<TjCount> lnbysxc=hxMapper.getlnbysxc(lb,zymc);
	List<Object> list=new ArrayList<Object>();
	list.add(new Title("历年毕业生薪资分布图","nf127"));
	list.addAll(lnbysxc);
	return list;
}
//选定专业师生比同比图
@Override
public List<TjCount> getxdzyssbtbt(String zym) {
	TjCount t=hxMapper.getxdzyssbtbt(zym);
	Integer ggjs=hxMapper.getggjssl();
	Double bl=0.0;
		if(t.getXcount()>0){
			t.setXcount(t.getXcount()+((t.getZcount()*ggjs)/this.getTotalCountStu(null)));
			bl=t.getZcount()/t.getXcount()*1.0;
		}else{
			t.setXcount(((t.getZcount()*ggjs)/this.getTotalCountStu(null)));
			bl=t.getZcount()/t.getXcount()*1.0;
		}
	List<TjCount> jslist=new ArrayList<TjCount>();
	jslist.add(new TjCount("2017",bl));
	jslist.add(new TjCount("2016",bl*0.9));
	jslist.add(new TjCount("2015",bl*0.75));
	return jslist;
}
//选定专业教师数量同比图
@Override
public List<TjCount> getxdzyjssltbt(String zym) {
	Integer zymc=hxMapper.getxdzyjssl(zym);
	Integer zsl=zymc+hxMapper.getggjssl();
	List<TjCount> jslist=new ArrayList<TjCount>();
	jslist.add(new TjCount("当前选择的专业历年讲师数量同比图","nf201"));
	jslist.add(new TjCount("2017",zsl));
	jslist.add(new TjCount("2016",zsl*0.9));
	jslist.add(new TjCount("2015",zsl*0.75));
	return jslist;
}
//选定年和专业教师详情
@Override
public List<JzgEntity> getxdzynfjsmd(String zym, String nf) {
	List<JzgEntity> xdzynfjsmd=hxMapper.getxdzynfjsmd(zym,nf);
	//List<JzgEntity> ggjslist=hxMapper.ggjslist();
	if(!xdzynfjsmd.isEmpty()){
		for(JzgEntity x:xdzynfjsmd){
			x.setLx("专业教师");
		}
	}
//	for(JzgEntity gg:ggjslist){
//		gg.setLx("公共课讲师");
//	}
//	xdzynfjsmd.addAll(ggjslist);
	return xdzynfjsmd;
}
//选中专业学生数量同比图
@Override
public List<TjCount> getlnbmxssltb(String zym) {
	List<TjCount> lnbmxssltb=hxMapper.getlnbmxssltb(zym);
	List<TjCount> jslist=new ArrayList<TjCount>();
	jslist.add(new TjCount("当前选择的专业历年学生数量同比图","nf202"));
	jslist.addAll(lnbmxssltb);
	return jslist;
}
//当前年份，当前专业的学生明细
@Override
public List<StudentEntity> getydbmxsmd(String zym, String nf) {
	List<StudentEntity> stulist=hxMapper.getydbmxsmd(nf,zym);
	return stulist;
}
//各专业教师占专任教师比例
@Override
public List<TjCount> getgzyjsbl() {
	List<TjCount> gzyjsbl=hxMapper.getgzyjsbl();
	for (TjCount tjCount : gzyjsbl) {
		System.out.println("=========="+tjCount.getDm());
		if(tjCount.getDm()==null){
			System.out.println("=========="+tjCount.getDm());
			gzyjsbl.remove(tjCount);
			break;
		}
	}
	return gzyjsbl;
}

@Override
public List<Object> getgzyzrjssl() {
	List<TjCount> gzyzrjssl=hxMapper.getgzyzrjssl();
	List<Object> jslist=new ArrayList<Object>();
	jslist.add(new TjCount("各专业专任教师数量饼图","nf204",null,"bt"));
	jslist.addAll(gzyzrjssl);
	return jslist;
}
//各专业高级职务者比例
@Override
public List<Object> getgzyzrjsb() {
	List<TjCount> gzyjsb=hxMapper.getgzygjjs();
	List<Object> list=new ArrayList<Object>();
	list.addAll(gzyjsb);
	return list;
}
//选定专业的高级职务者数量同比图
@Override
public List<Object> getlnxdgjzwsl(String zymc) {
	List<TjCount> zs=hxMapper.zygjzwsl(zymc);
	List<Object> list=new ArrayList<Object>();
	list.addAll(zs);
	return list;
}
//选定年份专业高级职务者名单
@Override
public List<Object> getgjzwmd(String nf, String zymc) {
	List<JzgEntity> jzggjlist=hxMapper.getgjzwmd(nf,zymc);
	List<Object> list=new ArrayList<Object>();
	list.addAll(jzggjlist);
	return list;
}
//各专业双师型教师比例
@Override
public List<Object> getgzyssxsjbl() {
	List<TjCount> gzyssxjsbl = hxMapper.gzyssxjsbl();
	List<Object> list=new ArrayList<Object>();
	list.addAll(gzyssxjsbl);
	return list;
}
//双师型教师比例同比图
@Override
public List<Object> getxdzyssxjsbl(String zymc) {
	List<TjCount> bl=hxMapper.getxdzyssxjsbl(zymc);
	List<Object> list=new ArrayList<Object>();
	list.addAll(bl);
	return list;
}
//选定年份专业双师型教师名单
@Override
public List<Object> getxdssxjsmd(String nf, String zymc) {
	List<JzgEntity> ssjzglist=hxMapper.getxdssxjsmd(nf,zymc);
	List<Object> list=new ArrayList<Object>();
	list.addAll(ssjzglist);
	return list;
}
//报刊类型数量
@Override
public TjCount getqklxsl() {
	Integer sl=hxMapper.getqklxsl();
	TjCount bksl=new TjCount("报刊数量","nf211",sl);
	return bksl;
}
//学校报刊种类同比图
@Override
public List<Object> bktbt() {
	List<TjCount> bktbt=hxMapper.getlnqklxsl();
	List<Object> list=new ArrayList<Object>();
    list.addAll(bktbt);
	return list;
}
//教职工阅览室座位数
@Override
public TjCount getjzgylszw() {
	Integer jzgyls=(int) (this.getZrjsCount()*0.2);
	TjCount bksl=new TjCount("教职工阅览室座位数","nf212",jzgyls);
	return bksl;
}
//学生阅览室座位数
@Override
public TjCount getxsylszw() {
	Integer xsgyls=(int) (this.getTotalCountStu(null)*0.15);
	TjCount bksl=new TjCount("学生阅览室座位数","nf2121",xsgyls);
	return bksl;
}
//学生阅览室座位数同比图
@Override
public List<Object> getxsyls() {
	Integer xsyls=(int) (this.getTotalCountStu(null)*0.15);
	List<Object> list=new ArrayList<Object>();
	list.add(new TjCount("2015",(int)(xsyls*0.8)));
	list.add(new TjCount("2016",(int)(xsyls*0.9)));
	list.add(new TjCount("2017",xsyls));
	return list;
}
//教职工阅览室座位数同比图
@Override
public List<Object> getjzgyls() {
	Integer jzgyls=(int) (this.getZrjsCount()*0.2);
	List<Object> list=new ArrayList<Object>();
	list.add(new TjCount("2015",(int)(jzgyls*0.8)));
	list.add(new TjCount("2016",(int)(jzgyls*0.9)));
	list.add(new TjCount("2017",jzgyls));
	return list;
}

@Override
public List<Object> getbkflbt(String nf) {
    List<TjCount> bkfl=hxMapper.getbkflbt(nf);
    List<Object> list=new ArrayList<Object>();
	list.addAll(bkfl);
	return list;
}

@Override
public List<Object> getbkflmx(String nf, String mc) {
	List<TjCount> bkjemc=hxMapper.getbkflmx(nf,mc);
	List<Object> list=new ArrayList<Object>();
	list.addAll(bkjemc);
	return list;
}

@Override
public List<Object> getxzsbqd(String nf) {
	List<TjCount> xzsbqd=hxMapper.getxzsbqd(nf);
	List<Object> list=new ArrayList<Object>();
	list.addAll(xzsbqd);
	return list;
}

@Override
public List<Object> getsjjxfzyf() {
	Double jxyfmj=hxMapper.getjxyfmj();
	Double sjjxyfmj=jxyfmj/hxMapper.totalCountStudent(null);
	List<Object> list=new ArrayList<Object>();
	list.add(new TjCount("2015",sjjxyfmj*0.75));
	list.add(new TjCount("2016",sjjxyfmj*0.9));
	list.add(new TjCount("2017",sjjxyfmj));
	return list;
}

@Override
public List<TjCount> getxzjxfzyf(String nf) {
	List<TjCount> yf=hxMapper.getxzjxyf(nf);
	return yf;
}

@Override
public List<Object> getxzxzbgqd(String nf) {
	List<TjCount> xzyf=hxMapper.getxzxzbgqd(nf);
	List<Object> list=new ArrayList<Object>();
	list.addAll(xzyf);
	return list;
}

@Override
public List<Object> getxzjsjqd(String nf) {
	List<TjCount> xzjsj=hxMapper.getxzjsjqd(nf);
	List<Object> list=new ArrayList<Object>();
	list.addAll(xzjsj);
	return list;
}

@Override
public List<TjCount> getwldmtjsmx(String nf) {
	List<TjCount> wldmtmx=hxMapper.getwldmtmx(nf);	
	return wldmtmx;
}

@Override
public List<TjCount> getjxgwxq(String nf) {
	List<TjCount> jxgwxq=hxMapper.getjxgwxq(nf);
	return jxgwxq;
}
//年支付兼职教师课酬清单
@Override
public List<TjCount> getjszylist() {
	List<TjCount> jslist=hxMapper.getjszylist();
	return jslist;
}

@Override
public List<Object> getsjxwjssysj() {
	Integer xwjdsyts = hxMapper.getxwjdsyts();
	Integer jdjdxsl = hxMapper.getjdjdxsl();
	Integer stuCount = this.getTotalCountStu(null);
	Double sjjdsyts = xwjdsyts/(stuCount/(jdjdxsl*1.0));
	List<Object> list=new ArrayList<Object>();
	list.add(new TjCount("2015",sjjdsyts*0.75));
	list.add(new TjCount("2016",sjjdsyts*0.9));
	list.add(new TjCount("2017",sjjdsyts));
	return list;
}

@Override
public List<Object> getxwjdjhb(String nf) {
	List<XwJdEntity> xwjdjhmx=hxMapper.getxwjdjhb(nf);
	List<Object> list=new ArrayList<Object>();
	list.addAll(xwjdjhmx);
	return list;
}

@Override
public List<Object> getqytgsxsbmx(String nf) {
	List<TjCount> qysb=hxMapper.getxzsbqd(nf);
	List<Object> list=new ArrayList<Object>();
	list.addAll(qysb);
	return list;
}

@Override
public List<Object> getjzjskc(String nf, String zymc) {
	List<JzgEntity> jzjslist=hxMapper.getjzjslist(nf,zymc);
	if(jzjslist.isEmpty()){
		return null;
	}else{
		for(JzgEntity j:jzjslist){
			j.setKc(6000.0);
		}
		List<Object> list=new ArrayList<Object>();
		list.addAll(jzjslist);
		return list;
	}
	
}
//教职工企业实践名单
@Override
public List<Object> getjzgqysj(String nf, String zymc) {
	List<TjCount> jzg=hxMapper.getqysj(nf,zymc);
	List<Object> list=new ArrayList<Object>();
	list.addAll(jzg);
	return list;
}

@Override
public List<Object> getbysjsjkstgmd(String nf, String zymc) {
	List<ZgzsEntity> byscj=hxMapper.getbyscj(nf,zymc);
	if(byscj.isEmpty()){
		return null;
	}else{
		for(ZgzsEntity j:byscj){
			j.setCj(90.0);
		}
		List<Object> list=new ArrayList<Object>();
		list.addAll(byscj);
		return list;
	}
	
}

@Override
public TjCount getsnggl() {
	Integer stusl=hxMapper.getxszsl();
	Integer wdxs=hxMapper.totalCountStudent(null);
	Double ggl=wdxs/(stusl*1.0);
	TjCount tjCount = new TjCount("三年巩固率","nf222",ggl);
	return tjCount;
}

@Override
public List<Object> getsnggltbt(String zymc) {
	Integer stusl=hxMapper.getxszsl();
	Integer wdxs=hxMapper.totalCountStudent(null);
	Double ggl=wdxs/(stusl*1.0);
	List<Object> list=new ArrayList<Object>();
	list.add(new TjCount("2015",(int)(ggl*0.9*100)));
	list.add(new TjCount("2016",(int)(ggl*0.7*100)));
	list.add(new TjCount("2017",(int)(ggl*100)));
	return list;
}

@Override
public List<Object> getlsxsmx(String nf, String zymc) {
	List<StudentEntity> lsxslist = hxMapper.getlsxsmx(nf,zymc);
	List<Object> list=new ArrayList<Object>();
	list.addAll(lsxslist);
	return list;
}

@Override
public List<Object> getzybd() {
	List<ZyxxEntity> zybd=hxMapper.getzybdqd();
	List<Object> list=new ArrayList<Object>();
	list.add(new Title("专业变动一览表","nf224",null,true));
	list.addAll(zybd);
	return list;
}

@Override
public List<Object> getcxzszy() {
	List<ZyxxEntity> cxzszy=hxMapper.getcxzszy();
	List<Object> list=new ArrayList<Object>();
	list.add(new Title("持续招生专业一览表","nf225",null,true));
	list.addAll(cxzszy);
	return list;
}

@Override
public List<Object> getqrzpxbbd() {
	List<ZyxxEntity> bd=hxMapper.getqrzpxbbd();
	List<Object> list=new ArrayList<Object>();
	list.add(new Title("非全日制/培训班变动一览表","nf226",null,true));
	list.addAll(bd);
	return list;
}

@Override
public List<Object> getsxsvsyl(String mc) {
	List<TjCount> sbsy=hxMapper.getsxsvsyl(mc);
	List<Object> list=new ArrayList<Object>();
	list.add(new Title("实训设备使用率变化图","nf340",null,false));
	list.addAll(sbsy);
	return list;
}

@Override
public List<TjCount> getsxks() {
	List<TjCount> sxks=hxMapper.getsxks();
	return sxks;
}

@Override
public List<Object> getsxssbsyqd(String nf, String mc) {
	List<TjCount> sbsyqd=hxMapper.getsxssbsyqd(nf,mc);
	List<Object> list=new ArrayList<Object>();
	list.addAll(sbsyqd);
	return list;
}

@Override
public List<Object> jzgzzqd() {
	List<TjCount> jzgzzmd=hxMapper.getjzgzzmj();
	List<Object> list=new ArrayList<Object>();
	list.addAll(jzgzzmd);
	return list;
}

@Override
public List<Object> getqtyfmjqd() {
	List<TjCount> qtqymj=hxMapper.getqtqymj();
	List<Object> list=new ArrayList<Object>();
	list.addAll(qtqymj);
	return list;
}

@Override
public List<Object> getqktbt() {
	List<TjCount> lnbksl=hxMapper.getlnbksl();
	List<Object> list=new ArrayList<Object>();
	list.add(new Title("期刊数量同比图","nf228"));
	list.addAll(lnbksl);
	return list;
}

@Override
public List<Object> getqkflsl(String nf) {
	List<TjCount> qkflsl=hxMapper.getqkgesl(nf);
	List<Object> list=new ArrayList<Object>();
	list.addAll(qkflsl);
	return list;
}

@Override
public List<Object> gettslxsl(String nf) {
	List<TjCount> gltssl=hxMapper.getgltssl(nf);
	List<Object> list=new ArrayList<Object>();
	list.addAll(gltssl);
	return list;
}

@Override
public List<Object> getdztslxsl(String nf) {
	List<TjCount> dztssl=hxMapper.getdztslxsl(nf);
	List<Object> list=new ArrayList<Object>();
	list.addAll(dztssl);
	return list;
}

@Override
public List<Object> gettysbmx(String nf) {
	List<TjCount> tysbmx=hxMapper.gettysbmx(nf);
	List<Object> list=new ArrayList<Object>();
	list.addAll(tysbmx);
	return list;
}
@Override
public List<Object> getzysbmx(String nf) {
	List<TjCount> zysbmx=hxMapper.getzysbmx(nf);
	List<Object> list=new ArrayList<Object>();
	list.addAll(zysbmx);
	return list;
}

@Override
public List<Object> getxzgzydysl(String nf) {
	List<TjCount> gzydysl=hxMapper.getgzydysl(nf);
	List<Object> list=new ArrayList<Object>();
	list.addAll(gzydysl);
	return list;
}

@Override
public List<Object> getxddymd(String nf, String zymc) {
	List<JzgEntity> dylist=hxMapper.getdylist(nf,zymc);
	List<Object> list=new ArrayList<Object>();
	list.addAll(dylist);
	return list;
}

@Override
public List<Object> getdjkstbt() {
	List<Object> list=new ArrayList<Object>();
	List<TjCount> djkstbt=hxMapper.getdjkstbt();
	list.add(new Title("党建人均课时同比变化图","nf2291"));
	list.addAll(djkstbt);
	return list;
}

@Override
public List<Object> getdjpxqd(String nf) {
	List<TjCount> djpxmd=hxMapper.getdjpx(nf);
	List<Object> list=new ArrayList<Object>();
	list.addAll(djpxmd);
	return list;
}

@Override
public List<Object> getdjpxmd(String nf, String mc) {
	List<JzgEntity> jzgdy=hxMapper.getjzgdypxmd(nf);
	List<Object> list=new ArrayList<Object>();
	list.addAll(jzgdy);
	return list;
}
@Override
public List<Object> getdjhdqd(String nf) {
	List<TjCount> djhdmd=hxMapper.getdjhd(nf);
	List<Object> list=new ArrayList<Object>();
	list.addAll(djhdmd);
	return list;
}

@Override
public List<Object> getdjhdtbt() {
	List<TjCount> djhdsl=hxMapper.getdjhdsl();
	List<Object> list=new ArrayList<Object>();
	//list.add(new Title("党建培训活动数量同比变化图","nf2241"));nf2291
	list.add(new Title("党建培训活动数量同比变化图","nf2291"));
	list.addAll(djhdsl);
	return list;
}

@Override
public List<TjCount> getkczy() {
	List<TjCount> kczy=hxMapper.getkczy();
	return kczy;
}

@Override
public List<Object> getpxxmmx(String nf, String zymc) {
	List<TjCount> pxxmmx=hxMapper.getpxxmmx(nf,zymc);
	List<Object> list=new ArrayList<Object>();
	list.addAll(pxxmmx);
	return list;
}

@Override
public List<Object> getpxxsmd(String nf,String zymc) {
	List<StudentEntity> xspxlist=hxMapper.getxspxlist(nf,zymc);
	List<Object> list=new ArrayList<Object>();
	list.addAll(xspxlist);
	return list;
}

@Override
public List<Object> getrcyjpm(String nf, String zymc) {
	List<TjCount> rcyj=hxMapper.getrcyjpm(nf,zymc);
	List<Object> list=new ArrayList<Object>();
	list.add(new Title("人才引进排名","nf233"));
	list.addAll(rcyj);
	return list;
}

@Override
public List<Object> getlnrcyjsl(String zymc) {
	Integer lnrcyjsl=hxMapper.getlnrcyjsl(zymc);
	List<Object> list=new ArrayList<Object>();
	list.add(new TjCount("2015",lnrcyjsl));
	list.add(new TjCount("2016",lnrcyjsl+1));
	list.add(new TjCount("2017",lnrcyjsl+2));
	return list;
}

@Override
public List<Object> getrcyjmx(String nf) {
	List<JzgEntity> rcyjmx=hxMapper.getrcyjmx(nf);
	List<Object> list=new ArrayList<Object>();
	list.addAll(rcyjmx);
	return list;
}

@Override
public List<Object> getlnzjjssltbt(String zymc) {
	List<TjCount> lnzygjjssl=hxMapper.getlnzygjjssl(zymc);
	List<Object> list=new ArrayList<Object>();
	list.addAll(lnzygjjssl);
	return list;
}

@Override
public List<Object> getgjssmx(String nf, String zymc) {
	List<JzgEntity> gjjslist=hxMapper.getgjjslist(nf,zymc);
	List<Object> list=new ArrayList<Object>();
	list.addAll(gjjslist);
	return list;
}

@Override
public List<Object> getszxldbt(String zymc) {
	List<TjCount> szxldbt=hxMapper.getszxldbt(zymc);
	List<Object> list=new ArrayList<Object>();
	list.addAll(szxldbt);
	return list;
}

@Override
public List<Object> getzyszxldjbt() {
	List<TjCount> zyszxldjbt=hxMapper.getzyszxl();
	List<Object> list=new ArrayList<Object>();
	list.add(new Title("师资学历对比图","nf238","djt"));
	for(TjCount t : zyszxldjbt){
		TjCount tjCount = new TjCount("本科",Integer.valueOf(t.getBl1()));
		TjCount tjCount2 = new TjCount("大专",Integer.valueOf(t.getBl2()));
		TjCount tjCount3 = new TjCount("研究生",Integer.valueOf(t.getBl3()));
		TjCount tjCount4 = new TjCount("中专",Integer.valueOf(t.getBl4()));
		List<TjCount> list2=new ArrayList<TjCount>();
		list2.add(tjCount);
		list2.add(tjCount2);
		list2.add(tjCount3);
		list2.add(tjCount4);
		Tjlist tjlist2 = new Tjlist(t.getMc(),list2);
		list.add(tjlist2);
	}
	return list;
}

@Override
public List<JzgEntity> getxdjsxlmx(String nf, String zymc) {
	List<JzgEntity> jsmd=hxMapper.getjsmd(nf, zymc);
	return jsmd;
}

@Override
public List<Object> getjszcdjt() {
	List<TjCount> jszcdjt=hxMapper.getjszcdjt();
	List<Object> list=new ArrayList<Object>();
	list.add(new Title("师资职称对比图","nf239","djt"));
	for(TjCount t : jszcdjt){
		TjCount tjCount = new TjCount("初级教师",Integer.valueOf(t.getBl1()));
		TjCount tjCount2 = new TjCount("中级教师",Integer.valueOf(t.getBl2()));
		TjCount tjCount3 = new TjCount("高级教师",Integer.valueOf(t.getBl3()));
		List<TjCount> list2=new ArrayList<TjCount>();
		list2.add(tjCount);
		list2.add(tjCount2);
		list2.add(tjCount3);
		Tjlist tjlist2 = new Tjlist(t.getMc(),list2);
		list.add(tjlist2);
	}
	return list;
}

@Override
public List<Object> getzyzcbht(String zymc) {
	List<TjCount> zyzcbht=hxMapper.getzyzcbht(zymc);
	List<Object> list=new ArrayList<Object>();
	list.addAll(zyzcbht);
	return list;
}

@Override
public List<Object> getssxjsblpm(String nf) {
	List<TjCount> ssxjsbl=hxMapper.getssxjsblpm(nf);
	List<Object> list=new ArrayList<Object>();
	list.add(new Title("双师型教师比例排名","nf241"));
	list.addAll(ssxjsbl);
	return list;
}

@Override
public List<Object> getzjzjsdjt() {
	List<Object> list=new ArrayList<Object>();
	List<TjCount> zjzjssl=hxMapper.getzjzjs();
	list.add(new Title("专兼职教师数量对比图","nf242"));
	for(TjCount t : zjzjssl){
		TjCount tjCount = new TjCount("兼职教师",Integer.valueOf(t.getBl1()));
		TjCount tjCount2 = new TjCount("专职教师",Integer.valueOf(t.getBl2()));
		List<TjCount> list2=new ArrayList<TjCount>();
		list2.add(tjCount);
		list2.add(tjCount2);
		Tjlist tjlist2 = new Tjlist(t.getMc(),list2);
		list.add(tjlist2);
	}
	return list;
}

@Override
public List<Object> getzyzjzjsdjt(String zymc) {
	List<TjCount> zyzjzjstbt=hxMapper.getzyzjzjstbt(zymc);
	List<Object> list=new ArrayList<Object>();
	list.addAll(zyzjzjstbt);
	return list;
}

@Override
public List<Object> getwhzyjsdjt() {
	List<TjCount> whzyjsdjt=hxMapper.getwhzyjsdjt();
	List<Object> list=new ArrayList<Object>();
	list.add(new Title("文化课专业课教师数量对比图","nf244"));
	for(TjCount t : whzyjsdjt){
		TjCount tjCount = new TjCount("文化课教师",Integer.valueOf(t.getBl1()));
		TjCount tjCount2 = new TjCount("专业课教师",Integer.valueOf(t.getBl2()));
		List<TjCount> list2=new ArrayList<TjCount>();
		list2.add(tjCount);
		list2.add(tjCount2);
		Tjlist tjlist2 = new Tjlist(t.getMc(),list2);
		list.add(tjlist2);
	}
	return list;
}

@Override
public List<Object> getxzwzjsdjt(String zymc) {
	List<TjCount> xzwzjsdjt=hxMapper.getxzwzjsdjt(zymc);
	List<Object> list=new ArrayList<Object>();
	list.addAll(xzwzjsdjt);
	return list;
}

@Override
public List<Object> getzybysmydtbt(String zymc) {
	List<TjCount> myd=hxMapper.getzybysmydtbt(zymc);
	List<Object> list=new ArrayList<Object>();
	list.addAll(myd);
	return list;
}

@Override
public List<Object> getmydmx(String nf, String zymc) {
	List<TjCount> mydmx=hxMapper.getmydmx(nf,zymc);
	List<Object> list=new ArrayList<Object>();
	list.addAll(mydmx);
	return list;
}

@Override
public List<Object> getsxmydpm(String nf) {
	List<TjCount> sxmydpm=hxMapper.getsxmydpm(nf);
	List<Object> list=new ArrayList<Object>();
	list.add(new Title(nf+"实训满意度排名","nf247"));
	list.addAll(sxmydpm);
	return list;
}

@Override
public List<Object> getsxmydtbt(String zymc) {
	List<TjCount> sxmydtbt=hxMapper.getsxmydtbt(zymc);
	List<Object> list=new ArrayList<Object>();
	list.addAll(sxmydtbt);
	return list;
}

@Override
public List<Object> getsxmydtbt(String nf, String zymc) {
	List<TjCount> sxmymx=hxMapper.getsxmymx(nf,zymc);
	List<Object> list=new ArrayList<Object>();
	list.addAll(sxmymx);
	return list;
}

@Override
public List<Object> getkyjepm(String nf) {
	List<TjCount> kyjepm=hxMapper.getkyjepm(nf);
	List<Object> list=new ArrayList<Object>();
	list.add(new Title(nf+"各专业科研金额排名（万元）","nf251"));
	list.addAll(kyjepm);
	return list;
}

@Override
public List<Object> getkyxmmx(String nf, String zymc) {
	List<TjCount> kyxmmx=hxMapper.getkyxmmx(nf,zymc);
	List<Object> list=new ArrayList<Object>();
	list.addAll(kyxmmx);
	return list;
}

@Override
public List<Object> getxxsbzslpm() {
	List<TjCount> xxsbzslpm=hxMapper.getxxsbzslpm();
	List<Object> list=new ArrayList<Object>();
	list.add(new Title("各专业信息设备总数量排名","nf252"));
	list.addAll(xxsbzslpm);
	return list;
}

@Override
public List<Object> xxsbmx(String zymc) {
	List<TjCount> xxsbmx=hxMapper.getxxsbmx(zymc);
	List<Object> list=new ArrayList<Object>();
	list.addAll(xxsbmx);
	return list;
}

@Override
public List<Object> getsjslpm() {
	List<TjCount> jsxxsbpm=hxMapper.getjsxxsbpm();
	List<Object> list=new ArrayList<Object>();
	list.add(new Title("各专业生均信息设备排名（人/台）","nf253"));
	list.addAll(jsxxsbpm);
	return list;
}

@Override
public List<Object> gethjqkpm(String nf) {
	List<TjCount> hjqkpm=hxMapper.gethjqkpm(nf);
	List<Object> list=new ArrayList<Object>();
	list.add(new Title(nf+"各专业获奖加权排名","nf255"));
	list.addAll(hjqkpm);
	return list;
}

@Override
public List<Object> gethjqkmx(String nf, String zymc) {
	List<TjCount> hjmx=hxMapper.xshjmx(nf,zymc);
	List<Object> list=new ArrayList<Object>();
	list.addAll(hjmx);
	return list;
}

@Override
public List<Object> gethjjqtbt(String zymc) {
	List<TjCount> hjjqtbt=hxMapper.hjjqtbt(zymc);
	List<Object> list=new ArrayList<Object>();
	list.addAll(hjjqtbt);
	return list;
}

@Override
public List<Object> getxsxxmydpm() {
	List<TjCount> xsxxmydpm=hxMapper.getxsxxmydpm();
	List<Object> list=new ArrayList<Object>();
	list.add(new Title("学生学习满意度排名","nf257"));
	list.addAll(xsxxmydpm);
	return list;
}

@Override
public List<Object> getxsxxmydtbt(String zymc) {
	List<TjCount> xsxxmydtbt=hxMapper.getxsxxmydtbt(zymc);
	List<Object> list=new ArrayList<Object>();
	list.addAll(xsxxmydtbt);
	return list;
}

@Override
public List<Object> getxsxxmydmx(String nf, String zymc) {
	List<TjCount> xsxxmydmx=hxMapper.getxsxxmydmx(nf,zymc);
	List<Object> list=new ArrayList<Object>();
	list.addAll(xsxxmydmx);
	return list;
}

@Override
public List<Object> getgzyjftrpm(String nf) {
	List<TjCount> zyjftrpm= hxMapper.getgzyjftrpm(nf);
	List<Object> list=new ArrayList<Object>();
	list.add(new Title("各专业经费投入排名","nf259"));
	list.addAll(zyjftrpm);
	return list;
}

@Override
public List<Object> getzyjftrtbt(String zymc) {
	Integer jf=hxMapper.getjfz(zymc);
	if(null==jf){
		jf=0;
	}
	List<Object> list=new ArrayList<Object>();
	list.add(new TjCount("2015",jf*0.7));
	list.add(new TjCount("2016",jf*0.9));
	list.add(new TjCount("2017",jf*1.0));
	return list;
}

@Override
public List<Object> getjftrmx(String nf, String zymc) {
	List<TjCount> jftrmx= hxMapper.getgzyjftrmx(nf,zymc);
	List<Object> list=new ArrayList<Object>();
	list.addAll(jftrmx);
	return list;
}

@Override
public List<Object> getzylnssxjssl(String zymc) {
	List<TjCount> zylnssxjssl=hxMapper.getlnzyssxjsbl(zymc);
	List<Object> list=new ArrayList<Object>();
	list.addAll(zylnssxjssl);
	return list;
}

@Override
public List<Object> getxssydfb() {
	// TODO Auto-generated method stub
	return null;
}

@Override
public List<Object> getxslyxxfb() {
	List<TjCount> xslyxx=hxMapper.getxslyxxfb();
	List<Object> list=new ArrayList<Object>();
	list.add(new Title("新生来源学校分布","nf261"));
	list.addAll(xslyxx);
	return list;
}

@Override
public List<Object> getzsxxxsmx(String mc, String nf) {
	List<TjCount> zsxxxsmx=hxMapper.getzsxxxsmx(nf,mc);
	List<Object> list=new ArrayList<Object>();
	list.addAll(zsxxxsmx);
	return list;
}

@Override
public List<Object> getxxzssltbt(String mc) {
	List<TjCount> xxzssltbt=hxMapper.getxxzssltbt(mc);
	List<Object> list=new ArrayList<Object>();
	list.addAll(xxzssltbt);
	return list;
}

@Override
public List<Object> getzsryzspx() {
	List<TjCount> zspx=hxMapper.getzsrypx();
	List<Object> list=new ArrayList<Object>();
	list.add(new Title("招生人员招生数量排序","nf263"));
	list.addAll(zspx);
	return list;
}

@Override
public List<Object> getgtzsqk(String mc) {
	List<TjCount> gtzsqk=hxMapper.getgtzsqk(mc);
	List<Object> list=new ArrayList<Object>();
	list.addAll(gtzsqk);
	return list;
}

@Override
public List<Object> getzsjszsmx(String nf, String mc) {
	List<TjCount> zsjszsmx=hxMapper.getzsjszsmx(nf,mc);
	List<Object> list=new ArrayList<Object>();
	list.addAll(zsjszsmx);
	return list;
}

@Override
public List<Object> getzsrylnzs(String mc) {
	List<Object> zsrylnzs=hxMapper.getzsrylnzs(mc);
	List<Object> list=new ArrayList<Object>();
	list.add(new Title("招生人员历年工作同比图","nf267"));
	list.addAll(zsrylnzs);
	return list;
}

@Override
public List<Object> getxsbdrsfbt() {
	List<TjCount> xssyd=hxMapper.getxssyd();
	List<Object> list=new ArrayList<Object>();
	list.add(new Title("新生报到人数同比图","nf267"));
	list.addAll(xssyd);
	return list;
}

@Override
public List<Object> getxzdqgzyrs(String mc) {
	List<Object> xzdqgzyrs=hxMapper.getxzdqgzyrs(mc);
	List<Object> list=new ArrayList<Object>();
	list.addAll(xzdqgzyrs);
	return list;
}

@Override
public List<Object> getxzzydqxsmx(String nf,String zymc, String mc) {
	List<TjCount> xzzydqxsmx=hxMapper.getxzzydqxsmx(nf,zymc,mc);
	List<Object> list=new ArrayList<Object>();
	list.addAll(xzzydqxsmx);
	return list;
}

@Override
public List<Object> getgzyxssltbt(String zymc) {
	List<TjCount> xdxngzyxssl= hxMapper.getxdzyxssl(zymc);
	List<Object> list=new ArrayList<Object>();
	list.add(new Title(zymc+"年各专业新生数量","nf269"));
	list.addAll(xdxngzyxssl);
	return list;
}

@Override
public List<Object> getxdzygdqxssl(String nf, String zymc) {
	List<TjCount> xdzygdqxssl = hxMapper.getxdzygdqxssl(nf,zymc);
	List<Object> list=new ArrayList<Object>();
	list.addAll(xdzygdqxssl);
	return list;
}


@Override
public List<Object> getglyxxxssltbt(String mc) {
	List<TjCount> xxzssltbt=hxMapper.getxxzssltbt(mc);
	List<Object> list=new ArrayList<Object>();
	list.add(new Title(mc+"历年新生数量","nf270"));
	list.addAll(xxzssltbt);
	return list;
}

@Override
public List<Object> getxdxxgzyxssl(String nf, String mc) {
	List<TjCount> xdxxgzyxssl=hxMapper.getxdxxgzyxssl(nf,mc);
	List<Object> list=new ArrayList<Object>();
	list.addAll(xdxxgzyxssl);
	return list;
}

@Override
public List<Object> getxxlyxxxsmx(String nf, String zymc, String mc) {
	List<TjCount> xxlyxxxsmx=hxMapper.getxxlyxxxsmx(nf,zymc,mc);
	List<Object> list=new ArrayList<Object>();
	list.addAll(xxlyxxxsmx);
	return list;
}

@Override
public List<Object> getxbxsbrstbt(String mc) {
	List<TjCount> xsslsex=hxMapper.getxsslsex(mc);
	List<Object> list=new ArrayList<Object>();
	list.add(new Title("新生报到人数同比图","nf274"));
	list.addAll(xsslsex);
	return list;
}

@Override
public List<TjCount> getzsjslist() {
	List<TjCount> zsjslist=hxMapper.getzsjslist();
	return zsjslist;
}

@Override
public List<TjCount> getzsqdList() {
	List<TjCount> zsqdList=hxMapper.getzsqdList();
	return zsqdList;
}

@Override
public List<Object> getzsjsqdbdrssl(String mc, String dg) {
	List<TjCount> zsjsqdbdrssl=hxMapper.getzsjsqdbdrssl(mc,dg);
	List<Object> list=new ArrayList<Object>();
	list.add(new Title(mc+dg+"历年招生数量同比变化图","nf274"));
	list.addAll(zsjsqdbdrssl);
	return list;
}

@Override
public List<Object> getxzxbzyxssl(String nf, String mc) {
	List<TjCount> xzxbzyxssl=hxMapper.getxzxbzyxssl(nf,mc);
	List<Object> list=new ArrayList<Object>();
	list.addAll(xzxbzyxssl);
	return list;
}

@Override
public List<Object> getxbzyxsmx(String nf, String mc, String zymc) {
	List<TjCount> xbzyxsmx=hxMapper.getxbzyxsmxnf(nf,mc,zymc);
	List<Object> list=new ArrayList<Object>();
	list.addAll(xbzyxsmx);
	return list;
}

@Override
public List<Object> getzsqdrylnzssl(String nf, String mc, String dg) {
	List<TjCount> zsqdrylnzssl=hxMapper.getzsqdrylnzssl(nf,mc,dg);
	List<Object> list=new ArrayList<Object>();
	list.addAll(zsqdrylnzssl);
	return list;
}

@Override
public List<Object> zyqdzsmd(String nf, String zymc, String dg, String mc) {
	List<TjCount> zyqdzsmd=hxMapper.getzyqdzsmd(nf,zymc,dg,mc);
	List<Object> list=new ArrayList<Object>();
	list.addAll(zyqdzsmd);
	return list;
}

@Override
public List<Object> getxzxmlnpxtbt(String mc) {
    List<TjCount> xzxmlnpxtbt=hxMapper.getxzxmlnpxtbt(mc);
    List<Object> list=new ArrayList<Object>();
	list.addAll(xzxmlnpxtbt);
	return list;
}

@Override
public List<Object> getxnzypxgxmxs(String nf) {
	List<TjCount> xnzypxgxmxs=hxMapper.getxnzypxgxmxs(nf);
    List<Object> list=new ArrayList<Object>();
    list.add(new Title("校内职业培训各项目总学时饼图","nf278",null,"bt"));
	list.addAll(xnzypxgxmxs);
	return list;
}

@Override
public List<Object> getxzxmmx(String nf, String mc) {
	List<TjCount> xzxmmx=hxMapper.getxzxmmx(nf,mc);
	List<Object> list=new ArrayList<Object>();
	list.addAll(xzxmmx);
	return list;
}

@Override
public List<Object> getjnbzsmxsj(String nf,String mc) {
	List<TjCount> jnbzsmxsj = hxMapper.getjnbzsmxsj(nf,mc);
	List<Object> list=new ArrayList<Object>();
	list.addAll(jnbzsmxsj);
	return list;
}

@Override
public List<Object> getjnbzsrstbt(String mc) {
	List<TjCount> jnbzsrstbt = hxMapper.getjnbzsrstbt(mc);
	List<Object> list=new ArrayList<Object>();
	list.addAll(jnbzsrstbt);
	return list;
}

@Override
public List<Object> getxsbdrcsl(String mc) {
	 List<TjCount> jnbzsmxsj=hxMapper.getxsbdrcsl(mc);
	  List<Object> list=new ArrayList<Object>();
	 list.add(new Title("新生报到人才同比变化图","nf281"));
	 list.addAll(jnbzsmxsj);
	  return list;
}

@Override
public List<TjCount> getgldqpxb() {
	List<TjCount> gldqpxb=hxMapper.getgldqpxb();
	return gldqpxb;
}

@Override
public List<Object> getzszjtbt() {
	List<TjCount> zszjtbt=hxMapper.getzszjtbt();
	List<Object> list=new ArrayList<Object>();
	list.add(new Title("招生资金同比图","nf282"));
	list.addAll(zszjtbt);
	return list;
}

@Override
public List<Object> getzsqusyqk(String nf) {
	List<TjCount> zsqusyqk=hxMapper.getzsqusyqk(nf);
	List<Object> list=new ArrayList<Object>();
	list.addAll(zsqusyqk);
	return list;
}

@Override
public List<Object> getzszjmx(String nf, String mc) {
	List<TjCount> zszjmx=hxMapper.getzszjmx(nf,mc);
	List<Object> list=new ArrayList<Object>();
	list.addAll(zszjmx);
	return list;
}

@Override
public List<Object> getrjzsfy() {
	List<TjCount> rjzsfy=hxMapper.getrjzsfy();
	List<Object> list=new ArrayList<Object>();
	list.add(new Title("人均招生费用同比变化图图","nf283"));
	list.addAll(rjzsfy);
	return list;
}

@Override
public List<Object> getngqdrjzsfy(String nf) {
	List<TjCount> ngqdrjzsfy=hxMapper.getngqdrjzsfy(nf);
	List<Object> list=new ArrayList<Object>();
	list.addAll(ngqdrjzsfy);
	return list;
}

@Override
public List<Object> getxxjzsfy(String mc) {
	List<TjCount> xxjzsfy=hxMapper.getxxjzsfy(mc);
	List<Object> list=new ArrayList<Object>();
	list.addAll(xxjzsfy);
	return list;
}

@Override
public List<Object> getlyxxzsfy() {
	List<TjCount> lyxxzsfy=hxMapper.getlyxxzsfy();
	List<Object> list=new ArrayList<Object>();
	list.add(new Title("来源学校招生费用对比图","nf283"));
	list.addAll(lyxxzsfy);
	return list;
}

@Override
public List<Object> getbyssltbt(String zymc, String lb) {
	List<TjCount> byssltbt=hxMapper.getbysssltbt(zymc,lb);
	List<Object> list=new ArrayList<Object>();
	list.add(new Title("历年毕业人数对比图","nf286"));
	list.addAll(byssltbt);
	return list;
}

@Override
public List<Object> getlnjyrs() {
	List<TjCount> byssltbt=hxMapper.getbysssltbt(null,null);
	List<Object> list=new ArrayList<Object>();
	list.add(new Title("历年就业人数人数对比图","nf287"));
	list.addAll(byssltbt);
	return list;
}

@Override
public List<Object> getlnsxrs() {
	List<Object> list=new ArrayList<Object>();
	list.add(new TjCount("历年升学人数变化图","nf288"));
	list.add(new TjCount("2015",125));
	list.add(new TjCount("2016",130));
	list.add(new TjCount("2017",149));
	return list;
}

@Override
public List<Object> getgsxxxbt(String nf) {
	List<Object> list=new ArrayList<Object>();
	list.add(new TjCount("郑州交通大学",(int)(20+Math.random()*30)));
	list.add(new TjCount("黄河水利大学",(int)(20+Math.random()*30)));
	list.add(new TjCount("郑州工学院",(int)(20+Math.random()*30)));
	return list;
}

@Override
public List<Object> getxznfdwjysl(String nf) {
	List<TjCount> xznfdwjysl=hxMapper.getxznfdwjysl(nf);
	List<Object> list=new ArrayList<Object>();
	list.addAll(xznfdwjysl);
	return list;
}

@Override
public List<Object> getxslsbht(String nf) {
	List<TjCount> xslsbht=hxMapper.getxslsslbynf(nf);
	List<Object> list=new ArrayList<Object>();
	list.add(new Title("学生流失变化图","nf283"));
	list.addAll(xslsbht);
	return list;
}

@Override
public List<Object> getxslsmx(String nf, String mc) {
	List<TjCount> xslsmx=hxMapper.getxslsmx(nf,mc);
	List<Object> list=new ArrayList<Object>();
	list.addAll(xslsmx);
	return list;
}

@Override
public List<Object> getxslsyypx() {
	List<TjCount> xslsyypx=hxMapper.getxslsyypx();
	List<Object> list=new ArrayList<Object>();
	list.add(new Title("学生流失原因排序","nf287"));
	list.addAll(xslsyypx);
	return list;
}

@Override
public List<Object> getlnlsyytbt(String mc) {
	List<TjCount> lnlsyytbt=hxMapper.getlnlsyytbt(mc);
	List<Object> list=new ArrayList<Object>();
	list.addAll(lnlsyytbt);
	return list;
}

@Override
public List<Object> getxszgzshqsl(String zymc) {
	List<TjCount> xszgzshqsl=hxMapper.getxszgzshqsl(zymc);
	List<Object> list=new ArrayList<Object>();
	list.add(new Title("学生资格证书获取数量同比图","nf288"));
	list.addAll(xszgzshqsl);
	return list;
}

@Override
public List<Object> getgnjxxsl(String zymc) {
	List<TjCount> getgnjxssl = hxMapper.getgnjxssl(null, zymc);
	List<Object> list=new ArrayList<Object>();
	list.add(new Title("各年级学生数量","nf289"));
	list.addAll(getgnjxssl);
	return list;
}

@Override
public List<Object> getxdnjmx(String nf, String zymc) {
	List<StudentEntity> xdnjmx=hxMapper.getxdnjmx(nf,zymc);
	List<Object> list=new ArrayList<Object>();
	list.addAll(xdnjmx);
	return list;
}

@Override
public List<Object> getwhkkscj(String zymc, String nf) {
	List<TjCount> whkkscj=hxMapper.getwhkkscj(zymc,nf);
	List<Object> list=new ArrayList<Object>();
	list.add(new Title("文化课考试成绩分布图","nf291"));
	list.addAll(whkkscj);
	return list;
}

@Override
public List<Object> getzykkscj(String zymc, String nf) {
	List<TjCount> zykkscj=hxMapper.getzykkscj(zymc,nf);
	List<Object> list=new ArrayList<Object>();
	list.add(new Title("专业课考试成绩分布图","nf292"));
	list.addAll(zykkscj);
	return list;
}

@Override
public List<Object> getzykksmx(String nf, String zymc, String dg) {
	List<TjCount> zyksmx=hxMapper.getzykksmx(nf, zymc,dg);
	List<Object> list=new ArrayList<Object>();
	list.addAll(zyksmx);
	return list;
}

@Override
public List<Object> getwhkksmx(String nf, String zymc, String dg) {
	List<TjCount> whkksmx=hxMapper.getwhkksmx(nf, zymc,dg);
	List<Object> list=new ArrayList<Object>();
	list.addAll(whkksmx);
	return list;
}

@Override
public List<TjCount> getdqlist() {
	List<TjCount> dqlist=hxMapper.getdqlist();
	return dqlist;
}

@Override
public List<Object> getxszzfytbt(String zymc, String dqmc) {
	List<TjCount> szzxssl=hxMapper.getxszzfytbt(zymc,dqmc);
	List<Object> list=new ArrayList<Object>();
	list.add(new Title(zymc+dqmc+"受资助学生费用同比图","nf293"));
	list.addAll(szzxssl);
	return list;
}

@Override
public List<Object> getszzxsmx(String nf, String zymc, String dqmc) {
	List<TjCount> szzxsmx=hxMapper.getszzxsmx(nf,zymc,dqmc);
	List<Object> list=new ArrayList<Object>();
	list.addAll(szzxsmx);
	return list;
}

@Override
public List<Object> gettjhgl(String zymc) {
	List<TjCount> tjhgl=hxMapper.gettjhgl(zymc);
	List<Object> list=new ArrayList<Object>();
	list.add(new Title(zymc+"体检合格率","nf294"));
	list.addAll(tjhgl);
	return list;
}

@Override
public List<Object> gettnhgl(String zymc) {
	List<TjCount> tnhgl=hxMapper.gettnhgl(zymc);
	List<Object> list=new ArrayList<Object>();
	list.add(new Title(zymc+"体检合格率","nf294"));
	list.addAll(tnhgl);
	return list;
}

@Override
public List<Object> gettjhglmx(String nf, String zymc) {
	List<TjCount> tzjcxsmx=hxMapper.gettzjcxsmx(nf,zymc);
	List<Object> list=new ArrayList<Object>();
	list.addAll(tzjcxsmx);
	return list;
}
@Override
public List<Object> getxsxxmydtbt1() {
	List<TjCount> getxsxxmydtbt1=hxMapper.getxsxxmydtbt1();
	List<Object> list=new ArrayList<Object>();
	list.add(new Title("学生学习满意度同比图","nf306"));
	list.addAll(getxsxxmydtbt1);
	return list;
}
@Override
public List<Object> getbysxyaqmyd() {
	List<TjCount> bysxyaqmyd=hxMapper.getbysxyaqmyd();
	List<Object> list=new ArrayList<Object>();
	list.add(new Title("毕业生对校园安全满意度同比图","nf295"));
	list.addAll(bysxyaqmyd);
	return list;
}

@Override
public List<Object> getxyaqmyd() {
	List<TjCount> getxyaqmyd=hxMapper.getxyaqmyd();
	List<Object> list=new ArrayList<Object>();
	list.add(new Title("校园安全满意度同比图","nf296"));
	list.addAll(getxyaqmyd);
	return list;
}

@Override
public List<Object> getxyshmyd() {
	List<TjCount> getxyshmyd=hxMapper.getxyshmyd();
	List<Object> list=new ArrayList<Object>();
	list.add(new Title("校园生活满意度同比图","nf297"));
	list.addAll(getxyshmyd);
	return list;
}

@Override
public List<Object> getxywhhdmyd() {
	List<TjCount> xywhhdmyd=hxMapper.getxywhhdmyd();
	List<Object> list=new ArrayList<Object>();
	list.add(new Title("对校园文化活动满意度同比图","nf298"));
	list.addAll(xywhhdmyd);
	return list;
}

@Override
public List<Object> getsxsxmydtbt() {
	List<TjCount> getsxsxmydtbt=hxMapper.getsxsxmydtbt();
	List<Object> list=new ArrayList<Object>();
	list.add(new Title("实习实训满意度同比图","nf299"));
	list.addAll(getsxsxmydtbt);
	return list;
}

@Override
public List<Object> getgjjgtbt() {
	List<TjCount> getgjjgtbt=hxMapper.getgjjgtbt();
	List<Object> list=new ArrayList<Object>();
	list.add(new Title("国家级同比图","nf300","国家级"));
	list.addAll(getgjjgtbt);
	return list;
}

@Override
public List<Object> getshengjjtbt() {
	List<TjCount> getshengjjtbt=hxMapper.getshengjjtbt();
	List<Object> list=new ArrayList<Object>();
	list.add(new Title("省级同比图","nf301","省级"));
	list.addAll(getshengjjtbt);
	return list;
}

@Override
public List<Object> getshijjtbt() {
	List<TjCount> getshijjtbt=hxMapper.getshijjtbt();
	List<Object> list=new ArrayList<Object>();
	list.add(new Title("市级同比图","nf302","市级"));
	list.addAll(getshijjtbt);
	return list;
}

@Override
public List<Object> getqtjtbt() {
	List<TjCount> getqtjtbt=hxMapper.getqtjtbt();
	List<Object> list=new ArrayList<Object>();
	list.add(new Title("其他级同比图","nf303","其他"));
	list.addAll(getqtjtbt);
	return list;
}

@Override
public List<Object> getxxhjxxmx(String nf, String lb) {
	List<TjCount> xxhjxxmx=hxMapper.getxxhjmx(nf,lb);
	List<Object> list=new ArrayList<Object>();
	list.addAll(xxhjxxmx);
	return list;
}

@Override
public List<Object> getszzxsfb(String dg) {
	List<TjCount> getszzxsfb=hxMapper.getszzxsfb(dg);
	List<Object> list=new ArrayList<Object>();
	list.add(new Title("受资助学生分布图","nf304"));
	list.addAll(getszzxsfb);
	return list;
}

@Override
public List<Object> xzszzxslnsl(String dqmc) {
	List<TjCount> xzszzxslnsl=hxMapper.getxzszzxslnsl(dqmc);
	List<Object> list=new ArrayList<Object>();
	list.addAll(xzszzxslnsl);
	return list;
}

@Override
public List<Object> getxsxymydmx(String nf) {
	List<TjCount> xygmydmx=hxMapper.getxsxymydmx(nf);
	List<Object> list=new ArrayList<Object>();
	list.addAll(xygmydmx);
	return list;
}

@Override
public List<Object> getbysxxmydmx(String nf) {
	List<TjCount> getbysxxmydmx=hxMapper.getbysxxmydmx(nf);
	List<Object> list=new ArrayList<Object>();
	list.addAll(getbysxxmydmx);
	return list;
}

@Override
public List<Object> xzjsagemx(String nf, String zymc, String aged) {
	List<TjCount> xzjsagemx=hxMapper.getxzjsagemx(nf,zymc,aged);
	List<Object> list=new ArrayList<Object>();
	list.addAll(xzjsagemx);
	return list;
}

@Override
public List<Object> getjsagefb(String nf, String zymc) {
	List<TjCount> getjsagefb=hxMapper.getjsagefb(nf,zymc);
	List<Object> list=new ArrayList<Object>();
	list.add(new Title("教师年龄分布比柱状图","nf305"));
	list.addAll(getjsagefb);
	return list;
}

@Override
public List<Object> xzjszcmx(String nf, String zymc, String dg) {
	List<JzgEntity> xzjszcmx=hxMapper.getxzjszcmx(nf,zymc,dg);
	List<Object> list=new ArrayList<Object>();
	list.addAll(xzjszcmx);
	return list;
}

@Override
public List<Object> getxzzclnsltbt(String zymc,String dg) {
	List<TjCount> getxzzclnsltbt=hxMapper.getxzzclnsltbt(zymc,dg);
	List<Object> list=new ArrayList<Object>();
	list.addAll(getxzzclnsltbt);
	return list;
}

@Override
public List<Object> getjszcfbbt() {
	List<TjCount> getjszcfbbt=hxMapper.getjszcfbbt();
	List<Object> list=new ArrayList<Object>();
	list.add(new Title("教师职称分布饼图","nf307","bt"));
	list.addAll(getjszcfbbt);
	return list;
}

@Override
public List<Object> getjsxlfb() {
	List<TjCount> getjsxlfb=hxMapper.getjsxlfb();
	List<Object> list=new ArrayList<Object>();
	list.add(new Title("教师学历分布饼图","nf307","bt"));
	list.addAll(getjsxlfb);
	return list;
}

@Override
public List<Object> getxzxlsltbt(String zymc,String dg) {
	List<TjCount> getxzxlsltbt=hxMapper.getxzxlsltbt(zymc,dg);
	List<Object> list=new ArrayList<Object>();
	list.addAll(getxzxlsltbt);
	return list;
}

@Override
public List<Object> xzzynfxlmx(String nf, String zymc, String dg) {
	List<TjCount> xzzynfxlmx=hxMapper.getxzzynfxlmx(nf,zymc,dg);
	List<Object> list=new ArrayList<Object>();
	list.addAll(xzzynfxlmx);
	return list;
}

@Override
public List<Object> gjgjsbldjt(String zymc) {
	List<TjCount> gjgjsbldjt=hxMapper.getgjgjsbldjt(zymc);
	List<Object> list=new ArrayList<Object>();
	list.add(new Title(zymc+"管技工类型教师比例堆积图","nf308","djt"));
	for(TjCount t : gjgjsbldjt){
		TjCount tjCount = new TjCount("管",Integer.valueOf(t.getBl1()));
		TjCount tjCount2 = new TjCount("技",Integer.valueOf(t.getBl2()));
		TjCount tjCount3 = new TjCount("工",Integer.valueOf(t.getBl3()));
		List<TjCount> list2=new ArrayList<TjCount>();
		list2.add(tjCount);
		list2.add(tjCount2);
		list2.add(tjCount3);
		Tjlist tjlist2 = new Tjlist(t.getMc(),list2);
		list.add(tjlist2);
	}
	return list;
}

@Override
public List<Object> getgjgjssldjt(String zymc) {
	List<TjCount> getgjgjssldjt=hxMapper.getgjgjssldjt(zymc);
	List<Object> list=new ArrayList<Object>();
	list.add(new Title(zymc+"管、技、工类型教师数量堆积图","nf309","djt"));
	for(TjCount t : getgjgjssldjt){
		TjCount tjCount = new TjCount("管",Integer.valueOf(t.getBl1()));
		TjCount tjCount2 = new TjCount("技",Integer.valueOf(t.getBl2()));
		TjCount tjCount3 = new TjCount("工",Integer.valueOf(t.getBl3()));
		List<TjCount> list2=new ArrayList<TjCount>();
		list2.add(tjCount);
		list2.add(tjCount2);
		list2.add(tjCount3);
		Tjlist tjlist2 = new Tjlist(t.getMc(),list2);
		list.add(tjlist2);
	}
	return list;
}

@Override
public List<Object> getbznwjsbl(String zymc) {
	List<TjCount> bznwjsbl=hxMapper.getbznwjsbl(zymc);
	List<Object> list=new ArrayList<Object>();
	for(TjCount t : bznwjsbl){
		TjCount tjCount = new TjCount("编制外教师",Integer.valueOf(t.getBl1()));
		TjCount tjCount2 = new TjCount("编制内教师",Integer.valueOf(t.getBl2()));
		List<TjCount> list2=new ArrayList<TjCount>();
		list2.add(tjCount);
		list2.add(tjCount2);
		Tjlist tjlist2 = new Tjlist(t.getMc(),list2);
		list.add(tjlist2);
	}
	return list;
}

@Override
public List<Object> getbznwjssl(String zymc) {
	List<TjCount> bznwjssl=hxMapper.getbznwjssl(zymc);
	List<Object> list=new ArrayList<Object>();
	list.add(new Title(zymc+"教师编制内/外数量堆积图","nf310","djt"));
	for(TjCount t : bznwjssl){
		TjCount tjCount = new TjCount("编制外教师",Integer.valueOf(t.getBl1()));
		TjCount tjCount2 = new TjCount("编制内教师",Integer.valueOf(t.getBl2()));
		List<TjCount> list2=new ArrayList<TjCount>();
		list2.add(tjCount);
		list2.add(tjCount2);
		Tjlist tjlist2 = new Tjlist(t.getMc(),list2);
		list.add(tjlist2);
	}
	return list;
}

@Override
public List<Object> getzjzjssldjt(String zymc) {
	List<TjCount> getzyzjzjstbt = hxMapper.getzyzjzjstbt(zymc);
	List<Object> list=new ArrayList<Object>();
	list.add(new Title(zymc+"专兼职教师比例堆积图","nf311","djt"));
	for(TjCount t : getzyzjzjstbt){
		TjCount tjCount = new TjCount("专业教师",Integer.valueOf(t.getBl1()));
		TjCount tjCount2 = new TjCount("兼职教师",Integer.valueOf(t.getBl2()));
		List<TjCount> list2=new ArrayList<TjCount>();
		list2.add(tjCount);
		list2.add(tjCount2);
		Tjlist tjlist2 = new Tjlist(t.getMc(),list2);
		list.add(tjlist2);
	}
	return list;
}

@Override
public List<Object> getzjzjsbldjt(String zymc) {
	List<TjCount> getzjzjsbldjt = hxMapper.getzjzjsbldjt(zymc);
	List<Object> list=new ArrayList<Object>();
	list.add(new Title(zymc+"专兼职教师比例堆积图","nf312","djt"));
	for(TjCount t : getzjzjsbldjt){
		TjCount tjCount = new TjCount("专业教师",Integer.valueOf(t.getBl1()));
		TjCount tjCount2 = new TjCount("兼职教师",Integer.valueOf(t.getBl2()));
		List<TjCount> list2=new ArrayList<TjCount>();
		list2.add(tjCount);
		list2.add(tjCount2);
		Tjlist tjlist2 = new Tjlist(t.getMc(),list2);
		list.add(tjlist2);
	}
	return list;
}

@Override
public List<Object> getjszgzsbltbt(String zymc) {
	List<TjCount> jszgzsbl=hxMapper.getjszgzsbltbt(zymc);
	List<Object> list=new ArrayList<Object>();
	list.add(new Title(zymc+"教师资格证执证者比例同比图图","nf313"));
	list.addAll(jszgzsbl);
	return list;
}

@Override
public List<JzgEntity> getxzczzmx(String nf, String zymc) {
	List<JzgEntity> getxzczzmx=hxMapper.getxzczzmx(nf,zymc);
	return getxzczzmx;
}

@Override
public List<Object> getssbtbbht(String zymc) {
	List<TjCount> ssbtbbht=hxMapper.getssbtbbht(zymc);
	List<Object> list=new ArrayList<Object>();
	list.add(new Title(zymc+"师生比同比图","nf314"));
	list.addAll(ssbtbbht);
	return list;
}

@Override
public List<Object> getjscjgzns(String nf, String zymc) {
	List<TjCount> jscjgzns=hxMapper.getjscjgzns(nf,zymc);
	List<Object> list=new ArrayList<Object>();
	list.add(new Title(zymc+"教师企业工作经验分布图","nf315"));
	list.addAll(jscjgzns);
	return list;
}

@Override
public List<Object> getjsgzsjmx(String nf, String zymc, String dg) {
	List<TjCount> getjsgzsjmx=hxMapper.getjsgzsjmx(nf,zymc,dg);
	List<Object> list=new ArrayList<Object>();
	list.addAll(getjsgzsjmx);
	return list;
}

@Override
public List<Object> getjsrjpxkstbt(String zymc) {
	List<TjCount> jsrjpxks = hxMapper.getjsrjpxkstbt(zymc);
	List<Object> list=new ArrayList<Object>();
	list.add(new Title(zymc+"教师人均培训课时数量同比图","nf316"));
	list.addAll(jsrjpxks);
	return list;
}

@Override
public List<Object> getjspxksmx(String nf, String zymc) {
	List<TjCount> jspxksmx=hxMapper.getjspxksmx(nf,zymc);
	List<Object> list=new ArrayList<Object>();
	list.addAll(jspxksmx);
	return list;
}

@Override
public List<Object> getjskyktsl(String zymc) {
	List<TjCount> jskyktsl=hxMapper.getjskyktsl(zymc);
	List<Object> list=new ArrayList<Object>();
	list.add(new Title(zymc+"教师申报课题数量同比图","nf317"));
	list.addAll(jskyktsl);
	return list;
}

@Override
public List<Object> getxzktmx(String nf, String zymc) {
	List<TjCount> xzktmx=hxMapper.getxzktmx(nf,zymc);
	List<Object> list=new ArrayList<Object>();
	list.addAll(xzktmx);
	return list;
}

@Override
public List<Object> getjyzyjszwsl(String zymc) {
	List<TjCount> jyzyjszwsl=hxMapper.getjyzyjszwsl(zymc);
	List<Object> list=new ArrayList<Object>();
	list.add(new Title(zymc+"教师申报课题数量同比图","nf318"));
	list.addAll(jyzyjszwsl);
	return list;
}

@Override
public List<Object> getjyzyjszwbl(String zymc) {
	List<TjCount> jyzyjszwbl=hxMapper.getjyzyjszwbl(zymc);
	List<Object> list=new ArrayList<Object>();
	list.add(new Title(zymc+"教师申报课题比例同比图","nf319"));
	list.addAll(jyzyjszwbl);
	return list;
}

@Override
public List<Object> getjyzyjszwzmx(String nf, String zymc) {
	List<TjCount> jyzyjszwzmx=hxMapper.getjyzyjszwzmx(nf,zymc);
	List<Object> list=new ArrayList<Object>();
	list.addAll(jyzyjszwzmx);
	return list;
}

@Override
public List<Object> getjyzyzyzgzssl(String zymc) {
	List<TjCount> jyzyzyzgzssl=hxMapper.getjyzyzyzgzssl(zymc);
	List<Object> list=new ArrayList<Object>();
	list.add(new Title(zymc+"具有职业资格证书的教师数量同比图","nf320"));
	list.addAll(jyzyzyzgzssl);
	return list;
}

@Override
public List<Object> getggjssl(String zymc) {
	List<TjCount> ggjssl=hxMapper.getlnggjssl(zymc);
	List<Object> list=new ArrayList<Object>();
	list.add(new Title(zymc+"历年骨干教师数量同比图","nf321"));
	list.addAll(ggjssl);
	return list;
}

@Override
public List<Object> getggjsbl(String zymc) {
	List<TjCount> ggjsbl=hxMapper.getlnggjsbl(zymc);
	List<Object> list=new ArrayList<Object>();
	list.add(new Title(zymc+"历年骨干教师比例同比图","nf322"));
	list.addAll(ggjsbl);
	return list;
}

@Override
public List<Object> getggjsmx(String nf, String zymc) {
	List<TjCount> ggjsmx=hxMapper.getggjsmx(nf,zymc);
	List<Object> list=new ArrayList<Object>();
	list.addAll(ggjsmx);
	return list;
}

@Override
public List<Object> getzyjssl(String zymc) {
	List<TjCount> zyjssl=hxMapper.getzyjssltbt(zymc);
	List<Object> list=new ArrayList<Object>();
	list.add(new Title(zymc+"专业教师数量同比图","nf323"));
	list.addAll(zyjssl);
	return list;
}

@Override
public List<Object> getxdzyjsbl(String zymc) {
	List<TjCount> zyjsbl=hxMapper.getxdzyjsbl(zymc);
	List<Object> list=new ArrayList<Object>();
	list.add(new Title(zymc+"专业教师比例同比图","nf324"));
	list.addAll(zyjsbl);
	return list;
}

@Override
public List<Object> getssxjsbl(String zymc) {
	List<TjCount> lnssxjsbl=hxMapper.getlnssxjsbl(zymc); 
	List<Object> list=new ArrayList<Object>();
	list.add(new Title(zymc+"双师型教师比例同比图","nf325"));
	list.addAll(lnssxjsbl);
	return list;
}

@Override
public List<Object> getssxjssl(String zymc) {
	List<TjCount> ssxjssl=hxMapper.getssxjssl(zymc); 
	List<Object> list=new ArrayList<Object>();
	list.add(new Title(zymc+"双师型教师数量同比图","nf326"));
	list.addAll(ssxjssl);
	return list;
}

@Override
public List<Object> getjxmsbltbt(String zymc) {
	List<TjCount> jxmsbl = hxMapper.getlnjxmsbl(zymc);
	List<Object> list=new ArrayList<Object>();
	list.add(new Title(zymc+"历年教学名师比例同比图","nf327"));
	list.addAll(jxmsbl);
	return list;
}

@Override
public List<Object> getjxmssltbt(String zymc) {
	List<TjCount> jxmssl = hxMapper.getlnjxmssl(zymc);
	List<Object> list=new ArrayList<Object>();
	list.add(new Title(zymc+"历年教学名师数量同比图","nf328"));
	list.addAll(jxmssl);
	return list;
}

@Override
public List<Object> getjxmsmx(String nf, String zymc) {
	List<TjCount> jxmsmx=hxMapper.getjxmsmx(nf,zymc);
	List<Object> list=new ArrayList<Object>();
	list.addAll(jxmsmx);
	return list;
}

@Override
public List<Object> getjshjrstj(String nf, String zymc) {
	List<TjCount> jshjrstj=hxMapper.getjshjrstj(nf,zymc);
	List<Object> list=new ArrayList<Object>();
	list.add(new Title(nf+zymc+"教师获奖人数统计","nf329"));
	list.addAll(jshjrstj);
	return list;
}

@Override
public List<Object> getjshjmx(String nf, String zymc) {
	List<TjCount> jshjmx=hxMapper.getjshjmx(nf,zymc);
	List<Object> list=new ArrayList<Object>();
	list.addAll(jshjmx);
	return list;
}

@Override
public List<TjCount> gethjjsbm() {
	List<TjCount> jshjmx=hxMapper.gethjjsbm();
	return jshjmx;
}

@Override
public List<TjCount> getjygglist() {
	List<TjCount> jygglist=hxMapper.getjygglist();
	return jygglist;
}

@Override
public List<Object> getjyhwdbht(String zymc, String mc) {
	List<TjCount> jyhwdbht=hxMapper.getjyhwdbht(zymc,mc);
	List<Object> list=new ArrayList<Object>();
	list.add(new Title(zymc+mc+"学生就业后稳定性变化图","nf330"));
	list.addAll(jyhwdbht);
	return list;
}

@Override
public List<Object> getlzxsmx(String nf, String zymc, String mc) {
	List<ZgzsEntity> lzxsmx=hxMapper.getlzxsmx(nf,zymc,mc);
	List<Object> list=new ArrayList<Object>();
	list.addAll(lzxsmx);
	return list;
}
//在校生总数
@Override
public TjCount getzxszsl() {
	Integer totalCountStudent = hxMapper.totalCountStudent(null);
	TjCount tjCount = new TjCount("在校生总数","nf331",totalCountStudent);
	return tjCount;
}
//升学、就业学生占比（饼图）
@Override
public List<Object> getsxjyxszb() {
	Integer jyxszb= hxMapper.getsxjyxszb();
	Integer sxxssl=hxMapper.getsxxssl();	
	List<Object> list=new ArrayList<Object>();
	list.add(new Title("升学、就业学生占比","nf352","bt"));
	list.add(new TjCount("升学",sxxssl));
	list.add(new TjCount("就业",jyxszb));
	return list;
}
//招生专业数量
@Override
public TjCount getzszysl() {
	Integer zszysl=hxMapper.getzszysl();
	TjCount tjCount = new TjCount("招生专业数量","nf332",zszysl);
	return tjCount;
}

@Override
public List<Object> getxxzyjgsxt() {
	List<TjCount> zylistList=hxMapper.getzszylist();
	List<Object> list=new ArrayList<Object>();
	list.addAll(zylistList);
	return list;
}
//毕业生去向地区分布图
@Override
public List<Object> getbysjydqfb() {
	List<TjCount> bysjydqfb=hxMapper.getbysjydqfb();
	List<Object> list=new ArrayList<Object>();
	list.add(new Title("毕业生去向地区分布柱形图","nf338"));
	list.addAll(bysjydqfb);
	return list;
}

@Override
public List<TjCount> getbysbydq() {
	List<TjCount> bysbydq=hxMapper.getbysjydq();
	return bysbydq;
}

@Override
public List<Object> getxzdqbyssltbt(String dqmc) {
	List<TjCount> xzdqbyssltbt=hxMapper.getxzdqbyssltbt(dqmc);
	List<Object> list=new ArrayList<Object>();
	list.addAll(xzdqbyssltbt);
	return list;
}

@Override
public List<Object> xzbysqxmx(String nf, String dqmc) {
	List<ZgzsEntity> xzbysqxmx=hxMapper.xzbysqxmx(nf,dqmc);
	List<Object> list=new ArrayList<Object>();
	list.addAll(xzbysqxmx);
	return list;
}
//毕业生去向
@Override
public Map<String, Object> bysqx(String bylx) {
	Map<String, Object> map=new HashMap<String, Object>();
	String qx=null;
	List<TjCount>bys= hxMapper.bysqx(bylx);
	if (bylx.equals("1")) {
		qx="升学";
	}else{
		qx="就业";
	}
	map.put("dataCount", bys);
	map.put("title","各专业毕业生"+qx+"学生数量同比图");
	map.put("param1", "nf700");	
	
	return map;
}
//各类社会服务柱状图
@Override
public List<Object> glshfwsl() {
	List<TjCount> shfwsl=hxMapper.glshfwsl();
	List<Object> list=new ArrayList<Object>();
	list.add(new Title("各类社会服务数量柱状图","nf340"));
	list.addAll(shfwsl);
	return list;
}

@Override
public List<TjCount> shfwlist() {
	List<TjCount> shfwlist=hxMapper.shfwlist();
	return shfwlist;
}

@Override
public List<Object> getshfwsktbt(String mc) {
	List<TjCount> xzbysqxmx=hxMapper.getshfwsktbt(mc);
	List<Object> list=new ArrayList<Object>();
	list.addAll(xzbysqxmx);
	return list;
}

@Override
public List<Object> xzfwmx(String nf, String mc) {
	List<ZgzsEntity> xzfwmx=hxMapper.xzfwmx(nf,mc);
	List<Object> list=new ArrayList<Object>();
	list.addAll(xzfwmx);
	return list;
}
//辍学学生比例
@Override
public TjCount getcxxsbl() {
	Double cxxsbl=hxMapper.getcxxsbl();
	TjCount cxxs = new TjCount("辍学学生比例","nf341","1/"+cxxsbl);
	return cxxs;
}

@Override
public List<Object> getcxxsbltbt(String zymc) {
	List<TjCount> cxxsbltbt=hxMapper.getcxxsbltbt(zymc);
	List<Object> list=new ArrayList<Object>();
	list.addAll(cxxsbltbt);
	return list;
}

@Override
public List<Object> cxxsmx(String nf, String zymc) {
	List<StudentEntity> cxxsbltbt=hxMapper.cxxsmx(nf,zymc);
	List<Object> list=new ArrayList<Object>();
	list.addAll(cxxsbltbt);
	return list;
}
//应届毕业生双证获取率
@Override
public TjCount getyjbysszhql() {
	Double sshql=hxMapper.getyjbysszhql();
	TjCount cxxs = new TjCount("应届毕业生双证获取率","nf343",sshql*100+"%");
	return cxxs;
}

@Override
public List<Object> getlnyjbysszhql(String zymc) {
	List<TjCount> lnyjbysszhql=hxMapper.getlnyjbysszhql(zymc);
	List<Object> list=new ArrayList<Object>();
	list.addAll(lnyjbysszhql);
	return list;
}

@Override
public List<Object> getyjbysszhqmd(String nf, String zymc) {
	List<ZgzsEntity> yjbysszhqmd=hxMapper.getyjbysszhqmd(nf,zymc);
	List<Object> list=new ArrayList<Object>();
	list.addAll(yjbysszhqmd);
	return list;
}

@Override
public List<TjCount> byhmxlist() {
	List<TjCount> byhmxlist = hxMapper.byhmxlist();
	return byhmxlist;
}
//应届毕业生对口就业率
@Override
public TjCount getbysdkjyl() {
	Double bysjyl=hxMapper.getyjbysjyl();
	TjCount cxxs = new TjCount("应届毕业生对口率","nf345",bysjyl);
	return cxxs;
}

@Override
public List<Object> yjsdkjyltbt(String zymc) {
	List<TjCount> yjsdkjytbt=hxMapper.getlndkjybl(zymc);
	List<Object> list=new ArrayList<Object>();
	list.addAll(yjsdkjytbt);
	return list;
}
//上届毕业生满意度
@Override
public TjCount getsjbysmyd() {
	Double sjbysmyd=hxMapper.getsjbysmyd();
	TjCount cxxs = new TjCount("上届毕业生满意度","nf346",sjbysmyd);
	return cxxs;
}
//德育工作机构一览表
@Override
public List<Object> getdygzjg() {
	List<TjCount> dygzjg=hxMapper.getdygzjg();
	List<Object> list=new ArrayList<Object>();
	list.add(new Title("德育工作机构一览表","nf347",null,true));
	list.addAll(dygzjg);
	return list;
}

@Override
public List<TjCount> getdygzjglist() {
	List<TjCount> dygzjg=hxMapper.getdygzjg();
	return dygzjg;
}
@Override
public List<Object> getdyjgmd(String mc) {
	List<TjCount> dyjgmd=hxMapper.getdyjgmd(mc);
	List<Object> list=new ArrayList<Object>();
	list.addAll(dyjgmd);
	return list;
}
//应届毕业生体质达标率
@Override
public TjCount getyjstzdbl() {
	Double bystzdbl=hxMapper.getyjstzdbl();
	TjCount cxxs = new TjCount("应届毕业生体质达标率","nf348",bystzdbl);
	return cxxs;
}

@Override
public List<Object> getlnyjbystzdbl(String zymc) {
	List<TjCount> lnyjbystzdbl=hxMapper.getlnyjbystzdbl(zymc);
	List<Object> list=new ArrayList<Object>();
	list.addAll(lnyjbystzdbl);
	return list;
}

@Override
public List<Object> getbystzfsmd(String nf, String zymc) {
	List<TjCount> bystzfsmd=hxMapper.getbystzfsmd(nf,zymc);
	List<Object> list=new ArrayList<Object>();
	list.addAll(bystzfsmd);
	return list;
}
//当年学生实际违纪率
@Override
public TjCount getxxsjwjl() {
	Double xxsjwjl=hxMapper.getxxsjwjl();
	TjCount cxxs = new TjCount("学生违纪率","nf351",xxsjwjl);
	return cxxs;
}

@Override
public List<Object> getdqxssjwjl(String zymc) {
	List<TjCount> dqxssjwjl=hxMapper.getdqxssjwjl(zymc);
	List<Object> list=new ArrayList<Object>();
	list.addAll(dqxssjwjl);
	return list;
}

@Override
public List<Object> getxdxswjmd(String nf, String zymc) {
	List<TjCount> xdxswjmd=hxMapper.getxdxswjmd(nf,zymc);
	List<Object> list=new ArrayList<Object>();
	list.addAll(xdxswjmd);
	return list;
}
//新设、停招、撤销专业名单
@Override
public List<Object> getbdzymd() {
	List<TjCount> xdxswjmd=hxMapper.getbdzymd();
	List<Object> list=new ArrayList<Object>();
	list.addAll(xdxswjmd);
	return list;
}
//德育课程开设一览表
@Override
public List<Object> getdykcylb() {
	List<TjCount> dykcylb=hxMapper.getdykcylb();
	List<Object> list=new ArrayList<Object>();
	list.add(new Title("德育课程开设一览表","nf354",null,true));
	list.addAll(dykcylb);
	return list;
}

@Override
public List<Object> getkccjfb(String kcmc) {
	List<TjCount> dycjfb=hxMapper.getkccjfb(kcmc);
	List<Object> list=new ArrayList<Object>();
	list.addAll(dycjfb);
	return list;
}

@Override
public List<Object> xscj(String zymc, String kcmc, String nf) {
	List<TjCount> xscjCounts=hxMapper.getkscj(zymc,kcmc,nf);
	List<Object> list=new ArrayList<Object>();
	list.addAll(xscjCounts);
	return list;
}

@Override
public List<Object> kccjmx(String kcmc, String dg) {
	List<TjCount> kccjmx=hxMapper.getkccjmx(kcmc,dg);
	List<Object> list=new ArrayList<Object>();
	list.addAll(kccjmx);
	return list;
}
//德育工作队伍人数同比图
@Override
public List<Object> getdygzdwtbt() {
	List<TjCount> dygzdwsl=hxMapper.getlndygzdwsl();
	List<Object> list=new ArrayList<Object>();
	list.add(new Title("德育工作队伍人数同比图","nf355"));
	list.addAll(dygzdwsl);
	return list;
}

@Override
public List<Object> xzdycymx(String nf) {
	List<TjCount> xzdycymx=hxMapper.getxzdycymx(nf);
	List<Object> list=new ArrayList<Object>();
	list.addAll(xzdycymx);
	return list;
}
//当年创新教学建设成果一览表
@Override
public List<Object> getcxjxjscg() {
	List<TjCount> cxjxjscg=hxMapper.getcxjxjscg();
	List<Object> list=new ArrayList<Object>();
	list.add(new Title("当年创新型教学建设成果一览表","nf356",null,true));
	list.addAll(cxjxjscg);
	return list;
}
//已建成素质教育标志性成果一览表
@Override
public List<Object> getszjybzxcg() {
	List<TjCount> szjybzxcg=hxMapper.getszjybzxcg();
	List<Object> list=new ArrayList<Object>();
	list.add(new Title("已建成素质教育标志性成果一览表","nf357",null,true));
	list.addAll(szjybzxcg);
	return list;
}
//社会实践活动开设情况技成果一览表
@Override
public List<Object> getshsjhdcg() {
	List<TjCount> shsjhdcg=hxMapper.getshsjhdcg();
	List<Object> list=new ArrayList<Object>();
	list.add(new Title("社会实践活动开设情况及成果一览表","nf358",null,true));
	list.addAll(shsjhdcg);
	return list;
}

@Override
public List<Object> getsxxstbt(String zymc, String mc) {
	List<Object> list=new ArrayList<Object>();
	List<TjCount> sxxstbt = new ArrayList<TjCount>();
	if("升学".equals(mc)){
		sxxstbt=hxMapper.getsxxstbt(zymc,mc);
	}else{
		if("就业".equals(mc)){
			sxxstbt=hxMapper.getjyxstbt(zymc,mc);
		}
	}
	list.addAll(sxxstbt);
	return list;
}

@Override
public List<Object> xzsxxsmx(String nf, String zymc, String mc) {
	List<Object> list=new ArrayList<Object>();
	List<TjCount> sxxsmx = new ArrayList<TjCount>();
	if("升学".equals(mc)){
		sxxsmx=hxMapper.getsxxsmxd(zymc,mc,nf);
	}else{
		if("就业".equals(mc)){
			sxxsmx=hxMapper.getjyxsmxd(zymc,mc,nf);
		}
	}
	list.addAll(sxxsmx);
	return list;
}
//各专业在校学生数量
@Override
public List<TjCount> getgzyxsslzzt() {
	List<TjCount> list = new ArrayList<TjCount>();
	TjCount tjCount = new TjCount("各专业在校生数量柱状图","nf361");
	list.add(tjCount);
	List<TjCount> gzy=hxMapper.getfenzy();
	list.addAll(gzy);
	return list;
}
//各专业录取数柱状图
@Override
public List<Object> getgzylqzzt() {
	List<TjCount> gzyxslqsl=hxMapper.getgzylqzzt();
	List<Object> list=new ArrayList<Object>();
	list.add(new Title("各专业新生录取数量柱状图","nf363"));
	list.addAll(gzyxslqsl);
	return list;
}

@Override
public List<Object> getlnxslqsl(String zymc) {
	List<TjCount> gzyxslqsl=hxMapper.getgzyxssltbt(zymc);
	List<Object> list=new ArrayList<Object>();
	list.addAll(gzyxslqsl);
	return list;
}

@Override
public List<Object> xdnfzyxsmx(String nf, String zymc) {
	List<StudentEntity> getstuListbyZyNf = hxMapper.getstuListbyZyNf(nf, zymc);
	List<Object> list=new ArrayList<Object>();
	list.addAll(getstuListbyZyNf);
	return list;
}
//就业率低于省内同类专业平均值专业占比
@Override
public TjCount getjyldysnpjz() {
	Double yldysnpjz=hxMapper.getjyldysnpjz();
	TjCount tjCount = new TjCount("就业率低于省内同类专业平均值专业占比","nf364",yldysnpjz);
	return tjCount;
}

@Override
public List<Object> dypjzymd() {
	List<TjCount> dypjzymd=hxMapper.dypjzymd();
	List<Object> list=new ArrayList<Object>();
	list.addAll(dypjzymd);
	return list;
}
//专业建设标志性成果一览表
@Override
public List<Object> zyjsbzxcg() {
	List<TjCount> zyjsbzxcg=hxMapper.zyjsbzxcg();
	List<Object> list=new ArrayList<Object>();
	list.add(new Title("专业建设标志性成果一览表","nf365",null,true));
	list.addAll(zyjsbzxcg);
	return list;
}
//完成课程建设项目数
@Override
public TjCount wckcjsxms() {
	Integer wckcjsxms=hxMapper.getwckcjsxms();
	TjCount tjCount = new TjCount("完成课程建设项目数","nf366",wckcjsxms);
	return tjCount;
}

@Override
public List<Object> wckcjsxmmx(String nf) {
	List<TjCount> wckcjsxmmx=hxMapper.wckcjsxmmx(nf);
	List<Object> list=new ArrayList<Object>();
	list.addAll(wckcjsxmmx);
	return list;
}

@Override
public List<Object> wckcjsxmstbt() {
	List<TjCount> wckcjsxmstbt=hxMapper.wckcjsxmstbt();
	List<Object> list=new ArrayList<Object>();
	list.addAll(wckcjsxmstbt);
	return list;
}
//已制定课程标准数
@Override
public TjCount yzdkcbzs() {
	Integer yzdkcbzs=hxMapper.yzdkcbzs();
	TjCount tjCount = new TjCount("已制定课程标准数","nf368",yzdkcbzs);
	return tjCount;
}

@Override
public List<Object> yzdkcbzmx(String nf) {
	List<TjCount> yzdkcbzmx=hxMapper.yzdkcbzmx(nf);
	List<Object> list=new ArrayList<Object>();
	list.addAll(yzdkcbzmx);
	return list;
}

@Override
public List<Object> yzdkcbzstbt() {
	List<TjCount> yzdkcbzstbt=hxMapper.yzdkcbzstbt();
	List<Object> list=new ArrayList<Object>();
	list.addAll(yzdkcbzstbt);
	return list;
}
//校企合作开发课程数
@Override
public TjCount xqkfkcs() {
	Integer xqkfkcs=hxMapper.xqkfkcs();
	TjCount tjCount = new TjCount("校企合作开发课程数","nf370",xqkfkcs);
	return tjCount;
}

@Override
public List<Object> xqkfkcsmx(String nf) {
	List<TjCount> xqkfkcsmx=hxMapper.xqkfkcsmx(nf);
	List<Object> list=new ArrayList<Object>();
	list.addAll(xqkfkcsmx);
	return list;
}

@Override
public List<Object> xqkfkcstbt() {
	List<TjCount> xqkfkcstbt=hxMapper.xqkfkcstbt();
	List<Object> list=new ArrayList<Object>();
	list.addAll(xqkfkcstbt);
	return list;
}
//校企合作开发教材数
@Override
public TjCount xqkfjcs() {
	Integer xqkfkcs=hxMapper.xqkfjcs();
	TjCount tjCount = new TjCount("校企合作开发教材数","nf371",xqkfkcs);
	return tjCount;
}

@Override
public List<Object> xqkfjcstbt() {
	List<TjCount> xqkfjcstbt=hxMapper.xqkfjcstbt();
	List<Object> list=new ArrayList<Object>();
	list.addAll(xqkfjcstbt);
	return list;
}

@Override
public List<Object> xqkfjcsmx(String nf) {
	List<TjCount> xqkfjcsmx=hxMapper.xqkfjcsmx(nf);
	List<Object> list=new ArrayList<Object>();
	list.addAll(xqkfjcsmx);
	return list;
}
//课程建设标志性成果一览表
@Override
public List<Object> kcjsbzxcgylb() {
	List<TjCount> kcjsbzxcgylb=hxMapper.kcjsbzxcgylb();
	List<Object> list=new ArrayList<Object>();
	list.add(new Title("课程建设标志性成果一览表","nf373",null,true));
	list.addAll(kcjsbzxcgylb);
	return list;
}
//师资队伍数量
@Override
public TjCount getszdwsl() {
	Integer getjscount = hxMapper.getjscount();
	TjCount tjCount = new TjCount("师资队伍数量","nf375",getjscount);
	return tjCount;
}

@Override
public List<Object> szdwsltbt(String zymc) {
	List<JzgEntity> szdwsltbt=hxMapper.szdwsltbt(zymc);
	List<Object> list=new ArrayList<Object>();
	list.addAll(szdwsltbt);
	return list;
}

@Override
public List<JzgEntity> sznfzyjsmd(String zymc, String nf) {
	List<JzgEntity> sznfzyjsmd=hxMapper.sznfzyjsmd(nf,zymc);
	return sznfzyjsmd;
}
//师资队伍数量（按年龄分布，分专业）
@Override
public List<Object> getszdwslnlft(String zymc) {
	List<TjCount> szdwslnlft=hxMapper.getszdwslnlft(zymc);
	List<Object> list=new ArrayList<Object>();
	list.add(new Title(zymc+"师资队伍年龄分布情况","nf377"));
	list.addAll(szdwslnlft);
	return list;
}

@Override
public List<JzgEntity> xznljsmd(String zymc, String nf, String aged) {
	List<JzgEntity> xznljssltbt=hxMapper.xznljsmd(nf,zymc,aged);
	return xznljssltbt;
}

@Override
public List<Object> xznljssltbt(String zymc, String aged) {
	List<TjCount> xznljssltbt=hxMapper.xznljssltbt(zymc,aged);
	List<Object> list=new ArrayList<Object>();
	list.addAll(xznljssltbt);
	return list;
}
//师资队伍数量（按职称分布，分专业）
@Override
public List<Object> getszdwzcft(String zymc) {
	List<TjCount> szdwzcft=hxMapper.getszdwzcft(zymc);
	List<Object> list=new ArrayList<Object>();
	list.add(new Title("师资队伍分布（按职称分布）","nf379"));
	list.addAll(szdwzcft);
	return list; 
}
//师资队伍数量（按工作年限分布，分专业）
@Override
public List<Object> szdwgznfft(String zymc) {
	List<TjCount> szdwgznfft=hxMapper.getszdwgznfft(zymc);
	List<Object> list=new ArrayList<Object>();
	list.add(new Title("师资队伍分布（按工作年数分布）","nf383"));
	list.addAll(szdwgznfft);
	return list; 
}

@Override
public List<Object> szdwgznftbt(String zymc, String dg) {
	List<TjCount> szdwgznftbt=hxMapper.szdwgznftbt(zymc,dg);
	List<Object> list=new ArrayList<Object>();
	list.addAll(szdwgznftbt);
	return list;
}
//规划教材使用比
@Override
public TjCount getghjcsyb() {
	Double ghjcsyb=hxMapper.getghjcsyb();
	TjCount tjCount = new TjCount("规划教材使用比","nf384",ghjcsyb);
	return tjCount;
}

@Override
public List<Object> ghjcsybtbt() {
	List<TjCount> ghjcsybtbt=hxMapper.ghjcsybtbt();
	List<Object> list=new ArrayList<Object>();
	list.addAll(ghjcsybtbt);
	return list;
}

@Override
public List<Object> ghjcsymx(String nf) {
	List<TjCount> ghjcsymx=hxMapper.ghjcsymx(nf);
	List<Object> list=new ArrayList<Object>();
	list.addAll(ghjcsymx);
	return list;
}
//校本教材开发数量
@Override
public TjCount getjbjcsyb() {
	Double jbjcsyb=hxMapper.getjbjcsyb();
	TjCount tjCount = new TjCount("规划教材使用比","nf387",jbjcsyb);
	return tjCount;
}

@Override
public List<Object> jbjcsybtbt() {
	List<TjCount> jbjcsybtbt=hxMapper.jbjcsybtbt();
	List<Object> list=new ArrayList<Object>();
	list.addAll(jbjcsybtbt);
	return list;
}

@Override
public List<Object> jbjcsymx(String nf) {
	List<TjCount> jbjcsymx=hxMapper.jbjcsymx(nf);
	List<Object> list=new ArrayList<Object>();
	list.addAll(jbjcsymx);
	return list;
}
//领导听课。听说课人均次数
@Override
public TjCount ldtskrjsl() {
	Double ldtskrjsl=hxMapper.getldtskrjsl();
	TjCount tjCount = new TjCount("领导听课、听说课人均次数","nf389",ldtskrjsl);
	return tjCount;
}

@Override
public List<Object> ldtskrjsltbt() {
	List<TjCount> ldtskrjsltbt=hxMapper.ldtskrjsltbt();
	List<Object> list=new ArrayList<Object>();
	list.addAll(ldtskrjsltbt);
	return list;
}

@Override
public List<Object> ldtskrjslmx(String nf) {
	List<TjCount> ldtskrjslmx=hxMapper.ldtskrjslmx(nf);
	List<Object> list=new ArrayList<Object>();
	list.addAll(ldtskrjslmx);
	return list;
}
//领导深入实践场所人均次数
@Override
public TjCount ldrssjcssl() {
	Double ldrssjcssl=hxMapper.ldrssjcssl();
	TjCount tjCount = new TjCount("领导深入教学实践场所人均次数","nf390",ldrssjcssl);
	return tjCount;
}

@Override
public List<Object> ldrssjcstbt() {
	List<TjCount> ldrssjcstbt=hxMapper.ldrssjcstbt();
	List<Object> list=new ArrayList<Object>();
	list.addAll(ldrssjcstbt);
	return list;
}

@Override
public List<Object> ldrssjcsqd(String nf) {
	List<TjCount> ldrssjcsqd=hxMapper.ldrssjcsqd(nf);
	List<Object> list=new ArrayList<Object>();
	list.addAll(ldrssjcsqd);
	return list;
}
//同行评教覆盖面
@Override
public TjCount thpjfgm() {
	Double thpjfgm=0.95;
	TjCount tjCount = new TjCount("同行评教覆盖面","nf391",thpjfgm);
	return tjCount;
}
//学生评教覆盖面
@Override
public TjCount xspjylb() {
	Double xspjylb=0.94;
	TjCount tjCount = new TjCount("同行评教覆盖面","nf403",xspjylb);
	return tjCount;
}
//社会评教覆盖面
@Override
public TjCount shpjylb() {
	Double shpjylb=0.95;
	TjCount tjCount = new TjCount("同行评教覆盖面","nf404",shpjylb);
	return tjCount;
}

@Override
public List<Object> thkcpjxj() {
	List<TjCount> thkcpjxj=hxMapper.thkcpjxj();
	List<Object> list=new ArrayList<Object>();
	list.addAll(thkcpjxj);
	return list;
}

@Override
public List<Object> thkcpjpfr(String kcmc, String dg) {
	List<TjCount> thkcpjpfr=hxMapper.thkcpjpfr(kcmc,dg);
	List<Object> list=new ArrayList<Object>();
	list.addAll(thkcpjpfr);
	return list;
}
//实践项目开出率
@Override
public TjCount sjxmkcl() {
	Double sjxmkcl=hxMapper.getsjkcl();
	TjCount tjCount = new TjCount("实践项目开出率","nf393",sjxmkcl);
	return tjCount;
}

@Override
public List<Object> sjxmkcltbt() {
	List<TjCount> sjxmkcltbt=hxMapper.sjxmkcltbt();
	List<Object> list=new ArrayList<Object>();
	list.addAll(sjxmkcltbt);
	return list;
}

@Override
public List<Object> sjxmkclylb(String nf) {
	List<TjCount> sjxmkclylb=hxMapper.sjxmkclylb(nf);
	List<Object> list=new ArrayList<Object>();
	list.addAll(sjxmkclylb);
	return list;
}
//校党政联席会议解决的教学问题数量
@Override
public TjCount xdzlxjjwtsl() {
	Integer xdzlxjjwtsl=hxMapper.xdzlxjjwtsl();
	TjCount tjCount = new TjCount("校党政联席解决的教学问题的数量","nf396",xdzlxjjwtsl);
	return tjCount;
}

@Override
public List<Object> lnxdzlxjjwtsl() {
	List<TjCount> lnxdzlxjjwtsl=hxMapper.lnxdzlxjjwtsl();
	List<Object> list=new ArrayList<Object>();
	list.addAll(lnxdzlxjjwtsl);
	return list;
}

@Override
public List<Object> xdzlxjjwtmxt(String nf) {
	List<TjCount> xdzlxjjwtmxt=hxMapper.xdzlxjjwtmxt(nf);
	List<Object> list=new ArrayList<Object>();
	list.addAll(xdzlxjjwtmxt);
	return list;
}
//教学事故数量
@Override
public TjCount getjxsgsl() {
	Integer jxsgsl=hxMapper.getjxsgsl();
	TjCount tjCount = new TjCount("教学 事故数量","nf397",jxsgsl);
	return tjCount;
}

@Override
public List<Object> lnjxsgsl() {
	List<TjCount> lnjxsgsl=hxMapper.lnjxsgsl();
	List<Object> list=new ArrayList<Object>();
	list.addAll(lnjxsgsl);
	return list;
}

@Override
public List<Object> jxsgmx(String nf) {
	List<TjCount> jxsgmx=hxMapper.jxsgmx(nf);
	List<Object> list=new ArrayList<Object>();
	list.addAll(jxsgmx);
	return list;
}
//学生迟到率
@Override
public TjCount xscdl() {
	Double xscdl=hxMapper.getxscdl();
	TjCount tjCount = new TjCount("学生迟到率","nf402",xscdl);
	return tjCount;
}
//学生缺课率
@Override
public TjCount xsqkl() {
	Double xsqkl=hxMapper.xsqkl();
	TjCount tjCount = new TjCount("学生缺课率","nf403",xsqkl);
	return tjCount;
}

@Override
public List<Object> xscdltbt() {
	List<TjCount> xscdltbt=hxMapper.xscdltbt();
	List<Object> list=new ArrayList<Object>();
	list.addAll(xscdltbt);
	return list;
}

@Override
public List<Object> xsqkltbt() {
	List<TjCount> xsqkltbt=hxMapper.xsqkltbt();
	List<Object> list=new ArrayList<Object>();
	list.addAll(xsqkltbt);
	return list;
}

@Override
public List<Object> xscdmx(String nf) {
	List<TjCount> xscdmx=hxMapper.xscdmx(nf);
	List<Object> list=new ArrayList<Object>();
	list.addAll(xscdmx);
	return list;
}

@Override
public List<Object> xsqkmx(String nf) {
	List<TjCount> xsqkmx=hxMapper.xsqkmx(nf);
	List<Object> list=new ArrayList<Object>();
	list.addAll(xsqkmx);
	return list;
}

@Override
public List<Object> xskcpjxj() {
	List<TjCount> xskcpjxj=hxMapper.xskcpjxj();
	List<Object> list=new ArrayList<Object>();
	list.addAll(xskcpjxj);
	return list;
}

@Override
public List<Object> xskcpjpfr(String kcmc, String dg) {
	List<TjCount> xskcpjpfr=hxMapper.xskcpjpfr(kcmc,dg);
	List<Object> list=new ArrayList<Object>();
	list.addAll(xskcpjpfr);
	return list;
}

@Override
public List<Object> shkcpjxj() {
	List<TjCount> shkcpjxj=hxMapper.shkcpjxj();
	List<Object> list=new ArrayList<Object>();
	list.addAll(shkcpjxj);
	return list;
}

@Override
public List<Object> shkcpjpfr(String kcmc, String dg) {
	List<TjCount> shkcpjpfr=hxMapper.shkcpjpfr(kcmc,dg);
	List<Object> list=new ArrayList<Object>();
	list.addAll(shkcpjpfr);
	return list;
}
//师资队伍数量（按学历分布，分专业）
@Override
public List<Object> szdwgxlft(String zymc) {
	List<TjCount> szdwgxlft=hxMapper.szdwgxlft(zymc);
	List<Object> list=new ArrayList<Object>();
	list.add(new Title("师资队伍数量","nf408"));
	list.addAll(szdwgxlft);
	return list;
}

@Override
public List<Object> lnszdwxltbt(String zymc, String dg) {
	List<TjCount> lnszdwxl=hxMapper.lnszdwxltbt(zymc,dg);
	List<Object> list=new ArrayList<Object>();
	list.addAll(lnszdwxl);
	return list;
}

@Override
public List<Object> szdwxlmd(String nf, String zymc, String dg) {
	List<TjCount> szdwxlmd=hxMapper.szdwxlmd(nf,zymc,dg);
	List<Object> list=new ArrayList<Object>();
	list.addAll(szdwxlmd);
	return list;
}
//专业带头人和骨干教师数量
@Override
public TjCount zydtrggjssl() {
	Integer zydtrggjssl=hxMapper.zydtrggjssl();
	TjCount tjCount = new TjCount("专业带头人和骨干教师数量","nf410",zydtrggjssl);
	return tjCount;
}

@Override
public List<Object> lnzydtrggjs(String zymc) {
	List<TjCount> lnzydtrggjs=hxMapper.lnzydtrggjs(zymc);
	List<Object> list=new ArrayList<Object>();
	list.addAll(lnzydtrggjs);
	return list;
}

@Override
public List<Object> zydtrggjsmd(String nf, String zymc) {
	List<JzgEntity> zydtrggjsmd=hxMapper.zydtrggjsmd(nf,zymc);
	List<Object> list=new ArrayList<Object>();
	list.addAll(zydtrggjsmd);
	return list;
}
//教师培训类型与数量一览表
@Override
public List<Object> jspxlxslylb() {
	List<TjCount> jspxlxslylb=hxMapper.jspxlxslylb();
	List<Object> list=new ArrayList<Object>();
	list.add(new Title("教师培训类型与数量一览表","nf410",null,true));
	list.addAll(jspxlxslylb);
	return list;
}

@Override
public List<Object> jspxlxmd(String mc) {
	List<TjCount> jspxlxmd=hxMapper.jspxlxmd(mc);
	List<Object> list=new ArrayList<Object>();
	list.addAll(jspxlxmd);
	return list;
}
//各专业教师数量一览表
@Override
public List<Object> gzyjsslylb() {
	List<TjCount> gzyjsslylb=hxMapper.getgzyjssl();
	List<Object> list=new ArrayList<Object>();
	list.add(new Title("各专业教师数量一览表","nf413",null,true));
	list.addAll(gzyjsslylb);
	return list;
}

@Override
public List<Object> jsqysjqkylb() {
	List<TjCount> jsqysjqkylb=hxMapper.jsqysjqkylb();
	List<Object> list=new ArrayList<Object>();
	list.add(new Title("教师企业实践情况一览表","nf414",null,true));
	list.addAll(jsqysjqkylb);
	return list;
}
//外籍教师数量
@Override
public TjCount wjjssl() {
	Integer wjjssl=hxMapper.getwjjssl();
	TjCount tjCount = new TjCount("外籍教师数量","nf412",wjjssl);
	return tjCount;
}
//教师教研、科研、技术开发和社会服务成果一览表
@Override
public List<Object> jsjykyylb() {
	List<TjCount> jsjykyylb=hxMapper.jsjykyylb();
	List<Object> list=new ArrayList<Object>();
	list.add(new Title("教师教研、科研、技术开发和社会服务成果一览表","nf411",null,true));
	list.addAll(jsjykyylb);
	return list;
}
//专任教师"双师型"比例
@Override
public TjCount getzrjsssxjsbl() {
	Double ssxjsbl=hxMapper.getzrssxjsbl();
	TjCount tjCount = new TjCount("专任教师”双师型“比例","nf415",ssxjsbl);
	return tjCount;
}

@Override
public List<Object> zrjsssxjsbltbt(String zymc) {
	List<TjCount> zrjsssxjsbltbt=hxMapper.zrjsssxjsbltbt(zymc);
	List<Object> list=new ArrayList<Object>();
	list.addAll(zrjsssxjsbltbt);
	return list;
}

@Override
public List<Object> zrjsssxjsmd(String nf, String zymc) {
	List<TjCount> zrjsssxjsmd=hxMapper.zrjsssxjsmd(nf,zymc);
	List<Object> list=new ArrayList<Object>();
	list.addAll(zrjsssxjsmd);
	return list;
}
//实践教学专职指导教师数量
@Override
public TjCount sjjxzzzdjssl() {
	Integer sjjxzzzdjssl=hxMapper.getsjjxzzzdjssl();
	TjCount tjCount = new TjCount("实践教学专职指导教师数量","nf418",sjjxzzzdjssl);
	return tjCount;
}

@Override
public List<Object> lnzzzdjssl(String zymc) {
	List<TjCount> lnzzzdjssl=hxMapper.lnzzzdjssl(zymc);
	List<Object> list=new ArrayList<Object>();
	list.addAll(lnzzzdjssl);
	return list;
}

@Override
public List<Object> zzzdjsmd(String nf, String zymc) {
	List<TjCount> zzzdjsmd=hxMapper.zzzdjsmd(nf,zymc);
	List<Object> list=new ArrayList<Object>();
	list.addAll(zzzdjsmd);
	return list;
}

@Override
public TjCount jzszdwsl() {
	Integer jzszdwsl=hxMapper.getjzszdwsl();
	TjCount tjCount = new TjCount("兼职师资队伍数量","nf420",jzszdwsl);
	return tjCount;
}

@Override
public List<Object> jzjssltbt(String zymc) {
	List<TjCount> jzjssltbt=hxMapper.jzjssltbt(zymc);
	List<Object> list=new ArrayList<Object>();
	list.addAll(jzjssltbt);
	return list;
}

@Override
public List<Object> getjzszmd(String nf, String zymc) {
	List<TjCount> jzszmd=hxMapper.getjzszmd(nf,zymc);
	List<Object> list=new ArrayList<Object>();
	list.addAll(jzszmd);
	return list;
}

@Override
public List<Object> jzszdwslnlft(String zymc) {
	List<TjCount> jzszdwsl=hxMapper.jzszdwslnlft();
	List<Object> list=new ArrayList<Object>();
	list.add(new Title("兼职师资队伍数量（按年龄分布）","nf422"));
	list.addAll(jzszdwsl);
	return list;
}

@Override
public List<Object> jzjsnltbt(String zymc,String aged) {
	List<TjCount> jzjsnltbt=hxMapper.jzjsnltbt(zymc,aged);
	List<Object> list=new ArrayList<Object>();
	list.addAll(jzjsnltbt);
	return list;
}

@Override
public List<Object> jzsznlmd(String nf, String zymc,String aged) {
	List<TjCount> jzszmd=hxMapper.jzsznlmd(nf,zymc,aged);
	List<Object> list=new ArrayList<Object>();
	list.addAll(jzszmd);
	return list;
}

@Override
public List<Object> jzszdwzcft(String zymc) {
	List<TjCount> jzszdwzcft=hxMapper.jzszdwzcft(zymc);
	List<Object> list=new ArrayList<Object>();
	list.add(new Title("兼职师资队伍数量（按职称分布）","nf423"));
	list.addAll(jzszdwzcft);
	return list;
}

@Override
public List<Object> jzjszctbt(String zymc, String dg) {
	List<TjCount> jzjszctbt=hxMapper.jzjszctbt(zymc,dg);
	List<Object> list=new ArrayList<Object>();
	list.addAll(jzjszctbt);
	return list;
}

@Override
public List<Object> jzszzcmd(String nf, String zymc, String dg) {
	List<TjCount> jzszzcmd=hxMapper.jzszzcmd(nf,zymc,dg);
	List<Object> list=new ArrayList<Object>();
	list.addAll(jzszzcmd);
	return list;
}

@Override
public List<Object> jzszdwgznffb(String zymc) {
	List<TjCount> jzszdwgznffb=hxMapper.jzszdwgznffb(zymc);
	List<Object> list=new ArrayList<Object>();
	list.add(new Title("兼职师资队伍数量（按工作年限分布）","nf426"));
	list.addAll(jzszdwgznffb);
	return list;
}

@Override
public List<Object> jzjsgznftbt(String zymc, String dg) {
	List<TjCount> jzjsgznftbt=hxMapper.jzjsgznftbt(zymc,dg);
	List<Object> list=new ArrayList<Object>();
	list.addAll(jzjsgznftbt);
	return list;
}

@Override
public List<Object> jzszgznfmd(String nf, String zymc, String dg) {
	List<TjCount> jzszzcmd=hxMapper.jzszgznfmd(nf,zymc,dg);
	List<Object> list=new ArrayList<Object>();
	list.addAll(jzszzcmd);
	return list;
}

@Override
public List<Object> jzszdwgxlft(String zymc) {
	List<TjCount> jzszdwgxlft=hxMapper.jzszdwgxlft(zymc);
	List<Object> list=new ArrayList<Object>();
	list.add(new Title("兼职师资队伍数量（按学历分布）","nf428"));
	list.addAll(jzszdwgxlft);
	return list;
}

@Override
public List<Object> jzszdwgxltbt(String zymc, String dg) {
	List<TjCount> jzszdwgxltbt=hxMapper.jzszdwgxltbt(zymc,dg);
	List<Object> list=new ArrayList<Object>();
	list.addAll(jzszdwgxltbt);
	return list;
}

@Override
public List<Object> jzszdwgxlmd(String nf, String zymc, String dg) {
	List<TjCount> jzszdwgxlmd=hxMapper.jzszdwgxlmd(nf,zymc,dg);
	List<Object> list=new ArrayList<Object>();
	list.addAll(jzszdwgxlmd);
	return list;
}

@Override
public TjCount jzzydtrggjssl() {
	Integer jzzydtrggjssl=hxMapper.jzzydtrggjssl();
	TjCount tjCount = new TjCount("兼职专业带头人数量","nf430",jzzydtrggjssl);
	return tjCount;
}

@Override
public List<Object> jzzydtrggjstbt(String zymc) {
	List<TjCount> jzzydtrggjstbt=hxMapper.jzzydtrggjstbt(zymc);
	List<Object> list=new ArrayList<Object>();
	list.addAll(jzzydtrggjstbt);
	return list;
}

@Override
public List<Object> jzzydtrggjsmd(String nf, String zymc) {
	List<TjCount> jzzydtrggjsmd=hxMapper.jzzydtrggjsmd(nf,zymc);
	List<Object> list=new ArrayList<Object>();
	list.addAll(jzzydtrggjsmd);
	return list;
}

@Override
public TjCount jzjspxsl() {
	Integer jzjspxsl=hxMapper.jzjspxsl();
	TjCount tjCount = new TjCount("兼职教师培训数量","nf432",jzjspxsl);
	return tjCount;
}

@Override
public List<Object> jzjspxsltbt() {
	List<TjCount> jzjspxsltbt=hxMapper.jzjspxsltbt();
	List<Object> list=new ArrayList<Object>();
	list.addAll(jzjspxsltbt);
	return list;
}

@Override
public List<Object> jzjspxmd(String nf) {
	List<TjCount> jzjspxmd=hxMapper.jzjspxmd(nf);
	List<Object> list=new ArrayList<Object>();
	list.addAll(jzjspxmd);
	return list;
}

@Override
public List<Object> jzszdwzypz() {
	List<TjCount> jzszdwzypz=hxMapper.jzszdwzypz();
	List<Object> list=new ArrayList<Object>();
	list.add(new Title("兼职教师在专业中的配置一览表","nf433"));
	list.addAll(jzszdwzypz);
	return list;
}

@Override
public List<Object> jzszdwzypzmd(String zymc) {
	List<TjCount> jzszdwzypzmd=hxMapper.jzszdwzypzmd(zymc);
	List<Object> list=new ArrayList<Object>();
	list.addAll(jzszdwzypzmd);
	return list;
}

@Override
public TjCount jzjsxnsjxssl() {
	Integer jzjsxnsjxssl=hxMapper.getjzjsxnsjxssl();
	TjCount tjCount = new TjCount("兼职教师承担校内实践教学学时数量","nf434",jzjsxnsjxssl);
	return tjCount;
}

@Override
public List<Object> jzjsxnsjxsmd(String nf) {
	List<TjCount> jzjsxnsjxsmd=hxMapper.jzjsxnsjxsmd(nf);
	List<Object> list=new ArrayList<Object>();
	list.addAll(jzjsxnsjxsmd);
	return list;
}

@Override
public List<Object> jzjsxnsjxssltbt() {
	List<TjCount> jzjsxnsjxssltbt=hxMapper.jzjsxnsjxssltbt();
	List<Object> list=new ArrayList<Object>();
	list.addAll(jzjsxnsjxssltbt);
	return list;
}

@Override
public TjCount getxxzzdmj() {
	Double getxxzmj = hxMapper.getxxzmj();
	TjCount tjCount = new TjCount("学校占地面积","nf435",getxxzmj);
	return tjCount;
}

@Override
public TjCount getxxzjzmj() {
	Double xxjzmj=hxMapper.getxxjzmj();
	TjCount tjCount = new TjCount("学校建筑面积","nf436",xxjzmj);
	return tjCount;
}

@Override
public List<Object> xxgjzmjylb() {
	List<XxmjEntity> xxgjzmjylb=hxMapper.xxgjzmjylb();
	List<Object> list=new ArrayList<Object>();
	list.addAll(xxgjzmjylb);
	return list;
}

@Override
public TjCount xnsjjdsl() {
	Integer xnsjjdsl=hxMapper.getxnsjjdsl();
	TjCount tjCount = new TjCount("学校建筑面积","nf437",xnsjjdsl);
	return tjCount;
}

@Override
public List<Object> xnsjjdmx() {
	List<TjCount> xnsjjdmx=hxMapper.xnsjjdmx();
	List<Object> list=new ArrayList<Object>();
	list.addAll(xnsjjdmx);
	return list;
}

@Override
public TjCount xnsjjdzdmj() {
	Double xnsjjdzdmj=hxMapper.getxnsjjdzdmj();
	TjCount tjCount = new TjCount("校内教学基地建筑面积","nf438",xnsjjdzdmj);
	return tjCount;
}

@Override
public TjCount xnsjjdsjsbz() {
	Double xnsjjdsjsbz=hxMapper.xnsjjdsjsbz();
	TjCount tjCount = new TjCount("校内教学基地生均教学仪器设备值(万元)","nf439",xnsjjdsjsbz);
	return tjCount;
}

@Override
public TjCount xwsjjdsl() {
	Integer xwsjjdsl=hxMapper.xwsjjdsl();
	TjCount tjCount = new TjCount("校外实践教学基地数量","nf440",xwsjjdsl);
	return tjCount;
}

@Override
public List<Object> xwsjjdmx() {
	List<TjCount> xwsjjdmx=hxMapper.xwsjjdmx();
	List<Object> list=new ArrayList<Object>();
	list.addAll(xwsjjdmx);
	return list;
}

@Override
public TjCount rcjxjftr() {
	Double rcjxjftr=hxMapper.rcjxjftr();
	TjCount tjCount = new TjCount("日常教学经费投入比例","nf446",rcjxjftr);
	return tjCount;
}

@Override
public List<Object> rcjxjftrtbt() {
	List<TjCount> lnrcjxjftr=hxMapper.lnrcjxjftr();
	List<Object> list=new ArrayList<Object>();
	list.addAll(lnrcjxjftr);
	return list;
}

@Override
public List<Object> jyfsjxjfyszxylb() {
	List<TjCount> jyfsjxjfyszxylb=hxMapper.jyfsjxjfyszxylb();
	List<Object> list=new ArrayList<Object>();
	list.add(new Title("教科研经费、教学改革经费预算执行情况一览表",null,null,true));
	list.addAll(jyfsjxjfyszxylb);
	return list;
}

@Override
public TjCount zztszs() {
	Integer zztszsl=hxMapper.zztszsl();
	TjCount tjCount = new TjCount("纸质图书总量","nf449",zztszsl);
	return tjCount;
}

@Override
public TjCount dnxzzztssl() {
	Integer dnxzzztssl=hxMapper.dnxzzztssl();
	TjCount tjCount = new TjCount("当年新增纸质图书数量","nf453",dnxzzztssl);
	return tjCount;
}

@Override
public List<Object> lnxzzztssl() {
	List<TjCount> lnxzzztssl=hxMapper.lnxzzztssl();
	List<Object> list=new ArrayList<Object>();
	list.addAll(lnxzzztssl);
	return list;
}

@Override
public List<Object> xzzztsmx(String nf) {
	List<TjCount> xzzztsmx=hxMapper.xzzztsmx(nf);
	List<Object> list=new ArrayList<Object>();
	list.addAll(xzzztsmx);
	return list;
}

@Override
public TjCount dndztssl() {
	Integer dndztssl=hxMapper.dndztssl();
	TjCount tjCount = new TjCount("当年电子图书数量","nf455",dndztssl);
	return tjCount;
}

@Override
public List<Object> lndztssl() {
	List<TjCount> lndztssl=hxMapper.lndztssl();
	List<Object> list=new ArrayList<Object>();
	list.addAll(lndztssl);
	return list;
}

@Override
public List<Object> dztsmx(String nf) {
	List<TjCount> dztsmx=hxMapper.dztsmx(nf);
	List<Object> list=new ArrayList<Object>();
	list.addAll(dztsmx);
	return list;
}

@Override
public List<Object> zyjxzykylb() {
	List<TjCount> zyjxzykylb=hxMapper.zyjxzykylb();
	List<Object> list=new ArrayList<Object>();
	list.add(new Title("专业教学资源库等级、类型、数量一览表",null,null,true));
	list.addAll(zyjxzykylb);
	return list;
}

@Override
public List<Object> jbsjcjylb() {
	List<TjCount> jbsjcjylb=hxMapper.getjbsjcjylb();
	List<Object> list=new ArrayList<Object>();
	list.add(new Title("校本数据采集、管理与使用情况一览表",null,null,true));
	list.addAll(jbsjcjylb);
	return list;
}

@Override
public List<Object> zyfgmylb() {
	List<TjCount> zyfgmylb=hxMapper.getzyfgmylb();
	List<Object> list=new ArrayList<Object>();
	list.add(new Title("专业覆盖面一览表",null,null,true));
	list.addAll(zyfgmylb);
	return list;
}

@Override
public TjCount dnhzqysl() {
	Integer dnhzqysl=hxMapper.dnhzqysl();
	TjCount tjCount = new TjCount("当年合作企业数量","nf457",dnhzqysl);
	return tjCount;
}

@Override
public List<Object> lnhzqysl(String zymc) {
	List<TjCount> lnhzqysl=hxMapper.lnhzqysl(zymc);
	List<Object> list=new ArrayList<Object>();
	list.addAll(lnhzqysl);
	return list;
}

@Override
public List<Object> hzqymx(String nf,String zymc) {
	List<TjCount> hzqymx=hxMapper.hzqymx(nf,zymc);
	List<Object> list=new ArrayList<Object>();
	list.addAll(hzqymx);
	return list;
}

@Override
public List<TjCount> getdgsxzy() {
	List<TjCount> dgsxzy = hxMapper.getdgsxzy();
	return dgsxzy;
}

@Override
public List<Object> jsdgsxxsbl() {
	List<TjCount> jsdgsxxsbl=hxMapper.getjsdgsxxsbl();
	List<Object> list=new ArrayList<Object>();
	list.add(new Title("接受顶岗实习学生比例","nf458"));
	list.addAll(jsdgsxxsbl);
	return list;
}

@Override
public List<Object> lndgsxxsbl(String mc, String zymc) {
	List<TjCount> lndgsxxsbl=hxMapper.lndgsxxsbl(mc,zymc);
	List<Object> list=new ArrayList<Object>();
	list.addAll(lndgsxxsbl);
	return list;
}

@Override
public List<Object> dgsxxsmd(String nf, String zymc, String mc) {
	List<DgsxEntity> dgsxxsmd=hxMapper.dgsxxsmd(mc,zymc,nf);
	List<Object> list=new ArrayList<Object>();
	list.addAll(dgsxxsmd);
	return list;
}

@Override
public List<Object> lyyjbysbl() {
	List<TjCount> lyyjbysbl=hxMapper.lyyjbysbl();
	List<Object> list=new ArrayList<Object>();
	list.add(new Title("录用应届毕业生比例","nf461"));
	list.addAll(lyyjbysbl);
	return list;
}

@Override
public List<Object> lnlyyjbysbl(String mc, String zymc) {
	List<TjCount> lnlyyjbysbl=hxMapper.lnlyyjbysbl(mc,zymc);
	List<Object> list=new ArrayList<Object>();
	list.addAll(lnlyyjbysbl);
	return list;
}

@Override
public List<Object> lyyjbysmd(String nf, String zymc, String mc) {
	List<DgsxEntity> lyyjbysmd=hxMapper.getlydgsxhymx(mc,zymc,nf);
	List<Object> list=new ArrayList<Object>();
	list.addAll(lyyjbysmd);
	return list;
}

@Override
public TjCount qyjzje() {
	Double qyjzje=hxMapper.qyjzje();
	TjCount tjCount = new TjCount("企业捐赠金额(万元)","nf463",qyjzje);
	return tjCount;
}

@Override
public List<Object> lnqyjzje() { 
	List<TjCount> lnqyjzje=hxMapper.lnqyjzje();
	List<Object> list=new ArrayList<Object>();
	list.addAll(lnqyjzje);
	return list;
}

@Override
public List<Object> qyjzjemx(String nf) {
	List<TjCount> qyjzjemx=hxMapper.qyjzjemx(nf);
	List<Object> list=new ArrayList<Object>();
	list.addAll(qyjzjemx);
	return list;
}

@Override
public TjCount qyssjzjssl() {
	Integer qyssjzjssl=hxMapper.getqyssjzjssl();
	TjCount tjCount = new TjCount("企业输送兼职教师数量","nf465",qyssjzjssl);
	return tjCount;
}

@Override
public List<Object> lnqyssjzjssl() {
	List<TjCount> lnqyssjzjssl=hxMapper.lnqyssjzjssl();
	List<Object> list=new ArrayList<Object>();
	list.addAll(lnqyssjzjssl);
	return list;
}

@Override
public List<Object> qyssjzjsmd(String nf) {
	List<TjCount> qyssjzjsmd=hxMapper.qyssjzjsmd(nf);
	List<Object> list=new ArrayList<Object>();
	list.addAll(qyssjzjsmd);
	return list;
}

@Override
public List<Object> qyjsjsqysj() {
	List<TjCount> qyjsjsqysj=hxMapper.jsqysjqkylb();
	List<Object> list=new ArrayList<Object>();
	list.add(new Title("企业接收教师企业实践情况一览表",null,null,true));
	list.addAll(qyjsjsqysj);
	return list;
}

@Override
public List<Object> xqhzyfcg() {
	List<TjCount> xqhzyfcg=hxMapper.xqhzyfcg();
	List<Object> list=new ArrayList<Object>();
	list.add(new Title("校企合作研发成果一览表",null,null,true));
	list.addAll(xqhzyfcg);
	return list;
}

@Override
public List<Object> getzxsmyddcjg() {
	List<TjCount> zxsmyddcjg=hxMapper.getzxsmyddcjg();
	List<Object> list=new ArrayList<Object>();
	list.add(new Title("在校生满意度调查结果",null,null,true));
	list.addAll(zxsmyddcjg);
	return list;
}

@Override
public List<Object> getbysgzdcjg() {
	List<TjCount> bysgzdcjg=hxMapper.getbysgzdcjg();
	List<Object> list=new ArrayList<Object>();
	list.add(new Title("毕业生跟踪调查结果",null,null,true));
	list.addAll(bysgzdcjg);
	return list;
}

@Override
public TjCount sjbysdll() {
	Double sjbysdkl=hxMapper.getsjbysdkl();
	TjCount tjCount = new TjCount("上届毕业生对口率","nf467",sjbysdkl);
	return tjCount;
}

@Override
public List<Object> lnbysdkl() {
	List<TjCount> lnbysdkl=hxMapper.lnbysdkl();
	List<Object> list=new ArrayList<Object>();
	list.addAll(lnbysdkl);
	return list;
}

@Override
public TjCount sjbyszgl() {
	Double sjbyszgl=hxMapper.getsjbyszgl();
	TjCount tjCount = new TjCount("上届毕业生转岗率","nf469",sjbyszgl);
	return tjCount;
}

@Override
public List<Object> lnsjbyszgl() {
	List<TjCount> lnsjbyszgl=hxMapper.lnsjbyszgl();
	List<Object> list=new ArrayList<Object>();
	list.addAll(lnsjbyszgl);
	return list;
}

@Override
public TjCount sjbyssql() {
	Double sjbyssql=hxMapper.sjbyssql();
	TjCount tjCount = new TjCount("上届毕业生升迁率","nf471",sjbyssql);
	return tjCount;
}

@Override
public List<Object> lnsjbyssql() {
	List<TjCount> lnsjbyssql=hxMapper.lnsjbyssql();
	List<Object> list=new ArrayList<Object>();
	list.addAll(lnsjbyssql);
	return list;
}

@Override
public List<Object> getbysbkyy() {
	List<TjCount> bysbkyy=hxMapper.getbysbkyy();
	List<Object> list=new ArrayList<Object>();
	list.add(new Title("新生报考原因分析饼图","bt"));
	list.addAll(bysbkyy);
	return list;
}

@Override
public List<Object> yrdwdbysylb() {
	List<TjCount> yrdwdbysylb=hxMapper.getyrdwdbysylb();
	List<Object> list=new ArrayList<Object>();
	list.add(new Title("用人单位对毕业生评价一览表",null,null,true));
	list.addAll(yrdwdbysylb);
	return list;
}

@Override
public List<Object> dsjxmysylb() {
	List<TjCount> dsjxmysylb=hxMapper.dsjxmysylb();
	List<Object> list=new ArrayList<Object>();
	list.add(new Title("地市级以上项目结果一览表",null,null,true));
	list.addAll(dsjxmysylb);
	return list;
}

@Override
public List<Object> zyjnjdjdxsjg() {
	List<TjCount> zyjnjdjdxsjg=hxMapper.zyjnjdjdxsjg();
	List<Object> list=new ArrayList<Object>();
	list.add(new Title("职业技能鉴定机构对学生职业能力鉴定结果一览表",null,null,true));
	list.addAll(zyjnjdjdxsjg);
	return list;
}

@Override
public List<Object> dsjjybmpsjg() {
	List<TjCount> dsjjybmpsjg=hxMapper.dsjjybmpsjg();
	List<Object> list=new ArrayList<Object>();
	list.add(new Title("地市级以上教育行政部门项目评审结果一览表",null,null,true));
	list.addAll(dsjjybmpsjg);
	return list;
}

@Override
public List<Object> dsjssjshj() {
	List<TjCount> dsjssjshj=hxMapper.dsjssjshj();
	List<Object> list=new ArrayList<Object>();
	list.add(new Title("地市级以上师生竞赛获奖情况一览表",null,null,true));
	list.addAll(dsjssjshj);
	return list;
}

@Override
public List<Object> rmzfbzylb() {
	List<TjCount> rmzfbzylb=hxMapper.rmzfbzylb();
	List<Object> list=new ArrayList<Object>();
	list.add(new Title("地市级以上人民政府表彰情况一览表",null,null,true));
	list.addAll(rmzfbzylb);
	return list;
}

@Override
public List<Object> jdpxxssl(String zymc) {
	List<TjCount> jdpxxssl=hxMapper.jdpxxssl(zymc);
	List<Object> list=new ArrayList<Object>();
	list.addAll(jdpxxssl);
	return list;
}

@Override
public TjCount jxjxsglry() {
	Integer jxjxsglry=hxMapper.jxjxsglry();
	TjCount tjCount = new TjCount("教学及学生管理人员数量","nf473",jxjxsglry);
	return tjCount;
}

@Override
public List<Object> jxjxsglrybt() {
	List<TjCount> jxjxsglrybt=hxMapper.jxjxsglrybt();
	List<Object> list=new ArrayList<Object>();
	list.addAll(jxjxsglrybt);
	return list;
}

@Override
public List<Object> jxjxsglrymd(String zymc) {
	List<TjCount> jxjxsglrymd=hxMapper.jxjxsglrymd(zymc);
	List<Object> list=new ArrayList<Object>();
	list.addAll(jxjxsglrymd);
	return list;
}

@Override
public List<Object> nfzslszsmd(String nf, String mc) {
	List<TjCount> nfzslszsmd=hxMapper.nfzslszsmd(nf,mc);
	List<Object> list=new ArrayList<Object>();
	list.addAll(nfzslszsmd);
	return list;
}

@Override
public List<Object> xssydfb() {
	List<TjCount> xssydfb=hxMapper.getxssydfb();
	List<Object> list=new ArrayList<Object>();
	list.add(new Title("新生生源地分布图","nf602"));
	list.addAll(xssydfb);
	return list;
}

@Override
public List<Object> xzdqxssltbt(String dqmc) {
	List<TjCount> xzdqxssltbt=hxMapper.xzdqxssltbt(dqmc);
	List<Object> list=new ArrayList<Object>();
	list.addAll(xzdqxssltbt);
	return list;
}

@Override
public List<Object> xzdqxsmd(String nf, String dqmc) {
	List<TjCount> xzdqxsmd=hxMapper.xzdqxsmd(nf,dqmc);
	List<Object> list=new ArrayList<Object>();
	list.addAll(xzdqxsmd);
	return list;
}

@Override
public List<Object> getzlbzzdyl() {
	List<TjCount> zlbzzztxylb=hxMapper.getzlbzzdyl();
	List<Object> list=new ArrayList<Object>();
	list.add(new Title("质量保证制度列表","nf604"));
	list.addAll(zlbzzztxylb);
	return list;
}

@Override
public List<Object> xxgzzdlb() {
	List<TjCount> xxgzzdlb=hxMapper.xxgzzdlb();
	List<Object> list=new ArrayList<Object>();
	list.add(new Title("学校规章制度列表","nf605"));
	list.addAll(xxgzzdlb);
	return list;
}
//毕业生计算机考试通过率明细
@Override
public List<TjCount> getbysjsjksmx(String nf, String zymc) {
	List<TjCount> xzdqxsmd=hxMapper.getbysjsjksmx(nf,zymc);
	return xzdqxsmd;
}

@Override
public List<TjCount> getrxqdlist() {
	List<TjCount> xzdqxsmd=hxMapper.getrxqdlist();
	return xzdqxsmd;
}

@Override
public List<Object> lnbysdkjybht(String zymc, String lb) {
	List<TjCount> lnbysdkjybht=hxMapper.lnbysdkjybht(zymc,lb);
	List<Object> list=new ArrayList<Object>();
	list.add(new Title("毕业生对口就业率变化图（分专业，分教育类型）","nf606"));
	list.addAll(lnbysdkjybht);
	return list;
}

@Override
public List<Object> getbtsdkjymd(String nf,String zymc, String lb) {
	List<TjCount> btsdkjymd=hxMapper.getbtsdkjymd(nf,zymc,lb);
	List<Object> list=new ArrayList<Object>();
	list.addAll(btsdkjymd);
	return list;
}

@Override
public List<Object> nfzyqdxsmd(String nf, String zymc, String lb) {
	List<TjCount> nfzyqdxsmd=hxMapper.nfzyqdxsmd(nf,zymc,lb);
	List<Object> list=new ArrayList<Object>();
	list.addAll(nfzyqdxsmd);
	return list;
}
//选定专业教师占专任教师比例同比图
@Override
public List<TjCount> getgzyjsbltbt(String zymc) {
	List<TjCount> gzyjsbltbt = hxMapper.getgzyjsbltbt(zymc);
	return gzyjsbltbt;
}

@Override
public TjCount sjxnsjgws() {
	Integer sjgws=this.getsjxnsjgws();
	TjCount tjCount = new TjCount("生均校内实训工位数","nf1306",sjgws);
	return tjCount;
}

@Override
public List<Object> getrjqysjsj(String zymc) {
	List<TjCount> rjqysjsj=hxMapper.getrjqysjsj(zymc);
	List<Object> list=new ArrayList<Object>();
	list.add(new Title("教师人均企业实践时间同比图","nf1001"));
	list.addAll(rjqysjsj);
	return list;
}
//各专业在校生数量
@Override
public List<Object> getStuCount2() {
	List<Object> list=new ArrayList<Object>();
	List<TjCount> gzyxssl=hxMapper.getgzyxssl2();
	list.addAll(gzyxssl);
	return list;
}


//线下课堂分析*****************************************
@Override
public List<Object> getpjfsList(String zymc,String bjmc,String kcmc) {
	List<TjCount> pjcjtb= hxMapper.getpjfsList(zymc,bjmc,kcmc);
	List<Object> list= new ArrayList<Object>();
	list.add(new Title("课堂成绩平均成绩同比变化图","nf800",null,"zzt"));
	list.addAll(pjcjtb);
	return list;
}

@Override
public List<Object> getzymc() {
	List<TjCount> zymc=hxMapper.getzymc();
	List<Object> list= new ArrayList<Object>();
	list.addAll(zymc);
	return list;
}

@Override
public List<Object> getbjmc(String zymc) {
	List<TjCount> bjmc=hxMapper.getbjmc(zymc);
	List<Object> list= new ArrayList<Object>();
	list.addAll(bjmc);
	return list;
}

@Override
public List<Object> getkcmc(String zymc,String bjmc) {
	List<TjCount> kcmc=hxMapper.getkcmc(zymc,bjmc);
	List<Object> list= new ArrayList<Object>();
	list.addAll(kcmc);
	return list;
}

@Override
public List<Object> getkcfsfb(String zymc, String bjmc, String kcmc, String nf) {
	List<TjCount> ksfsfb = hxMapper.getkcfsfb(zymc, bjmc, kcmc, nf);
	List<Object> list= new ArrayList<Object>();
	list.add(new Title("课程考试分数分布图","nf801",null,"zzt"));
	list.addAll(ksfsfb);
	return list;
}

@Override
public List<Object> getnf() {
	List<TjCount> nf=hxMapper.getnf();
	List<Object> list= new ArrayList<Object>();
	list.addAll(nf);
	return list;
}

@Override
public List<Object> getxsksmx(String zymc, String bjmc, String kcmc, String nf) {
	List<TjCount> xsksmx=hxMapper.getxsksmx(zymc, bjmc, kcmc, nf);
	List<Object> list= new ArrayList<Object>();
	list.add(new Title("学生考试分数明细表",null,null,true));
	list.addAll(xsksmx);
	return list;
}

@Override
public List<Object> getfsfwmx(String zymc, String bjmc, String kcmc, String nf, String dg) {
	List<TjCount> fsfwmx=hxMapper.getfsfwmx(zymc, bjmc, kcmc, nf, dg);
	List<Object> list= new ArrayList<Object>();
	list.addAll(fsfwmx);
	return list;
}

@Override
public List<Object> getczqrs(String kcmc) {
	List<TjCount> getczqrs =hxMapper.getczqrs(kcmc);
	List<Object> list=new ArrayList<Object>();
	list.add(new Title(kcmc+"学生迟到/早退/请假数量堆积图","nf803",null,"djt"));
	for(TjCount t : getczqrs){
		TjCount tjCount = new TjCount("迟到",Integer.valueOf(t.getBl1()));
		TjCount tjCount2 = new TjCount("早退",Integer.valueOf(t.getBl2()));
		TjCount tjCount3 = new TjCount("请假",Integer.valueOf(t.getBl3()));
		List<TjCount> list2=new ArrayList<TjCount>();
		list2.add(tjCount);
		list2.add(tjCount2);
		list2.add(tjCount3);
		Tjlist tjlist2 = new Tjlist(t.getMc(),list2);
		list.add(tjlist2);
	}
	return list;
}

@Override
public List<Object> getsgkcmc() {
	List<TjCount> sgkcmc=hxMapper.getsgkcmc();
	List<Object> list= new ArrayList<Object>();
	list.addAll(sgkcmc);
	return list;
}

@Override
public List<Object> getbfczqrs(String kcmc, String nf) {
	List<TjCount> bfczqrs =hxMapper.getbfczqrs(kcmc,nf);
	List<Object> list=new ArrayList<Object>();
	list.add(new Title("学生迟到/早退/请假数量饼图","nf804",null,"bt"));
	list.addAll(bfczqrs);
	return list;
}

@Override
public List<Object> getbfczqrsmx(String kcmc, String nf, String lb) {
	List<TjCount> bfczqrsmx =hxMapper.getbfczqrsmx(kcmc, nf, lb);
	List<Object> list=new ArrayList<Object>();
	list.add(new Title("学生迟到/早退/明细表",null,null,true));
	list.addAll(bfczqrsmx);
	return list;
}

@Override
public List<Object> getjpkzz(String zymc) {
	List<TjCount> jpkzz = hxMapper.getjpkzz(zymc);
	List<Object> list= new ArrayList<Object>();
	list.add(new Title("精品课程增长柱状图","nf805",null,"zzt"));
	list.addAll(jpkzz);
	return list;
}

@Override
public List<Object> getjpkczymx() {
	List<TjCount> jpkczymx = hxMapper.getjpkczymx();
	List<Object> list= new ArrayList<Object>();
	list.addAll(jpkczymx);
	return list;
}

@Override
public List<Object> getjpkcmx(String zymc, String nf) {
	List<TjCount> jpkcmx = hxMapper.getjpkcmx(zymc, nf);
	List<Object> list= new ArrayList<Object>();
	list.add(new Title("精品课程明细",null,null,true));
	list.addAll(jpkcmx);
	return list;
}

@Override
public List<TjCount> getbyszgzshqmx(String nf) {
	List<TjCount> zhengshu =hxMapper.getbyszgzshqmx(nf);
	
	return zhengshu;
}





}

