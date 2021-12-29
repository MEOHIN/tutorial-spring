package ch10;

public class BirthDay {

//    private : 멤버변수의 오류 또는 객체가 오용되 상황을 제어 (정보 은닉 보다는 정보 보호에 가까운 느낌이다)
    private int day;
    private int month;
    private int year;

    private boolean isValid;

    public int getDay(){
        return day;
    }

    public void setDay(int day){
        this.day = day;
    }

    public int getMonth() {
        return month;
    }

    public void setMonth(int month) {

        if (month < 1 || month >12){
            isValid = false;
        }
        else {
            isValid = true;
            this.month = month;
        }
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public void showDate(){
        if (isValid){
            System.out.println(year + "년 " + month + "월 " + day + "입니다.");
        }
        else {
            System.out.println("유효하지 않은 날짜입니다.");
        }
    }
}
