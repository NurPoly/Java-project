package gymmanagement;

public class DefaultMember {
    private String membershipNumber;
    private String memberName;
    private Date startMembershipDate;

    public DefaultMember(String membershipNumber, String memberName, Date startMembershipDate) {
        this.membershipNumber = membershipNumber;
        this.memberName = memberName;
        this.startMembershipDate = startMembershipDate;
    }

    public String getMembershipNumber() {
        return membershipNumber;
    }

    public void setMembershipNumber(String membershipNumber) {
        this.membershipNumber = membershipNumber;
    }

    public String getMemberName() {
        return memberName;
    }

    public void setMemberName(String memberName) {
        this.memberName = memberName;
    }

    public Date getStartMembershipDate() {
        return startMembershipDate;
    }

    public void setStartMembershipDate(Date startMembershipDate) {
        this.startMembershipDate = startMembershipDate;
    }
}

