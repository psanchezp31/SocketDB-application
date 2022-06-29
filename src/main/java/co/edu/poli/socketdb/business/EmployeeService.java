package co.edu.poli.socketdb.business;

import co.edu.poli.socketdb.dao.EmployeeDao;
import co.edu.poli.socketdb.dto.EmployeeDto;

/**
 * This class is in charge of calling EmployeeDao methods and passing EmployeeDto object to it
 * Uses Singleton pattern because uses just one instance of the EmployeeService, to use this instance in other parts of the code.
 *
 * @autor Paula Sanchez
 * @autor Diana Neira
 * @autor Ramon Barrios
 * @autor Andres Triana
 */

public class EmployeeService {

    private static final EmployeeService INSTANCE = new EmployeeService();
    private EmployeeDao employeeDao;

    private EmployeeService() {
        this.employeeDao = EmployeeDao.getInstance();
    }

    /**
     * Implementation of Singleton pattern, it returns an instance of this class itself.
     *
     * @return EmployeeService
     */
    public static EmployeeService getInstance() {
        return INSTANCE;
    }

    public void create(EmployeeDto employeeDto) {
        employeeDao.create(employeeDto);
    }

    public boolean update(EmployeeDto employeeDto) {
        return employeeDao.update(employeeDto);
    }

    public EmployeeDto read(EmployeeDto employeeDto) {
        return employeeDao.read(employeeDto.getEmplId());
    }

    public boolean deleteEmployee(EmployeeDto employeeDto) {
        return employeeDao.passiveDelete(employeeDto.getEmplId());
    }

}
