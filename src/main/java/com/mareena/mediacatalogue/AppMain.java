package com.mareena.mediacatalogue;

import com.mareena.mediacatalogue.controller.VideoCatalogueController;

import javax.swing.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public class AppMain {

  public static void main(String[] args) {
    try {
      UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
      VideoCatalogueController videoCatalogueController = new VideoCatalogueController();
    } catch (ClassNotFoundException ex) {
      Logger.getLogger(AppMain.class.getName()).log(Level.SEVERE, null, ex);
    } catch (InstantiationException ex) {
      Logger.getLogger(AppMain.class.getName()).log(Level.SEVERE, null, ex);
    } catch (IllegalAccessException ex) {
      Logger.getLogger(AppMain.class.getName()).log(Level.SEVERE, null, ex);
    } catch (UnsupportedLookAndFeelException ex) {
      Logger.getLogger(AppMain.class.getName()).log(Level.SEVERE, null, ex);
    }
  }
}
