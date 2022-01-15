package integration_tests;

import com.company.database.UserDatabase;
import com.company.factories.UserFactory;
import com.company.users.User;
import org.junit.Assert;
import org.junit.Test;

public class Integration_Test {

    @Test
    public void t_addUsersToDB() {
        UserFactory factory = new UserFactory();
        UserDatabase<User> udb = UserDatabase.getInstance();

        User u1 = factory.getUser("jésus","pw");
        udb.add(u1);

        Assert.assertEquals("UDB SIZE - should be 1", udb.size(), 1);


        User u2 = factory.getUser("John Cena", "    ");
        udb.add(u2);

        Assert.assertEquals("UDB SIZE - should be 2", udb.size(), 2);



    }

    @Test
    public void t_getUsersFromDB() {

    }
}
