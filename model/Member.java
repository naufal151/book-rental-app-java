package model;

public class Member {
    private String memberId;
    private String name;
    private String address;

    public Member(){

    }

    public Member(String memberId, String name, String address) {
        this.memberId = memberId;
        this.name = name;
        this.address = address;
    }

    public String getMemberId() {
        return memberId;
    }

    public void setMemberId(String memberId) {
        this.memberId = memberId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return "Member [memberId=" + memberId + ", name=" + name + ", address=" + address + "]";
    }

}
