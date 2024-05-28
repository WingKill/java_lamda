import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

class SLenComp implements Comparator<String> {

	@Override
	public int compare(String o1, String o2) {
		return o1.length() - o2.length();
	}
	
}

// 람다가 필요한 상황
public class LamdaTest2 {
	public static void main(String[] args) {
		List<String> list = new ArrayList<String>();
		list.add("Robot");
		list.add("Lambda");
		list.add("Box");
		
		// C언어에서는 함수 포인터라는 것이 있었음
		
		// 인스턴스보다 기능 하나가 필요한 상황 = 자바는 함수 자체를 전달하지 못했음 
		Collections.sort(list, new SLenComp()); // 정렬
		
		for(String s : list) {
			System.out.println(s);
		}
	}
}
