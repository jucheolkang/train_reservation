package Train;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

public class TrainDAO {
    Scanner sc = new Scanner(System.in);
    List<TrainDTO> trains = new ArrayList<>();
    public TrainDAO(){
        trains.add(new TrainDTO("ktx","13:00","대전역","서울역",30000));
        trains.add(new TrainDTO("무궁화","9:00","부산역","대전역",35000));
        trains.add(new TrainDTO("ktx","7:00","부산역","서울역",40000));
    }
    public void Trun() {

        int key = 0;
        while ((key = menu()) != 0) {
            switch (key) {
                case 1:
                    trainSelect();
                    break;
                case 2:
                    ticketShow();
                    break;
                case 3:
                    ticketDel();
                    break;
            }
        }
    }
    private void trainSelect(){
        ;int count = 0;
        int select = -1;
        select = showTrain()-1;
        System.out.print("기차를 이용하려고 하는 인원을 입력하시오 : ");
        trains.get(select).setUser_amount(sc.nextInt());
        int price = trains.get(select).total_price();
        do{
            System.out.println("결재 금액 : " + price);
            System.out.print("값을 지불해 주세요 : ");
            int money = sc.nextInt();

            if(price == money){
                System.out.println("결제가 완료되었습니다.");
                trains.get(select).setBuy(true);
                break;
            }
            else if(price > money){
                System.out.println("금액이 부족합니다");
            }
            else if(price < money){
                System.out.println("결제가 완료되었습니다.");
                System.out.println("잔돈 : "+ (money - price));
                trains.get(select).setBuy(true);
                break;
            }
            count++;
        }while(count != 5);

        if(count == 5){
            System.out.println("결재 횟수가 초과로 결재가 취소 되었습니다.");
        }
        else {
            System.out.println();
            System.out.println("================== <표 출력 >==================");
            System.out.println("출발역 : " + trains.get(select).getStartPlace());
            System.out.println("도착역 : " + trains.get(select).getEndPlace());
            System.out.println("출발시간 : " + trains.get(select).getStartTime()+"시");
            System.out.println("탑승 기차 : " + trains.get(select).getTraiNname());
            System.out.println("탑승 인원 : " + trains.get(select).getUser_amount()+"명");
            System.out.println("==============================================");
            System.out.println();
        }

    }
    private void ticketShow(){
        int cnt = 0;// 0번째 리스트 먼저 탐색하기 때문에 순차적으로 true가 아니라면 실행X

        while(trains.get(cnt).isBuy()){
            System.out.println();
            System.out.println("================== <표 출력 >==================");
            System.out.println("출발역 : " + trains.get(cnt).getStartPlace());
            System.out.println("도착역 : " + trains.get(cnt).getEndPlace());
            System.out.println("출발시간 : " + trains.get(cnt).getStartTime()+"시");
            System.out.println("탑승 기차 : " + trains.get(cnt).getTraiNname());
            System.out.println("탑승 인원 : " + trains.get(cnt).getUser_amount()+"명");
            System.out.println("==============================================");
            System.out.println();
            cnt++;
        }

    }
    private  void ticketDel(){
        int cnt = 0;
        while(trains.get(cnt).isBuy()){// 출력 코드 메소드로 만들기
            System.out.println();
            System.out.println("================== <표"+(cnt+1)+" 출력 >==================");
            System.out.println("출발역 : " + trains.get(cnt).getStartPlace());
            System.out.println("도착역 : " + trains.get(cnt).getEndPlace());
            System.out.println("출발시간 : " + trains.get(cnt).getStartTime()+"시");
            System.out.println("탑승 기차 : " + trains.get(cnt).getTraiNname());
            System.out.println("탑승 인원 : " + trains.get(cnt).getUser_amount()+"명");
            System.out.println("==============================================");
            System.out.println();
            cnt++;
        }
        System.out.print("취소하려고 하는 표의 번호를 입력하세요 : ");
        trains.get(sc.nextInt()-1).setBuy(false);

    }


    private int showTrain() {
        Iterator<TrainDTO> ite = trains.iterator();
        int count = 0;

        while(ite.hasNext()) {
            count++;
            System.out.println("원하는 기차의 번호를 입력하시오");
            System.out.println(count + ". "+ite.next() + " ");
        }
        System.out.print("선택 : ");

        return sc.nextInt();

    }


    private int menu() {
        return getNumInput("[1]기차 예매 [2]예매 기록 확인 [3]예매 취소 [0]로그아웃");
    }
    private int getNumInput(String msg) {
        System.out.println(msg);
        return sc.nextInt();
    }
}
