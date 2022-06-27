package co.edu.poli.dto;

import java.time.LocalDate;
public class EmpleadoDto {

    private int emplId; //usar int o byte?
    private String emplPrimerNombre; //usar el mismito nombre de la tabla?
    private String emplSegundoNombre;
    private String emplApellidos;
    private String emplEmail;
    private LocalDate emplFechaNacimiento; //date o localdate?
    private int emplSueldo;
    private int emplComision;
    private int emplCargoId;
    private int emplGerenteId;
    private int emplDptoId;

    public int getEmplId() {
        return emplId;
    }

    public void setEmplId(int emplId) {
        this.emplId = emplId;
    }

    public String getEmplPrimerNombre() {
        return emplPrimerNombre;
    }

    public void setEmplPrimerNombre(String emplPrimerNombre) {
        this.emplPrimerNombre = emplPrimerNombre;
    }

    public String getEmplSegundoNombre() {
        return emplSegundoNombre;
    }

    public void setEmplSegundoNombre(String emplSegundoNombre) {
        this.emplSegundoNombre = emplSegundoNombre;
    }

    public String getEmplApellidos() {
        return emplApellidos;
    }

    public void setEmplApellidos(String emplApellidos) {
        this.emplApellidos = emplApellidos;
    }

    public String getEmplEmail() {
        return emplEmail;
    }

    public void setEmplEmail(String emplEmail) {
        this.emplEmail = emplEmail;
    }

    public LocalDate getEmplFechaNacimiento() {
        return emplFechaNacimiento;
    }

    public void setEmplFechaNacimiento(LocalDate emplFechaNacimiento) {
        this.emplFechaNacimiento = emplFechaNacimiento;
    }

    public int getEmplSueldo() {
        return emplSueldo;
    }

    public void setEmplSueldo(int emplSueldo) {
        this.emplSueldo = emplSueldo;
    }

    public int getEmplComision() {
        return emplComision;
    }

    public void setEmplComision(int emplComision) {
        this.emplComision = emplComision;
    }

    public int getEmplCargoId() {
        return emplCargoId;
    }

    public void setEmplCargoId(int emplCargoId) {
        this.emplCargoId = emplCargoId;
    }

    public int getEmplGerenteId() {
        return emplGerenteId;
    }

    public void setEmplGerenteId(int emplGerenteId) {
        this.emplGerenteId = emplGerenteId;
    }

    public int getEmplDptoId() {
        return emplDptoId;
    }

    public void setEmplDptoId(int emplDptoId) {
        this.emplDptoId = emplDptoId;
    }
}
