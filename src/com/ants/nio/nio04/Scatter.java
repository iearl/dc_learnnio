package com.ants.nio.nio04;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.nio.Buffer;
import java.nio.ByteBuffer;
import java.nio.channels.Channel;
import java.nio.channels.FileChannel;

public class Scatter {
    public static void main(String[] args) throws Exception {
        FileInputStream is = new FileInputStream(new File("data.txt"));
        FileChannel ch = is.getChannel();

        ByteBuffer buf1 = ByteBuffer.allocate(4);
        ByteBuffer buf2 = ByteBuffer.allocate(40);

        ByteBuffer[] bufferArray = { buf1, buf2 };

        ch.read(bufferArray);


        buf1.flip();
        buf2.flip();

        while (buf1.hasRemaining()) {
            System.out.print((char) buf1.get());
        }
        System.out.println();
        while (buf2.hasRemaining()) {
            System.out.print((char) buf2.get());
        }
    }
}
