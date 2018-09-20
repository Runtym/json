package test;

import static org.junit.Assert.assertEquals;

import java.util.List;

import org.junit.Test;

import service.DepartService;
import vo.DepartInfo;

public class TestDepartService {

	@Test
	public void test() {
		DepartService ddao = new DepartService();
		List<DepartInfo> diList = ddao.getDepartInfoList(null);
		assertEquals(diList.size(), 4);
	}

}
