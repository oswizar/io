
package com.oswizar.io.sample.iodemo;




import java.io.*;

public class IoStream {

    /**
     * 创建一个文件
     */
    
    public void crateFile() {

        String fileName = "d:" + File.separator + "app" + File.separator + "haha.txt";
        File f = new File(fileName);

        try {
            f.createNewFile();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    /**
     * 删除文件
     */
    
    public void deleteFile() {
        File f = new File("d:/app/hello.txt");
        if (f.exists()) {
            f.delete();
            System.out.println("文件" + f.getName() + "删除成功!");
        } else {
            System.out.println("文件不存在!");
        }
    }

    /**
     * 创建一个文件夹
     */
    
    public void createDir() {
        File f = new File("d:/app/hello1");
        if (f.exists()) {
            System.out.println("文件(文件夹)已存在");
        } else {
            f.mkdir();
            System.out.println("创建成功");
        }
    }

    /**
     * 列出指定目录的全部文件(包括隐藏文件)
     */
    
    public void listFile() {
        File f = new File("D:/");
        File[] list = f.listFiles();
        for (int i = 0; i < list.length; i++) {
            System.out.println(list[i]);

        }
    }

    /**
     * 搜索指定目录下的所有文件
     */
    
    public void completeFile() {
        File f = new File("d:/tmp/");
        print(f);
    }

    public void print(File f) {
        if (f != null) {
            if (f.isDirectory()) {
                File[] filesArray = f.listFiles();
                if (filesArray != null) {
                    for (int i = 0; i < filesArray.length; i++) {
                        print(filesArray[i]);
                    }
                }
            } else {
                System.out.println(f);
            }
        }
    }


    /**
     * 使用RandomAccessFile写入文件
     */
    
    public void randomFile() throws Exception {
        File file = new File("d:/app/aaa.txt");
        RandomAccessFile raf = new RandomAccessFile(file, "rws");
        raf.writeBytes("adfsfsafadsf");
        raf.writeInt(1234);
        raf.writeChar('W');
        raf.writeFloat(1.25F);
        raf.writeDouble(1.255);
        raf.close();
//        System.out.println(raf.toString());
    }


    /**
     * 向文件中写入字符串
     */
    
    public void writeStrings() throws Exception {
        File file = new File("d:/app/aaab.txt");
        OutputStream out = new FileOutputStream(file);
        String str = "向文件中写入字符串1wwqdqw12e12e";
        byte[] b = str.getBytes();
        // 将数组b中的所有字节写到输出流中
        out.write(b);
        out.close();
    }


    /**
     * 向文件中写入字符串(一个字节一个字节写入)
     */
    
    public void writeStringsByte() throws Exception {
        File file = new File("d:/app/aaab.txt");
        OutputStream out = new FileOutputStream(file);
        String str = "向文件中写入字符串1wwqdqw12e12e";
        byte[] b = str.getBytes();
        for (int i = 0; i < b.length; i++) {
            // 将数组中的每个字节写到输出流中
            out.write(b[i]);
        }
        out.close();
    }

    /**
     * 向文件中追加新内容
     */
    
    public void appendString() throws Exception {
        File file = new File("d:/app/aaab.txt");
        OutputStream out = new FileOutputStream(file, true);
        String str = "\n新追加的内容1111";
        byte[] b = str.getBytes();
        for (int i = 0; i < b.length; i++) {
            out.write(b[i]);
        }
        out.close();
    }


///////////////////////////////////////////////////////////////////

    /**
     * 读取文件内容
     */
    
    public void readFile() throws Exception {
        File file = new File("d:/app/aaab.txt");
        InputStream in = new FileInputStream(file);
        byte[] b = new byte[1024];
        // 从输入流中读入字节，并将其存储到缓冲数组b中
        in.read(b);
        in.close();
        System.out.println(new String(b));
    }


    /**
     * 读取文件内容(高效)
     */
    
    public void readFileByLength() throws Exception {
        File file = new File("d:/app/aaab.txt");
        InputStream in = new FileInputStream(file);
        byte[] b = new byte[1024];
        int len = in.read(b);
        in.close();
        System.out.println("读取字符串的长度为:" + len);
        System.out.println(new String(b, 0, len));
    }

    /**
     * 读取文件内容(先计算长度)
     */
    
    public void readFilePreLength() throws Exception {
        File file = new File("d:/app/aaab.txt");
        InputStream in = new FileInputStream(file);
        byte[] b = new byte[(int) file.length()];
        in.read(b);
        in.close();
        System.out.println("读取字符串的长度为:" + file.length());
        System.out.println(new String(b));
    }

    /**
     * 读取文件内容(判断是否到文件末尾)
     */
    
    public void readFileDynamic() throws Exception {
        File file = new File("d:/app/aaab.txt");
        InputStream in = new FileInputStream(file);
        byte[] b = new byte[2048];
        int count = 0;
        int temp = 0;
        while ((temp=in.read()) != -1) {
            b[count++] = (byte)temp;
        }
        System.out.println("读取字符串的实际长度为:" + count);
        in.close();
        System.out.println(new String(b));
    }



    /////////////////////////字符流////////////////////////////////////

    /**
     * 字符流写入文件
     */
    
    public void writeFile() throws Exception {
        File file = new File("d:/app/aaab.txt");
        Writer writer = new FileWriter(file);
        String str = "字符流写入文件";
        writer.write(str);
        writer.close();
    }

    /**
     * 字符流读取文件
     */
    
    public void readStringFile() throws Exception {
        File file = new File("d:/app/aaab.txt");
        Reader reader = new FileReader(file);
        char[] chars = new char[(int) file.length()];
        reader.read(chars);
        reader.close();
        System.out.println("读取的内容为：" + new String(chars));
    }


    /**
     * 文件的复制
     */
    
    public void copyFile () throws Exception {
        File file1 = new File("d:/app/aaab.txt");
        File file2 = new File("d:/app/haha.txt");
        if (!file1.exists()) {
            System.out.println("被复制的文件不存在");
            System.exit(1);
        } else {
            InputStream in = new FileInputStream(file1);
            OutputStream out = new FileOutputStream(file2,true);
            if ((in != null) && (out != null)) {
                int temp = 0;
                while ((temp = in.read()) != (-1)) {
                    out.write(temp);
                }
            }
            in.close();
            out.close();
        }
    }





































}
