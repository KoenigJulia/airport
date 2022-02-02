package at.htl.workloads.employee;

import at.htl.workloads.airplane.Airplane;

import javax.enterprise.context.ApplicationScoped;
import javax.persistence.EntityManager;
import javax.transaction.Transactional;
import java.util.List;

@ApplicationScoped
public class EmployeeRepository {
    public final EntityManager em;

    public EmployeeRepository(EntityManager em) {
        this.em = em;
    }

    public void add(Employee employee) {
        this.em.persist(employee);
    }

    public void update(Employee employee) {
        this.em.merge(employee);
    }

    public Employee getEmployee(Long id) {
        var query = this.em
                .createQuery("select e from Employee e where e.id = :id", Employee.class)
                .setParameter("id", id);

        return query.getResultList().stream()
                .findFirst().orElse(null);
    }

    public List<Employee> getAll() {
        return this.em
                .createQuery("select e from Employee e", Employee.class)
                .getResultList();
    }

    public Employee deleteEmployee(Long id){
        Employee employee = this.em.find(Employee.class,id);
        this.em.remove(employee);
        return employee;
    }
}
