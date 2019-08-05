package yd.slgl.entity;


import java.util.List;
import java.util.Set;

public class Target {
private String id;
private String parent_id;
private String parent_name;
private String creator_id;
private String creator_name;
private String manager_id;
private String manager_name;
private String participant;
private String target_name;
private String target_category;
private String target_extends;
private String target_info;
private String target_stand;
private String target_stand_name;
private String target_stand_contion;
private String target_stand_info;
private String start_time;
private String end_time;
private String check_type;
private String check_time;
private String check_status;
private String result_type;
private String complate_time;
private String complate_value;
private String set_year;
private String is_qy;
private String target_index;
private Integer progress;
private String follow;
private String title;
private String name;
private String funds;
private String upManager;
private String target_dj;
private String actual_funds;
private String importancedj;
private String weight;
private String className;
private String brother;
private String level;
private String upManager_id;
private String tag;
public String getTag() {
	return tag;
}
public void setTag(String tag) {
	this.tag = tag;
}
private Set<UsersEntity> userEntity;
private Set<Target> children;
private Target child;
private List<String> list;
public List<String> getList() {
	return list;
}
public void setList(List<String> list) {
	this.list = list;
}
public Target getChild() {
	return child;
}
public void setChild(Target child) {
	this.child = child;
}
public String getTitle() {
	return title;
}
public void setTitle(String title) {
	this.title = title;
}
public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}
public String getTarget_stand_name() {
	return target_stand_name;
}
public void setTarget_stand_name(String target_stand_name) {
	this.target_stand_name = target_stand_name;
}
public String getUpManager_id() {
	return upManager_id;
}
public void setUpManager_id(String upManager_id) {
	this.upManager_id = upManager_id;
}
public String getUpManager() {
	return upManager;
}
public void setUpManager(String upManager) {
	this.upManager = upManager;
}
public String getClassName() {
	return className;
}
public void setClassName(String className) {
	this.className = className;
}
public String getBrother() {
	return brother;
}
public void setBrother(String brother) {
	this.brother = brother;
}
public String getLevel() {
	return level;
}

public String getCreator_name() {
	return creator_name;
}
public void setCreator_name(String creator_name) {
	this.creator_name = creator_name;
}
public void setLevel(String level) {
	this.level = level;
}
public String getTarget_dj() {
	return target_dj;
}
public void setTarget_dj(String target_dj) {
	this.target_dj = target_dj;
}
public String getWeight() {
	return weight;
}
public void setWeight(String weight) {
	this.weight = weight;
}
public String getManager_name() {
	return manager_name;
}
public void setManager_name(String manager_name) {
	this.manager_name = manager_name;
}
public Set<UsersEntity> getUserEntity() {
	return userEntity;
}
public void setUserEntity(Set<UsersEntity> userEntity) {
	this.userEntity = userEntity;
}
public String getId() {
	return id;
}
public void setId(String id) {
	this.id = id;
}
public String getParent_id() {
	return parent_id;
}
public void setParent_id(String parent_id) {
	this.parent_id = parent_id;
}
public String getParent_name() {
	return parent_name;
}
public void setParent_name(String parent_name) {
	this.parent_name = parent_name;
}
public String getCreator_id() {
	return creator_id;
}
public void setCreator_id(String creator_id) {
	this.creator_id = creator_id;
}
public String getManager_id() {
	return manager_id;
}
public void setManager_id(String manager_id) {
	this.manager_id = manager_id;
}
public String getParticipant() {
	return participant;
}
public void setParticipant(String participant) {
	this.participant = participant;
}
public String getTarget_name() {
	return target_name;
}
public void setTarget_name(String target_name) {
	this.target_name = target_name;
}
public String getTarget_category() {
	return target_category;
}
public void setTarget_category(String target_category) {
	this.target_category = target_category;
}
public String getTarget_info() {
	return target_info;
}
public void setTarget_info(String target_info) {
	this.target_info = target_info;
}
public String getTarget_stand() {
	return target_stand;
}
public void setTarget_stand(String target_stand) {
	this.target_stand = target_stand;
}
public String getTarget_stand_contion() {
	return target_stand_contion;
}
public void setTarget_stand_contion(String target_stand_contion) {
	this.target_stand_contion = target_stand_contion;
}
public String getTarget_stand_info() {
	return target_stand_info;
}
public void setTarget_stand_info(String target_stand_info) {
	this.target_stand_info = target_stand_info;
}
public String getStart_time() {
	return start_time;
}
public void setStart_time(String start_time) {
	this.start_time = start_time;
}
public String getEnd_time() {
	return end_time;
}
public void setEnd_time(String end_time) {
	this.end_time = end_time;
}
public String getCheck_type() {
	return check_type;
}
public void setCheck_type(String check_type) {
	this.check_type = check_type;
}
public String getCheck_time() {
	return check_time;
}
public void setCheck_time(String check_time) {
	this.check_time = check_time;
}
public String getCheck_status() {
	return check_status;
}
public void setCheck_status(String check_status) {
	this.check_status = check_status;
}
public String getResult_type() {
	return result_type;
}
public void setResult_type(String result_type) {
	this.result_type = result_type;
}
public String getComplate_time() {
	return complate_time;
}
public void setComplate_time(String complate_time) {
	this.complate_time = complate_time;
}
public String getComplate_value() {
	return complate_value;
}
public void setComplate_value(String complate_value) {
	this.complate_value = complate_value;
}
public String getSet_year() {
	return set_year;
}
public void setSet_year(String set_year) {
	this.set_year = set_year;
}
public String getIs_qy() {
	return is_qy;
}
public void setIs_qy(String is_qy) {
	this.is_qy = is_qy;
}
public String getTarget_index() {
	return target_index;
}
public void setTarget_index(String target_index) {
	this.target_index = target_index;
}
public Integer getProgress() {
	return progress;
}
public void setProgress(Integer progress) {
	this.progress = progress;
}
public String getFollow() {
	return follow;
}
public void setFollow(String follow) {
	this.follow = follow;
}
public String getFunds() {
	return funds;
}
public void setFunds(String funds) {
	this.funds = funds;
}
public String getActual_funds() {
	return actual_funds;
}
public void setActual_funds(String actual_funds) {
	this.actual_funds = actual_funds;
}
public String getImportancedj() {
	return importancedj;
}
public void setImportancedj(String importancedj) {
	this.importancedj = importancedj;
}
public Set<Target> getChildren() {
	return children;
}
public void setChildren(Set<Target> children) {
	this.children = children;
}
public String getTarget_extends() {
	return target_extends;
}
public void setTarget_extends(String target_extends) {
	this.target_extends = target_extends;
}




}
