import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    private static ArrayList<File> fileList = new ArrayList<>();
    private static File folder;
    public static void main(String[] args) {
        while(!fileCheck().isDirectory());

        String extension = "";
        for(String file: folder.list()){
            extension = file.substring(file.lastIndexOf("."));
            extension = extension.replace(".", "");

            System.out.println(file);

        }
    }
    static File fileCheck(){
        System.out.println("フォルダーのPATHをペーストしてください");
        Scanner scanner = new Scanner(System.in);
        String path = scanner.nextLine();
        folder = new File(path);
        return folder;
    }
    static String[][] setExtension(){
        System.out.println("以下のリストから拡張子を指定してください");
        System.out.println("ts" +
                "flv");
        Scanner scanner1 = new Scanner(System.in);
        return scanner1.nextLine();
    }
}
