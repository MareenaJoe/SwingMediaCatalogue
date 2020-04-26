package com.mareena.mediacatalogue.model.json;

import java.util.List;

public class MediaCatalogue {
  private List<Film> films;
  private List<TVSeries> tvseries;
  private List<Genre> genres;
  private List<People> people;
  private List<Profile> profiles;

  public MediaCatalogue() {}

  public List<People> getPeople() {
    return people;
  }

  public void setPeople(List<People> people) {
    this.people = people;
  }

  public List<Film> getFilms() {
    return films;
  }

  public void setFilms(List<Film> films) {
    this.films = films;
  }

  public List<TVSeries> getTvseries() {
    return tvseries;
  }

  public void setTvseries(List<TVSeries> tvseries) {
    this.tvseries = tvseries;
  }

  public List<Genre> getGenres() {
    return genres;
  }

  public void setGenres(List<Genre> genres) {
    this.genres = genres;
  }

  public List<Profile> getProfiles() {
    return profiles;
  }

  public void setProfiles(List<Profile> profiles) {
    this.profiles = profiles;
  }

  /**
   * After json data is populated into the catalogue, now we need to update both film & tvSeries
   * model object with the Genre, Cast objects because this will be later needed in the view models.
   * After initial model data is populated from json, the cast, genre collection are only integer
   * based collections, and these will need to be converted to the respective objects in a seperate
   * collection
   */
  public void updateCastAndGenreInMediaModel() {
    films.forEach(film -> film.setAppModel(this));
    tvseries.forEach(tvSeries -> tvSeries.setAppModel(this));
  }

  @Override
  public String toString() {
    return "MediaCatalogue{"
        + "films="
        + films
        + ", tvseries="
        + tvseries
        + ", genres="
        + genres
        + ", people="
        + people
        + ", profiles="
        + profiles
        + '}';
  }
}
