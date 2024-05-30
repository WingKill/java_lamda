import java.util.ArrayList;
import java.util.function.Consumer;
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
		
		// 스트림 특징 : 일회성
		stream = list.stream();
		stream.filter(i -> i % 2 == 0).forEach(i -> System.out.println(i + "\t"));		
	}
}
