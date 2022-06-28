package co.edu.poli.socketdb.business;

import co.edu.poli.socketdb.dao.EmployeeDao;
import co.edu.poli.socketdb.dto.EmployeeDto;

public class EmployeeService {

    private static final EmployeeService INSTANCE = new EmployeeService();
    private EmployeeDao employeeDao;

    private EmployeeService() {
        this.employeeDao = EmployeeDao.getInstance();
    }

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
