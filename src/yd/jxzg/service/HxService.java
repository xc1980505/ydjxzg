package yd.jxzg.service;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import yd.jxzg.common.TjCount;
import yd.jxzg.entity.BysxzEntity;
import yd.jxzg.entity.JzgEntity;
import yd.jxzg.entity.KcEntity;
import yd.jxzg.entity.StudentEntity;
import yd.jxzg.entity.XxjbqkEntity;
import yd.jxzg.entity.XxmjEntity;
import yd.jxzg.entity.ZgzsEntity;
import yd.jxzg.entity.ZyxxEntity;



public interface  HxService {


	Map<String, Object> getStuCount(String flag,String zym, String rxnj, String bh);

	Integer getTotalCountStu(Object object);

	Map<String, Object> getToStudentCount();

	Integer getZrjsCount();

	Map<String, Object> getGjgslbt();

	Map<String, Object> getggxzmc();

	Double getsbzz();

	Map<String, Object> getxsyqsbtb();

	Integer getsxgws();

	Map<String, Object> getxnsxgwstb();

	Integer getxwjd();
	//实训生数
	Map<String, Object> getxwjdtb();

	Map<String, Object> getjdsxqd(String jdrq);

	List<Object> getgjbfb();

	Map<String, Object> getzyjsbfb();

	TjCount getdoublejsbfb();

	Double getsjzdmj();

	Map<String, Object> getsjydtbt();

	Map<String, Object> getxznfxsmx(String nf);

	Double getxsjzmj();

	Double sjxsmj();

	Map<String, Object> getsjxsmjtbt();

	Double gettxydmj();

	Integer getSjzzts();

	Map<String, Object> zztstbt();

	Double getsjyqsbz();

	Integer getjsjsjyysl();

	Map<String, Object> getjsjtbt();

	Double getxxzdmj();

	List<XxmjEntity> getXxgjzmj();

	List<TjCount> getjssltbt();

	List<TjCount> getzxsxstbt();

	List<TjCount> getxxzystbt();

	Map<String, Object> getxdnfzyqd(String nf);

	TjCount getggkcsl();

	TjCount getzykcsl();

	Map<String, Object> getkcqd(String nf);

	List<TjCount> getzsbtbt();

	List<TjCount> getxzsbtbt();

	Double getlhmj();

	Double getflhmj();

	Double getxscqmj();

	Double getfxscqmj();

	List<TjCount> gettstbt();

	List<TjCount> getzztstbt();

	List<TjCount> getdztstbt();

	List<TjCount> getsjzztstbt();

	List<TjCount> getsjsbtbt();

	Map<String, Object> getgzyssb();

	List<TjCount> getzyxstbt();

	Double getyydmj();

	Integer getxnsxgws();

	TjCount getsjczbk();

	TjCount getsjjxyfmj();

	Map<String, Object> getjxfzyftbt();

	TjCount getxzbgyfmj();
	
	Map<String, Object> getxzbgyfmjtbt();

	TjCount getwldmtjssl();

	Map<String, Object> getmbmjsjstbt();

	Map<String, Object> getwldmtjstbt();

	TjCount flwdk();

	Map<String, Object> getdktbt();

	Map<String, Object> getflwzc(String nf);

	TjCount getswkc();
	
	Map<String, Object> bysqx(String bylx);

	Map<String, Object> getswkctbt();

	Integer getsjxnsjgws();

	Map<String, Object> getsjxnsjgwstbt();

	Map<String, Object> ssxjstbt();

	Map<String, Object> getxdnfssxjsmd(String nf, String zym);

	List<KcEntity> getkcList(String nf, String zym);

	TjCount getsjxwsxsj();

	Map<String, Object> getxwsxjdsxsjtbt();

	Map<String, Object> getxznfxwsxjh(String nf);

	TjCount getqyddpyxs();

	TjCount getqyzfjzkc();

	Map<String, Object> getnzfqyjzjstbt();

	TjCount getnzrzyjssjsj();

	Map<String, Object> getzyjssjtbt();

	TjCount getqytgxnsjjusbz();

	Map<String, Object> getqytgxnsjjxsbtbt();

	List<TjCount> getbysjsjkstgl();

	Map<String, Object> getbysjsjkstgltbt(String zymc);

	TjCount getbyszyzgzshql();

	Map<String, Object> getbyszgzshqtbt(String zym);

	Map<String, Object> getxznfzgzsmx(String nf, String zymc);

	TjCount getzjjyl();
	Map<String ,Object> getzjjyltbt();

	Map<String, Object> getjysmx(String nf);

