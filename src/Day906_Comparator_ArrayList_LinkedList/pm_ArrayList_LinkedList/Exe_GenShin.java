package Day906_Comparator_ArrayList_LinkedList.pm_ArrayList_LinkedList;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;
import java.util.Scanner;

class Role {
    private String name;
    private String nature;
    private int liveSeat;
    private String rarity;
    private int level;

    public Role() {

    }

    public Role(String name, String nature, int liveSeat, String rarity, int level) {
        this.name = name;
        this.nature = nature;
        this.liveSeat = liveSeat;
        this.rarity = rarity;
        this.level = level;
    }

    @Override
    public String toString() {
        return "Role{" +
                "name : " + name +
                ", nature : " + nature  +
                ", liveSeat : " + liveSeat +
                ", rarity : " + rarity  +
                ", lv." + level +
                '}';
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNature() {
        return nature;
    }

    public void setNature(String nature) {
        this.nature = nature;
    }

    public int getLiveSeat() {
        return liveSeat;
    }

    public void setLiveSeat(int liveSeat) {
        this.liveSeat = liveSeat;
    }

    public String getRarity() {
        return rarity;
    }

    public void setRarity(String rarity) {
        this.rarity = rarity;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }
}

class RoleManage {
    static ArrayList characters = new ArrayList();
    static Scanner scanner = new Scanner(System.in);
    static {
        characters.add(new Role("魈", "风", 1, "*****", 90));
        characters.add(new Role("枫原万叶", "风", 0, "*****", 90));
        characters.add(new Role("胡桃", "火", 1, "*****", 89));
        characters.add(new Role("夜兰", "水", 0, "*****", 89));
        characters.add(new Role("雷电将军", "雷", 0, "*****", 89));
        characters.add(new Role("纳西妲", "草", 1, "*****", 89));
        characters.add(new Role("神里绫华", "冰", 0, "*****", 90));
        characters.add(new Role("行秋", "水", 6, "****", 89));

    }
    public static void menu() {
        System.out.println("========================================");
        System.out.println("请选择操作\n0.退出\n1.浏览所有角色\n" +
                "2.添加角色\n3.按等级排序\n4.按命座排序\n5.删除低于指定的角色");
        System.out.println("========================================");
        int opera = scanner.nextInt();
        switch (opera) {
            case 0 -> System.exit(1);
            case 1 -> show();
            case 2 -> add();
            case 3 -> sortByLv();
            case 4 -> sortByLive();
            case 5 -> remove();
        }
    }

    public static void show() {
        characters.forEach(o -> System.out.println(o));
        menu();
    }

    public static void add(){
        System.out.println("请输入角色名称：");
        String name = scanner.next();
        System.out.println("请输入角色属性");
        String nature = scanner.next();
        System.out.println("请输入角色稀有度");
        String rarity = scanner.next();
        System.out.println("请输入角色命座");
        int lives = scanner.nextInt();
        System.out.println("请输入角色等级");
        int level = scanner.nextInt();
        characters.add(new Role(name,nature,lives,rarity,level));
        menu();
    }

    public static void sortByLv(){
        characters.sort(new Comparator() {
            @Override
            public int compare(Object o1, Object o2) {
                Role r1 = (Role) o1;
                Role r2 = (Role) o2;
                return r2.getLevel() - r1.getLevel();
            }
        });
        show();
    }

    public static void sortByLive(){
        characters.sort(new Comparator() {
            @Override
            public int compare(Object o1, Object o2) {
                Role r1 = (Role) o1;
                Role r2 = (Role) o2;
                return r2.getLiveSeat() - r1.getLiveSeat();
            }
        });
        show();
    }

    public static void remove(){
        System.out.println("请输入指定的等级");
        int lessThanLevel = scanner.nextInt();
        Iterator iterator = characters.iterator();
        while (iterator.hasNext()){
            Role temp =(Role) iterator.next();
            if (temp.getLevel()<lessThanLevel){
                iterator.remove();
            }
        }
        show();
    }
}

