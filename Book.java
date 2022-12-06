package FMA_7AGA;
public class Book {
    private String id;
    private String author;
    private String title;
    private String genre;
    private String price;
    private String publishDate;
    private String description;

    public Book(){
        id=null;
        author=null;
        title=null;
        genre=null;
        price=null;
        publishDate=null;
        description=null;
    }
    
     public void setId(String id) {
        this.id = id;
    }
    public String getId() {
        return id;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getAuthor() {
        return author;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getTitle() {
        return title;
    }

   public void setGenre(String genre) {
        this.genre = genre;
    }

    public String getGenre() {
        return genre;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getPrice() {
        return price;
    }

    public void setPublishDate(String publishDate) {
        this.publishDate = publishDate;
    }

    public String getPublishDate() {
        return publishDate;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    } 
    
}
