package cn.limy.test.java8;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.collections4.ListUtils;
import org.apache.commons.lang3.ArrayUtils;
import org.junit.Test;

import com.google.common.collect.Lists;

public class ListSpilitTest {
	//按每3个一组分割
	private static final Integer MAX_NUMBER = 3;

	public static void main(String[] args) {

	     
//		1java8 Stream 大数据量List分批处理
		List<Integer> list = Arrays.asList(1, 2, 3, 4, 5, 6, 7,8,9,10);
	      int limit = countStep(list.size());
	      //方法一：使用流遍历操作
	      List<List<Integer>> mglist = new ArrayList<>();
	      Stream.iterate(0, n -> n + 1).limit(limit).forEach(i -> {
	          mglist.add(list.stream().skip(i * MAX_NUMBER).limit(MAX_NUMBER).collect(Collectors.toList()));
	      });
	      
	      System.out.println(mglist);

	      //方法二：获取分割后的集合
	      List<List<Integer>> splitList = Stream.iterate(0, n -> n + 1).limit(limit).parallel().map(a -> list.stream().skip(a * MAX_NUMBER).limit(MAX_NUMBER).parallel().collect(Collectors.toList())).collect(Collectors.toList());
	      
	      System.out.println(splitList);
	      
			
		}
	
	/**
	* 计算切分次数
	*/
	private static Integer countStep(Integer size) {
		return (size + MAX_NUMBER - 1) / MAX_NUMBER;
	}
	
	@Test
	public void testGoogleGuavaLists() {
		// 2使用google guava对List进行分割
		List<Integer> intList = Lists.newArrayList(1, 21, 31, 41, 51, 61, 71, 81);
		// 按每4个一组分割
		List<List<Integer>> parts = Lists.partition(intList, 4);
		parts.stream().forEach(list -> {
			System.out.println(ArrayUtils.toString(list));
		});
		
		System.out.println(10/3);

	}
	
	@Test
	public void testCollectionListUtils(){
//	      3使用apache common collection
		List<Integer> intList = Lists.newArrayList(1, 2, 3, 4, 5, 6, 7, 8);
		// 按每4个一组分割
		List<List<Integer>> subs = ListUtils.partition(intList, 4);
		CollectionUtils.isEmpty(intList);
		subs.stream().forEach(list -> {
			System.out.println(ArrayUtils.toString(list));
		});
		
	}

	
//	4java 手写将一个List等分成n个list
	public static <T> List<List<T>> averageAssign(List<T> source, int n) {
	    List<List<T>> result = new ArrayList<>();
	    int remainder = source.size() % n;  //(先计算出余数)
	    int number = source.size() / n;  //然后是商
	    int offset = 0;//偏移量
	    for (int i = 0; i < n; i++) {
	        List<T> value;
	        if (remainder > 0) {
	            value = source.subList(i * number + offset, (i + 1) * number + offset + 1);
	            remainder--;
	            offset++;
	        } else {
	            value = source.subList(i * number + offset, (i + 1) * number + offset);
	        }
	        result.add(value);
	    }
	    return result;
	}
	
}
