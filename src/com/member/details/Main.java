package com.member.details;

import java.sql.*;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
    	
    	//connections parameters and values according to local machine configuration
        String url = "jdbc:mysql://localhost:3306/memberDB";
        String user = "root";
        String pwd = "root";

        try {
        	
        	//load the driver
        	new com.mysql.cj.jdbc.Driver();
        	
        	//setting connection
            Connection con = DriverManager.getConnection(url, user, pwd);
            System.out.println("Connected to the database.");
            
            MemberDao memberDao = new MemberDao(con); //calling memberDao class

            Scanner scanner = new Scanner(System.in);

            while (true) {
                System.out.println("\nMenu:");
                System.out.println("a) Insert a new member into the table");
                System.out.println("b) Update membership type");
                System.out.println("c) Update membership fees");
                System.out.println("d) Delete membership details");
                System.out.println("e) Display details of all members");
                System.out.println("f) Exit");

                System.out.print("Enter your choice: ");
                String choice = scanner.nextLine();

                switch (choice) {
                    case "a": //insert a new member into the table
                        System.out.print("Enter MemberID: ");
                        int memberID = scanner.nextInt();
                        scanner.nextLine(); //consume extra character
                        System.out.print("Enter MemberName: ");
                        String memberName = scanner.nextLine();
                        System.out.print("Enter MemberType: ");
                        String memberType = scanner.nextLine();
                        System.out.print("Enter MembershipFees: ");
                        float membershipFees = scanner.nextFloat();
                        scanner.nextLine();
                        Member newMember = new Member(memberID, memberName, memberType, membershipFees);
                        memberDao.insertMember(newMember);
                        break;
                    case "b": //update membership type
                        System.out.print("Enter MemberID: ");
                        memberID = scanner.nextInt();
                        scanner.nextLine();
                        System.out.print("Enter MemberType: ");
                        memberType = scanner.nextLine();
                        memberDao.updateMemberType(memberID, memberType);
                        break;
                    case "c": //update membership fees
                        System.out.print("Enter MemberID: ");
                        memberID = scanner.nextInt();
                        scanner.nextLine();
                        System.out.print("Enter MembershipFees: ");
                        membershipFees = scanner.nextFloat();
                        scanner.nextLine();
                        memberDao.updateMembershipFees(memberID, membershipFees);
                        break;
                    case "d": //delete membership details
                        System.out.print("Enter MemberID: ");
                        memberID = scanner.nextInt();
                        scanner.nextLine();
                        memberDao.deleteMember(memberID);
                        break;
                    case "e": //display all member details
                        memberDao.displayAllMembers();
                        break;
                    case "f"://exit
                        System.exit(0);
                    default:
                        System.out.println("Invalid choice. Please try again.");
                        break;
                }
            }
        } catch (SQLException e) {
            System.out.println("Error connecting to the database: " + e.getMessage());
        }
   
}
}