package cn.limy.test.java8;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;

import org.junit.Test;

public class Demo02 {
	public static void main(String[] args) {
		List<User> listUser = new ArrayList<>();
		listUser.add(new User("李白", 20, true));
		listUser.add(new User("杜甫", 40, true));
		listUser.add(new User("李清照", 18, false));
		listUser.add(new User("李商隐", 23, true));
		listUser.add(new User("杜牧", 39, true));
		listUser.add(new User("苏小妹", 16, false));
//		
//		HashMap<String, List<User>> hashMap = new HashMap<String,List<User>>();
//		hashMap.put("1", listUser);
//		Collections.sort(hashMap.get("1"),(x,y) -> y.getAge() -x.getAge());
//		hashMap.get("1").forEach(x->System.out.println(x.getAge()));
		
//		listUser.forEach(user-> user.setName(user.getName() +"11"));
//		List<User> collect = listUser.stream().map(u-> {u.setName(u.getName() +"11");return u;}).collect(Collectors.toList());
//		List<User> collect2 = listUser.stream().map(u-> {User newu = new User("aa",20,true);newu.setName(u.getName());return newu;}).collect(Collectors.toList());

		listUser.forEach(x->x.setName(x.getName() + "22"));

		listUser.forEach(user->{System.out.println(user.getName());System.out.println(user.getAge());});
//		collect.forEach(user->System.out.println(user.getName()));
//		collect2.forEach(user->{System.out.println(user.getName());System.out.println(user.getAge());});
		
//		Integer i=100;
//		Integer is = 100;
//		System.out.println(is.equals(i));
//		System.out.println(is==i);
		
/*		Function<Integer,Integer> f =  x->x+1;
		Function<Integer,Integer> before =  x->x *10;
		System.out.println(f.compose(before).apply(2));
		testFunction(2,f.compose(before));
		testFunction(2,f.compose(x->x *10));*/
	}
	
	
	static void testFunction(int a,Function<Integer,Integer>  function){
		System.out.println(function.apply(a));
	}
	
	@Test
	public void TestString() {
		
	}
}
