package cn.limy.test.java8;


import java.time.Instant;
import java.util.*;
import java.util.concurrent.TimeUnit;
import java.util.function.Function;
import java.util.stream.Collectors;

import org.junit.Before;
import org.junit.Test;

public class Demo {
	private List<Integer> numbers;
	private List<User> listUser;

	@Before
	public void beforeMethod1(){
		numbers = Arrays.asList(3, 2, 2, 3, 7, 3, 5);
		Integer integer = new Integer("1");
		String string = integer.toString();
	}

	@Before
    public void beforeMethod2(){
		listUser = new ArrayList<>();
		listUser.add(new User("李白", 20, true));
		listUser.add(new User("杜甫", 40, true));
		listUser.add(new User("李清照", 18, false));
		listUser.add(new User("李商隐", 23, true));
		listUser.add(new User("杜牧", 39, true));
		listUser.add(new User("苏小妹", 16, false));
	}
	@Test
    public void method1(){
		//		new Thread(new Runnable() {
//
//			@Override
//			public void run() {
//				System.out.println("hello world");
//			}
//		}).start();
//
//		new Thread(()->System.out.println("hello world")).start();

/*		List<Integer> asList = Arrays.asList(99,99,1,0);
		Map<Integer, Long> countMap = asList.stream().collect(Collectors.groupingBy(Function.identity(),Collectors.counting()));
		countMap.forEach( (k,v)->{System.out.println(k+" "+v);} );*/

/*		List<Integer> list = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9);
		list.stream().filter((x) -> x>3).forEach(System.out::print);
		System.out.println();
		list.stream().filter((x) -> x>3).forEach(x -> System.out.print(x));*/


		// 获取对应的平方数
//		List<Integer> squaresList = numbers.stream().map( i -> i*i).distinct().collect(Collectors.toList());
//		Stream<Integer> map = numbers.stream().map( i -> i*i).forEach(System.out::print);

	}
	@Test
    public void method2(){
		// 根据指定条件取最大值： 取年纪最大的人
		Optional<User> optional = listUser.stream().collect(Collectors.maxBy(Comparator.comparing((user) -> {
			return user.getAge();
		})));

		Function<User,Integer> keyExtractor =user -> {return user.getAge();};
		 keyExtractor =user -> user.getAge();
		 keyExtractor =User::getAge;

		Comparator<User> comparator = Comparator.comparing(keyExtractor);
		if (optional.isPresent()) { // 判断是否有值
			User user = optional.get();
			System.out.println("最大年纪的人是:" + user.getName()); // 输出==》 最大年纪的人是:杜甫
		}

//		ToIntFunction<User> mapper = (user)->{
//			return user.getAge();
//		};
//		Double averageAge = listUser.stream().collect(Collectors.averagingInt(mapper));
//		averageAge = listUser.stream().collect(Collectors.averagingInt(User::getAge));
//		System.out.println("平均年齡是：" + averageAge); // 输出--》 平均年齡是：26.0


//		Long count = listUser.stream().filter(user -> user.getGender()).collect(Collectors.counting());
//		System.out.println("男性个数：" + count); // 输出--》 男性个数：2

		// 将List中的人按性别分组
//		Predicate<User> predicate = (user) -> {
//			return user.getGender();
//		};
//		  <R, A> R collect(Collector<? super T, A, R> collector);
//		 public static <T>
//		    Collector<T, ?, Map<Boolean, List<T>>> partitioningBy(Predicate<? super T> predicate)
//		Map<Boolean, List<User>> partition = listUser.stream().collect(Collectors.partitioningBy(predicate));
//
//		Function<User, Boolean> classifier = (user) -> {
//			return user.getGender();
//		};
//		Map<Boolean, List<User>> groupby = listUser.stream().collect(Collectors.groupingBy(classifier));
//
//		Function<User, String> classifier2 = (user) -> {
//			return user.getName();
//		};
//		Map<String, List<User>> groupby2 = listUser.stream().collect(Collectors.groupingBy(classifier2));


		//1.1根据某个属性分组计数
		Map<Boolean,Long> result1=listUser.stream().collect(Collectors.groupingBy(User::getGender,Collectors.counting()));
		System.out.println(result1);

		//1.2根据整个实体对象分组计数,当其为String时常使用
		Map<User,Long> result2=listUser.stream().collect(Collectors.groupingBy(Function.identity(),Collectors.counting()));
		System.out.println(result2);

		//1.3根据分组的key值对结果进行排序、放进另一个map中并输出
		Map<Boolean,Long> xMap=new HashMap<>();
		result1.entrySet().stream().sorted(Map.Entry.<Boolean,Long>comparingByKey().reversed()) //reversed不生效
				.forEachOrdered(x->xMap.put(x.getKey(),x.getValue()));
		System.out.println(xMap);

		//2.分组，并统计其中一个属性值得sum或者avg:id总和
//        Map<Boolean,Integer> result3=listUser.stream().collect(
//                Collectors.groupingBy(User::getGender,Collectors.summingInt(User::getAge))
//        );
//        System.out.println(result3);
	}

	public static void main(String[] args) {
		System.out.println("haha");

	}

	/**
	 * 5. 【强制】SimpleDateFormat 是线程不安全的类，一般不要定义为 static 变量，如果定义为 static，必须加锁，或者使用
	 * DateUtils 工具类。 正例：注意线程安全，使用 DateUtils。亦推荐如下处理： private static final
	 * ThreadLocal<DateFormat> df = new ThreadLocal<DateFormat>() {
	 *
	 * @Override protected DateFormat initialValue() { return new
	 *           SimpleDateFormat("yyyy-MM-dd"); } }; 说明：如果是 JDK8 的应用，可以使用 Instant
	 *           代替 Date，LocalDateTime 代替 Calendar， DateTimeFormatter 代替
	 *           SimpleDateFormat，官方给出的解释：simple beautiful strong immutable
	 *           thread-safe。
	 * @Description:
	 * @date: 2019年5月9日
	 */
	@Test
	public void java8NewDateAndTimeTestMethod() {
//		表示方法
//	    注意：通过这种方式获取的时间戳与北京时间相差8个时区，需要修正为北京时间，通过查看源代码发现Instant.now()使用等是UTC时间Clock.systemUTC().instant()。LocalDate、LocalDateTime 的now()方法使用的是系统默认时区 不存在Instant.now()的时间问题。
		Instant instant = Instant.now().plusMillis(TimeUnit.HOURS.toMillis(8));
		System.out.println(instant);
		instant = Instant.parse("1970-01-01T00:00:51Z");
		instant.getNano();
		instant.toString();
		instant.getEpochSecond();
		System.out.println("秒数:"+instant.getEpochSecond());
		System.out.println("毫秒数:"+instant.toEpochMilli());
//        *第二个由{@code getEpochSecond}返回。
		System.out.println("纳秒数:"+instant.getNano());


//        操作方法
		instant.plusMillis(0);
		instant.plusSeconds(0);
		instant.plusNanos(0);
		instant.minusMillis(0);

//        判断方法
		Instant otherInstant = Instant.now();
		instant.isAfter(otherInstant);
		instant.isBefore(otherInstant);

	}
}
