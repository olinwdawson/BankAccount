public class employee{
    private String employeeName;
    private double currentSalary;
    public employee(String employeeName, double currentSalary){
        this.employeeName = employeeName;
        this.currentSalary = currentSalary;
    }
    public String getName(){
        return employeeName;
    }
    public double getSalary(){
        return currentSalary;
    }
    public void raiseSalary(double byPercent){
        currentSalary = currentSalary*(1+byPercent*.01);
    }
}
