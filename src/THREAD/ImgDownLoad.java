package THREAD;
import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

/**
 * @ClassName ImgDownLoad
 * @Description
 * @Author Administrator
 * @Date 2023/4/1 16:49
 * @Version V1.0
 */
public class ImgDownLoad {
    public static void download(String url,String name) {
        try {
            FileUtils.copyURLToFile(new URL(url),new File(name));
        }catch (MalformedURLException e){
            e.printStackTrace();
            System.out.println("不合法的url");
        }catch (IOException e){
            e.printStackTrace();
            System.out.println("下载失败");
        }
    }
}
