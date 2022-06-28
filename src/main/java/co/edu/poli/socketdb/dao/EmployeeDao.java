package co.edu.poli.socketdb.dao;

import co.edu.poli.socketdb.dto.EmployeeDto;
import co.edu.poli.socketdb.util.DbUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class EmployeeDao {

    private static final EmployeeDao instance = new EmployeeDao();
    private Connection connection;

    private EmployeeDao() {
        this.connection = DbUtil.getInstance().getConnection();
    }

    public static EmployeeDao getInstance() {
        return instance;
    }

    /**
     * Never Used. passiveDelete is encouraged.
     *
     * @param id
     * @return
     */
    public boolean delete(Integer id) {
        String sql = "DELETE FROM datos.empleado WHERE empl_id = ?";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setInt(1, id);
            int rowsDeleted = statement.executeUpdate();
            connection.commit();
            return rowsDeleted > 0;
        } catch (SQLException e) {
            throw new RuntimeException(e.getMessage());
        }
    }

    public boolean passiveDelete(Integer id) {
        String sql = "UPDATE datos.empleado SET " +
                "empl_activo = ? " +
                "WHERE empl_id = ? and empl_activo = ?";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setInt(1, 0);
            statement.setInt(2, id);
            statement.setInt(3, 1);
            int rowsUpdated = statement.executeUpdate();
            connection.commit();
            return rowsUpdated > 0;
        } catch (SQLException e) {
            throw new RuntimeException(e.getMessage());
        }
    }

    public boolean update(EmployeeDto dto) {
        String sql = "UPDATE datos.empleado SET " +
                "empl_primer_nombre=?, " +
                "empl_segundo_nombre=?, " +
                "empl_apellidos=?, " +
                "empl_email=?, " +
                "empl_fecha_nac=?, " +
                "empl_sueldo=?, " +
                "empl_comision=?, " +
                "empl_cargo_id=?, " +
                "empl_gerente_id=?, " +
                "empl_dpto_id=?, " +
                "empl_activo=? " +
                "WHERE empl_id=?";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setString(1, dto.getEmplPrimerNombre());
            statement.setString(2, dto.getEmplSegundoNombre());
            statement.setString(3, dto.getEmplApellidos());
            statement.setString(4, dto.getEmplEmail());
            statement.setDate(5, new java.sql.Date(dto.getEmplFechaNac().getTime()));
            statement.setInt(6, dto.getEmplSueldo());
            statement.setInt(7, dto.getEmplComision());
            statement.setInt(8, dto.getEmplCargoId());
            statement.setInt(9, dto.getEmplGerenteId());
            statement.setInt(10, dto.getEmplDptoId());
            statement.setInt(11, dto.getEmplActivo());
            statement.setInt(12, dto.getEmplId());
            int rowsUpdated = statement.executeUpdate();
            connection.commit();
            return rowsUpdated > 0;
        } catch (SQLException e) {
            throw new RuntimeException(e.getMessage());
        }
    }

    public void create(EmployeeDto dto) {
        String sql = "INSERT INTO datos.empleado " +
                "(empl_id," +
                "empl_primer_nombre, " +
                "empl_segundo_nombre, " +
                "empl_apellidos, " +
                "empl_email, " +
                "empl_fecha_nac, " +
                "empl_sueldo, " +
                "empl_comision, " +
                "empl_cargo_id, " +
                "empl_gerente_id, " +
                "empl_dpto_id, " +
                "empl_activo) " +
                "VALUES (?,?,?,?,?,?,?,?,?,?,?,?)";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setInt(1, dto.getEmplId());
            statement.setString(2, dto.getEmplPrimerNombre());
            statement.setString(3, dto.getEmplSegundoNombre());
            statement.setString(4, dto.getEmplApellidos());
            statement.setString(5, dto.getEmplEmail());
            statement.setDate(6, new java.sql.Date(dto.getEmplFechaNac().getTime()));
            statement.setInt(7, dto.getEmplSueldo());
            statement.setInt(8, dto.getEmplComision());
            statement.setInt(9, dto.getEmplCargoId());
            statement.setInt(10, dto.getEmplGerenteId());
            statement.setInt(11, dto.getEmplDptoId());
            statement.setInt(12, dto.getEmplActivo());
            statement.executeUpdate();
            connection.commit();
        } catch (SQLException e) {
            throw new RuntimeException(e.getMessage());
        }
    }

    public EmployeeDto read(Integer id) {
        EmployeeDto dto = null;
        String sql = "SELECT * FROM datos.empleado where empl_id = ?";

        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setInt(1, id);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                dto = new EmployeeDto();
                dto.setEmplId(id);
                dto.setEmplPrimerNombre(resultSet.getString("empl_primer_nombre"));
                dto.setEmplSegundoNombre(resultSet.getString("empl_segundo_nombre"));
                dto.setEmplApellidos(resultSet.getString("empl_apellidos"));
                dto.setEmplEmail(resultSet.getString("empl_email"));
                dto.setEmplFechaNac(resultSet.getDate("empl_fecha_nac"));
                dto.setEmplSueldo(resultSet.getInt("empl_sueldo"));
                dto.setEmplComision(resultSet.getInt("empl_comision"));
                dto.setEmplCargoId(resultSet.getInt("empl_cargo_id"));
                dto.setEmplGerenteId(resultSet.getInt("empl_gerente_id"));
                dto.setEmplDptoId(resultSet.getInt("empl_dpto_id"));
                dto.setEmplActivo(resultSet.getInt("empl_activo"));
            }
            return dto;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

}

