package cn.limy.test.interview;

public class DoubleCheck {
    private volatile static DoubleCheck instance = null;

    private DoubleCheck(){

    }

    static DoubleCheck getDoubleCheck(){
        if(instance == null){
            synchronized (DoubleCheck.class){
                if(instance == null){
                    instance = new DoubleCheck();
                }
            }
        }
        return instance;
    }


}
