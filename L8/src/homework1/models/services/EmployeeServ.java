package homework1.models.services;

import homework1.models.entities.EmployeeEnti;
import homework1.models.repositories.EmployeeRepo;

/**
 * Created by Peyman RM
 */
public class EmployeeServ {
    private EmployeeServ() {}
    private static EmployeeServ employeeServ = new EmployeeServ();
    public static EmployeeServ getInstance(){
        return employeeServ;
    }

    public void save(EmployeeEnti employee) throws Exception {
        EmployeeRepo employeeRepo = new EmployeeRepo();
        employeeRepo.insertEmployee(employee);
        employeeRepo.commit();
        employeeRepo.close();
    }
}
