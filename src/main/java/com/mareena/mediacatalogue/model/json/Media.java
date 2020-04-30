package com.mareena.mediacatalogue.model.json;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public abstract class Media implements Comparable {
  // For JSON model
  protected String title;
  protected Integer year;
  protected List<Integer> genre;
  protected Set<Integer> cast;
  protected String description;

  // For app model
  protected People mediaCreator;
  protected Set<Genre> genres = new HashSet<>();
  protected Set<People> actors = new HashSet<>();

  public Media() {}

  public String getTitle() {
    return title;
  }

  public void setTitle(String title) {
    this.title = title;
  }

  public Integer getYear() {
    return year;
  }

  public void setYear(Integer year) {
    this.year = year;
  }

  public List<Integer> getGenre() {
    return genre;
  }

  public void setGenre(List<Integer> genre) {
    this.genre = genre;
  }

  public Set<Integer> getCast() {
    return cast;
  }

  public void setCast(Set<Integer> cast) {
    this.cast = cast;
  }

  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  // For setting variables that will be used by the application models
  public void setAppModel(MediaCatalogue mediaCatalogue) {
    setMediaCreator(mediaCatalogue);
    setCastByName(mediaCatalogue);
    setGenreByName(mediaCatalogue);
  }

  public People getMediaCreator() {
    return mediaCreator;
  }

  public abstract void setMediaCreator(MediaCatalogue mediaCatalogue);

  public void setGenreByName(MediaCatalogue mediaCatalogue) {
    genre.forEach(
        genreItem ->
            genres.add(
                mediaCatalogue.getGenres().stream()
                    .filter(genreObjectItem -> genreObjectItem.getGid() == genreItem)
                    .findFirst()
                    .get()));
  }

  public void setCastByName(MediaCatalogue mediaCatalogue) {
    cast.forEach(
        castId ->
            actors.add(
                mediaCatalogue.getPeople().stream()
                    .filter(people -> people.getPid() == castId)
                    .findFirst()
                    .get()));
  }

  @Override
  public int compareTo(Object o) {
    return year.compareTo(((Media) o).year);
  }

  public Set<Genre> getGenres() {
    return genres;
  }

  public Set<People> getActors() {
    return actors;
  }

  @Override
  public String toString() {
    return "" + title + "    " + year + "   " + getSeperatedGenres();
  }

  public String toStringforListByYear() {
    return "" + title + "\t\t\t\t" + getSeperatedGenres();
  }

  String getSeperatedGenres() {
    String SEPERATOR = " | ";
    if (genres == null || genres.size() == 0) {
      return "";
    }
    String genreStr = "";
    for (Genre g : genres) {
      genreStr = genreStr + g.getGenre() + SEPERATOR;
    }
    // removing the last 3 chars from the string to remove " | " from the string
    genreStr = genreStr.substring(0, genreStr.length() - SEPERATOR.length());
    return genreStr;
  }

  public String toStringforListByGenre() {
    return title + "\t\t" + year;
  }
}
