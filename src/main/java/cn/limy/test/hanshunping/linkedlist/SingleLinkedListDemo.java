package cn.limy.test.hanshunping.linkedlist;

public class SingleLinkedListDemo {
    public static void main(String[] args) {
        // 先创建节点
        HeroNode her1 = new HeroNode(1, "宋江", "及时雨");
        HeroNode her2 = new HeroNode(2, "卢俊义", "玉麒麟");
        HeroNode her3 = new HeroNode(3, "吴用", "智多星");
        HeroNode her4 = new HeroNode(4, "林冲", "豹子头");

        // 创建一个链表
        SingleLinkedList singleLinkedList = new SingleLinkedList();
        // 无顺序加入节点
//        singleLinkedList.add(her1);
//        singleLinkedList.add(her2);
//        singleLinkedList.add(her3);
//        singleLinkedList.add(her4);
        // singleLinkedList.add(her4); （不考虑排序）如果重复添加一个对象就会死循环，因为第一次添加到队尾的时候next还为空，再次添加next就为自己本身就死循环了

        // 按照编号顺序加入节点
        singleLinkedList.addByOrder(her1);
        singleLinkedList.addByOrder(her4);
        singleLinkedList.addByOrder(her2);
        singleLinkedList.addByOrder(her3);
        singleLinkedList.addByOrder(her3); // 不能重复插入

        // 显示
        singleLinkedList.list();

        // 测试修改节点
        HeroNode newHeroNode = new HeroNode(2, "小卢", "玉麒麟~~");
        singleLinkedList.update(newHeroNode);
        System.out.println("修改之后的链表存储情况：");
        singleLinkedList.list();

        // 删除节点
        singleLinkedList.delete(1);
        singleLinkedList.delete(4);
        singleLinkedList.delete(3);
        singleLinkedList.delete(2);
        System.out.println("删除之后的链表存储情况：");
        singleLinkedList.list();
    }

    /**
     * 方法：获取单链表的节点个数（如果是带头结点的链表，需求不统计头节点）--test
     * @param head 链表的头节点
     * @return 返回的就是有效节点的个数
     */
    public static int getLength(HeroNode head) {
        if (head.getNext() == null) { // 空链表
            return 0;
        }
        int length = 0;
        // 定义一个辅助变量
        HeroNode temp = head.getNext();
        while (temp != null) {
            length++;
            temp = temp.getNext(); // 遍历
        }
        return length;
    }


    /**
     * 查找单链表的倒数第k个节点【新浪面试题】--test
     * 两次遍历方法
     * @param head 链表的 头节点
     * @param index 倒数位置索引
     * @return 倒数index的节点
     */
    public static HeroNode findLastIndexNode1(HeroNode head, int index) {
        // 如果链表为空，返回null
        if (head.getNext() == null) {
            return null; // 没有找到
        }
        // 第一个遍历得到链表的长度(节点个数）
        int size = getLength(head);
        // 第二次遍历 size - index 位置，就是我们倒数的第k个节点
        // 先做一个index的校验
        if (index <= 0 || index > size){
            return null;
        }
        // 这里需要获得倒数第index节点，所以这里遍历从head.getNext()起，与findFirstIndexNode从head起不一致
        HeroNode temp = head.getNext();
        for (int i = 0; i < size - index; i++) {
            temp = temp.getNext();
        }
        return temp;
    }

    /**
     * 快慢指针方法
     * @param head 链表的 头节点
     * @param index 倒数位置索引
     * @return 倒数index的节点
     */
    public static HeroNode findLastIndexNode2(HeroNode head, int index) {
        // 调用方法获取正数第index个节点
        HeroNode quick = findFirstIndexNode(head, index);
        if(quick == null) {
            // 如果为空，说明链表长度太短，直接返回
            return null;
        }
        HeroNode slow = head.getNext();
        while (quick.getNext() != null) {
            quick = quick.getNext();
            slow = slow.getNext();
        }
        return slow;
    }

    /**
     * @param head 链表的 头节点
     * @param index 正数位置索引
     * @return 正数index的节点
     */
    public static HeroNode findFirstIndexNode(HeroNode head, int index) {
        if(index <= 0){
            return null;
        }
        if(head.getNext() == null) {
            return null;
        }
        // 这里需要获得正数第index节点，所以这里遍历从head.getNext()起，与findFirstIndexNode从head起不一致
        HeroNode temp = head;
        for (int i = 0; i < index; i++) {
            if(temp == null) {
                return null;
            }
            temp = temp.getNext();
        }
        return temp;
    }



}

