/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package consola;

import auxiliares.Random;
import auxiliares.Reloj;
import auxiliares.Reporte;
import auxiliares.Separador;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;
import modelos.Asiento;
import modelos.Asignacion;
import modelos.Horario;
import modelos.Pelicula;
import modelos.Sala;

public class Administrador {
    
    Scanner scan = new Scanner(System.in);
    public static Pelicula[] movies = new Pelicula[100];
    public static Asignacion[] assigned = new Asignacion[100];
    public static Asignacion[] transmitidas = new Asignacion[100];
    Credenciales login;
    int option, time,correct,count;
    String movieName, producer, language, cadena;       
    Reloj clock = new Reloj();
    boolean exists = false;
    Asiento[][] seats=null;
    Separador separator = new Separador();
    Pelicula currentMovie, movieCurr=new Pelicula();
    Asignacion assign;
    Sala currentSala,salaCurr =new Sala();
    Random random = new Random();
    Horario timeTable,horario=new Horario();
    Reporte report = new Reporte();
    
    
    void incorrectOption(String menu){
        option = 0;
        System.out.println("********** OPCION INCORRECTA **********");
        System.out.println("Desea seguir con la ejecucion del programa? ");
        System.out.println("1. SI");
        System.out.println("2. NO ");
        try{option = scan.nextInt();}catch(Exception e){incorrectOption("incorrectOption");}
        switch(option){
            case 1:
                switch(menu){
                    case "incorrectOption":
                        incorrectOption("incorrectOption");
                        break;
                    case "menu":    
                        menu();
                        break;
                    case "enterMovie":
                        enterMovie();
                        break;
                    case "assignMovie":
                        assignMovie();
                        break;
                }
                break;
            case 2:
                System.exit(0);
                break;
            default:
                
                break;
        }
        
    }
    
    public void menu(){
        System.out.println("Bienvenido");
        System.out.println("1. Hora");
        System.out.println("2. Ingreso de peliculas");
        System.out.println("3. Simulacion de horario");
        System.out.println("4. Asignacion");
        System.out.println("5. Reportes");
        System.out.println("6. Cerrar sesion");
        try{option = scan.nextInt();}catch(Exception e){}
        switch(option){
            case 1:
                currentTime();
                 menu();
                break;
            case 2:
                enterMovie();
                break;
            case 3:
                assignMovie();
                break;
            case 4:
                simulate();
                menu();
                break;
            case 5:
                report();
                break;
            case 6:
                login = new Credenciales();
                login.login();
                break;
            default:
                incorrectOption("menu");
                break;
        }   
    
    }
    
    public void currentTime(){
        System.out.println("La hora actual es: "+clock.getCurrentTime());
    }
    
    public void enterMovie(){
        System.out.println("*****INGRESAR PELICULA*****");
        System.out.println("1. Ingreso de pelicula manual");
        System.out.println("2. Ingreso de pelicula por lote");
        System.out.println("3. Atras");
        try{option = scan.nextInt();}catch(Exception e){}
        switch(option){
            case 1:
                movieManual();
                break;
            case 2:
                movieAutomatic();
                break;
            case 3:
                menu();
                break;
            default:
                incorrectOption("enterMovie");
                break;
        }
    }
    public void movieAutomatic(){
        System.out.println("*****INGRESAR PELICULA*****");
        System.out.println("-------------------------------------");
        System.out.println("Ingrese la cadena de caracteres");
        cadena = scan.nextLine();
        cadena = scan.nextLine();
        System.out.println("Ingresando pelicula(s)...");
        try{separator.read(cadena, moviePointer());
            System.out.println("Pelicula(s) ingresadas correctamente");
            enterMovie();
        }catch(Exception e){
            System.out.println("Hubo un error al intentar ingresar la pelicula,"
                    + " por favor, intentelo de nuevo");
            enterMovie();
        }
    }
    
    
    public void movieManual(){
        System.out.println("*****INGRESAR PELICULA*****");
        System.out.println("-------------------------------------");
        movieName = scan.nextLine();
        System.out.println("Ingrese el nombre de la pelicula");
        movieName = scan.nextLine();
        System.out.println("Ingrese el tiempo de duracion de la pelicula");
        try{time = Integer.valueOf(scan.nextLine());}catch(NumberFormatException e){}
        System.out.println("Ingrese el productor de la pelicula");
        producer = scan.nextLine();
        System.out.println("Ingrese el lenguaje de la pelicula");
        language = scan.nextLine();
        System.out.println("Ingresando pelicula...");
        try{
            Pelicula movie = new Pelicula(moviePointer()+1, movieName, time, producer, language,0.0);
            movies[moviePointer()] = movie;
            System.out.println("Pelicula ingresada correctamente");
            enterMovie();
        }catch(Exception e){
            System.out.println("Hubo un error al intentar ingresar la pelicula,"
                    + " por favor, intentelo de nuevo");
            enterMovie();
        }
    }
    
