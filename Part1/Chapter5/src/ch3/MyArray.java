package ch3;

public class MyArray {

    int[] intArr;   //int array
    int count;      //개수

    public int ARRARY_SIZE;
    public static final int ERROR_NUM = -999999999;

    public MyArray(){
        count = 0;
        ARRARY_SIZE = 10;
        intArr = new int[ARRARY_SIZE];
    }

    public MyArray(int size){
        count = 0;
        ARRARY_SIZE = size;
        intArr = new int[size];
    }

    public void addElement(int num){
        if (count >= ARRARY_SIZE){
            System.out.println("not enough memory");
            return;
        }
        intArr[count++] = num;
    }

    /** 5개 인수를 가진 배열이 있고 인덱스 0~3까지 데이터가 있다.
     * index 2에 데이터를 넣고 싶다면, 인덱스 3의 데이터부터 하나씩 index 위치를 앞쪽으로 옮기고 인덱스 2에 데이터가 비었을 때, 원하는 데이터값을 넣으면 된다.
      * @param position : 인데스값 (위치)
     * @param num : 데이터값
     */
    public void insertElement(int position, int num){

        int i;

        if (position <0 || position >count){
            return;
        }
        if (count >= ARRARY_SIZE){
            return;
        }
        for (i=count-1; i>=position; i++){
            intArr[i+1] = intArr[i];
        }

        intArr[position] = num;
        count++;
    }

    /** 5개 인수를 가진 배열이 있고 인덱스 0~3까지 데이터가 있다.
     * index 2에 데이터를 빼 싶다면, 인덱스 3의 데이터부터 하나씩 index 위치를 뒤쪽으로 옮기면 된다.
     * @param position : 인데스값 (위치)
     * @param num : 데이터값
     * @return
     */
    public int removeElement(int position, int num){

        int ret = ERROR_NUM;
        if (isEmpty()){
            System.out.println("Array is empty");
            return ret;
        }

        if (position<0 || position>position-1){
            return ret;
        }

        ret = intArr[position];

        for (int i = position; i < count-1; i++){
            intArr[i] = intArr[i+1];
        }

        count--;

        return ret;
    }

    public int getSize(){
        return count;
    }

    public boolean isEmpty(){
        if (count == 0){
            return true;
        }
        else {
            return false;
        }
    }

    public int getElement(int position){
        if (position<0 || position > count-1){
            System.out.println("검색 위치 오류. 현재 리스트의 개수는 " + count + "개 입니다.");
            return ERROR_NUM;
        }
        return intArr[position];
    }

    public void printAll(){
        if (count == 0){
            System.out.println("출력한 내용이 없습니다.");
            return;
        }

        for (int i = 0; i<count; i++){
            System.out.println(intArr[i]);
        }
    }

    public void removeAll(){
        for (int i=0; i<count; i++){
            intArr[i] = 0;
        }
        count = 0;
    }
}
