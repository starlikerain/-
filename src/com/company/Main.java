package com.company;

import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Properties;
import java.util.Set;

public class Main {

    public static void main(String[] args) throws IOException, ClassNotFoundException {
//        readAsSerialized();
//        saveAsSerialized();
//        serializedArray();
        changeSout();
    }

    /**
     * 常识一下，改变 sout 的默认输出目的地
     */
    public static void changeSout () throws FileNotFoundException {
        System.out.println("我在控制台输出");

        System.setOut(new PrintStream("/Users/StarLikeRain/Documents/_JavaCodes/1/输出的目的地.rtf"));

        System.out.println("我应该在文件里面输出了");
    }

    /**
     * 做一个序列化集合
     */
    public static void serializedArray () throws IOException, ClassNotFoundException {
        ArrayList<Person> p = new ArrayList<>();
        p.add(new Person(" 名字1", 18));
        p.add(new Person(" 名字2", 19));
        p.add(new Person(" 名字3", 2000));

        ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream("/Users/StarLikeRain/Documents/_JavaCodes/1/保存的文件.txt"));
        objectOutputStream.writeObject(p);

        ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream("/Users/StarLikeRain/Documents/_JavaCodes/1/保存的文件.txt"));

        Object o = objectInputStream.readObject();
        ArrayList<Person> people = (ArrayList<Person>)o;

        for (Person person : people) {
            System.out.println(person.name + person.age);
        }

        objectInputStream.close();
        objectOutputStream.close();


    }

    /**
     * 读取文件，反序列化
     * @throws IOException
     * @throws ClassNotFoundException
     */
    public static void readAsSerialized() throws IOException, ClassNotFoundException {
        ObjectInputStream ois = new ObjectInputStream(new FileInputStream("/Users/StarLikeRain/Documents/_JavaCodes/1/保存的文件.txt"));
        int len;

        Object obj = ois.readObject();
        ois.close();

        System.out.println(obj);

        Person P = (Person)obj;
        System.out.println(P.getName());
    }


    /**
     * 保存文件，序列化
     * @throws  IOException
     */
    public static void saveAsSerialized() throws IOException {
        ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("/Users/StarLikeRain/Documents/_JavaCodes/1/保存的文件.txt"));
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
