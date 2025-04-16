package Models;

public class Participacao {
    private int id;
    private int clienteId;
    private int atracaoId;
    private int ingressoId;

    // Getters e Setters
    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public int getClienteId() { return clienteId; }
    public void setClienteId(int clienteId) { this.clienteId = clienteId; }

    public int getAtracaoId() { return atracaoId; }
    public void setAtracaoId(int atracaoId) { this.atracaoId = atracaoId; }

    public int getIngressoId() { return ingressoId; }
    public void setIngressoId(int ingressoId) { this.ingressoId = ingressoId; }
}

