package test;

import static org.junit.Assert.assertEquals;

import java.util.List;

import org.junit.Test;

import dao.DepartDAO;
import vo.DepartInfo;

public class TestDepartDAO {

	@Test
	public void test() {
		DepartDAO ddao = new DepartDAO();
		List<DepartInfo> diList = ddao.selectDepartInfoList(null);
		assertEquals(diList.size(), 4);
	}

}
