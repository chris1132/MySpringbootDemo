package com.chris.demo.nio;

import java.io.FileInputStream;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

/**
 * Created by wangchaohui on 2018/8/7.
 */
public class NioTest2 {

    public static void main(String[] arg) throws Exception {
        FileInputStream fileInputStream = new FileInputStream("MySpringbootDemo\\src\\main\\java\\com\\chris\\demo\\nio\\text\\Niotest.txt");
        FileChannel fileChannel = fileInputStream.getChannel();

        ByteBuffer byteBuf = ByteBuffer.allocate(512);
        fileChannel.read(byteBuf);

        byteBuf.flip();

        while (byteBuf.hasRemaining()) {
            System.out.print((char) byteBuf.get());
        }
        fileInputStream.close();
    }
}
