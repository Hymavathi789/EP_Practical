package com.klu.insert;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.ResultSet;

import com.klu.Bean.itemBean;
import com.klu.Connections.DBUtil;

public class ItemInsertion {
	public int ItemInsert(itemBean item) throws SQLException, ClassNotFoundException {
		Connection con=DBUtil.DBConnection();
		PreparedStatement ps1=con.prepareStatement("insert into sales values(?,?,?)");
		ps1.setInt(1,item.getItemid());
		ps1.setString(2,item.getItemname());
		ps1.setInt(3,item.getCost());
		int i=ps1.executeUpdate();
		con.close();
		return i;
	}
	public void ItemDisplay(itemBean item) throws SQLException, ClassNotFoundException{
		Connection con=DBUtil.DBConnection();
		PreparedStatement ps2=con.prepareStatement("select * from sales");
		ResultSet rs;
		rs=ps2.executeQuery();
		System.out.println("Item Id\t\tName\t\tCost");
		while(rs.next())
		{
			System.out.print(rs.getInt(1));
			System.out.print("\t\t"+rs.getString(2));
			System.out.print("\t\t"+rs.getInt(3));
			System.out.println();
		}
		rs.close();
		con.close();
	}
	public void totalCost(itemBean item) throws SQLException, ClassNotFoundException{
		Connection con=DBUtil.DBConnection();
		PreparedStatement ps3=con.prepareStatement("select sum(cost) from sales");
		ResultSet rs;
		rs=ps3.executeQuery();
		System.out.println("Total Cost:");
		rs.next();
		System.out.println(rs.getInt(1));
		rs.close();
		con.close();
	}

}