	List<TjCount> getgzyxsslbt();

	Map<String, Object> getgzyzxssltbt(String zym);

	Map<String, Object> getxdxnxdzyxsmd(String nf, String zym);

	List<TjCount> getbxxy();

	List<TjCount> getjgsltbt();

	List<TjCount> getzxstb();

	List<TjCount> getxxzystbt1();

	List<TjCount> getsjGwstbt();

	Map<String, Object> getssbtbt();

	TjCount getfzyfmj();

	Map<String, Object> getgjxfzyfmjqd();

	TjCount getshyfmj();

	Map<String, Object> getgshyfmjqd();

	List<TjCount> gettysbtbt();

	List<TjCount> getzysbtbt();

	List<TjCount> getdkzztbt();

	List<XxjbqkEntity> getxznfdkckmx(String nf);

	List<TjCount> getwlxxjdzztbt();

	List<TjCount> getxznfwlxxjdfb(String nf);

	TjCount getsjsbz();

	List<TjCount> getsjczbktbt();

	List<TjCount> getswkctbt1();

	TjCount getmbmjsjstbt1();

	TjCount getssbl();

	List<TjCount> getbxzjf();

	List<TjCount> getjfly(String nf);

	List<TjCount> getsjjftbt();

	List<TjCount> getzyjftbt();

	List<TjCount> getxdnzyjfmx(String nf);

	List<Object> getjfkzdjt();

	List<TjCount> getxdnfdjflbt(String nf);

	List<TjCount> getjxtrjetbt();

	List<TjCount> getbxjfzcbt();

	List<Object> getjssltbdjt(String zym);

	List<JzgEntity> getxznfzjzjs(String nf, String zym);

	List<TjCount> getzylist();

	List<TjCount> getzyjsbl();


	List<TjCount> getssxjstbtzy(String zym);

	List<Object> getgjsfzysltbt();

	List<ZyxxEntity> getsfzylist(String nf);

	List<Object> szdzysltbt();

	List<ZyxxEntity> getxzszdzymd(String nf);

	List<Object> sppzysltbt();

	List<TjCount> getlhflmj();

	List<TjCount> getxscfqmj();

	TjCount getxzbgyf();

	TjCount getjzzz();

	TjCount getqtmj();

	List<KcEntity> getggkcqd();

	List<KcEntity> getzykcqd();

	List<ZyxxEntity> getxzszymd(String nf);

	List<Object> getqttszytbt();

	List<ZyxxEntity> getxznfqtzymd(String nf);

	List<Object> getkcList1(String nf, String zym);

	List<Object> getjpkctbt();

	List<KcEntity> getjpkcqd(String nf);

	List<Object> getxztxkctbt();

	List<KcEntity> getxzttkclist(String nf);

	List<Object> getzxkctbt();

	List<KcEntity> getnfzxkcqd(String nf);

	List<Object> getxssltbtcx(String lb,String nf, String zym, String dqmc);

	List<StudentEntity> getxsmd(String lb, String nf, String zym, String dqmc);

	List<TjCount> getstuzy();

	List<TjCount> dqlist();
	List<TjCount> pycc();
	List<TjCount> stunj();

	List<Object> getstujkzs(String lb, String nf, String zym, String dqmc);

	List<Object> getstujkqd(String lb, String nf, String zym, String dqmc);

	List<Object> getlnzsrstbt(String zym);

	List<Object> getxzzsmd(String zym, String zym2);

	List<Object> getdjtbt(String lb);

	List<Object> getjyltbt();

	List<TjCount> getxznfjyl(String nf);

	List<Object> getjyxsmd(String nf, String zymc);

	List<Object> gethzqytbt( String zymc);

	List<TjCount> xzqyjytbt(String mc);
	
	List<TjCount>  getgxnxsrs(String zymc);

	List<TjCount> getxzqyjymd(String mc, String nf);

	List<Object> getzjxsslpm(String nf);

	List<TjCount> getzynjxsdbt(String nf, String zymc);

	List<TjCount> getbjxssl(String nf, String zymc);


	List<StudentEntity> getgbjxsmd(String bh);

	List<Object> getxslspm(String zymc);

	List<Object> getxzxslsnjfbt(String nf, String zymc);

	List<Object> getzyjnpx(String zymc);

	List<Object> getggkcpjcjpm(String zymc, String kcmc, String nf);

	List<Object> getcjqgpm(String zymc, String kcmc);

	List<Object> getcjqgpm(String zymc, String kcmc, String nf);

	List<Object> gethqzsbl(String nf);

	List<Object> getlnzshqtbt(String zym) ;

