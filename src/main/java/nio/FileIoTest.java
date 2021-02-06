package nio;

import java.io.*;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

public class FileIoTest {


    public static void main(String[] args) {
        String path = "/home/liulisheng/文档/DefaultCommentGenerator.java";
//        method2(path);
        method1(path);


    }

    public static void method1(String path){
        RandomAccessFile aFile = null;
        try {
            aFile = new RandomAccessFile(path,"rw");
            FileChannel fileChannel = aFile.getChannel();
            ByteBuffer byteBuffer = ByteBuffer.allocate(1024);
            int byteRead = fileChannel.read(byteBuffer);
            System.out.println(byteRead);
            while (byteRead != -1){
                byteBuffer.flip();
                while(byteBuffer.hasRemaining()){
                    System.out.print((char)byteBuffer.get());
                }
                byteBuffer.compact();
                System.out.println("-----------------  --------------- ");
                byteRead = fileChannel.read(byteBuffer);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }




    public static void method2(String path)  {
        InputStream in = null;

        try {
            in = new BufferedInputStream(new FileInputStream(path));
            byte[] buf = new byte[1024];
            int bytesRead = in.read(buf);
            while (bytesRead != -1){
                for(int i =0; i < bytesRead;i++){
                    System.out.print((char)buf[i]);
                }
                System.out.println("-----------------  --------------- ");
                bytesRead = in.read(buf);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            try {
                in.close();
                in.close();
            } catch (IOException e) {
                e.printStackTrace();
            }

        }
    }


}
