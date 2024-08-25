package cn.debuged.prototype;

public class Demo {
    public static void main(String[] args) {
        Resume resume1 = new Resume("大鸟");
        resume1.setPersonalInfo("男", "29");
        resume1.setWorkExperience("1998-2000", "XX公司");
        Resume resume2 = resume1.clone();
        resume2.setWorkExperience("2000-2002", "YY集团");

        Resume resume3 = resume1.clone();
        resume3.setWorkExperience("2002-2004", "ZZ公司");
        resume3.setPersonalInfo("女","18");
        // 对象模式的浅拷贝 对象属性没有拷贝
        resume1.display();
        resume2.display();
        resume3.display();
    }
}

// 工作经理类
class WorkExperience implements Cloneable{
    private String timeArea;

    public String getTimeArea() {
        return timeArea;
    }

    public void setTimeArea(String timeArea) {
        this.timeArea = timeArea;
    }

    private String company;

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    @Override
    public WorkExperience clone() {
        try {
            // TODO: 复制此处的可变状态，这样此克隆就不能更改初始克隆的内部项
            return (WorkExperience) super.clone();
        } catch (CloneNotSupportedException e) {
            throw new AssertionError();
        }
    }
}

// 简历类
class Resume implements Cloneable {
    private String name;
    private String sex;
    private String age;
    private WorkExperience workExperience;

    public Resume(String name) {
        this.name = name;
        this.workExperience = new WorkExperience();
    }

    public void setPersonalInfo(String sex, String age) {
        this.sex = sex;
        this.age = age;
    }

    public void setWorkExperience(String timeArea, String company) {
        this.workExperience.setTimeArea(timeArea);
        this.workExperience.setCompany(company);
    }

    public void display() {
        System.out.println(this.name + " " + this.sex + " " + this.age);
        System.out.println("工作经历：" + this.workExperience.getTimeArea() + " " + this.workExperience.getCompany());
    }

    public Resume clone() {
        Resume obj = null;
        try {
            obj = (Resume) super.clone();
            obj.workExperience = this.workExperience.clone();
        } catch (CloneNotSupportedException e) {
            System.err.println("不支持复制！");
        }
        return obj;
    }
}
