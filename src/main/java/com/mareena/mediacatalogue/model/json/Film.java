package com.mareena.mediacatalogue.model.json;

public class Film extends Media {
  protected int director;
  private int fid;

  public int getFid() {
    return fid;
  }

  public void setFid(int fid) {
    this.fid = fid;
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