	List<ZgzsEntity> gethqzsxsmx(String zym, String nf);

	List<Object> getzyjsbl2(String zymc);

	List<Object> getssxjstbtzy1(String zym);

	List<Object> getgzypjxc(String nf);

	List<TjCount> getxzzyxztbt(String zymc);

	List<BysxzEntity> getbysxzmx(String nf, String zymc);
	
	List<TjCount> getbysjymx(String nf, String zymc);

	List<Object> getgzyjylpm(String nf);

	List<Object> getxzzyjyl(String zymc);

	List<Object> getxzzyjyl(String nf, String zymc);

	List<Object> gebysmyd(String nf);

	List<Object> getsjgwpm();

	List<Object> getsbjepm();

	List<Object> getkyslpm(String nf);

	List<Object> getxwjdslpm(String nf);

	List<Object> getxzjdmx(String nf, String zymc);

	List<Object> getxssltbzzt();

	List<Object> getzyyxsslbt(String nf);

	List<Object> getxzxsmx(String nf, String zymc, String lb);

	List<Object> getxszyfbt();

	List<Object> getlnzyxssl(String zymc);

	List<Object> getxsjyflfb();

	List<Object> getlxxstbt(String lb);

	List<TjCount> getbjlist();

	List<Object> getagegb(String bh, String zymc);

	List<Object> getnlfbmx(String bh, String zymc, String aged);

	List<Object> getxsxbfb(String bh, String zymc);

	List<Object> getxbxsmx(String bh, String zymc, String lb);

	List<Object> getssmzfb(String bh, String zymc);

	List<Object> getssmzmx(String bh, String zymc, String lb);

	List<Object> getxssyzl(String zymc);

	List<Object> getxzcjmx(String bh, String zymc, String lb);

	List<Object> getdxsslbl(String zymc);

	List<Object> getdxssl(String zymc);

	List<Object> getdxsmx(String nf, String zymc);

	List<Object> getrxqdtbt();

	List<Object> getgzyrxqd(String mc);

	List<Object> getbdrytbt(String lb, String zymc);

	List<TjCount> getbyszy1();

	List<Object> getlndkjy(String zymc);

	List<Object> getlndkjybl(String zymc);

	List<Object> getdkjyxsmx(String nf, String zymc);

	List<Object> getghypxb(String zymc);

	List<Object> getxzhytbt(String lb);

	List<Object> gethyjymx(String lb);

	List<Object> getsxxxpm(String zymc, String nf);

	List<Object> getlnsxxxtbt(String mc);

	List<Object> getxzxxsxmx(String nf, String mc);

	List<Object> getjyqdbt();

	List<Object> getxzqdlntbt(String mc);

	List<Object> getxzqdjymx(String mc, String nf);

	List<TjCount> getdgsxqy();

	List<Object> getdgsxrs(String zymc, String mc);

	List<Object> getdgsxmx(String mc, String zymc, String nf);

	List<Object> getdghlytbt(String zymc, String mc);

	List<Object> getdgsxlymx(String mc, String zymc, String nf);

	List<Object> getdglylbht(String zymc, String mc);

	List<Object> getghzqyjy(String mc);

	List<Object> getxzqyjymx(String mc, String nf);

	List<TjCount> getjyszy();

	List<Object> getbydyfbt(String zymc);

	List<Object> getxdyjytbt(String zymc, String mc);

	List<Object> getbysdymx(String zymc, String mc, String nf);

	List<Object> getdwmyd(String zymc);

	List<Object> getgqymydmx(String nf);

	List<Object> getbysxzfb(String lb, String nf, String zymc);

	List<Object> getxzbfxzmx(String lb, String nf, String zymc, String dg);

	List<Object> lnbysxcbht(String lb, String zymc);


	List<TjCount> getxdzyssbtbt(String zym);

	List<TjCount> getxdzyjssltbt(String zym);

	List<JzgEntity> getxdzynfjsmd(String zym, String nf);

	List<TjCount> getlnbmxssltb(String zym);

	List<StudentEntity> getydbmxsmd(String zym, String nf);

	List<TjCount> getgzyjsbl();

	List<Object> getgzyzrjssl();

	List<Object> getgzyzrjsb();

	List<Object> getlnxdgjzwsl(String zymc);

	List<Object> getgjzwmd(String nf, String zymc);

	List<Object> getgzyssxsjbl();

	List<Object> getxdzyssxjsbl(String zymc);

	List<Object> getxdssxjsmd(String nf, String zymc);

	TjCount getqklxsl();

	List<Object> bktbt();

	TjCount getjzgylszw();

