import sun.misc.IOUtils;

import java.io.*;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    private static ArrayList<String> fileList = new ArrayList<>();
    private static ArrayList<String> selectedFileList = new ArrayList<>();
    private static File folder;
    public static void main(String[] args) throws IOException {
        System.out.println("指定するフォルダの中にフォルダがあると、エラーが発生するので事前に移動させてください");

        while(!fileCheck().isDirectory());
        setFfmpeg();

        String settedExtension = setExtension();
        String extension = "";

        for(String file: folder.list()){
            extension = file.substring(file.lastIndexOf("."));
            extension = extension.replace(".", "");

            System.out.print(extension);
            System.out.println(file);


            if(extension.equals(settedExtension)){
                fileList.add(file);
            }


        }

        System.out.println(fileList.size());

        String command1 = "ffmpeg -i ";
        String command2 = ".mp4";
        String command3 = "-vcodec h264_nvenc";

        char c = 92;
        for(String a : fileList){
            selectedFileList.add(folder + String.valueOf(c) + a);
        }
        for(String a : selectedFileList){
            Runtime runtime = Runtime.getRuntime();
            String command = command1 + a + " " + command3 + " " + a + ".mp4";
            //Process process = runtime.exec(command);
			System.out.println(command);
        }
        System.out.println("成功しました");
    }

    private static boolean getDirectory(String file) {
        File file1 = new File(file);
        return file1.isDirectory();
    }

    static File fileCheck(){
        System.out.println("フォルダーのPATHをペーストしてください");
        Scanner scanner = new Scanner(System.in);
        String path = scanner.nextLine();
        folder = new File(path);
        return folder;
    }
    static String setExtension(){
        System.out.println("拡張子を指定してください");
        Scanner scanner1 = new Scanner(System.in);
        return scanner1.nextLine();
    }
    static void setFfmpeg(){
        System.out.println("FFmpegをインストールしておいてください");
    }
    static String convertInputStreamToString(InputStream is) throws IOException {
        InputStreamReader reader = new InputStreamReader(is);
        StringBuilder builder = new StringBuilder();
        char[] buffer = new char[1024];
        int read;
        while (0 <= (read = reader.read(buffer))) {
            builder.append(buffer, 0, read);
        }
        return builder.toString();
    }
}
