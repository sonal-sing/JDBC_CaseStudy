package com.member.details;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


public class MemberDao {
    private Connection con;

    public MemberDao(Connection connection) {
        this.con = connection;
    }

    
    
    //inserting member details
    public void insertMember(Member member) {
        try {
            PreparedStatement statement = con.prepareStatement(
                    "INSERT INTO Member (memberid, membername, membertype, membershipfees) VALUES (?, ?, ?, ?)");
            statement.setInt(1, member.getMemberID());
            statement.setString(2, member.getMemberName());
            statement.setString(3, member.getMemberType());
            statement.setFloat(4, member.getMembershipFees());
            statement.executeUpdate();
            System.out.println("Member inserted successfully.");
        } catch (SQLException e) {
            System.out.println("Error inserting member: " + e.getMessage());
        }
    }

    //updating memberType
    public void updateMemberType(int memberID, String memberType) {
        try {
            PreparedStatement statement = con.prepareStatement(
                    "UPDATE Member SET membertype = ? WHERE memberid = ?");
            statement.setString(1, memberType);
            statement.setInt(2, memberID);
            int rowsAffected = statement.executeUpdate();
            if (rowsAffected > 0) {
                System.out.println("Membership type updated successfully.");
            } else {
                System.out.println("Member not found.");
            }
        } catch (SQLException e) {
            System.out.println("Error updating membership type: " + e.getMessage());
        }
    }

    //updating membershipfees 
    public void updateMembershipFees(int memberID, float membershipFees) {
        try {
            PreparedStatement statement = con.prepareStatement(
                    "UPDATE Member SET membershipfees = ? WHERE memberid = ?");
            statement.setFloat(1, membershipFees);
            statement.setInt(2, memberID);
            int rowsAffected = statement.executeUpdate();
            if (rowsAffected > 0) {
                System.out.println("Membership fees updated successfully.");
            } else {
                System.out.println("Member not found.");
            }
        } catch (SQLException e) {
            System.out.println("Error updating membership fees: " + e.getMessage());
        }
    }

    //deleting member details
    public void deleteMember(int memberID) {
        try {
            PreparedStatement statement = con.prepareStatement(
                    "DELETE FROM Member WHERE memberid = ?");
            statement.setInt(1, memberID);
            int rowsAffected = statement.executeUpdate();
            if (rowsAffected > 0) {
                System.out.println("Member deleted successfully.");
            } else {
                System.out.println("Member not found.");
            }
        } catch (SQLException e) {
            System.out.println("Error deleting member: " + e.getMessage());
        }
    }

    //displaying list of details of all the members
    public void displayAllMembers() {
        try {
            Statement statement = con.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT * FROM Member");
            System.out.println("MemberID\tMemberName\tMemberType\tMembershipFees");
            while (resultSet.next()) {
                int memberID = resultSet.getInt("memberid");
                String memberName = resultSet.getString("membername");
                String memberType = resultSet.getString("membertype");
                float membershipFees = resultSet.getFloat("membershipfees");
                System.out.println(memberID + "\t\t" + memberName + "\t\t" + memberType + "\t\t" + membershipFees);
            }
        } catch (SQLException e) {
            System.out.println("Error retrieving members: " + e.getMessage());
        }
    }
}
