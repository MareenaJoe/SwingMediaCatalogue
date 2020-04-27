package com.mareena.mediacatalogue.swing.model;

import com.mareena.mediacatalogue.controller.VideoCatalogueController;
import com.mareena.mediacatalogue.model.json.Film;
import com.mareena.mediacatalogue.model.json.Media;
import com.mareena.mediacatalogue.model.json.MediaCatalogue;
import com.mareena.mediacatalogue.model.json.TVSeries;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class ListByYearAndGenreModel {
  final MediaCatalogue mediaCatalogue;
  final VideoCatalogueController videoCatalogueController;

  public ListByYearAndGenreModel(
      MediaCatalogue mediaCatalogue, VideoCatalogueController videoCatalogueController) {
    this.mediaCatalogue = mediaCatalogue;
    this.videoCatalogueController = videoCatalogueController;
  }

  public String getMediaByYear() {
    Map<Integer, List<Media>> mediaMap = new HashMap<>();
    //    mediaCatalogue.getFilms().forEach(film -> processItem(film, mediaMap));
    for (Film film : mediaCatalogue.getFilms()) {
      // mediaList, alist for storing films and tvseries
      List<Media> mediaList = mediaMap.get(film.getYear());
      if (mediaList == null) {
        List<Media> filmList = new ArrayList<>();
        filmList.add(film);
        mediaMap.put(film.getYear(), filmList);
      } else {
        mediaList.add(film);
      }
    }
    for (TVSeries tvSeries : mediaCatalogue.getTvseries()) {
      List<Media> mediaList = mediaMap.get(tvSeries.getYear());
      if (mediaList == null) {
        List<Media> filmList = new ArrayList<>();
        filmList.add(tvSeries);
        mediaMap.put(tvSeries.getYear(), filmList);
      } else {
        mediaList.add(tvSeries);
      }
    }

    // converting the list of films/tvseries into a String
    // Traversing through a collection of years,

    String finalString = "";
    for (Map.Entry<Integer, List<Media>> entry : mediaMap.entrySet()) {
      finalString =
          finalString
              + entry.getKey()
              + "\n"
              + entry.getValue().stream()
                  .map(Media::toStringforListByYear)
                  .collect(Collectors.joining("\n"))
              + "\n"
              + "\n";
    }
    return finalString;
  }

  public String getMediaByGenre() {

    Map<String, List<Media>> genreMediaMap = new HashMap<>();

    // Populate genreMediaMap with keys containing all known genre strings & empty arraylist of
    // type media. The arrayLists will be populated later
    mediaCatalogue
        .getGenres()
        .forEach(genre -> genreMediaMap.put(genre.getGenre(), new ArrayList<Media>()));
    for (Film film : mediaCatalogue.getFilms()) {
      // traversing through string list of genres in film.
      // Get the arraylist for the genre currently being traversed and add the current
      // film to the list.
      // So each film gets added to 2 or more list
      film.getGenres().forEach(genre -> genreMediaMap.get(genre.getGenre()).add(film));
    }
    for (TVSeries tvSeries : mediaCatalogue.getTvseries()) {
      // Same logic as above
      tvSeries.getGenres().forEach(genre -> genreMediaMap.get(genre.getGenre()).add(tvSeries));
    }
    String finalString = "";
    for (Map.Entry<String, List<Media>> entry : genreMediaMap.entrySet()) {
      finalString =
          finalString
              + entry.getKey()
              + "\n"
              + entry.getValue().stream()
                  .map(Media::toStringforListByGenre)
                  .collect(Collectors.joining("\n"))
              + "\n"
              + "\n";
    }
    return finalString;
  }
}
