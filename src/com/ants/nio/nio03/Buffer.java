package com.ants.nio.nio03;

import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

/**
 * 测试compact\clear ：hello_java_nio
 *   allocate分配4个字节，四个字节为一组显示
 *     1 2 3步骤：clear会清空缓存              输出  hovi  分别是4个字节中第一个
 *     1 2 4步骤：未读的数据拷贝到Buffer起始处 输出:hello_java_ 只有最后三个字节没有输出
 */
public class Buffer {
    public static void main(String[] args) throws Exception {

        RandomAccessFile aFile = new RandomAccessFile("data.txt", "rw");

        FileChannel inChannel = aFile.getChannel();

        ByteBuffer buf = ByteBuffer.allocate(4);//1

        int bytesRead = inChannel.read(buf);
        while (bytesRead != -1) {
            //管道能读取到的长度
            buf.flip();
            //读取到管道的内容
            while (buf.hasRemaining()) {
                System.out.print((char) buf.get());
                break;//2
            }
            buf.clear();//clear 3
            //buf.compact();//compact 4
            bytesRead = inChannel.read(buf);
        }
        aFile.close();
    }
}
