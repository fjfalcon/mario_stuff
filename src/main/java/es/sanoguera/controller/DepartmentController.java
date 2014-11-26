package es.sanoguera.controller;

import es.sanoguera.model.Departament;

import java.util.Scanner;

/**
 * Created by fjfalcon on 26.11.14.
 */
public class DepartmentController
{
    Scanner in;
    public DepartmentController(Scanner in)
    {
        this.in = in;
    }

    public void create() throws Exception
    {
        System.out.println("Introduzca IdDepartamento que deseas crear:");
        Long id = in.nextLong();

        Departament dep = DAOService.getDepartmentDAO().read(id);
        if ( dep != null )
            System.out.println("Already have one with dat id");

    }
}
