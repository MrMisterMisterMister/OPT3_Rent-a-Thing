package com.rentathing.ui;

import com.rentathing.utils.WindowOpener;

public class LoginController {

    public void login() {

        // Go to main menu screen
        WindowOpener.openWindow("/com/rentathing/fxml/MainMenuScreen.fxml", null);
    }
}
