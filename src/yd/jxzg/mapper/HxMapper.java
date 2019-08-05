package yd.jxzg.mapper;
import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import yd.jxzg.common.TjCount;
import yd.jxzg.entity.BysxzEntity;
import yd.jxzg.entity.DgsxEntity;
import yd.jxzg.entity.JzgEntity;
import yd.jxzg.entity.StuCj;
import yd.jxzg.entity.StudentEntity;
import yd.jxzg.entity.XwJdEntity;
import yd.jxzg.entity.XxjbqkEntity;
import yd.jxzg.entity.XxmjEntity;
import yd.jxzg.entity.ZgzsEntity;
import yd.jxzg.entity.ZyxxEntity;
import yd.jxzg.entity.KcEntity;
@Repository
public interface HxMapper {

	List<StudentEntity> stuListByBj(@Param("bh") String bh);

	Integer getStuCount(@Param("zym") String zym, @Param("rxnj") String rxnj, @Param("bh") String bh);

	List<TjCount> getfenzy();

	List<TjCount> getStuCountByZym(@Param("zym") String zym);

	List<TjCount> getStuCountByRxnj(@Param("zym") String zym,@Param("rxnj") String rxnj);

	Integer totalCountStudent(@Param("object")Object object);

	List<StudentEntity> getStudList(@Param("object") Object object);

	Integer getzyJsCount();

	Integer getgljs();

	Integer getjnjs();

	Integer getgqJs();

	List<JzgEntity> getJzgList();

	List<JzgEntity> getJzgByZy();

	Double getsbzz();

	List<TjCount> getsbtb();
	
	List<TjCount> bysqx(@Param("bylx") String bylx);

	Integer getsxgws();

	List<TjCount> getXnsxgwstb();

	Integer getxwjd();

	List<TjCount> getxwjdtb();

	List<XwJdEntity> getjdsxqd(@Param("jdrq") String jdrq);

	Double getgjbfb();

	Integer getjscount();

	Double getzyJs();

	Integer getdoublejs();

	Double getxxzmj();

	Double getxsjzmj();

	Double getTyydmj();

	Integer gettszs();

	List<TjCount> getzztstbt();

	Double getsjyqsbzz();

	Integer getjsjzs();

	List<TjCount> getjsjtbt();
	//各建筑面积
	List<XxmjEntity> getXxgjzmj();

	Integer getzxszs();
	//专业数量
	Integer getxxzysl();

	List<ZyxxEntity> getzyByNfList(@Param("nf") String nf);

	Integer getggkcsl();

	Integer getzykcsl();

	List<KcEntity> getKclist(@Param("nf") String nf);

	List<TjCount> getxzsbtb();

	String getzyByzym(@Param("zym") String zym);

	Double getlhmj();

	Double getxscqmj();

	List<TjCount> getdztstbt();

	Double getjxyfmj();

	Double getxzbgyfmj();

	Integer getwldmtjssl();

	Integer getdks();

	List<TjCount> getdktbt();

	Integer getswkcs();

	List<TjCount> getswkctbt();

	Integer getxnsjgws();

	List<TjCount> getmnxnsjgws();

	List<JzgEntity> getdoublejsList(@Param("nf") String nf);

	List<KcEntity> getkcListBynfandzym(@Param("nf") String nf,@Param("zym") String zym);

	Integer getxwjdsyts();

	Integer getjdjdxsl();

	Integer getjssjsj();

	Integer getbyssl();

	Integer getzyzgzshql();

	List<TjCount> getbyszy();

	Integer getbysslByzy(@Param("zym") String zym);

	Integer getzyzgzshlqlbyzy(@Param("zym") String zym);

	List<ZgzsEntity> getzgzLi(@Param("nf") String nf);

	List<TjCount> getxdztxssl();

	Integer getzyzxssltbt(@Param("zym") String zym);

	List<TjCount> getstuzy();

	List<StudentEntity> getstuListbyZyNf(@Param("nf") String nf,@Param("zym") String zym);

	List<TjCount> getnjlist();

	Double getfzyfmj();

	List<XxmjEntity> getggzyfmj();

	Double getshyfzmj();

	List<XxmjEntity> getgshyfmj();

	List<XxjbqkEntity> getkdxxjbqk(@Param("nf") String nf);

	List<TjCount> getwlxxjd();

	List<TjCount> getjxsbtrjetbt();

	List<TjCount> getbxjfzcbt();

	Integer getzrfjz(@Param("zymc") String zymc);

	Integer getjzjssl(@Param("zymc") String zymc);

	List<TjCount> getzyList();

	Integer getsfzysltbt();

	List<ZyxxEntity> getsfzylist(@Param("nf") String nf);

	Integer getszdzysl();

	List<ZyxxEntity> getxzszdzymd(@Param("nf") String nf);

	Integer sppzysl();

	Double getjgzzmj();

	Double getqtmj();

	List<KcEntity> getggkcqd();

	List<KcEntity> getzykcqd();

	List<ZyxxEntity> getxzszymd(@Param("nf") String nf);

	Integer getzysl();

	List<ZyxxEntity> getqttszymd(@Param("nf") String nf);

	List<KcEntity> getkcList1(@Param("nf") String nf,@Param("zym")  String zym);

	List<TjCount> getkcxn();

	List<TjCount> getkczy();

	List<TjCount> getjpkctbt();

	List<KcEntity> getjpkcqd(@Param("nf") String nf);

	List<TjCount> getlnxzttkc();

	List<KcEntity> getxzttkcqd(@Param("nf") String nf);

	List<TjCount> getgnzxkcsl();

	Integer getstusl(@Param("lb") String lb,@Param("nf")  String nf,@Param("zym")  String zym,@Param("dqmc")  String dqmc);

	List<StudentEntity> getstumd(@Param("lb") String lb,@Param("nf")  String nf,@Param("zym")  String zym,@Param("dqmc")  String dqmc);

