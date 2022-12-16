package com.codegym.model;

public class Mailbox {
    private int id;
    private String language;
    private int size;
    private boolean spamsFilter;
    private String signature;


    public Mailbox() {
    }


    public Mailbox(int id, String language, int size, boolean spamsFilter, String signature) {
        this.id = id;
        this.language = language;
        this.size = size;
        this.spamsFilter = spamsFilter;
        this.signature = signature;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public boolean isSpamsFilter() {
        return spamsFilter;
    }

    public void setSpamsFilter(boolean spamsFilter) {
        this.spamsFilter = spamsFilter;
    }

    public String getSignature() {
        return signature;
    }

    public void setSignature(String signature) {
        this.signature = signature;
    }
}
