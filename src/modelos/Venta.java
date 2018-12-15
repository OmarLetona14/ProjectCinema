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
public class Venta {
    
    private int idSale;
    private Asignacion movie;
    private String seats;
    private double amount;

    public Venta(int idSale, Asignacion movie, String seats, double amount) {
        this.idSale = idSale;
        this.movie = movie;
        this.seats = seats;
        this.amount = amount;
    }

    public int getIdSale() {
        return idSale;
    }

    public void setIdSale(int idSale) {
        this.idSale = idSale;
    }

    public Asignacion getMovie() {
        return movie;
    }

    public void setMovie(Asignacion movie) {
        this.movie = movie;
    }

    public String getSeats() {
        return seats;
    }

    public void setSeats(String seats) {
        this.seats = seats;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    } 
}
