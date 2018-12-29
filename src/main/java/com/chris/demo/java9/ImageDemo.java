package com.chris.demo.java9;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BaseMultiResolutionImage;
import java.awt.image.MultiResolutionImage;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class ImageDemo {

    //Image getResolutionVariant(double destImageWidth, double destImageHeight) ?
    // ��ȡ�ض��ֱ��ʵ�ͼ�����-��ʾһ����֪�ֱ��ʵ�λΪDPI���ض��ߴ��С���߼�ͼ�񣬲�������ͼ������ѵı��塣��

    //List<Image> getResolutionVariants() ? ���ؿɶ��ķֱ��ʵ�ͼ������б�


    public static void main(String[] args) throws IOException, MalformedURLException {

        List<String> imgUrls = List.of("http://www.runoob.com/wp-content/themes/runoob/assets/img/runoob-logo@2x.png",
                "http://www.runoob.com/wp-content/themes/runoob/assets/img/runoob-logo.png",
                "http://www.runoob.com/wp-content/themes/runoob/assets/images/qrcode.png");

        List<Image> images = new ArrayList<Image>();
        imgUrls.stream().map(e -> {
            try {
                images.add(ImageIO.read(new URL(e)));
            } catch (MalformedURLException mue) {

            } catch (IOException ioe) {

            }
            return true;
        }).collect(Collectors.toList());
        // ��ȡ����ͼƬ
        MultiResolutionImage multiResolutionImage = new BaseMultiResolutionImage(images.toArray(new Image[0]));

        // ��ȡͼƬ�����зֱ���
        List<Image> variants = multiResolutionImage.getResolutionVariants();
        System.out.println("Total number of images: " + variants.size());

        for (Image image : variants) {
            System.out.println(image);
        }

        // ���ݲ�ͬ�ߴ��ȡ��Ӧ��ͼ��ֱ���
        Image variant1 = multiResolutionImage.getResolutionVariant(156, 45);
        System.out.printf("\nImage for destination[%d,%d]: [%d,%d]",
                156, 45, variant1.getWidth(null), variant1.getHeight(null));
    }

}
