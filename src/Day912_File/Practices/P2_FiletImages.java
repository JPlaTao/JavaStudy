package Day912_File.Practices;

import java.io.File;

public class P2_FiletImages {
    public static void main(String[] args) {
            getImages("C:\\Users\\25603\\Pictures\\Screenshots");
    }
    public static void getImages(String direPath){
        File file = new File(direPath);
        if (file.isFile()){
            return;
        }
        File[] images = file.listFiles((dir, name) -> name.endsWith(".jpg")||name.endsWith(".png")||name.endsWith(".gif"));
        for (File  i : images) {
            System.out.println(i.getName());
        }
    }
}
