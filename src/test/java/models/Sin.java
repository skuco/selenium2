package models;

public class Sin {
    private String title;
    private String author;
    private String message;

    public Sin(String title, String author, String message) {
        this.title = title;
        this.author = author;
        this.message = message;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public String getMessage() {
        return message;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
