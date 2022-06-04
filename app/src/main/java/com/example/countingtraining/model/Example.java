package com.example.countingtraining.model;

import java.util.UUID;

public class Example {

    private long id;
   // private UUID mId;
    private boolean isCorrect;
    private String example1;

    public Example(long id, String example1) {
        //this.mId = UUID.randomUUID();
        //this.isCorrect = isCorrect;
        this.example1 = example1;
        this.id = id;
    }


    /*public UUID getmId() {
        return mId;
    }*/

    /*public void setmId(UUID mId) {
        this.mId = mId;
    }*/

    public boolean isCorrect() {
        return isCorrect;
    }

    public void setCorrect(boolean correct) {
        isCorrect = correct;
    }

    public String getExample1() {
        return example1;
    }

    public void setExample1(String example1) {
        this.example1 = example1;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }
}