	List<TjCount> getdqlist();

	List<TjCount> getpycc();

	Integer getxxzssl();

	List<TjCount> getgndjsl(@Param("lb")String lb);

	TjCount getjyqktbt();

	List<TjCount> getgzyjyl();

	List<TjCount> getjyxsmd(@Param("nf") String nf,@Param("zymc") String zymc);

	List<TjCount> gethzqysl(@Param("zymc") String zymc);

	List<TjCount> getzylist2();

	Integer getqyxssl(@Param("mc") String mc);

	List<TjCount> getqyjymd(@Param("mc") String mc, @Param("nf") String nf);

	List<TjCount> getzjxsslpm(@Param("nf") String nf);

	List<TjCount> getgnjxssl(@Param("nf")String nf,@Param("zymc") String zymc);

	List<TjCount> getxslssl(@Param("zymc") String zymc);

	List<TjCount> getlsnjxssl(@Param("nf") String nf,@Param("zymc") String zymc);

	List<TjCount> getbjxssl(@Param("nf") String nf,@Param("zymc")String zymc);

	List<TjCount> getzypxpm(@Param("zymc") String zymc);

	List<TjCount> getbjpjcj(@Param("zymc") String zymc,@Param("kcmc")  String kcmc, @Param("nf") String nf);

	List<StuCj> getcjList(@Param("zymc") String zymc,@Param("kcmc") String kcmc,@Param("nf") String nf);

	List<TjCount> gethqzsbl(@Param("nf") String nf);

	List<ZgzsEntity> gethqzsxs(@Param("zym")String zym,@Param("nf") String nf);

	List<TjCount> getzjjssl(@Param("nf") String nf);

	List<TjCount> getzyxcpm(@Param("nf") String nf);

	List<TjCount> getzyxztbt(@Param("zymc") String zymc);

	List<BysxzEntity> getbysxzmx(@Param("nf") String nf,@Param("zymc") String zymc);
	
	List<TjCount> getbysjymx(@Param("nf") String nf,@Param("zymc") String zymc);
	
	List<TjCount> getgxnxsrs(@Param("zymc") String zymc);

	List<TjCount> getgzyjylpm(@Param("nf")String nf);

	List<TjCount> getzyjytbt(@Param("zymc") String zymc);

	List<TjCount> getsjgwpm();

	List<TjCount> getsbjepm();

	List<TjCount> getxwjdslpm(String nf);

	List<XwJdEntity> getxwjdmx(@Param("nf") String nf,@Param("zymc") String zymc);

	List<TjCount> getgzyxssl(@Param("nf")String nf);

	List<StudentEntity> getstuByZy(@Param("nf")String nf,@Param("zymc")  String zymc,@Param("lb") String lb);

	List<TjCount> getxszysl();

	List<TjCount> getlnzyxssl(@Param("zymc") String zymc);

	List<TjCount> getgjyfsxssl();

	List<TjCount> getxsjyflfb();

	List<TjCount> getxzflxstbt(String lb);

	List<TjCount> getbjlist();

	List<TjCount> getstuage(@Param("bh")String bh,@Param("zymc") String zymc);

	List<StudentEntity> getstuagefb(@Param("bh") String bh,@Param("zymc") String zymc,@Param("aged") String aged);

	List<TjCount> getxsxbfb(@Param("bh") String bh,@Param("zymc") String zymc);

	List<StudentEntity> getxbxsmx(@Param("bh") String bh,@Param("zymc") String zymc, @Param("lb")String lb);

	List<TjCount> getssmzfb(@Param("bh") String bh,@Param("zymc") String zymc);

	List<StudentEntity> getssmzmx(@Param("bh") String bh,@Param("zymc") String zymc,@Param("lb")String lb);

	List<TjCount> getxssyzl(@Param("zymc") String zymc);

	List<StuCj> getxzcjmx(@Param("bh") String bh,@Param("zymc") String zymc, @Param("lb")String lb);

	List<StudentEntity> getdxsmx(@Param("nf") String nf,@Param("zymc") String zymc);

	List<TjCount> getgzyxssltbt(@Param("zymc") String zymc);

	List<TjCount> getbdry(@Param("lb")String lb,@Param("zymc") String zymc);


	List<TjCount> getdkjysl(@Param("zymc")String zymc);

	List<TjCount> getlndkjybl(@Param("zymc")String zymc);

	List<ZgzsEntity> getdkjyxsmx(@Param("nf")String nf,@Param("zymc") String zymc);

	List<TjCount> getghypx(@Param("zymc") String zymc);

	List<TjCount> hyjytbt(@Param("lb")String lb);

	List<ZgzsEntity> gethyjymx(@Param("lb")String lb);

	List<TjCount> getsxxxpm(@Param("zymc") String zymc,@Param("nf") String nf);

	List<TjCount> getlnsxsl(@Param("mc")String mc);

	List<ZgzsEntity> getxzxxsxmx(@Param("nf")String nf,@Param("mc") String mc);

	List<TjCount> getjyqdbt();

	List<TjCount> getqdlnjysl(String mc);

	List<ZgzsEntity> getqdjymx(@Param("mc")String mc,@Param("nf") String nf);

	List<TjCount> getdgsxqy();
	

	List<TjCount> getlndgsxrs(@Param("zymc")String zymc,@Param("mc") String mc);

	List<DgsxEntity> getdgsxmx(@Param("nf")String nf,@Param("zymc") String zymc,@Param("mc") String mc);

	List<TjCount> getdgsxhly(@Param("zymc") String zymc,@Param("mc") String mc);

	List<DgsxEntity> getdgsxhymx(@Param("mc")String mc,@Param("zymc") String zymc,@Param("nf") String nf);

	List<TjCount> getlndglyl(@Param("zymc") String zymc,@Param("mc") String mc);

