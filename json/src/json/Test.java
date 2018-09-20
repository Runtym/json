package json;

import java.util.HashMap;
import java.util.Map;

public class Test {
	//public String innerHTML = "나나나";
	private Map<String,String> attribute = new HashMap<String,String>();
	public Test() {
		attribute.put("dataAttr", "내가 만든거1");
	}

	public String getAttribute(String key) {
		return attribute.get(key);
	}
	public void setAttribute(String key,String value) {
		attribute.put(key,value);
	}
	public void onclick() {
		System.out.println(this.getAttribute("dataAttr"));
	}
	
	public static void main(String[] args) {
		Test t = new Test();
		t.setAttribute("dataAttr", "지금 바꾼거~~");
		t.onclick();
		
		t = new Test();
		t.onclick();
	}
}
