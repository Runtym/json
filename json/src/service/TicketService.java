package service;

import java.util.HashMap;
import java.util.Map;

import dao.TicketDAO;
import vo.Ticket;

public class TicketService {
	private TicketDAO tdao = new TicketDAO();

	public Map<String,Object> selectTicketList(Ticket ticket){
		Map<String,Object> rMap = new HashMap<String,Object>();
		rMap.put("list", tdao.selectTicketList(ticket));
		rMap.put("page", 10);
		return rMap;
	}
	
	public Ticket selectTicket(Ticket ticket) {
		return tdao.selectTicket(ticket);
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