	List<TjCount> getghzqyjy(@Param("mc")String mc);

	List<DgsxEntity> getxzqyjymx(@Param("mc")String mc,@Param("nf") String nf);

	List<TjCount> getjyszy();

	List<TjCount> getjydysl(@Param("zymc")String zymc);

	List<TjCount> getxdyjysl(@Param("zymc")String zymc,@Param("mc") String mc);

	List<ZgzsEntity> getbysdymx(@Param("zymc")String zymc,@Param("mc") String mc,@Param("nf") String nf);

	List<TjCount> getdwmyd(@Param("zymc")String zymc);

	List<TjCount> getgqymydmx(@Param("nf")String nf);

	List<TjCount> getbysxzfb(@Param("lb")String lb,@Param("nf") String nf,@Param("zymc") String zymc);

	List<ZgzsEntity> getxzbfxzmx(@Param("lb")String lb,@Param("nf") String nf,@Param("zymc") String zymc,@Param("dg") String dg);

	List<TjCount> getlnbysxc(@Param("lb")String lb,@Param("zymc") String zymc);

	TjCount getxdzyssbtbt(String zym);

	Integer getggjssl();

	List<TjCount> getgzyssb();

	Integer getxdzyjssl(@Param("zym")String zym);

	List<JzgEntity> getxdzynfjsmd(@Param("zym")String zym,@Param("nf") String nf);

	List<JzgEntity> ggjslist();
	List<JzgEntity> getxznfzjzjs(@Param("zym")String zym,@Param("nf") String nf);

	List<TjCount> getlnbmxssltb(@Param("zym")String zym);

	List<StudentEntity> getydbmxsmd(@Param("nf")String nf,@Param("zym") String zym);

	List<TjCount> getgzyjsbl();

	List<TjCount> getgzyzrjssl();

	List<TjCount> getgzygjjs();

	List<TjCount> zygjzwsl(@Param("zymc") String zymc);

	List<JzgEntity> getgjzwmd(@Param("nf")String nf,@Param("zymc") String zymc);

	List<TjCount> gzyssxjsbl();

	List<TjCount> getxdzyssxjsbl(@Param("zymc") String zymc);

	List<JzgEntity> getxdssxjsmd(@Param("nf")String nf,@Param("zymc")String zymc);

	Integer getqklxsl();

	List<TjCount> getbkflbt(@Param("nf")String nf);

	List<TjCount> getbkflmx(@Param("nf")String nf,@Param("mc") String mc);

	List<TjCount> getxzsbqd(@Param("nf")String nf);

	List<TjCount> getxzjxyf(@Param("nf")String nf);

	List<TjCount> getxzxzbgqd(@Param("nf")String nf);

	List<TjCount> getxzjsjqd(@Param("nf")String nf);

	List<TjCount> getwldmtmx(@Param("nf")String nf);

	List<TjCount> getjxgwxq(@Param("nf")String nf);

	List<TjCount> getjszylist();

	List<XwJdEntity> getxwjdjhb(@Param("nf")String nf);

	List<JzgEntity> getjzjslist(@Param("nf")String nf,@Param("zymc")String zymc);

	List<TjCount> getqysj(@Param("nf")String nf,@Param("zymc")String zymc);

	List<ZgzsEntity> getbyscj(@Param("nf")String nf,@Param("zymc")String zymc);

	Integer getxszsl();

	Integer getlsxssl();

	List<StudentEntity> getlsxsmx(@Param("nf")String nf,@Param("zymc")String zymc);

	List<ZyxxEntity> getzybdqd();

	List<ZyxxEntity> getcxzszy();

	List<ZyxxEntity> getqrzpxbbd();

	List<TjCount> getsxsvsyl(@Param("mc")String mc);

	List<TjCount> getsxks();

	List<TjCount> getsxssbsyqd(@Param("nf")String nf,@Param("mc") String mc);

	List<TjCount> getjzgzzmj();

	List<TjCount> getqtqymj();

	List<TjCount> getlnbksl();

	List<TjCount> getqkgesl(@Param("nf")String nf);

	List<TjCount> getgltssl(@Param("nf")String nf);

	List<TjCount> getdztslxsl(@Param("nf")String nf);

	List<TjCount> gettysbmx(@Param("nf")String nf);

	List<TjCount> getzysbmx(@Param("nf")String nf);

	List<TjCount> getxxjdfb(@Param("nf")String nf);

	List<TjCount> getzyjfmx(@Param("nf")String nf);

	List<TjCount> getstujkqd();

	List<TjCount> getgzydysl(@Param("nf")String nf);

	List<JzgEntity> getdylist(@Param("nf")String nf,@Param("zymc") String zymc);

	List<TjCount> getdjpx(@Param("nf")String nf);

	List<JzgEntity> getjzgdypxmd(@Param("nf")String nf);

	List<TjCount> getdjhd(@Param("nf")String nf);

	List<TjCount> getdjhdsl();

	List<TjCount> getpxxmmx(@Param("nf")String nf,@Param("zymc") String zymc);

	List<StudentEntity> getxspxlist(@Param("nf")String nf,@Param("zymc") String zymc);

	List<TjCount> getrcyjpm(@Param("nf")String nf,@Param("zymc") String zymc);

	Integer getlnrcyjsl(@Param("zymc") String zymc);

	List<JzgEntity> getrcyjmx(@Param("nf")String nf);

	Integer getlnzgjjssl(@Param("zymc") String zymc);

	List<JzgEntity> getgjjslist(@Param("nf")String nf,@Param("zymc") String zymc);

	List<TjCount> getszxldbt(@Param("zymc")String zymc);

	List<TjCount> getzyszxl();

	List<JzgEntity> getjsmd(@Param("nf")String nf,@Param("zymc")String zymc);

	List<TjCount> getjszcdjt();

