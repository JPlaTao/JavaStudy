package Practice816;

public class ACT {
    private static int id_Private;
    public static int getId_public(){
        return ACT.id_Private;
    }


    public static void main(String[] args) {
        ACT.getId_public();
    }
}
