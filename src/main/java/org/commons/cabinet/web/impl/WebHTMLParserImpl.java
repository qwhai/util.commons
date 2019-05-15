package org.commons.cabinet.web.impl;

import java.io.IOException;

import org.commons.cabinet.web.interf.HTMLParserable;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

/**
 * <p>
 * 我是一个HTML解析工具，
 * 我负责解析网络上的HTML
 * </p>
 * Create Date: 2015年12月15日
 * Last Modify: 2016年5月26日
 * 
 * @author Q-WHai
 * @see <a href="https://github.com/qwhai">https://github.com/qwhai</a>
 */
public final class WebHTMLParserImpl implements HTMLParserable {

    @Override
    public Document requestHTML(String url) throws IOException {
        Document document = Jsoup.connect(url)
                .header("User-Agent", "Mozilla/5.0 (Windows NT 6.1; WOW64; rv:33.0) Gecko/20100101 Firefox/33.0")
                .get();
        
        return document;
    }
    
    @Override
    public Document requestHTML(String url, int delay) throws IOException {
        Document document = Jsoup.connect(url)
                .header("User-Agent", "Mozilla/5.0 (Windows NT 6.1; WOW64; rv:33.0) Gecko/20100101 Firefox/33.0")
                .timeout(delay)
                .get();
        
        return document;
    }

    @Override
    public String requestHTMLToString(String url) throws IOException {
        return requestHTML(url).toString();
    }

    @Override
    public String requestHTMLText(String url) throws IOException {
        return requestHTML(url).text();
    }

    @Override
    public void downloadHTML(String url, String savePath) throws IOException {
        //String text = requestHTMLToString(url);
        //FileWriteUtils.writeFileCover(savePath, text);
    }

    @Override
    public void downloadHTML(String url, String savePath, int delay)
            throws IOException {
        //String text = requestHTMLToString(url, delay);
        //FileWriteUtils.writeFileCover(savePath, text);
    }

    @Override
    public String requestHTMLToString(String url, int delay)
            throws IOException {
        return requestHTML(url, delay).toString();
    }

    @Override
    public String requestHTMLText(String url, int delay) throws IOException {
        return requestHTML(url, delay).text();
    }

    @Override
    public Document requestHTML(String url, int delay, boolean redirect)
            throws IOException {
        Document doc = Jsoup.connect(url)
                .header("User-Agent", "Mozilla/5.0 (Windows NT 6.1; WOW64; rv:33.0) Gecko/20100101 Firefox/33.0")
                .timeout(delay)
                .followRedirects(redirect)
                .get();
        
        return doc;
    }

    @Override
    public String requestHTMLToString(String url, int delay, boolean redirect)
            throws IOException {
        return requestHTML(url, delay, redirect).toString();
    }

    @Override
    public String requestHTMLText(String url, int delay, boolean redirect)
            throws IOException {
        return requestHTML(url, delay, redirect).text();
    }
}
