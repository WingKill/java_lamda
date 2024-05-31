import java.util.ArrayList;
import java.util.Arrays;
import java.util.function.Consumer;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class StreamTest {
	public static void main(String[] args) {
		ArrayList<Integer> list = new ArrayList<Integer>();
		for(int i = 1; i <= 10; i++) {
			list.add(i);
		}
		
		for(int i : list) {
			System.out.print(i + "\t");
		}
		
		System.out.println();
		
		// Stream 객체 생성
		Stream<Integer> stream = list.stream();
		
		// Consumer<? super T> action 
		// void accept(T t);
		stream.forEach(i -> System.out.print(i + "\t"));
		
		System.out.println();
		
		// 두 번째 짝수만 출력하기
		for(int i : list) {
			if(i%2 == 0) {
				System.out.print(i + "\t");
			}
		}
		
		System.out.println();
		// 스트림 특징 : 일회성
		stream = list.stream();
		stream.filter(i -> i % 2 == 0).forEach(i -> System.out.print(i + "\t"));
		
		// ^ 20240530
		
		System.out.println();
		System.out.println();
	
		// v 20240531
		
		// 1~10까지의 합
		int sum = IntStream.rangeClosed(1, 10).sum();
		System.out.println(sum);
		
		// 1~100까지의 짝수의 합
		sum = IntStream.rangeClosed(1, 100).filter(i -> i % 2 == 0).sum();
		System.out.println(sum);
		
		// 1~100까지의 홀수의 합
		sum = IntStream.rangeClosed(1, 100).filter(i -> i % 2 != 0).sum();
		System.out.println(sum);
		
		////
		// 중간 연산에서 map
		// 1~10까지의 숫자 중 짝수를 골라, 해당 짝수에 2를 곱하여 결과값을 나타내라.
		// [2,4,6,8,10] - > [4,8,12,16,20]
		IntStream.rangeClosed(1,10).filter(i -> i%2 == 0).map(i -> i*2).forEach(System.out::println);
		IntStream.rangeClosed(1,10).filter(i -> i%2 == 0).map(i -> i*2).forEach(i -> System.out.print(i + "\t"));
		
		System.out.println();
		
		// 1~10까지의 숫자 중 짝수를 골라 해당 짝수에 2를 곱한 값을 전부 더하기
		sum = IntStream.rangeClosed(1, 10).filter( i -> i % 2 == 0).map(i -> i*2).sum();
		System.out.println(sum);
		
		int[] arr = {1,3,5,7,9};
		
		sum = Arrays.stream(arr).sum();
		System.out.println(sum);

		// OptionalDouble
		// orElse() 는 위 계산값이 null이면 0.0을 뿌린다. 즉, null 체크라고 보면 된다.
		System.out.println(Arrays.stream(arr).average().orElse(0.0));
		

	}
}
