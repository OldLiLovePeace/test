package cn.asiainfo.test;

import java.util.ArrayList;
import java.util.List;

public class TreeNode {
	private String id;
	private String name;
	private List<TreeNode> sonList = new ArrayList<TreeNode>(); //该结点的 子结点集合
	
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

	public List<TreeNode> getSonList() {
		return sonList;
	}

	public void setSonList(List<TreeNode> sonList) {
		this.sonList = sonList;
	}


}
