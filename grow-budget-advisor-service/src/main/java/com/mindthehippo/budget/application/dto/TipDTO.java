package com.mindthehippo.budget.application.dto;

/**
 *
 * @author Novaes
 */
public class TipDTO {

    private String text;
    private String kind;

    public TipDTO(String text, String kind) {
        this.text = text;
        this.kind = kind;
    }

    public String getKind() {
        return kind;
    }

    public void setKind(String kind) {
        this.kind = kind;
    }
    

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

}
