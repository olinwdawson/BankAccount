public class employeeTester {
        public static void main(String[] args) {
            employee craig = new employee("Craig Johnson",50);
            System.out.println("Name: " + craig.getName());
            System.out.println("Salary: " + craig.getSalary());
            craig.raiseSalary(50); //raise
            System.out.println("Post Raise Salary: " + craig.getSalary());
        }
}
