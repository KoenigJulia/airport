package at.htl.api;

import at.htl.workloads.employee.Employee;
import at.htl.workloads.employee.EmployeeRepository;

import javax.transaction.Transactional;
import javax.ws.rs.*;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;

@Path("employee")
public class EmployeeResource {
    private final EmployeeRepository employeeRepository;

    public EmployeeResource(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    @GET
    @Path("all")
    public Response getAllEmployees() {
        var allEmployees = this.employeeRepository.getAll();
        return Response.ok(allEmployees).build();
    }

    @GET
    @Path("{id}")
    public Response get(@PathParam("id") Long id) {
        Employee employee = this.employeeRepository.getEmployee(id);
        return (employee == null
                ? Response.status(404)
                : Response.ok(employee))
                .build();
    }

    @POST
    @Transactional
    @Path("addEmployee")
    public Response addEmployee(Employee newEmployee, @Context UriInfo uriInfo){
        this.employeeRepository.add(newEmployee);
        return Response.ok(newEmployee).build();
    }

    @DELETE
    @Path("{id}")
    @Transactional
    public Response removeEmployee(@PathParam("id") Long id){
        Employee employee = this.employeeRepository.removeEmployee(id);
        return (employee == null
                ? Response.status(404)
                : Response.ok(employee))
                .build();
    }

}
