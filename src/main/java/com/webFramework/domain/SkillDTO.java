package com.webFramework.domain;

public class SkillDTO { // 사실 안 쓰임 -> List<Map<String, Integer>> 의 형태로 다루고 있는데 무엇이 더 좋은 지를 모르겠음.
                         // 나중에 테이블이 수정이 될 확률이 매우 낮은 테이블이라 굳이 DTO로 안 쓰고 Map으로 써도 되겠다 라는 판단.
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
        return "SkillDTO{" +
                "skillNo=" + skillNo +
                ", skillName='" + skillName + '\'' +
                '}';
    }
}
