package sample.model;

import java.util.Random;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.ObservableSet;

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class Jogo {

    private static String FILE="jogadores.bin";
    private static String FILE_PERGUNTAS="Geografia.txt";


    private ObservableSet<Jogador> jogadores;
    private ObservableSet<Pergunta> perguntas;

    private static Jogo instance = new Jogo();

    private Jogo(){
        jogadores = FXCollections.observableSet();
        perguntas = FXCollections.observableSet();
    }

    public static Jogo getInstance(){
        return instance;
    }

    public void cadastrarJogador(Jogador j){
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
                        perguntas.add(aux.get(j));

                    }
                }


            }while(perguntas.size()<8);
            System.out.println(perguntas);
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
}
