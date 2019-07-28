package sample.model;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Collections;
import java.util.Date;
import java.util.Random;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import sample.control.Avisos;
import sample.control.MenuJogo;
import sample.control.TelaInicial;

import java.io.*;
import java.util.ArrayList;

public class Jogo extends Avisos {

    private static String FILE="jogadores.bin";
    private static String FILE_PERGUNTAS="perguntas.txt";

    private ObservableList<Jogador> jogadores;
    private ObservableList<Pergunta> perguntas;
    private Jogador jogadorLogado;
    private int pontuacao = 0;
    private String dificuldade;


    private static Jogo instance = new Jogo();

    public void  finalizaPartida() throws IOException{

        if(jogadorLogado.getMaiorPontuacao() < pontuacao){
            jogadorLogado.setMaiorPontuacao(pontuacao);
        }

        DateFormat ultimaJogada = new SimpleDateFormat("dd/MM/yyyy");

        Date data = new Date();

        ultimaJogada.format(data);

        for (Jogador j:jogadores) {
            if(j.equals(jogadorLogado)){
                j.setUltimaJogada(data);
            }
        }

        jogadorLogado.setUltimaJogada(data);
        pontuacao = 0;

        salvarJogadores();

    }

    public ObservableList<Pergunta> getPerguntas() {
        return perguntas;
    }

    public int getPontuacao() {
        return pontuacao;
    }

    public Jogador getJogadorLogado() {
        return jogadorLogado;
    }

    public int getDificuldade(){
        if(dificuldade.equals("Dificíl")){
            return 1;
        }
        else if(dificuldade.equals("Médio")){
            return 2;
        }
        else{
            return 3;
        }
    }

    public void setDificuldade(String dificuldade) {
        this.dificuldade = dificuldade;
    }

    public void setJogadorLogado(Jogador jogadorLogado) {
        this.jogadorLogado = jogadorLogado;
    }

    private Jogo(){
        jogadores = FXCollections.observableArrayList();
        perguntas = FXCollections.observableArrayList();

    }

    public static Jogo getInstance(){
        return instance;
    }

    public void cadastrarJogador(Jogador j){

        jogadorLogado = j;
        jogadores.add(j);
    }

    public void carregaPerguntas(){
        ArrayList<Pergunta> aux = new ArrayList<>();

        //randomizer//
        Random random = new Random();
        //////////////

        String enunciado;


        int correta;

        int numPerguntas, rand, numOpcoes;

        try(FileReader f = new FileReader(FILE_PERGUNTAS);
                BufferedReader br = new BufferedReader(f)){

            numPerguntas = Integer.valueOf(br.readLine());
            numOpcoes= Integer.valueOf(br.readLine());

            for(int i =0; i<numPerguntas;i++){
                ArrayList<String> opcoes = new ArrayList<>();


                enunciado = br.readLine();
                for(int j = 0; j<numOpcoes; j++){
                    opcoes.add(br.readLine());
                }

                correta = Integer.valueOf(br.readLine());

                Pergunta p = new Pergunta(enunciado, opcoes,correta);

                aux.add(p);
            }

            do{
                for(int j=0; j<numPerguntas; j++){
                    rand = random.nextInt(numPerguntas);
                    if(j == rand){
                        if(!perguntas.contains(aux.get(j))){
                            perguntas.add(aux.get(j));

                        }
                    }
                }


            }while(perguntas.size()<8);

        }
        catch (IOException e){
            System.out.println(e);
        }

    }


    public void carregaJogadores() throws IOException, ClassNotFoundException{
        jogadores.clear();

        ObjectInputStream ois = new ObjectInputStream(
                new FileInputStream(
                        new File(FILE)
                )
        );

        ArrayList<Jogador> temp = (ArrayList)ois.readObject();

        jogadores.addAll(temp);

        ois.close();
    }

    public void salvarJogadores() throws IOException{
        ObjectOutputStream oos = new ObjectOutputStream(
                new FileOutputStream(
                        new File(FILE))
        );

        ArrayList<Jogador> temp = new ArrayList<>();
        temp.addAll(jogadores);

        oos.writeObject(temp);

        oos.close();
    }

    public void marcaPontos(int verifica){
        if(verifica == 1){
            pontuacao = pontuacao+3;

        }
        else if(verifica == 2){
            pontuacao = pontuacao-1;

        }
    }

    public boolean verificaJogadores(String nome){
        for(Jogador j: jogadores){
            if(j.getNome().equals(nome)){
                jogadorLogado = j;
                return true;
            }
        }

        return false;
    }


    public ObservableList<Jogador> getJogador(){

        return FXCollections.unmodifiableObservableList(jogadores);
    }
}
