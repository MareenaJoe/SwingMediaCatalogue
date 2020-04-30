package com.mareena.mediacatalogue.model.json;

public class Genre {
  public static int MAX_ID;
  private int gid;
  private String genre;

  public Genre() {}

  public Genre(int gid, String genre) {
    this.gid = gid;
    this.genre = genre;
  }

  public Genre(String genre) {
    this.genre = genre;
    this.gid = getNextID();
  }

  public int getGid() {
    return gid;
  }

  public void setGid(int gid) {
    this.gid = gid;
    if (gid > MAX_ID) {
      MAX_ID = gid;
    }
  }

  int getNextID() {
    MAX_ID += 1;
    return MAX_ID;
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
