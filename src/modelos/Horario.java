/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelos;

import java.util.Date;

/**
 *
 * @author Omar
 */
public class Horario {
    
    private int idTimeTable;
    private Date init;
    private Date finish;

    public Horario(int idTimeTable, Date init, Date finish) {
        this.idTimeTable = idTimeTable;
        this.init = init;
        this.finish = finish;
    }

    public Horario() {
    }
    

    public int getIdTimeTable() {
        return idTimeTable;
    }

    public void setIdTimeTable(int idTimeTable) {
        this.idTimeTable = idTimeTable;
    }

    public Date getInit() {
        return init;
    }

    public void setInit(Date init) {
        this.init = init;
    }

    public Date getFinish() {
        return finish;
    }

    public void setFinish(Date finish) {
        this.finish = finish;
    }
 
}
