package THREAD;

/**
 * @ClassName ImgMainThread
 * @Description
 * @Author Administrator
 * @Date 2023/4/1 16:54
 * @Version V1.0
 */
public class ImgMainThread extends Thread{
    private String url;
    private String name;
    public ImgMainThread(String url,String name){
        this.url = url;
        this.name = name;
    }

    public void run(){
        ImgDownLoad imgDownLoad = new ImgDownLoad();
        imgDownLoad.download(url,name);
        System.out.println(name);
    }
    public static void main(String[] args) {
        ImgMainThread imt1 = new ImgMainThread("https://img0.baidu.com/it/u=1289268361,3819617468&fm=253&fmt=auto&app=138&f=PNG?w=343&h=500","bilan.jpg");
        ImgMainThread imt2 = new ImgMainThread("https://pic.616pic.com/photoone/00/03/96/618ce5441d6a75161.jpg!/fw/1120","sky.jpg");

        imt1.start();
        imt2.start();

    }
}
