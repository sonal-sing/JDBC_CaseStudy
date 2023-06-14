package com.member.details;

public class Member {
    private int memberID;
    private String memberName;
    private String memberType;
    private float membershipFees;

    //parmeterized constructor
    public Member(int memberID, String memberName, String memberType, float membershipFees) {
        this.memberID = memberID;
        this.memberName = memberName;
        this.memberType = memberType;
        this.membershipFees = membershipFees;
    }

    //default constructor
    public Member() {
    }

    //Getter and Setter methods
    public int getMemberID() {
        return memberID;
    }

    public void setMemberID(int memberID) {
        this.memberID = memberID;
    }

    public String getMemberName() {
        return memberName;
    }

    public void setMemberName(String memberName) {
        this.memberName = memberName;
    }

    public String getMemberType() {
        return memberType;
    }

    public void setMemberType(String memberType) {
        this.memberType = memberType;
    }

    public float getMembershipFees() {
        return membershipFees;
    }

    public void setMembershipFees(float membershipFees) {
        this.membershipFees = membershipFees;
    }
}
