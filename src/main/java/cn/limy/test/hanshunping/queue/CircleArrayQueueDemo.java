package cn.limy.test.hanshunping.queue;

import java.util.Scanner;

public class CircleArrayQueueDemo {
    public static void main(String[] args) {
        // 创建一个队列
        CircleArray circleArray = new CircleArray(4); // 其队列的有效数据最大是3
        char key = ' '; // 接受用户输入
        Scanner scanner = new Scanner(System.in);
        boolean loop = true;
        System.out.println("s(show):显示队列");
        System.out.println("e(exit):退出程序");
        System.out.println("a(add):添加数据到队列");
        System.out.println("g(get):从队列取数据");
        System.out.println("h(head):查看队列头的数据");
        while (loop) {
            key = scanner.next().charAt(0); // 接收第一个字符
            switch (key) {
                case 's':
                    circleArray.showQueue();
                    break;
                case 'a':
                    System.out.println("输入一个数:");
                    int value = scanner.nextInt();
                    circleArray.addQueue(value);
                    break;
                case 'g':
                    try {
                        int res = circleArray.getQueue();
                        System.out.printf("取出的数据是%d\n", res);
                        continue;
                    } catch (RuntimeException e){
                        System.out.println(e.getMessage());
                    }
                    break;
                case 'h':
                    try {
                        int res = circleArray.headQueue();
                        System.out.printf("队列头的数据是%d\n", res);
                    } catch (RuntimeException e){
                        System.out.println(e.getMessage());
                    }
                    break;
                case 'e':
                    scanner.close();
                    loop = false;
                    break;
                default:
                    break;
            }
        }
        System.out.println("程序退出");
    }
}

class CircleArray {
    private int maxSize; // 表示数组的最大容量
    private int front; // 队列头的下标，初始值为0
    private int rear; // 队列尾的下标的后一个位置,初始值为0
    private int[] arr; // 该数据用于存放数据，模拟队列

    // 创建队列的构造器
    public CircleArray(int maxSize) {
        this.maxSize = maxSize;
        arr = new int[maxSize];
        front = 0; // 指向队列头部,指向队列头部的数据
        rear = 0; // 指向队列尾，指向队列尾部的数据的后一个位置
    }

    // 判断队列是否满
    public boolean isFull() {
        return (rear + 1) % maxSize == front;
    }

    // 判断队列是否为空
    public boolean isEmpty() {
        // 因为不是循环队列，头尾不相连,所以rear == front 时队列就为空
        return rear == front;
    }

    // 添加数据到队列
    public void addQueue(int n) {
        // 判断队列是否满
        if (isFull()){
            System.out.println("队列满，不能加入数据~~");
            return;
        }
        // 直接将数据加入
        arr[rear] = n;
        // 将 rear 后移 ，这里必须考虑取模
        rear = (rear + 1) % maxSize;
    }

    // 数据出队列
    public int getQueue(){
        // 判断队列是否为空
        if (isEmpty()){
            // 通过抛出异常
            throw new RuntimeException("队列为空，不能取数据~~");
        }
        // front是指向队列的第一个元素
        // 1.先把front对应的值保留到一个临时变量,如果考虑释放要设置arr[front] = 0
        int value = arr[front];
        // 2.将front后移，考虑取模
        front = (front + 1) % maxSize;
        // 3.将临时保存的变量返回
        return value;
    }

    // 显示队列的所有数据
    public void showQueue() {
        // 遍历
        if(isEmpty()){
            System.out.println("队列空的，没有数据~~");
            return;
        }
        // 从front开始遍历，遍历多少个元素
        for (int i = front; i < front + size(); i++) {
            int index = i % maxSize; // 加上size之后可能会超过数组范围，需要进行取模
            System.out.printf("arr[%d]=%d\n", index, arr[index]);
        }
    }

    // 求出当前队列的有效数据个数
    public int size(){
        // 这里 + maxSize保证分子是正数，也可以使用Math.abs(rear - front)
        return (rear + maxSize - front) % maxSize;
    }

    // 显示队列的头数据，不是取数据而仅仅是显示
    public int headQueue(){
        // 判断队列是否为空
        if (isEmpty()){
            // 通过抛出异常
            throw new RuntimeException("队列为空，没有数据~~");
        }
        return arr[front];
    }
}