	List<TjCount> getzyzcbht(@Param("zymc")String zymc);

	List<TjCount> getssxjsblpm(@Param("nf")String nf);

	List<TjCount> getzjzjs();

	List<TjCount> getzyzjzjstbt(@Param("zymc")String zymc);

	List<TjCount> getwhzyjsdjt();

	List<TjCount> getxzwzjsdjt(@Param("zymc")String zymc);

	List<TjCount> getbysmydpm(@Param("nf")String nf);

	List<TjCount> getzybysmydtbt(@Param("zymc")String zymc);

	List<TjCount> getmydmx(@Param("nf")String nf,@Param("zymc")String zymc);

	List<TjCount> getsxmydpm(@Param("nf")String nf);

	List<TjCount> getsxmymx(@Param("nf")String nf,@Param("zymc")String zymc);

	List<TjCount> getsxmydtbt(@Param("zymc")String zymc);

	List<TjCount> getkyslpm(@Param("nf")String nf);

	List<TjCount> getkyxmmx(@Param("nf")String nf,@Param("zymc") String zymc);

	List<TjCount> getkyjepm(@Param("nf")String nf);

	List<TjCount> getxxsbzslpm();

	List<TjCount> getjsxxsbpm();

	List<TjCount> getxxsbmx(@Param("zymc")String zymc);

	List<TjCount> gethjqkpm(@Param("nf")String nf);

	List<TjCount> xshjmx(@Param("nf")String nf,@Param("zymc") String zymc);

	List<TjCount> hjjqtbt(@Param("zymc")String zymc);

	List<TjCount> getxsxxmydpm();

	List<TjCount> getxsxxmydtbt(@Param("zymc")String zymc);

	List<TjCount> getxsxxmydmx(@Param("nf")String nf, @Param("zymc")String zymc);

	List<TjCount> getgzyjftrpm(@Param("nf")String nf);

	Integer getjfz(@Param("zymc")String zymc);

	List<TjCount> getgzyjftrmx(@Param("nf")String nf, @Param("zymc")String zymc);

	List<TjCount> getlnzyssxjsbl( @Param("zymc")String zymc);

	List<TjCount> getxslyxxfb();

	List<TjCount> getxxzssltbt(@Param("mc")String mc);

	List<TjCount> getzsxxxsmx(@Param("nf")String nf,@Param("mc") String mc);

	List<TjCount> getzsrypx();

	List<TjCount> getgtzsqk(@Param("mc")String mc);

	List<TjCount> getzsjszsmx(@Param("nf")String nf, @Param("mc")String mc);

	List<TjCount> getxssyd();

	List<Object> getxzdqgzyrs(@Param("mc")String mc);

	List<TjCount> getxzzydqxsmx(@Param("nf")String nf,@Param("zymc")String zymc,@Param("mc") String mc);

	List<TjCount> getxdzyxssl(@Param("zymc")String zymc);

	List<TjCount> getxdzygdqxssl(@Param("nf")String nf,@Param("zymc") String zymc);

	List<TjCount> getxdxxgzyxssl(@Param("nf")String nf, @Param("mc")String mc);

	List<TjCount> getxxlyxxxsmx(@Param("nf")String nf, @Param("zymc")String zymc,@Param("mc") String mc);

	List<TjCount> getzsjslist();

	List<TjCount> getzsqdList();

	List<TjCount> getxsslsex(String mc);

	List<TjCount> getxzxbzyxssl(@Param("nf")String nf,@Param("mc") String mc);

	List<TjCount> getzsjsqdbdrssl(@Param("mc")String mc, @Param("dg")String dg);

	List<TjCount> getxbzyxsmxnf(@Param("nf")String nf,@Param("mc") String mc,@Param("zymc") String zymc);

	List<TjCount> getzsqdrylnzssl(@Param("nf")String nf,@Param("mc") String mc,@Param("dg") String dg);

	List<TjCount> getzyqdzsmd(@Param("nf")String nf,@Param("zymc") String zymc,@Param("dg") String dg,@Param("mc") String mc);

	List<TjCount> getxzxmlnpxtbt(@Param("mc")String mc);

	List<TjCount> getxnzypxgxmxs(@Param("nf")String nf);

	List<TjCount> getxzxmmx(@Param("nf")String nf,@Param("mc") String mc);

	List<TjCount> getxsbdrcsl(@Param("mc")String mc);

	List<TjCount> getgldqpxb();

	List<TjCount> getjnbzsmxsj(@Param("nf")String nf,@Param("mc") String mc);

	List<TjCount> getjnbzsrstbt(@Param("mc")String mc);

	List<TjCount> getzszjtbt();

	List<TjCount> getzsqusyqk(@Param("nf")String nf);

	List<TjCount> getzszjmx(@Param("nf")String nf,@Param("mc") String mc);

	List<TjCount> getrjzsfy();

	List<TjCount> getngqdrjzsfy(@Param("nf")String nf);

	List<TjCount> getxxjzsfy(@Param("mc")String mc);

	List<TjCount> getlyxxzsfy();

	List<TjCount> getbysssltbt(@Param("zymc")String zymc, String lb);

	List<TjCount> getxznfdwjysl(@Param("nf")String nf);

	void getinsertmyd(@Param("t")Integer t,@Param("i") Integer i);

	List<TjCount> getxslsslbynf(@Param("nf")String nf);

	List<TjCount> getxslsmx(@Param("nf")String nf,@Param("mc") String mc);

	List<TjCount> getlnlsyytbt(@Param("mc") String mc);

	List<TjCount> getxslsyypx();

	List<TjCount> getxszgzshqsl(@Param("zymc")String zymc);

	List<StudentEntity> getxdnjmx(@Param("nf")String nf,@Param("zymc") String zymc);

	List<TjCount> getzykkscj(@Param("zymc")String zymc,@Param("nf") String nf);

