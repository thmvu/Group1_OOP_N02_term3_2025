package com.example.servingwebcontent;

public class Song {
    public String songID;
    public String songName;
    public String songAuthor;
    public String country;

    public Song(){}

    public Song(String songID, String songName, String songAuthor, String country){
        this.songID = songID;
        this.songName = songName;
        this.songAuthor = songAuthor;
        this.country = country;
    }
    public String getSongName(){
        return this.songName;
    }

    
    
    public void setSongID(String id){
        this.songID = id;

    }
    public void setSongName(String name){
        this.songName = name;

    }
    public void setSongAuthor(String author){
        this.songAuthor = author;

    }
    
    public void setSongCountry(String country){
        this.country = country;

    }
    

    

}
