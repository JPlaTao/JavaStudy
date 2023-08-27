package Day815_Object_QuickSort;

public class GirlFriend {
    String name;
    double height;
    double weight;
    public GirlFriend(String name,double height,double weight){
        this.name = name;
        this.height = height;
        this.weight = weight;
    }
    public void wash(){
        System.out.println("女朋友帮我洗衣服");
    }
    public void cock(){
        System.out.println("女朋友给我做饭");
    }
    public void show(){
        System.out.println("我的女朋友叫"+ name+",身高"+height+"厘米,体重"+weight+"斤。");
    }
}
