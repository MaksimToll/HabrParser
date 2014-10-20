package task3_1;

import temp.*;

/**
 * Created by maks on 19.10.2014.
 */
public class Reader extends Thread {
    ArticleContainer articles;
    private int current;
    public Reader(ArticleContainer articles) {
        this.articles = articles;
    }

    @Override
    public void run() {
        synchronized (articles) {


                if (articles.isReady == false) {
                    try {
                        System.out.println("!!!!!waiting parser!!!!!!");
                        articles.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                while (articles.isReady) {
                    System.out.println("Read...");
                    view();
                    articles.notifyAll();
                    try {
                        if (articles.isReady)
                            System.out.println(".....S");
                        articles.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        System.out.println("Reader read");
        }



    private void view() {
        System.out.println("in view!!");

        while (current <articles.getCurrent()) {
            System.out.println(articles.getElement(current++));
        }
        System.out.println("size articles = "+articles.size());
    }
}
