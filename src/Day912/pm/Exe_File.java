package Day912.pm;

import java.io.File;
import java.io.IOException;

public class Exe_File {
    public static void main(String[] args) throws IOException {
        String folderPath = "D:\\#Exe_FileTest\\testFolder";
        String fileName = "test.txt";
        System.out.println("创建目录");
        createFolder(folderPath);
        System.out.println("创建文件");
        createFile(folderPath, fileName);
        System.out.println("显示文件夹");
        listFile("D:\\#Exe_FileTest");
        System.out.println("显示盘符数据");
        listDisk();
        System.out.println("删除文件");
        deleteFile(folderPath + "\\" + fileName);
        System.out.println("删除文件夹");
        deleteFolder(folderPath);
        System.out.println("显示文件信息");
        fileInfo("d:/#Exe_FileTest", "testFile");
    }

    /**
     * 显示文件信息
     *
     * @param path     地址
     * @param filename 文件名
     */
    public static void fileInfo(String path, String filename) {
        File file = new File("C:\\Users\\25603\\Desktop", "exe");
        System.out.println("file size : " + file.length() + "byte");
        System.out.println("file path : " + file.getAbsoluteFile());
    }


    /**
     * 删除文件
     *
     * @param fileFullName 指定删除的文件
     */
    public static void deleteFile(String fileFullName) {
        File file = new File(fileFullName);
        if (!file.exists()) {
            System.out.println(fileFullName + " 文件不存在");
            return;
        }
        if (!file.isFile()) {
            System.out.println(fileFullName + "不是文件，删除停止");
            return;
        }
        if (file.canExecute()) {
            file.delete();
        } else
            System.out.println("无删除权限");
    }

    public static void deleteFolder(String folderPath) {
        File file = new File(folderPath);
        if (!file.exists()) {
            System.out.println("文件夹不存在，删除操作停止");
            return;
        }
        if (file.isFile()) {
            System.out.println("此地址是文件，删除操作停止");
            return;
        }
        if (file.canExecute()) {
            file.delete();
        } else
            System.out.println("无删除权限，删除操作停止");
    }

    /**
     * 新建文件夹
     *
     * @param folderPath 指定的文件夹地址
     */
    public static void createFolder(String folderPath) {
        File file = new File(folderPath);
        if (!file.exists()) {
            file.mkdirs();
        }
    }

    /**
     * 新建文件
     *
     * @param folderPath 指定的文件夹地址
     * @param fileName   新建文件名
     * @throws IOException
     */
    public static void createFile(String folderPath, String fileName) throws IOException {
        File file = new File(folderPath, fileName);
        if (!(file.exists())) {
            file.createNewFile();
        }
    }

    /**
     * 显示系统盘符和磁盘空间
     */
    public static void listDisk() {
        File[] disks = File.listRoots();
        if (disks != null) {
            for (File disk : disks) {
                System.out.println("磁盘：" + disk);
                System.out.printf("\t磁盘大小：%.2f GB \n",
                        (disk.getTotalSpace() / 1024.0 / 1024 / 1024));
                System.out.printf("\t磁盘剩余空间：%.2f GB \n",
                        (disk.getFreeSpace() / 1024.0 / 1024 / 1024));
            }
        }
    }

    /**
     * 显示指定目录下的子目录和文件
     *
     * @param diskName 指定的目录
     */
    public static void listFile(String diskName) {
        File file = new File(diskName);
        File[] files = file.listFiles();
        if (files != null && files.length > 0) {
            for (int i = 0; i < files.length; i++) {
                if (files[i].isDirectory()) {
                    System.out.println("目录名：" + files[i].getAbsolutePath());
                }
                if (files[i].isFile()) {
                    System.out.println("文件: " + files[i].getName());
                }
            }
        }
    }
}
