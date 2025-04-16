package com.example.gerenciamentodeparque;

import Dao.BilheteriaDao;
import Models.Bilheteria;
import javafx.fxml.FXML;
import javafx.scene.control.*;

public class PagamentoController {

    @FXML
    private Label labelDescricao, labelPreco, labelHorario, labelQuantidade, labelStatus;

    @FXML
    private ComboBox<String> comboFormaPagamento;

    @FXML
    private Button buttonConfirmarCompra;

    private Bilheteria bilheteriaSelecionada;
    private final BilheteriaDao bilheteriaDao = new BilheteriaDao();

    public void inicializar(Bilheteria bilheteria) {
        bilheteriaSelecionada = bilheteria;

        labelDescricao.setText(bilheteria.getDescricao());
        labelPreco.setText("Preço: R$ " + bilheteria.getPreco().toString());
        labelHorario.setText("Horário de Fechamento: " + bilheteria.getHorarioFechamento().toString());
        labelQuantidade.setText("Ingressos Disponíveis: " + bilheteria.getQuantidadeDisponivel());
    }

    @FXML
    private void confirmarCompra() {
        if (bilheteriaSelecionada.getQuantidadeDisponivel() > 0) {
            // Seleciona a forma de pagamento
            String formaPagamento = comboFormaPagamento.getValue();
            if (formaPagamento == null) {
                labelStatus.setText("Por favor, selecione uma forma de pagamento.");
                labelStatus.setTextFill(javafx.scene.paint.Color.RED);
                return;
            }

            // Reduz a quantidade de ingressos
            boolean sucesso = bilheteriaDao.reduzirQuantidade(bilheteriaSelecionada.getId());

            if (sucesso) {
                labelStatus.setText("Compra realizada com sucesso!");
                labelStatus.setTextFill(javafx.scene.paint.Color.GREEN);
            } else {
                labelStatus.setText("Erro ao realizar a compra.");
                labelStatus.setTextFill(javafx.scene.paint.Color.RED);
            }
        } else {
            labelStatus.setText("Ingressos esgotados.");
            labelStatus.setTextFill(javafx.scene.paint.Color.RED);
        }
    }
}

