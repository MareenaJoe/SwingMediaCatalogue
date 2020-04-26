package com.mareena.mediacatalogue.model.json;

public class Genre {
  private int gid;
  private String genre;

  public Genre() {}

  public Genre(int gid, String genre) {
    this.gid = gid;
    this.genre = genre;
  }

  public int getGid() {
    return gid;
  }

  public void setGid(int gid) {
    this.gid = gid;
  }

  public String getGenre() {
    return genre;
  }

  public void setGenre(String genre) {
    this.genre = genre;
  }

  @Override
  public String toString() {
    return genre + "\n";
  }
}
