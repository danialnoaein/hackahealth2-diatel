package models;

import java.util.ArrayList;
import java.util.List;

public class Article {

    int id;
    String imageUrl , title , article;

    public Article(int id, String title , String imageUrl , String article) {
        this.id = id;
        this.imageUrl = imageUrl;
        this.title = title;
        this.article = article;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getArticle() {
        return article;
    }

    public void setArticle(String article) {
        this.article = article;
    }

    public static List<Article> getArticles() {
        List<Article> list = new ArrayList<>();

        list.add( new Article(0 , "درمان و پیشگیری" , "https://www.basiratgroup.com/wp-content/uploads/2019/02/Medical-Old-2-750x430.jpg", "درمان و پیشگیری"));
        list.add( new Article(0 , "تغذیه و رژیم" , "https://www.basiratgroup.com/wp-content/uploads/2019/02/Medical-Old-2-750x430.jpg", "درمان و پیشگیری"));
        list.add( new Article(0 , "علائم بالینی" , "https://www.basiratgroup.com/wp-content/uploads/2019/02/Medical-Old-2-750x430.jpg", "درمان و پیشگیری"));
        list.add( new Article(0 , "داروخانه" , "https://www.basiratgroup.com/wp-content/uploads/2019/02/Medical-Old-2-750x430.jpg", "درمان و پیشگیری"));
        list.add( new Article(0 , "بیماری های مرتبط" , "https://www.basiratgroup.com/wp-content/uploads/2019/02/Medical-Old-2-750x430.jpg", "درمان و پیشگیری"));
        list.add( new Article(0 , "مصاحبه پزشکان" , "https://www.basiratgroup.com/wp-content/uploads/2019/02/Medical-Old-2-750x430.jpg", "درمان و پیشگیری"));

        return list;
    }

}
