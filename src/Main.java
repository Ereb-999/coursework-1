public class Main {

    private static Employee[] employees = new Employee[10];
    public  static void printEmplouees(){
        for (Employee employee : employees) {
            System.out.println(employee);
        }
    }
    public static void increaserelay(int procent){
        for (Employee employee : employees) {
                int currentSeelary = employee.getSalary();
                employee.setSalary((int) (currentSeelary * (procent / 100f + 1)));
        }
    }

    public static Employee searchMinSalaryEmployeeByDepartament(int departament){
        int minSalary = Integer.MAX_VALUE;
        Employee result = null;
        for (Employee employee : employees) {
            if (employee.getDepartament() != departament){
                continue;
            }
            if (employee.getSalary() < minSalary){
                minSalary = employee.getSalary();
                result = employee;
            }
        }
        return result;
    }

    public static Employee searchMaxSalaryEmployeeByDepartament(int departament){
        int maxSalary = Integer.MIN_VALUE;
        Employee result = null;
        for (Employee employee : employees) {
            if (employee.getDepartament() != departament){
                continue;
            }
            if (employee.getSalary() > maxSalary){
                maxSalary = employee.getSalary();
                result = employee;
            }
        }
        return result;
    }


    public static int calculatorAmountEmployee(){
        int sum = 0;
        for(Employee employee : employees){
            if(employee != null){
                sum +=employee.getSalary();
            }
        }
        return sum;
    }

    public static float getAmountEmployeeByDepartament(int departament){
        int numbersCount = 0;
        int sum = 0;
        for(Employee employee : employees){
            if(employee != null && employee.getDepartament() == departament){
                sum +=employee.getSalary();
                numbersCount++;
            }
        }
        return sum/(float) numbersCount;
    }
    public static void increaseSalaryOfTeam(int pricent, int departament) {
        for (Employee employee : employees) {
            if (employee.getDepartament() == departament){
                int currentSalary = employee.getSalary();
                employee.setSalary((int) (currentSalary * (pricent /100f + 1)));
            }
        }
    }

    public static void printTeam(int teamNumber){
        for (Employee employee : employees){
            if (employee != null && employee.getDepartament() == teamNumber){
                System.out.println(employee.getId() + ". " + employee.getFIO() + ", зарплата " + employee.getSalary());
            }
        }
    }
    public static void printEmployeesHigherSalary(int salary){
        for (Employee employee:employees){
            if (employee != null && employee.getSalary() < salary){
                System.out.println(employee.getId() + ". " + employee.getFIO() + ": " + employee.getSalary());
            }
        }
    }

    public static void ptintLowerEmployeeSalary(int salary){
        for (Employee employee:employees){
            if (employee != null && employee.getSalary() >= salary){
                System.out.println(employee.getId() + ". " + employee.getFIO() + ": " + employee.getSalary());
            }
        }
    }

    public static Employee MinimumWageAtEmployee(){
        Employee resultEmployee = employees[0];
        int minSalary = resultEmployee.getSalary();
        for(Employee employee : employees) {
            if (employee != null && employee.getSalary() < minSalary) {
                minSalary = employee.getSalary();
                resultEmployee = employee;
            }
        }
        return resultEmployee;
    }
    public static Employee MaxWageAtEmployee(){
        Employee resultEmplyee = employees[0];
        int maxSalary = resultEmplyee.getSalary();
        for (Employee employee : employees) {
            if (employee != null && employee.getSalary() > maxSalary){
                maxSalary = employee.getSalary();
        resultEmplyee = employee;
            }
        }
        return  resultEmplyee;
    }
    public static float countingAverageSalary(){
        return (float) calculatorAmountEmployee() / MaxWageAtEmployee().getCount();
    }
    public static void printFullNames(){
        for (Employee employee : employees) {
            System.out.println(employee.getFIO());
        }
    }



    public static void main(String[] args) {
        employees = new Employee[]{
                new Employee("Чернышева Ульяна Максимовна", 4, 20000),
                new Employee("Хохлова Надежда Владиславовна",1, 30000),
                new Employee("Мартынов Платон Денисович",4, 19000),
                new Employee("Архипова Таисия Максимовна",5, 54200),
                new Employee("Дементьева Елизавета Алексеевна",2, 29000),
                new Employee("Молчанов Виктор Павлович",3, 12000),
                new Employee("Львов Никита Михайлович",2, 19900),
                new Employee("Поздняков Артём Алексеевич",1,  40000),
                new Employee("Львов Никита Михайлович", 3, 32000),
                new Employee("Носков Даниил Владимирович",3, 39000)

        };
        printEmplouees();
        System.out.println();
        printFullNames();
        System.out.println();
        MaxWageAtEmployee();
        MinimumWageAtEmployee();
        countingAverageSalary();
        increaserelay(14);
        increaseSalaryOfTeam(14, 2);
        getAmountEmployeeByDepartament(3);
        searchMaxSalaryEmployeeByDepartament(2);
        searchMinSalaryEmployeeByDepartament(4);
        printEmployeesHigherSalary(30_000);
        ptintLowerEmployeeSalary(20_000);
        printTeam(3);
        System.out.println("Средняя зароботная плата сотрудника: " + countingAverageSalary());
        System.out.println("Средняя зароботная плата сотрудника по отделу: " + getAmountEmployeeByDepartament(3));
        System.out.println("Общаяя сумма затрат на зарплаты: " + calculatorAmountEmployee());
        System.out.println("Сотрудник с наименьшей заработной платой: " +  MinimumWageAtEmployee());
        System.out.println("Сотрудник с наибольшей заработной платой: " + MaxWageAtEmployee());
        System.out.println("Сотрудник с минимальной зарплатой по отделу: " + searchMinSalaryEmployeeByDepartament(4));
        System.out.println("Сотрудник с максимальной зарплатой по отделу: " + searchMaxSalaryEmployeeByDepartament(2));


    }

}