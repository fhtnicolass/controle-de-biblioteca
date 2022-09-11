package models;

public class Curso {
    private int codigo;
    private String nome;
    private String tipo;
    private int vagas;
    private String duracao;
    private String supervisor;
    private Double mensalidade;
    private Modalidade ensino;
    
    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public int getVagas() {
        return vagas;
    }

    public void setVagas(int vagas) {
        this.vagas = vagas;
    }

    public String getDuracao() {
        return duracao;
    }

    public void setDuracao(String duracao) {
        this.duracao = duracao;
    }

    public String getSupervisor() {
        return supervisor;
    }

    public void setSupervisor(String supervisor) {
        this.supervisor = supervisor;
    }

    public Modalidade getStatus() {
        return ensino;
    }

    public void setStatus(Modalidade status) {
        
        this.ensino = status;
        
    }
    
    public Double getMensalidade() {
        return mensalidade;
    }

    public void setMensalidade(Double mensalidade) {
        this.mensalidade = mensalidade;
    }

    public enum Modalidade {
        EAD("Ensino a Distancia"), PRESENCIAL("Presencial"), HIBRIDO("Hibrido");

        private Modalidade(String label) {
            this.label = label;
        }

        public String label;

        @SuppressWarnings("unused")
        public String getLabel() {
            return label;
        }
    }

}

    
