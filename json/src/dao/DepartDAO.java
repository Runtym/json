package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import common.DBCon;
import vo.DepartInfo;

public class DepartDAO {
	
	public List<DepartInfo> selectDepartInfoList(DepartInfo di){
		Connection con = DBCon.getCon();
		String sql = "select * from depart_info where 1=1 ";
		if(di.getDiname()!=null) {
			sql += " and diname like '%'||?||'%'";
		}
		List<DepartInfo> diList = new ArrayList<DepartInfo>();
		try {
			PreparedStatement ps = con.prepareStatement(sql);
			if(di.getDiname()!=null) {
				ps.setString(1, di.getDiname());
			}
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				di = new DepartInfo(rs.getInt("dinum"),
							rs.getString("dicode"),
							rs.getString("diname"),
							rs.getString("didesc"),
							rs.getString("ditest")
						);
				diList.add(di);
			}
			ps.close();
			rs.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			DBCon.close();
		}
		return diList;
	}
}
