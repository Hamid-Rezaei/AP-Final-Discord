package com.discordapp.View;

import com.discordapp.Controller.AppController;
import com.discordapp.Controller.Authentication;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;


/**
 * The type Login view controller.
 */
public class LoginViewController {

    @FXML
    private TextField userTF;
    @FXML
    private TextField passTF;
    @FXML
    private Label emailPhoneErr;
    @FXML
    private Label passErr;
    @FXML
    private Button loginBtn;
    private String password;
    private String email;
    private String phoneNum;
    /**
     * The Username.
     */
    public String username;

    /**
     * Initialize.
     */
    @FXML
    public void initialize() {
    }

    /**
     * Em ph user tf handler.
     *
     * @param event the event
     */
    @FXML
    void emPhUserTFHandler(KeyEvent event) {
        emailPhoneErr.setText("");
        if (event.getCode() == KeyCode.ENTER) {
            String text = userTF.getText();
            if (!(text == null || text.equals(""))) {
                username = text;
                passTF.requestFocus();
            } else {
                emailPhoneErr.setText("THIS FIELD IS REQUIRED");
            }
        }
    }


    /**
     * Pass tf handler.
     *
     * @param event the event
     */
    @FXML
    void passTFHandler(KeyEvent event) {
        passErr.setText("");
        if (event.getCode() == KeyCode.ENTER) {
            password = passTF.getText();
            if (!(password == null || password.equals(""))) {
                loginBtn.fire();
            } else {
                passErr.setText("THIS FIELD IS REQUIRED");

            }
        }
    }

    /**
     * On login button.
     *
     * @param event the event
     */
    @FXML
    void onLoginButton(ActionEvent event) {
        username = userTF.getText();
        password = passTF.getText();
        DiscordApplication.appController = new AppController();
        DiscordApplication.appController.connect();
        if (!(password == null || password.equals("")) && !(username == null || username.equals(""))) {
            DiscordApplication.user = DiscordApplication.appController.login(username, password);
            if (DiscordApplication.user != null) {
                FXMLLoader loader = new FXMLLoader(getClass().getResource("in-application-view.fxml"));
                Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
                DiscordApplication.loadNewScene(loader, stage);
            } else {
                passErr.setText("USERNAME/PASSWORD IS WRONG");
            }
        } else {
            if (password == null || password.equals("")) {
                passErr.setText("THIS FIELD IS REQUIRED");
            }
            if (username == null || username.equals("")) {
                emailPhoneErr.setText("THIS FIELD IS REQUIRED");
            }
        }
    }

    /**
     * Go to sign up.
     *
     * @param event the event
     */
    @FXML
    void goToSignUp(MouseEvent event) {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("signup-view.fxml"));
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        DiscordApplication.loadNewScene(loader, stage);
    }
}
