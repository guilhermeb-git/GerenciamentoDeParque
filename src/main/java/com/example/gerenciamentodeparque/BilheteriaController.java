package com.example.gerenciamentodeparque;

import Dao.BilheteriaDao;
import Models.Bilheteria;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;

import java.util.List;

public class BilheteriaController {

    @FXML
    private ListView<Bilheteria> listViewBilheterias;

    @FXML
    private Label labelMensagem;

    private final BilheteriaDao bilheteriaDao = new BilheteriaDao();

    @FXML
    public void initialize() {
        List<Bilheteria> bilheterias = bilheteriaDao.listarTodas();

        if (bilheterias.isEmpty()) {
            labelMensagem.setText("Nenhuma bilheteria disponível no momento.");
            listViewBilheterias.setVisible(false); // esconde a lista
        } else {
            labelMensagem.setText(""); // limpa qualquer mensagem
            listViewBilheterias.getItems().addAll(bilheterias);
        }
    }
}


