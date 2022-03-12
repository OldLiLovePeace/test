package cn.limy.test.hanshunping.queue;

import java.util.Map;

public class ArrayAroundQueue {
    //队列的大小
    int maxSize;
    //用数组来实现队列
    int[] arr;
    //指向队列首元素的前一个位置
    int front;
    //指向队列的尾元素
    int rear;

    public ArrayAroundQueue(int maxSize) {
        this.maxSize = maxSize;
        arr = new int[this.maxSize];
        //front指向队列首元素的前一个位置
        front = 0;
        rear = 0;
    }


    public boolean isFull() {
        return (rear+1)%maxSize == front;
    }


    public boolean isEmpty() {
        return front == rear;
    }


    public void addNum(int num) {
        if(isFull()) {
            System.out.println("队列已满，无法在进行入队操作");
            return;
        }
        //先放入元素，在后移队尾标记
        arr[rear] = num;
        rear = (rear+1)%maxSize;
    }

    public int getNum() {
        if(isEmpty()) {
            throw new RuntimeException("队列为空，无法出队");
        }
        //队首标记后移，指向队首元素
        System.out.print("出队元素是：");
        int num = arr[front];
        front = (front+1)%maxSize;
        return num;
    }

    public void showQueue() {
        if(isEmpty()) {
            throw new RuntimeException("队列为空，无法遍历");
        }
        System.out.println("遍历队列");
        //当front + 1 == rear时停止遍历
        int start = front;
        while(start != rear) {
            System.out.println(arr[start]);
            //移动到下一个元素
            start = (start+1)%maxSize;
        }
    }

    public void getHead() {
        if(isEmpty()) {
            throw new RuntimeException("队列为空");
        }

        System.out.println("队首元素为："+arr[front]);
    }

    public static void main(String[] args) {
        ArrayAroundQueue aroundQueue = new ArrayAroundQueue(5);
        aroundQueue.addNum(1);
        aroundQueue.addNum(2);
        aroundQueue.addNum(3);
        aroundQueue.addNum(4);
        aroundQueue.showQueue();
        System.out.println(aroundQueue.getNum());
        System.out.println(aroundQueue.getNum());
        aroundQueue.addNum(5);
        aroundQueue.addNum(6);
        aroundQueue.showQueue();
        aroundQueue.getHead();
    }
}
