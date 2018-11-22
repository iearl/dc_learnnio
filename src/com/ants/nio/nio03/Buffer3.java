package com.ants.nio.nio03;

import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

/**
 * mark()与reset()：hello_java_nio
 *     通过调用Buffer.mark()方法，可以标记Buffer中的一个特定position。
 *     通过调用Buffer.reset()方法恢复到这个position。
 *
 *   1注释前  hello_java_nio
 *           llo_java_nio
 *   1注释后  hello_java_nio
 */
public class Buffer3 {
    public static void main(String[] args) throws Exception {

        RandomAccessFile aFile = new RandomAccessFile("data.txt", "rw");

        FileChannel inChannel = aFile.getChannel();

        ByteBuffer buf = ByteBuffer.allocate(24);//1

        int bytesRead = inChannel.read(buf);
        int count=0;//1
        while (bytesRead != -1) {
            //管道能读取到的长度
            buf.flip();
            //读取到管道的内容
            while (buf.hasRemaining()) {
                System.out.print((char) buf.get());
                if(++count==2){//2
                   buf.mark();//3
                }
            }
            //buf.reset();//4
            System.out.println();
            while (buf.hasRemaining()) {
                System.out.print((char) buf.get());

            }
            buf.clear();
            bytesRead = inChannel.read(buf);
        }
        aFile.close();
    }
}
