import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Random;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.IntBinaryOperator;
import java.util.function.IntPredicate;
import java.util.function.Predicate;
import java.util.function.Supplier;

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

class A{

}

// 람다가 필요한 상황
public class LamdaTest2 {
	public static void main(String[] args) {
		// int applyAsInt(int left, int right);
		// IntBinaryOperator operator = (x,y) -> Math.max(x, y);
		
		// 메서드 참조(method reference) :: == 람다식을 좀 더 줄인 것
		
		// 함수형 인터페이스의 매개변수 타입 == 메서드의 매개변수 타입
		// 함수형 인터페이스의 매개변수 개수 == 메서드의 매개변수 개수
		// 함수형 인터페이스의 반환 타입 == 메서드의 반환 타입
		
		IntBinaryOperator operator = Math::max;
		
		System.out.println(operator.applyAsInt(10, 20));		
		System.out.println("/////////////////////////////////////////");
		List<Integer> ls2 = new ArrayList<Integer>(Arrays.asList(1,-2,3,-4,5));
		
		ls2.removeIf(i -> i < 0);
		System.out.println(ls2);
		
		System.out.println("/////////////////////////////////////////");
		// 자바 1.8 이전, 음수값 제거 로직
		List<Integer> ls1 = new ArrayList<Integer>(Arrays.asList(1,-2,3,-4,5));
		System.out.println(ls1);
		
		for(int i=0; i<ls1.size(); i++) {
			if(ls1.get(i) < 0 ) {
				ls1.remove(i);	// 여기서 에러가 가끔 나올 수 있음
			}
		}
		System.out.println(ls1);
		
		System.out.println("/////////////////////////////////////////");
		// T : 입력, R : 출력
		// R apply(T t);
		Function<String, Integer> function = (s) -> s.length();  
		System.out.println(function.apply("안녕???")); 
		System.out.println("/////////////////////////////////////////");
		// void accept(T t);
		Consumer<String> consumer = (s) -> System.out.println(s);
		consumer.accept("해볼까?");
		Consumer<String> consumer2 = (s) ->{
			System.out.println(s);
			System.out.println(s.toUpperCase());
		};
		consumer2.accept("해봅시돵");
		
		Consumer<A> consumer3 = (a) -> System.out.println(a);
		consumer3.accept(new A());
		System.out.println("/////////////////////////////////////////");
		// T get();
		Supplier<String> supplier = () -> "헬로우 월드";
		System.out.println(supplier.get());
	
		Supplier<A> supplier2 = () -> new A();
		System.out.println(supplier2.get());
		System.out.println("/////////////////////////////////////////");
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
