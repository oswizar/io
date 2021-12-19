package com.oswizar.io.obtest;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.InputStreamReader;

public class Main {
    public static void main(String args[]) {
        try { // ��ֹ�ļ��������ȡʧ�ܣ���catch��׽���󲢴�ӡ��Ҳ����throw


        	File[] files=(new File("D:\\1\\")).listFiles();

        	for(File f:files) {
        		String pathname = f.getPath(); // ����·�������·�������ԣ������Ǿ���·����д���ļ�ʱ��ʾ���·��
                File filename = new File(pathname); // Ҫ��ȡ����·����input��txt�ļ�

                String fileNameCopy=filename.getName();
                File writename = new File("D:\\2\\"+fileNameCopy); // ���·�������û����Ҫ����һ���µ�output��txt�ļ�
                writename.createNewFile(); // �������ļ�
                BufferedWriter out = new BufferedWriter(new FileWriter(writename));

                InputStreamReader reader = new InputStreamReader(new FileInputStream(filename)); // ����һ������������reader
                BufferedReader br = new BufferedReader(reader); // ����һ�����������ļ�����ת�ɼ�����ܶ���������
                String line = "";
//                line = br.readLine();
                while (true) {
                    line = br.readLine(); // һ�ζ���һ������
                    if(line == null){
                        break;
                    }
                    if(!line.startsWith("--")&&!(line.startsWith("/"))) {

                        out.write(line+"\r\n"); // \r\n��Ϊ����
                        out.flush(); // �ѻ���������ѹ���ļ�
                    }
                }
                out.close(); // ���ǵùر��ļ�
        	}

            /* ����TXT�ļ� */

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
