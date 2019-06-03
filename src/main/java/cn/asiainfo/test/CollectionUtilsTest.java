package cn.asiainfo.test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.lang3.ArrayUtils;
import org.junit.Test;

public class CollectionUtilsTest {
	@Test
	public void testUnion(){
	    String[] arrayA = new String[] { "A", "B", "C", "D", "E", "F" };  
	    String[] arrayB = new String[] { "B", "D", "F", "G", "H", "K" };
	    List<String> listA = Arrays.asList(arrayA);
	    List<String> listB = Arrays.asList(arrayB);
	    //2个数组取并集 
	    System.out.println(ArrayUtils.toString(CollectionUtils.union(listA, listB)));
	    //[A, B, C, D, E, F, G, H, K]
	}
	
	@Test
	public void testIntersection(){
	    String[] arrayA = new String[] { "A", "B", "C", "D", "E", "F" };  
	    String[] arrayB = new String[] { "B", "D", "F", "G", "H", "K" };
	    List<String> listA = Arrays.asList(arrayA);
	    List<String> listB = Arrays.asList(arrayB);
	    //2个数组取交集 
	    System.out.println(ArrayUtils.toString(CollectionUtils.intersection(listA, listB)));
	    //[B, D, F]

	}
	
	@Test
	public void testDisjunction(){
	    String[] arrayA = new String[] { "A", "B", "C", "D", "E", "F" };  
	    String[] arrayB = new String[] { "B", "D", "F", "G", "H", "K" };
	    List<String> listA = Arrays.asList(arrayA);
	    List<String> listB = Arrays.asList(arrayB);
	    //2个数组取交集 的补集
	    System.out.println(ArrayUtils.toString(CollectionUtils.disjunction(listA, listB)));
	    //[A, C, E, G, H, K]
	}
	
	@Test
	public void testSubtract(){
	    String[] arrayA = new String[] { "A", "B", "C", "D", "E", "F" };  
	    String[] arrayB = new String[] { "B", "D", "F", "G", "H", "K" };
	    List<String> listA = Arrays.asList(arrayA);
	    List<String> listB = Arrays.asList(arrayB);
	    //arrayA扣除arrayB
	    System.out.println(ArrayUtils.toString(CollectionUtils.subtract(listA, listB)));
	    //[A, C, E]

	}
	
	@Test
	public void testIsEmpty(){

	    class Person{}
	    class Girl extends Person{}

	    List<Integer> first = new ArrayList<>();
	    List<Integer> second = null;
	    List<Person> boy = new ArrayList<>();
	    //每个男孩心里都装着一个女孩
	    boy.add(new Girl());
	    //判断集合是否为空
	    System.out.println(CollectionUtils.isEmpty(first));   //true
	    System.out.println(CollectionUtils.isEmpty(second));   //true
	    System.out.println(CollectionUtils.isEmpty(boy));   //false

	    //判断集合是否不为空
	    System.out.println(CollectionUtils.isNotEmpty(first));   //false
	    System.out.println(CollectionUtils.isNotEmpty(second));   //false
	    System.out.println(CollectionUtils.isNotEmpty(boy));   //true
	}
	
	@Test
	public void testIsEqual(){

	    class Person{}
	    class Girl extends Person{
	    }

	    List<Integer> first = new ArrayList<>();
	    List<Integer> second = new ArrayList<>();
	    first.add(1);
	    first.add(2);
	    second.add(2);
	    second.add(1);
	    Girl goldGirl = new Girl();
	    List<Person> boy1 = new ArrayList<>();
	    //每个男孩心里都装着一个女孩
	    boy1.add(new Girl());
	    List<Person> boy2 = new ArrayList<>();
	    //每个男孩心里都装着一个女孩
	    boy2.add(new Girl());
	    //比较两集合值
	    System.out.println(CollectionUtils.isEqualCollection(first,second));   //true
	    System.out.println(CollectionUtils.isEqualCollection(first,boy1));   //false
	    System.out.println(CollectionUtils.isEqualCollection(boy1,boy2));   //false

	    List<Person> boy3 = new ArrayList<>();
	    //每个男孩心里都装着一个女孩
	    boy3.add(goldGirl);
	    List<Person> boy4 = new ArrayList<>();
	    boy4.add(goldGirl);
	    System.out.println(CollectionUtils.isEqualCollection(boy3,boy4));   //true
	}
	
	@Test
	public void testUnmodifiableCollection(){
	    Collection<String> c = new ArrayList<>();
	    Collection<String> s = CollectionUtils.unmodifiableCollection(c);
	    c.add("boy");
	    c.add("love");
	    c.add("girl");
	    //! s.add("have a error");
	    System.out.println(s);
	}
}
