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

        list.add( new ArticleCategory(0 , "درمان و پیشگیری" , "http://0pc.ir/apppics/cheap-darman.png"));
        list.add( new ArticleCategory(0 , "تغذیه و رژیم" , "http://0pc.ir/apppics/cheap-t.png"));
        list.add( new ArticleCategory(0 , "علائم بالینی" , "http://0pc.ir/apppics/cheap-balini.png"));
        list.add( new ArticleCategory(0 , "داروخانه" , "http://0pc.ir/apppics/cheap-pharmacy.png"));
        list.add( new ArticleCategory(0 , "بیماری های مرتبط" , "http://0pc.ir/apppics/cheap-bimari.png"));
        list.add( new ArticleCategory(0 , "مصاحبه پزشکان" , "http://0pc.ir/apppics/cheap-visit.png"));

        return list;
    }

}
