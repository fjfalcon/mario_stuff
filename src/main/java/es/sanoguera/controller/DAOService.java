package es.sanoguera.controller;

import es.sanoguera.dao.HibernateDAO;
import es.sanoguera.model.Departament;
import es.sanoguera.model.Employee;

/**
 * Created by fjfalcon on 26.11.14.
 */
public class DAOService
{
    private static volatile DAOService instance;
    private static HibernateDAO<Employee,Long> employeeDAO = new HibernateDAO<Employee, Long>(Employee.class);
    private static HibernateDAO<Departament,Long> departmentDAO = new HibernateDAO<Departament, Long>(Departament.class);


    public static DAOService getInstance() {
        DAOService localInstance = instance;
        if (localInstance == null) {
            synchronized (DAOService.class) {
                localInstance = instance;
                if (localInstance == null) {
                    instance = localInstance = new DAOService();
                }
            }
        }
        return localInstance;
    }

    public static HibernateDAO<Employee, Long> getEmployeeDAO()
    {
        return employeeDAO;
    }

    public static void setEmployeeDAO(HibernateDAO<Employee, Long> employeeDAO)
    {
        DAOService.employeeDAO = employeeDAO;
    }

    public static HibernateDAO<Departament, Long> getDepartmentDAO()
    {
        return departmentDAO;
    }

    public static void setDepartmentDAO(HibernateDAO<Departament, Long> departmentDAO)
    {
        DAOService.departmentDAO = departmentDAO;
    }
}
