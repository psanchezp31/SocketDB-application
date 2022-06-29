package co.edu.poli.socketdb.handler;

import co.edu.poli.socketdb.business.EmployeeService;
import co.edu.poli.socketdb.dto.EmployeeDto;
import co.edu.poli.socketdb.util.JsonUtil;

/**
 * This class receive the action and the string-json input, and depending on the action it calls a method in order
 * to obtain a feedback from the server.
 * Uses Singleton pattern because uses just one instance of the CommandHandler, to use this instance in other parts
 * of the code.
 *
 * @autor Paula Sanchez
 * @autor Diana Neira
 * @autor Ramon Barrios
 * @autor Andres Triana
 */

public class CommandHandler {

    private static final CommandHandler INSTANCE = new CommandHandler();
    private JsonUtil jsonUtil;
    private EmployeeService employeeService;

    private CommandHandler() {
        this.employeeService = EmployeeService.getInstance();
        this.jsonUtil = JsonUtil.getInstance();
    }

    /**
     * Implementation of Singleton pattern, it returns an instance of this class itself.
     *
     * @return CommandHandler
     */
    public static CommandHandler getInstance() {
        return INSTANCE;
    }

    public String processCommand(String command) {
        String[] commandSplit = command.split(" ", 2);
        String actionString = commandSplit[0];
        String jsonString = commandSplit[1];
        ActionEnum action = ActionEnum.valueOf(actionString.toUpperCase());
        EmployeeDto dto = jsonUtil.mapToDto(jsonString);

        String feedback = "";

        switch (action) {
            case INSERT:
                feedback = doCreate(dto);
                break;
            case UPDATE:
                feedback = doUpdate(dto);
                break;
            case SELECT:
                feedback = doRead(dto);
                break;
            case DELETE:
                feedback = doDelete(dto);
                break;
        }

        return feedback;
    }

    private String doCreate(EmployeeDto dto) {
        try {
            employeeService.create(dto);
            return "User inserted.";
        } catch (RuntimeException e) {
            return "User not inserted: " + e.getMessage();
        }
    }

    private String doUpdate(EmployeeDto dto) {
        try {
            boolean result = employeeService.update(dto);
            return result ? "User updated." : "User was not updated.";
        } catch (RuntimeException e) {
            return "User not updated: " + e.getMessage();
        }
    }

    private String doRead(EmployeeDto dto) {
        EmployeeDto output = employeeService.read(dto);
        if (output != null) {
            String json = JsonUtil.getInstance().mapToString(output);
            return "User found: " + json;
        } else {
            return "User not found, please try again.";
        }
    }

    private String doDelete(EmployeeDto dto) {
        try {
            boolean result = employeeService.deleteEmployee(dto);
            return result ? "User deleted." : "User was not deleted.";
        } catch (RuntimeException e) {
            return "User not deleted: " + e.getMessage();
        }
    }
}
