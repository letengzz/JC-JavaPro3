package com.hjc.demo.pojo;

import java.util.List;

/**
 * 部门表
 * @author hjc
 */
public class Department {
    private Integer deptId;
    private String deptName;
    private String deptCity;

    private List<Employee> employee;

    public Department() {
    }

    public Department(Integer deptId, String deptName, String deptCity) {
        this.deptId = deptId;
        this.deptName = deptName;
        this.deptCity = deptCity;
    }

    public Integer getDeptId() {
        return deptId;
    }

    public void setDeptId(Integer deptId) {
        this.deptId = deptId;
    }

    public String getDeptName() {
        return deptName;
    }

    public void setDeptName(String deptName) {
        this.deptName = deptName;
    }

    public String getDeptCity() {
        return deptCity;
    }

    public void setDeptCity(String deptCity) {
        this.deptCity = deptCity;
    }

    @Override
    public String toString() {
        return "Department{" +
                "deptId=" + deptId +
                ", deptName='" + deptName + '\'' +
                ", deptCity='" + deptCity + '\'' +
                ", employee=" + employee +
                '}';
    }
}
