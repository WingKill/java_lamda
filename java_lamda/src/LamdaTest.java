// 익명 클래스
interface Printable{
	void print();
}


// 함수가 무조건 하나만 와야 한다.

@FunctionalInterface
interface Printable2{
	void print(String s);
}

@FunctionalInterface
interface Addable{
	int add(int num, int num2);
}

class SPrint implements Printable{

	@Override
	public void print() {
		System.out.println("프린트합니다.");
		
	}
	
}

public class LamdaTest {
	public static void main(String[] args) {
		// System.out.println("Hello World");
		
		/////////
		
		Printable printable = new SPrint();
		printable.print();
		
		/////////
//		Printable printable2 = new Printable() {
//			
//			@Override
//			public void print() {
//				System.out.println("프린트합니다.2");
//				
//			}
//		};
		
		Printable printable2 = () -> {System.out.println("프린트합니다.2");};
		printable2.print();
		
		////////
		Printable prn = () -> {System.out.println("프린트합니다.3");};
		prn.print();	
		
		////////
		Printable2 prn2 = (String s) -> {System.out.println(s + "을(를) 프린트합니다.4");};
		prn2.print("'안녕'");
		
		////////
		// 파라미터 타입 생략 가능
		Printable2 prn3 = (s) -> {System.out.println(s);};
		prn3.print("안녕2");
		
		// 구현이 한 줄인 경우 중괄호 생략 가능
		Printable2 prn4 = (s) -> System.out.println(s);
		prn4.print("안녕3");
		
		// 리턴값이 있을 경우에는 중괄호 생략 불가
		Addable add = (num1,num2) -> {return (num1 + num2);};
		System.out.println(add.add(1, 2));
	}
}
