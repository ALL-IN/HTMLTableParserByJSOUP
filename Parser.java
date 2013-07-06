import java.io.FileWriter;
import java.io.IOException;
import java.util.Iterator;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import com.google.gson.Gson;

/**
 * Author: Aleksey Alekseenko
 * Date: 05.07.13
 */
public class Parser {
    public static void main(String[] args) {
        Document doc;
        try {
            doc = Jsoup.connect("http://dota-academy.com/herolist")
                    .userAgent("Mozilla/5.0 (Windows NT 6.1; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/27.0.1453.116 Safari/537.36")
                    .referrer("http://www.google.com").get();
            Elements table = doc.select("div[id=tabs-1]");
            for (Element row : table.select("tr")) {
                Elements tds = row.select("td");
                if (!tds.isEmpty()) {
                    Element link = row.select("a[href]").first();
                    String detailsUrl = link.attr("href");
                    Element img = row.select("img[src]").first();
                    String iconUrl = img.attr("src");
                    HeroObject heroObject = new HeroObject(tds, detailsUrl, iconUrl);
                    StringBuffer sb = new StringBuffer("c:\\java education\\dota\\heroes\\");
                    Gson gson = new Gson();
                    String json = gson.toJson(heroObject);
                    FileWriter writer = new FileWriter(String.valueOf(sb.append(heroObject.getNameOfFile()).append(".json")));
                    writer.write(json);
                    writer.close();
                    System.out.println(json);
                    System.out.println(tds.text());
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}