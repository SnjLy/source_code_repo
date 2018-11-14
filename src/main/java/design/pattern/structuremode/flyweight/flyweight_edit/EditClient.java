package design.pattern.structuremode.flyweight.flyweight_edit;

import design.pattern.structuremode.flyweight.flyweight_example.Coordinates;

/**
 * @Package: design.pattern.structuremode.flyweight.flyweight_edit
 * @Description:
 * @function:
 * @Author : LiuYong
 * Created by yehao on 2018/9/6.
 */
public class EditClient {

    public static void main(String[] args) {
        FunctionEdit edit = FunctionEdit.getEdit();

        AbstractFile video1, video2, picture1, picture2, cartoon1, cartoon2;
        video1 = edit.getCompnont("video");
        video2 = edit.getCompnont("video");
        System.out.println("视频组件：" + (video1==video2));

        picture1 = edit.getCompnont("picture");
        picture2 = edit.getCompnont("picture");
        System.out.println("图片组件：" + (picture1 == picture2));


        cartoon1 = edit.getCompnont("cartoon");
        cartoon2 = edit.getCompnont("cartoon");
        System.out.println("动漫组件：" + (cartoon1 == cartoon2));


        ComositeFlyweight composit = new ComositeFlyweight();
        composit.addFlyweight(cartoon1);
        composit.addFlyweight(video1);
        composit.addFlyweight(picture1);
        composit.operate(new FileAttribute(5, new Coordinates(8,8)));

        video1.show(new FileAttribute(10, new Coordinates(1,5)));
        video2.show(new FileAttribute(6, new Coordinates(12,15)));

        picture1.show(new FileAttribute(2, new Coordinates(10,5)));
        picture2.show(new FileAttribute(1, new Coordinates(10,34)));

        cartoon1.show(new FileAttribute(232, new Coordinates(23,35)));
        cartoon2.show(new FileAttribute(23, new Coordinates(13,53)));
    }
}
