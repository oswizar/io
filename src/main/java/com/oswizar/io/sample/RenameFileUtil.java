package com.oswizar.io.sample;

import java.io.File;

public class RenameFileUtil {
    private static final String path="xxxxxxxxx";
    public static void main(String[] args) {
        File file = new File(path);
//        file.listFiles((dir, name) -> !name.equals(".DS_Store"));
        File[] tempList = file.listFiles((dir, name) -> !name.equals(".DS_Store"));

        for (int i = 0; i < tempList.length; i++) {
            if (tempList[i].isFile()) {
                //原名称
                String oldFileName  = tempList[i].getName();
                String fileName = oldFileName.substring(0,10);
                tempList[i].renameTo(new File(path+"/"+fileName));
            }
        }
    }

}
