import lombok.Data;

public class DemoTest {

    //水果枚举资源
    public enum Fruit {
        APPLE(8.0, "苹果", 1),
        STRAWBERRY(13.0, "草莓", 1),
        MANGO(20.0, "芒果", 1),
        ;
        private double price; //价格
        private String name; //名称
        private double discount; //折扣

        public double getPrice() {
            return price;
        }

        public void setPrice(double price) {
            this.price = price;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public double getDiscount() {
            return discount;
        }

        public void setDiscount(double discount) {
            this.discount = discount;
        }

        Fruit(double price, String name, double discount) {
            this.price = price;
            this.name = name;
            this.discount = discount;

        }
    }

    /**
     * 购买水果项目
     */
    @Data
    public static class Item {

        private Fruit fruit; //水果

        private int num; //数量

        public Item(Fruit fruit, int num) {
            this.fruit = fruit;
            this.num = num;
        }
    }

    /**
     * 计算水果购买的价格
     */
    public static double calculatePrice1(Item... items) {
        if (items == null || items.length == 0) {
            return 0;
        }
        double totalPrice = 0;
        for (Item item : items) {
            if (item == null || item.getFruit() == null || item.getNum() < 0) {
                throw new IllegalArgumentException("参数错误");
            }
            totalPrice += item.getFruit().price * item.getNum() * item.getFruit().discount;
        }
        return totalPrice;
    }

    /**
     * 计算草莓打折购买的价格
     */
    public static double calculatePrice3(Item... items) {
        if (items == null || items.length == 0) {
            return 0;
        }
        double totalPrice = 0;
        for (Item item : items) {
            if (item == null || item.getFruit() == null || item.getNum() < 0) {
                throw new IllegalArgumentException("参数错误");
            }
            if (("草莓").equals(item.getFruit().name)) {
                item.fruit.setDiscount(0.8);
            }
            totalPrice += item.getFruit().price * item.getNum() * item.getFruit().discount;
        }
        return totalPrice;
    }

    /**
     * 计算草莓打折后 买水果 满100减10
     */
    public static double calculatePrice4(Item... items) {
        if (items == null || items.length == 0) {
            return 0;
        }
        double totalPrice = 0;
        for (Item item : items) {
            if (item == null || item.getFruit() == null || item.getNum() < 0) {
                throw new IllegalArgumentException("参数错误");
            }
            if (("草莓").equals(item.getFruit().name)) {
                item.fruit.setDiscount(0.8);
            }
            totalPrice += item.getFruit().price * item.getNum() * item.getFruit().discount;
        }
        if (totalPrice>=100) {
            return totalPrice-10;
        }else {
            return totalPrice;
        }
    }

    public static void main(String[] args) {
        Item apple = new Item(Fruit.APPLE, 14);
        Item strawberry = new Item(Fruit.STRAWBERRY, 5);
        double price = calculatePrice1(apple, strawberry);
        System.out.println("第一题价格 ： " + price);

        Item apple2 = new Item(Fruit.APPLE, 14);
        Item strawberry2 = new Item(Fruit.STRAWBERRY, 5);
        Item mango2 = new Item(Fruit.MANGO, 11);
        double price2 = calculatePrice1(apple2, strawberry2,mango2);
        System.out.println("第二题价格 ： " + price2);

        Item apple3 = new Item(Fruit.APPLE, 14);
        Item strawberry3 = new Item(Fruit.STRAWBERRY, 5);
        Item mango3 = new Item(Fruit.MANGO, 11);
        double price3 = calculatePrice3(apple3, strawberry3,mango3);
        System.out.println("第三题价格 ： " + price3);

        Item apple4 = new Item(Fruit.APPLE, 14);
        Item strawberry4 = new Item(Fruit.STRAWBERRY, 5);
        Item mango4 = new Item(Fruit.MANGO, 11);
        double price4 = calculatePrice4(apple4, strawberry4,mango4);
        System.out.println("第四题价格 ： " + price4);
    }

}