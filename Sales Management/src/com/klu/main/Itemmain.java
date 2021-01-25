package com.klu.main;
import com.klu.Bean.itemBean;
import com.klu.insert.ItemInsertion;

import java.sql.SQLException;
import java.util.Scanner;
public class Itemmain {

	public static void main(String[] args) throws SQLException ,ClassNotFoundException {
		Scanner sc=new Scanner(System.in);
		ItemInsertion is=new ItemInsertion();
		itemBean ib=new itemBean();
		while(true) {
			System.out.println("JDBC TASK-1");
			System.out.println("1.insert item details\n2.display item details\n3.get the total cost\n4.Exit");
			int ob=sc.nextInt();
			switch(ob){
				case 1: System.out.println("Enter item id:");
						int id=sc.nextInt();
						ib.setItemid(id);
						System.out.println("Enter item name:");
						String n=sc.next();
						ib.setItemname(n);
						System.out.println("Enter item id:");
						int c=sc.nextInt();
						ib.setCost(c);
					    int i=is.ItemInsert(ib);
							if(i>0)
							{
								System.out.println("insertion is successfull");
							}
							else
							{
								System.out.println("fail");
							}
							break;
				case 2: is.ItemDisplay(ib);
							break;
				case 3: System.out.println("getting the total cost from database");
						is.totalCost(ib);
							break;
				case 4: System.exit(0);
			}
		}
	}
}
