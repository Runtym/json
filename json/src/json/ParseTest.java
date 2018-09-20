package json;

import java.util.HashMap;
import java.util.Map;

import com.google.gson.Gson;

class Person{
	private String empno;
	private String empname;
	private String empjob;
	private String empmgr;
	private String hiredate;
	private String sal;
	private String comm;
	private String deptno;
	public String getEmpno() {
		return empno;
	}
	public void setEmpno(String empno) {
		this.empno = empno;
	}
	public String getEmpname() {
		return empname;
	}
	public void setEmpname(String empname) {
		this.empname = empname;
	}
	public String getEmpjob() {
		return empjob;
	}
	public void setEmpjob(String empjob) {
		this.empjob = empjob;
	}
	public String getEmpmgr() {
		return empmgr;
	}
	public void setEmpmgr(String empmgr) {
		this.empmgr = empmgr;
	}
	public String getHiredate() {
		return hiredate;
	}
	public void setHiredate(String hiredate) {
		this.hiredate = hiredate;
	}
	public String getSal() {
		return sal;
	}
	public void setSal(String sal) {
		this.sal = sal;
	}
	public String getComm() {
		return comm;
	}
	public void setComm(String comm) {
		this.comm = comm;
	}
	public String getDeptno() {
		return deptno;
	}
	public void setDeptno(String deptno) {
		this.deptno = deptno;
	}
	@Override
	public String toString() {
		return "Person [empno=" + empno + ", empname=" + empname + ", empjob=" + empjob + ", empmgr=" + empmgr
				+ ", hiredate=" + hiredate + ", sal=" + sal + ", comm=" + comm + ", deptno=" + deptno + "]";
	}
	
	
}
