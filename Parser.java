package task3_1;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import temp.*;

import java.io.IOException;

/**
 * Created by maks on 19.10.2014.
 */
public class Parser extends Thread {


    private ArticleContainer articles = new ArticleContainer();
    private Document document;
    private Elements elements;

    public void run() {
        try {
            document = Jsoup.connect("http://habrahabr.ru/").get();
            Elements elements = document.getElementsByClass("post_title");
//            for(Element element: elements){

            synchronized (articles) {
                for (Element element : elements) {
                    articles.add(new Article(element.text(), element.attr("href")));
//                    articles.canRead = true;
//                    Thread.sleep(100);
                    articles.notifyAll();
                    articles.wait();

                }
                System.out.println("--isReady = fasle--");
                articles.isReady = false;

                articles.notifyAll();


            }


        } catch (IOException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }


    }

    public ArticleContainer getArticles() {
        return articles;
    }
//
//    public static void main(String[] args) {
//        new Parser().run();
//    }
}
