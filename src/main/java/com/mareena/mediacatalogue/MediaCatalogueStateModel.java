package com.mareena.mediacatalogue;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.mareena.mediacatalogue.model.json.MediaCatalogue;

import java.io.File;

public class MediaCatalogueStateModel {

  static MediaCatalogueStateModel INSTANCE;
  MediaCatalogue mediaCatalogue;

  private MediaCatalogueStateModel() {
    mediaCatalogue = readMediaCatalogueFromJson();
    mediaCatalogue.updateCastAndGenreInMediaModel();
  }

  public static synchronized MediaCatalogueStateModel getInstance() {
    if (INSTANCE == null) {
      INSTANCE = new MediaCatalogueStateModel();
    }
    return INSTANCE;
  }

  public static MediaCatalogue readMediaCatalogueFromJson() {
    ObjectMapper mapper = new ObjectMapper();
    MediaCatalogue mediaCatalogue = null;
    try {
      File mediaCatalogueFile =
          new File(AppMain.class.getClassLoader().getResource("data.json").getFile());
      mediaCatalogue = mapper.readValue(mediaCatalogueFile, MediaCatalogue.class);
    } catch (Exception e) {
      e.printStackTrace();
    }
    return mediaCatalogue;
  }

  // For testing
  public static void main(String[] args) {
    MediaCatalogue mediaCatalogue = readMediaCatalogueFromJson();
    mediaCatalogue.updateCastAndGenreInMediaModel();
    System.out.println(mediaCatalogue);
  }

  public MediaCatalogue getCatalogue() {
    return mediaCatalogue;
  }
}
