package com.biybiruza.news.data;

import com.biybiruza.news.R;

import java.util.ArrayList;
import java.util.List;

public class Topics {
    String category;
    String newsName;
    int img;
    String article;
    Boolean isSaved;

    public Topics(String category, String newsName, int img, String article, boolean isSaved) {
        this.category = category;
        this.newsName = newsName;
        this.img = img;
        this.article = article;
        this.isSaved = isSaved;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getNewsName() {
        return newsName;
    }

    public void setNewsName(String newsName) {
        this.newsName = newsName;
    }

    public int getImg() {
        return img;
    }

    public void setImg(int img) {
        this.img = img;
    }

    public String getArticle() {
        return article;
    }

    public void setArticle(String article) {
        this.article = article;
    }

    public Boolean getSaved() {
        return isSaved;
    }

    public void setSaved(Boolean saved) {
        isSaved = saved;
    }

    static public List<Topics> topicsList(){
        List<Topics> models = new ArrayList<>();

        models.add(new Topics("Health",
                "View the latest health news and explore articles on...",
                R.drawable.health,"Ukrainian President Volodymyr Zelensky has accused European countries that continue to buy Russian oil of \"earning their money in other people's blood\".\n" +
                "\n" + "In an interview with the BBC, President Zelensky singled out Germany and Hungary, accusing them of blocking efforts to embargo energy sales, from which Russia stands to make up to £250bn ($326bn) this year.\n" +
                "\n" + "There has been a growing frustration among Ukraine's leadership with Berlin, which has backed some sanctions against Russia but so far resisted calls to back tougher action on oil sales.",
                false)
        );
        models.add(new Topics("Technology",
                "The latest tech news about the world's best hardware...",
                R.drawable.texnology, "(CNN) - For 33-year-old Sarah Richard, life has long revolved around scuba diving. As the founder of Girls that Scuba, billed as the world’s largest scuba community for women, she traveled nonstop to host dive trips and events before the pandemic.\n"
                + "It would not be unusual for Richard to spend a few weeks in Jordan, then pop over to Egypt, then fly to Mexico, Micronesia, the Maldives or Indonesia to immerse divers in the magic of the underwater world.\n" +
                "\n" + "When it came to her love life, the divemaster imagined herself meeting a scuba instructor or perhaps someone in the travel sphere with a similarly nomadic lifestyle. After all, she was laser-focused on her mission to empower women in the male-dominated scuba industry.",
                false)
        );
        models.add(new Topics("Art",
                "The Art Newspaper is the journal of record for...",
                R.drawable.art,
                "A Russian warship that was damaged by an explosion on Wednesday has sunk, Russia's defence ministry has said.\n"+
                "Moskva, the flagship of Russia's Black Sea Fleet, was being towed to port when \"stormy seas\" caused it to sink, according to a ministry message. The 510-crew missile cruiser was a symbol of Russia's military power, leading its naval assault on Ukraine. Kyiv says its missiles hit the warship. The United States says it also believes it was hit by Ukrainian missiles.\n" +
                "Moscow has not reported any attack - it says the vessel sank after a fire.\n" +
                "The blaze caused the explosion of the warship's ammunition, Russia says, adding that the entire crew were later evacuated to nearby Russian vessels in the Black Sea.",
                false)
        );
        models.add(new Topics("Politics",
                " opinion and analysis of American and global politi...",
                R.drawable.politic,
                "At the same time, the Energy Information Administration noted since the demand for electricity usually dips during the spring and fall, nuclear and coal generators reduce their output or scheduled maintenance during the season. When there is more wind, coal and natural gas generations often reduce their output to match the demand with the overall supply for electricity.\n"+
                "In 2019, wind capacity surpassed nuclear capacity, but nuclear energy usually produces more electricity because of technological differences. On average, the wind usually produces the least amount of electricity each month. The EIA Energy Information Administration does not expect wind power to overtake coal-fired or nuclear generation in any month in 2022 or 2023.",
                false)
        );
        models.add(new Topics("Sport",
                "Sports news and live sports coverage including scores...",
                R.drawable.sport,
                "Reed started ministering soon after, encouraging his roughly 100 church members to pivot from suffering to servanthood. Congregants walked through the disaster zone assessing needs, passing out thousands of dollars in gift cards and helping residents rescue belongings.\n" +
                "\n" +
                "“The example of Jesus Christ is the suffering servant,” he said. “When we turn away from our own difficulties … we are able to let go of our own pain for a minute and focus on our neighbor, which is the core strength of Christianity.\n"+
                        "\n"+"As the congregation weighs how best to rebuild, they continue to process the tornado’s destruction through waves of grieving and helping. Only in recent weeks – after Reed performed his daughter’s wedding, escaped to a cabin with his wife and mourned the death of their cat, " +
                        "George – did Reed realize he was still carrying around trauma from the storm.", false)
        );
        models.add(new Topics("Travel",
                "The latest travel news on the most significant developm...",
                R.drawable.travel,
                "Reed started ministering soon after, encouraging his roughly 100 church members to pivot from suffering to servanthood. Congregants walked through the disaster zone assessing needs, passing out thousands of dollars in gift cards and helping residents rescue belongings.\n" +
                "\n" +
                "“The example of Jesus Christ is the suffering servant,” he said. “When we turn away from our own difficulties … we are able to let go of our own pain for a minute and focus on our neighbor, which is the core strength of Christianity.\n"+
                        "\n"+"As the congregation weighs how best to rebuild, they continue to process the tornado’s destruction through waves of grieving and helping. Only in recent weeks – after Reed performed his daughter’s wedding, escaped to a cabin with his wife and mourned the death of their cat, George – did Reed realize he was still carrying around trauma from the storm.",
                false)
        );

        return models;
    }
}
