package Day915_DeepCopy_JSON.am;

import java.io.*;

public class Exe_someStream {
    public static void main(String[] args) {
        File file = new File(
                "D:\\4.WorkSpace\\JAVA\\java-study\\src\\Day915_someOtherStream\\testFile_Data.txt");
        try (/*PrintStream ps = new PrintStream(file)*/
                DataOutputStream dos = new DataOutputStream(new FileOutputStream(file))){
//            //PrintStream
//            ps.printf("this is %d test\n",3);
//            System.setOut(ps);
//            System.out.print("sout test");
            int[] nums = new int[]{1,2,3,4,5,6};
            for (int num : nums) {
                dos.write(num);
            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
}
class person{

}