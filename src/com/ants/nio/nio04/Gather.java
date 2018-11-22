package com.ants.nio.nio04;

import java.io.File;
import java.io.FileOutputStream;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

public class Gather {
    public static void main(String[] args) throws Exception{
        File file = new File("data.txt");
        FileOutputStream outputStream = new FileOutputStream(file);
        FileChannel channel = outputStream.getChannel();
        ByteBuffer buffer = ByteBuffer.allocate(300);
        ByteBuffer buffer1 = ByteBuffer.allocate(100);
        ByteBuffer[] bufferArray = { buffer, buffer1 };

        String string = "hello_java_nio";
        String string1 = "123456789";
        buffer.put(string.getBytes());
        buffer1.put(string1.getBytes());

        buffer.rewind();
        buffer1.rewind();
        channel.write(bufferArray);
        channel.close();
        outputStream.close();
    }
}
