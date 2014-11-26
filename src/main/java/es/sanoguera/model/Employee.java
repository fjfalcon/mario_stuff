package es.sanoguera.model;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;

/**
 * Created by fjfalcon on 26.11.14.
 */
@Entity
@Table(name="empleados")

public class Employee
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String firstName;
    private String lastName;
    private String office;
    private String direction;
    private Date modifyDate;
    private BigDecimal salary;
    private BigDecimal comision;

    @ManyToOne()
    @JoinColumn(name="directionId")
    private Departament department;

    public Employee()
    {
    }

    public Employee(Long id, Departament department)
    {
        this.id = id;
        this.department = department;
    }

    public Employee(Long id, String firstName, String lastName, String office, String direction, Date modifyDate, BigDecimal salary, BigDecimal comision, Departament department)
    {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.office = office;
        this.direction = direction;
        this.modifyDate = modifyDate;
        this.salary = salary;
        this.comision = comision;
        this.department = department;
    }

    public Long getId()
    {
        return id;
    }

    public void setId(Long id)
    {
        this.id = id;
    }

    public String getFirstName()
    {
        return firstName;
    }

    public void setFirstName(String firstName)
    {
        this.firstName = firstName;
    }

    public String getLastName()
    {
        return lastName;
    }

    public void setLastName(String lastName)
    {
        this.lastName = lastName;
    }

    public String getOffice()
    {
        return office;
    }

    public void setOffice(String office)
    {
        this.office = office;
    }

    public String getDirection()
    {
        return direction;
    }

    public void setDirection(String direction)
    {
        this.direction = direction;
    }

    public Date getModifyDate()
    {
        return modifyDate;
    }

    public void setModifyDate(Date modifyDate)
    {
        this.modifyDate = modifyDate;
    }

    public BigDecimal getSalary()
    {
        return salary;
    }

    public void setSalary(BigDecimal salary)
    {
        this.salary = salary;
    }

    public BigDecimal getComision()
    {
        return comision;
    }

    public void setComision(BigDecimal comision)
    {
        this.comision = comision;
    }

    public Departament getDepartment()
    {
        return department;
    }

    public void setDepartment(Departament department)
    {
        this.department = department;
    }

    @Override
    public boolean equals(Object o)
    {
        if (this == o) return true;
        if (!(o instanceof Employee)) return false;

        Employee employee = (Employee) o;

        if (comision != null ? !comision.equals(employee.comision) : employee.comision != null) return false;
        if (department != null ? !department.equals(employee.department) : employee.department != null) return false;
        if (direction != null ? !direction.equals(employee.direction) : employee.direction != null) return false;
        if (firstName != null ? !firstName.equals(employee.firstName) : employee.firstName != null) return false;
        if (id != null ? !id.equals(employee.id) : employee.id != null) return false;
        if (lastName != null ? !lastName.equals(employee.lastName) : employee.lastName != null) return false;
        if (modifyDate != null ? !modifyDate.equals(employee.modifyDate) : employee.modifyDate != null) return false;
        if (office != null ? !office.equals(employee.office) : employee.office != null) return false;
        if (salary != null ? !salary.equals(employee.salary) : employee.salary != null) return false;

        return true;
    }

    @Override
    public int hashCode()
    {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (firstName != null ? firstName.hashCode() : 0);
        result = 31 * result + (lastName != null ? lastName.hashCode() : 0);
        result = 31 * result + (office != null ? office.hashCode() : 0);
        result = 31 * result + (direction != null ? direction.hashCode() : 0);
        result = 31 * result + (modifyDate != null ? modifyDate.hashCode() : 0);
        result = 31 * result + (salary != null ? salary.hashCode() : 0);
        result = 31 * result + (comision != null ? comision.hashCode() : 0);
        result = 31 * result + (department != null ? department.hashCode() : 0);
        return result;
    }

    @Override
    public String toString()
    {
        return "Employee{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", office='" + office + '\'' +
                ", direction='" + direction + '\'' +
                ", modifyDate=" + modifyDate +
                ", salary=" + salary +
                ", comision=" + comision +
                ", department=" + department +
                '}';
    }
}
