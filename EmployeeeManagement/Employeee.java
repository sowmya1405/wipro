package EmployeeeManagement;
class Employeee {
    int empNo;
    String empName;
    String joinDate;
    char desCode;
    String department;
    int basic;
    int hra;
    int it;

    Employeee(int empNo, String empName, String joinDate, char desCode,
             String department, int basic, int hra, int it) {

        this.empNo = empNo;
        this.empName = empName;
        this.joinDate = joinDate;
        this.desCode = desCode;
        this.department = department;
        this.basic = basic;
        this.hra = hra;
        this.it = it;
    }
}