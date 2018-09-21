package service;

import java.util.HashMap;
import java.util.Map;

import dao.TicketDAO;
import vo.PageInfo;
import vo.Ticket;

public class TicketService {
	private TicketDAO tdao = new TicketDAO();

	public Map<String,Object> selectTicketList(Ticket ticket){
		ticket.getPi().initPage(tdao.countList(ticket));
		Map<String,Object> rMap = new HashMap<String,Object>();
		rMap.put("list", tdao.selectTicketList(ticket));
		rMap.put("page", ticket.getPi());
		return rMap;
	}
	
	public Ticket selectTicket(Ticket ticket) {
		return tdao.selectTicket(ticket);
	}
	
	public int insertTicket(Ticket ticket) {
		return tdao.insertTicket(ticket);
	}
	
	public int updateTicket(Ticket ticket) {
		return tdao.updateTicket(ticket);
	}
	
	public int deleteTicket(Ticket ticket) {
		return tdao.deleteTicket(ticket);
	}
}
