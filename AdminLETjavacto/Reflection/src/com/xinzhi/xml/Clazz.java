package com.xinzhi.xml;

import java.util.List;

/**
 *
 */
public class Clazz {
    private  String name;
    private List<Student> students;

    @Override
    public String toString() {
        return "Clazz{" +
                "name='" + name + '\'' +
                ", students=" + students +
                '}';
    }

    public List<Student> getStudents() {
        return students;
    }

    public void setStudents(List<Student> students) {
        this.students = students;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
