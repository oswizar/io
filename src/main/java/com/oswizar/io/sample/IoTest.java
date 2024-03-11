package com.oswizar.io.sample;



import java.io.*;

public class IoTest {

    
    public void ioTest() throws Exception {

        // TODO Auto-generated method stub
        File file = new File("aa.txt");//文件默认就创建在你创建的项目下面，刷新即可看到
        System.out.println(file.exists());//判断文件是否存在
        file.createNewFile();//创建文件，不是文件夹
        System.out.println(file.exists());//再次判断是否存在
        System.out.println(file.getName());//获取文件的名字
        System.out.println(file.getAbsolutePath());//获取文件的绝对路径
        System.out.println(file.getPath());//获取文件的相对路径
        System.out.println(file.getParent());//获取文件的父路径
        System.out.println(file.canRead());//文件是否可读
        System.out.println(file.canWrite());//文件是否可写
        System.out.println(file.length());//文件的长度
        System.out.println(file.lastModified());//文件最后一次修改的时间
        System.out.println(file.isDirectory());//判断文件是否是一个目录
        System.out.println(file.isHidden());//文件是否隐藏
        System.out.println(file.isFile());//判断文件是否存在
    }

    /**
     * D:\app
     */
    
    public void fileTest() {
        File file = new File("D:/");//指定文件路径
        File[] f = file.listFiles();//获取指定目录下的所有文件或者文件夹的File数组
        System.out.println(f);
        for (File fi : f) {//加强for循环遍历输出
            System.out.println(fi);
        }
    }


    /**
     * app
     */
    
    public void stringFileTest() {
        File file = new File("D:/");//指定文件目录
        String[] str = file.list();//获取指定目录下的所有文件或者文件夹的名称数组
        System.out.println(str);
        for (String s : str) {//加强for循环遍历输出
            System.out.println(s);
        }
    }

    /**
     * 输出指定后缀的文件
     */
    
    public void endWithTest(){
        File file = new File("D:\\Picture");
        String [] list = file.list();
        for (String li: list) {
            if(li.endsWith(".jpg")||li.endsWith(".png")){
                System.out.println(li);

            }
        }
    }


    /**
     * 字节文件流测试
     * 如一个ASCII码就是一个字节
     * @throws IOException
     */
    
    public void inputOutputTest() throws IOException {
        FileInputStream fis = new FileInputStream("aa.txt");
        FileOutputStream fos = new FileOutputStream("bb.txt",true);
        System.out.println(fis);
        System.out.println(fos);
        int a = fis.read();
        System.out.println(a);

        fos.write(97);
        System.out.println(fos);

        fis.close();
        fos.close();
    }


    
    public void copyTest(){
        try {
            FileInputStream fis = new FileInputStream("aa.txt");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        try {
            FileOutputStream fos = new FileOutputStream("bb.txt");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

    }

}
