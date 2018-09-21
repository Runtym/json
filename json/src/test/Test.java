package test;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Test {

	public static void main(String[] args) {
		List<String> strList = new ArrayList<String>();
		strList.add("a1");
		strList.add("b1");
		strList.add("t1");
		strList.add("z1");
		strList.add("i1");
		strList.add("q5");
		strList = strList.stream().filter(s->{
			return s.endsWith("1");
		}).collect(Collectors.toList());;
		System.out.println(strList);
	}
}
