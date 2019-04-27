package models;

import java.util.ArrayList;
import java.util.List;

public class ArticleCategory {

    int id;
    String imageUrl , title;

    public ArticleCategory(int id, String title , String imageUrl) {
        this.id = id;
        this.imageUrl = imageUrl;
        this.title = title;
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

    public static List<ArticleCategory> getArticleCategories() {
        List<ArticleCategory> list = new ArrayList<>();

        list.add( new ArticleCategory(0 , "درمان و پیشگیری" , "https://www.basiratgroup.com/wp-content/uploads/2019/02/Medical-Old-2-750x430.jpg"));
        list.add( new ArticleCategory(0 , "تغذیه و رژیم" , "https://www.basiratgroup.com/wp-content/uploads/2019/02/Medical-Old-2-750x430.jpg"));
        list.add( new ArticleCategory(0 , "علائم بالینی" , "https://www.basiratgroup.com/wp-content/uploads/2019/02/Medical-Old-2-750x430.jpg"));
        list.add( new ArticleCategory(0 , "داروخانه" , "https://www.basiratgroup.com/wp-content/uploads/2019/02/Medical-Old-2-750x430.jpg"));
        list.add( new ArticleCategory(0 , "بیماری های مرتبط" , "https://www.basiratgroup.com/wp-content/uploads/2019/02/Medical-Old-2-750x430.jpg"));
        list.add( new ArticleCategory(0 , "مصاحبه پزشکان" , "https://www.basiratgroup.com/wp-content/uploads/2019/02/Medical-Old-2-750x430.jpg"));

        return list;
    }

}
