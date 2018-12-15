/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package auxiliares;

import consola.Administrador;
import consola.Credenciales;
import modelos.Asignacion;
import modelos.Sala;

public class Reporte {
    
    int total =0, numberOfSeats, sala1count, sala2count, sala3count, sala4count, sala5count;
    int[] matrix, arreglo;
    Asignacion movie;
    
    public int pointerMatrix(){
        int count = 0;
        for(int i: matrix){
            if(i!=0){
                count++;
            }
        }return count;
    }
    
    public void getMatrix(){
        matrix = new int[100];
        for(Asignacion assign: Administrador.assigned){
            if(assign!=null){
                matrix[pointerMatrix()] = (int) assign.getMovie().getTotal();
            }
        }
    }
    
    int mayor(int [] vector){
        int mayor = vector[0]; 
        for(int i = 1; i<vector.length; i++){
            if(vector[i]>mayor)mayor = vector[i];
        }
        return mayor;
    }
    
    public void report1(){
        getMatrix();
       for(Asignacion assign: Administrador.assigned){
            if(assign!=null){
                if(assign.getMovie().getTotal()==mayor(matrix)){
                    movie = assign;
                }
            }
        }
        System.out.println("Nombre: "+movie.getMovie().getName()
        +"\n"+"Productor: "+movie.getMovie().getProducer()
        +"\n"+"Ganancias: "+movie.getMovie().getTotal());
    } 

    
    public void report2(){ 
        sum();
        for(int i = 0; i<=pointerMatrix();i++){
            if(matrix[i]==sala1count){
                System.out.println("Sala 1: "+matrix[i]);
            }else if(matrix[i]==sala2count){
                System.out.println("Sala 2: "+matrix[i]);
            }else if(matrix[i]==sala3count){
                System.out.println("Sala 3: "+matrix[i]);
            }else if(matrix[i]==sala4count){
                System.out.println("Sala 4: "+matrix[i]);
            }else if(matrix[i]==sala5count){
                System.out.println("Sala 5: "+matrix[i]);
            }
        }
        
    }
    
    public void sum(){
    for(Sala sala: Credenciales.salas){
        if(sala!=null){
            switch(sala.getName()){
                case "Sala 1":
                    for(Asignacion assig: Administrador.assigned){
                        if(assig!=null){
                            if(assig.getSala().getName().equals(sala.getName())){
                                sala1count += assig.getSala().getSeatsSaled();
                            }
                        }
                    }
                    break;
                    case "Sala 2":
                    for(Asignacion assig: Administrador.assigned){
                        if(assig!=null){
                            if(assig.getSala().getName().equals(sala.getName())){
                                sala2count += assig.getSala().getSeatsSaled();
                            }
                        }
                    }
                    break;
                    case "Sala 3":
                    for(Asignacion assig: Administrador.assigned){
                        if(assig!=null){
                            if(assig.getSala().getName().equals(sala.getName())){
                                sala3count += assig.getSala().getSeatsSaled();
                            }
                        }
                    }
                    break;
                    case "Sala 4":
                    for(Asignacion assig: Administrador.assigned){
                        if(assig!=null){
                            if(assig.getSala().getName().equals(sala.getName())){
                                sala4count += assig.getSala().getSeatsSaled();
                            }
                        }
                    }
                    break;
                    case "Sala 5":
                    for(Asignacion assig: Administrador.assigned){
                        if(assig!=null){
                            if(assig.getSala().getName().equals(sala.getName())){
                                sala5count += assig.getSala().getSeatsSaled();
                            }
                        }
                    }
                    break;
                }
        
            }
    
        }
        
    generateSalasMatrix();
    }
    
    public Sala serchByNumber(int number){
        for(Asignacion assign: Administrador.assigned){
            if(assign!=null){
                if(assign.getSala().getSeatsSaled()==number){
                    return assign.getSala();
                }
            }
        }
    return null;
    }
    
    static void burbuja(int arreglo[]){
        for(int i = 0; i < arreglo.length - 1; i++){
            for(int j = 0; j < arreglo.length - 1; j++){
                if (arreglo[j] < arreglo[j + 1]){
                    int tmp = arreglo[j+1];
                    arreglo[j+1] = arreglo[j];
                    arreglo[j] = tmp;
                }
            }
        }
    }
    
    public void generateSalasMatrix(){
        matrix = new int[100];
        matrix[0] = sala1count;
        matrix[1] = sala2count;
        matrix[2] = sala3count;
        matrix[3] = sala4count;
        matrix[4] = sala5count;
        burbuja(matrix);
    }
    
    public void report3(Sala sala){
        System.out.println("---------- "+sala.getName()+" ----------");
        for(Asignacion transmitida: Administrador.transmitidas){
            if(transmitida!=null){
                if(transmitida.getSala()==sala){
                    System.out.println(transmitida.getMovie());
                }
            }
        }
    }
    
    
}