	List<TjCount> getwhkkscj(@Param("zymc")String zymc,@Param("nf") String nf);

	List<TjCount> getwhkksmx(@Param("nf")String nf, @Param("zymc")String zymc,@Param("dg") String dg);

	List<TjCount> getzykksmx(@Param("nf")String nf, @Param("zymc")String zymc,@Param("dg") String dg);

	List<TjCount> getxszzfytbt(@Param("zymc")String zymc,@Param("dqmc") String dqmc);

	List<TjCount> getszzxsmx(@Param("nf")String nf, @Param("zymc")String zymc,@Param("dqmc")String dqmc);

	List<TjCount> getxywhhdmyd();

	List<TjCount> getbysxyaqmyd();

	List<TjCount> getxyshmyd();

	List<TjCount> getxyaqmyd();

	List<TjCount> getsxsxmydtbt();

	List<TjCount> getgjjgtbt();

	List<TjCount> getshengjjtbt();

	List<TjCount> getshijjtbt();

	List<TjCount> getqtjtbt();

	List<TjCount> getxxhjmx(@Param("nf")String nf, @Param("lb")String lb);

	List<TjCount> gettjhgl(String zymc);

	List<TjCount> gettnhgl(String zymc);

	List<TjCount> gettzjcxsmx(@Param("nf")String nf,@Param("zymc") String zymc);

	List<TjCount> getszzxsfb(@Param("dg")String dg);

	List<TjCount> getxzszzxslnsl(@Param("dqmc")String dqmc);

	List<TjCount> getxsxxmydtbt1();

	List<TjCount> getxsxymydmx(@Param("nf")String nf);

	List<TjCount> getbysxxmydmx(@Param("nf")String nf);

	List<TjCount> getxzjsagemx(@Param("nf")String nf,@Param("zymc") String zymc,@Param("aged") String aged);

	List<TjCount> getjsagefb(@Param("nf")String nf, @Param("zymc")String zymc);

	List<JzgEntity> getxzjszcmx(@Param("nf")String nf,  @Param("zymc")String zymc,@Param("dg") String dg);

	List<TjCount> getjszcfbbt();

	List<TjCount> getxzzclnsltbt( @Param("zymc")String zymc,@Param("dg") String dg);

	List<TjCount> getjsxlfb();

	List<TjCount> getxzxlsltbt(@Param("zymc")String zymc,@Param("dg") String dg);

	List<TjCount> getxzzynfxlmx(@Param("nf")String nf, @Param("zymc")String zymc,@Param("dg") String dg);

	List<TjCount> getgjgjsbldjt(@Param("zymc")String zymc);

	List<TjCount> getgjgjssldjt(@Param("zymc")String zymc);

	List<TjCount> getbznwjsbl(@Param("zymc")String zymc);

	List<TjCount> getbznwjssl(@Param("zymc")String zymc);

	List<TjCount> getzjzjsbldjt(@Param("zymc")String zymc);

	List<TjCount> getjszgzsbltbt(@Param("zymc")String zymc);

	List<JzgEntity> getxzczzmx(@Param("nf")String nf,@Param("zymc") String zymc);

	List<TjCount> getssbtbbht(@Param("zymc")String zymc);

	List<TjCount> getjscjgzns(@Param("nf")String nf,@Param("zymc") String zymc);

	List<TjCount> getjsgzsjmx(@Param("nf")String nf, @Param("zymc")String zymc,@Param("dg") String dg);

	List<TjCount> getjspxksmx(@Param("nf")String nf, @Param("zymc")String zymc);

	List<TjCount> getjsrjpxkstbt(@Param("zymc")String zymc);

	List<TjCount> getjskyktsl(@Param("zymc")String zymc);

	List<TjCount> getxzktmx(@Param("nf")String nf, @Param("zymc")String zymc);

	List<TjCount> getjyzyjszwsl( @Param("zymc")String zymc);

	List<TjCount> getjyzyjszwbl( @Param("zymc")String zymc);

	List<TjCount> getjyzyjszwzmx( @Param("nf")String nf,  @Param("zymc")String zymc);

	List<TjCount> getjyzyzyzgzssl( @Param("zymc")String zymc);

	List<TjCount> getlnggjssl(@Param("zymc")String zymc);

	List<TjCount> getlnggjsbl(@Param("zymc")String zymc);

	List<TjCount> getggjsmx(@Param("nf")String nf, @Param("zymc")String zymc);

	List<TjCount> getzyjssltbt(@Param("zymc")String zymc);

	List<TjCount> getxdzyjsbl(@Param("zymc")String zymc);

	List<TjCount> getssxjssl(@Param("zymc")String zymc);

	List<TjCount> getlnssxjssl(@Param("zymc")String zymc);

	List<TjCount> getjxmsmx(@Param("nf")String nf,@Param("zymc") String zymc);

	List<TjCount> getlnjxmssl(@Param("zymc")String zymc);

	List<TjCount> getlnjxmsbl(@Param("zymc")String zymc);

	List<TjCount> gethjjsbm();

	List<TjCount> getjshjmx(@Param("nf")String nf,@Param("zymc") String zymc);

	List<TjCount> getjshjrstj(@Param("nf")String nf, @Param("zymc")String zymc);

	List<TjCount> getjygglist();

	List<TjCount> getjyhwdbht(@Param("zymc")String zymc,@Param("mc") String mc);

	List<ZgzsEntity> getlzxsmx(@Param("nf")String nf, @Param("zymc")String zymc, @Param("mc")String mc);

	Integer getsxjyxszb();

	Integer getzszysl();

	List<TjCount> getzszylist();

	List<TjCount> getbysjydqfb();

	List<TjCount> getbysjydq();

	List<TjCount> getxzdqbyssltbt(@Param("dqmc")String dqmc);

