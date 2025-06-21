package com.laoxu.main;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import java.io.InputStream;
import java.net.URL;
import java.net.URLConnection;

public class GbkFixExample {
    public static void main(String[] args) {
        try {
            String url = "https://x12kwdu4vyv4o08.com:58010/";

            // 建立连接，读取输入流
            URLConnection conn = new URL(url).openConnection();
            conn.setRequestProperty("User-Agent", "Mozilla/5.0");
            conn.setConnectTimeout(10000);
            conn.setReadTimeout(10000);

            // 强制用 GBK 或你猜测的编码（也可能是 GB2312、BIG5）
            InputStream is = conn.getInputStream();
            Document doc = Jsoup.parse(is, "GBK", url);  // 关键点！

            System.out.println("THE TITLE IS: " + doc.title());

            // 示例：打印所有 h1~h3 内容
            doc.select("h1, h2, h3").forEach(el -> System.out.println(el.text()));

            is.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
