package com.student.crm.web.controller;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.*;

/**
 * Created by Administrator on 2017/10/17.
 */
@Controller
@RequestMapping("crawler")
public class CrawlerController {


    @RequestMapping("lookForUrl")
    @ResponseBody
    public List<Map<String,String>> crawler() throws Exception {


        Map<String, String> map = null;
        List<Map<String, String>> listUrl = new ArrayList<>();
        Set<String> list = new HashSet<>();
        String pageNo = "http://tieba.baidu.com/f/search/res?ie=utf-8&qw=java%E5%9F%B9%E8%AE%AD&red_tag=t0099689223";
        List<Document> docList = new ArrayList<Document>();
        // 循环的前面十页的页面代码
        for (int i = 0; i < 10; i++) {
            Document doc = Jsoup.connect(pageNo + i).get();
            String title = doc.title();
            Element content = doc.getElementById("content");
            Elements links = doc.getElementsByTag("a");
            for (Element link : links) {
                String linkHref = link.attr("href");
                String linkText = link.text().trim() + "";
                if (!list.contains(linkText) && linkText.contains("回复")) {

                    map = new HashMap<>();
                    map.put("linkText",linkText);
                    map.put("linkHref","http://tieba.baidu.com" + linkHref);
                    list.add(linkText);
                    listUrl.add(map);
                }
            }
        }
        return listUrl;
    }
}