	TjCount getxsylszw();

	List<Object> getxsyls();

	List<Object> getjzgyls();

	List<Object> getbkflbt(String nf);

	List<Object> getbkflmx(String nf, String mc);

	List<Object> getxzsbqd(String nf);

	List<Object> getsjjxfzyf();

	List<TjCount> getxzjxfzyf(String nf);

	List<Object> getxzxzbgqd(String nf);

	List<Object> getxzjsjqd(String nf);

	List<TjCount> getwldmtjsmx(String nf);

	List<TjCount> getjxgwxq(String nf);

	List<TjCount> getjszylist();

	List<Object> getsjxwjssysj();

	List<Object> getxwjdjhb(String nf);

	List<Object> getqytgsxsbmx(String nf);

	List<Object> getjzjskc(String nf, String zymc);

	List<Object> getjzgqysj(String nf, String zymc);

	List<Object> getbysjsjkstgmd(String nf, String zymc);

	TjCount getsnggl();

	List<Object> getsnggltbt(String zymc);

	List<Object> getlsxsmx(String nf, String zymc);

	List<Object> getzybd();

	List<Object> getcxzszy();

	List<Object> getqrzpxbbd();

	List<Object> getsxsvsyl(String mc);

	List<TjCount> getsxks();

	List<Object> getsxssbsyqd(String nf, String mc);

	List<Object> jzgzzqd();

	List<Object> getqtyfmjqd();

	List<Object> getqktbt();

	List<Object> getqkflsl(String nf);

	List<Object> gettslxsl(String nf);

	List<Object> getdztslxsl(String nf);

	List<Object> gettysbmx(String nf);

	List<Object> getzysbmx(String nf);

	List<TjCount> getgjg();

	List<Object> getxzgzydysl(String nf);

	List<Object> getxddymd(String nf, String zymc);

	List<Object> getdjkstbt();

	List<Object> getdjhdqd(String nf);

	List<Object> getdjpxmd(String nf, String mc);

	List<Object> getdjpxqd(String nf);

	List<Object> getdjhdtbt();

	List<TjCount> getkczy();

	List<Object> getpxxmmx(String nf, String zymc);

	List<Object> getpxxsmd(String nf,String zymc);

	List<Object> getrcyjpm(String nf, String zymc);

	List<Object> getlnrcyjsl(String zymc);

	List<Object> getrcyjmx(String nf);

	List<Object> getzjjssl(String nf);

	List<Object> getlnzjjssltbt(String zymc);

	List<Object> getgjssmx(String nf, String zymc);

	List<Object> getszxldbt(String zymc);

	List<Object> getzyszxldjbt();

	List<JzgEntity> getxdjsxlmx(String nf, String zymc);

	List<Object> getjszcdjt();

	List<Object> getzyzcbht(String zymc);

	List<Object> getssxjsblpm(String nf);

	List<Object> getzjzjsdjt();

	List<Object> getzyzjzjsdjt(String zymc);

	List<Object> getwhzyjsdjt();

	List<Object> getxzwzjsdjt(String zymc);

	List<Object> getzybysmydtbt(String zymc);

	List<Object> getmydmx(String nf, String zymc);

	List<Object> getsxmydpm(String nf);

	List<Object> getsxmydtbt(String zymc);

	List<Object> getsxmydtbt(String nf, String zymc);

	List<Object> getkyjepm(String nf);

	List<Object> getkyxmmx(String nf, String zymc);

	List<Object> getxxsbzslpm();

	List<Object> xxsbmx(String zymc);

	List<Object> getsjslpm();

	List<Object> gethjqkpm(String nf);

	List<Object> gethjqkmx(String nf, String zymc);

	List<Object> gethjjqtbt(String zymc);

	List<Object> getxsxxmydpm();

	List<Object> getxsxxmydtbt(String zymc);

	List<Object> getxsxxmydmx(String nf, String zymc);

	List<Object> getgzyjftrpm(String nf);

	List<Object> getzyjftrtbt(String zymc);

	List<Object> getjftrmx(String nf, String zymc);

	List<Object> getzylnssxjssl(String zymc);

	List<Object> getxssydfb();

	List<Object> getxslyxxfb();

	List<Object> getzsxxxsmx(String mc, String nf);

	List<Object> getxxzssltbt(String mc);

	List<Object> getzsryzspx();

	List<Object> getgtzsqk(String mc);

	List<Object> getzsjszsmx(String nf, String mc);

	List<Object> getzsrylnzs(String mc);

	List<Object> getxsbdrsfbt();

	List<Object> getxzdqgzyrs(String mc);

