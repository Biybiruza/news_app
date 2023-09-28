package com.biybiruza.news.data;

/*Api key; 74c6de7f96f349a8ac1e22dfe234437c*/

import java.util.List;

public class Articles {

    Source source;
    String author;
    String content;
    String description;
    String publishedAt;
    String title;
    String url;
    String urlToImage;

    public Articles(Source source, String author, String content, String description, String publishedAt, String title, String url, String urlToImage) {
        this.source = source;
        this.author = author;
        this.content = content;
        this.description = description;
        this.publishedAt = publishedAt;
        this.title = title;
        this.url = url;
        this.urlToImage = urlToImage;
    }

    public Source getSource() {
        return source;
    }

    public void setSource(Source source) {
        this.source = source;
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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getPublishedAt() {
        return publishedAt;
    }

    public void setPublishedAt(String publishedAt) {
        this.publishedAt = publishedAt;
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

    public String getUrlToImage() {
        return urlToImage;
    }

    public void setUrlToImage(String urlToImage) {
        this.urlToImage = urlToImage;
    }
}