	List<ZgzsEntity> xzbysqxmx(@Param("nf")String nf,@Param("dqmc") String dqmc);

	List<TjCount> glshfwsl();

	List<TjCount> shfwlist();

	List<TjCount> getshfwsktbt(@Param("mc")String mc);

	List<ZgzsEntity> xzfwmx(@Param("nf") String nf,@Param("mc")String mc);

	Double getcxxsbl();

	List<TjCount> getcxxsbltbt(@Param("zymc")String zymc);

	List<StudentEntity> cxxsmx(@Param("nf")String nf,@Param("zymc") String zymc);

	Double getyjbysszhql();

	List<TjCount> getlnyjbysszhql(@Param("zymc")String zymc);

	List<ZgzsEntity> getyjbysszhqmd(@Param("nf")String nf, @Param("zymc")String zymc);

	Double getzjjyl();

	List<TjCount> byhmxlist();

	Double getyjbysjyl();

	Double getsjbysmyd();

	List<TjCount> getdyjgmd(@Param("mc")String mc);

	List<TjCount> getdygzjg();

	Double getyjstzdbl();

	List<TjCount> getlnyjbystzdbl(@Param("zymc")String zymc);

	List<TjCount> getbystzfsmd(@Param("nf")String nf,@Param("zymc") String zymc);

	Double getxxsjwjl();

	List<TjCount> getdqxssjwjl(@Param("zymc")String zymc);

	List<TjCount> getxdxswjmd(@Param("nf")String nf,@Param("zymc") String zymc);

	Integer getsxxssl();

	List<TjCount> getdykcylb();

	List<TjCount> getkccjfb(@Param("kcmc")String kcmc);

	List<TjCount> getkscj(@Param("zymc")String zymc,@Param("kcmc") String kcmc,@Param("nf") String nf);

	List<TjCount> getkccjmx(@Param("kcmc")String kcmc,@Param("dg") String dg);

	List<TjCount> getlndygzdwsl();

	List<TjCount> getxzdycymx(@Param("nf")String nf);

	List<TjCount> getcxjxjscg();

	List<TjCount> getszjybzxcg();

	List<TjCount> getshsjhdcg();

	List<TjCount> getsxxstbt(@Param("zymc")String zymc, @Param("mc")String mc);

	List<TjCount> getjyxstbt(@Param("zymc")String zymc,@Param("mc") String mc);

	List<TjCount> getsxxsmxd(@Param("zymc")String zymc,@Param("mc") String mc,@Param("nf") String nf);

	List<TjCount> getjyxsmxd(@Param("zymc")String zymc,@Param("mc") String mc,@Param("nf") String nf);

	List<TjCount> getbdzymd();

	List<TjCount> getgzylqzzt();

	Double getjyldysnpjz();

	List<TjCount> dypjzymd();

	List<TjCount> zyjsbzxcg();

	Integer getwckcjsxms();

	List<TjCount> wckcjsxmstbt();

	List<TjCount> wckcjsxmmx(@Param("nf")String nf);

	Integer yzdkcbzs();

	List<TjCount> yzdkcbzmx(@Param("nf")String nf);

	List<TjCount> yzdkcbzstbt();

	Integer xqkfkcs();

	List<TjCount> xqkfkcsmx(@Param("nf")String nf);

	List<TjCount> xqkfkcstbt();

	Integer xqkfjcs();

	List<TjCount> xqkfjcstbt();

	List<TjCount> xqkfjcsmx(@Param("nf")String nf);

	List<TjCount> kcjsbzxcgylb();

	List<JzgEntity> szdwsltbt(@Param("zymc")String zymc);

	List<JzgEntity> sznfzyjsmd(@Param("nf")String nf,@Param("zymc") String zymc);

	List<TjCount> getszdwslnlft(@Param("zymc")String zymc);

	List<TjCount> xznljssltbt(@Param("zymc")String zymc,@Param("aged") String aged);

	List<JzgEntity> xznljsmd(@Param("nf")String nf,@Param("zymc") String zymc,@Param("aged") String aged);

	List<TjCount> getszdwzcft(@Param("zymc")String zymc);

	List<TjCount> getszdwgznfft(@Param("zymc")String zymc);

	List<TjCount> szdwgznftbt(@Param("zymc")String zymc,@Param("dg") String dg);

	Double getghjcsyb();

	List<TjCount> ghjcsybtbt();

	List<TjCount> ghjcsymx(@Param("nf")String nf);

	Double getjbjcsyb();

	List<TjCount> jbjcsybtbt();

	List<TjCount> jbjcsymx(@Param("nf")String nf);

	Double getldtskrjsl();

	List<TjCount> ldtskrjsltbt();

	List<TjCount> ldtskrjslmx(@Param("nf")String nf);

	Double ldrssjcssl();

	List<TjCount> ldrssjcstbt();

	List<TjCount> ldrssjcsqd(String nf);

	Double getsjkcl();

	List<TjCount> sjxmkcltbt();

	List<TjCount> sjxmkclylb(@Param("nf")String nf);

	Integer xdzlxjjwtsl();

	List<TjCount> lnxdzlxjjwtsl();

	List<TjCount> xdzlxjjwtmxt(@Param("nf")String nf);

	Integer getjxsgsl();

	List<TjCount> lnjxsgsl();

	List<TjCount> jxsgmx(@Param("nf")String nf);

	Double getxscdl();

	Double xsqkl();

	List<TjCount> xscdltbt();

	List<TjCount> xsqkltbt();

	List<TjCount> xscdmx(@Param("nf")String nf);

	List<TjCount> xsqkmx(@Param("nf")String nf);

	List<TjCount> thkcpjxj();

	List<TjCount> thkcpjpfr(@Param("kcmc")String kcmc,@Param("dg") String dg);

	List<TjCount> xskcpjxj();

