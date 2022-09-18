package cn.limy.test.hanshunping.linkedlist;

/**
 * 双向链表
 * @author wuyou
 */
public class DoubleLinkedListDemo {
    public static void main(String[] args) {
        System.out.println("双向链表的测试:");
        // 创建节点
        HeroNode2 her1 = new HeroNode2(1, "宋江", "及时雨");
        HeroNode2 her2 = new HeroNode2(2, "卢俊义", "玉麒麟");
        HeroNode2 her3 = new HeroNode2(3, "吴用", "智多星");
        HeroNode2 her4 = new HeroNode2(4, "林冲", "豹子头");
        // 创建一个双向链表对象
        DoubleLinkedList doubleLinkedList = new DoubleLinkedList();
        doubleLinkedList.add(her1);
        doubleLinkedList.add(her2);
        doubleLinkedList.add(her3);
        doubleLinkedList.add(her4);
        doubleLinkedList.list();

        // 修改
        HeroNode2 newHeroNode = new HeroNode2(4, "公孙胜", "入云龙");
        doubleLinkedList.update(newHeroNode);
        System.out.println("修改后的链表情况:");
        doubleLinkedList.list();

        // 删除
        doubleLinkedList.delete(3);
        System.out.println("删除之后的链表情况：");
        doubleLinkedList.list();

        // 测试有序新增
        DoubleLinkedList doubleLinkedList1 = new DoubleLinkedList();
        doubleLinkedList1.addByOrder(her3);
        doubleLinkedList1.addByOrder(her2);
        doubleLinkedList1.addByOrder(her2);
        doubleLinkedList1.addByOrder(her4);
        doubleLinkedList1.addByOrder(her4);
        doubleLinkedList1.addByOrder(her2);
        doubleLinkedList1.addByOrder(her1);
        System.out.println("测试有序增加链表：");
        doubleLinkedList1.list();

    }
}

/**
 * 创建一个双向链表的类
 */
class DoubleLinkedList {
    /**
     * 初始化一个头节点，头节点不动，不存放具体的数据
     */
    private HeroNode2 head = new HeroNode2(0, "", "");
    /**
     * 初始化一个尾节点，指向最后一个元素，默认等于head
     */
    private HeroNode2 tail = head;

    public HeroNode2 getHead() {
        return head;
    }

    /**
     * 修改一个节点的内容
     * @param newHeroNode 修改节点对象
     */
    public void update(HeroNode2 newHeroNode) {
        // 判断是否为空
        if (head.getNext() == null){
            System.out.println("链表为空~~");
            return;
        }
        // 找到需要修改的节点
        // 定义一个辅助变量
        HeroNode2 temp = head.getNext();
        // 表示是否找到这个节点
        boolean flag = false;
        while (true) {
            // 已经遍历完了链表
            if (temp == null) {
                break;
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

    /**
     * 双向链表删除节点
     * 对应双向链表，我们可以直接找到要删除的这个节点，直接删除即可
     * @param no
     */
    public void delete(int no) {
        // 判断当前链表是否为空
        if(head.getNext() == null) {
            System.out.println("链表为空，无法删除");
            return;
        }
        // 辅助变量
        HeroNode2 temp = head;
        // 标志是否找到删除节点
        boolean flag = false;
        while (true) {
            // 已经找到链表的最后
            if (temp == null) {
                break;
            }
            if (temp.getNo() == no) {
                // 找到待删除节点
                flag = true;
                break;
            }
            // temp后移，遍历
            temp = temp.getNext();
        }
        // 判断flag，此时找到要删除的节点就是temp
        if (flag) {
            // 可以删除，将【temp的pre的next域】设置为【temp的next域】
            temp.getPre().setNext(temp.getNext());
            // 如果是最后一个节点，就不需要指向下面这句话，否则会出现空指针 temp.getNext().setPre(null.getPre())
            if (temp.getNext() != null) {
                temp.getNext().setPre(temp.getPre());
            }
        }
    }

    /**
     * 直接新增节点
     * @param heroNode 新增的节点
     */
    public void add(HeroNode2 heroNode) {
        tail.setNext(heroNode);
        heroNode.setPre(tail);
        tail = heroNode;
    }

    /**
     * 有序新增节点
     * @param heroNode 新增的节点
     */
    public void addByOrder(HeroNode2 heroNode) {
        HeroNode2 temp = head;
        // 标记添加的编号是否已经存在
        boolean flag = false;
        while (true) {
            if (temp.getNext() == null) {
                break;
            }
            // 位置已经找到，应该在temp和temp.getNext()之间
            if (temp.getNext().getNo() > heroNode.getNo()) {
                break;
            }
            if (temp.getNext().getNo() == heroNode.getNo()) {
                flag = true;
            }
            temp = temp.getNext();
        }
        // 判断flag
        if (flag) {
            System.out.printf("准备插入的英雄编号【%d】已经存在了\n", heroNode.getNo());
        } else {
            // 插入到链表中
            // 1、将【heroNode的next】设置为【temp的next】
            heroNode.setNext(temp.getNext());
            // 判断是不是加在链表最后
            if (temp.getNext() != null) {
                // 2、将【temp的next的pre】设为为【heroNode】
                temp.getNext().setPre(heroNode);
            }
            // 3、将【temp的next】设置为【heroNode】
            temp.setNext(heroNode);
            // 4、将【heroNode的pre】设置为【temp】
            heroNode.setPre(temp);
        }
    }

    /**
     * 遍历打印双向链表的方法
     */
    public void list() {
        if (head.getNext() == null) {
            System.out.println("链表为空");
            return;
        }
        // 因为头节点，不能动。因此我们需要一个辅助遍历来遍历
        HeroNode2 temp = head.getNext();
        while (temp != null){
            System.out.println(temp);
            temp = temp.getNext();
        }
    }
}

/**
 * 定义HeroNode，每个HeroNode对象就是一个节点
 */
class HeroNode2 {
    private int no;
    private String name;
    private String nickname;
    /**
     * 指向下一个节点，默认为null
     */
    private HeroNode2 next;
    /**
     * 指向前一个节点，默认为null
     */
    public HeroNode2 pre;

    /**
     * 构造器
     * @param no
     * @param name
     * @param nickname
     */
    public HeroNode2(int no, String name, String nickname){
        this.no = no;
        this.name = name;
        this.nickname = nickname;
    }

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

    public HeroNode2 getNext() {
        return next;
    }

    public void setNext(HeroNode2 next) {
        this.next = next;
    }

    public HeroNode2 getPre() {
        return pre;
    }

    public void setPre(HeroNode2 pre) {
        this.pre = pre;
    }
}
