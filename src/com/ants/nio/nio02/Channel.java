package com.ants.nio.nio02;

import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

/**
 * Java NIO的通道
 * rw:读文件，如果文件不存在就新建文件
 */
public class Channel {
    public static void main(String[] args) throws Exception {

        RandomAccessFile aFile = new RandomAccessFile("data.txt", "rw");
        FileChannel inChannel = aFile.getChannel();

        ByteBuffer buf = ByteBuffer.allocate(48);

        int bytesRead = inChannel.read(buf);
        while (bytesRead != -1) {
            //管道能读取到的长度
            System.out.println("Read " + bytesRead);
            buf.flip();
            //读取到管道的内容
            while (buf.hasRemaining()) {
                System.out.print((char) buf.get());
            }

            buf.clear();
            bytesRead = inChannel.read(buf);
        }
        aFile.close();
    }
}
