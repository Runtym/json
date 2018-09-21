package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import common.DBCon;
import vo.PageInfo;
import vo.Ticket;

public class TicketDAO {
	private Connection con;
	private ResultSet rs;
	private PreparedStatement ps;
	
	private void close() {
		try {
			if(rs!=null) {
				rs.close();
			}
			if(ps!=null) {
				ps.close();
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}
		DBCon.close();
	}

	public int countList(Ticket ti) {
		String sql = "select count(*) from ticket_movie ";
		Connection con = DBCon.getCon();
		try {
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery();
			if(rs.next()) {
				return rs.getInt(1);
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			close();
		}
		return 0;
	}
	public List<Ticket> selectTicketList(Ticket ti){
		List<Ticket> ticketList = new ArrayList<Ticket>();
		Connection con = DBCon.getCon();
		try {
			String sql = "select * from \r\n" + 
					"(select tm.*,rownum rnum  from (SELECT *  FROM TICKET_MOVIE order by tmnum desc) tm\r\n" + 
					"where rownum<=?)\r\n" + 
					"where rnum>=?";
			ps = con.prepareStatement(sql);
			ps.setInt(1, ti.getPi().getlNum());
			ps.setInt(2, ti.getPi().getsNum());
			rs = ps.executeQuery();
			while(rs.next()) {
				ti = new Ticket(rs.getInt("tmnum"),
						rs.getString("tmname"),
						rs.getInt("tmprice"),
						rs.getString("tmstartdat"),
						rs.getString("tmenddat"),
						rs.getString("tmcredat"),
						rs.getString("tmdesc"),
						rs.getInt("tmcnt"),
						rs.getString("tmimg")
						);
				ticketList.add(ti);
			}
			return ticketList;
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			close();
		}
		return null;
	}
	
	public Ticket selectTicket(Ticket ticket) {
		Connection con = DBCon.getCon();
		try {
			String sql = "select * from ticket_movie tm where tmnum=?";
			ps = con.prepareStatement(sql);
			ps.setInt(1, ticket.getTmnum());
			rs = ps.executeQuery();
			while(rs.next()) {
				ticket = new Ticket(rs.getInt("tmnum"),
						rs.getString("tmname"),
						rs.getInt("tmprice"),
						rs.getString("tmstartdat"),
						rs.getString("tmenddat"),
						rs.getString("tmcredat"),
						rs.getString("tmdesc"),
						rs.getInt("tmcnt"),
						rs.getString("tmimg")
						);
				return ticket;
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			close();
		}
		return null;
	}
	
	public int insertTicket(Ticket ticket) {
		Connection con = DBCon.getCon();
		try {
			String sql = "insert into TICKET_MOVIe(tmnum, tmname,\r\n" + 
					"tmprice, tmstartdat,tmenddat,tmcredat)\r\n" + 
					"values(seq_tmnum.nextval, ?,?,"
					+ " ?,?,to_char(sysdate,'YYYYMMDD'))";
			ps = con.prepareStatement(sql);
			ps.setString(1,ticket.getTmname());
			ps.setInt(2,ticket.getTmprice());
			ps.setString(3,ticket.getTmstartdat());
			ps.setString(4,ticket.getTmenddat());
			return ps.executeUpdate();
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			close();
		}
		return 0;
	}
	
	public int updateTicket(Ticket ticket) {
		Connection con = DBCon.getCon();
		try {
			String sql = " update TICKET_MOVIe set tmname=?,\r\n" + 
					"tmprice=?, tmstartdat=?,tmenddat=?\r\n" + 
					"where tmnum=?";
			ps = con.prepareStatement(sql);
			ps.setString(1,ticket.getTmname());
			ps.setInt(2,ticket.getTmprice());
			ps.setString(3,ticket.getTmstartdat());
			ps.setString(4,ticket.getTmenddat());
			ps.setInt(5,ticket.getTmnum());
			return ps.executeUpdate();
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			close();
		}
		return 0;
	}
	
	public int deleteTicket(Ticket ticket) {
		Connection con = DBCon.getCon();
		try {
			String sql = "delete from ticket_movie " + 
					" where tmnum=?";
			ps = con.prepareStatement(sql);
			ps.setInt(1,ticket.getTmnum());
			return ps.executeUpdate();
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			close();
		}
		return 0;
	}
}
