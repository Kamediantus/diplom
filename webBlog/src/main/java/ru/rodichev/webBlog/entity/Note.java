package ru.rodichev.webBlog.entity;


import org.hibernate.annotations.Type;
import ru.rodichev.webBlog.logic.CurrDate;
import javax.persistence.*;

@Table(name = "t_notes")
@Entity
public class Note {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String heading;

    @Type(type = "text")
    private String rawFullText;
    @Type(type = "text")
    private String moderateFullText;
    @Type(type = "text")
    private String finalFullText;
    private String date;
    private String tags;
    private boolean isChecked;

    public boolean isChecked() {
        return isChecked;
    }

    public void setChecked(boolean checked) {
        isChecked = checked;
    }

    public String getRawFullText() {
        return rawFullText;
    }

    public void setRawFullText(String rawFullText) {
        this.rawFullText = rawFullText;
    }

    public String getModerateFullText() {
        return moderateFullText;
    }

    public void setModerateFullText(String moderateFullText) {
        this.moderateFullText = moderateFullText;
    }

    public String getFinalFullText() {
        return finalFullText;
    }

    public void setFinalFullText(String finalFullText) {
        this.finalFullText = finalFullText;
    }

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

    public String getTags() {
        return tags;
    }

    public void setTags(String tags) {
        this.tags = tags;
    }

    public String getDate() { return date; }

    public void setDate(String date) { this.date = date; }

    public Note(String heading, String fullText, String tags) {
        this.heading = heading;
        this.rawFullText = toHtmlBreakLines(fullText);
        this.tags = tags;
        this.date = CurrDate.getCurrDate();
        this.setChecked(false);
    }
    public String toHtmlBreakLines(String text){
        return text.replaceAll("\n","<br />");
    }

    public String toSqlBreakLines(String text){
        return text.replaceAll("<br />","\n");
    }

    public String getShortText(String text) {
        if (text.length() > 1001) {
            if (text.substring(0,1000).contains(" ")) {
                return text.substring(0, text.substring(0, 1000).lastIndexOf(" ")) + "...";
            } else return text.substring(0, 1000) + "...";
        } else return text;
    }

    public Note() {
        }
    }

