package com.stefan.salaryapp.dto;

public class Salary {

    private String jobTitle;
    private String areaName;
    private String companyName;
    private String cityName;
    private String levelName;
    private String added;
    private String salary;

    public Salary(String jobTitle, String areaName, String companyName, String cityName, String levelName, String added, String salary) {
        this.jobTitle = jobTitle;
        this.areaName = areaName;
        this.companyName = companyName;
        this.cityName = cityName;
        this.levelName = levelName;
        this.added = added;
        this.salary = salary;
    }

    public String getJobTitle() {
        return jobTitle;
    }

    public void setJobTitle(String jobTitle) {
        this.jobTitle = jobTitle;
    }

    public String getAreaName() {
        return areaName;
    }

    public void setAreaName(String areaName) {
        this.areaName = areaName;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public String getCityName() {
        return cityName;
    }

    public void setCityName(String cityName) {
        this.cityName = cityName;
    }

    public String getLevelName() {
        return levelName;
    }

    public void setLevelName(String levelName) {
        this.levelName = levelName;
    }

    public String getAdded() {
        return added;
    }

    public void setAdded(String added) {
        this.added = added;
    }

    public String getSalary() {
        return salary;
    }

    public void setSalary(String salary) {
        this.salary = salary;
    }
}
