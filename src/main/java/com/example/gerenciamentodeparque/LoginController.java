package com.example.gerenciamentodeparque;

import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.event.ActionEvent;

public class LoginController {

    @FXML
    private TextField txtEmail;

    @FXML
    private PasswordField txtSenha;

    @FXML
    private Button btnEntrar;

    @FXML
    private Hyperlink linkCadastrar;

    @FXML
    private void initialize() {
        btnEntrar.setOnAction(this::handleLogin);
        linkCadastrar.setOnAction(this::handleCadastroRedirect);
    }

    private void handleLogin(ActionEvent event) {
        String email = txtEmail.getText();
        String senha = txtSenha.getText();

        // Lógica para validar login aqui
        System.out.println("Login com: " + email + " / " + senha);

    }

    private void handleCadastroRedirect(ActionEvent event) {
        // Trocar para a tela de cadastro
        System.out.println("Ir para cadastro...");
    }
}
