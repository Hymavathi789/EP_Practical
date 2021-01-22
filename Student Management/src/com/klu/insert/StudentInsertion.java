package com.klu.insert;

import com.klu.Bean.studentBean;
import com.klu.Connections.DBUtil;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
public class StudentInsertion {
	public int StudentInsert(studentBean student) throws SQLException, ClassNotFoundException {
		Connection con=DBUtil.DBConnection();
		PreparedStatement ps1=con.prepareStatement("insert into Student values(?,?,?)");
		ps1.setInt(1,student.getRegno());
		ps1.setString(2,student.getName());
		ps1.setString(3,student.getEmail());
		int i=ps1.executeUpdate();
		con.close();
		return i;
	}
	
	public int StudentDelete(studentBean student)throws SQLException, ClassNotFoundException{
		Connection con=DBUtil.DBConnection();
		PreparedStatement ps2=con.prepareStatement("delete from Student where regno=101");
		int j=ps2.executeUpdate();
		con.close();
		return j;
	}
	
	public int StudentUpdate(studentBean student)throws SQLException, ClassNotFoundException{
		Connection con=DBUtil.DBConnection();
		PreparedStatement ps3=con.prepareStatement("update Student set email='vhyma@co.in' where regno=101");
		int k=ps3.executeUpdate();
		con.close();
		return k;
	}
	
	public boolean StudentDisplay(studentBean student)throws SQLException, ClassNotFoundException{
		Connection con=DBUtil.DBConnection();
		PreparedStatement ps4=con.prepareStatement("select * from Student");
		boolean l=ps4.execute();
		con.close();
		return l;
	}

}
