package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import common.DBCon;
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

	public List<Ticket> selectTicketList(Ticket ti){
		List<Ticket> ticketList = new ArrayList<Ticket>();
		Connection con = DBCon.getCon();
		try {
			String sql = "select * from ticket_movie ";
			ps = con.prepareStatement(sql);
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
			String sql = "select * from ticket_movie where tmnum=?";
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
		return 0;
	}
	
	public int updateTicket(Ticket ticket) {
		return 0;
	}
	
	public int deleteTicket(Ticket ticket) {
		return 0;
	}
}
