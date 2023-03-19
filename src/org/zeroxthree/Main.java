package org.zeroxthree;

import org.hibernate.Session;
import org.zeroxthree.cruds.PlayersCRUD;

import java.util.Scanner;

public class Main {

    public static void main(String args[]){


        Scanner scanner = new Scanner(System.in);
        System.out.println("1. Просмотреть всех игроков");
        System.out.println("2. Создать нового игрока");
        String choose = scanner.nextLine();
        if(choose.equals("2")){
            createNewPlayer();
        }else if(choose.equals("1")){
            showPlayers();
        }


    }

    public static void createNewPlayer(){
        PlayersCRUD playersCRUD = new PlayersCRUD();
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите имя: ");
        String name = scanner.nextLine();
        System.out.println("Введите пароль: ");
        String password = scanner.nextLine();
        System.out.println("Введите рекорд: ");
        int record = scanner.nextInt();
        Players players1 = new Players(name, password, record);
        playersCRUD.save(players1);
        System.out.println(name + " успешно создан!");

    }



    public static void showPlayers(){
        PlayersCRUD playersCRUD = new PlayersCRUD();
        System.out.println("Все игроки: ");
        if(playersCRUD.getAllPlayers() != null){
            for(Players player: playersCRUD.getAllPlayers()){
                System.out.println("Игрок: " + player.getNickname() + " | " +  player.getRecord());
            }

        }else{
            System.out.println("В данный момент не зарегистрировано ни одного игрока");
        }



    }
}
