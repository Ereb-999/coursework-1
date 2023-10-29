import java.util.Objects;

public class Employee {
    private final String FIO;
    private int departament;
    private int salary;
    private static int count = 0;
    private final int id;

    public Employee(String FIO, int departament, int salary){

        this.FIO = FIO;
        this.salary = salary;
        this.departament = departament;
        id = ++count;
    }

    public String getFIO(){return this.FIO;}
    public  int getDepartament(){return this.departament;}
    public int getSalary(){
        return this.salary;
    }
    public int getId() {return id;}
    public int getCount(){return count;}

    public void setDepartament(int departament){this.departament = departament;}
    public void setSalary(int salary){this.salary = salary;}

    @Override
    public String toString(){
        return
                "Ф.И.О.: " + FIO +
                ". Отдел: " + departament +
                ". Зарплата сотрудника: " + salary;
    }

    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || this.getClass() != obj.getClass()) return false;
        Employee employee = (Employee) obj;
        return Objects.equals(FIO, employee.FIO) && Objects.equals(departament, employee.departament) && Objects.equals(salary, employee.salary);
    }

    @Override
    public int hashCode() {
        return Objects.hash(FIO, id, departament, salary);
    }

    private  int numberDepartament(int departament){return  departament < 1 || departament > 5 ? 1 : departament;
    }
}
