package ru.rodichev.webBlog.models;


import org.hibernate.annotations.Type;
import org.springframework.context.annotation.Primary;
import ru.rodichev.webBlog.logic.CurrDate;

import javax.persistence.*;

@Entity
public class Notes {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String heading;

    @Type(type = "text")
    private String fullText;
    private String date;
    private String tags;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getHeading() {
        return heading;
    }

    public void setHeading(String heading) {
        this.heading = heading;
    }

    public String getFullText() {
        return fullText;
    }

    public void setFullText(String fullText) {
        this.fullText = fullText;
    }

    public String getTags() {
        return tags;
    }

    public void setTags(String tags) {
        this.tags = tags;
    }

    public String getDate() { return date; }

    public void setDate(String date) { this.date = date; }

    public Notes(String heading, String fullText, String tags) {
        this.heading = heading;
        this.fullText = toHtmlBreakLines(fullText);
        this.tags = tags;
        this.date = CurrDate.getCurrDate();
    }
    public String toHtmlBreakLines(String text){
        return text.replaceAll("\n","<br />");
    }

    public String toSqlBreakLines(){
        return this.fullText.replaceAll("<br />","\n");
    }

//    public String getShortText() {
//        if (this.fullText.length() > 1001) {
//            return this.fullText.substring(0, 1000) + "...";
//        } else return this.fullText;
//    }

    public String getShortText() {
        if (this.fullText.length() > 1001) {
            return this.fullText.substring(0, this.fullText.substring(0, 1000).lastIndexOf(" ")) + "...";
        } else return this.fullText;
    }


    public Notes() {
    }
}
