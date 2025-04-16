package com.example.gerenciamentodeparque;

import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.event.ActionEvent;

public class CadastroController {

    @FXML
    private TextField txtNome, txtEmail, txtCpf, txtTelefone;

    @FXML
    private PasswordField txtSenha;

    @FXML
    private Button btnCadastrar;

    @FXML
    private Hyperlink linkVoltarLogin;

    @FXML
    private void initialize() {
        btnCadastrar.setOnAction(this::handleCadastro);
        linkVoltarLogin.setOnAction(this::voltarParaLogin);
    }

    private void handleCadastro(ActionEvent event) {
        String nome = txtNome.getText();
        String email = txtEmail.getText();
        String cpf = txtCpf.getText();
        String senha = txtSenha.getText();
        String telefone = txtTelefone.getText();


        System.out.println("Cadastro: " + nome + ", " + email);
    }

    private void voltarParaLogin(ActionEvent event) {
        System.out.println("Voltar para tela de login");
    }
}
