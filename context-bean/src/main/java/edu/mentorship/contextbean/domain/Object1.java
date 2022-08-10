package edu.mentorship.contextbean.domain;

import edu.mentorship.contextbean.interfaces.ObjectType;

public class Object1 implements ObjectType {
    @Override
    public String getType() {
        return "Object1";
    }
}