    public void assignMovie(){
        System.out.println("Asignacion de peliculas por sala");
        System.out.println("1. Asignacion manual");
        System.out.println("2. Asignacion automatica");
        System.out.println("3. Atras");
        try{option = scan.nextInt();}catch(Exception e){}
        switch(option){
            case 1:
                assignManual();
                menu();
                break;
            case 2:
                assignAutomatic();
                break;
            case 3:
                menu();
            default:
                incorrectOption("assignMovie");
                break;
        }
    }
    
    public void generateReport(){
        System.out.println("********** REPORTE 3 **********");
        System.out.println("Peliculas que se pasaron en cada sala");
        System.out.println("Por favor, ingrese el numero de la sala: ");
        try{option = scan.nextInt();}catch(Exception e){}
        if(serchSala(option)!=null){
            report.report3(serchSala(option));
        }else{
            System.out.println("********** SALA INVALIDA **********");
            menu();
        }
    }
    
    public Sala serchSala(int id){
        for(Sala sala: Credenciales.salas){
            if(sala!=null){
                if(sala.getIdSala()==id){
                    return sala;
                }
            }
        }return null;
    }
    
    public Pelicula generateRandomMovie(){
        return movies[random.generateRandomID(moviePointer())];
    }
    
    public Horario generateRandomTimeTable(){
        return Credenciales.horarios[random.generateRandomID(Credenciales.horarios.length)];
    }
    
    public Sala generateRandomSala(){
        return Credenciales.salas[random.generateRandomID(Credenciales.salas.length)];
    }
    
    public boolean movieExists(Asignacion movie){
        for(Asignacion assignMov: assigned){
            if(assignMov!=null){
                if(movie.getSala()==assignMov.getSala()
                        && movie.getTimeTable()==assignMov.getTimeTable()){
                    return true;
                }
            }
        }
     return false;
    }
    
    public void simulate(){
        currentTime();
        System.out.println("Se transmitirán las peliculas del siguiente horario...");
        try{
            simuHorary(clock.convertToDate(clock.getCurrentTime()));
            clock.changeTime();
            System.out.println("Pelicula(s) transimitadas correctamente");
        }catch(Exception e){
            System.out.println("Hubo un error al intentar transmitir las peliculas");
        }
        
    }
    
    public void simuHorary(Date init){
       for(Asignacion asgn: assigned){
            if(asgn!=null){
                if(clock.convertToString(asgn.getTimeTable().getInit()).equals(clock.convertToString(init))){ 
                    transmitidas[transmitidasPointer()] = asgn; 
                    assigned[asgn.getIdMoviePerRoom()-1] = null;
                }
            }
        }
    }
    
    
    public void assignAutomatic(){ 
           while(correct < moviePointer()){
               try{
                    movieCurr = generateRandomMovie();
                   salaCurr = generateRandomSala();
                   horario = generateRandomTimeTable();                 
                   Asignacion movie = new Asignacion(moviePerRoomPointer()+1, movieCurr,salaCurr,horario);
                    if(!movieExists(movie)){
                        assigned[moviePerRoomPointer()] = movie;
                        correct++;   
                    }
                }catch(Exception e){
                    System.out.println("OCURRIO UN ERROR AL INTENTAR ASIGNAR LAS PELICULAS");
                    menu();
                }
           }   
           System.out.println("Peliculas asignadas correctamente");
            menu();
    }
    
