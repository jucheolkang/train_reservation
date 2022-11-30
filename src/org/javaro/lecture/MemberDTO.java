package org.javaro.lecture;

public class MemberDTO {
    private String ID;
    private String PW;
    private String Name;

    public MemberDTO(String iD, String pW, String name) {
        ID = iD;
        PW = pW;
        Name = name;
    }

    public String getID() {
        return ID;
    }

    public String getPW() {
        return PW;
    }

    public String getName() {
        return Name;
    }

    public void setID(String iD) {
        ID = iD;
    }

    public void setPW(String pW) {
        PW = pW;
    }

    public void setName(String name) {
        Name = name;
    }



}