	List<Object> getxzzydqxsmx( String nf,String zymc, String mc);

	List<Object> getgzyxssltbt(String zymc);

	List<Object> getxdzygdqxssl(String nf, String zymc);

	List<Object> getglyxxxssltbt(String mc);

	List<Object> getxdxxgzyxssl(String nf, String mc);

	List<Object> getxxlyxxxsmx(String nf, String zymc, String mc);

	List<Object> getxbxsbrstbt(String mc);

	List<TjCount> getzsjslist();

	List<TjCount> getzsqdList();

	List<Object> getzsjsqdbdrssl(String mc, String dg);

	List<Object> getxzxbzyxssl(String nf, String mc);

	List<Object> getxbzyxsmx(String nf, String mc, String zymc);

	List<Object> getzsqdrylnzssl(String nf, String mc, String dg);

	List<Object> zyqdzsmd(String nf, String zymc, String dg, String mc);

	List<Object> getxzxmlnpxtbt(String mc);

	List<Object> getxnzypxgxmxs(String nf);

	List<Object> getxzxmmx(String nf, String mc);

	List<Object> getjnbzsmxsj(String nf,String mc);

	List<Object> getjnbzsrstbt(String mc);

	List<Object> getxsbdrcsl(String mc);

	List<TjCount> getgldqpxb();

	List<Object> getzszjtbt();

	List<Object> getzsqusyqk(String nf);

	List<Object> getzszjmx(String nf, String mc);

	List<Object> getrjzsfy();

	List<Object> getngqdrjzsfy(String nf);

	List<Object> getxxjzsfy(String mc);

	List<Object> getlyxxzsfy();

	List<Object> getbyssltbt(String zymc, String lb);

	List<Object> getlnjyrs();

	List<Object> getlnsxrs();

	List<Object> getgsxxxbt(String nf);

	List<Object> getxznfdwjysl(String nf);

	List<Object> getxslsbht(String nf);

	List<Object> getxslsmx(String nf, String mc);

	List<Object> getxslsyypx();

	List<Object> getlnlsyytbt(String mc);

	List<Object> getxszgzshqsl(String zymc);

	List<Object> getgnjxxsl(String zymc);

	List<Object> getxdnjmx(String nf, String zymc);

	List<Object> getwhkkscj(String zymc, String nf);

	List<Object> getzykkscj(String zymc, String nf);

	List<Object> getzykksmx(String nf, String zymc, String dg);

	List<Object> getwhkksmx(String nf, String zymc, String dg);

	List<TjCount> getdqlist();

	List<Object> getxszzfytbt(String zymc, String dqmc);

	List<Object> getszzxsmx(String nf, String zymc, String dqmc);

	List<Object> gettjhgl(String zymc);

	List<Object> gettnhgl(String zymc);

	List<Object> gettjhglmx(String nf, String zymc);

	List<Object> getbysxyaqmyd();

	List<Object> getxyaqmyd();

	List<Object> getxyshmyd();

	List<Object> getxywhhdmyd();

	List<Object> getsxsxmydtbt();

	List<Object> getgjjgtbt();

	List<Object> getshengjjtbt();

	List<Object> getshijjtbt();

	List<Object> getqtjtbt();

	List<Object> getxxhjxxmx(String nf, String lb);

	List<Object> getszzxsfb(String dg);

	List<Object> xzszzxslnsl(String dqmc);

	List<Object> getxsxxmydtbt1();

	List<Object> getxsxymydmx(String nf);

	List<Object> getbysxxmydmx(String nf);

	List<Object> xzjsagemx(String nf, String zymc, String aged);

	List<Object> getjsagefb(String nf, String zymc);

	List<Object> xzjszcmx(String nf, String zymc, String dg);

	List<Object> getxzzclnsltbt(String zymc, String dg);

	List<Object> getjszcfbbt();

	List<Object> getjsxlfb();

	List<Object> getxzxlsltbt(String zymc, String dg);

	List<Object> xzzynfxlmx(String nf, String zymc, String dg);

	List<Object> gjgjsbldjt(String zymc);

	List<Object> getgjgjssldjt(String zymc);

	List<Object> getbznwjsbl(String zymc);

	List<Object> getbznwjssl(String zymc);

	List<Object> getzjzjssldjt(String zymc);

	List<Object> getzjzjsbldjt(String zymc);

	List<Object> getjszgzsbltbt(String zymc);

	List<JzgEntity> getxzczzmx(String nf, String zymc);

	List<Object> getssbtbbht(String zymc);

	List<Object> getjscjgzns(String nf, String zymc);

