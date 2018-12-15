/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package auxiliares;

import modelos.Pelicula;
import consola.Administrador;

public class Separador {
    
    public void read(String cadena, int pointer){
        String[] movieStr = cadena.split(";");
        for(String m: movieStr){
            String[] movie = m.split(",");
            String number = movie[1].trim();
            Pelicula newMovie = new Pelicula(pointer +1, movie[0], Integer.valueOf(number), movie[2], movie[3], 0.0);
            Administrador.movies[pointer] = newMovie;
            pointer++;
        }
    
    }
    
}
