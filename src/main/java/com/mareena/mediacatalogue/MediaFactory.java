package com.mareena.mediacatalogue;

import com.mareena.mediacatalogue.model.json.*;

import java.util.*;

public class MediaFactory {

  public static Media createMedia(
      String title,
      String year,
      String castList,
      String genreList,
      String director,
      String description,
      boolean isTvSeries) {
    People directorObj = getArtist(director);
    Set<Genre> genreSet = getGenres(genreList);
    Set<People> castSet = getCast(castList);
    Integer yearInt = getYear(year);
    Media media = null;
    MediaCatalogueStateModel mediaCatalogueStateModel = MediaCatalogueStateModel.getInstance();
    if (isTvSeries) {
      media = new TVSeries(title, yearInt, description, directorObj, genreSet, castSet);
      mediaCatalogueStateModel.getCatalogue().getTvseries().add((TVSeries) media);
    } else {
      media = new Film(title, yearInt, description, directorObj, genreSet, castSet);
      mediaCatalogueStateModel.getCatalogue().getFilms().add((Film) media);
    }
    return media;
  }

  private static int getYear(String year) {
    return Integer.parseInt(year);
  }

  private static Set<People> getCast(String castList) {
    // castSet created same as app model
    // director and cast people are coming from the same list so main login in getArtist
    Set<People> castSet = new HashSet<>();
    System.out.println("Cast: " + Arrays.toString(castList.split("\n")));
    List<String> castFromCastTextArea = Arrays.asList(castList.split("\n"));
    // castFromCastTextArea.forEach(castStr -> castSet.add(getArtist(castStr)));
    for (String cast : castFromCastTextArea) {
      castSet.add(getArtist(cast));
    }
    return castSet;
  }

  private static Set<Genre> getGenres(String genresList) {
    System.out.println("Genre: " + Arrays.toString(genresList.split("\n")));
    Set<Genre> genreSet = new HashSet<>();
    List<String> genreFromGenreTextArea = Arrays.asList(genresList.split("\n"));
    for (String genreStr : genreFromGenreTextArea) {
      genreSet.add(getGenre(genreStr));
    }
    return genreSet;
  }

  private static Genre getGenre(String genreStr) {
    if (genreStr == null || genreStr.isEmpty()) {
      return null;
    }
    Optional<Genre> genreFound =
        MediaCatalogueStateModel.getInstance().getCatalogue().getGenres().stream()
            .filter(genre -> genre.getGenre().equalsIgnoreCase(genreStr))
            .findFirst();
    if (genreFound.isPresent()) {
      return genreFound.get();
    }
    Genre newGenre = new Genre(genreStr);
    MediaCatalogueStateModel.getInstance().getCatalogue().getGenres().add(newGenre);
    return newGenre;
  }

  private static People getArtist(String cast) {
    if (cast == null || cast.isEmpty()) {
      return null;
    }
    Optional<People> artistFound =
        MediaCatalogueStateModel.getInstance().getCatalogue().getPeople().stream()
            .filter(people -> people.getName().equalsIgnoreCase(cast))
            .findFirst();
    if (artistFound.isPresent()) {
      return artistFound.get();
    }
    People newArtist = new People(cast);
    // Adding director into catalogue
    MediaCatalogueStateModel.getInstance().getCatalogue().getPeople().add(newArtist);
    System.out.println("Added new list of actors: " + newArtist);
    return newArtist;
  }
}
