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
public class Pelicula {
    
    private int idMovie;
    private String name;
    private int time;
    private String producer;
    private String language;
    private double total;

    public Pelicula(int idMovie, String name, int time, String producer, String language, double total) {
        this.idMovie = idMovie;
        this.name = name;
        this.time = time;
        this.producer = producer;
        this.language = language;
        this.total = total;
    }

    public Pelicula() {
    }
    
    

    public int getIdMovie() {
        return idMovie;
    }

    public void setIdMovie(int idMovie) {
        this.idMovie = idMovie;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getTime() {
        return time;
    }

    public void setTime(int time) {
        this.time = time;
    }

    public String getProducer() {
        return producer;
    }

    public void setProducer(String producer) {
        this.producer = producer;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    
}
