package com.example.gerenciamentodeparque;

import Dao.IngressoDao;
import Models.Ingresso;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;

public class ValidacaoController {

    @FXML
    private TextField codigoIngressoTextField;

    @FXML
    private TableView<Ingresso> tableIngressos;
    @FXML
    private TableColumn<Ingresso, String> colCliente;
    @FXML
    private TableColumn<Ingresso, String> colAtracao;
    @FXML
    private TableColumn<Ingresso, String> colDataCompra;
    @FXML
    private TableColumn<Ingresso, String> colFormaPagamento;

    private IngressoDao ingressoDao = new IngressoDao();

    @FXML
    private void initialize() {
        // Configura as colunas da tabela
        colCliente.setCellValueFactory(cellData -> cellData.getValue().clienteNomeProperty());
        colAtracao.setCellValueFactory(cellData -> cellData.getValue().atracaoNomeProperty());
        colDataCompra.setCellValueFactory(cellData -> cellData.getValue().dataCompraProperty().asString());
        colFormaPagamento.setCellValueFactory(cellData -> cellData.getValue().formaPagamentoProperty());

        // Carregar os ingressos
        carregarIngressos();
    }

    private void carregarIngressos() {
        // Carregar ingressos na tabela
        tableIngressos.getItems().setAll(ingressoDao.listarTodos());
    }

    @FXML
    private void validarIngresso(ActionEvent event) {
        // Obter o código do ingresso inserido
        String codigoIngresso = codigoIngressoTextField.getText();

        if (codigoIngresso != null && !codigoIngresso.isEmpty()) {
            try {
                int codigo = Integer.parseInt(codigoIngresso);
                boolean validado = ingressoDao.validarIngresso(codigo);

                if (validado) {
                    // Exibe mensagem de sucesso
                    Alert alert = new Alert(Alert.AlertType.INFORMATION);
                    alert.setTitle("Sucesso");
                    alert.setHeaderText(null);
                    alert.setContentText("Ingresso validado com sucesso!");
                    alert.showAndWait();
                } else {
                    // Caso o ingresso não seja encontrado ou inválido
                    Alert alert = new Alert(Alert.AlertType.WARNING);
                    alert.setTitle("Aviso");
                    alert.setHeaderText(null);
                    alert.setContentText("Ingresso inválido ou já foi validado.");
                    alert.showAndWait();
                }
            } catch (NumberFormatException e) {
                // Código inserido não é um número
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Erro");
                alert.setHeaderText(null);
                alert.setContentText("Código inválido. Digite apenas números.");
                alert.showAndWait();
            }
        } else {
            // Caso o campo esteja vazio
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("Aviso");
            alert.setHeaderText(null);
            alert.setContentText("Por favor, insira um código de ingresso.");
            alert.showAndWait();
        }
    }

}