	List<TjCount> xskcpjpfr(@Param("kcmc")String kcmc,@Param("dg") String dg);

	List<TjCount> shkcpjxj();

	List<TjCount> shkcpjpfr(@Param("kcmc")String kcmc,@Param("dg") String dg);

	List<TjCount> szdwgxlft(@Param("zymc")String zymc);

	List<TjCount> lnszdwxltbt(@Param("zymc")String zymc,@Param("dg") String dg);

	List<TjCount> szdwxlmd(@Param("nf")String nf,@Param("zymc") String zymc,@Param("dg") String dg);

	Integer zydtrggjssl();

	List<TjCount> lnzydtrggjs(@Param("zymc")String zymc);

	List<JzgEntity> zydtrggjsmd(@Param("nf")String nf, @Param("zymc")String zymc);

	List<TjCount> jspxlxslylb();

	List<TjCount> jspxlxmd(@Param("mc")String mc);

	List<TjCount> getgzyjssl();

	List<TjCount> jsqysjqkylb();

	Integer getwjjssl();

	List<TjCount> jsjykyylb();

	Double getzrssxjsbl();

	List<TjCount> zrjsssxjsbltbt(@Param("zymc")String zymc);

	List<TjCount> zrjsssxjsmd(@Param("nf")String nf,@Param("zymc") String zymc);

	Integer getsjjxzzzdjssl();

	List<TjCount> lnzzzdjssl(@Param("zymc")String zymc);

	List<TjCount> zzzdjsmd(@Param("nf")String nf, @Param("zymc")String zymc);

	Integer getjzszdwsl();

	List<TjCount> jzjssltbt(@Param("zymc")String zymc);

	List<TjCount> getjzszmd(@Param("nf")String nf, @Param("zymc")String zymc);

	List<TjCount> jzszdwslnlft();

	List<TjCount> jzjsnltbt(@Param("zymc")String zymc,@Param("aged")String aged);

	List<TjCount> jzsznlmd(@Param("nf")String nf, @Param("zymc")String zymc,@Param("aged")String aged);

	List<TjCount> jzszdwzcft(@Param("zymc")String zymc);

	List<TjCount> jzjszctbt(@Param("zymc")String zymc,@Param("dg") String dg);

	List<TjCount> jzszzcmd(@Param("nf")String nf,@Param("zymc") String zymc,@Param("dg") String dg);

	List<TjCount> jzszdwgznffb(@Param("zymc")String zymc);

	List<TjCount> jzjsgznftbt(@Param("zymc")String zymc,@Param("dg") String dg);

	List<TjCount> jzszgznfmd(@Param("nf")String nf, @Param("zymc")String zymc,@Param("dg") String dg);

	List<TjCount> jzszdwgxlft(@Param("zymc")String zymc);

	List<TjCount> jzszdwgxltbt(@Param("zymc")String zymc,@Param("dg") String dg);

	List<TjCount> jzszdwgxlmd(@Param("nf")String nf, @Param("zymc")String zymc,@Param("dg") String dg);

	Integer jzzydtrggjssl();

	List<TjCount> jzzydtrggjstbt(@Param("zymc")String zymc);

	List<TjCount> jzzydtrggjsmd(@Param("nf")String nf, @Param("zymc")String zymc);

	Integer jzjspxsl();

	List<TjCount> jzjspxsltbt();

	List<TjCount> jzjspxmd(@Param("nf")String nf);

	List<TjCount> jzszdwzypz();

	List<TjCount> jzszdwzypzmd(@Param("zymc")String zymc);

	Integer getjzjsxnsjxssl();

	List<TjCount> jzjsxnsjxssltbt();

	List<TjCount> jzjsxnsjxsmd(@Param("nf")String nf);

	List<XxmjEntity> xxgjzmjylb();

	Double getxxjzmj();

	Integer getxnsjjdsl();

	List<TjCount> xnsjjdmx();

	Double getxnsjjdzdmj();

	Double xnsjjdsjsbz();

	Integer xwsjjdsl();

	List<TjCount> xwsjjdmx();

	List<TjCount> lnrcjxjftr();

	Double rcjxjftr();

	List<TjCount> jyfsjxjfyszxylb();

	Integer zztszsl();

	Integer dnxzzztssl();

	List<TjCount> lnxzzztssl();

	List<TjCount> xzzztsmx(@Param("nf")String nf);

	Integer dndztssl();

	List<TjCount> lndztssl();

	List<TjCount> dztsmx(@Param("nf")String nf);

	Integer dnhzqysl();

	List<TjCount> lnhzqysl(@Param("zymc")String zymc);

	List<TjCount> hzqymx(@Param("nf")String nf, @Param("zymc")String zymc);

	List<TjCount> getdgsxzy();

	List<TjCount> getjsdgsxxsbl();

	List<TjCount> lndgsxxsbl(@Param("mc")String mc,@Param("zymc") String zymc);

	List<DgsxEntity> dgsxxsmd(@Param("nf")String nf,@Param("zymc") String zymc,@Param("mc") String mc);

	List<TjCount> lyyjbysbl();

	List<TjCount> lnlyyjbysbl(@Param("mc")String mc, @Param("zymc")String zymc);

	List<DgsxEntity> getlydgsxhymx(@Param("mc")String mc, @Param("zymc")String zymc,@Param("nf") String nf);

	Double qyjzje();

	List<TjCount> lnqyjzje();

	List<TjCount> qyjzjemx(@Param("nf")String nf);

	Integer getqyssjzjssl();

	List<TjCount> lnqyssjzjssl();

	List<TjCount> qyssjzjsmd(@Param("nf")String nf);

	List<TjCount> xqhzyfcg();

	List<TjCount> getjbsjcjylb();

	List<TjCount> zyjxzykylb();

	List<TjCount> getzyfgmylb();

	List<TjCount> getzxsmyddcjg();

