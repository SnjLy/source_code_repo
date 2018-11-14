package ansj.snsj_seg;

/**
 * @Package: ansj.snsj_seg
 * @Description:
 * @function:
 * @Author : LiuYong
 * Created by yehao on 2018/7/6.
 */
public class JavaNull {

    public static void main(String[] args) {
        Integer prepare = null;
        if ( 0 == prepare){  // nullPointerException
            System.out.println("null");
        }else{
            System.out.println("not null");
        }

    }
}
