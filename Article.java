package task3_1;

/**
 * Created by maks on 17.10.2014.
 */
public class Article {
    public String getName() {
        return name;
    }

    public String getLink() {
        return link;
    }

    private String name;

    @Override
    public String toString() {
        return "Article{" +
                "name='" + name + '\'' +
                ", link='" + link + '\'' +
                '}';
    }

    private String link;
    public Article(String name, String link){
        this.link = link;
        this.name = name;

    }

}
