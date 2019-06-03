package cn.asiainfo.test;

import java.util.List;
/**
 * 
 * @author 多叉树简化--李明阳--java--4年
 *
 */
public class SimplifyTreeDemo {
		public static void main(String[] args) {
			TreeNode tree = new TreeNode();
			List<TreeNode> tree0SonList = tree.getSonList();
			
			tree.setId("0");
			TreeNode tree1 = new TreeNode();
			tree1.setId("1");
			
			TreeNode tree11 = new TreeNode();
			tree11.setId("11");
			tree1.getSonList().add(tree11);
			
			tree0SonList.add(tree1);
			
			TreeNode tree2 = new TreeNode();
			tree2.setId("2");
			
			TreeNode tree21 = new TreeNode();
			tree21.setId("21");
			tree2.getSonList().add(tree21);
			
			TreeNode tree211 = new TreeNode();
			tree211.setId("211");
			TreeNode tree212 = new TreeNode();
			tree212.setId("212");
			TreeNode tree213 = new TreeNode();
			tree213.setId("213");
			
			List<TreeNode> tree21SonList = tree21.getSonList();
			tree21SonList.add(tree211);
			tree21SonList.add(tree212);
			tree21SonList.add(tree213);
			
			tree0SonList.add(tree2);
			
			simplify(tree,null);
			System.out.println(tree.getId());
		}
	
	private static void simplify(TreeNode tree,TreeNode treesFather) {
		List<TreeNode> sonList = tree.getSonList();
		if(sonList.size() == 0) {
			return;
		}else if(sonList.size() ==1) {
			System.out.println(tree.getId());
			TreeNode nextSon = sonList.get(0);
//			取代原来的索引，否则会引发遍历混乱
			int index = treesFather.getSonList().indexOf(tree);
			treesFather.getSonList().remove(tree);
			treesFather.getSonList().add(index,nextSon);
			simplify(nextSon,treesFather);
		}else {
			for(int i=0; i<sonList.size(); i++) {
				simplify(sonList.get(i),tree);
			}
		}
	}
}
