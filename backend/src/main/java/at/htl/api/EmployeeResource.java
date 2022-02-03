package at.htl.api;

import at.htl.workloads.employee.Employee;
import at.htl.workloads.employee.EmployeeRepository;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.Response;

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
}
