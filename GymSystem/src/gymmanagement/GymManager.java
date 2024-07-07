package gymmanagement;

public interface GymManager {
    void addMember(DefaultMember member);
    void deleteMember(String membershipNumber);
    void printMembers();
    void sortMembers();
    void saveMembers();
    void loadMembers();
}

