package task3_1;

import temp.*;

/**
 * Created by maks on 19.10.2014.
 */
public class DemoHabrParser {
    public static void main(String[] args) throws InterruptedException {

        Parser parser = new Parser();

        Reader reader = new Reader(parser.getArticles());
        parser.start();
        reader.start();
        for (int i = 0; i < 5; i++) {
            System.out.println("Start thread "+ i);
            Thread.sleep(100);
             new Reader(parser.getArticles()).start();
        }
//        Thread.sleep(4000);

        System.out.println("parser   " +parser.isAlive());
        System.out.println("reader   " +reader.isAlive());

    }
}
