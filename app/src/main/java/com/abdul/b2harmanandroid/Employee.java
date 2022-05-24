package com.abdul.b2harmanandroid;

public class Employee {
    String eName;
    int eAge;
    boolean isElgible;

    public Employee(String eName, int eAge, boolean isElgible) {
        this.eName = eName;
        this.eAge = eAge;
        this.isElgible = isElgible;
    }

    public String geteName() {
        return eName;
    }

    public void seteName(String eName) {
        this.eName = eName;
    }

    public int geteAge() {
        return eAge;
    }

    public void seteAge(int eAge) {
        this.eAge = eAge;
    }

    public boolean isElgible() {
        return isElgible;
    }

    public void setElgible(boolean elgible) {
        isElgible = elgible;
    }
}
