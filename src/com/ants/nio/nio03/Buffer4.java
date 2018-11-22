package com.ants.nio.nio03;

import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

/**
 * mark()与reset()：hello_java_nio
 * data.txt   hello_java_nio
 * data1.txt  ello_java_nio
 */
public class Buffer4 {
    public static void main(String[] args) throws Exception {

        RandomAccessFile aFile = new RandomAccessFile("data.txt", "rw");
        RandomAccessFile aFile1 = new RandomAccessFile("data1.txt", "rw");

        FileChannel inChannel = aFile.getChannel();
        FileChannel inChannel1 = aFile1.getChannel();

        ByteBuffer buf = ByteBuffer.allocate(24);//1

        ByteBuffer buf1 = ByteBuffer.allocate(24);//1

        int bytesRead = inChannel.read(buf);
        int bytesRead1 = inChannel1.read(buf1);

        buf.flip();
        buf1.flip();


        System.out.println(buf.equals(buf1));
        System.out.println(buf.compareTo(buf1));

        buf.get();//buf读取一个字符
        System.out.println(buf.equals(buf1));
        System.out.println(buf.compareTo(buf1));


        aFile.close();
        aFile1.close();
    }

}
