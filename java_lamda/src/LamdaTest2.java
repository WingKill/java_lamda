import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Random;
import java.util.function.Predicate;

class SLenComp implements Comparator<String> {

	@Override
	public int compare(String s1, String s2) {
		return s1.length() - s2.length();
	}
	
}

@FunctionalInterface
interface Calculate{
	void cal(int a, int b);
}

@FunctionalInterface
interface Calculate2<T>{
	T cal(T a, T b);
}


// 매개변수가 있고 리턴값을 반환하는 람다식
interface HowLong{
	int len(String s);
}

// 매개변수가 없는 람다식
interface Generator{
	int rand();
}

// 람다가 필요한 상황
public class LamdaTest2 {
	public static void main(String[] args) {
		// boolean test(T t); 
		
		Predicate<Integer> predicate = (num) -> num < 10;
		System.out.println(predicate.test(2));		
		System.out.println("/////////////////////////////////////////");
		/////////////////////////////////////////
		Calculate2<Integer> cal = (a,b) -> a+b;
		
		System.out.println(cal.cal(1, 2)); 
		
		Calculate2<Double> cal2 = (a,b) -> a+b;
		System.out.println(cal2.cal(1.1, 2.2));
		
		/////////////////////////////////////////
		
		Generator generator = () -> {
			Random rand = new Random();
			return rand.nextInt();
		};
		
		/////////////////////////////////////////
		HowLong hl = (s) -> {
			System.out.println(s);
			return s.length();
		};
		
		//HowLong h2 = (String s) -> {return s.length();};
		HowLong h2 = (s) -> s.length();
		int y = h2.len("안녕?");
		System.out.println("y : " + y);
		
		int x = hl.len("안녕하세요");
		System.out.println(x);
		/////////////////////////////////////////
		Calculate calculate;
		
		//calculate = (int a, int b) -> {System.out.println(a+b);};
		calculate = (a,b) -> System.out.println(a+b);
		calculate.cal(1, 3);
		
		calculate = (a,b) -> System.out.println(a-b);
		calculate.cal(1, 3);
		
		calculate = (a,b) -> System.out.println(a*b);
		calculate.cal(1, 3);
		
		/////////////////////////////////////////
		List<String> list = new ArrayList<String>();
		list.add("Robot");
		list.add("Lambda");
		list.add("Box");
		
		// C언어에서는 함수 포인터라는 것이 있었음
		
		// 인스턴스보다 기능 하나가 필요한 상황 = 자바는 함수 자체를 전달하지 못했음 
		// Collections.sort(list, new SLenComp()); // 정렬
		Collections.sort(list, (s1,s2) -> {return s1.length() - s2.length();});
		
		for(String s : list) {
			System.out.println(s);
		}
	}
}