	List<Object> getjsgzsjmx(String nf, String zymc, String dg);

	List<Object> getjsrjpxkstbt(String zymc);

	List<Object> getjspxksmx(String nf, String zymc);

	List<Object> getjskyktsl(String zymc);

	List<Object> getxzktmx(String nf, String zymc);

	List<Object> getjyzyjszwsl(String zymc);

	List<Object> getjyzyjszwbl(String zymc);

	List<Object> getjyzyjszwzmx(String nf, String zymc);

	List<Object> getjyzyzyzgzssl(String zymc);

	List<Object> getggjssl(String zymc);

	List<Object> getggjsbl(String zymc);

	List<Object> getggjsmx(String nf, String zymc);

	List<Object> getzyjssl(String zymc);

	List<Object> getxdzyjsbl(String zymc);

	List<Object> getssxjsbl(String zymc);

	List<Object> getssxjssl(String zymc);

	List<Object> getjxmsbltbt(String zymc);

	List<Object> getjxmssltbt(String zymc);

	List<Object> getjxmsmx(String nf, String zymc);

	List<Object> getjshjrstj(String nf, String zymc);

	List<Object> getjshjmx(String nf, String zymc);

	List<TjCount> gethjjsbm();

	List<TjCount> getjygglist();

	List<Object> getjyhwdbht(String zymc, String mc);

	List<Object> getlzxsmx(String nf, String zymc, String mc);

	TjCount getzxszsl();

	List<Object> getsxjyxszb();

	TjCount getzszysl();

	List<Object> getxxzyjgsxt();

	List<Object> getbysjydqfb();

	List<TjCount> getbysbydq();

	List<Object> getxzdqbyssltbt(String dqmc);

	List<Object> xzbysqxmx(String nf, String dqmc);

	List<Object> glshfwsl();

	List<TjCount> shfwlist();

	List<Object> getshfwsktbt(String mc);

	List<Object> xzfwmx(String nf, String mc);

	TjCount getcxxsbl();

	List<Object> getcxxsbltbt(String zymc);

	List<Object> cxxsmx(String nf, String mc);

	TjCount getyjbysszhql();

	List<Object> getlnyjbysszhql(String zymc);

	List<Object> getyjbysszhqmd(String nf, String zymc);

	List<TjCount> byhmxlist();

	TjCount getbysdkjyl();

	List<Object> yjsdkjyltbt(String zymc);

	TjCount getsjbysmyd();

	List<Object> getdygzjg();

	List<Object> getdyjgmd(String mc);

	List<TjCount> getdygzjglist();

	TjCount getyjstzdbl();

	List<Object> getlnyjbystzdbl(String zymc);

	List<Object> getbystzfsmd(String nf, String zymc);

	TjCount getxxsjwjl();

	List<Object> getdqxssjwjl(String zymc);

	List<Object> getxdxswjmd(String nf, String zymc);

	List<Object> getbdzymd();

	List<Object> getdykcylb();

	List<Object> getkccjfb(String kcmc);

	List<Object> xscj(String zymc, String kcmc, String nf);

	List<Object> kccjmx(String kcmc, String dg);

	List<Object> getdygzdwtbt();

	List<Object> xzdycymx(String nf);

	List<Object> getcxjxjscg();

	List<Object> getszjybzxcg();

	List<Object> getshsjhdcg();

	List<Object> getsxxstbt(String zymc, String mc);

	List<Object> xzsxxsmx(String nf, String zymc, String mc);

	List<TjCount> getgzyxsslzzt();

	List<Object> getgzylqzzt();

	List<Object> xdnfzyxsmx(String nf, String zymc);

	List<Object> getlnxslqsl(String zymc);

	TjCount getjyldysnpjz();

	List<Object> dypjzymd();

	List<Object> zyjsbzxcg();

	TjCount wckcjsxms();

	List<Object> wckcjsxmmx(String nf);

	List<Object> wckcjsxmstbt();

	TjCount yzdkcbzs();

	List<Object> yzdkcbzmx(String nf);

	List<Object> yzdkcbzstbt();

	TjCount xqkfkcs();

	List<Object> xqkfkcsmx(String nf);

	List<Object> xqkfkcstbt();

	TjCount xqkfjcs();

	List<Object> xqkfjcstbt();

	List<Object> xqkfjcsmx(String nf);

	List<Object> kcjsbzxcgylb();

	TjCount getszdwsl();

	List<Object> szdwsltbt(String zymc);

	List<JzgEntity> sznfzyjsmd(String zymc, String nf);

	List<Object> getszdwslnlft(String zymc);

