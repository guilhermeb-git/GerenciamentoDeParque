package Models;

import javafx.beans.property.*;

import java.time.LocalTime;

public class Atracao {
    private IntegerProperty id;
    private StringProperty nome;
    private ObjectProperty<LocalTime> horario;
    private IntegerProperty capacidade;

    public Atracao() {
        this.id = new SimpleIntegerProperty();
        this.nome = new SimpleStringProperty();
        this.horario = new SimpleObjectProperty<>();
        this.capacidade = new SimpleIntegerProperty();
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

    public String getNome() {
        return nome.get();
    }

    public void setNome(String nome) {
        this.nome.set(nome);
    }

    public StringProperty nomeProperty() {
        return nome;
    }

    public LocalTime getHorario() {
        return horario.get();
    }

    public void setHorario(LocalTime horario) {
        this.horario.set(horario);
    }

    public ObjectProperty<LocalTime> horarioProperty() {
        return horario;
    }

    public int getCapacidade() {
        return capacidade.get();
    }

    public void setCapacidade(int capacidade) {
        this.capacidade.set(capacidade);
    }

    public IntegerProperty capacidadeProperty() {
        return capacidade;
    }
}
