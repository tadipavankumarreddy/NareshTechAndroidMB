
package in.nareshtechnologies.inshortsnews;


public class Datum {

    private String author;
    private String content;
    private String date;
    private String id;
    private String imageUrl;
    private String readMoreUrl;
    private String time;
    private String title;
    private String url;

    /**
     * No args constructor for use in serialization
     * 
     */
    public Datum() {
    }

    /**
     * 
     * @param date
     * @param readMoreUrl
     * @param author
     * @param imageUrl
     * @param id
     * @param time
     * @param title
     * @param content
     * @param url
     */
    public Datum(String author, String content, String date, String id, String imageUrl, String readMoreUrl, String time, String title, String url) {
        super();
        this.author = author;
        this.content = content;
        this.date = date;
        this.id = id;
        this.imageUrl = imageUrl;
        this.readMoreUrl = readMoreUrl;
        this.time = time;
        this.title = title;
        this.url = url;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public String getReadMoreUrl() {
        return readMoreUrl;
    }

    public void setReadMoreUrl(String readMoreUrl) {
        this.readMoreUrl = readMoreUrl;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

}
