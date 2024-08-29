package cn.debuged.abstractFactory;

import lombok.Data;

public class AbstractFactory {
    public static void main(String[] args) {
        User user = new User();
        // SqlserverUser sqlserverUser = new SqlserverUser();
        IFactory factory = new SqlServerFactory();
        IUser iu = factory.createUser();
        iu.insert(user);
        iu.getUser(1);
    }
}

@Data
class User {
    private int id;
    private String name;
}
interface IUser {
    void insert(User user);

    User getUser(int id);
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

class AccessUser implements IUser {
    public void insert(User user) {
        System.out.println("在AccessUser中给User表增加一条记录");
    }

    public User getUser(int id) {
        System.out.println("在AccessUser中根据ID得到User表的一条记录");
        return null;
    }
}


interface IFactory {
    public IUser createUser();
}
class SqlServerFactory implements IFactory {
    public IUser createUser() {
        return new SqlserverUser();
    }
}
class AccessFactory implements IFactory {
    public IUser createUser() {
        return new AccessUser();
    }
}