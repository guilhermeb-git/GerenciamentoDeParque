package com.example.gerenciamentodeparque;

import Dao.AtracaoDao;
import Models.Atracao;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;

import java.util.List;

public class AtracaoController {

    @FXML
    private TableView<Atracao> tableAtracoes;
    @FXML
    private TableColumn<Atracao, String> colNome;
    @FXML
    private TableColumn<Atracao, String> colHorario;
    @FXML
    private TableColumn<Atracao, Integer> colCapacidade;

    private AtracaoDao atracaoDao = new AtracaoDao();

    @FXML
    private void initialize() {
        // Configura as colunas da tabela
        colNome.setCellValueFactory(cellData -> cellData.getValue().nomeProperty());
        colHorario.setCellValueFactory(cellData -> cellData.getValue().horarioProperty().asString());
        colCapacidade.setCellValueFactory(cellData -> cellData.getValue().capacidadeProperty().asObject());

        // Carregar as atrações na tabela
        carregarAtrações();
    }

    private void carregarAtrações() {
        List<Atracao> atracoes = atracaoDao.listarTodas();
        tableAtracoes.getItems().setAll(atracoes);
    }

    @FXML
    private void registrarParticipacao(ActionEvent event) {
        // Verifica se há uma atração selecionada na tabela
        Atracao atracaoSelecionada = tableAtracoes.getSelectionModel().getSelectedItem();

        if (atracaoSelecionada != null) {
            // Aqui você pode implementar a lógica para registrar a participação do cliente.
            // Exemplo: Registrar a participação de um cliente na atração selecionada

            // Exemplo de notificação
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Sucesso");
            alert.setHeaderText(null);
            alert.setContentText("Participação registrada com sucesso!");
            alert.showAndWait();
        } else {
            // Caso nenhuma atração seja selecionada
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("Aviso");
            alert.setHeaderText(null);
            alert.setContentText("Por favor, selecione uma atração.");
            alert.showAndWait();
        }
    }
}
