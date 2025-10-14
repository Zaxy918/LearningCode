package fakename;

import java.io.File;
import java.net.URI;
import java.net.URL;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

import cn.hutool.core.io.FileUtil;
import cn.hutool.core.util.ReUtil;
import cn.hutool.http.HttpUtil;

public class App {
    public static void main(String[] args) throws Exception {
        String famName = "https://hanyu.baidu.com/shici/detail?pid=0b2f26d4c0ddb3ee693fdb1137ee1b0d&from=kg0";
        String boyName = "https://www.meimeiming.com/zhouyi/11091.html";
        String girlName = "https://www.meimeiming.com/zhouyi/8347.html";

        String famNameHtml = HttpUtil.get(famName);
        String boyNameHtml = HttpUtil.get(boyName);
        String girlNameHtml = HttpUtil.get(girlName);

        List<String> tempFamNames = ReUtil.findAll("(.{4})(，|。)", (ReUtil.findAll("</br>(.{4}，.{4}。)", famNameHtml, 1)).toString(), 1);
        List<String> tempBoyNames = ReUtil.findAll("[0-9]{1,3}、(.{2})", boyNameHtml, 1);
        List<String> tempGirlNames = ReUtil.findAll("[0-9]{1,3}、(.{2})", girlNameHtml, 1);

        ArrayList<String> boyNames = getBoyNames(tempFamNames, tempBoyNames);
        ArrayList<String> girlNames = getGilrNames(tempFamNames, tempGirlNames);
        ArrayList<String> names = new ArrayList<>(boyNames);
        names.addAll(girlNames);
        Collections.shuffle(names);
        writeNamesToFile(names);
    }

    private static void writeNamesToFile(ArrayList<String> names) {
        File nameFile = new File("src\\res\\name.txt");
        FileUtil.writeLines(names, nameFile, "UTF-8");
    }

    public static ArrayList<String> getBoyNames(List<String> tempFamNames, List<String> tempBoyNames) {
        int cntb = 0;
        Random r = new Random();
        ArrayList<String> boyNames = new ArrayList<>();
        for (int i = 0; i < 15; i++) {
            String fami = tempFamNames.get(i);
            for (int j = 0; j < fami.length(); j++) {
                StringBuilder sb = new StringBuilder();
                sb.append(fami.charAt(j) + tempBoyNames.get(cntb++) + "-男-" + r.nextInt(18, 26) + "-1");
                boyNames.add(sb.toString());
            }
        }
        return boyNames;
    }

    public static ArrayList<String> getGilrNames(List<String> tempFamNames, List<String> tempGirlNames) {
        int cntg = 0;
        Random r = new Random();
        ArrayList<String> girlNames = new ArrayList<>();
        for (int i = 0; i < 15; i++) {
            String fami = tempFamNames.get(i);
            for (int j = 0; j < fami.length(); j++) {
                StringBuilder sb = new StringBuilder();
                sb.append(fami.charAt(j) + tempGirlNames.get(cntg++) + "-女-" + r.nextInt(18, 26) + "-1");
                girlNames.add(sb.toString());
            }
        }
        return girlNames;
    }
}
