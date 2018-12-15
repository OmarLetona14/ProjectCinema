/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelos;

/**
 *
 * @author Omar
 */
public class Asignacion {
    
    private int idMoviePerRoom;
    private Pelicula movie;
    private Sala sala;
    private Horario timeTable;

    public Asignacion(int idMoviePerRoom, Pelicula movie, Sala sala, Horario timeTable) {
        this.idMoviePerRoom = idMoviePerRoom;
        this.movie = movie;
        this.sala = sala;
        this.timeTable = timeTable;
    }

    public Asignacion() {
    }
    
    

    public int getIdMoviePerRoom() {
        return idMoviePerRoom;
    }

    public void setIdMoviePerRoom(int idMoviePerRoom) {
        this.idMoviePerRoom = idMoviePerRoom;
    }

    public Pelicula getMovie() {
        return movie;
    }

    public void setMovie(Pelicula movie) {
        this.movie = movie;
    }

    public Sala getSala() {
        return sala;
    }

    public void setSala(Sala sala) {
        this.sala = sala;
    }

    public Horario getTimeTable() {
        return timeTable;
    }

    public void setTimeTable(Horario timeTable) {
        this.timeTable = timeTable;
    }
}
