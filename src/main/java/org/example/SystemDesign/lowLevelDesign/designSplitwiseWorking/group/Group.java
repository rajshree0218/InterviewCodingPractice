package org.example.SystemDesign.lowLevelDesign.designSplitwiseWorking.group;

import org.example.SystemDesign.lowLevelDesign.designSplitwise.user.User;

import java.util.List;

public class Group {
    private String id;
    private String name;
    private List<User> members;

    public Group(String id, String name, List<User> members) {
        this.id = id;
        this.name = name;
        this.members = members;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public List<User> getMembers() {
        return members;
    }
}
