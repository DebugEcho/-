package cn.debuged.abstractFactory;

import lombok.Data;

public class AbstractFactory {
    public static void main(String[] args) {
        User user = new User();
        Department department = new Department();
        // SqlserverUser sqlserverUser = new SqlserverUser();

        IUser iu = DataAccess.createUser();
        iu.insert(user);
        iu.getUser(1);
        IDepartment idep = DataAccess.createDepartment();
        idep.insert(department);
        idep.getDepartment(1);
    }
}

@Data
class User {
    private int id;
    private String name;
}

@Data
class Department {
    private int id;
    private String name;
}

interface IUser {
    void insert(User user);

    User getUser(int id);
}

interface IDepartment {
    void insert(Department department);

    Department getDepartment(int id);
}

class SqlserverUser implements IUser {
    public void insert(User user) {
        System.out.println("在SQL Server中给User表增加一条记录");
    }

    public User getUser(int id) {
        System.out.println("在SQL Server中根据ID得到User表的一条记录");
        return null;
    }
}

class SqlserverDepartment implements IDepartment {
    public void insert(Department department) {
        System.out.println("在Access中给Department表增加一条记录");
    }

    public Department getDepartment(int id) {
        System.out.println("在Access中根据ID得到Department表的一条记录");
        return null;
    }
}


class AccessUser implements IUser {
    public void insert(User user) {
        System.out.println("在AccessUser中给User表增加一条记录");
    }

    public User getUser(int id) {
        System.out.println("在AccessUser中根据ID得到User表的一条记录");
        return null;
    }
}

class AccessDepartment implements IDepartment {
    public void insert(Department department) {
        System.out.println("在Access中给Department表增加一条记录");
    }

    public Department getDepartment(int id) {
        System.out.println("在Access中根据ID得到Department表的一条记录");
        return null;
    }
}

interface IFactory {
    public IUser createUser();

    public IDepartment createDepartment();
}

class SqlServerFactory implements IFactory {
    public IUser createUser() {
        return new SqlserverUser();
    }

    @Override
    public IDepartment createDepartment() {
        return new SqlserverDepartment();
    }
}

class AccessFactory implements IFactory {
    public IUser createUser() {
        return new AccessUser();
    }

    @Override
    public IDepartment createDepartment() {
        return new AccessDepartment();
    }
}
class DataAccess{
    private static String db = "SqlServer";
    static IUser createUser(){
        IUser result = null;
        switch (db){
            case "SqlServer":
                result = new SqlserverUser();
                break;
            case "Access":
                result = new AccessUser();
                break;
            default:
                break;
        }
        return result;
    }
    static IDepartment createDepartment(){
        IDepartment result = null;
        switch (db){
            case "SqlServer":
                result = new SqlserverDepartment();
                break;
            case "Access":
                result = new AccessDepartment();
                break;
            default:
                break;
        }
        return result;
    }
}