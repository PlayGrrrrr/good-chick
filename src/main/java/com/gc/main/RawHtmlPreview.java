package com.gc.main;
import java.io.InputStream;
import java.net.URL;
import java.net.URLConnection;
import java.nio.charset.Charset;

public class RawHtmlPreview {
    public static void main(String[] args) {
        try {
            String url = "https://x12kwdu4vyv4o08.com:58010/";
            URLConnection conn = new URL(url).openConnection();
            conn.setRequestProperty("User-Agent", "Mozilla/5.0");
            conn.setConnectTimeout(10000);
            conn.setReadTimeout(10000);

            InputStream in = conn.getInputStream();
            byte[] data = in.readAllBytes();
            in.close();

            // 尝试多种编码方式查看网页头部原始字符
            for (String charset : new String[]{"UTF-8", "GBK", "GB2312", "GB18030", "Big5"}) {
                System.out.println("==== 尝试编码：" + charset + " ====");
                String html = new String(data, Charset.forName(charset));
                System.out.println(html.substring(0, Math.min(1500, html.length())));
                System.out.println();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