	List<JzgEntity> xznljsmd(String zymc, String nf, String aged);

	List<Object> xznljssltbt(String zymc, String aged);

	List<Object> getszdwzcft(String zymc);

	List<Object> szdwgznfft(String zymc);

	List<Object> szdwgznftbt(String zymc, String dg);

	TjCount getghjcsyb();

	List<Object> ghjcsybtbt();

	List<Object> ghjcsymx(String nf);

	TjCount getjbjcsyb();

	List<Object> jbjcsybtbt();

	List<Object> jbjcsymx(String nf);

	TjCount ldtskrjsl();

	List<Object> ldtskrjsltbt();

	List<Object> ldtskrjslmx(String nf);

	TjCount ldrssjcssl();

	List<Object> ldrssjcstbt();

	List<Object> ldrssjcsqd(String nf);

	TjCount thpjfgm();

	List<Object> thkcpjxj();

	List<Object> thkcpjpfr(String kcmc, String dg);

	TjCount sjxmkcl();

	List<Object> sjxmkcltbt();

	List<Object> sjxmkclylb(String nf);

	TjCount xdzlxjjwtsl();

	List<Object> lnxdzlxjjwtsl();

	List<Object> xdzlxjjwtmxt(String nf);

	TjCount getjxsgsl();

	List<Object> lnjxsgsl();

	List<Object> jxsgmx(String nf);

	TjCount xscdl();

	TjCount xsqkl();

	List<Object> xscdltbt();

	List<Object> xsqkltbt();

	List<Object> xscdmx(String nf);

	List<Object> xsqkmx(String nf);

	TjCount xspjylb();

	TjCount shpjylb();

	List<Object> xskcpjxj();

	List<Object> xskcpjpfr(String kcmc, String dg);

	List<Object> shkcpjxj();

	List<Object> shkcpjpfr(String kcmc, String dg);

	List<Object> szdwgxlft(String zymc);

	List<Object> lnszdwxltbt(String zymc, String dg);

	List<Object> szdwxlmd(String nf, String zymc, String dg);

	TjCount zydtrggjssl();

	List<Object> lnzydtrggjs(String zymc);

	List<Object> zydtrggjsmd(String nf, String zymc);

	List<Object> jspxlxslylb();

	List<Object> jspxlxmd(String mc);

	List<Object> gzyjsslylb();

	List<Object> jsqysjqkylb();

	TjCount wjjssl();

	List<Object> jsjykyylb();

	TjCount getzrjsssxjsbl();

	List<Object> zrjsssxjsbltbt(String zymc);

	List<Object> zrjsssxjsmd(String nf, String zymc);

	TjCount sjjxzzzdjssl();

	List<Object> lnzzzdjssl(String zymc);

	List<Object> zzzdjsmd(String nf, String zymc);

	TjCount jzszdwsl();

	List<Object> jzjssltbt(String zymc);

	List<Object> getjzszmd(String nf, String zymc);

	List<Object> jzszdwslnlft(String zymc);

	List<Object> jzjsnltbt(String zymc,String aged);

	List<Object> jzsznlmd(String nf, String zymc, String aged);

	List<Object> jzszdwzcft(String zymc);

	List<Object> jzjszctbt(String zymc, String dg);

	List<Object> jzszzcmd(String nf, String zymc, String dg);

	List<Object> jzszdwgznffb(String zymc);

	List<Object> jzjsgznftbt(String zymc, String dg);

	List<Object> jzszgznfmd(String nf, String zymc, String dg);

	List<Object> jzszdwgxlft(String zymc);

	List<Object> jzszdwgxltbt(String zymc, String dg);

	List<Object> jzszdwgxlmd(String nf, String zymc, String dg);

	TjCount jzzydtrggjssl();

	List<Object> jzzydtrggjstbt(String zymc);

	List<Object> jzzydtrggjsmd(String nf, String zymc);

	TjCount jzjspxsl();

	List<Object> jzjspxsltbt();

	List<Object> jzjspxmd(String nf);

	List<Object> jzszdwzypz();

	List<Object> jzszdwzypzmd(String zymc);

	TjCount jzjsxnsjxssl();

	List<Object> jzjsxnsjxsmd(String nf);

	List<Object> jzjsxnsjxssltbt();

	TjCount getxxzzdmj();

	TjCount getxxzjzmj();

	List<Object> xxgjzmjylb();

	TjCount xnsjjdsl();

	List<Object> xnsjjdmx();

	TjCount xnsjjdzdmj();

	TjCount xnsjjdsjsbz();

	TjCount xwsjjdsl();

