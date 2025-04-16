package Models;

import javafx.beans.property.*;

public class Ingresso {
    private IntegerProperty id;
    private IntegerProperty clienteId;
    private IntegerProperty atracaoId;  // Propriedade para atracaoId
    private ObjectProperty<java.time.LocalDateTime> dataCompra;
    private StringProperty formaPagamento;
    private BooleanProperty validado;

    public Ingresso() {
        this.id = new SimpleIntegerProperty();
        this.clienteId = new SimpleIntegerProperty();
        this.atracaoId = new SimpleIntegerProperty();  // Inicializa a propriedade
        this.dataCompra = new SimpleObjectProperty<>();
        this.formaPagamento = new SimpleStringProperty();
        this.validado = new SimpleBooleanProperty(false);
    }

    public int getId() {
        return id.get();
    }

    public void setId(int id) {
        this.id.set(id);
    }

    public IntegerProperty idProperty() {
        return id;
    }

    public int getClienteId() {
        return clienteId.get();
    }

    public void setClienteId(int clienteId) {
        this.clienteId.set(clienteId);
    }

    public IntegerProperty clienteIdProperty() {
        return clienteId;
    }

    public int getAtracaoId() {
        return atracaoId.get();
    }

    public void setAtracaoId(int atracaoId) {  // Adicionando o setter para atracaoId
        this.atracaoId.set(atracaoId);
    }

    public IntegerProperty atracaoIdProperty() {
        return atracaoId;
    }

    public java.time.LocalDateTime getDataCompra() {
        return dataCompra.get();
    }

    public void setDataCompra(java.time.LocalDateTime dataCompra) {
        this.dataCompra.set(dataCompra);
    }

    public ObjectProperty<java.time.LocalDateTime> dataCompraProperty() {
        return dataCompra;
    }

    public String getFormaPagamento() {
        return formaPagamento.get();
    }

    public void setFormaPagamento(String formaPagamento) {
        this.formaPagamento.set(formaPagamento);
    }

    public StringProperty formaPagamentoProperty() {
        return formaPagamento;
    }

    public boolean isValidado() {
        return validado.get();
    }

    public void setValidado(boolean validado) {
        this.validado.set(validado);
    }

    public BooleanProperty validadoProperty() {
        return validado;
    }

    // Métodos para as propriedades das colunas da tabela
    public StringProperty clienteNomeProperty() {
        return new SimpleStringProperty("Nome do Cliente");  // Exemplo, deve ser ajustado conforme seu modelo
    }

    public StringProperty atracaoNomeProperty() {
        return new SimpleStringProperty("Nome da Atração");  // Exemplo, deve ser ajustado conforme seu modelo
    }
}
