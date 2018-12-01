package da.Temp;

import da.Config.Database;
import da.Model.User;

public class UserTest {
    public static void main(String args[]) {
        User user = Database.getUserMapper().getById(1);
        System.out.println(user);

        user.setAdmin(true);
        int k = Database.getUserMapper().update(user);
        System.out.println(k);
        user=Database.getUserMapper().getById(k);
        System.out.println(user);


//        User newUser=new User();
//        newUser.setName("New User");
//        newUser.setPassword("passwd");
//        newUser.setAdmin(true);
//        Database.getUserMapper().add(newUser);
    }
}