    public void assignManual(){
       
        printMovies();
        System.out.println("Por favor, ingrese el numero de la pelicula que desea asignar");
        try{option = scan.nextInt();
            currentMovie = selectedMovie(option);
        }catch(Exception e){
            System.out.println("Ocurrio un problema con la pelicula seleccionada");
        }
        System.out.println("Por favor, ingrese el numero de la sala de desea asignar");
        printSala();
        try{option = scan.nextInt();
            currentSala=selectedSala(option);
        }catch(Exception e){
            System.out.println("Ocurrio un problema con la sala seleccionada");
        }
        System.out.println("Por favor, ingrese el numero del horario que desea asignar");
        printHorary();
        try{option = scan.nextInt();
            timeTable = selectedHorary(option);
        }catch(Exception e){
            System.out.println("Ocurrio un problema con el horario seleccionado");
        }
        System.out.println("Realizando asignacion...");
        assign = new Asignacion(moviePerRoomPointer()+1,currentMovie, currentSala, timeTable);
        assigned[moviePerRoomPointer()] = assign;
        System.out.println("Asignacioln realizada correctamente");
    }
    
    
    public Horario selectedHorary(int selected){
        for(Horario horary: Credenciales.horarios){
            if(horary!=null){
                if(horary.getIdTimeTable()==selected){
                    return horary;
                }
            }
        }return null;
    }
    
    public void report(){
        System.out.println("A continuacion se muestran los reportes de cada una de las peliculas");
        System.out.println("********** PELICULA CON MAS GANANCIAS **********");
        report.report1();
        System.out.println("********** SALAS CON MAS ASIENTOS VENDIDOS ********** ");
        report.report2();
        generateReport();
        menu();
    
    }
    
    public Sala selectedSala(int selected){
        for(Sala sala: Credenciales.salas){
            if(sala!=null){
                if(sala.getIdSala()==selected){
                    return sala;
                }
            }
        }
    return null;
    }
    
    public void printAssigned(){
        for(Asignacion asg: assigned){
            if(asg !=null){
                System.out.println(asg.getIdMoviePerRoom()+". Pelicula: "+asg.getMovie().getName()+"\n"
                       + "Horario: de "+getCurrentTime(asg.getTimeTable().getInit())+" a "+ getCurrentTime(asg.getTimeTable().getFinish())
               + "En: "+asg.getMovie().getLanguage());           
            }
        }   
    }
    
    public boolean verifyHorary(Horario horary, Sala sala){
        for(Asignacion as:assigned){
            if(as!=null){
                if(as.getSala()==sala){
                    if(as.getTimeTable()==horary){
                    return true;
                    }
                }
            }
        }    
        return false;
    }
    
    public String getCurrentTime(Date date){
        DateFormat hourFormat = new SimpleDateFormat("HH:mm:ss");
        return hourFormat.format(date);
    }
    
    public void printHorary(){
        for(Horario horary: Credenciales.horarios){
            if(horary!=null){
                if(!verifyHorary(horary,currentSala)){
                System.out.println(horary.getIdTimeTable()+". Horario de: " +getCurrentTime(horary.getInit())+ " a "+
                        getCurrentTime(horary.getFinish()));
                }
            }
        }  
    }
    
    public Pelicula selectedMovie(int selected){
        for(Pelicula movie: movies){
            if(movie!=null){
                if(movie.getIdMovie()==selected){
                    return movie;
                }
            }
        
        }
        return null;
    }
    
    public void printMovies(){
        for(Pelicula movie: movies){
            if(movie!=null){
                System.out.println(movie.getIdMovie()+". Pelicula:"+movie.getName()+"\n"
                        +"Duracion: "+movie.getTime() +" minutos"+"\n"
                                +"Lenguaje: "+movie.getLanguage()+"\n"
                                +"Productor: "+movie.getProducer()+" \n");
            }
        }
    }
    
    public void printSala(){
        for(Sala sala:Credenciales.salas){
            if(sala!=null){
                System.out.println(sala.getIdSala()+ ". Sala: "+sala.getName());
            }
        }
    }
    
    int transmitidasPointer(){
        int count = 0;
        for(Asignacion transmitida: transmitidas){
            if(transmitida!=null){
                count++;
            }
        }
        return count;
    }
    
    int moviePointer(){
        int count = 0;
        for(Pelicula movie: movies){
            if(movie!=null){
                count++;
            }
        }
    return count;
    }
    
    int moviePerRoomPointer(){
        int count = 0;
        for(Asignacion asgn: assigned){
            if(asgn!=null){
                count++;
            }
        }
    return count;
    }
    
}
