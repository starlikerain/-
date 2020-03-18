package com.company;

import java.io.*;
import java.util.HashMap;
import java.util.Properties;
import java.util.Set;

public class Main {

    public static void main(String[] args) throws IOException, ClassNotFoundException {
        readAsSerialized();
    }


    // 读取存在于文件中的对象，对象的反序列化
    public static void readAsSerialized() throws IOException, ClassNotFoundException {
        ObjectInputStream ois = new ObjectInputStream(new FileInputStream("/Users/StarLikeRain/Documents/_JavaCodes/1/serilizedIn.txt"));
        int len;

        Object obj = ois.readObject();
        ois.close();

        System.out.println(obj);

        Person P = (Person)obj;
        System.out.println(P.getName());
    }

    public static void saveAsSerialized() throws IOException {
        ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("/Users/StarLikeRain/Documents/_JavaCodes/1/serilizedIn.txt"));
        oos.writeObject(new Person("啊", 12));
        oos.close();
    }

    public static void inputGBK() throws IOException {
        InputStreamReader myInputStreamReader = new InputStreamReader(new FileInputStream("/Users/StarLikeRain/Documents/_JavaCodes/1/gbk.txt"), "GBK");
        int len;
        while(
                (len = myInputStreamReader.read()) != -1
        ){
            System.out.println((char) len);
        }
    }

    public static void outputGBK() throws IOException {
        OutputStreamWriter gbkWriter = new OutputStreamWriter(new FileOutputStream("/Users/StarLikeRain/Documents/_JavaCodes/1/gbk.txt"), "gbk");

        gbkWriter.write("你好啊");

        gbkWriter.flush();
        gbkWriter.close();

    }

    public static void goRead() throws IOException {
        HashMap<String, String> hashMap = new HashMap<>();
        BufferedReader br = new BufferedReader(new FileReader("/Users/StarLikeRain/Documents/_JavaCodes/1/disorderdText.txt"));
        BufferedWriter bw = new BufferedWriter(new FileWriter("/Users/StarLikeRain/Documents/_JavaCodes/1/trashOut.txt"));

        String line;

        while (
                (line = br.readLine()) != null
        ) {
            // 把每一行都按照 排序+内容 放到 hashMap 中
            String[] split = line.split("\\.");
            // hashMap 会自动排序的
            hashMap.put(split[0], split[1]);
        }

        for (String key : hashMap.keySet()) {
            bw.write(key + hashMap.get(key));
            bw.newLine();
        }

        bw.close();
        br.close();

    }
}
