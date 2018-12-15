/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package consola;

import auxiliares.Reloj;
import java.util.Date;
import java.util.Scanner;
import modelos.Asiento;
import modelos.Horario;
import modelos.Sala;
import modelos.Usuario;

public class Credenciales {
    
    Scanner reader = new Scanner(System.in);
    public static Sala[] salas = new Sala[5];
    public static Usuario[] users = new Usuario[2];
    public static Horario[] horarios = new Horario[6];
    Asiento[][] seats =null;
    Administrador admin = new Administrador();
    Vendedor seller = new Vendedor();
    Reloj clock = new Reloj();
    String userName, password;
    
    public void login(){
        generateSala();
        createUser();
        generateTimeTable();
        clock.initTime();
        System.out.println("BIENVENIDO AL SISTEMA");
        System.out.println("Nickname: ");
        userName = reader.nextLine();
        System.out.println("Contraseña: ");
        password = reader.nextLine();
        if(verifyLogin(userName, password)){
            if(verifyAdmin(userName)){
                admin.menu();
            }else{
                seller.menu();
            }
        }else{
            System.out.println("**********  Credenciales incorrectas **********");
            login();
        }
    }
    
    
    public void generateSala(){
        Sala sala;
        for(int i = 0; i<=4; i++){
            generateSeats();
            sala = new Sala(i+1, "Sala " + (i+1), seats,0);
            salas[i] = sala;
        }
    }
    
    public void generateSeats(){
        seats = new Asiento[5][8];
        Asiento seat;
        int count = 1;
        for(int x = 0; x<=7; x++){
            for(int y = 0; y<=4;y++){
                seat = new Asiento(count,generateRowName(x),String.valueOf(y),true);
                seats[y][x] = seat;
                count++;
            }
        }
    }
    
    
    public void generateTimeTable(){
        int init = 13, fin = 15;
        String timeStrInit, timeStrFinal;
        Horario horary;
        for(int i=0; i<=5;i++ ){
            timeStrInit = init+":00:00";
            timeStrFinal = fin+":00:00";
            Date initTime = clock.convertToDate(timeStrInit);
            Date finalTime = clock.convertToDate(timeStrFinal);
            horary = new Horario(i+1,initTime,finalTime);
            init +=2;
            fin += 2;
            horarios[i] = horary;
        }
    
    }
    
    public String generateRowName(int x){
        switch(x){
            case 0:
                return "a";
            case 1:
                return "b";
            case 2:
                return "c";
            case 3:
                return "d";
            case 4:
                return "e";
            case 5:
                return "f";
            case 6:
                return "g";
            case 7:
                return "h";   
        }
        return "";
    }
    
    public void createUser(){
        Usuario admin = new Usuario(1, "ADMIN","Administrador","201700377" );
        Usuario seller = new Usuario(2, "VENDEDOR","Vendedor", "201700377");
        users[0] = admin;
        users[1] = seller;
    }
    
    public boolean verifyAdmin(String userName){
        return userName.equals("ADMIN");
    }
    
    public boolean verifyLogin(String user, String password){
        for(Usuario systemUser: users){
            if(systemUser.getName().equals(user)){
                return systemUser.getPassword().equals(password);
            }
        }
        return false;
    }
    
}
