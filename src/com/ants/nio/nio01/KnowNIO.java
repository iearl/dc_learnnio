package com.ants.nio.nio01;

import java.io.File;
import java.io.FileOutputStream;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

/**
 * NIO 概述
 * 利用nio完成文件写
 */
public class KnowNIO {
    public static void main(String[] args) throws Exception  {
        File file = new File("data.txt");
        FileOutputStream outputStream = new FileOutputStream(file);
        FileChannel channel = outputStream.getChannel();
        ByteBuffer buffer = ByteBuffer.allocate(1024);
        String string = "hello java nio";
        buffer.put(string.getBytes());
        buffer.flip();     //此处必须要调用buffer的flip方法
        channel.write(buffer);
        channel.close();
        outputStream.close();
    }
}
