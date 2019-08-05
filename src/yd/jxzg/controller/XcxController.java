package yd.jxzg.controller;
import com.alibaba.fastjson.JSON;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.ServletRequest;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import yd.htgl.entity.Permis;
import yd.jxzg.common.TjCount;
import yd.jxzg.entity.BysxzEntity;
import yd.jxzg.entity.JzgEntity;
import yd.jxzg.entity.KcEntity;
import yd.jxzg.entity.StudentEntity;
import yd.jxzg.entity.XxjbqkEntity;
import yd.jxzg.entity.XxmjEntity;
import yd.jxzg.entity.ZgzsEntity;
import yd.jxzg.entity.ZyxxEntity;
import yd.jxzg.service.HxService;
import yd.slgl.entity.UsersEntity;

@Controller
@RequestMapping("xcx")
@CrossOrigin
public class XcxController {
	@Resource
	private HxService xhService;
	
	@RequestMapping(value="index.action", produces = "application/json; charset=utf-8")
	@ResponseBody
	public void index(HttpServletRequest request,HttpServletResponse response){    	
		response.addHeader("location", request.getContextPath()+"/index.html");
		response.setStatus(302);
	}

//	@SuppressWarnings("unchecked")
	@RequestMapping(value="xsgl.action", produces = "application/json; charset=utf-8",method=RequestMethod.POST)
	@ResponseBody
	public String getTest(HttpServletRequest request,HttpServletResponse response, HttpSession session) throws IOException{
		String reg = request.getParameter("reg");
		String zym = request.getParameter("zym");//专业码
		String rxnj = request.getParameter("rxnj");//入学年期
		String bh = request.getParameter("bh");//班号
		String nf = request.getParameter("nf");//年份
		String jdrq = request.getParameter("jdrq");//基地日期
		String kcmc = request.getParameter("kcmc");//课程名称
		String lb = request.getParameter("lb");//类别
		String dqmc = request.getParameter("dqmc");//地区名称
		String zymc = request.getParameter("zymc");//专业名称
		String mc = request.getParameter("mc");//名称
		String aged = request.getParameter("aged");//年龄等级
		String dg = request.getParameter("dg");//等级
		String bjmc=request.getParameter("bjmc");//班级名
		Map<String, Object> map = new HashMap<String ,Object>();
		System.out.println("----------------");
		System.out.println("测试访问的url"+request.getServerName());
		request.getRequestURL();
		System.out.println("测试访问的url"+request.getRequestURL());
		System.out.println("sessionID"+session.getId());
//				System.out.println("测试访问的url"+request.getHeader("Origin"));
//		UsersEntity user=(UsersEntity) session.getAttribute("user");
//		if(user==null){
//		map.put("code", "401");
//		}else{
//		List<Permis> list= new ArrayList<Permis>();
//		list=(List<Permis>) session.getAttribute("permis");
//		System.out.println("++++++++++++"+list);
		if("jbzb".equals(reg)){//基本指标
			//中职学校标准
//			for (Permis permis : list) {
//			System.out.println(permis);
//			if(permis.getRemark().equals("/hxsj")){
//			map.clear();
			List<Object> gjbfb=xhService.getgjbfb();//高级教师比例
			map.put("gjjsbfb", gjbfb);
			Integer totalCountStudent=xhService.getTotalCountStu(null);//在校学生总数
			Integer zrjsCount=xhService.getZrjsCount();//专任教师总数
			Integer stubijs=totalCountStudent/zrjsCount;//师生比
			Map<String, Object> mapjb=xhService.getzyjsbfb();
			map.put("zyjsbfb", mapjb.get("zyjsbfb"));
			Double sbzz=xhService.getsbzz();//设备总值
			Double rjsbzz = sbzz/totalCountStudent;//生均设备总值			
			map.put("zrjsCount",zrjsCount );//专任教师总数
			map.put("rjsbzz", rjsbzz);//生均设备值			
			map.put("totalCountStudent", totalCountStudent);
			map.put("ssb", "1:"+stubijs);//师生比
			Double xsjzmj=xhService.getxsjzmj();//校舍建筑面积
			map.put("xsjzmj", xsjzmj);
			//校外实训基地数
			Integer xwsxjd = xhService.getxwjd();
			map.put("xwsxjd", xwsxjd);//校外实训基地数		
			Double xxzdmj = xhService.getxxzdmj();//学校占地面积
			map.put("xxzdmj", xxzdmj);
			Double sjydmj = xxzdmj/(totalCountStudent+zrjsCount);//生均占地面积
			map.put("sjydmj", sjydmj);
			Double sjxsmj=xsjzmj/(totalCountStudent+zrjsCount);//生均校舍面积
			map.put("sjxsmj", sjxsmj);
			TjCount doublejsbl=xhService.getdoublejsbfb();//双师型教师比例
			map.put("doublejsbl", doublejsbl);
			Double tyydmj=xhService.getyydmj();//体育用地面积
			map.put("tyydmj", tyydmj);
			Integer sjzzts=xhService.getSjzzts();//生均纸质图书
			map.put("sjzzts", sjzzts);
			Integer sjjsjsl=xhService.getjsjsjyysl();//生均计算机拥有数量
			map.put("sjjsjsl", sjjsjsl);
			Integer xnsxgws=xhService.getxnsxgws();//校内实训工位数
			map.put("xnsxgws", xnsxgws);
			TjCount qklxsl=xhService.getqklxsl();//报刊类型数量
			map.put("qklxsl", qklxsl);
			TjCount jsylszws=xhService.getjzgylszw();//教职工阅览室座位数
			map.put("jsylszws", jsylszws);
			TjCount xslszws=xhService.getxsylszw();//学生阅览室座位数
			map.put("xslszws", xslszws);
//			}
//			else{
//				map.put("code","403");
//			}
//			}
		}if("jzgylstbt".equals(reg)){//教职工阅览室座位数同比图
			List<Object> jzgyls=xhService.getjzgyls();
			map.put("dataCount", jzgyls);
			map.put("title", "教职工阅览室座位数同比图");
			map.put("param1", "nf213");
		}if("xsylstbt".equals(reg)){//学生阅览室座位数同比图
			List<Object> xsyls=xhService.getxsyls();
			map.put("dataCount", xsyls);
			map.put("title", "学生阅览室座位数同比图");
			map.put("param1", "nf214");
		}if("bkzltbt".equals(reg)){//学校报刊种类同比图
			List<Object> bkzltbt=xhService.bktbt();
			map.put("dataCount", bkzltbt);
			map.put("title", "学校报刊种类同比图");
		}if("gzyssxjsbl".equals(reg)){//各专业双师型教师比例
			List<Object> gzyssxjsbl=xhService.getgzyssxsjbl();
			map.put("dataCount", gzyssxjsbl);
			map.put("title", "各专业双师型教师比例");
			map.put("param1", "nf208");
		}if("xdgzyssxjstbt".equals(reg)){//双师型教师比例同比图
			List<Object> xdzyssxjsbl=xhService.getxdzyssxjsbl(zymc);
			map.put("dataCount", xdzyssxjsbl);
			map.put("title", zymc+"双师型教师比例同比图");
			map.put("param1", "nf209");
		}if("xdssxjsmd".equals(reg)){//选定年份专业双师型教师名单
			List<Object> xdssxjsmd=xhService.getxdssxjsmd(nf,zymc);
			List<TjCount> jszy = xhService.getjszylist();
			map.put("jszy", jszy);
			map.put("dataCount", xdssxjsmd);
			map.put("title", nf+zymc+"双师型教师名单");
			map.put("table", true);
		}if("gzyzrjsb".equals(reg)){//各专业高级职务者比例
			List<Object> gzyzrjsb = xhService.getgzyzrjsb();
			map.put("dataCount", gzyzrjsb);
			map.put("title", "各专业高级职务者比例");
			map.put("param1", "nf206");
		}if("xdgjzwtbt".equals(reg)){//选定专业的高级职务者数量同比图
			List<Object> gjzwtbt=xhService.getlnxdgjzwsl(zymc);
			map.put("dataCount", gjzwtbt);
			map.put("title", zymc+"高级职务者数量同比图");
			map.put("param", "nf207");
		}if("gjzwmd".equals(reg)){//选定年份专业高级职务者名单
			List<Object> gjzwmd=xhService.getgjzwmd(nf,zymc);
			map.put("dataCount", gjzwmd);
			map.put("title", nf+zymc+"高级职务者名单");
			map.put("table", true);
		}if("gzyzrjsbl".equals(reg)){//各专业教师占专任教师比例
			List<TjCount> gzyjsbl=xhService.getgzyjsbl();
			map.put("dataCount", gzyjsbl);
			map.put("title", "各专业老师占专任老师数量");
			map.put("param", "nf203");
		}if("gzyzrjsbltbt".equals(reg)){//选定专业教师占专任教师比例同比图
			List<TjCount> gzyzrjsbltbt=xhService.getgzyjsbltbt(zymc);
			map.put("dataCount", gzyzrjsbltbt);
			map.put("title", "选定专业教师占专任教师比例同比图");
			map.put("param", "nf681");
		}if("xdzyssbltbt".equals(reg)){//选定专业师生比同比图
			//选定专业师生比同比图
			List<TjCount> xdzyssbltbt=xhService.getxdzyssbtbt(zym);
			map.put("xdzyssbltbt", xdzyssbltbt);
			map.put("title", "选定师生比同比图");
			//选定专业教师数量同比图
			List<TjCount> xdzyjssltbt=xhService.getxdzyjssltbt(zym);
			map.put("xdzyjssltbt", xdzyjssltbt);
			//选中专业学生数量同比图
			List<TjCount> lnzyxssl = xhService.getlnbmxssltb(zym);
			map.put("lnzyxssl", lnzyxssl);
		}if("ydbmxsmd".equals(reg)){//当前年份，当前专业的学生明细
			List<StudentEntity> ydbmxsmd=xhService.getydbmxsmd(zym,nf);
			map.put("ydbmxsmd", ydbmxsmd);
			map.put("table", true);
			map.put("title", "当前专业学生详情");
		}if("xdzynfjsmd".equals(reg)){//选定年和专业教师详情
			List<JzgEntity> jzglist=xhService.getxdzynfjsmd(zym,nf);
			map.put("jzglist", jzglist);
			map.put("table", true);
			map.put("title", zymc+nf+"当前专业教师详情");
		}if("byszgzshqtbt".equals(reg)){//毕业生资格证书获取率同比图
			List<TjCount> byszy=xhService.getbyszy1();
			map=xhService.getbyszgzshqtbt(zymc);
			map.put("byszy", byszy);
		}if("bysjsjkstgltbt".equals(reg)){//毕业生计算机等级考试通过率同比图
			List<TjCount> byszy=xhService.getbyszy1();
			map=xhService.getbysjsjkstgltbt(zymc);
			map.put("byszy", byszy);
		}if("bysjsjksmx".equals(reg)){//毕业生计算机考试通过率明细
			List<TjCount> bysjsjksmx=xhService.getbysjsjksmx(nf,zymc);
			map.put("dataCount", bysjsjksmx);
			map.put("table", true);
			map.put("title", nf+"毕业生计算机考试明细");
		}if("qytgxnsjjxsbtbt".equals(reg)){//企业提供的校内实践教学设备值同比图
			map=xhService.getqytgxnsjjxsbtbt();
		}if("zyjssjtbt".equals(reg)){//教师实践时间同比图
			map=xhService.getzyjssjtbt();
		}if("xljyzxssltbt".equals(reg)){//学历教育在校生数量同比图
			List<TjCount> zyxstbt=xhService.getzyxstbt();//在校生数量同比图
			map.put("zyxstbt", zyxstbt);
		}if("nzfqyjzjstbt".equals(reg)){//年支付企业兼职教师薪酬同比图
			map=xhService.getnzfqyjzjstbt();
		}if("jzjskcmd".equals(reg)){//年支付兼职教师课酬清单
			List<TjCount> jszylist=xhService.getjszylist();
			List<Object> jzjskc=xhService.getjzjskc(nf,zymc);
			map.put("jszylist", jszylist);
			map.put("jzjskc", jzjskc);
			map.put("table", true);
			map.put("title", nf+"年支付兼职教师课酬清单");
		}if("jsqysjmd".equals(reg)){//教职工企业实践名单
			List<Object> qysjmd=xhService.getjzgqysj(nf,zymc);
			map.put("qysjmd", qysjmd);
			List<TjCount> jszylist=xhService.getjszylist();
			map.put("jszylist", jszylist);
			map.put("table", true);
			map.put("title", nf+zymc+"教师企业实践名单");
		}if("xwsxjdsxsjtbt".equals(reg)){//年生均校外实训 基地实习时间同比图
			map=xhService.getxwsxjdsxsjtbt();
		}if("gzyssb".equals(reg)){//各专业师生同比图
			map=xhService.getgzyssb();
		}if("xznfxwsxjh".equals(reg)){
			map=xhService.getxznfxwsxjh(nf);
		}if("sbtbt".equals(reg)){//设备同比图
			List<TjCount> zsbtbt=xhService.getzsbtbt();
			map.put("zsbtbt", zsbtbt);
		}if("zyzsxsl".equals(reg)){
			List<TjCount> zyxstbt=xhService.getzyxstbt();//在校生数量同比图
			map = xhService.getStuCount(reg,zym,rxnj,bh);//各专业在校生数量
			map.put("zyxstbt", zyxstbt);
		}if("zynjsl".equals(reg)){//选定年级班级学生数量 
			map = xhService.getStuCount(reg,zym,rxnj,bh);
		}if("xdzyxssl".equals(reg)){//选定专业的各年级学生数量
			map = xhService.getStuCount(reg,zym,rxnj,bh);
		}if("xdbjmd".equals(reg)){//选定班级学生明细
			map = xhService.getStuCount(reg,zym,rxnj,bh);
		}if("gjgslbt".equals(reg)){//管、技、工数量饼图
			map = xhService.getGjgslbt();
		}if("ggxz".equals(reg)){//管、工教师信息
			map=xhService.getggxzmc();
			//各专业的专任教师数量饼图
			List<Object> gzyzrjssl=xhService.getgzyzrjssl();
			map.put("gzyzrjssl", gzyzrjssl);
		}if("xzzyjsmd".equals(reg)){//选中专业教师详情
			List<JzgEntity> jzglist=xhService.getxdzynfjsmd(zym,null);
			map.put("dataCount", jzglist);
			map.put("table", true);
			map.put("title", "当前专业教师详情");
		}if("xsyqsbtb".equals(reg)){//学校仪器设备同比图
			map = xhService.getxsyqsbtb();
		}if("xnsxgwstb".equals(reg)){//培训工位数同比图
			map=xhService.getxnsxgwstb();
		}if("ssxjstbt".equals(reg)){//双师型教师比例同比图
			map=xhService.ssxjstbt();
		}if("xdnfssxjsmd".equals(reg)){//选定年份双师型教师名单
			map=xhService.getxdnfssxjsmd(nf,zym);
		}if("xwjdtb".equals(reg)){//校外实习实训基地数量同比图
			map = xhService.getxwjdtb();
		}if("jdsxqd".equals(reg)){//选择年份校外实习基地清单
			map=xhService.getjdsxqd(nf);
		}if("zztstbt".equals(reg)){//纸质图书同比图
			//纸质图书同比图
			List<TjCount> zztstbt=xhService.getzztstbt();
			map.put("zztstbt", zztstbt);
		}if("xnsxgwstbt".equals(reg)){//校内实训工位数同比图
			map = xhService.getxnsxgwstb();		
		}if("zznlpg".equals(reg)){
			//中职能力评估
//			for (Permis permis : list) {
//			System.out.println("----------"+permis.getRemark());
//			if(permis.getRemark().equals("/nlpg")){
//			map.clear();
			//接入互联网出口带宽
			TjCount flwdk = xhService.flwdk();
			map.put("flwdk", flwdk);
			//上网课程总量
			TjCount swkc=xhService.getswkc();
			map.put("swkczs", swkc);
			//上网课程同比图
			List<TjCount> swkctbt=xhService.getswkctbt1();
			map.put("swkctbt", swkctbt);
			List<KcEntity> kcList = xhService.getkcList(nf,zym);//课程列表
			map.put("kcList", kcList);
			TjCount sjxwsxsj=xhService.getsjxwsxsj();//生均校外实训基地使用实间
			map.put("sjxwsxsj", sjxwsxsj);
			TjCount qyddpy = xhService.getqyddpyxs();//企业订单培养
			map.put("qyddpy", qyddpy);
			TjCount nzfqyjzjskc=xhService.getqyzfjzkc();//企业支付兼职教师课酬
			map.put("nzfqyjzjskc", nzfqyjzjskc);
			TjCount nzrzyjssjsj=xhService.getnzrzyjssjsj();//教师实践时间
			map.put("nzrzyjssjsj", nzrzyjssjsj);
			TjCount qytgxnsjjxsbz=xhService.getqytgxnsjjusbz();//企业提供的校内实践教学设备值
			map.put("qytgxnsjjxsbz", qytgxnsjjxsbz);	
			List<TjCount> bysjsjkstgl=xhService.getbysjsjkstgl();//毕业生计算机等级考试通过率
			map.put("bysjsjkstgl", bysjsjkstgl);
			TjCount byszyzgzshql=xhService.getbyszyzgzshql();//毕业生职业资格证书获取率
			map.put("byszyzgzshql", byszyzgzshql);
			TjCount nsjczbk=xhService.getsjczbk();//年生均财政拨款
			map.put("nsjczbk", nsjczbk);
			TjCount rjsbzz = xhService.getsjsbz();//生均设备值
			map.put("rjsbzz", rjsbzz);
			TjCount sjjxyfmj=xhService.getsjjxyfmj();//生均教学及辅助用房面积
			map.put("sjjxyfmj", sjjxyfmj);
			TjCount xzbgyfmj=xhService.getxzbgyfmj();//生均行政办公用房面积
			map.put("xzbgyfmj", xzbgyfmj);
			TjCount sjjsjyysl= xhService.getmbmjsjstbt1();//每一百学生有多少台计算机
			map.put("sjjsjyysl", sjjsjyysl);
			TjCount doublejsbl=xhService.getdoublejsbfb();//双师型教师比例
			map.put("doublejsbl", doublejsbl);
			TjCount wldmtjssl=xhService.getwldmtjssl();//网络多媒体教室数量	
			map.put("wldmtjssl", wldmtjssl);
			TjCount stubijs=xhService.getssbl();//师生比
			map.put("stubijs", stubijs);
			TjCount zjjyl = xhService.getzjjyl();//直接就业率
			map.put("zjjyl", zjjyl);
			List<TjCount> gzyxsslbt = xhService.getgzyxsslbt();//各专业在校学生数量
			map.put("gzyxsslbt", gzyxsslbt);
			List<TjCount> bxxy=xhService.getbxxy();//办学效益
			map.put("bxxy", bxxy);
			//三年巩固率
			TjCount snggl=xhService.getsnggl();
			map.put("snggl", snggl);
			//生均校内实践工位数
			TjCount sjxnsjgws=xhService.sjxnsjgws();
			map.put("sjxnsjgws", sjxnsjgws);
//				}
//				else{
//					map.put("code","403");
//				}
//			}
		}if("snggltbt".equals(reg)){//三年巩固率同比图
			List<TjCount> getstuzy = xhService.getstuzy();
			List<Object> snggltbt=xhService.getsnggltbt(zymc);
			map.put("dataCount", snggltbt);
			map.put("getstuzy", getstuzy);
			map.put("title","三年巩固率同比图");
			map.put("param1", "nf223");
		}if("lsxsmx".equals(reg)){//选中流失学生明细
			List<TjCount> getstuzy = xhService.getstuzy();
			List<Object> lsxsmx=xhService.getlsxsmx(nf,zymc);
			map.put("dataCount", lsxsmx);
			map.put("getstuzy", getstuzy);
			map.put("title",nf+zymc+ "流失学生明细");
			map.put("table", true);
		}if("sjxwjssysj".equals(reg)){//生均校外基地使用时间同比图
			List<Object> sjxwjdsysj=xhService.getsjxwjssysj();
			map.put("dataCount", sjxwjdsysj);
			map.put("title", "生均校外基地使用时间同比图");
			map.put("param1", "nf218");
		}if("xwjdjhmx".equals(reg)){//年校外基地实习计划表
			List<Object> xwjdmx=xhService.getxwjdjhb(nf);
			map.put("dataCount", xwjdmx);
			map.put("title", nf+"校外实训基地实习计划表");
			map.put("param1", "nf219");		
		}if("sjjxfzyftbt".equals(reg)){//生均教学辅助用房面积同比图
			List<Object> sjjxfzyftbt=xhService.getsjjxfzyf();
			map.put("dataCount", sjjxfzyftbt);
			map.put("title", "生均教学辅助用房面积同比图");
			map.put("param1", "nf216");
		}if("qytgsbmx".equals(reg)){//企业提供实训设备明细
			List<Object> qysbmx=xhService.getqytgsxsbmx(nf);
			map.put("dataCount", qysbmx);
			map.put("title", nf+"企业提供实训设备明细");
			map.put("table", true);
		}if("xdxzjxyfqd".equals(reg)){//年新增教学辅助用房面积清单
			List<TjCount> xzjxfzyf=xhService.getxzjxfzyf(nf);
			map.put("dataCount", xzjxfzyf);
			map.put("title", nf+"年新增教学辅助用房面积清单");
			map.put("table", true);
		}if("sjczbktbt".equals(reg)){//年均财政拨款同比图
			List<TjCount> sjczbktbt=xhService.getsjczbktbt();
			map.put("dataCount", sjczbktbt);
			map.put("title", "年生均财政拨款同比图(元)");
			map.put("param1", "nf35");
		}if("bkflbt".equals(reg)){//年生均财政拨款分类饼图
			List<Object> bkflbt=xhService.getbkflbt(nf);
			map.put("dataCount", bkflbt);
			map.put("title", "年生均财政拨款分类饼图");
			map.put("type", "bt");
			map.put("param1", "nf215");
		}if("bkflmx".equals(reg)){//年财政拨款明细
			List<Object> bkflmx=xhService.getbkflmx(nf,mc);
			map.put("dataCount", bkflmx);
			map.put("title", nf+mc+"年财政拨款明细");
			map.put("table",true);
		}if("xdzyjssltbt".equals(reg)){//在校学生同比图（分专业）
			map=xhService.getgzyzxssltbt(zym);
		}if("xdnfjysmx".equals(reg)){//选定年就业生明细
			map=xhService.getjysmx(nf);
		}if("zjjyltbt".equals(reg)){//直接就业率同比图
			map=xhService.getzjjyltbt();
		}if("xznfzgzsmx".equals(reg)){//选择年份学生资格证书明细
			map=xhService.getxznfzgzsmx(nf,zymc);
		}if("jxfzyftbt".equals(reg)){//教学及辅助用房面积同比图
			map = xhService.getjxfzyftbt();
		}if("xzbgyfmjtbt".equals(reg)){//生均行政办公用房面积同比图
			map=xhService.getxzbgyfmjtbt();
		}if("xzxzbgqd".equals(reg)){//新增新增办公用房面积清单
			List<Object> xzxzbgqd=xhService.getxzxzbgqd(nf);
			map.put("dataCount", xzxzbgqd);
			map.put("title", nf+"年新增行政办公用房清单");
			map.put("table",true);
		}if("ssbtbt".equals(reg)){//生师比同比图
			map=xhService.getssbtbt();
		}if("mbmxsjsjstbt".equals(reg)){//每百名学生拥有计算机数量同比他
			map=xhService.getmbmjsjstbt();
		}if("jsjcg".equals(reg)){//教学用计算机采购清单
			List<Object> xzjsjqd=xhService.getxzjsjqd(nf);
			map.put("dataCount", xzjsjqd);
			map.put("title", nf+"年新增行政办公用房清单");
			map.put("table",true);
		}if("jsjcjmx".equals(reg)){//毕业生计算机考试成绩
			List<TjCount> byszylist=xhService.getbyszy1();
			List<Object> bysks=xhService.getbysjsjkstgmd(nf,zymc);
			map.put("dataCount", bysks);
			map.put("byslist", byszylist);
			map.put("title", nf+zymc+"毕业生计算机考试成绩");
			map.put("table",true);
		}if("wldmtjstbt".equals(reg)){//同比图网络多媒体教室
			map=xhService.getwldmtjstbt();
		}if("wldmtjs".equals(reg)){//选中年网络多媒体建设明细
			List<TjCount> wldmtjs=xhService.getwldmtjsmx(nf);
			map.put("dataCount", wldmtjs);
			map.put("title", nf+"年网络多媒体建设明细");
			map.put("table",true);
		}if("zxsandjstbt".equals(reg)){//在校生和教师数量同比图
			List<TjCount> zyxstbt=xhService.getzyxstbt();//在校生数量同比图
			List<TjCount> jssltbt =xhService.getjssltbt();
			map.put("zyxstbt", zyxstbt);
			map.put("jssltbt", jssltbt);
		}if("xdxnxdzyxsmd".equals(reg)){//选定学年和专业学生明细
			map=xhService.getxdxnxdzyxsmd(nf,zym);
		}if("gwsmx".equals(reg)){//教学工位数明细
			List<TjCount> jsgwxq=xhService.getjxgwxq(nf);
			map.put("dataCount", jsgwxq);
			map.put("title", nf+"教学工位数明细");
			map.put("table",true);
		}if("xxjxx".equals(reg)){
			//各建筑面积
			List<XxmjEntity> xxgjzmj = xhService.getXxgjzmj();
			map.put("xxgjzmj", xxgjzmj);
			List<TjCount> jssltbt =xhService.getjgsltbt();//教师数量同比图
			map.put("jssltbt", jssltbt);
			//在校生总数量同比图
			List<TjCount> zxszstbt = xhService.getzxstb();
			map.put("zxszstbt", zxszstbt);
			//学校专业数同比图
			List<TjCount> xxzystbt=xhService.getxxzystbt1();
			map.put("xxzystbt", xxzystbt);
			//当年新增设备同比图
			List<TjCount> xzsbtbt=xhService.getxzsbtbt();		
			map.put("xzsbtbt", xzsbtbt);
			//总设备同比图
			List<TjCount> zsbtbt=xhService.getzsbtbt();
			map.put("zsbtbt", zsbtbt);
		}if("zyzb".equals(reg)){
			//高级教师比例
			List<Object> gjbfb=xhService.getgjbfb();
			map = xhService.getzyjsbfb();
			map.put("gjbfb", gjbfb);
			Double sjzdmj = xhService.getsjzdmj();//生均占地面积
			map.put("sjzdmj", sjzdmj);
			Double xsjzmj=xhService.getxsjzmj();//校舍总面积
			map.put("xsjzmj", xsjzmj);
			Double sjxsmj=xhService.sjxsmj();//生均校舍面积
			map.put("sjxsmj", sjxsmj);
			Double tyydmj = xhService.gettxydmj();//体育用地面积
			map.put("tyydmj", tyydmj);
			Integer sjzztu = xhService.getSjzzts();//生均纸质图书
			map.put("sjzztu", sjzztu);
			Double sjyqsbz=xhService.getsjyqsbz();//生均仪器设备
			map.put("sjyqsbz", sjyqsbz);
			Integer jsjsjyysl=xhService.getjsjsjyysl();//生均计算机
			map.put("jsjsjyysl", jsjsjyysl);
		}if("sjydtbt".equals(reg)){//生均用地同比图
			map = xhService.getsjydtbt();
		}if("xznfxsmx".equals(reg)){//选定学年在校生明细
			map = xhService.getxznfxsmx(nf);
		}if("sjxsmjtbt".equals(reg)){//生均校舍面积同比图
			map = xhService.getsjxsmjtbt();
		}if("xxzztstbt".equals(reg)){//学校纸质图书同比图
			map=xhService.zztstbt();
		}if("jsjtbt".equals(reg)){//计算机同比图
			map=xhService.getjsjtbt();
		}if("xxjbxx".equals(reg)){
			//学校基本信息
//			for (Permis permis : list) {
//				System.out.println(permis);
//				if(permis.getRemark().equals("/school")){
//				map.clear();
			//高级教师比例
			List<Object> gjbfb=xhService.getgjbfb();
			map.put("gjbfb", gjbfb);
			List<TjCount> gzyxsslbt = xhService.getgzyxsslbt();//各专业在校学生数量
			map.put("gzyxsslbt", gzyxsslbt);
			//各建筑面积
			List<XxmjEntity> xxgjzmj = xhService.getXxgjzmj();
			map.put("xxgjzmj", xxgjzmj);
			//教工同比图
			List<TjCount> jssltbt = xhService.getjssltbt();
			map.put("jssltbt", jssltbt);
			//在校生数量同比图
			List<TjCount> zxssltbt = xhService.getzxsxstbt();
			map.put("zxssltbt", zxssltbt);
			//学校专业数同比图
			List<TjCount> xxzystbt=xhService.getxxzystbt();
			map.put("xxzystbt", xxzystbt);
			//课程数量
			TjCount ggkcsl=xhService.getggkcsl();
			TjCount zykcsl=xhService.getzykcsl();
			map.put("ggkc", ggkcsl);
			map.put("zykc", zykcsl);
			//总设备同比变化图
			List<TjCount> zsbtbt=xhService.getzsbtbt();
			map.put("zsbtbt", zsbtbt);
			//绿化面积非绿化面积
			List<TjCount> lhmjf=xhService.getlhflmj();		
			map.put("lhmjf", lhmjf);
			//校舍产权面积
			List<TjCount> xscfqmj=xhService.getxscfqmj();
			map.put("xscfqmj", xscfqmj);
			//教学辅助用房总面积
			TjCount fzyfmj=xhService.getfzyfmj();
			map.put("fzyfmj", fzyfmj);
			//生活用房面积
			TjCount shyfmj = xhService.getshyfmj();
			map.put("shyfmj", shyfmj);
			//行政办公用房面积
			TjCount xzbgyfmj = xhService.getxzbgyf();
			map.put("xzbgyfmj", xzbgyfmj);
			//教工住宅
			TjCount jgzz = xhService.getjzzz();
			map.put("jgzz", jgzz);
			//上网课程同比图
			List<TjCount> swkctbt=xhService.getswkctbt1();
			map.put("swkctbt", swkctbt);
			//其他面积
			TjCount qtmj = xhService.getqtmj();
			map.put("qtmj", qtmj);
			//图书同比图
			List<TjCount> tstbt=xhService.gettstbt();
			map.put("tstbt", tstbt);
			//期刊同比图
			List<Object> qktbt=xhService.getqktbt();
			map.put("qktbt", qktbt);
			//纸质图书同比图
			List<TjCount> zztstbt=xhService.getzztstbt();
			map.put("zztstbt", zztstbt);
			//电子图书同比图
			List<TjCount> dztstbt=xhService.getdztstbt();
			map.put("dztstbt", dztstbt);
			//生均纸质图书同比图
			List<TjCount> sjzztutbt=xhService.getsjzztstbt();
			map.put("sjzztutbt", sjzztutbt);
			//生均实训工位数同比图
			List<TjCount> sjGWSTBT = xhService.getsjGwstbt();
			map.put("sjsxgwstbt", sjGWSTBT);
			//通用设备同比图
			List<TjCount> tysbtbt=xhService.gettysbtbt();
			map.put("tysbtbt", tysbtbt);
			//专业设备同比图
			List<TjCount> zysbtbt=xhService.getzysbtbt();
			map.put("zysbtbt", zysbtbt);
			//生均教学仪器设备同比图
			List<TjCount> sjsbtbt=xhService.getsjsbtbt();
			map.put("sjsbtbt", sjsbtbt);
			//带宽增长同比图
			List<TjCount> dkzztbt = xhService.getdkzztbt();
			map.put("dkzztbt", dkzztbt);
			//网络信息节点增长同比图
			List<TjCount> wlxxjdzztbt=xhService.getwlxxjdzztbt();
			map.put("wlxxjdzztbt", wlxxjdzztbt);
			//新增设备同比图
			List<TjCount> xzsbtbt=xhService.getxzsbtbt();		
			map.put("xzsbtbt", xzsbtbt);
			//专业变动一览表
			List<Object> zybd=xhService.getzybd();
			map.put("zybd", zybd);
			//持续招生专业一览表
			List<Object> cxzszy=xhService.getcxzszy();
			map.put("cxzszy", cxzszy);
			//全日制专业/培训版变动一览表
			List<Object> qrzpxbbd=xhService.getqrzpxbbd();
			map.put("qrzpxbbd", qrzpxbbd);
			//实训设备使用率变化图（分科室）
			List<Object> sxsbsyl=xhService.getsxsvsyl(mc);
			map.put("sxsbsyl", sxsbsyl);
			//实训科室
			List<TjCount> sxks=xhService.getsxks();
			map.put("sxks", sxks);
	//	}
//		else{
//				map.put("code","403");
//				}
//			}
		}if("jxsbmx".equals(reg)){//选中年教学设备明细
			List<Object> jxsbmx=xhService.getxzsbqd(nf);
			map.put("dataCount", jxsbmx);
			map.put("title",nf+"教学设备明细");
			map.put("table", true);
		}if("tysbmx".equals(reg)){//选中年通用设备明细
			List<Object> tysbmx=xhService.gettysbmx(nf);
			map.put("dataCount", tysbmx);
			map.put("title",nf+"通用设备明细");
			map.put("table", true);
		}if("zysbmx".equals(reg)){//选中年通用设备明细
			List<Object> zysbmx=xhService.getzysbmx(nf);
			map.put("dataCount", zysbmx);
			map.put("title",nf+"专业设备明细");
			map.put("table", true);
		}if("dztslxsl".equals(reg)){//选中年电子各类电子图书数量
			List<Object> dztslxsl=xhService.getdztslxsl(nf);
			map.put("dataCount", dztslxsl);
			map.put("title",nf+"各类电子图书数量");
			map.put("table", true);
		}if("tsflxsl".equals(reg)){//图书分类数量
			List<Object> tsflsl=xhService.gettslxsl(nf);
			map.put("dataCount", tsflsl);
			map.put("title",nf+"各类图书数量");
			map.put("table", true);
		}if("qkflsl".equals(reg)){//选中年各类期刊数量
			List<Object> qkflsl=xhService.getqkflsl(nf);
			map.put("dataCount", qkflsl);
			map.put("title",nf+"期刊分类数量");
			map.put("table", true);
		}if("jzzzqd".equals(reg)){//教职工住宅面积清单
			List<Object> jzgzzmj=xhService.jzgzzqd();
			map.put("dataCount", jzgzzmj);
			map.put("title","教职工住宅面积清单");
			map.put("table", true);
		}if("qtyfmjqd".equals(reg)){//其它区域面积清单
			List<Object> qtyfmjqd=xhService.getqtyfmjqd();
			map.put("dataCount", qtyfmjqd);
			map.put("title", "其它区域面积清单");
			map.put("table", true);
		}if("sxkssyqd".equals(reg)){//选中科室设备使用清单
			List<Object> sxssbsyqd=xhService.getsxssbsyqd(nf,mc);
			map.put("dataCount", sxssbsyqd);
			map.put("title", nf+mc+"设备使用清单");
			map.put("table", true);
		}if("ggkcqd".equals(reg)){//公共课程清单
			List<KcEntity> ggkcqd=xhService.getggkcqd();		
			map.put("dataCount", ggkcqd);
			map.put("title", "公共课程清单");
			map.put("table", true);
		}if("zykcqd".equals(reg)){//专业课程清单
			List<KcEntity> zykcqd=xhService.getzykcqd();		
			map.put("dataCount", zykcqd);
			map.put("title", "专业课程清单");
			map.put("table", true);
		}if("xxbxjf".equals(reg)){//学校办学经费
//			    for (Permis permis : list) {
//				System.out.println(permis);
//				if(permis.getRemark().equals("/bxjf")){
//				map.clear();
	    	   //办学总经费同比变化图
				List<TjCount> bxzjf=xhService.getbxzjf();
				map.put("bxzjf", bxzjf);
	    	   //生均经费同比变化图
				List<TjCount> sjjftbt=xhService.getsjjftbt();
				map.put("sjjftbt", sjjftbt);
				//专项经费同比变化图
				List<TjCount> zyjftbt=xhService.getzyjftbt();
				map.put("zyjftbt", zyjftbt);
				//经费开支分类堆积柱状图
				List<Object> jfkzdjt=xhService.getjfkzdjt();
				map.put("jfkzdjt", jfkzdjt);
				//教学设备投入金额同比变化图
				List<TjCount> jxtrjetbt=xhService.getjxtrjetbt();
				map.put("jxtrjetbt", jxtrjetbt);
				//专项经费支出分类饼图
				List<TjCount> bxjfzcflbt = xhService.getbxjfzcbt();
				map.put("bxjfzcflbt", bxjfzcflbt);
//				}
//				else{
//					map.put("code","403");
//				}
//			}
	     }if("xzfljfkzmx".equals(reg)){//选中年份类别经费开支明细
			List<TjCount> xzfljfkzmx=xhService.getxdnfdjflmx(nf,lb);
			map.put("dataCount", xzfljfkzmx);
			map.put("title", nf+"年中分类经费开支明细表");
			map.put("param1", "nf42");
			map.put("table", true);
		}if("xdnfdjflbt".equals(reg)){//选中年份经费开支分类饼图
			List<TjCount> xdnfdjflbt=xhService.getxdnfdjflbt(nf);
			map.put("dataCount", xdnfdjflbt);
			map.put("title", nf+"年份经费开支分类饼图");
			map.put("type", "bt");
			map.put("param1", "nf42");
		}if("xznzyjfmx".equals(reg)){//年专项经费明细
			List<TjCount> xdnzyjfmx=xhService.getxdnzyjfmx(nf);
			map.put("dataCount", xdnzyjfmx);
			map.put("title", nf+"年专项经费明细");
			map.put("table", true);
		}if("xdnfjfly".equals(reg)){//经费来源饼图
			List<TjCount> jfly=xhService.getjfly(nf);
			map.put("dataCount", jfly);
			map.put("title", nf+"年经费来源");
			map.put("type", "bt");
		}if("xznfwlxxjdfb".equals(reg)){//选择年份网络节点分布图或表
			List<TjCount> xznfwlxxjdfb=xhService.getxznfwlxxjdfb(nf);
			map.put("dataCount", xznfwlxxjdfb);
			map.put("title", "选中年份网络节点分布图或表");
			map.put("table", true);
		}if("xzndkcqmx".equals(reg)){//选择年的宽带出口明细表
			List<XxjbqkEntity> xzndkcqmx=xhService.getxznfdkckmx(nf);
			map.put("dataCount", xzndkcqmx);
			map.put("table", true);
			map.put("title", nf+"年的宽带出口明细表");
		}if("gjxfzyfmjqd".equals(reg)){//各辅助用房面积
			map=xhService.getgjxfzyfmjqd();
		}if("xznfsbcg".equals(reg)){//年新增设备清单
			List<Object> xzsbqd=xhService.getxzsbqd(nf);
			map.put("dataCount", xzsbqd);
			map.put("title", nf+"年新增设备清单");
			map.put("table", true);
		}if("sjsbtbt".equals(reg)){//生均设备同比图	
			List<TjCount> sjsbtbt=xhService.getsjsbtbt();
			map.put("dataCount", sjsbtbt);
			map.put("title","生均教学仪器设备值同比图");
			map.put("param","nf22");
		}if("gshyfmjqd".equals(reg)){//各生活用房
			map=xhService.getgshyfmjqd();
		}if("xdnfzyqd".equals(reg)){//选定年份专业清单
			map=xhService.getxdnfzyqd(nf);
		}if("kcqd".equals(reg)){//选定年份的课程清单
			map=xhService.getkcqd(nf);
		}if("dktbt".equals(reg)){//接入互联网出口带宽同比图
			map=xhService.getdktbt();
		}if("xznfflwbt".equals(reg)){//选定年份互联网出口宽带组成饼图
			map=xhService.getflwzc(nf);
		}if("swkctbt".equals(reg)){//上网课程总量同比图
			map=xhService.getswkctbt();
			map.put("title", "各年课程总量同比图");
			map.put("param1", "nf4");
		}if("sjxnsjgwstbt".equals(reg)){//生均实践工位数同比图
			map=xhService.getsjxnsjgwstbt();
		}if("xxzyts".equals(reg)){//学校专业特色
//			 for (Permis permis : list) {
//					System.out.println(permis);
//					if(permis.getRemark().equals("/zyts")){
//					map.clear();
	    	 //国家示范专业数量同比图
	    	 List<Object> gjsfzysltbt=xhService.getgjsfzysltbt();
	    	 map.put("gjsfzysltbt", gjsfzysltbt);
	    	 //省重点专业同比图
	    	 List<Object> szdzysltbt=xhService.szdzysltbt();
	    	 map.put("szdzysltbt", szdzysltbt);
	    	 //市品牌专业数量同比图
	    	 List<Object> sppzysltbt=xhService.sppzysltbt();
	    	 map.put("sppzysltbt", sppzysltbt);
	    	 //其他特色专业数量同比图
	    	 List<Object> qttszytbt=xhService.getqttszytbt();
	    	 map.put("qttszytbt", qttszytbt);
//					}
//					else{
//						map.put("code","403");
//					}
//				}
	     }if("xznfqtzymd".equals(reg)){//选中年份其他特色专业名单
	    	 List<ZyxxEntity> xzszymd=xhService.getxznfqtzymd(nf);
	    	 map.put("dataCount", xzszymd);
	    	 map.put("title", nf+"年其他特色专业名单");
	    	 map.put("table", true);
	     }if("xzszymd".equals(reg)){//选中年份市品牌专业名单
	    	 List<ZyxxEntity> xzszymd=xhService.getxzszymd(nf);
	    	 map.put("dataCount", xzszymd);
	    	 map.put("title", nf+"年市品牌专业名单");
	    	 map.put("table", true);
	     }if("xzszdzymd".equals(reg)){//选中省重点专业名单
	    	 List<ZyxxEntity> xzszdzymd=xhService.getxzszdzymd(nf);
	    	 map.put("dataCount", xzszdzymd);
	    	 map.put("title", nf+"年省重点专业名单");
	    	 map.put("table", true);
	     }if("xzsfzymd".equals(reg)){//选中国家示范专业名单
	    	 List<ZyxxEntity> zyListByNf=xhService.getsfzylist(nf);
	    	 map.put("dataCount", zyListByNf);
	    	 map.put("title", nf+"年国家示范专业名单");
	    	 map.put("table", true);
	     }if("xznfssxjs".equals(reg)){//选中年份专业双师型教师名单
	    	 map=xhService.getxdnfssxjsmd(nf,zym);
	     }if("ssxjstbtzy".equals(reg)){//按专业双师型教师同比图
	    	 List<TjCount> ssxjstbtzy = xhService.getssxjstbtzy(zym);
	    	 List<TjCount> zylist=xhService.getzylist();
	    	 map.put("dataCount", ssxjstbtzy);
	    	 map.put("param1", "nf50");
	    	 map.put("zylist", zylist);
	     }if("xxszdw".equals(reg)){//师资队伍
//	    	 for (Permis permis : list) {
//					System.out.println(permis);
//					if(permis.getRemark().equals("/szdw")){
//					map.clear();
	    	//各专业
	    	 List<TjCount> zylist=xhService.getjszylist();
	    	 map.put("zylist", zylist);
	    	//教师数量同比变化图
	    	 List<Object> jssltbdjt = xhService.getjssltbdjt(zymc);
	    	 map.put("jssltbdjt", jssltbdjt);
	        //专业教师占专任教师比例
	    	 List<Object> zyjsbl = xhService.getzyjsbl2(zymc);
	    	 map.put("zyjsbl", zyjsbl);
	    	//按专业双师型教师同比图
	    	 List<Object> ssxjstbtzy = xhService.getssxjstbtzy1(zym);
	    	 map.put("ssxjstbtzy", ssxjstbtzy);
//					}
//					else{
//						map.put("code","403");
//					}
//				}
		 }if("jssltbdjt".equals(reg)){//教师数量同比变化图
	    	 List<Object> jssltbdjt = xhService.getjssltbdjt(zym);
	    	 map.put("jssltbdjt", jssltbdjt);
	    	 //各专业
	    	 List<TjCount> zylist=xhService.getzylist();
	    	 map.put("zylist", zylist);
	    	 map.put("type", "djt");
	    	 map.put("param1", "nf55");
	     }if("zyjsbl".equals(reg)){
	    	 //专业教师占专任教师比例
	    	 List<TjCount> zyjsbl=xhService.getzyjsbl();
	    	 List<TjCount> zylist=xhService.getzylist();
	    	 map.put("zylist", zylist);
	    	 map.put("param1", "nf1bl");
	    	 map.put("dataCount", zyjsbl);
	    	 
	     }if("xznfzyjsmd".equals(reg)){//选中年份专业的专业教师名单
	    	 List<JzgEntity> jzgList=xhService.getxdzynfjsmd(zymc, nf);
	    	 map.put("title",nf+"年该专业教师名单");
	    	 map.put("dataCount", jzgList);
	    	 map.put("table", true);
	     }if("xznfzjzjs".equals(reg)){//选中年份的专业专兼职教师名单
	    	 List<JzgEntity> xznfzjzjs=xhService.getxznfzjzjs(nf,zym);
			 map.put("dataCount", xznfzjzjs);
			 map.put("title",nf+"年中专业的专兼职教师名单");
			 map.put("table", true);
	     }if("xxkcgk".equals(reg)){//学校课程概况
//	    	 for (Permis permis : list) {
//					System.out.println(permis);
//					if(permis.getRemark().equals("/kcgk")){
//					map.clear();
	    	 //课程清单按年级和专业
	    	 List<Object> kcList=xhService.getkcList1(nf, zym);
	    	 map.put("kcList", kcList);
	    	 //精品课程同比图
	    	 List<Object> jpkctbt=xhService.getjpkctbt();
	    	 map.put("jpkctbt", jpkctbt);
	    	 //新增课程同比图
	    	 List<Object> xzttkc = xhService.getxztxkctbt();
	    	 map.put("xzttkc", xzttkc);
	    	 //在线教学课程同比图
	    	 List<Object> zxkctbt = xhService.getzxkctbt();
	    	 map.put("zxkctbt", zxkctbt);
//					}
//					else{
//						map.put("code","403");
//					}
//				}
	     }if("nfzxkcqd".equals(reg)){//选定年份在线课程清单
	    	 List<KcEntity> kclist=xhService.getnfzxkcqd(nf);
	    	 map.put("dataCount", kclist);
	    	 map.put("table", true);
	    	 map.put("title", nf+"年在线教学课程清单");
	     }if("xzttkcqd".equals(reg)){//新增淘汰课程清单
	    	 List<KcEntity> kclist=xhService.getxzttkclist(nf);
	    	 map.put("dataCount", kclist);
	    	 map.put("table", true);
	    	 map.put("title", nf+"年新增/淘汰课程清单");
	     }if("xznfjpmx".equals(reg)){//选中年份精品课程清单
	    	 List<KcEntity> jpkcqd=xhService.getjpkcqd(nf);
	    	 map.put("dataCount", jpkcqd); 
	    	 map.put("title", nf+"年精品课程清单");
	    	 map.put("table", true);
	     }if("xxxsgz".equals(reg)){
//	    	 for (Permis permis : list) {
//					System.out.println(permis);
//					if(permis.getRemark().equals("/xsgz")){
//					map.clear();
	    	//学生数量同比变化图
	    	 List<Object> stsltbt=xhService.getxssltbtcx(lb,nf,zym,dqmc);
	    	 //培养层次
	    	 List<TjCount> pycc=xhService.pycc();
	    	 //学生专业
	    	 List<TjCount> stuzy=xhService.getstuzy(); 
	    	//学生年级
	    	 List<TjCount> stunj=xhService.stunj();
	    	 map.put("stunj", stunj);
	    	//地区
	    	 List<TjCount> dqlist=xhService.dqlist();
	    	 map.put("dqlist", dqlist);
	    	 map.put("stuzy", stuzy);
	    	 map.put("pycc", pycc);
	    	 map.put("stsltbt", stsltbt);
	    	 //招生人数同比图
	    	 List<Object> lnzsrs=xhService.getlnzsrstbt(zym);
	    	 map.put("lnzsrs", lnzsrs);
	    	 //学生体质合格率同比图
	    	 List<Object> stujkzs=xhService.getstujkzs(lb,nf,zym,dqmc);
	    	 map.put("stujkzs", stujkzs);
	    	 //就业率同比图
	    	 List<Object> jyltbt=xhService.getjyltbt();
	    	 map.put("jyltbt", jyltbt);
	    	 //合作企业同比图
	    	 List<Object> hzqytbt=xhService.gethzqytbt(zymc);
	    	 map.put("hzqytbt", hzqytbt);
//					}
//					else{
//						map.put("code","403");
//					}
//				}
	     }if("xdqynjymd".equals(reg)){//历年企业就业名单
	    	 List<TjCount> xzqyjymd=xhService.getxzqyjymd(mc,nf);
	    	 map.put("dataCount", xzqyjymd);
	    	 map.put("title", nf+"年"+"mc"+"就业学生名单");
	    	 map.put("table", true);
	     }if("xzqyjytbt".equals(reg)){//选中企业历年就业学生数量同比图
	    	 List<TjCount> xzqyjytbt=xhService.xzqyjytbt(mc);
	    	 map.put("dataCount", xzqyjytbt);
	    	 map.put("title", mc+"历年就业学生同比图");
	    	 map.put("param1","nf64");
	     }if("jyxsmd".equals(reg)){//选定年专业学生就业单位
	    	 List<Object> jyxsmd=xhService.getjyxsmd(nf,zymc);
	    	 map.put("dataCount", jyxsmd);
	    	 map.put("title", nf+"年"+zymc+"就业学生及就业单位");
	    	 map.put("table", true);
	     }if("xznfjyl".equals(reg)){//选中年份各专业就业柱状图
	    	 List<TjCount> xznfjyl=xhService.getxznfjyl(nf);
	    	 map.put("xznfjyl", xznfjyl);
	     }if("xzzsmd".equals(reg)){//选中条件的招生名单
	    	 List<Object> xzzsmd=xhService.getxzzsmd(nf,zymc);
	    	 map.put("dataCount", xzzsmd);
	    	 map.put("table", true);
	    	 map.put("title", "招生各学生名单");
	     }if("xzxsjkfsqd".equals(reg)){//选中年份学生健康测评清单
	    	 List<Object>  stujkcp=xhService.getstujkqd(lb,nf,zymc,dqmc);
	    	 map.put("dataCount", stujkcp);
	    	 map.put("table", true);
	    	 map.put("title", "学生健康测评清单");
	     }if("xztjxsnd".equals(reg)){//按学生类型、年级、专业、地区查询名单
	    	 List<StudentEntity> stsltbt=xhService.getxsmd(lb,nf,zym,dqmc);
	    	 map.put("dataCount", stsltbt);
	    	 map.put("table", true);
	    	 map.put("title", "按学生类型、年级、专业、地区查询名单");
	     }if("xxdjgz".equals(reg)){//学校党建工作
//	    	 for (Permis permis : list) {
//					System.out.println(permis);
//					if(permis.getRemark().equals("/djgz")){
//					map.clear();
	    	 //管、技、工
	    	 List<TjCount> gjglist=xhService.getgjg();
	    	 map.put("gjglist", gjglist);
			//党建同比图
			List<Object> djtbt=xhService.getdjtbt(lb);
			map.put("djtbt", djtbt);
			//党建人均课时同比变化图
			List<Object> djkstbt=xhService.getdjkstbt();
			map.put("djkstbt", djkstbt);
			//党建活动数量同比变化图
			List<Object> djhdtbt=xhService.getdjhdtbt();
			map.put("djhdtbt", djhdtbt);
//					}
//					else{
//						map.put("code","403");
//					}
//				}
		}if("djhdqd".equals(reg)){//党建活动清单及参加人数
			 List<Object> djhdqd=xhService.getdjhdqd(nf);
			 map.put("dataCount", djhdqd);
			 map.put("title", nf+"党建活动清单及参加人数");
			 map.put("param1", "nf232");
			 map.put("table", true);
		}if("djpxqd".equals(reg)){//选定党建培训清单及参加人数
			 List<Object> djpxqd=xhService.getdjpxqd(nf);
			 map.put("dataCount", djpxqd);
			 map.put("title", nf+"党建培训清单及参加人数");
			 map.put("param1", "nf231");
			 map.put("table", true);
		}if("djpxmd".equals(reg)){//党建培训名单
			List<Object> djpxmd = xhService.getdjpxmd(nf,mc);
			map.put("dataCount", djpxmd);
			 map.put("title", nf+mc+"党建培训名单");
			 map.put("table", true);
		}if("xddymd".equals(reg)){//选定条件的党员名单
			 List<Object> xddymd=xhService.getxddymd(nf,zymc);
			 map.put("dataCount", xddymd);
			 map.put("title", nf+zymc+"党员名单");
			 map.put("table", true);
		}if("xzgzydysl".equals(reg)){//选定年份各专业、科室党员数量
			List<Object> xzgzydysl=xhService.getxzgzydysl(nf);
			 map.put("dataCount", xzgzydysl);
			 map.put("title", nf+"各专业党员数量");
			 map.put("param1", "nf227");
		}if("zyxsqk".equals(reg)){//专业学生情况
//			for (Permis permis : list) {
//				System.out.println(permis);
//				if(permis.getRemark().equals("/xsqk")){
//				map.clear();
			 //学生专业
	    	 List<TjCount> stuzy=xhService.getstuzy();
	    	 map.put("stuzy", stuzy);
	    	//学生年级
	    	 List<TjCount> stunj=xhService.stunj();
	    	 map.put("stunj", stunj);
			//在籍学生排名
			List<Object> zjxsslpm=xhService.getzjxsslpm(nf);
			map.put("zjxsslpm", zjxsslpm);
			//学生流失数量排名
			List<Object> xslspm=xhService.getxslspm(zymc);
			map.put("xslspm", xslspm);
			//培训专业
			List<TjCount> pxzylist=xhService.getzylist();
			map.put("pxzylist", pxzylist);
			//专业技能培训人次排名
			List<Object> zyjnpm=xhService.getzyjnpx(zymc);
			map.put("zyjnpm", zyjnpm);
			//各班级公共课平均成绩排名
			List<Object> gbggkpjcj=xhService.getggkcpjcjpm(zymc,kcmc,nf);
			map.put("gbggkpjcj", gbggkpjcj);
		    //获取技能证书学生比例排名
			List<Object> hqzsbl=xhService.gethqzsbl(nf);
			map.put("hqzsbl", hqzsbl);
//				}
//				else{
//					map.put("code","403");
//				}
//			}
		}if("xzpxmd".equals(reg)){//选中技能培训名单
			List<Object> pxxsmd=xhService.getpxxsmd(nf,zymc);
			map.put("dataCount", pxxsmd);
			map.put("title", zymc+"技能培训名单");
			map.put("table", true);
		}if("xzxmpxb".equals(reg)){//选中年份选中专业各项专业技能培训人数表
			List<Object> pxxmmx=xhService.getpxxmmx(nf,zymc);
			map.put("dataCount", pxxmmx);
			map.put("param1", "nf232");
			map.put("title", nf+zymc+"各项专业技能培训人数表");
			map.put("table", true);
		}if("hqzsxsmx".equals(reg)){//选中获取技能证书的学生详细数据表
			List<ZgzsEntity> hqzsxsmx=xhService.gethqzsxsmx(zym,nf);
			map.put("dataCount", hqzsxsmx);
			map.put("param1", "nf82");
			map.put("title", "获取技能证书的学生详细数据表");
			map.put("table", true);
		}if("lnzshqtbt".equals(reg)){//选中专业历年获取证书学生数量同比图
			List<Object> lnzshqtbt=xhService.getlnzshqtbt(zym);
			map.put("dataCount", lnzshqtbt);
			map.put("param1", "nf81");
			map.put("title", "该专业历年获取证书学生数量同比图");
		}if("xscj".equals(reg)){//选中学年该专业在该课程的学生成绩表
			List<Object> xscj=xhService.xscj(zymc,kcmc,nf);
			map.put("dataCount", xscj);
			map.put("title", nf+zymc+kcmc+"中每个学生的成绩");
			map.put("param1", "nf79");
		}if("kclncjpm".equals(reg)){//历年全校排名
			List<Object> cjqxpm=xhService.getcjqgpm(zymc,kcmc);
			map.put("dataCount", cjqxpm);
			map.put("title", zymc+kcmc+"历年全校排名");
			map.put("param1", "nf78");
		}if("bjxssl".equals(reg)){//选定年级专业班级学生数量列表
			List<TjCount> bjxssl=xhService.getbjxssl(nf, zymc);
			map.put("dataCount", bjxssl);
			map.put("title", nf+"年"+zymc+"各班级学生数量列表");
			map.put("param1", "nf76");
			map.put("table", true);
		}if("xzxslsnjfbt".equals(reg)){
			///选中部分的学生流失所处年级分布图
			List<Object> xzxslsnjfbt=xhService.getxzxslsnjfbt(nf,zymc);
			map.put("dataCount", xzxslsnjfbt);
			map.put("title", nf+"年"+zymc+"学生流失所在班级分布图");
			map.put("param1", "nf75");
		}if("xdzynjxsdbt".equals(reg)){
			//选中专业在该学年的各年级学生数量对比图
			List<TjCount> zynjxsdbt=xhService.getzynjxsdbt(nf,zymc);
			map.put("dataCount", zynjxsdbt);
			map.put("title", nf+"年各年级学生数量对比图");
			map.put("param1", "nf74");
		}if("xzbjxsmx".equals(reg)){
			//选中班级人员明细
			List<StudentEntity> zynjxsdbt=xhService.getgbjxsmd(bh);
			map.put("dataCount", zynjxsdbt);
			map.put("title", bh+"学生明细");
			map.put("table", true);
		}if("zyszjg".equals(reg)){//专业师资结构
//			for (Permis permis : list) {
//				System.out.println(permis);
//				if(permis.getRemark().equals("/szjg")){
//				map.clear();
			//专业列表
			List<TjCount> zylist=xhService.getzylist();
			map.put("zylist", zylist);
			//年份列表
			List<TjCount> zynj = xhService.stunj();
			map.put("zynj", zynj);
			//人才引进排名
			List<Object> rcyjpm=xhService.getrcyjpm(nf,zymc);
			map.put("rcyjpm", rcyjpm);
			//教职工专业
			List<TjCount> jzgzy=xhService.getjszylist();
			map.put("jzgzy", jzgzy);
			//拥有专业中级以上职称的教师数量
			List<Object> zjjssl=xhService.getzjjssl(nf);
			map.put("zjjssl", zjjssl);
			//师资学历对比图
			List<Object> zyszxldjbt=xhService.getzyszxldjbt();
			map.put("zyszxldjbt", zyszxldjbt);
			//教师职称对比图
			List<Object> jszcdjt=xhService.getjszcdjt();
			map.put("jszcdjt", jszcdjt);
			//双师型教师比例排名表
			List<Object> ssxjsblpm=xhService.getssxjsblpm(nf);
			map.put("ssxjsblpm", ssxjsblpm);
			//专兼职教师数量对比图
			List<Object> zjzjsdjt=xhService.getzjzjsdjt();
			map.put("zjzjsdjt", zjzjsdjt);
			//文化课专业课教师数量对比图
			List<Object> whzyjsdjt=xhService.getwhzyjsdjt();
			map.put("whzyjsdjt", whzyjsdjt);
//				}
//				else{
//					map.put("code","403");
//				}
//			}
			
		}if("ssxjsbltbt".equals(reg)){//选中专业双师型教师比例同比图
			List<Object> zyssxjsbltbt=xhService.getzylnssxjssl(zymc);
			map.put("dataCount", zyssxjsbltbt);
			map.put("title", zymc+"双师型教师比例同比图");
			map.put("param1", "nf260");    
		}if("xzwzjsdjt".equals(reg)){//选中专业历年文化课专业课教师数量同比图
			List<Object> xzwzjsdjt=xhService.getxzwzjsdjt(zymc);
			map.put("dataCount", xzwzjsdjt);
			map.put("title", zymc+"历年文化课专业课教师数量同比图");
			map.put("type", "djt");
			map.put("param1", "nf245");     
		}if("zyzjzjsdjt".equals(reg)){//选中专业专兼职教师同比图
			List<Object> zyzjzjsdjt=xhService.getzyzjzjsdjt(zymc);
			map.put("dataCount", zyzjzjsdjt);
			map.put("title", zymc+"专兼职教师同比图");
			map.put("type", "djt");
			map.put("param1", "nf243");                                                                                                                                                                                                                                                                      
		}if("zyzcbht".equals(reg)){//各专业师资职称同比变化图
			List<Object> zyzcbht=xhService.getzyzcbht(zymc);
			map.put("dataCount", zyzcbht);
			map.put("title", zymc+"师资职称同比变化图");
			map.put("type", "djt");
			map.put("param1", "nf240");
		}if("zyszxldbt".equals(reg)){//各专业师资学历堆积图
			List<Object> szxldbt=xhService.getszxldbt(zymc);
			map.put("dataCount", szxldbt);
			map.put("title", zymc+"师资学历同比变化图");
			map.put("type", "djt");
			map.put("param1", "nf237");
		}if("xdjsxlmx".equals(reg)){//选中年分专业教师学历/职称/专兼职教/文化课专业课教师明细
			List<JzgEntity> xdjsxlmx=xhService.getxdjsxlmx(nf,zym);
			map.put("dataCount", xdjsxlmx);
			map.put("title", nf+zymc+"教师学历明细");
			map.put("table", true);
		}if("gjssmx".equals(reg)){//选定年份专业中级以上教师明细
			List<Object> gjssmx=xhService.getgjssmx(nf,zymc);
			map.put("dataCount", gjssmx);
			map.put("title",nf+zymc+ "中级以上教师明细");
			map.put("table", true);
		}if("zyzjsstbt".equals(reg)){//选中专业历年中级以上教师数量同比图
			List<Object> zyzjsstbt=xhService.getlnzjjssltbt(zymc);
			map.put("dataCount", zyzjsstbt);
			map.put("title",zymc+"历年中级以上教师数量同比图");
			map.put("param1", "nf236");
		}if("rcyjmx".equals(reg)){//选中年份人才引进明细
			List<Object> rcyjmx=xhService.getrcyjmx(nf);
			map.put("dataCount", rcyjmx);
			map.put("title",nf+ "年人才引进清单");
			map.put("param1", "nf235");
			map.put("table", true);
		}if("rcyjtbt".equals(reg)){//历年人才引进数量同比图
			List<Object> lnrcyjsl=xhService.getlnrcyjsl(zymc);
			map.put("dataCount", lnrcyjsl);
			map.put("title","历年人才引进数量同比图");
			map.put("param1", "nf234");	
		}if("zyjyqk".equals(reg)){//专业就业情况
//			for (Permis permis : list) {
//				System.out.println(permis);
//				if(permis.getRemark().equals("/jyqk")){
//				map.clear();
			//学生年级
	    	 List<TjCount> stunj=xhService.stunj();
	    	 map.put("stunj", stunj);
			//平均薪酬排名			
			List<Object> gzypjxc=xhService.getgzypjxc(nf);
			map.put("gzypjxc", gzypjxc);
			//就业率排名
			List<Object> zyjylpm = xhService.getgzyjylpm(nf);
			map.put("zyjylpm", zyjylpm);
			//毕业生满意率排名
			List<Object> mylpm=xhService.gebysmyd(nf);
			map.put("mylpm", mylpm);
//				}
//				else{
//					map.put("code","403");
//				}
//			}
		}if("mydmx".equals(reg)){//选中专业毕业生满意度明细
			List<Object> mydmx=xhService.getmydmx(nf,zymc);
			map.put("dataCount", mydmx);
			map.put("title",zymc+nf+ "年毕业生薪资明细");
			map.put("table", true);
		}if("zybysmydtbt".equals(reg)){//选中专业毕业生满意度同比图
			List<Object> zybysmydtbt=xhService.getzybysmydtbt(zymc);
			map.put("dataCount", zybysmydtbt);
			map.put("title",zymc+"毕业生满意度同比图");
			map.put("param1", "nf246");	
		}if("xzzyjyltbt".equals(reg)){//选中专业就业率同比图
			List<Object> xzzyjyltbt=xhService.getxzzyjyl(zymc);
			map.put("dataCount", xzzyjyltbt);
			map.put("title",zymc+"就业率同比图");
			map.put("param1", "nf89");	
		}if("xzzyxztbt".equals(reg)){//选中专业各年平均薪资同比变化图
			List<TjCount> xzzyxztbt=xhService.getxzzyxztbt(zymc);
			map.put("dataCount", xzzyxztbt);
			map.put("title",zymc+ "各年平均薪资同比变化图");
			map.put("param1", "nf86");
		}if("bysxzmx".equals(reg)){//选中年专业就业明细
			List<BysxzEntity> bysxzmx = xhService.getbysxzmx(nf,zymc);
			map.put("dataCount", bysxzmx);
			map.put("title",zymc+nf+ "年毕业生薪资明细");
			map.put("table", true);
		}if("zyjxsx".equals(reg)){//专业教学实训
//			for (Permis permis : list) {
//				System.out.println(permis);
//				if(permis.getRemark().equals("/jxsx")){
//				map.clear();
			//学年
	    	 List<TjCount> stunj=xhService.stunj();
	    	 map.put("xn", stunj);
			//实训满意度排名
	    	 List<Object> sxmydpm=xhService.getsxmydpm(nf);
	    	 map.put("sxmydpm", sxmydpm);
			//实训设备/生均工位数数量排名（横轴专业）
			List<Object> sjgwpm=xhService.getsjgwpm();
			map.put("sjgwpm", sjgwpm);
			//设备金额排名
			List<Object> sbjepm=xhService.getsbjepm();
			map.put("sbjepm", sbjepm);
			//科研数量排名
			List<Object> kyslpm=xhService.getkyslpm(nf);
			map.put("kyslpm", kyslpm);
			//科研金额排名
			List<Object> kyjepm=xhService.getkyjepm(nf);
			map.put("kyjepm", kyjepm);
			//信息设备总量
			List<Object> xxsbzslpm=xhService.getxxsbzslpm();
			map.put("xxsbzslpm", xxsbzslpm);
			//生均数量排名（横轴专业）
			List<Object> sjslpm=xhService.getsjslpm();
			map.put("sjslpm", sjslpm);
			//校外实训基地数量排名
			List<Object> xwjdslpm=xhService.getxwjdslpm(nf);
			map.put("xwjdslpm", xwjdslpm);
			//获奖情况加权排名
			List<Object> hjqkpm=xhService.gethjqkpm(nf);
			map.put("hjqkpm", hjqkpm);
			//学生学习满意度评分排名
			List<Object> xsxxmydpm=xhService.getxsxxmydpm();
			map.put("xsxxmydpm", xsxxmydpm);
			//各专业经费投入排名（分学年）
			List<Object> gzyjftrpm=xhService.getgzyjftrpm(nf);
			map.put("gzyjftrpm", gzyjftrpm);
//				}
//				else{
//					map.put("code","403");
//				}
//			}
		}if("zyjftrtbt".equals(reg)){//选定专业经费投入同比图
			List<Object> zyjftrtbt=xhService.getzyjftrtbt(zymc);
			map.put("dataCount", zyjftrtbt);
			map.put("title",zymc+"经费投入同比变化图");
			map.put("param1", "nf257");
		}if("jftrmx".equals(reg)){//经费投入明细
			List<Object> jftrmx=xhService.getjftrmx(nf,zymc);
			map.put("dataCount", jftrmx);
			map.put("title",nf+zymc+"经费投入明细");
			map.put("table", true);
		}if("xxmydtbt".equals(reg)){//选中专业学生学习满意度同比图
			List<Object> xsxxmydtbt=xhService.getxsxxmydtbt(zymc);
			map.put("dataCount", xsxxmydtbt);
			map.put("title",zymc+"历年学生学习满意度同比变化图");
			map.put("param1", "nf256");
		}if("xsxxmydmx".equals(reg)){//学生学习满意度明细
			List<Object> xsxxmydmx=xhService.getxsxxmydmx(nf,zymc);
			map.put("dataCount", xsxxmydmx);
			map.put("title",nf+zymc+"学生学习满意度明细");
			map.put("table", true);
		}if("zyhjtbt".equals(reg)){//选中专业获奖加权同比图
			List<Object> hjjqtbt=xhService.gethjjqtbt(zymc);
			map.put("dataCount", hjjqtbt);
			map.put("title",zymc+"历年获奖加权同比图");
			map.put("param1", "nf256");
		}if("hjqkmx".equals(reg)){//选中年份专业获奖情况明细
			List<Object> hjqkmx=xhService.gethjqkmx(nf,zymc);
			map.put("dataCount", hjqkmx);
			map.put("title",nf+zymc+"获奖情况明细");
			map.put("table", true);		
		}if("xxsbmx".equals(reg)){//选中专业信息设备明细及专业人数同比图
			List<Object> xxsbmx=xhService.xxsbmx(zymc);
			map.put("xxsbmx", xxsbmx);
			List<Object> kyxmmx=xhService.getlnzyxssl(zymc);
			map.put("dataCount", kyxmmx);
			map.put("title",zymc+"信息设备明细及专业人数同比图");
			map.put("table", true);		
		}if("kyxmmx".equals(reg)){//科研项目明细
			List<Object> kyxmmx=xhService.getkyxmmx(nf,zymc);
			map.put("dataCount", kyxmmx);
			map.put("title",nf+zymc+"科研项目明细");
			map.put("table", true);		
		}if("sxmyltbt".equals(reg)){//专业实训满意度同比图
			List<Object> sxmydtbt=xhService.getsxmydtbt(zymc);
			map.put("dataCount", sxmydtbt);
			map.put("title",zymc+"训满意度同比图");
			map.put("param1", "nf249");			
		}if("sxsmydmx".equals(reg)){//实训满意度明细
			List<Object> sxmydtbt=xhService.getsxmydtbt(nf,zymc);
			map.put("dataCount", sxmydtbt);
			map.put("title",nf+zymc+"实训满意度明细");
			map.put("table", true);			
		}if("sbgwsmx".equals(reg)){//选中专业的实训设备及工位数明细表
			map.put("dataCount", null);
			map.put("title",zymc+"实训设备及工位数明细表");
			map.put("table", true);
		}if("sbjemx".equals(reg)){//选中专业的实训设备金额/及工位数明细表
			List<Object> sbjemx=xhService.getsxssbsyqd("2017", null) ;
			map.put("dataCount", sbjemx);
			map.put("title",zymc+"实训设备金额明细表");
			map.put("table", true);
		}if("xzjdmx".equals(reg)){//选中年专业校外基地明细表
			List<Object> xzjdmx = xhService.getxzjdmx(nf,zymc);
			map.put("dataCount", xzjdmx);
			map.put("title",nf+zymc+"校外基地明细表");
			map.put("table", true);
		}
		/********************************招生工作*************************************/
		if("xszsgz".equals(reg)){//学生招生工作
//			for (Permis permis : list) {
//				System.out.println(permis);
//				if(permis.getRemark().equals("/students")){
//				map.clear();
			//招生老师
			List<TjCount> zslslist=xhService.getzsjslist();
			map.put("zslslist", zslslist);
			//学生专业
	    	 List<TjCount> stuzy=xhService.getstuzy();
	    	 map.put("stuzy", stuzy);
	    	 //入学渠道
	    	 List<TjCount> rxqd=xhService.getrxqdlist();
	    	 map.put("rxqd", rxqd);
	    	 //学生班级
	    	 List<TjCount> stubj=xhService.getbjlist();
	    	 map.put("stubj", stubj);
			//新生数量同比图
			List<Object> xssltbzzt = xhService.getxssltbzzt();
			map.put("xssltbzzt", xssltbzzt);
			//新生生源地分布图
			List<Object> xssydfb = xhService.xssydfb();
			map.put("xssydfb", xssydfb);
			//新生专业分布图
			List<Object> xszyfbt=xhService.getxszyfbt();
			map.put("xszyfbt", xszyfbt);
			//新生教育分类分布
			List<Object> xsjyflfb=xhService.getxsjyflfb();
			map.put("xsjyflfb", xsjyflfb);
			//学生年龄分布
			List<Object> agefb=xhService.getagegb(bh,zymc);
			map.put("agefb", agefb);
			//新生性别分布
			List<Object> xsxbfb=xhService.getxsxbfb(bh,zymc);
			map.put("xsxbfb", xsxbfb);
			//少数民族分布
			List<Object> ssmzfb=xhService.getssmzfb(bh,zymc);
			map.put("ssmzfb", ssmzfb);
			//新生生源质量
			List<Object> xssyzl=xhService.getxssyzl(zymc);
			map.put("xssyzl", xssyzl);
			//定向生数量同比图
			List<Object> dxsslbl=xhService.getdxsslbl(zymc);
			map.put("dxsslbl", dxsslbl);
			//定向生数量同比图
			List<Object> dxssl=xhService.getdxssl(zymc);
			map.put("dxssl", dxssl);
			//入学渠道同比变化图
			List<Object> rxqdtbt=xhService.getrxqdtbt();
			map.put("rxqdtbt", rxqdtbt);
			//报到人员比例
			List<Object> bdrybitbt = xhService.getbdrytbt(lb,zymc);
			map.put("bdrybitbt", bdrybitbt);
			//新生来源学校
			List<Object> xslyxxfb=xhService.getxslyxxfb();
			map.put("xslyxxfb", xslyxxfb);
			//招生人员招生数量排序
			List<Object> zsryzssl=xhService.getzsryzspx();
			map.put("zsryzssl", zsryzssl);
			//招生人员历年工作同比图
			List<Object> zsrylbzs=xhService.getzsrylnzs(mc);
			map.put("zsrylbzs", zsrylbzs);
			//新生报到人数图（按生源地）
			List<Object> xsbdrsfbt=xhService.getxsbdrsfbt();
			map.put("xsbdrsfbt", xsbdrsfbt);
			//新生报到人数同比图（分专业）
			List<Object> gzyxssl=xhService.getgzyxssltbt(zymc);
			map.put("gzyxssl", gzyxssl);
			//新生报到人数同比变化图（分生源学校）
			List<Object> glyxxxssltbt=xhService.getglyxxxssltbt(mc);
			map.put("glyxxxssltbt", glyxxxssltbt);
			//新生报到人数同比变化图(分性别)
			List<Object> xbxsbrstbt=xhService.getxbxsbrstbt(mc);
			map.put("xbxsbrstbt", xbxsbrstbt);
			//招生渠道
			List<TjCount> zsqdList=xhService.getzsqdList();
			map.put("zsqdList", zsqdList);
			//新生报到人数同比变化图（分招生人员/渠道）
			List<Object> zsjsqdbdrssl=xhService.getzsjsqdbdrssl(mc,dg);
			map.put("zsjsqdbdrssl", zsjsqdbdrssl);
			//各类短期技能培训班
			List<TjCount> gldqpxb=xhService.getgldqpxb();
			map.put("gldqpxb", gldqpxb);
			//新生报到人次同比变化图（分各类短期技能培训班）
			List<Object> xsbdrctbt=xhService.getxsbdrcsl(mc);
			map.put("xsbdrctbt", xsbdrctbt);
			//招生资金同比变化图
			List<Object> zszjtbt=xhService.getzszjtbt();
			map.put("zszjtbt", zszjtbt);
			//人均招生费用同比变化图
			List<Object> rjzsfytbt=xhService.getrjzsfy();
			map.put("rjzsfytbt", rjzsfytbt);
			//各来源学校招生费用对比图
			List<Object> lyxxzsfydbt=xhService.getlyxxzsfy();
			map.put("lyxxzsfydbt", lyxxzsfydbt);
//				}
//				else{
//					map.put("code","403");
//				}
//			}
		}if("xzdqxssltbt".equals(reg)){//选中地区新生数量同比图
			List<Object> xzdqxssltbt= xhService.xzdqxssltbt(dqmc);
			map.put("dataCount", xzdqxssltbt);
			map.put("title",dqmc+"选中地区新生数量同比图");
			map.put("param1", "nf603");
		}if("xzdqxsmd".equals(reg)){//选中地区新生名单
			List<Object> xzdqxsmd=xhService.xzdqxsmd(nf,dqmc);
			map.put("dataCount", xzdqxsmd);
			map.put("title",nf+dqmc+"新生名单");
			map.put("table", true);			
		}if("nfzslszsmd".equals(reg)){//选中年招生老师招生名单
			List<Object> nfzslszsmd=xhService.nfzslszsmd(nf,mc);
			map.put("dataCount", nfzslszsmd);
			map.put("title",nf+zymc+mc+dg+"学生名单");
			map.put("table", true);			
		}if("xxjzsfy".equals(reg)){//选中来源学校均招生费用同比图
			List<Object> xxjzsfy= xhService.getxxjzsfy(mc);
			map.put("dataCount", xxjzsfy);
			map.put("title",mc+"招生资金使用分类饼图");
			map.put("param1", "nf285");
		}if("ngqdrjzsfy".equals(reg)){//年各渠道人均招生费用饼图
			List<Object> ngqdrjzsfy= xhService.getngqdrjzsfy(nf);
			map.put("dataCount", ngqdrjzsfy);
			map.put("title",nf+"年各渠道人均招生费用饼图");
			map.put("param1", "nf284");
			map.put("type", "bt");
		}if("zsqusyqk".equals(reg)){//年招生资金使用分类饼图
			List<Object> zsqusyqk= xhService.getzsqusyqk(nf);
			map.put("dataCount", zsqusyqk);
			map.put("title",nf+"年招生资金使用分类饼图");
			map.put("param1", "nf281");
		}if("zszjmx".equals(reg)){//选中年、渠道招生金额使用明细
			List<Object> zszjmx= xhService.getzszjmx(nf,mc);
			map.put("dataCount", zszjmx);
			map.put("title",nf+mc+"招生资金使用明细");
			map.put("table", true);	
		}if("jnbzsrstbt".equals(reg)){//选中技能班历年招生人数
			List<Object> jnbzsrstbt= xhService.getjnbzsrstbt(mc);
			map.put("dataCount", jnbzsrstbt);
			map.put("title",mc+"历年招生数量");
			map.put("param1", "nf280");
		}if("jnbzsmxsj".equals(reg)){//选中技能班该年招生明细
			List<Object> jnbzsmxsj= xhService.getjnbzsmxsj(nf,mc);
			map.put("dataCount", jnbzsmxsj);
			map.put("title",mc+"历年招生明细数据");
			map.put("table", true);	
		}if("zyqdzsmd".equals(reg)){//选中年专业渠道招生名单
			List<Object> zyqdzsmd=xhService.zyqdzsmd(nf,zymc,dg,mc);
			map.put("dataCount", zyqdzsmd);
			map.put("title",nf+zymc+mc+dg+"学生名单");
			map.put("table", true);			
		}if("zsqdrylnzssl".equals(reg)){//该招生人员/渠道各专业当年招生数量
			List<Object> zsqdrylnzssl= xhService.getzsqdrylnzssl(nf,mc,dg);
			map.put("dataCount", zsqdrylnzssl);
			map.put("title",nf+mc+dg+"各专业招生数量");
			map.put("param1", "nf277");
		}if("xzxbzyxssl".equals(reg)){//选中性别年份各专业新生数量
			List<Object> xzxbzyxssl=xhService.getxzxbzyxssl(nf,mc);
			String nam="";
			if("1".equals(mc)){
				nam="男";
			}if("2".equals(mc)){
				nam="女";
			}
			map.put("dataCount", xzxbzyxssl);
			map.put("title",nf+nam+"各专业新生数量");
			map.put("param1", "nf275");
		}if("xbzyxsmx".equals(reg)){//选定年份、性别、专业新生明细
			List<Object> xbzyxsmx=xhService.getxbzyxsmx(nf,mc,zymc);
			String nam="";
			if("1".equals(mc)){
				nam="男";
			}if("2".equals(mc)){
				nam="女";
			}
			map.put("dataCount", xbzyxsmx);
			map.put("title",nf+nam+zymc+"新生明细");
			map.put("table", true);
		}if("xxlyxxxsmx".equals(reg)){//选定年份专业学校新生明细
			List<Object> xxlyxxxsmx=xhService.getxxlyxxxsmx(nf,zymc,mc);
			map.put("dataCount", xxlyxxxsmx);
			map.put("title",nf+zymc+mc+"新生名单");
			map.put("table", true);
		}if("xdxxgzyxssl".equals(reg)){//选定学校该年各专业新生数量
			List<Object> xdxxgzyxssl=xhService.getxdxxgzyxssl(nf,mc);
			map.put("dataCount", xdxxgzyxssl);
			map.put("title",nf+mc+"各专业新生数量");
			map.put("param1", "nf271");
		}if("xdzygdqxssl".equals(reg)){//选定专业各地区新生数量
			List<Object> xdzygdqxssl=xhService.getxdzygdqxssl(nf,zymc);
			map.put("dataCount", xdzygdqxssl);
			map.put("title",nf+zymc+"各地区新生数量");
			map.put("param1", "nf272");
		}if("xzzydqxsmx".equals(reg)){//选定专业地区新生明细
			List<Object> xzzydqxsmx=xhService.getxzzydqxsmx(nf,zymc,mc);
			map.put("dataCount", xzzydqxsmx);
			map.put("title",zymc+mc+"新生名单");
			map.put("table", true);
		}if("xzdqzyrs".equals(reg)){//选中地区各专业当年新生人数
			List<Object> xzdqgzyrs=xhService.getxzdqgzyrs(mc);
			map.put("dataCount", xzdqgzyrs);
			map.put("title",mc+"各专业当年新生人数");
			map.put("param1", "nf268");
		}if("gtzsqk".equals(reg)){//选定教职工每天招生数量变化图
			List<Object> gtzsqk=xhService.getgtzsqk(mc);
			map.put("dataCount", gtzsqk);
			map.put("title",mc+"每天招生数量变化图");
			map.put("param1", "nf265");
		}if("zsjszsmx".equals(reg)){//选定日期教职工招生明细
			List<Object> zsjszsmx=xhService.getzsjszsmx(nf,mc);
			map.put("dataCount", zsjszsmx);
			map.put("title",nf+mc+"招生明细表");
			map.put("table", true);
		}if("xxzssltbt".equals(reg)){//选定学校历年招生数量同比图
			List<Object> xxzssltbt=xhService.getxxzssltbt(mc);
			map.put("dataCount", xxzssltbt);
			map.put("title",mc+"历年招生数量同比变化图");
			map.put("param1", "nf264");
		}if("zsxxxsmx".equals(reg)){//选中招生学校新生明细表
			List<Object> zsxxxsmx=xhService.getzsxxxsmx(mc,nf);
			map.put("dataCount", zsxxxsmx);
			map.put("title",nf+mc+"招生明细表");
			map.put("table", true);
		}if("gzyrxqd".equals(reg)){//各专业入学渠道同比图
			List<Object> gzyrxqd=xhService.getgzyrxqd(mc);
			map.put("dataCount", gzyrxqd);
			map.put("title",mc+"入学渠道同比图");
			map.put("table", true);
		}if("zyqdxsmd".equals(reg)){//选中专业入学渠道新生明细
			List<Object> zyqdxsmd=xhService.getzyqdxsmd(zymc,mc);
			map.put("dataCount", zyqdxsmd);
			map.put("title",nf+zymc+"入学渠道新生明细");
			map.put("table", true);
		}if("dxsmx".equals(reg)){//定向生明细
			List<Object> dxsmx=xhService.getdxsmx(nf,zymc);
			map.put("dataCount", dxsmx);
			map.put("title",nf+zymc+"定向生明细");
			map.put("table", true);
		}if("xzcjmx".equals(reg)){//选中新生成绩明细
			List<Object> xzcjmx=xhService.getxzcjmx(bh,zymc,lb);
			map.put("dataCount", xzcjmx);
			map.put("title",bh+zymc+"新生明细");
			map.put("table", true);
		}if("ssmzmx".equals(reg)){//按民族学生明细
			List<Object> ssmzmx = xhService.getssmzmx(bh,zymc,lb);
			map.put("dataCount", ssmzmx);
			map.put("title",bh+zymc+lb+"新生明细");
			map.put("table", true);	
		}if("xbmxb".equals(reg)){//按性比新生明细
			List<Object> xbxsmx = xhService.getxbxsmx(bh,zymc,lb);
			map.put("dataCount", xbxsmx);
			map.put("title",bh+zymc+"新生明细");
			map.put("table", true);			
		}if("xzmxsj".equals(reg)){//按年龄新生明细
			List<Object> xsxxb=xhService.getnlfbmx(bh,zymc,aged);
			map.put("dataCount", xsxxb);
			map.put("title",bh+zymc+"新生明细");
			map.put("table", true);
		}if("xzfllnxssltbt".equals(reg)){
			//选中分类历年新生数量同比图
			List<Object> lxxstbt=xhService.getlxxstbt(lb);
			map.put("dataChi'yount", lxxstbt);
			map.put("title",lb+"新生历年学生数量同比图");
			map.put("param1", "nf100");
		}if("xzgzyxssl".equals(reg)){
			//选中年份各专业新生数量饼图
			List<Object> gzyxssl=xhService.getzyyxsslbt(nf);
			map.put("dataCount", gzyxssl);
			map.put("title",nf+"各专业招生数量饼图");
			map.put("param1", "nf97");
			map.put("type", "bt");
		}if("xzmxb".equals(reg)){//新生明细表
			List<Object> xzjdmx = xhService.getxzxsmx(nf,zymc,lb);
			map.put("dataCount", xzjdmx);
			map.put("title",nf+zymc+"新生明细表");
			map.put("table", true);
		}if("lnzyxstbt".equals(reg)){//专业历年学生数量同比图
			List<Object> lnzyxssl = xhService.getlnzyxssl(zymc);
			map.put("dataCount", lnzyxssl);
			map.put("title",zymc+"历年学生数量同比图");
			map.put("param1", "nf91");
		}
		/*******************************就业升学***************************************/
		if("xsjysx".equals(reg)){
//			for (Permis permis : list) {
//				System.out.println(permis);
//				if(permis.getRemark().equals("/jysx")){
//				map.clear();
			/**********就业率**********/
			//培养层次
	    	 List<TjCount> pycc=xhService.pycc();
	    	 map.put("pycc", pycc);
	    	//学生年级
	    	 List<TjCount> stunj=xhService.stunj();
	    	 map.put("stunj", stunj);
			//毕业生专业
			List<TjCount> dgszy=xhService.getbyszy1();
			map.put("dgszy", dgszy);
			//历年升学人数变化图
			List<Object> lnsxrstbt=xhService.getlnsxrs();
			map.put("lnsxrstbt", lnsxrstbt);
			//历年毕业生人数
			List<Object> bysrs=xhService.getbyssltbt(zymc,lb);
			map.put("bysrs", bysrs);
			//历年就业人数同比图
			List<Object> lnjyrs=xhService.getlnjyrs();
			map.put("lnjyrs", lnjyrs);
			//历年多口就业人数同比变化图
			List<Object> lndkjy=xhService.getlndkjy(zymc);
			map.put("lndkjy", lndkjy);
			//历年对口就业比例同比变化图
			List<Object> lndkjybl=xhService.getlndkjybl(zymc);
			map.put("lndkjybl", lndkjybl);
			//就业行业排序表 
			List<Object> hypxb=xhService.getghypxb(zymc);
			map.put("hypxb", hypxb);
			//升学学校排名表
			List<Object> sxxxpmb=xhService.getsxxxpm(zymc,nf);
			map.put("sxxxpmb", sxxxpmb);
			//就业渠道饼图
			List<Object> jyqdbt=xhService.getjyqdbt();
			map.put("jyqdbt", jyqdbt);
			//顶岗实习企业
			List<TjCount> dgsxqy=xhService.getdgsxqy();
			map.put("dgsxqy", dgsxqy);
			//顶岗实习人数同比图（分专业，企业）
			List<Object> dgsxrstbt=xhService.getdgsxrs(zymc,mc);
			map.put("dgsxrstbt", dgsxrstbt);
			//顶岗实习后录用人数同比变化图（分专业、分企业）
			List<Object> dgsxhlytbt=xhService.getdghlytbt(zymc,mc);
			map.put("dgsxhlytbt", dgsxhlytbt);
			//历年顶岗实习后录用率同比变化图
			List<Object> dglylbht=xhService.getdglylbht(zymc,mc);
			map.put("dglylbht", dglylbht);
			//合作企业的就业人数同比变化图（分企业）
			List<Object> ghzqyjyrs=xhService.getghzqyjy(mc);			
			map.put("ghzqyjyrs", ghzqyjyrs);
		/*************************************就业质量******************************************/
			//就业专业
			List<TjCount> jyszy = xhService.getjyszy();
			map.put("jyszy", jyszy);
			//就业地域分布图
			List<Object> bydyfbt=xhService.getbydyfbt(zymc);
			map.put("bydyfbt", bydyfbt);
			//用人单位满意度同比变化图
			List<Object> dwmyd=xhService.getdwmyd(zymc);
			map.put("dwmyd", dwmyd);
			//毕业生薪酬分布图
			List<Object> bysxcfb=xhService.getbysxzfb(lb,nf,zymc);
			map.put("bysxcfb", bysxcfb);
			//历年毕业生薪酬变化图
			List<Object> lnbysxc=xhService.lnbysxcbht(lb,zymc);
			map.put("lnbysxc", lnbysxc);
			//对口就业变化图（分专业，分教育类型）
			List<Object> dkjy=xhService.lnbysdkjybht(zymc,lb);
			map.put("dkjy", dkjy);
			//就业公司
			List<TjCount> yrdwlist=xhService.getjygglist();
			map.put("yrdwlist", yrdwlist);
			//学生就业后稳定性变化
			List<Object> jyhwdbht=xhService.getjyhwdbht(zymc,mc);
			map.put("jyhwdbht", jyhwdbht);
//				}
//				else{
//					map.put("code","403");
//				}
//			}
		}if("nfzyqdxsmd".equals(reg)){//选中渠道专业年分新生名单
			List<Object> nfzyqdxsmd=xhService.nfzyqdxsmd(nf,zymc,lb);
			map.put("dataCount", nfzyqdxsmd);
			map.put("title",nf+zymc+lb+"新生名单");
			map.put("table", true);
		}if("btsdkjymd".equals(reg)){//毕业生对口就业名单
			List<Object> btsdkjymd=xhService.getbtsdkjymd(nf,zymc,lb);
			map.put("dataCount", btsdkjymd);
			map.put("title",nf+zymc+lb+"毕业生对口就业名单");
			map.put("table", true);
		}if("lzxsmx".equals(reg)){//选中离职学生明细
			List<Object> lzxsmx=xhService.getlzxsmx(nf,zymc,mc);
			map.put("dataCount", lzxsmx);
			map.put("title",nf+zymc+mc+"离职学生明细表");
			map.put("table", true);
		}if("xznfdwjysl".equals(reg)){//选中年分就业单位就业生数量
			List<Object> xznfdwjysl=xhService.getxznfdwjysl(nf);
			map.put("dataCount", xznfdwjysl);
			map.put("title",nf+"就业单位就业生数量饼图");
			map.put("param1", "nf291");
			map.put("type", "bt");
		}if("gsxxxbt".equals(reg)){//选中年份升学学校饼图
			List<Object> gsxxxbt=xhService.getgsxxxbt(nf);
			map.put("dataCount", gsxxxbt);
			map.put("title",nf+"升学学校饼图");
			map.put("param1", "nf290");
			map.put("type", "bt");
		}if("xzbfxzmx".equals(reg)){//选中部分薪资明细
			List<Object> xzbfxzmx=xhService.getxzbfxzmx(lb,nf,zymc,dg);
			map.put("dataCount", xzbfxzmx);
			map.put("title",nf+zymc+lb+"毕业生工资明细表");
			map.put("table", true);
		}if("gqymydmc".equals(reg)){//企业满意度调查明细
			List<Object> gqymydmc=xhService.getgqymydmx(nf);
			map.put("dataCount", gqymydmc);
			map.put("title",nf+"企业就业满意度调查明细数据表");
			map.put("table", true);
		}if("bysdymx".equals(reg)){//选定地域就业生明细
			List<Object> bysdymx=xhService.getbysdymx(zymc,mc,nf);
			map.put("dataCount", bysdymx);
			map.put("title",nf+mc+zymc+"就业生明细");
			map.put("table", true);
		}if("xdyjytbt".equals(reg)){//选定地域就业同比图
			List<Object> xdyjytbt=xhService.getxdyjytbt(zymc,mc);
			map.put("dataCount", xdyjytbt);
			map.put("title",mc+zymc+"历年就业同比图");
			map.put("param1", "124");
		}if("xzqyjymx".equals(reg)){//选中企业就业明细
			List<Object> xzqyjymx=xhService.getxzqyjymx(mc,nf);
			map.put("dataCount", xzqyjymx);
			map.put("title",nf+mc+"就业明细表");
			map.put("table", true);
		}if("dgsxlymx".equals(reg)){//顶岗实训后录用明细
			List<Object> dgsxlymx=xhService.getdgsxlymx(mc,zymc,nf);
			map.put("dataCount", dgsxlymx);
			map.put("title",nf+mc+zymc+"顶岗实训后录用明细表");
			map.put("table", true);
		}if("xzdgsxmx".equals(reg)){//选中顶岗实训明细
			List<Object> dgsxmx=xhService.getdgsxmx(mc,zymc,nf);
			map.put("dataCount", dgsxmx);
			map.put("title",nf+mc+zymc+"顶岗实习明细表");
			map.put("table", true);
		}if("xzqdjymx".equals(reg)){//选中渠道就业生明细
			List<Object> jyqdxsmx=xhService.getxzqdjymx(mc,nf);
			map.put("dataCount", jyqdxsmx);
			map.put("title",nf+mc+"历年就业生明细数据表");
			map.put("table", true);
		}if("xzqdlntbt".equals(reg)){//选中渠道历年就业同比图
			List<Object> xzqdlntbt=xhService.getxzqdlntbt(mc);
			map.put("dataCount", xzqdlntbt);
			map.put("title",mc+"历年就业学生同比图");
			map.put("param1", "nf116");
		}if("xzxxsxmx".equals(reg)){//选中学生升学明细
			List<Object> xzxxsxmx=xhService.getxzxxsxmx(nf,mc);
			map.put("dataCount", xzxxsxmx);
			map.put("table", true);
			map.put("title",nf+mc+"升学学生明细表");
		}if("lnsxxxtbt".equals(reg)){//选中学校历年升学学生同比图
			List<Object> lnsxxxtbt=xhService.getlnsxxxtbt(mc);
			map.put("dataCount", lnsxxxtbt);
			map.put("param1", "nf106");
			map.put("title",mc+"历年升学人数同比图");
		}if("hyjymx".equals(reg)){//选中行业就业明细
			List<Object> hyjymx=xhService.gethyjymx(lb);
			map.put("dataCount", hyjymx);
			map.put("title" ,lb+"就业生明细");
			map.put("table", true);
		}if("xzhytbt".equals(reg)){//选中行业历年就业同比图
			List<Object> hyjytbt=xhService.getxzhytbt(lb);
			map.put("dataCount", hyjytbt);
			map.put("param1", "nf105");
			map.put("title",lb+"历年就业同比图");
		}if("dkjyxsmx".equals(reg)){//对口就业生明细
			List<Object> dkjyxsmx=xhService.getdkjyxsmx(nf,zymc);
			map.put("dataCount", dkjyxsmx);
			map.put("title",nf+zymc+"对口就业生明细");
			map.put("table", true);
		}
		if("xszxxx".equals(reg)){
//			for (Permis permis : list) {
//				System.out.println(permis);
//				if(permis.getRemark().equals("/zxxx")){
//				map.clear();
			//学生年级
	    	 List<TjCount> stunj=xhService.stunj();
	    	 map.put("stunj", stunj);
			//校内职业培训各项目总学时饼图
			List<Object> xnzypxgxmxs=xhService.getxnzypxgxmxs(nf);
			map.put("xnzypxgxmxs", xnzypxgxmxs);
			//学生流失变化图
			List<Object> stulsbht=xhService.getxslsbht(nf);
			//毕业生专业
			List<TjCount> getbyszy1 = xhService.getbyszy1();
			map.put("stulsbht", stulsbht);
			map.put("getbyszy1", getbyszy1);
			//学生流失原因排序
			List<Object> xslsyypx=xhService.getxslsyypx();
			map.put("xslsyypx", xslsyypx);
			//学生资格证书获取数量同比图
			List<Object> xszgzshqsl=xhService.getxszgzshqsl(zymc);
			map.put("xszgzshqsl", xszgzshqsl);
			//各年级学生人数
			List<Object> gnjxssl=xhService.getgnjxxsl(zymc);
			map.put("gnjxssl", gnjxssl);
			//文化课考试结果分布图
			List<Object> whkkscj=xhService.getwhkkscj(zymc,nf);
			map.put("whkkscj", whkkscj);
			//专业课考试成绩分布图
			List<Object> zykkscj=xhService.getzykkscj(zymc,nf);
			map.put("zykkscj", zykkscj);
			//地区列表
			List<TjCount> dqlist=xhService.getdqlist();
			map.put("dqlist", dqlist);
			//学生资助费用同比图(分专业，年分，地区)
			List<Object> xszzfytbt=xhService.getxszzfytbt(zymc,dqmc);
			map.put("xszzfytbt", xszzfytbt);
			//体检合格率
			List<Object> tjhgl=xhService.gettjhgl(zymc);
			map.put("tjhgl", tjhgl);
			//体能合格率
			List<Object> tnhgl=xhService.gettnhgl(zymc);
			map.put("tnhgl", tnhgl);
			//受资助学生分布图（分学生成绩）
			List<Object> szzxsfb=xhService.getszzxsfb(dg);
			map.put("szzxsfb", szzxsfb);
			/************************满意度调查*******************************/
			//学生学习满意度同比图
			List<Object> xsxxmydtbt=xhService.getxsxxmydtbt1();
			map.put("xsxxmydtbt", xsxxmydtbt);
			//实习实训满意度
			List<Object> sxsxmyd=xhService.getsxsxmydtbt();
			map.put("sxsxmyd", sxsxmyd);
			//校园文化与活动满意度同比图
			List<Object> xywhhdmyd=xhService.getxywhhdmyd();
			map.put("xywhhdmyd", xywhhdmyd);
			//校园生活满意度
			List<Object> xyshmyd=xhService.getxyshmyd();
			map.put("xyshmyd", xyshmyd);
			//校园安全满意度
			List<Object> xyaqmyd=xhService.getxyaqmyd();
			map.put("xyaqmyd", xyaqmyd);
			//毕业生对校园安全满意度
			List<Object> bysxyaqmyd=xhService.getbysxyaqmyd();
			map.put("bysxyaqmyd", bysxyaqmyd);
			/*************竞赛获奖***********************/
			//国家级同比图
			List<Object> gjjtbt=xhService.getgjjgtbt();
			map.put("gjjtbt", gjjtbt);
			//省级同比图
			List<Object> shengjjtbt=xhService.getshengjjtbt();
			map.put("shengjjtbt", shengjjtbt);
			//市家级同比图
			List<Object> shijjtbt=xhService.getshijjtbt();
			map.put("shijjtbt", shijjtbt);
			//其他获奖同比图
			List<Object> qtjtbt=xhService.getqtjtbt();
			map.put("qtjtbt", qtjtbt);
//				}
//				else{
//					map.put("code","403");
//				}
//			}
		}if("bysxxmydmx".equals(reg)){//毕业生对学校满意度明细
			List<Object> bysxxmydmx = xhService.getbysxxmydmx(nf);
			map.put("dataCount", bysxxmydmx);
			map.put("title",nf+"毕业生对学校满意度明细");
			map.put("table", true);	
		}if("xyaqmydmx".equals(reg)){//校园安全满意度明细
			List<Object> xyaqmydmx = xhService.getxsxymydmx(nf);
			map.put("dataCount", xyaqmydmx);
			map.put("title",nf+"校园安全满意度明细");
			map.put("table", true);	
		}if("xywhhdmydmx".equals(reg)){//校园文化活动满意度明细
			List<Object> xyaqmydmx = xhService.getxsxymydmx(nf);
			map.put("dataCount", xyaqmydmx);
			map.put("title",nf+"校园文化与活动满意度明细");
			map.put("table", true);	
		}if("xyshdmydmx".equals(reg)){//校园生活满意度明细
			List<Object> xyaqmydmx = xhService.getxsxymydmx(nf);
			map.put("dataCount", xyaqmydmx);
			map.put("title",nf+"校园生活满意度明细");
			map.put("table", true);	
		}if("xzszzxslnsl".equals(reg)){//选中受资助学生历年数量同比图
			List<Object> xzszzxslnsl = xhService.xzszzxslnsl(dqmc);
			map.put("dataCount", xzszzxslnsl);
			map.put("title",dqmc+"受资助学生历年数量同比图");
			map.put("param1", "nf305");	
		}if("xzszzxsmx".equals(reg)){//选中年分地区受资助学生明细
			List<Object> szzxsmx=xhService.getszzxsmx(nf,null,dqmc);
			map.put("dataCount", szzxsmx);
			map.put("title",nf+dqmc+"受资助学生明细");
			map.put("table", true);	
		}if("xxhjxxmx".equals(reg)){//选中学校获奖明细
			List<Object> xxhjxxmx = xhService.getxxhjxxmx(nf, lb);
			map.put("dataCount", xxhjxxmx);
			map.put("title",nf+lb+"获奖明细");
			map.put("table", true);	
		}if("xsxxmydmx".equals(reg)){//学生学习满意度明细
			List<Object> getxsxxmydmx = xhService.getxsxxmydmx(nf, null);
			map.put("dataCount", getxsxxmydmx);
			map.put("title",nf+"年学生学习满意度明细");
			map.put("table", true);	
		}if("tjhglmx".equals(reg)){//体检/体能合格学生明细
			List<Object> tjhglmx=xhService.gettjhglmx(nf,zymc);
			map.put("dataCount", tjhglmx);
			map.put("title",nf+zymc+"体质检查合格学生明细");
			map.put("table", true);	
		}if("szzxsmx".equals(reg)){//选定年分专业地区受资助学生明细
			List<Object> szzxsmx=xhService.getszzxsmx(nf,zymc,dqmc);
			map.put("dataCount", szzxsmx);
			map.put("title",nf+zymc+dqmc+"受资助学生明细");
			map.put("table", true);	
		}if("whkksmx".equals(reg)){//文化课考试明细
			List<Object> whkksmx=xhService.getwhkksmx(nf,zymc,dg);
			map.put("dataCount", whkksmx);
			map.put("title",nf+zymc+"文化课考试成绩明细");
			map.put("table", true);	
		}if("zykksmx".equals(reg)){//专业课考试明细
			List<Object> zykksmx=xhService.getzykksmx(nf,zymc,dg);
			map.put("dataCount", zykksmx);
			map.put("title",nf+zymc+"专业课考试成绩明细");
			map.put("table", true);	
		}if("xdnjmx".equals(reg)){//选定年级专业学生明细
			List<Object> xdnjmx=xhService.getxdnjmx(nf,zymc);
			map.put("dataCount", xdnjmx);
			map.put("title",nf+zymc+"学生明细");
			map.put("table", true);	
		}if("lnlsyytbt".equals(reg)){//选定流失原因同比图
			List<Object> lnlsyytbt=xhService.getlnlsyytbt(mc);
			map.put("dataCount", lnlsyytbt);
			map.put("title",mc+"历年流失原因同比变化图图");
			map.put("param1", "nf290");			
		}if("xslsmx".equals(reg)){//流失学生明细
			List<Object> xslsmx=xhService.getxslsmx(nf,mc);
			map.put("dataCount", xslsmx);
			map.put("title",nf+mc+"学生流失原因明细");
			map.put("table", true);	
		}if("xzxmlnpxtbt".equals(reg)){//选中项目历年总学时同比图
			List<Object> xzxmlnpxtbt=xhService.getxzxmlnpxtbt(mc);
			map.put("dataCount", xzxmlnpxtbt);
			map.put("title",nf+mc+"历年总学时同比图");
			map.put("param1", "nf279");			
		}if("xzxmmx".equals(reg)){//选中项目培训明细
			List<Object> xzxmmx=xhService.getxzxmmx(nf,mc);
			map.put("dataCount", xzxmmx);
			map.put("title",nf+mc+"项目培训明细");
			map.put("table", true);		
		}if("xjryqkfx".equals(reg)){//人员情况分析
//			for (Permis permis : list) {
//				System.out.println(permis);
//				if(permis.getRemark().equals("/ryqk")&&permis.getRemark().equals("/ryqk")){
//				map.clear();
			//教师专业
			List<TjCount> getjszylist = xhService.getjszylist();
			map.put("getjszylist", getjszylist);
			//学年
			List<TjCount> stunj = xhService.stunj();
			map.put("stunj", stunj);
			//教师年龄分布同比柱状图（分专业、分学年）
			List<Object> jsagefb=xhService.getjsagefb(nf,zymc);
			map.put("jsagefb", jsagefb);
			//教师职称分布饼图
			List<Object> jszcfbtb=xhService.getjszcfbbt();
			map.put("jszcfbtb", jszcfbtb);
			//教师学历分布饼图
			List<Object> jsxlfb=xhService.getjsxlfb();
			map.put("jsxlfb", jsxlfb);
			//技、管、工类型教师数量同比图（堆积柱状图，专业）
			List<Object> gjgjssldjt=xhService.getgjgjssldjt(zymc);
			map.put("gjgjssldjt", gjgjssldjt);
			//技、管、工类型教师数量同比图（堆积柱状图，专业）
			List<Object> gjgjsbldjt=xhService.gjgjsbldjt(zymc);
			map.put("gjgjsbldjt", gjgjsbldjt);
			//编制内/外的数量同比图
			List<Object> bznwjssltbt=xhService.getbznwjssl(zymc);
			map.put("bznwjssltbt", bznwjssltbt);
			//编制内/外的比例同比图
			List<Object> bznwjsbltbt=xhService.getbznwjsbl(zymc);
			map.put("bznwjsbltbt", bznwjsbltbt);
			//专兼职教师数量堆积图（分专业）
			List<Object> zjzjssldjt=xhService.getzjzjssldjt(zymc);
			map.put("zjzjssldjt", zjzjssldjt);
			//专兼职教师比例堆积图（分专业）
			List<Object> zjzjsbldjt=xhService.getzjzjsbldjt(zymc);
			map.put("zjzjsbldjt", zjzjsbldjt);
			//教师资格证书执证者比例同比图（分专业）
			List<Object> jszgzsbltbt=xhService.getjszgzsbltbt(zymc);
			map.put("jszgzsbltbt", jszgzsbltbt);
			//师生比同比变化图（分专业）
			List<Object> ssbtbbht=xhService.getssbtbbht(zymc);
			map.put("ssbtbbht", ssbtbbht);
			//教师企业工作经验分布图（横轴工作年数区域，分学年、专业）
			List<Object> jscjgzns=xhService.getjscjgzns(nf,zymc);
			map.put("jscjgzns", jscjgzns);
			//教师人均培训课时同比变化图（分专业）
			List<Object> jsrjpxks=xhService.getjsrjpxkstbt(zymc);
			map.put("jsrjpxks", jsrjpxks);
			//教师科研课题申报数量同比图（分专业）
			List<Object> jskyktsl=xhService.getjskyktsl(zymc);
			map.put("jskyktsl", jskyktsl);
			//具有专业技术职务的教师数量同比图
			List<Object> jyzyjszwsl=xhService.getjyzyjszwsl(zymc);
			map.put("jyzyjszwsl", jyzyjszwsl);
			//具有专业技术职务的教师比例同比图
			List<Object> jyzyjszwbl=xhService.getjyzyjszwbl(zymc);
			map.put("jyzyjszwbl", jyzyjszwbl);
			//具有职业资格证书的教师数量同比图（分专业）
			List<Object> jyzyzyzgzssl=xhService.getjyzyzyzgzssl(zymc);
			map.put("jyzyzyzgzsbl", jyzyzyzgzssl);
			//骨干教师数量同比图(分专业)
			List<Object> ggjssl=xhService.getggjssl(zymc);
			map.put("ggjssl", ggjssl);
			//骨干教师数量同比图(分专业)
			List<Object> ggjsbl=xhService.getggjsbl(zymc);
			map.put("ggjsbl", ggjsbl);
			//专业教师数量同比图（分专业）
			List<Object> zyjssl=xhService.getzyjssl(zymc);
			map.put("zyjssl", zyjssl);
			//教师人均企业实践时间
			List<Object> rjqysjsj=xhService.getrjqysjsj(zymc);
			map.put("rjqysjsj", rjqysjsj);
			//专业教师比例同比图（分专业）
			List<Object> zyjsbl=xhService.getxdzyjsbl(zymc);
			map.put("zyjsbl", zyjsbl);
			//双师型教师比例同比图（分专业）
			List<Object> ssxjsbl=xhService.getssxjsbl(zymc);
			map.put("ssxjsbl", ssxjsbl);
			//双师型教师比例同比图（分专业）
			List<Object> ssxjssl=xhService.getssxjssl(zymc);
			map.put("ssxjssl", ssxjssl);
			//教学名师比例同比图（分专业）
			List<Object> jxmsbltbt=xhService.getjxmsbltbt(zymc);
			map.put("jxmsbltbt", jxmsbltbt);
			//教学名师数量同比图（分专业）
			List<Object> jxmssltbt=xhService.getjxmssltbt(zymc);
			map.put("jxmssltbt", jxmssltbt);
			//获奖教师专业部门
			List<TjCount> hjjsbm=xhService.gethjjsbm();
			map.put("hjjsbm", hjjsbm);
			//教师获奖人数统计（横轴为获奖级别，分专业学年）
			List<Object> jshjrstj=xhService.getjshjrstj(nf,zymc);
			map.put("jshjrstj", jshjrstj);
//				}
//				else{
//					map.put("code","403");
//				}
//			}
		}if("jshjmx".equals(reg)){//教师获奖明细
			List<Object> jshjmx=xhService.getjshjmx(nf,zymc);
			map.put("dataCount", jshjmx);
			map.put("title",nf+zymc+"教师获奖明细");
			map.put("table", true);
		}if("jxmsmx".equals(reg)){//教学名师明细表
			List<Object> jxmsmx=xhService.getjxmsmx(nf,zymc);
			map.put("dataCount", jxmsmx);
			map.put("title",nf+zymc+"教学名师明细");
			map.put("table", true);
		}if("ggjsmx".equals(reg)){//选定骨干教师明细同比图
			List<Object> ggjsmx=xhService.getggjsmx(nf,zymc);
			map.put("dataCount", ggjsmx);
			map.put("title",nf+zymc+"骨干教师明细");
			map.put("table", true);
		}if("jyzyjszwzmx".equals(reg)){//选中专业年份具有专业技术职务者明细
			List<Object> jyzyjszwzmx=xhService.getjyzyjszwzmx(nf,zymc);
			map.put("dataCount", jyzyjszwzmx);
			map.put("title",nf+zymc+"具有专业技术职务教师明细");
			map.put("table", true);				
		}if("xzktmx".equals(reg)){//选中教师课题明细
			List<Object> xzktmx=xhService.getxzktmx(nf,zymc);
			map.put("dataCount", xzktmx);
			map.put("title",nf+zymc+"教师申报课题明细");
			map.put("table", true);				
		}if("jspxksmx".equals(reg)){//选中教师培训课时数明细
			List<Object> jspxksmx=xhService.getjspxksmx(nf,zymc);
			map.put("dataCount", jspxksmx);
			map.put("title",nf+zymc+"教师培训课时数明细");
			map.put("table", true);	
		}if("jsgzsjmx".equals(reg)){//选中教师工作时间明细
			List<Object> jsgzsjmx=xhService.getjsgzsjmx(nf,zymc,dg);
			map.put("dataCount", jsgzsjmx);
			map.put("title",nf+zymc+"教师工作时间明细");
			map.put("table", true);	
		}if("xzczzmx".equals(reg)){//选中教师资格证执证者明细
			List<JzgEntity> xzczzmx = xhService.getxzczzmx(nf,zymc);
			map.put("dataCount", xzczzmx);
			map.put("title",nf+zymc+"教师资格证执证者明细");
			map.put("table", true);			
		}if("gjgjsmx".equals(reg)){//选中年分专业管技工明细
			List<JzgEntity> getxdjsxlmx = xhService.getxdjsxlmx(nf, zymc);
			map.put("jsagefb", getxdjsxlmx);
			map.put("title",nf+zymc+"教师明细");
			map.put("table", true);				
		}if("xzxlsltbt".equals(reg)){//选中学历历年数量同比图
			//教师专业
			List<TjCount> jszylist = xhService.getjszylist();
			map.put("jszylist", jszylist);
			List<Object> xzxlsltbt=xhService.getxzxlsltbt(zymc,dg);
			map.put("dataCount", xzxlsltbt);
			map.put("title",zymc+"选中职称历年数量同比图");
			map.put("param1", "nf308");	
		}if("xzzynfxlmx".equals(reg)){//选中专业年分教师学历明细
			List<Object> xzzynfxlmx=xhService.xzzynfxlmx(nf,zymc,dg);
			map.put("jsagefb", xzzynfxlmx);
			map.put("title",nf+zymc+dg+"教师明细");
			map.put("table", true);	
		}if("xzzclnsltbt".equals(reg)){//选中职称历年数量同比图
			//教师专业
			List<TjCount> getjszylist = xhService.getjszylist();
			map.put("jszylist", getjszylist);
			List<Object> xzzclnsltbt=xhService.getxzzclnsltbt(zymc,dg);
			map.put("dataCount", xzzclnsltbt);
			map.put("title",zymc+"选中职称历年数量同比图");
			map.put("param1", "nf306");	
		}if("xzjszcmx".equals(reg)){//选中年分专业教师职称明细
			List<Object> xzjszcmx=xhService.xzjszcmx(nf,zymc,dg);
			map.put("jsagefb", xzjszcmx);
			map.put("title",nf+zymc+dg+"教师明细");
			map.put("table", true);		
		}if("xzjsagemx".equals(reg)){//选中年分专业教师年龄明细
			List<Object> xzjsagemx=xhService.xzjsagemx(nf,zymc,aged);
			map.put("jsagefb", xzjsagemx);
			map.put("title",nf+zymc+"教师年龄明细");
			map.put("table", true);		
		}if("gzyxssl".equals(reg)){
			//各专业学生数量柱形图
			List<Object> zgzyxssl = xhService.getStuCount2();//各专业在校生数量
			map.put("dataCount", zgzyxssl);
			map.put("title", "各专业学生数量柱形图");
			map.put("param1", "nf2210");
		}if("zzzgdbxln".equals(reg)){
			//中职诊改点
//			for (Permis permis : list) {
//				System.out.println(permis);
//				if(permis.getRemark().equals("/zgd")){
//				map.clear();
			/*******************************办学定位*********************************/
			//在校生总数
			TjCount zxszsl=xhService.getzxszsl();
			map.put("jsagefb", zxszsl);
			//升学、就业学生占比（饼图）
			List<Object> sxjyxszb=xhService.getsxjyxszb();
			map.put("sxjyxszb", sxjyxszb);
			//招生专业数量
			TjCount zszysl=xhService.getzszysl();
			map.put("zszysl", zszysl);
			//各专业学生数量柱形图
			List<TjCount> gzyxssl=xhService.getgzyxsslbt();
			map.put("gzyxssl", gzyxssl);
			//毕业生去向地区分布图
			List<Object> bysjydqfb=xhService.getbysjydqfb();
			map.put("bysjydqfb", bysjydqfb);
			//各类社会服务柱状图
			List<Object> glshfwsl=xhService.glshfwsl();
			map.put("glshfwsl", glshfwsl);
			/*******************************人才培养目标*******************************/
			//辍学学生比例
			TjCount cxxsbl=xhService.getcxxsbl();
			map.put("cxxsbl", cxxsbl);
			//应届毕业生双证获取率
			TjCount yjbysszhql=xhService.getyjbysszhql();
			map.put("yjbysszhql", yjbysszhql);
			//应届生就业率
			TjCount bysjyl=xhService.getzjjyl();
			map.put("bysjyl", bysjyl);
			//应届毕业生对口就业率
			TjCount bysdkjyl=xhService.getbysdkjyl();
			map.put("bysdkjyl", bysdkjyl);
			//上届毕业生满意度
			TjCount sjbysmyd=xhService.getsjbysmyd();
			map.put("sjbysmyd", sjbysmyd);
			/*********************************素质教育***************************/
			//德育工作机构一览表
			List<Object> dygzjg=xhService.getdygzjg();
			map.put("dygzjg", dygzjg);
			//德育课程开设一览表
			List<Object> dykcksylb=xhService.getdykcylb();
			map.put("dykcksylb", dykcksylb);
			//德育工作队伍人数同比图
			List<Object> dygzdwtbt=xhService.getdygzdwtbt();
			map.put("dygzdwtbt", dygzdwtbt);
			//应届毕业生体质达标率
			TjCount yjstzdbl=xhService.getyjstzdbl();
			map.put("yjstzdbl", yjstzdbl);
			//当年学生实际违纪率
			TjCount xxsjwjl=xhService.getxxsjwjl();
			map.put("xxsjwjl", xxsjwjl);
			//当年创新教学建设成果一览表
		    List<Object> cxjxjscg=xhService.getcxjxjscg();
		    map.put("cxjxjscg", cxjxjscg);
			//已建成素质教育标志性成果一览表
		    List<Object> szjybzxcg=xhService.getszjybzxcg();
		    map.put("szjybzxcg", szjybzxcg);
			//社会实践活动开设情况技成果一览表
		    List<Object> shsjhdcg=xhService.getshsjhdcg();
		    map.put("shsjhdcg", shsjhdcg);
		/*************************2.教学工作状态**********************************/
			/*************2.1专业建设状态*************/
			//新设、停招、撤销专业名单
			List<Object> bdzymx=xhService.getbdzymd();
			map.put("bdzymx", bdzymx);
			//各专业在校学生数量
			List<TjCount> gzyxsslbt = xhService.getgzyxsslzzt();
			map.put("gzyxsslbt", gzyxsslbt);
			//各专业录取数柱状图
			List<Object> gzylqszzt=xhService.getgzylqzzt();
			map.put("gzylqszzt", gzylqszzt);
			//就业率低于省内同类专业平均值专业占比
			TjCount zydypjzzb=xhService.getjyldysnpjz();
			map.put("zydypjzzb", zydypjzzb);
			//专业建设标志性成果一览表
			List<Object> zyjsbzxcg=xhService.zyjsbzxcg();
		    map.put("zyjsbzxcg", zyjsbzxcg);
		    /*************2.2课程建设状态***************/
		    //完成课程建设项目数
		    TjCount wckcjsxms=xhService.wckcjsxms();
		    map.put("wckcjsxms", wckcjsxms);
		    //已制定课程标准数
		    TjCount yzdkcbzs=xhService.yzdkcbzs();
		    map.put("yzdkcbzs", yzdkcbzs);
			//校企合作开发课程数
		    TjCount xqkfkcs=xhService.xqkfkcs();
		    map.put("xqkfkcs", xqkfkcs);
		    //校企合作开发教材数
		    TjCount xqkfjcs=xhService.xqkfjcs();
		    map.put("xqkfjcs", xqkfjcs);
		    //课程建设标志性成果一览表
		    List<Object> kcjsbzxcgylb=xhService.kcjsbzxcgylb();
		    map.put("kcjsbzxcgylb", kcjsbzxcgylb);
		    //规划教材使用比
		    TjCount ghjcsyb=xhService.getghjcsyb();
		    map.put("ghjcsyb", ghjcsyb);
		    //校本教材开发数量
		    TjCount jbjcsyb=xhService.getjbjcsyb();
		    map.put("jbjcsyb", jbjcsyb);
		    /***************2.3课堂教学与实践教学状态**********************/
		    //领导听课。听说课人均次数
		    TjCount ldtskrjsl=xhService.ldtskrjsl();
		    map.put("ldtskrjsl", ldtskrjsl);
		    //领导深入实践场所人均次数
		    TjCount ldrssjcssl=xhService.ldrssjcssl();
		    map.put("ldrssjcssl", ldrssjcssl);
		    //同行评教覆盖面
		    TjCount thpjfgm=xhService.thpjfgm();
		    map.put("szdwzcft", thpjfgm);
		    //学生评教覆盖面
		    TjCount xspjylb=xhService.xspjylb();
		    map.put("xspjylb", xspjylb);
		    //社会评教覆盖面
		    TjCount shpjylb=xhService.shpjylb();
		    map.put("shpjylb", shpjylb);
		    
		    //实践项目开出率
		    TjCount sjxmkcl=xhService.sjxmkcl();
		    map.put("sjxmkcl", sjxmkcl);
		    //校党政联席会议解决的教学问题数量
		    TjCount xdzlxjjwtsl=xhService.xdzlxjjwtsl();
		    map.put("xdzlxjjwtsl", xdzlxjjwtsl);
		    //教学事故数量
		    TjCount jxsgsl=xhService.getjxsgsl();
		    map.put("jxsgsl", jxsgsl);
		    //学生迟到率
		    TjCount xscdl=xhService.xscdl();
		    map.put("xscdl", xscdl);
		    //学生缺课率
		    TjCount xsqkl=xhService.xsqkl();
		    map.put("xsqkl", xsqkl);
		    /****************************************3.师资队伍建设状态*****************************/
		    
		    /********************3.1专任教师队伍建设状态*****************/
		    //师资队伍数量
		    TjCount szdwsl=xhService.getszdwsl();
		    map.put("szdwsl", szdwsl);
		    //教师专业
			List<TjCount> getjszylist = xhService.getjszylist();
			map.put("getjszylist", getjszylist);
		    //师资队伍数量（按年龄分布，分专业）
		    List<Object> szdwslnlft=xhService.getszdwslnlft(zymc);
		    map.put("szdwslnlft", szdwslnlft);
		    //师资队伍数量（按职称分布，分专业）
		    List<Object> szdwzcft=xhService.getszdwzcft(zymc);
		    map.put("szdwzcft", szdwzcft);
		    //师资队伍数量（按工作年限分布，分专业）
		    List<Object> szdwgznfft=xhService.szdwgznfft(zymc);
		    map.put("szdwgznfft", szdwgznfft);
		    //师资队伍数量（按学历分布，分专业）
		    List<Object> szdwgxlft=xhService.szdwgxlft(zymc);
		    map.put("szdwgxlft", szdwgxlft);
		    //专业带头人和骨干教师数量
		    TjCount zydtrggjssl=xhService.zydtrggjssl();
		    map.put("zydtrggjssl", zydtrggjssl);
		    //教师培训类型与数量一览表
		    List<Object> jspxlxslylb=xhService.jspxlxslylb();
		    map.put("jspxlxslylb", jspxlxslylb);
		    //各专业教师数量一览表
		    List<Object> gzyjsslylb=xhService.gzyjsslylb();
		    map.put("gzyjsslylb", gzyjsslylb);
		    //教师教研、科研、技术开发和社会服务成果一览表
		    List<Object> jsjykyylb=xhService.jsjykyylb();
		    map.put("jsjykyylb", jsjykyylb);
		    //外籍教师数量
		    TjCount wjjssl=xhService.wjjssl();
		    map.put("wjjssl", wjjssl);
		    //教师企业实践情况一览表
		    List<Object> jsqysjqkylb=xhService.jsqysjqkylb();
		    map.put("jsqysjqkylb", jsqysjqkylb);
		    //专任教师"双师型"比例
		    TjCount ssxjsbl=xhService.getzrjsssxjsbl();
		    map.put("ssxjsbl", ssxjsbl);
		    //实践教学专职指导教师数量
		    TjCount sjjxzzzdjssl=xhService.sjjxzzzdjssl();
		    map.put("sjjxzzzdjssl", sjjxzzzdjssl);
		    /**********************兼职教师队伍建设***************/
		    //兼职师资队伍数量
		    TjCount jzszdwsl=xhService.jzszdwsl();
		    map.put("jzszdwsl", jzszdwsl);
		    //兼职师资队伍数量（按年龄分布，分专业）
		    List<Object> jzszdwslnlft=xhService.jzszdwslnlft(zymc);
		    map.put("jzszdwslnlft", jzszdwslnlft);
		    //兼职师资队伍数量（按职称分布，分专业）
		    List<Object> jzszdwzcft=xhService.jzszdwzcft(zymc);
		    map.put("jzszdwzcft", jzszdwzcft);
		    //兼职师资队伍数量（按工作年限分布，分专业）
		    List<Object> jzszdwgznfft=xhService.jzszdwgznffb(zymc);
		    map.put("jzszdwgznfft", jzszdwgznfft);
		    //兼职师资队伍数量（按学历分布，分专业）
		    List<Object> jzszdwgxlft=xhService.jzszdwgxlft(zymc);
		    map.put("jzszdwgxlft", jzszdwgxlft);
		    //兼职专业带头人数量
		    TjCount jzzydtrggjssl=xhService.jzzydtrggjssl();
		    map.put("jzzydtrggjssl", jzzydtrggjssl);
		    //兼职教师培训数量
		    TjCount jzjspxsl=xhService.jzjspxsl();
		    map.put("jzjspxsl", jzjspxsl);
		    //兼职教师在专业中的配置数量一览表
		    List<Object> jzszdwzypz=xhService.jzszdwzypz();
		    map.put("jzszdwzypz", jzszdwzypz);
		    //兼职教师承担校内实践教学学时数量
		    TjCount jzjsxnsjxssl=xhService.jzjsxnsjxssl();
		    map.put("jzjsxnsjxssl", jzjsxnsjxssl);
		/**********************************资源建设状态******************************************/
		    /*****************教学投入及基础设施建设状态*********************/
		    //学校占地面积
		    TjCount xxzdmj=xhService.getxxzzdmj();
		    map.put("xxzdmj", xxzdmj);
		    //学校建筑面积
		    TjCount xxjzmj=xhService.getxxzjzmj();
		    map.put("xxjzmj", xxjzmj);
		    //校内实践教学基地数量
		    TjCount xnsjjdsl=xhService.xnsjjdsl();
		    map.put("xnsjjdsl", xnsjjdsl);
		    //校内实践教学基地建筑面积
		    TjCount xnsjjdzdmj=xhService.xnsjjdzdmj();
		    map.put("xnsjjdzdmj", xnsjjdzdmj);
		    //校内实践教学基地生均教学仪器设备值
		    TjCount xnsjjdsjsbz=xhService.xnsjjdsjsbz();
		    map.put("xnsjjdsjsbz", xnsjjdsjsbz);
		    //校外实践教学基地数量
		    TjCount xwsjjdsl=xhService.xwsjjdsl();
		    map.put("xwsjjdsl", xwsjjdsl);
		    //日常教学经费投入比例
		    TjCount rcjxjftr=xhService.rcjxjftr();
		    map.put("rcjxjftr", rcjxjftr);
		    //教科研经费、教学改革经费预算执行情况一览表
		    List<Object> jyfsjxjfyszxylb=xhService.jyfsjxjfyszxylb();
		    map.put("jyfsjxjfyszxylb", jyfsjxjfyszxylb);
		    /*************教学资源建设状态***************/
		    //纸质图书总量
		    TjCount zztszs=xhService.zztszs();
		    map.put("zztszs", zztszs);
		    //当年新增纸质图书数量
		    TjCount dnxzzztssl=xhService.dnxzzztssl();
		    map.put("dnxzzztssl", dnxzzztssl);
		    //当年电子图书总量
		    TjCount dndztssl=xhService.dndztssl();
		    map.put("dndztssl", dndztssl);
		    //专业教学资源库等级、类型、数量一览表
		    List<Object> zyjxzykylb=xhService.zyjxzykylb();
		    map.put("zyjxzykylb", zyjxzykylb);
		    //校本数据采集、管理与使用情况一览表
		    List<Object> jbsjcjylb=xhService.jbsjcjylb();
		    map.put("jbsjcjylb", jbsjcjylb);
		    /*******************************5.制度建设与运行状态*********************************/
		    /*****************校企合作状态******************/
		    //专业覆盖面情况一览表
		    List<Object> zyfgmylb=xhService.zyfgmylb();
		    map.put("zyfgmylb", zyfgmylb);
		    //当年合作企业数量
		    TjCount dnhzqysl=xhService.dnhzqysl();
		    map.put("dnhzqysl", dnhzqysl);
		    //接受顶岗实习学生比例
		    List<Object> jsdgsxxsbl=xhService.jsdgsxxsbl();
		    map.put("jsdgsxxsbl", jsdgsxxsbl);
		    //录用应届毕业生比例
		    List<Object> lyyjbysbl=xhService.lyyjbysbl();
		    map.put("lyyjbysbl", lyyjbysbl);
		    //企业捐赠金额
		    TjCount qyjzje=xhService.qyjzje();
		    map.put("qyjzje", qyjzje);
		    //企业输送兼职教师数量
		    TjCount qyssjzjssl=xhService.qyssjzjssl();
		    map.put("qyssjzjssl", qyssjzjssl);
		    //企业接受教师企业实践情况一览表
		    List<Object> qyjsjsqysj=xhService.qyjsjsqysj();
		    map.put("qyjsjsqysj", qyjsjsqysj);
		    //校企合作研发成果一览表
		    List<Object> xqhzyfcg=xhService.xqhzyfcg();
		    map.put("xqhzyfcg", xqhzyfcg);
		    /*************5.2学校管理制度建设与运行状态*************/
		    //学校章程一览
		    //学校内部治理结构图
		    //学校规章制度列表
		    List<Object> xxgzzdlb=xhService.xxgzzdlb();
		    map.put("xxgzzdlb", xxgzzdlb);
		    //管理制度执行情况
		    //校园卫生与安全情况
		    //学校依法办学情况
		    //教学及学生管理人员数量
		    TjCount jxjxsglry=xhService.jxjxsglry();
		    map.put("jxjxsglry", jxjxsglry);
		    
		    /*********************5.3质量监控状态**********************/
		    //质量保证制度列表
		    List<Object> zlbzdlb=xhService.getzlbzzdyl();
		    map.put("zlbzdlb", zlbzdlb);
		    //质量保证组织体系一览图
		    //年度自我诊改报告
		    //年度质量报告
		    //年度督导工作总结
		    //学校数据上传时间与质量
		    //评教覆盖面一览表
		    
		    /*****************************************6.需求方反馈********************************************/
		    /************************6.1学生反馈************************/
		    //在校生满意度调查结果
		    List<Object> zxsmyddcjg=xhService.getzxsmyddcjg();
		    map.put("zxsmyddcjg", zxsmyddcjg);
		    //毕业生跟踪调查结果
		    List<Object> bysgzdcjg=xhService.getbysgzdcjg();
		    map.put("bysgzdcjg", bysgzdcjg);
		    /*****************6.2用人方反馈*******************/
		    //上届毕业生对口率
		    TjCount sjbysdll=xhService.sjbysdll();
		    map.put("sjbysdll", sjbysdll);
		    //上届毕业生转岗率
		    TjCount sjbyszgl=xhService.sjbyszgl();
		    map.put("sjbyszgl", sjbyszgl);
		    //上届毕业生升迁率
		    TjCount sjbyssql=xhService.sjbyssql();
		    map.put("sjbyssql", sjbyssql);
		    //新生报考原因分析饼图
		    List<Object> bysbkyy=xhService.getbysbkyy();
		    map.put("bysbkyy", bysbkyy);
		    //用人单位对毕业生评价一览表
		    List<Object> yrdwdbysylb=xhService.yrdwdbysylb();
		    map.put("yrdwdbysylb", yrdwdbysylb);
		    /*****************6.3其他*******************/
		    //地市级以上评审项目结果一览表
		    List<Object> dsjxmysylb=xhService.dsjxmysylb();
		    map.put("dsjxmysylb", dsjxmysylb);
		    //职业技能鉴定机构对学生职业能力鉴定结果一览表
		    List<Object> zyjnjdjdxsjg=xhService.zyjnjdjdxsjg();
		    map.put("zyjnjdjdxsjg", zyjnjdjdxsjg);
		    //地市级以上教育行政部门项目评审结果一览表
		    List<Object> dsjjybmpsjg=xhService.dsjjybmpsjg();
		    map.put("dsjjybmpsjg", dsjjybmpsjg);
		    //地市级以上师生竞赛获奖情况一览表
		    List<Object> dsjssjshj=xhService.dsjssjshj();
		    map.put("dsjssjshj", dsjssjshj);
		    //地市级及以上人民政府表彰情况一览表
		    List<Object> rmzfbzylb=xhService.rmzfbzylb();
		    map.put("rmzfbzylb", rmzfbzylb);
//		}
//				else{
//					map.put("code","403");
//				}
//				}
		}if("jxjxsglrybt".equals(reg)){//教学及学生管理人员结构饼图	
			List<Object> jxjxsglrybt=xhService.jxjxsglrybt();
			map.put("dataCount", jxjxsglrybt);
			map.put("title","教学及学生管理人员结构饼图");
			map.put("type", "bt");	
			map.put("param1", "nf472");	
		}if("jxjxsglrymd".equals(reg)){//选中部分的人员名单
			List<Object> jxjxsglrymd=xhService.jxjxsglrymd(zymc);
			map.put("dataCount", jxjxsglrymd);
			map.put("title",zymc+"人员名单");
			map.put("table", true);	
		}if("jdpxxssl".equals(reg)){//选定专业基地培训学生数量明细
			List<Object> jdpxxssl=xhService.jdpxxssl(zymc);
			map.put("dataCount", jdpxxssl);
			map.put("title",zymc+"专业基地培训学生数量明细");
			map.put("table", true);	
		}if("lnsjbyssql".equals(reg)){//上届毕业生升迁率同比图	
			List<Object> lnsjbyssql=xhService.lnsjbyssql();
			map.put("dataCount", lnsjbyssql);
			map.put("title","上届毕业生升迁率同比图");
			map.put("param1", "nf470");	
		}if("sjbyszgltbt".equals(reg)){//毕业生转岗率同比图	
			List<Object> lnsjbyszgl=xhService.lnsjbyszgl();
			map.put("dataCount", lnsjbyszgl);
			map.put("title","毕业生转岗率同比图");
			map.put("param1", "nf468");	
		}if("bysdkltbt".equals(reg)){//毕业生对口率同比图	
			List<Object> lnbysdkl=xhService.lnbysdkl();
			map.put("dataCount", lnbysdkl);
			map.put("title","毕业生对口率同比图");
			map.put("param1", "nf466");	
		}if("lnqyssjzjssl".equals(reg)){//企业输送兼职教师数量同比图	
			List<Object> lnqyssjzjssl=xhService.lnqyssjzjssl();
			map.put("dataCount", lnqyssjzjssl);
			map.put("title","企业输送兼职教师数量同比图");
			map.put("param1", "nf464");	
		}if("qyssjzjsmd".equals(reg)){//企业输送兼职教师名单
			List<Object> qyssjzjsmd=xhService.qyssjzjsmd(nf);
			map.put("dataCount", qyssjzjsmd);
			map.put("title",nf+"企业输送兼职教师名单");
			map.put("table", true);	
		}if("qyjzjetbt".equals(reg)){//企业捐赠金额同比图	
			List<Object> lnqyjzje=xhService.lnqyjzje();
			map.put("dataCount", lnqyjzje);
			map.put("title","企业捐赠金额同比图");
			map.put("param1", "nf462");	
		}if("qyjzjemx".equals(reg)){//企业捐赠金额明细
			List<Object> qyjzjemx=xhService.qyjzjemx(nf);
			map.put("dataCount", qyjzjemx);
			map.put("title",nf+"企业捐赠金额明细");
			map.put("table", true);	
		}if("lyyjbysbltbt".equals(reg)){//录用应届毕业生比例同比图
			//顶岗学生专业
			List<TjCount> dgsxzy=xhService.getdgsxzy();
			map.put("dgsxzy", dgsxzy);
			List<Object> lnlyyjbysbl=xhService.lnlyyjbysbl(mc,zymc);
			map.put("dataCount", lnlyyjbysbl);
			map.put("title",mc+zymc+"录用应届毕业生比例同比图");
			map.put("param1", "nf460");	
		}if("lyyjbysmd".equals(reg)){//接受顶岗实习学生名单
			List<Object> lyyjbysmd=xhService.lyyjbysmd(nf,zymc,mc);
			map.put("dataCount", lyyjbysmd);
			map.put("title",nf+mc+zymc+"录用应届毕业生名单");
			map.put("table", true);	
		}if("dgsxxsbltbt".equals(reg)){//接受顶岗实习学生比例同比图
			//顶岗学生专业
			List<TjCount> dgsxzy=xhService.getdgsxzy();
			map.put("dgsxzy", dgsxzy);
			List<Object> lndgsxxsbl=xhService.lndgsxxsbl(mc,zymc);
			map.put("dataCount", lndgsxxsbl);
			map.put("title",mc+zymc+"接受顶岗实习学生比例同比图");
			map.put("param1", "nf459");	
		}if("dgsxxsmd".equals(reg)){//接受顶岗实习学生名单
			List<Object> dgsxxsmd=xhService.dgsxxsmd(nf,zymc,mc);
			map.put("dataCount", dgsxxsmd);
			map.put("title",nf+mc+zymc+"接受顶岗实习学生名单");
			map.put("table", true);	
		}if("lnhzqysl".equals(reg)){//合作企业数量同比图（分专业）
			//顶岗学生专业
			List<TjCount> dgsxzy=xhService.getdgsxzy();
			map.put("dgsxzy", dgsxzy);
			List<Object> lnhzqysl=xhService.lnhzqysl(zymc);
			map.put("dataCount", lnhzqysl);
			map.put("title","合作企业数量同比图（分专业）");
			map.put("param1", "nf456");	
		}if("hzqymx".equals(reg)){//合作企业名单
			List<Object> hzqymx=xhService.hzqymx(nf,zymc);
			map.put("dataCount", hzqymx);
			map.put("title","合作企业名单");
			map.put("table", true);	
		}if("lndztssl".equals(reg)){//电子图书总量同比图
			List<Object> lndztssl=xhService.lndztssl();
			map.put("dataCount", lndztssl);
			map.put("title","电子图书总量同比图");
			map.put("param1", "nf454");	
		}if("dztsmx".equals(reg)){//新增纸质图书明细表
			List<Object> dztsmx=xhService.dztsmx(nf);
			map.put("dataCount", dztsmx);
			map.put("title","电子图书明细表");
			map.put("table", true);	
		}if("lnxzzztssl".equals(reg)){//当年新增纸质图书总量同比图
			List<Object> lnxzzztssl=xhService.lnxzzztssl();
			map.put("dataCount", lnxzzztssl);
			map.put("title","当年新增纸质图书总量同比图");
			map.put("param1", "nf450");	
		}if("xzzztsmx".equals(reg)){//新增纸质图书明细表
			List<Object> xzzztsmx=xhService.xzzztsmx(nf);
			map.put("dataCount", xzzztsmx);
			map.put("title","新增纸质图书明细表");
			map.put("table", true);	
		}if("zztszsltbt".equals(reg)){//纸质图书总量同比图
			List<TjCount> zztstbt=xhService.getzztstbt();
			map.put("dataCount", zztstbt);
		}if("rcjxjftrtbt".equals(reg)){//日常教学经费投入比例同比图
			List<Object> rcjxjftrtbt=xhService.rcjxjftrtbt();
			map.put("dataCount", rcjxjftrtbt);
			map.put("title","日常教学经费投入比例同比图");
			map.put("param1", "nf451");	
		}if("xwsjjdmx".equals(reg)){//校外实践教学基地明细表
			List<Object> xwsjjdmx=xhService.xwsjjdmx();
			map.put("dataCount", xwsjjdmx);
			map.put("title","校外实践教学基地明细表");
			map.put("table", true);	
		}if("xnsjjdmx".equals(reg)){//校内实践教学基地明细表
			List<Object> xnsjjdmx=xhService.xnsjjdmx();
			map.put("dataCount", xnsjjdmx);
			map.put("title","校内实践教学基地明细表");
			map.put("table", true);	
		}if("xxgjzmjylb".equals(reg)){//学校各建筑面积一览表
			List<Object> xxgjzmjylb=xhService.xxgjzmjylb();
			map.put("dataCount", xxgjzmjylb);
			map.put("title","学校各建筑面积一览表");
			map.put("table", true);	
		}if("jzjsxnsjxsmd".equals(reg)){//兼职教师承担校内实践教学学时名单
			List<Object> jzjsxnsjxsmd=xhService.jzjsxnsjxsmd(nf);
			map.put("dataCount", jzjsxnsjxsmd);
			map.put("title",nf+"兼职教师名单");
			map.put("table", true);	
		}if("jzjsxnsjxssltbt".equals(reg)){//兼职教师承担校内实践教学学时数量同比图
			List<Object> jzjsxnsjxssltbt=xhService.jzjsxnsjxssltbt();
			map.put("dataCount", jzjsxnsjxssltbt);
			map.put("title","兼职教师承担校内实践教学学时数量同比图");
			map.put("param1", "nf435");	
		}if("jzszdwzypzmd".equals(reg)){//兼职教师名单(分专业)
			List<Object> jzszdwzypzmd=xhService.jzszdwzypzmd(zymc);
			map.put("dataCount", jzszdwzypzmd);
			map.put("title",zymc+"兼职教师名单");
			map.put("table", true);	
		}if("jzjspxsltbt".equals(reg)){//兼职教师培训数量同比图
			List<Object> jzjspxsltbt=xhService.jzjspxsltbt();
			map.put("dataCount", jzjspxsltbt);
			map.put("title","兼职教师培训数量同比图");
			map.put("param1", "nf431");	
		}if("jzjspxmd".equals(reg)){//兼职教师培训名单
			List<Object> jzjspxmd=xhService.jzjspxmd(nf);
			map.put("dataCount", jzjspxmd);
			map.put("title",nf+"年兼职教师培训名单");
			map.put("table", true);	
		}if("jzzydtrggjstbt".equals(reg)){//兼职专业带头人数量同比图
			//教师专业
			List<TjCount> jszylist = xhService.getjszylist();
			map.put("jszylist", jszylist);
			List<Object> jzzydtrggjstbt=xhService.jzzydtrggjstbt(zymc);
			map.put("dataCount", jzzydtrggjstbt);
			map.put("title",zymc+"兼职专业带头人数量同比图");
			map.put("param1", "nf429");	
		}if("jzzydtrggjsmd".equals(reg)){//兼职专业带头人和骨干教师名单
			List<Object> jzzydtrggjsmd=xhService.jzzydtrggjsmd(nf,zymc);
			map.put("dataCount", jzzydtrggjsmd);
			map.put("title",nf+zymc+"兼职专业带头名单");
			map.put("table", true);	
		}if("jzszdwgxltbt".equals(reg)){//兼职师资队伍数量同比图(按学历分布)
			//教师专业
			List<TjCount> jszylist = xhService.getjszylist();
			map.put("jszylist", jszylist);
			List<Object> jzszdwgxltbt=xhService.jzszdwgxltbt(zymc,dg);
			map.put("dataCount", jzszdwgxltbt);
			map.put("title",zymc+"兼职师资队伍数量(按学历分布)同比图");
			map.put("param1", "nf427");	
		}if("jzszdwgxlmd".equals(reg)){//兼职师资队伍名单(按学历分布)
			List<Object> jzszdwgxlmd=xhService.jzszdwgxlmd(nf,zymc,dg);
			map.put("dataCount", jzszdwgxlmd);
			map.put("title",nf+zymc+"兼职师资名单(按学历分布)");
			map.put("table", true);	
		}if("jzjsgznftbt".equals(reg)){//兼职师资队伍数量同比图(按工作年限分布)
			//教师专业
			List<TjCount> jszylist = xhService.getjszylist();
			map.put("jszylist", jszylist);
			List<Object> jzjsgznftbt=xhService.jzjsgznftbt(zymc,dg);
			map.put("dataCount", jzjsgznftbt);
			map.put("title",zymc+"兼职师资队伍数量(按工作年限分布)同比图");
			map.put("param1", "nf425");	
		}if("jzszgznfmd".equals(reg)){//兼职师资队伍名单(按工作年限分布)
			List<Object> jzszgznfmd=xhService.jzszgznfmd(nf,zymc,dg);
			map.put("dataCount", jzszgznfmd);
			map.put("title",nf+zymc+"兼职师资名单(按工作年限分布)");
			map.put("table", true);	
		}if("jzjszctbt".equals(reg)){//兼职师资队伍数量同比图(按职称)
			//教师专业
			List<TjCount> jszylist = xhService.getjszylist();
			map.put("jszylist", jszylist);
			List<Object> jzjszctbt=xhService.jzjszctbt(zymc,dg);
			map.put("dataCount", jzjszctbt);
			map.put("title",zymc+"兼职师资队伍数量(按职称)同比图");
			map.put("param1", "nf424");	
		}if("jzszzcmd".equals(reg)){//兼职师资队伍名单(按职称)
			List<Object> jzszzcmd=xhService.jzszzcmd(nf,zymc,dg);
			map.put("dataCount", jzszzcmd);
			map.put("title",nf+zymc+"兼职师资名单(按职称)");
			map.put("table", true);	
		}if("jzjsnltbt".equals(reg)){//兼职师资队伍数量同比图(按年龄)
			//教师专业
			List<TjCount> jszylist = xhService.getjszylist();
			map.put("jszylist", jszylist);
			List<Object> jzjsnltbt=xhService.jzjsnltbt(zymc,aged);
			map.put("dataCount", jzjsnltbt);
			map.put("title",zymc+"兼职师资队伍数量(按年龄)同比图");
			map.put("param1", "nf421");	
		}if("jzsznlmd".equals(reg)){//兼职师资队伍名单(按年龄)
			List<Object> jzsznlmd=xhService.jzsznlmd(nf,zymc,aged);
			map.put("dataCount", jzsznlmd);
			map.put("title",nf+zymc+"兼职师资名单(按年龄)");
			map.put("table", true);	
		}if("jzjssltbt".equals(reg)){//兼职师资队伍数量同比图
			//教师专业
			List<TjCount> jszylist = xhService.getjszylist();
			map.put("jszylist", jszylist);
			List<Object> jzjssltbt=xhService.jzjssltbt(zymc);
			map.put("dataCount", jzjssltbt);
			map.put("title",zymc+"兼职师资队伍数量同比图");
			map.put("param1", "nf419");	
		}if("jzszmd".equals(reg)){//兼职师资队伍名单
			List<Object> jzszmd=xhService.getjzszmd(nf,zymc);
			map.put("dataCount", jzszmd);
			map.put("title",nf+zymc+"兼职师资名单");
			map.put("table", true);	
		}
		/********************************************************************************/
		if("zzzdjssltbt".equals(reg)){//实践教学专职指导教师数量同比图（分专业）
			//教师专业
			List<TjCount> jszylist = xhService.getjszylist();
			map.put("jszylist", jszylist);
			List<Object> lnzzzdjssl=xhService.lnzzzdjssl(zymc);
			map.put("dataCount", lnzzzdjssl);
			map.put("title",zymc+"实践教学专职指导教师数量同比图");
			map.put("param1", "nf417");	
		}if("zzzdjsmd".equals(reg)){//实践教学专职指导教师名单
			List<Object> zzzdjsmd=xhService.zzzdjsmd(nf,zymc);
			map.put("dataCount", zzzdjsmd);
			map.put("title",nf+zymc+"实践教学专职指导教师名单");
			map.put("table", true);	
		}if("zrjsssxjsbltbt".equals(reg)){//专任教师"双师型教师"比例同比图
			//教师专业
			List<TjCount> jszylist = xhService.getjszylist();
			map.put("jszylist", jszylist);
			List<Object> zrjsssxjsbltbt=xhService.zrjsssxjsbltbt(zymc);
			map.put("dataCount", zrjsssxjsbltbt);
			map.put("title",zymc+"专任教师双师型教师比例同比图");
			map.put("param1", "nf416");	
		}if("zrjsssxjsmd".equals(reg)){//专任教师"双师型教师"名单
			List<Object> zrjsssxjsmd=xhService.zrjsssxjsmd(nf,zymc);
			map.put("dataCount", zrjsssxjsmd);
			map.put("title",nf+zymc+"专任教师双师型教师名单");
			map.put("table", true);	
		}if("jspxlxmd".equals(reg)){//培训人员名单
			List<Object> jspxlxmd=xhService.jspxlxmd(mc);
			map.put("dataCount", jspxlxmd);
			map.put("title",mc+"培训人员名单");
			map.put("table", true);	
		}if("lnzydtrggjs".equals(reg)){//专业带头人和骨干教师数量同比图
			//教师专业
			List<TjCount> jszylist = xhService.getjszylist();
			map.put("jszylist", jszylist);
			List<Object> lnzydtrggjs=xhService.lnzydtrggjs(zymc);
			map.put("dataCount", lnzydtrggjs);
			map.put("title",zymc+"专业带头人和骨干教师数量同比图");
			map.put("param1", "nf409");	
		}if("zydtrggjsmd".equals(reg)){//专业带头人和骨干教师名单
			List<Object> zydtrggjsmd=xhService.zydtrggjsmd(nf,zymc);
			map.put("dataCount", zydtrggjsmd);
			map.put("title",nf+zymc+"专业带头人和骨干教师名单");
			map.put("table", true);	
		}if("lnszdwxltbt".equals(reg)){//师资队伍学历数量同比图
			//教师专业
			List<TjCount> jszylist = xhService.getjszylist();
			map.put("jszylist", jszylist);
			List<Object> lnszdwxltbt=xhService.lnszdwxltbt(zymc,dg);
			map.put("dataCount", lnszdwxltbt);
			map.put("title",zymc+dg+"师资数量同比图");
			map.put("param1", "nf407");	
		}if("szdwxlmd".equals(reg)){//选中师资队伍学历名单
			List<Object> szdwxlmd=xhService.szdwxlmd(nf,zymc,dg);
			map.put("dataCount", szdwxlmd);
			map.put("title",nf+zymc+dg+"师资名单");
			map.put("table", true);	
		}if("xscdltbt".equals(reg)){//学生迟到率同比图
			List<Object> xscdltbt=xhService.xscdltbt();
			map.put("dataCount", xscdltbt);
			map.put("title","学生迟到率同比图");
			map.put("param1", "nf399");		
		}if("xscdmx".equals(reg)){//迟到学生明细
			List<Object> xscdmx=xhService.xscdmx(nf);
			map.put("dataCount", xscdmx);
			map.put("title",nf+"迟到学生明细");
			map.put("table", true);			
		}if("xsqkltbt".equals(reg)){//学生迟到率同比图
			List<Object> xsqkltbt=xhService.xsqkltbt();
			map.put("dataCount", xsqkltbt);
			map.put("title","学生迟到率同比图");
			map.put("param1", "nf400");		
		}if("xsqkmx".equals(reg)){//迟到学生明细
			List<Object> xsqkmx=xhService.xsqkmx(nf);
			map.put("dataCount", xsqkmx);
			map.put("title",nf+"迟到学生明细");
			map.put("table", true);			
		}if("lnjxsgtbt".equals(reg)){//教学事故数量同比图
			List<Object> lnjxsgsl=xhService.lnjxsgsl();
			map.put("dataCount", lnjxsgsl);
			map.put("title","校党政联席会议解决的教学问题数量同比图");
			map.put("param1", "nf397");		
		}if("jxsgmx".equals(reg)){//教学事故一览表
			List<Object> jxsgmx=xhService.jxsgmx(nf);
			map.put("dataCount", jxsgmx);
			map.put("title",nf+"校党政联席会议解决的教学问题一览表");
			map.put("table", true);			
		}if("xdzlxjjwtsltbt".equals(reg)){//校党政联席会议解决的教学问题数量同比图
			List<Object> lnxdzlxjjwtsl=xhService.lnxdzlxjjwtsl();
			map.put("dataCount", lnxdzlxjjwtsl);
			map.put("title","校党政联席会议解决的教学问题数量同比图");
			map.put("param1", "nf395");		
		}if("xdzlxjjwtmxt".equals(reg)){//校党政联席会议解决的教学问题一览表
			List<Object> xdzlxjjwtmxt=xhService.xdzlxjjwtmxt(nf);
			map.put("dataCount", xdzlxjjwtmxt);
			map.put("title",nf+"校党政联席会议解决的教学问题一览表");
			map.put("table", true);			
		}if("sjxmkcltbt".equals(reg)){//实践项目开出率同比图
			List<Object> sjxmkcltbt=xhService.sjxmkcltbt();
			map.put("dataCount", sjxmkcltbt);
			map.put("title","实践项目开出率同比图");
			map.put("param1", "nf392");		
		}if("sjxmkclylb".equals(reg)){//实践项目开出一览表
			List<Object> sjxmkclylb=xhService.sjxmkclylb(nf);
			map.put("dataCount", sjxmkclylb);
			map.put("title",nf+"实践项目开出一览表");
			map.put("table", true);			
		}if("thkcpjxj".equals(reg)){//同行课程评教小结表
			List<Object> thkcpjxj=xhService.thkcpjxj();
			map.put("dataCount", thkcpjxj);
			map.put("title","同行课程评教小结表");
			map.put("param1", "nf404");
			map.put("table", true);			
		}if("thkcpjpfr".equals(reg)){//同行评教名单
			List<Object> thkcpjpfr=xhService.thkcpjpfr(kcmc,dg);
			map.put("dataCount", thkcpjpfr);
			map.put("title",kcmc+"评教"+dg+""+"的人员名单");
			map.put("table", true);	
		}if("xskcpjxj".equals(reg)){//学生课程评教小结表
			List<Object> xskcpjxj=xhService.xskcpjxj();
			map.put("dataCount", xskcpjxj);
			map.put("title","学生课程评教小结表");
			map.put("param1", "nf405");
			map.put("table", true);			
		}if("xskcpjpfr".equals(reg)){//学生评教名单
			List<Object> xskcpjpfr=xhService.xskcpjpfr(kcmc,dg);
			map.put("dataCount", xskcpjpfr);
			map.put("title",kcmc+"评教"+dg+""+"的人员名单");
			map.put("table", true);	
		}if("shkcpjxj".equals(reg)){//社会课程评教小结表
			List<Object> shkcpjxj=xhService.shkcpjxj();
			map.put("dataCount", shkcpjxj);
			map.put("title","社会课程评教小结表");
			map.put("param1", "nf406");
			map.put("table", true);			
		}if("shkcpjpfr".equals(reg)){//社会评教名单
			List<Object> shkcpjpfr=xhService.shkcpjpfr(kcmc,dg);
			map.put("dataCount", shkcpjpfr);
			map.put("title",kcmc+"评教"+"的人员名单");
			map.put("table", true);	
		}if("ldrssjcstbt".equals(reg)){//领导深入实践场所人均次数同比图
			List<Object> ldrssjcstbt=xhService.ldrssjcstbt();
			map.put("dataCount", ldrssjcstbt);
			map.put("title","领导听课。听说课人均次数同比图");
			map.put("param1", "nf388");				
		}if("ldrssjcsqd".equals(reg)){//领导深入实践教学场所清单
			List<Object> ldrssjcsqd=xhService.ldrssjcsqd(nf);
			map.put("dataCount", ldrssjcsqd);
			map.put("title",nf+"领导深入实践教学场所清单");
			map.put("table", true);	
		}if("ldtskrjsltbt".equals(reg)){//领导听课。听说课人均次数同比图
			List<Object> ldtskrjsltbt=xhService.ldtskrjsltbt();
			map.put("dataCount", ldtskrjsltbt);
			map.put("title","领导听课。听说课人均次数同比图");
			map.put("param1", "nf388");				
		}if("ldtskrjslmx".equals(reg)){//领导听课。听说课清单
			List<Object> ldtskrjslmx=xhService.ldtskrjslmx(nf);
			map.put("dataCount", ldtskrjslmx);
			map.put("title",nf+"领导听课。听说课清单");
			map.put("table", true);	
		}if("jbjcsybtbt".equals(reg)){//校本教材开发数量同比图
			List<Object> jbjcsybtbt=xhService.jbjcsybtbt();
			map.put("dataCount", jbjcsybtbt);
			map.put("title","校本教材开发数量同比图");
			map.put("param1", "nf386");				
		}if("jbjcsymx".equals(reg)){//校本教材开发清单
			List<Object> jbjcsymx=xhService.jbjcsymx(nf);
			map.put("dataCount", jbjcsymx);
			map.put("title",nf+"校本教材开发清单");
			map.put("table", true);	
		}if("ghjcsybtbt".equals(reg)){//规划教材使用比同比图
			List<Object> ghjcsybtbt=xhService.ghjcsybtbt();
			map.put("dataCount", ghjcsybtbt);
			map.put("title","规划教材使用比同比图");
			map.put("param1", "nf385");				
		}if("ghjcsymx".equals(reg)){//规划教材使用清单
			List<Object> ghjcsymx=xhService.ghjcsymx(nf);
			map.put("dataCount", ghjcsymx);
			map.put("title",nf+"规划教材使用清单");
			map.put("table", true);	
		}if("szdwgznftbt".equals(reg)){//师资队伍工作年份同比图
			//教师专业
			List<TjCount> getjszylist = xhService.getjszylist();
			map.put("jszylist", getjszylist);
			List<Object> szdwgznftbt=xhService.szdwgznftbt(zymc,dg);
			map.put("dataCount", szdwgznftbt);
			map.put("title",zymc+dg+"师资工作年分同比图");
			map.put("param1", "nf382");	
		}if("szgzsjmx".equals(reg)){//选中教师工作时间明细
			List<Object> szgzsjmx=xhService.getjsgzsjmx(nf,zymc,dg);
			map.put("dataCount", szgzsjmx);
			map.put("title",nf+zymc+"师资工作时间明细");
			map.put("table", true);	
		}if("szdwzctbt".equals(reg)){//选中师资职称同比图
			//教师专业
			List<TjCount> getjszylist = xhService.getjszylist();
			map.put("jszylist", getjszylist);
			List<Object> xzzclnsltbt=xhService.getxzzclnsltbt(zymc,dg);
			map.put("dataCount", xzzclnsltbt);
			map.put("title",zymc+dg+"师资职称同比图");
			map.put("param1", "nf380");	
		}if("szdwzcmd".equals(reg)){//选中年分专业职称师资明单
			List<Object> xzjszcmx=xhService.xzjszcmx(nf,zymc,dg);
			map.put("jsagefb", xzjszcmx);
			map.put("title",nf+zymc+dg+"师资明单");
			map.put("table", true);		
		}if("xznljssltbt".equals(reg)){//选中教师年龄教师数量同比图
			//教师专业
			List<TjCount> getjszylist = xhService.getjszylist();
			map.put("getjszylist", getjszylist);
			List<Object> xznljssltbt=xhService.xznljssltbt(zymc,aged);
			map.put("dataCount", xznljssltbt);
			map.put("title", zymc+"师资队伍数量同比图");
			map.put("param1", "nf376");					
		}if("xznljsmd".equals(reg)){//选中年份专业的年龄师资名单
	    	 List<JzgEntity> xznljsmd=xhService.xznljsmd(zymc, nf,aged);
	    	 map.put("title",nf+zymc+"师资名单");
	    	 map.put("dataCount", xznljsmd);
	    	 map.put("table", true);
	     }if("sznfzyjsmd".equals(reg)){//选中年份专业的师资名单
	    	 List<JzgEntity> sznfzyjsmd=xhService.sznfzyjsmd(zymc, nf);
	    	 map.put("title",nf+zymc+"师资名单");
	    	 map.put("dataCount", sznfzyjsmd);
	    	 map.put("table", true);
	     }if("szdwsltbt".equals(reg)){//师资队伍数量同比图（分专业）
			//教师专业
			List<TjCount> getjszylist = xhService.getjszylist();
			map.put("getjszylist", getjszylist);
			List<Object> szdwsltbt=xhService.szdwsltbt(zymc);
			map.put("dataCount", szdwsltbt);
			map.put("title", zymc+"师资队伍数量同比图");
			map.put("param1", "nf374");		
		}if("xqkfjcsmx".equals(reg)){//校企合作开发教材数明细
			List<Object> xqkfjcsmx=xhService.xqkfjcsmx(nf);
			map.put("xqkfjcsmx", xqkfjcsmx);
			map.put("title", nf+"校企合作开发教材明细");
			map.put("table", true);
		}if("xqkfjcstbt".equals(reg)){//校企合作开发教材数同比图
			List<Object> xqkfjcstbt=xhService.xqkfjcstbt();
			map.put("dataCount", xqkfjcstbt);
			map.put("title", "校企合作开发教材数同比图");
			map.put("param1", "nf372");
		}if("xqkfkcsmx".equals(reg)){//校企合作开发课程数明细
			List<Object> xqkfkcsmx=xhService.xqkfkcsmx(nf);
			map.put("dataCount", xqkfkcsmx);
			map.put("title", nf+"校企合作开发课程明细");
			map.put("table", true);
		}if("xqkfkcstbt".equals(reg)){//校企合作开发课程数同比图
			List<Object> xqkfkcstbt=xhService.xqkfkcstbt();
			map.put("dataCount", xqkfkcstbt);
			map.put("title", "校企合作开发课程数同比图");
			map.put("param1", "nf369");
		}if("yzdkcbzmx".equals(reg)){//已制定课程标准明细
			List<Object> yzdkcbzmx=xhService.yzdkcbzmx(nf);
			map.put("dataCount", yzdkcbzmx);
			map.put("title", nf+"已制定课程标准明细");
			map.put("table", true);
		}if("yzdkcbzstbt".equals(reg)){//已制定课程标准数同比图
			List<Object> yzdkcbzstbt=xhService.yzdkcbzstbt();
			map.put("dataCount", yzdkcbzstbt);
			map.put("title", "已制定课程标准数同比图");
			map.put("param1", "nf367");
		}if("wckcjsxmmx".equals(reg)){//选中年完成课程建设项目明细
			List<Object> wckcjsxmmx=xhService.wckcjsxmmx(nf);
			map.put("dataCount", wckcjsxmmx);
			map.put("title", nf+"完成课程建设项目明细");
			map.put("table", true);
		}if("wckcjsxmstbt".equals(reg)){//完成课程建设项目数同比图
			List<Object> wckcjsxmstbt=xhService.wckcjsxmstbt();
			map.put("dataCount", wckcjsxmstbt);
			map.put("title", "完成课程建设项目数同比图");
			map.put("param1", "nf363");
		}if("dypjzymd".equals(reg)){//低于省内同类专业就业率平均值专业名单
			List<Object> dypjzymd=xhService.dypjzymd();
			map.put("dataCount", dypjzymd);
			map.put("title", "省内同类专业就业率平均值专业名单");
			map.put("table", true);
		}if("zyxslqstbt".equals(reg)){//新生录取数量同比图（分专业）
			//专业
			List<TjCount> stuzy=xhService.getstuzy();
			map.put("stuzy", stuzy);
			List<Object> lnzyxsl=xhService.getlnxslqsl(zymc);
			map.put("lnzyxsl", lnzyxsl);
			map.put("title", zymc+"新生录取数量同比图");
			map.put("param1", "nf362");			
		}if("xdnfzyxsmx".equals(reg)){//选中专业年分新生明细
			List<Object> xdnfzyxsmx=xhService.xdnfzyxsmx(nf,zymc);
			map.put("dataCount", xdnfzyxsmx);
			map.put("title", nf+zymc+"新生明细");
			map.put("table", true);
		}if("xzlbxstbt".equals(reg)){//选中升学类别学生同比图
			//专业
			List<TjCount> stuzy=xhService.getstuzy();
			map.put("stuzy", stuzy);
			List<Object> sxxstbt=xhService.getsxxstbt(zymc,mc);
			map.put("dataCount", sxxstbt);
			map.put("title", zymc+mc+"学生数量同比图");
			map.put("param1", "nf359");
		}if("xzsxxsmx".equals(reg)){//选中升学学生明细
			List<Object> xzsxxsmx=xhService.xzsxxsmx(nf,zymc,mc);
			map.put("dataCount", xzsxxsmx);
			map.put("title", nf+zymc+mc+"学生明细");
			map.put("table", true);
		}if("xzdycymx".equals(reg)){//选中人员名单
			List<Object> xzdycymx=xhService.xzdycymx(nf);
			map.put("dataCount", xzdycymx);
			map.put("title", nf+"德育人员明细");
			map.put("table", true);
		}if("kccjmx".equals(reg)){//德育课程成绩明细
			List<Object> kccjmx=xhService.kccjmx(kcmc,dg);
			map.put("dataCount", kccjmx);
			map.put("title", kcmc+"课程成绩明细");
			map.put("table", true);
		}if("xzkccjfb".equals(reg)){//德育成绩分布			
			//德育课程列表
			List<Object> dykcksylb=xhService.getdykcylb();
			map.put("dykcksylb", dykcksylb);
			List<Object> kccjfb=xhService.getkccjfb(kcmc);
			map.put("dataCount", kccjfb);
			map.put("title",kcmc+ "课程分布情况");
			map.put("param1", "nf353");
		}if("dqxssjwjl".equals(reg)){//当年学生实际违纪率同比图
			//专业
			List<TjCount> byszy=xhService.getstuzy();
			map.put("byszy", byszy);
			List<Object> dqxssjwjl=xhService.getdqxssjwjl(zymc);
			map.put("dataCount", dqxssjwjl);
			map.put("title",zymc+nf+ "学生实际违纪率同比图");
			map.put("param1", "nf350");
		}if("xdxswjmd".equals(reg)){//选中学生违纪名单
			List<Object> xdxswjmd=xhService.getxdxswjmd(nf,zymc);
			map.put("dataCount", xdxswjmd);
			map.put("title",zymc+nf+ "学生违纪名单");
			map.put("table", true);
		}if("bystzfstbt".equals(reg)){//应届毕业生体质达标率同比图
			//毕业生专业
			List<TjCount> byszy=xhService.byhmxlist();
			map.put("byszy", byszy);
			List<Object> yjbystzdbl=xhService.getlnyjbystzdbl(zymc);
			map.put("dataCount", yjbystzdbl);
			map.put("title",zymc+nf+ "应届毕业生体质达标率同比图");
			map.put("param1", "nf349");
		}if("bystzfsmd".equals(reg)){//毕业生体质达标名单
			List<Object> bystzfsmd=xhService.getbystzfsmd(nf,zymc);
			map.put("dataCount", bystzfsmd);
			map.put("title",zymc+nf+ "毕业生体质分数名单");
			map.put("table", true);
		}if("dyjgmd".equals(reg)){//德育机构名单
			//德育机构列表
			List<TjCount> dyjglist=xhService.getdygzjglist();
			map.put("dyjglist", dyjglist);		
			List<Object> dyjgmd=xhService.getdyjgmd(mc);
			map.put("dataCount", dyjgmd);
			map.put("title",mc+"部门人员名单");
			map.put("table", true);
		}if("sjbysmydmx".equals(reg)){//选中专业上届毕业生满意度明细
			List<Object> mydmx=xhService.getmydmx(nf,zymc);
			map.put("dataCount", mydmx);
			map.put("title",zymc+nf+ "年上届毕业生薪资明细");
			map.put("table", true);
		}if("sjbysmydtbt".equals(reg)){//选中专业毕业生满意度同比图
			//毕业生专业
			List<TjCount> byszy=xhService.byhmxlist();
			map.put("byszy", byszy);
			List<Object> zybysmydtbt=xhService.getzybysmydtbt(zymc);
			map.put("dataCount", zybysmydtbt);
			map.put("title",zymc+"上届毕业生满意度同比图");
			map.put("param1", "nf246");	
		}if("yjsdkjyltbt".equals(reg)){//应届生对口就业率同比图
			//毕业生专业
			List<TjCount> byszy=xhService.byhmxlist();
			map.put("byszy", byszy);	
			List<Object> lndkjybl=xhService.yjsdkjyltbt(zymc);
			map.put("title","应届毕业生多口就业率同比图");
			map.put("param1", "nf1345");
			map.put("dataCount", lndkjybl);
		}if("yjsjymx".equals(reg)){//应届生对口就业生明细
			List<Object> dkjyxsmx=xhService.getdkjyxsmx(nf,zymc);
			map.put("dataCount", dkjyxsmx);
			map.put("title",nf+zymc+"应届生对口就业生明细");
			map.put("table", true);
		}if("jyltbt".equals(reg)){//毕业生就业率同比图（分专业）
			//毕业生专业
			List<TjCount> byszy=xhService.byhmxlist();
			map.put("byszy", byszy);	
			List<Object> xzzyjyltbt=xhService.getxzzyjyl(zymc);
			map.put("dataCount", xzzyjyltbt);
			map.put("title",zymc+"应届生就业率同比图");
			map.put("param1", "nf344");	
		}if("yjsjymx".equals(reg)){//应届毕业生就业明细
			List<BysxzEntity> bysxzmx = xhService.getbysxzmx(nf,zymc);
			map.put("dataCount", bysxzmx);
			map.put("title",zymc+nf+ "年毕业生就业明细");
			map.put("table", true);
		}if("yjbysszhqtbt".equals(reg)){//应届毕业生双证获取率同比图
			//毕业生专业
			List<TjCount> getbyszy = xhService.getbyszy1();
			map.put("getbyszy", getbyszy);
			List<Object> lnyjbysszhql=xhService.getlnyjbysszhql(zymc);
		    map.put("dataCount", lnyjbysszhql);
		    map.put("title",zym+"应届毕业生双证获取率同比图");
			map.put("param1", "nf342");
		}if("yjbysszhqmd".equals(reg)){//应届毕业生双证获取者名单
			List<Object> yjbysszhqmd=xhService.getyjbysszhqmd(nf,zymc);
		    map.put("getbyszy", yjbysszhqmd);
		    map.put("title",zym+"应届毕业生双证获取者名单");
			map.put("table", true);
		}if("cxxsbltbt".equals(reg)){//辍学学生比例同比图
			//学生专业
	    	 List<TjCount> stuzy=xhService.getstuzy();
	    	 map.put("stuzy", stuzy);
	    	 List<Object> cxxsbltbt = xhService.getcxxsbltbt(zymc);
	    	 map.put("dataCount", cxxsbltbt);
	    	 map.put("title",zymc+"辍学学生比例同比图");
			 map.put("param1", "nf340");		
		}if("cxxsmx".equals(reg)){//辍学学生明细
			List<Object> cxxsmx=xhService.cxxsmx(nf,zymc);
			map.put("dataCount", cxxsmx);
			map.put("title",nf+zymc+"辍学学生明细");
			map.put("table", true);		
		}if("shfwsltbt".equals(reg)){//毕业生社会服务数量同比图(分社会服务类型)
			//就业生就业服务类型
			List<TjCount> shfwlist=xhService.shfwlist();
			map.put("shfwlist", shfwlist);
			//选定服务数量同比图(分社会服务类型)
			List<Object> shfwsltbt=xhService.getshfwsktbt(mc);
			map.put("dataCount", shfwsltbt);
			map.put("title",mc+"服务数量同比图");
			map.put("param1", "nf339");					
		}if("xzfwmx".equals(reg)){//选中服务类型明细
			List<Object> xzfwmx=xhService.xzfwmx(nf,mc);
			map.put("dataCount", xzfwmx);
			map.put("title",nf+zymc+"毕业生"+mc+"明细");
			map.put("table", true);		
		}if("xzbysqxmx".equals(reg)){//选中毕业生去向明细
			List<Object> xzbysqxmx=xhService.xzbysqxmx(nf,dqmc);
			map.put("dataCount", xzbysqxmx);
			map.put("title",nf+zymc+dqmc+"毕业生去向明细");
			map.put("table", true);		
		}if("xzdqbyssltbt".equals(reg)){//选中地区毕业生数量同比图
			//毕业生毕业地区
			List<TjCount> bysbydq=xhService.getbysbydq();
			map.put("bysbydq",bysbydq);
			List<Object> xzdqbyssltbt=xhService.getxzdqbyssltbt(dqmc);
			map.put("dataCount", xzdqbyssltbt);
			map.put("title",dqmc+"毕业生数量同比图");
			map.put("param1", "nf337");		
		}if("xzzyxssltbt".equals(reg)){//选中专业学生数量同比图
			List<TjCount> stuzy=xhService.getstuzy();
			map.put("stuzy", stuzy);
			List<Object> lnzyxssl = xhService.getlnzyxssl(zymc);
			map.put("dataCount", lnzyxssl);
			map.put("title",zymc+"历年学生数量同比图");
			map.put("param1", "nf335");
		}if("xxzyjgsxt".equals(reg)){//学校专业结构树形图
			List<Object> xxzyjgsxt=xhService.getxxzyjgsxt();
			map.put("dataCount", xxzyjgsxt);
			map.put("title","学校招生专业结构树形图");
			map.put("param1", "nf333");	
			map.put("type", "tree");	
		}if("xzzyzssltbt".equals(reg)){//选中专业历年学生数量同比图
			List<Object> lnzyxssl = xhService.getlnzyxssl(zymc);
			map.put("dataCount", lnzyxssl);
			map.put("title",zymc+"历年学生数量同比图");
			map.put("param1", "nf334");
		}if("xzzynfxsmd".equals(reg)){//选定专业年分学生明细
			map=xhService.getxdxnxdzyxsmd(nf,zym);
		}
		//课程线下***********************************************************
		if("zxktfx".equals(reg)){
			
			List<Object> pjftb=xhService.getpjfsList(zymc,bjmc,kcmc);
			map.put("pjftb", pjftb);
			List<Object> zymcjh=xhService.getzymc();
			map.put("zymcjh", zymcjh);
			List<Object> bjmcjh=xhService.getbjmc(zymc);
			map.put("bjmcjh", bjmcjh);
			List<Object> kcmcjh=xhService.getkcmc(zymc, bjmc);
			map.put("kcmcjh", kcmcjh);
			List<Object> kcnf=xhService.getnf();
			map.put("kcnf", kcnf);
			List<Object> kcfsfb=xhService.getkcfsfb(zymc,bjmc,kcmc,nf);
			map.put("kcfsfb", kcfsfb);
			List<Object> czqrs =xhService.getczqrs(kcmc);
			map.put("czqrs", czqrs);
			List<Object> sgkcmc=xhService.getsgkcmc();
			map.put("sgkcmc", sgkcmc);
			List<Object> jpkczymx =xhService.getjpkczymx();
			map.put("jpkczymx", jpkczymx);
			List<Object> jpkzz =xhService.getjpkzz(zymc);
			map.put("jpkzz", jpkzz);
		}
		//学生考试分数明细表数据
		if("xsksmx".equals(reg)){
			List<Object> xsksmx =xhService.getxsksmx(zymc, bjmc, kcmc, nf);
			map.put("xsksmx", xsksmx);
		}
		//学生考试分数段明细
		if("fsfwmx".equals(reg)){
			List<Object> fsfwmx = xhService.getfsfwmx(zymc, bjmc, kcmc, nf, dg);
			map.put("fsfwmx", fsfwmx);
		}
		//课程迟到/早退/请假人数堆积图
		if("czqrs".equals(reg)){
			List<Object> czqrs =xhService.getczqrs(kcmc);
			map.put("czqrs", czqrs);
			List<Object> sgkcmc=xhService.getsgkcmc();
			map.put("sgkcmc", sgkcmc);
		}
		//部分课程迟到/早退/请假人数饼图
		if("czqrsbt".equals(reg)){
			List<Object> bfczqrs =xhService.getbfczqrs(kcmc, nf);
			map.put("bfczqrs", bfczqrs);
		}
		//部分课程迟到/早退/请假人数明细
		if("bfczqrsmx".equals(reg)){
			List<Object> bfczqrsmx =xhService.getbfczqrsmx(kcmc, nf, lb);
			map.put("bfczqrsmx", bfczqrsmx);
		}
		//精品课程增长柱状图
		if("jpkzz".equals(reg)){
			List<Object> jpkczymx =xhService.getjpkczymx();
			map.put("jpkczymx", jpkczymx);
			List<Object> jpkzz =xhService.getjpkzz(zymc);
			map.put("jpkzz", jpkzz);
		}
		//精品课程明细
		if("jpkcmx".equals(reg)){
			List<Object> jpkcmx =xhService.getjpkcmx(zymc, nf);
			map.put("jpkcmx", jpkcmx);
		}
		if("111".equals(reg)){
			response.sendRedirect("http://zg.demo.xqit.net/ydjxzg/wxzhengai"); 
		}
		//}
		String jsonString = JSON.toJSONString(map);
		response.setCharacterEncoding("UTF-8");  
	    response.setContentType("application/json; charset=utf-8"); 
	   /* PrintWriter writer = response.getWriter();
	    writer.write(JSON.toJSONString(map));
	    writer.close();*/
		/*request.setAttribute("dataCount", jsonString);
		response.addHeader("location",request.getContextPath()+"/index.html");*/
		/*response.setStatus(302);*/
	    System.out.println(jsonString);
		return jsonString;
		}
//	//中职学校标准
//	@RequestMapping(value="hxsj.action",produces ="application/json;charset=utf-8",method=RequestMethod.POST)
//	@ResponseBody
//	public String updatezu(HttpServletRequest request,HttpServletResponse response)throws Exception{
//		Map<String,Object> map=new HashMap<String,Object>();
//		List<Object> gjbfb=xhService.getgjbfb();//高级教师比例
//		map.put("gjjsbfb", gjbfb);
//		Integer totalCountStudent=xhService.getTotalCountStu(null);//在校学生总数
//		Integer zrjsCount=xhService.getZrjsCount();//专任教师总数
//		Integer stubijs=totalCountStudent/zrjsCount;//师生比
//		Map<String, Object> mapjb=xhService.getzyjsbfb();
//		map.put("zyjsbfb", mapjb.get("zyjsbfb"));
//		Double sbzz=xhService.getsbzz();//设备总值
//		Double rjsbzz = sbzz/totalCountStudent;//生均设备总值			
//		map.put("zrjsCount",zrjsCount );//专任教师总数
//		map.put("rjsbzz", rjsbzz);//生均设备值			
//		map.put("totalCountStudent", totalCountStudent);
//		map.put("ssb", "1:"+stubijs);//师生比
//		Double xsjzmj=xhService.getxsjzmj();//校舍建筑面积
//		map.put("xsjzmj", xsjzmj);
//		//校外实训基地数
//		Integer xwsxjd = xhService.getxwjd();
//		map.put("xwsxjd", xwsxjd);//校外实训基地数		
//		Double xxzdmj = xhService.getxxzdmj();//学校占地面积
//		map.put("xxzdmj", xxzdmj);
//		Double sjydmj = xxzdmj/(totalCountStudent+zrjsCount);//生均占地面积
//		map.put("sjydmj", sjydmj);
//		Double sjxsmj=xsjzmj/(totalCountStudent+zrjsCount);//生均校舍面积
//		map.put("sjxsmj", sjxsmj);
//		TjCount doublejsbl=xhService.getdoublejsbfb();//双师型教师比例
//		map.put("doublejsbl", doublejsbl);
//		Double tyydmj=xhService.getyydmj();//体育用地面积
//		map.put("tyydmj", tyydmj);
//		Integer sjzzts=xhService.getSjzzts();//生均纸质图书
//		map.put("sjzzts", sjzzts);
//		Integer sjjsjsl=xhService.getjsjsjyysl();//生均计算机拥有数量
//		map.put("sjjsjsl", sjjsjsl);
//		Integer xnsxgws=xhService.getxnsxgws();//校内实训工位数
//		map.put("xnsxgws", xnsxgws);
//		TjCount qklxsl=xhService.getqklxsl();//报刊类型数量
//		map.put("qklxsl", qklxsl);
//		TjCount jsylszws=xhService.getjzgylszw();//教职工阅览室座位数
//		map.put("jsylszws", jsylszws);
//		TjCount xslszws=xhService.getxsylszw();//学生阅览室座位数
//		map.put("xslszws", xslszws);
//		String json = JSON.toJSONString(map);
//		response.setCharacterEncoding("UTF-8");  
//	    response.setContentType("application/json; charset=utf-8"); 
//		return json;
//	}
//	//中职能力评估
//	@RequestMapping(value="hxsj.action",produces ="application/json;charset=utf-8",method=RequestMethod.POST)
//	@ResponseBody
//	public String updatezu(HttpServletRequest request,HttpServletResponse response)throws Exception{
//		Map<String,Object> map=new HashMap<String,Object>();
//		List<Object> gjbfb=xhService.getgjbfb();//高级教师比例
//		map.put("gjjsbfb", gjbfb);
//		Integer totalCountStudent=xhService.getTotalCountStu(null);//在校学生总数
//		Integer zrjsCount=xhService.getZrjsCount();//专任教师总数
//		Integer stubijs=totalCountStudent/zrjsCount;//师生比
//		Map<String, Object> mapjb=xhService.getzyjsbfb();
//		map.put("zyjsbfb", mapjb.get("zyjsbfb"));
//		Double sbzz=xhService.getsbzz();//设备总值
//		Double rjsbzz = sbzz/totalCountStudent;//生均设备总值			
//		map.put("zrjsCount",zrjsCount );//专任教师总数
//		map.put("rjsbzz", rjsbzz);//生均设备值			
//		map.put("totalCountStudent", totalCountStudent);
//		map.put("ssb", "1:"+stubijs);//师生比
//		Double xsjzmj=xhService.getxsjzmj();//校舍建筑面积
//		map.put("xsjzmj", xsjzmj);
//		//校外实训基地数
//		Integer xwsxjd = xhService.getxwjd();
//		map.put("xwsxjd", xwsxjd);//校外实训基地数		
//		Double xxzdmj = xhService.getxxzdmj();//学校占地面积
//		map.put("xxzdmj", xxzdmj);
//		Double sjydmj = xxzdmj/(totalCountStudent+zrjsCount);//生均占地面积
//		map.put("sjydmj", sjydmj);
//		Double sjxsmj=xsjzmj/(totalCountStudent+zrjsCount);//生均校舍面积
//		map.put("sjxsmj", sjxsmj);
//		TjCount doublejsbl=xhService.getdoublejsbfb();//双师型教师比例
//		map.put("doublejsbl", doublejsbl);
//		Double tyydmj=xhService.getyydmj();//体育用地面积
//		map.put("tyydmj", tyydmj);
//		Integer sjzzts=xhService.getSjzzts();//生均纸质图书
//		map.put("sjzzts", sjzzts);
//		Integer sjjsjsl=xhService.getjsjsjyysl();//生均计算机拥有数量
//		map.put("sjjsjsl", sjjsjsl);
//		Integer xnsxgws=xhService.getxnsxgws();//校内实训工位数
//		map.put("xnsxgws", xnsxgws);
//		TjCount qklxsl=xhService.getqklxsl();//报刊类型数量
//		map.put("qklxsl", qklxsl);
//		TjCount jsylszws=xhService.getjzgylszw();//教职工阅览室座位数
//		map.put("jsylszws", jsylszws);
//		TjCount xslszws=xhService.getxsylszw();//学生阅览室座位数
//		map.put("xslszws", xslszws);
//		String json = JSON.toJSONString(map);
//		response.setCharacterEncoding("UTF-8");  
//	    response.setContentType("application/json; charset=utf-8"); 
//		return json;
//	}
	
}