package com.biybiruza.news.data;

import com.biybiruza.news.R;

import java.util.ArrayList;
import java.util.List;

public class Authors {
    int image;
    String name;
    String followCount;
    boolean isFollow;

    public Authors(int image, String name, String followCount, boolean isFollow) {
        this.image = image;
        this.name = name;
        this.followCount = followCount;
        this.isFollow = isFollow;
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getFollowCount() {
        return followCount;
    }

    public void setFollowCount(String followCount) {
        this.followCount = followCount;
    }

    public boolean isFollow() {
        return isFollow;
    }

    public void setFollow(boolean follow) {
        isFollow = follow;
    }

    static public List<Authors> authorsList() {
        List<Authors> authors = new ArrayList<>();

        authors.add(new Authors(R.drawable.news_author, "BBC News", "1.2M", false));
        authors.add(new Authors(R.drawable.icon_cnn, "CNN", "959K", false));
        authors.add(new Authors(R.drawable.vox, "Vox", "452K", false));
        authors.add(new Authors(R.drawable.usa_today, "USA Today", "325K", false));
        authors.add(new Authors(R.drawable.cnbc, "CNBC", "21K", false));
        authors.add(new Authors(R.drawable.cnet, "CNET", "18K", false));
        return authors;
    }
}
