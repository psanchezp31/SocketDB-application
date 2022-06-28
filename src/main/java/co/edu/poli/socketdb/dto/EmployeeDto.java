package co.edu.poli.socketdb.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Date;

public class EmployeeDto {

    @JsonProperty("empl_id")
    private Integer emplId;
    @JsonProperty("empl_primer_nombre")
    private String emplPrimerNombre;
    @JsonProperty("empl_segundo_nombre")
    private String emplSegundoNombre;
    @JsonProperty("empl_apellidos")
    private String emplApellidos;
    @JsonProperty("empl_email")
    private String emplEmail;
    @JsonProperty("emp_fecha_nac")
    @JsonFormat
            (shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    private Date emplFechaNac;
    @JsonProperty("empl_sueldo")
    private Integer emplSueldo;
    @JsonProperty("empl_comision")
    private Integer emplComision;
    @JsonProperty("empl_cargo_id")
    private Integer emplCargoId;
    @JsonProperty("empl_gerente_id")
    private Integer emplGerenteId;
    @JsonProperty("empl_dpto_id")
    private Integer emplDptoId;
    @JsonProperty("empl_activo")
    private Integer emplActivo;

    public Integer getEmplId() {
        return emplId;
    }

    public void setEmplId(Integer emplId) {
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

    public Date getEmplFechaNac() {
        return emplFechaNac;
    }

    public void setEmplFechaNac(Date emplFechaNac) {
        this.emplFechaNac = emplFechaNac;
    }

    public Integer getEmplSueldo() {
        return emplSueldo;
    }

    public void setEmplSueldo(Integer emplSueldo) {
        this.emplSueldo = emplSueldo;
    }

    public Integer getEmplComision() {
        return emplComision;
    }

    public void setEmplComision(Integer emplComision) {
        this.emplComision = emplComision;
    }

    public Integer getEmplCargoId() {
        return emplCargoId;
    }

    public void setEmplCargoId(Integer emplCargoId) {
        this.emplCargoId = emplCargoId;
    }

    public Integer getEmplGerenteId() {
        return emplGerenteId;
    }

    public void setEmplGerenteId(Integer emplGerenteId) {
        this.emplGerenteId = emplGerenteId;
    }

    public Integer getEmplDptoId() {
        return emplDptoId;
    }

    public void setEmplDptoId(Integer emplDptoId) {
        this.emplDptoId = emplDptoId;
    }

    public Integer getEmplActivo() {
        return emplActivo;
    }

    public void setEmplActivo(Integer emplActivo) {
        this.emplActivo = emplActivo;
    }
}
