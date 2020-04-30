package com.mareena.mediacatalogue.model.json;

import java.util.Set;

public class Film extends Media {
  public static int MAX_ID;
  protected int director;
  private int fid;

  public Film(
      String title,
      Integer yearInt,
      String description,
      People directorObj,
      Set<Genre> genreSet,
      Set<People> castSet) {
    this.title = title;
    this.year = yearInt;
    this.description = description;
    this.mediaCreator = directorObj;
    this.genres = genreSet;
    this.actors = castSet;
  }

  public Film() {}

  public int getFid() {
    return fid;
  }

  public void setFid(int fid) {
    this.fid = fid;
    if (fid > MAX_ID) {
      MAX_ID = fid;
    }
  }

  int getNextID() {
    MAX_ID += 1;
    return MAX_ID;
  }

  public int getDirector() {
    return director;
  }

  public void setDirector(int director) {
    this.director = director;
  }

  @Override
  public void setMediaCreator(MediaCatalogue mediaCatalogue) {
    this.mediaCreator =
        mediaCatalogue.getPeople().stream().filter(p -> p.getPid() == director).findFirst().get();
  }
}
