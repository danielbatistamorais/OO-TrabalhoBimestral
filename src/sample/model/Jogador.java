package sample.model;

import java.io.Serializable;
import java.time.LocalDateTime;

public class Jogador implements Serializable{
    private int codigo;
    private String nome;
    private int maiorPontuacao;
    private LocalDateTime ultimaJogada;

    public Jogador(int codigo, String nome, int maiorPontuacao, LocalDateTime ultimaJogada) {
        this.codigo = codigo;
        this.nome = nome;
        this.maiorPontuacao = maiorPontuacao;
        this.ultimaJogada = ultimaJogada;
    }

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

    public int getMaiorPontuacao() {
        return maiorPontuacao;
    }

    public void setMaiorPontuacao(int maiorPontuacao) {
        this.maiorPontuacao = maiorPontuacao;
    }

    public LocalDateTime getUltimaJogada() {
        return ultimaJogada;
    }

    public void setUltimaJogada(LocalDateTime ultimaJogada) {
        this.ultimaJogada = ultimaJogada;
    }
}
