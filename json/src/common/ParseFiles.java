package common;

import java.io.File;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

public class ParseFiles {
	private static final int THRESHOLD_SIZE = 1024*1024*5;//5MB
	private static final int UP_TOTAL_SIZE = 1024*1024*100;//100MB
	private static final int UP_FILE_SIZE = 1024*1024*20;//20MB
	
	private static final File TEMP_REPOSITORY = new File(System.getProperty("java.io.tmpdir"));
	public static final String UP_PATH = "C:\\jsp_study\\workspace\\git\\ict_erp\\ict_erp\\WebContent";
	

	public static Map<String,String> parseRequest(HttpServletRequest req) throws Exception{
		Map<String,Object> rMap = new HashMap<String,Object>();
		if(!ServletFileUpload.isMultipartContent(req)) {
			throw new ServletException("폼 인크립트가 파일업로드에 적합하지 않습니다.");
		}
		DiskFileItemFactory dfFactory = new DiskFileItemFactory(THRESHOLD_SIZE, TEMP_REPOSITORY);
		
		ServletFileUpload sfu = new ServletFileUpload(dfFactory);
		sfu.setHeaderEncoding("utf-8");
		sfu.setSizeMax(UP_TOTAL_SIZE);
		sfu.setFileSizeMax(UP_FILE_SIZE);
		List<FileItem> fList = sfu.parseRequest(req);
		Map<String,String> params = new HashMap<String,String>();
		for(FileItem fi:fList) {
			if(fi.isFormField()) {
				params.put(fi.getFieldName(), fi.getString("utf-8"));
			}else {
				String fName = File.separator + "upload" + File.separator + System.currentTimeMillis() + fi.getName().substring(fi.getName().lastIndexOf("."));
				params.put(fi.getFieldName(), fName);
				fi.write(new File(UP_PATH + File.separator + fName));
			}
		}
		return params;
	}
	
	
}
