package gymmanagement;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class MyGymManager implements GymManager {
    private ArrayList<DefaultMember> members = new ArrayList<>();
    private final int MAX_MEMBERS = 100;

    @Override
    public void addMember(DefaultMember member) {
        if (members.size() < MAX_MEMBERS) {
            members.add(member);
            System.out.println("Member added. Remaining spaces: " + (MAX_MEMBERS - members.size()));
        } else {
            System.out.println("No spaces available.");
        }
    }

    @Override
    public void deleteMember(String membershipNumber) {
        DefaultMember memberToRemove = null;
        for (DefaultMember member : members) {
            if (member.getMembershipNumber().equals(membershipNumber)) {
                memberToRemove = member;
                break;
            }
        }
        if (memberToRemove != null) {
            members.remove(memberToRemove);
            System.out.println("Member deleted. Remaining spaces: " + (MAX_MEMBERS - members.size()));
        } else {
            System.out.println("Member not found.");
        }
    }

    @Override
    public void printMembers() {
        for (DefaultMember member : members) {
            System.out.println(member.getMembershipNumber() + " " + member.getMemberName() + " " + member.getStartMembershipDate());
        }
    }

    @Override
    public void sortMembers() {
        Collections.sort(members, new Comparator<DefaultMember>() {
            @Override
            public int compare(DefaultMember m1, DefaultMember m2) {
                return m1.getMemberName().compareTo(m2.getMemberName());
            }
        });
        System.out.println("Members sorted.");
    }

    @Override
    public void saveMembers() {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("members.dat"))) {
            oos.writeObject(members);
            System.out.println("Members saved to file.");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void loadMembers() {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream("members.dat"))) {
            members = (ArrayList<DefaultMember>) ois.readObject();
            System.out.println("Members loaded from file.");
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public ArrayList<DefaultMember> getMembers() {
        return members;
    }
}
