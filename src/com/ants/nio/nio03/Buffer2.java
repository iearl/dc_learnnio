package com.ants.nio.nio03;

import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

/**
 * 测试rewind()：hello_java_nio
 *   1注释前  输出两次 hello_java_nio
 *   1注释后 输出一次 hello_java_nio
 */
public class Buffer2 {
    public static void main(String[] args) throws Exception {

        RandomAccessFile aFile = new RandomAccessFile("data.txt", "rw");

        FileChannel inChannel = aFile.getChannel();

        ByteBuffer buf = ByteBuffer.allocate(24);//1

        int bytesRead = inChannel.read(buf);
        while (bytesRead != -1) {
            //管道能读取到的长度
            buf.flip();
            //读取到管道的内容
            while (buf.hasRemaining()) {
                System.out.print((char) buf.get());
            }
            System.out.println();
            buf.rewind();//1
            while (buf.hasRemaining()) {
                System.out.print((char) buf.get());
            }
            buf.clear();
            bytesRead = inChannel.read(buf);
        }
        aFile.close();
    }
}
