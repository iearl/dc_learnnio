package com.ants.nio.nio05;

import java.io.RandomAccessFile;
import java.nio.channels.FileChannel;

public class TransferTo {
    public static void main(String[] args) throws Exception{
        RandomAccessFile toFile = new RandomAccessFile("data.txt", "rw");


        RandomAccessFile fromFile = new RandomAccessFile("fromFile.txt", "rw");
        FileChannel fromChannel = fromFile.getChannel();
        FileChannel toChannel = toFile.getChannel();

        long position = 0;
        long count = fromChannel.size();

        toChannel.transferTo(position, count, fromChannel);
    }
}
