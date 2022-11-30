package org.javaro.lecture;

public class Main {
    public static void main(String[] args) {
        MemberJoinDAO memberJoinDAO = new MemberJoinDAO();
        memberJoinDAO.run();
    }
}
/*문제점 - 회원 전환시 기차 예매 값이 사라짐*/