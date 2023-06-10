package com.rentathing.utils;

import com.rentathing.utils.CSS.CSSLoader;
import com.rentathing.utils.CSS.CSSPaths;
import io.github.palexdev.materialfx.css.themes.MFXThemeManager;
import io.github.palexdev.materialfx.css.themes.Themes;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class WindowOpener {

    public static void openWindow(String path, Parent newRoot) {
        try {
            // Set up new root
            FXMLLoader loader = new FXMLLoader(WindowOpener.class.getResource(path));
            Parent root = (newRoot == null) ? loader.load() : newRoot;

            // Set up the scene and add css
            Scene scene = new Scene(root);
            scene.getStylesheets().add(CSSLoader.loadCSS(CSSPaths.RENT_A_THING_CSS));

            // Set up theme manager
            MFXThemeManager.addOn(scene, Themes.LEGACY);

            // Set up the Stage
            Stage stage = new Stage();
            stage.setTitle("Rent-a-Thing");
            stage.setScene(scene);
            stage.show();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