	List<Object> xwsjjdmx();

	TjCount rcjxjftr();

	List<Object> rcjxjftrtbt();

	List<Object> jyfsjxjfyszxylb();

	TjCount zztszs();

	TjCount dnxzzztssl();

	List<Object> lnxzzztssl();

	List<Object> xzzztsmx(String nf);

	TjCount dndztssl();

	List<Object> lndztssl();

	List<Object> dztsmx(String nf);

	List<Object> zyjxzykylb();

	List<Object> jbsjcjylb();

	List<Object> zyfgmylb();

	TjCount dnhzqysl();

	List<Object> lnhzqysl(String zymc);

	List<Object> hzqymx(String nf, String zymc);

	List<TjCount> getdgsxzy();

	List<Object> jsdgsxxsbl();

	List<Object> lndgsxxsbl(String mc, String zymc);

	List<Object> dgsxxsmd(String nf, String zymc, String mc);

	List<Object> lyyjbysbl();

	List<Object> lnlyyjbysbl(String mc, String zymc);

	List<Object> lyyjbysmd(String nf, String zymc, String mc);

	TjCount qyjzje();

	List<Object> lnqyjzje();

	List<Object> qyjzjemx(String nf);

	TjCount qyssjzjssl();

	List<Object> lnqyssjzjssl();

	List<Object> qyssjzjsmd(String nf);

	List<Object> qyjsjsqysj();

	List<Object> xqhzyfcg();

	List<Object> getzxsmyddcjg();

	List<Object> getbysgzdcjg();

	TjCount sjbysdll();

	List<Object> lnbysdkl();

	TjCount sjbyszgl();

	List<Object> lnsjbyszgl();

	TjCount sjbyssql();

	List<Object> lnsjbyssql();

	List<Object> getbysbkyy();

	List<Object> yrdwdbysylb();

	List<Object> dsjxmysylb();

	List<Object> zyjnjdjdxsjg();

	List<Object> dsjjybmpsjg();

	List<Object> dsjssjshj();

	List<Object> rmzfbzylb();

	List<Object> jdpxxssl(String zymc);

	TjCount jxjxsglry();

	List<Object> jxjxsglrybt();

	List<Object> jxjxsglrymd(String zymc);

	List<Object> nfzslszsmd(String nf, String mc);

	List<Object> xssydfb();

	List<Object> xzdqxssltbt(String dqmc);

	List<Object> xzdqxsmd(String nf, String dqmc);

	List<Object> getzlbzzdyl();

	List<Object> xxgzzdlb();

	List<TjCount> getxdnfdjflmx(String nf, String lb);

	List<TjCount> getbysjsjksmx(String nf, String zymc);

	List<Object> getzyqdxsmd(String zymc, String mc);

	List<TjCount> getrxqdlist();

	List<Object> lnbysdkjybht(String zymc, String lb);

	List<Object> getbtsdkjymd(String nf,String zymc, String lb );

	List<Object> nfzyqdxsmd(String nf, String zymc, String lb);

	List<TjCount> getgzyjsbltbt(String zymc);

	TjCount sjxnsjgws();

	List<Object> getrjqysjsj(String zymc);

	List<Object> getStuCount2();
	
//     线下课堂分析*******************************************
	//平均成绩同比图
	List<Object> getpjfsList(String zymc,String bjmc,String kcmc);
	//学生成绩明细表
	List<Object> getxsksmx(String zymc,String bjmc,String kcmc,String nf);
	List<Object> getzymc();
	List<Object> getbjmc(String zymc);
	List<Object> getkcmc(String zymc,String bjmc);
	List<Object> getnf();
//	课程考试分数分布图
	List<Object> getkcfsfb(String zymc,String bjmc,String kcmc,String nf);
	//分数范围明细
	List<Object> getfsfwmx(String zymc,String bjmc,String kcmc,String nf,String dg);
	
	//课程迟到/早退/请假人数柱状图
	List<Object> getczqrs(String kcmc);
	List<Object> getsgkcmc();
	//部分迟到/早退/请假人数饼图
	List<Object> getbfczqrs(String kcmc,String nf);
	//部分迟到/早退/请假人明细
	List<Object> getbfczqrsmx(String kcmc,String nf,String lb);
	//开设精品课的专业 
	List<Object> getjpkczymx();
	//精品课程增长柱状图
	List<Object> getjpkzz(String zymc);
	//精品课程明细
	List<Object> getjpkcmx(String zymc,String nf);

	//毕业生资格证书获取明细
	List<TjCount> getbyszgzshqmx(String nf);

}
