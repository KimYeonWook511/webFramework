package com.webFramework.domain;

public class SkillVO {
    private int skillNo;
    private String skillName;

    public int getSkillNo() {
        return skillNo;
    }

    public void setSkillNo(int skillNo) {
        this.skillNo = skillNo;
    }

    public String getSkillName() {
        return skillName;
    }

    public void setSkillName(String skillName) {
        this.skillName = skillName;
    }

    @Override
    public String toString() {
        return "SkillVO{" +
                "skillNo=" + skillNo +
                ", skillName='" + skillName + '\'' +
                '}';
    }
}