	List<TjCount> getbysgzdcjg();

	Double getsjbysdkl();

	List<TjCount> lnbysdkl();

	List<TjCount> lnsjbyszgl();

	Double getsjbyszgl();

	Double sjbyssql();

	List<TjCount> lnsjbyssql();

	List<TjCount> getbysbkyy();

	List<TjCount> getyrdwdbysylb();

	List<TjCount> dsjxmysylb();

	List<TjCount> zyjnjdjdxsjg();

	List<TjCount> dsjjybmpsjg();

	List<TjCount> dsjssjshj();

	List<TjCount> rmzfbzylb();

	List<TjCount> jdpxxssl(@Param("zymc")String zymc);

	Integer jxjxsglry();

	List<TjCount> jxjxsglrybt();

	List<TjCount> jxjxsglrymd(@Param("zymc")String zymc);

	List<TjCount> getlnqklxsl();

	List<TjCount> getsjczbktbt();

	Double getsjczbk();

	List<TjCount> getjzgsltbt();

	List<Object> getzsrylnzs(@Param("mc")String mc);

	List<TjCount> nfzslszsmd(@Param("nf")String nf,@Param("mc") String mc);

	List<TjCount> getxssltbt();

	List<TjCount> getxssydfb();

	List<TjCount> xzdqxssltbt(@Param("dqmc")String dqmc);

	List<TjCount> xzdqxsmd(@Param("nf")String nf,@Param("dqmc") String dqmc);

	List<TjCount> getzlbzzdyl();

	List<TjCount> xxgzzdlb();

	List<TjCount> getlnzygjjssl(@Param("zymc")String zymc);

	List<TjCount> getdjkstbt();

	List<TjCount> getlnzysl();

	List<TjCount> getxdnfdjflmx(@Param("nf")String nf,@Param("lb") String lb);

	List<TjCount> getxdnfdjflbt(@Param("nf")String nf);

	List<TjCount> getjfkzdjt();

	List<TjCount> getjfzscd(@Param("t")String t);

	List<TjCount> getlnbxzjf();

	List<TjCount> getjfly(@Param("nf")String nf);

	List<TjCount> getsjjftbt();

	List<TjCount> getzyjftbt();

	List<TjCount> getbysjsjkstgltbt(@Param("zymc")String zymc);

	List<TjCount> getbysjsjksmx(@Param("nf")String nf,@Param("zymc") String zymc);

	List<TjCount> getbyszgzshqtbt(@Param("zymc")String zymc);

	List<ZgzsEntity> getzgzList(@Param("nf")String nf, @Param("zymc")String zymc);

	List<TjCount> getrxqdtbt();

	List<TjCount> getgrxqdtbt(@Param("zymc")String zymc);

	List<TjCount> getzyqdxsmd(@Param("zymc")String zymc,@Param("mc") String mc);

	List<TjCount> getrxqdlist();

	List<TjCount> lnbysdkjybht(@Param("zymc")String zymc,@Param("lb") String lb);

	List<TjCount> getbtsdkjymd(@Param("nf")String nf,@Param("zymc") String zymc,@Param("lb") String lb);

	List<TjCount> nfzyqdxsmd(@Param("nf")String nf,@Param("zymc") String zymc, @Param("lb")String lb);

	List<TjCount> getgzyjsbltbt(@Param("zymc")String zymc);

	Double getbysjsjlsl();

	Integer getzyrjssl(@Param("mc")String mc);

	Integer getjzjssl2(@Param("mc")String mc);

	List<TjCount> getrjqysjsj(@Param("zymc")String zymc);

	List<TjCount> getlnssxjsbl(@Param("zymc")String zymc);

	List<TjCount> getgzyxssl2();
	
	//课程线下分析*********************************************************
	//平均分数同比变化图部分
	List<TjCount> getpjfsList(@Param("zymc")String zymc,@Param("bjmc")String bjmc,@Param("kcmc")String kcmc);
	//学生考试分数明细表
	List<TjCount> getxsksmx(@Param("zymc")String zymc,@Param("bjmc")String bjmc,@Param("kcmc")String kcmc,@Param("nf")String nf);
	//专业  班级  课程 年份
	List<TjCount> getzymc();
	List<TjCount> getbjmc(@Param("zymc")String zymc);
	List<TjCount> getkcmc(@Param("zymc")String zymc,@Param("bjmc")String bjmc);
	List<TjCount> getnf();
	//课程考试范围分布图
	List<TjCount> getkcfsfb(@Param("zymc")String zymc,@Param("bjmc")String bjmc,@Param("kcmc")String kcmc,@Param("nf")String nf);
	//考试范围明细
	List<TjCount> getfsfwmx(@Param("zymc")String zymc,@Param("bjmc")String bjmc,@Param("kcmc")String kcmc,@Param("nf")String nf,@Param("dg")String dg);
	
	//课程迟到/早退/请假人数柱状图
	List<TjCount> getczqrs(@Param("kcmc")String kcmc);
	//课程迟到/早退/请假课程
	List<TjCount> getsgkcmc();
	//部分迟到/早退/请假人数饼图
	List<TjCount> getbfczqrs(@Param("kcmc")String kcmc,@Param("nf")String nf);
	//部分迟到/早退/请假人明细
	List<TjCount> getbfczqrsmx(@Param("kcmc")String kcmc,@Param("nf")String nf,@Param("lb")String lb);
	//精品课程增长柱状图
	List<TjCount> getjpkzz(@Param("zymc")String zymc);
	//开设精品课的专业 
	List<TjCount> getjpkczymx();
	//精品课程明细
	List<TjCount> getjpkcmx(@Param("zymc")String zymc,@Param("nf")String nf);
	
	
	//毕业生资格证书获取明细
	List<TjCount> getbyszgzshqmx(@Param("nf") String nf);
	
	
	
	
}
