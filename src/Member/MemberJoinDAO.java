package Member;
import Train.TrainDAO;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
public class MemberJoinDAO {

    Scanner sc = new Scanner(System.in);
    List<MemberDTO> members = new ArrayList<>();


    public void run() {

        int key = 0;
        while ((key = menu()) != 0) {
            switch (key) {
                case 1:
                    Login();
                    break;
                case 2:
                    MemberJoin();
                    break;
            }
        }
    }




    private void MemberJoin() {
        sc.nextLine();
        String id = getStrInput("ID : ");
        String pw = getStrInput("PassWord : ");
        String pw2 = getStrInput("Password Confirm : ");
        String name = getStrInput("Name : ");

        if(idCheck(id)) {
            System.out.println("중복된 ID입니다.");
        }
        else if(pw.equals(pw2)) {
            members.add(new MemberDTO(id, pw, name));
            System.out.println(id + "님 가입을 축하드립니다.");
        }
        else {
            System.out.println("비밀번호를 확인해주세요.");
        }

    }

    private boolean idCheck(String id) {
        boolean check = true;
        MemberDTO member = FindById(id);
        if(member == null)
            check = false;
        return check;
    }

    private void Login() {
        sc.nextLine();
        String id = getStrInput("ID : ");
        String pw = getStrInput("PassWord : ");

        MemberDTO member = FindById(id);
        if(member == null){
            System.out.println("등록되지 않은 ID입니다.");
        }
        else if(member.getPW().equals(pw)) {
            System.out.println("[" + member.getID() + "]님께서 로그인 하셨습니다.");

            // 기차 예매 프로그램 작동 코드 추가
            TrainDAO train = new TrainDAO();
            train.Trun();
        }
        else {
            System.out.println("비밀번호가 틀렸습니다.");
        }
    }

    private MemberDTO FindById(String id) {
        for(MemberDTO memberDTO : members) {
            if(memberDTO.getID().equals(id)) {
                return memberDTO;
            }
        }
        return null;
    }

    private String getStrInput(String msg) {
        System.out.print(msg);
        return sc.nextLine();
    }

    private int menu() {
        return getNumInput("[1]로그인 [2]회원가입 [0]종료");
    }

    private int getNumInput(String msg) {
        System.out.println(msg);
        return sc.nextInt();
    }

}