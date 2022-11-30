package org.javaro.lecture;

public class TrainDTO {
    private String traiNname;
    private String startTime;
    private int price;
    private String startPlace;
    private String endPlace;
    private int user_amount;
    private boolean buy = false;

    public TrainDTO(String traiNname, String startTime,String startPlace, String endPlace, int price){
        this.traiNname = traiNname;
        this.startTime = startTime;
        this. startPlace = startPlace;
        this.endPlace = endPlace;
        this.price = price;
    }
    public int total_price(){
        return user_amount*price;
    }

    public void setUser_amount(int user_amount) {
        this.user_amount = user_amount;
    }

    public void setBuy(boolean buy) {
        this.buy = buy;
    }

    public String getTraiNname() {
        return traiNname;
    }

    public String getStartTime() {
        return startTime;
    }

    public String getStartPlace() {
        return startPlace;
    }

    public String getEndPlace() {
        return endPlace;
    }

    public boolean isBuy() {
        return buy;
    }

    public int getUser_amount() {
        return user_amount;
    }

    @Override
    public String toString() {
        return "기차 이름 : " + traiNname + "    출발 시간 : " + startTime + "    출발역 : " + startPlace+"    도착역 : " +endPlace+"    요금 : " +price;
    }

}
