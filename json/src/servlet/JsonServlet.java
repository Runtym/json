package servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import service.DepartService;
import vo.DepartInfo;

/**
 * Servlet implementation class JsonServlet
 */
@WebServlet("/json/*")
public class JsonServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private Gson gson = new Gson();   
    private DepartService ds = new DepartService();
    /**
     * @see HttpServlet#HttpServlet()
     */
    public JsonServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String uri = request.getRequestURI();
		String cmd = uri.substring(uri.lastIndexOf("/")+1);
		response.setContentType("text/html;charset=utf-8");
		PrintWriter pw = response.getWriter();
		if(cmd.equals("list")) { 
			String param = request.getParameter("params");
			DepartInfo di = new DepartInfo();
			if(!param.equals("") && param!=null) {
				di = gson.fromJson(param, DepartInfo.class);
			}
			String json = gson.toJson(ds.getDepartInfoList(di));
			pw.print(json);
		}else { 
			response.setStatus(404);
			String str = "{\"errCode\":\"404\",\"errMsg\":\"안되..\"}";
			pw.print(str);
			pw.flush();
			return;
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

}
