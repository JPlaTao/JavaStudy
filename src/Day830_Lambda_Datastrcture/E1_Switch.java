package Day830_Lambda_Datastrcture;
interface Nintendo {
    void game();
}
class Switch {
    public static void main(String[] args) {
        Nintendo bow = new Nintendo() {
            @Override
            public void game() {
                System.out.println("野吹，启动！");
            }
        };
        Nintendo tok = ()-> System.out.println("王泪，启动！");
        bow.game();
        tok.game();
    }
}