// 定义SingleLinkedList 管理我们的英雄
class SingleLinkedList {
    // 初始化一个头节点，头节点不动，不存放具体的数据
    private HeroNode head = new HeroNode(0, "", "");
    // 初始化一个尾节点，指向最后一个元素，默认等于head
    private HeroNode tail = head;

    // 添加节点到单向链表
    // 不考虑编号顺序时
    // 1. 找到当前链表的最后节点
    // 2. 将最后这个节点的next指向新的节点
    public void add(HeroNode heroNode) {
        tail.setNext(heroNode);
        tail = heroNode;
    }

    // 第二种方式在添加英雄时， 根据排名将英雄插入到指定位置(如果有这个排名，则添加失败，并给出提示)
    public void addByOrder(HeroNode heroNode) {
        // 因为头节点不能动，需要一个辅助指针（变量）来帮助涨找到添加的位置
        // 因为时单链表，所以我们找的temp是位于添加位置的前一个节点，否则加入不了
        HeroNode temp = head;
        boolean flag = false; // 添加的编号是否存在，默认为false
        while(true) {
            if(temp.getNext() == null) { // 说明链表已经在链表的最后
                break;
            }
            if(temp.getNext().getNo() > heroNode.getNo()) { // 位置已经找到，应该在temp和temp.getNext()之间
                break;
            } else if (temp.getNext().getNo() == heroNode.getNo()) { // 说明希望添加heroNode的编号已经存在
                flag = true; // 说明编号存在
                break;
            }
            temp = temp.getNext(); // 后移，遍历当前列表
        }
        // 判断flag的值
        if(flag) { // 不能添加，说明编号存在
            System.out.printf("准备插入的英雄编号%d已经存在了\n", heroNode.getNo());
        } else {
            // 插入到链表中
            heroNode.setNext(temp.getNext());
            temp.setNext(heroNode);
        }
    }

    // 修改节点的信息，根据编号来修改
    public void update(HeroNode newHeroNode) {
        // 判断是否为空
        if (head.getNext() == null){
            System.out.println("链表为空~~");
            return;
        }
        // 找到需要修改的节点
        // 定义一个辅助变量
        HeroNode temp = head.getNext();
        boolean flag = false; // 表示是否找到这个节点
        while (true) {
            if (temp == null) {
                break; // 已经遍历完了链表
            }
            // 如果no是Integer服装类型，不能使用 == ，而应该用 equals
            if (temp.getNo() == newHeroNode.getNo()) {
                // 找到节点
                flag = true;
                break;
            }
            temp = temp.getNext();
        }
        // 根据flag判断是否找到要修改的节点
        if (flag) {
            temp.setName(newHeroNode.getName());
            temp.setNickname(newHeroNode.getNickname());
        } else { // 没有找到
            System.out.printf("没有找到编号为 %d 的节点，不能修改\n", newHeroNode.getNo());
        }
    }

    // 删除节点
    public void delete(int no) {
        HeroNode temp = head;
        boolean flag = false; // 标志是否找到待删除节点
        while (true) {
            if (temp.getNext() == null) { // 已经到节点的最后
                break;
            }
            if (temp.getNext().getNo() == no) {
                // 找到待删除节点的前一个节点temp
                flag = true;
                break;
            }
            temp = temp.getNext();
        }
        // 判断flag
        if (flag) { // 找到
            // 可以删除
            temp.setNext(temp.getNext().getNext());
        } else {
            System.out.printf("要删除的 %d 节点不存在\n", no);
        }
    }

    // 显示链表
    public void list() {
        if (head.getNext() == null) {
            System.out.println("链表为空");
            return;
        }
        // 因为头节点，不能动。因此我们需要一个辅助遍历来遍历
        HeroNode temp = head.getNext();
        while (temp != null){
            System.out.println(temp);
            temp = temp.getNext();
        }
    }
}
// 定义HeroNode，每个HeroNode对象就是一个节点
class HeroNode {
    private int no;
    private String name;
    private String nickname;
    private HeroNode next; // 指向下一个节点
    // 构造器
    public HeroNode(int no, String name, String nickname){
        this.no = no;
        this.name = name;
        this.nickname = nickname;
    }

    // 为了显示方便，我们重写一下toString
    @Override
    public String toString() {
        return "HeroNode [no=" + no + ", name=" + name + ", nickname=" + nickname + "]";
    }

    public int getNo() {
        return no;
    }

    public void setNo(int no) {
        this.no = no;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public HeroNode getNext() {
        return next;
    }

    public void setNext(HeroNode next) {
        this.next = next;
    }
}
