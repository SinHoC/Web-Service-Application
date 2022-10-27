package com.TeamTemple.TTempleProject;

public class ExampleOrder {
    
    private String name;
    
    private String phoneNumber;

    public String getName() {
        return name;
    }

    public ExampleOrder(String name, String phoneNumber) {
        super();
        this.name = name;
        this.phoneNumber = phoneNumber;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }
    
    
}
