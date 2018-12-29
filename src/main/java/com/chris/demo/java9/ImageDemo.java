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
    // 获取特定分辨率的图像变体-表示一张已知分辨率单位为DPI的特定尺寸大小的逻辑图像，并且这张图像是最佳的变体。。

    //List<Image> getResolutionVariants() ? 返回可读的分辨率的图像变体列表。


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
        // 读取所有图片
        MultiResolutionImage multiResolutionImage = new BaseMultiResolutionImage(images.toArray(new Image[0]));

        // 获取图片的所有分辨率
        List<Image> variants = multiResolutionImage.getResolutionVariants();
        System.out.println("Total number of images: " + variants.size());

        for (Image image : variants) {
            System.out.println(image);
        }

        // 根据不同尺寸获取对应的图像分辨率
        Image variant1 = multiResolutionImage.getResolutionVariant(156, 45);
        System.out.printf("\nImage for destination[%d,%d]: [%d,%d]",
                156, 45, variant1.getWidth(null), variant1.getHeight(null));
    }

}
