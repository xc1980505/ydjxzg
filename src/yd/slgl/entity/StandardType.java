package yd.slgl.entity;

import java.util.List;
import java.util.Set;

public class StandardType {
private String id;//����id
private String name;//��׼��
private String parent_id;//��׼��id
private String level;
private List<StandardType> children;
private List<Standard> childrenstand;

public List<Standard> getChildrenstand() {
	return childrenstand;
}
public void setChildrenstand(List<Standard> childrenstand) {
	this.childrenstand = childrenstand;
}
public List<StandardType> getChildren() {
	return children;
}
public void setChildren(List<StandardType> children) {
	this.children = children;
}
public String getId() {
	return id;
}
public void setId(String id) {
	this.id = id;
}
public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}
public String getParent_id() {
	return parent_id;
}
public void setParent_id(String parent_id) {
	this.parent_id = parent_id;
}
public String getLevel() {
	return level;
}
public void setLevel(String level) {
	this.level = level;
}
}
