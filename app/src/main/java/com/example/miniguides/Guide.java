package com.example.miniguides;

public class Guide {

    private String title;
    private int icon;
    private int arrow;

    public Guide(String title, int icon, int arrow) {
        this.title = title;
        this.icon = icon;
        this.arrow = arrow;
    }

    public String getTitle() {
        return title;
    }

    public int getIcon() {
        return icon;
    }

    public int getArrow() {
        return arrow;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setArrow(int arrow) {
        this.arrow = arrow;
    }

    public void setIcon(int icon) {
        this.icon = icon;
    }
}
