package co.edu.poli.dto;

import java.time.LocalDate;

public class HistoricoDto {

    private int emplHistId;
    private LocalDate empHistFechaRetiro;
    private int emplHistEmpleadoId;
    private int emplHistCargoId;
    private int emplHistDptoId;

    public int getEmplHistId() {
        return emplHistId;
    }

    public void setEmplHistId(int emplHistId) {
        this.emplHistId = emplHistId;
    }

    public LocalDate getEmpHistFechaRetiro() {
        return empHistFechaRetiro;
    }

    public void setEmpHistFechaRetiro(LocalDate empHistFechaRetiro) {
        this.empHistFechaRetiro = empHistFechaRetiro;
    }

    public int getEmplHistEmpleadoId() {
        return emplHistEmpleadoId;
    }

    public void setEmplHistEmpleadoId(int emplHistEmpleadoId) {
        this.emplHistEmpleadoId = emplHistEmpleadoId;
    }

    public int getEmplHistCargoId() {
        return emplHistCargoId;
    }

    public void setEmplHistCargoId(int emplHistCargoId) {
        this.emplHistCargoId = emplHistCargoId;
    }

    public int getEmplHistDptoId() {
        return emplHistDptoId;
    }

    public void setEmplHistDptoId(int emplHistDptoId) {
        this.emplHistDptoId = emplHistDptoId;
    }
}
