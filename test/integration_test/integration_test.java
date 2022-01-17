package integration_test;

import com.Model;
import com.database.TicketDatabase;
import com.database.UserDatabase;
import com.factories.UserFactory;
import com.tickets.EvenTicket;
import com.tickets.Ticket;
import com.tickets.UnevenTicket;
import com.users.User;
import org.junit.Assert;
import org.junit.Test;

public class integration_test {


    @Test
    public void t_addUsersToDB() {

        UserFactory factory = new UserFactory();
        UserDatabase<User> udb = UserDatabase.getInstance();
        udb.clear();

        User u1 = factory.getUser("jésus","pw");
        udb.add(u1);

        Assert.assertEquals("UDB SIZE - should be 1", udb.size(), 1);


        User u2 = factory.getUser("John Cena", "    ");
        udb.add(u2);

        Assert.assertEquals("UDB SIZE - should be 2", udb.size(), 2);

        Assert.assertTrue(udb.contains(u1));
        Assert.assertTrue(udb.contains(u2));

    }

    @Test
    public void t_removeUsersFromDB() {
        UserFactory factory = new UserFactory();
        UserDatabase<User> udb = UserDatabase.getInstance();
        udb.clear();

        User u1 = factory.getUser("jésus","pw");
        User u2 = factory.getUser("John Cena", "    ");

        udb.add(u1);

        Assert.assertEquals("UDB SIZE after adding user- should be 1",1 , udb.size());

        udb.add(u2);

        Assert.assertEquals("UDB SIZE - should be 2", udb.size(), 2);

        udb.remove(u2);

        Assert.assertTrue(udb.contains(u1));
        Assert.assertFalse("checking if user is removed from database",udb.contains(u2));

    }



    @Test
    public void t_addTicketsToDB() {
        TicketDatabase<Ticket> tdb = TicketDatabase.getInstance();
        tdb.clear();
        UserFactory factory = new UserFactory();
        User u1 = factory.getUser("jésus","pw");

        EvenTicket t1 = new EvenTicket(u1, 20, "cinema");
        tdb.addTicket(t1);
        Assert.assertEquals("size after adding eventicket - should be 1",tdb.size(), 1);
        Assert.assertTrue(tdb.contains(t1));

        UnevenTicket t2 = new UnevenTicket(u1, 20, "popcorn");
        tdb.addTicket(t2);
        Assert.assertEquals("size after adding uneventicket - should be 2",tdb.size(), 2);
        Assert.assertTrue(tdb.contains(t1));
    }

    @Test
    public void t_removeTicketsFromDB() {
        TicketDatabase<Ticket> tdb = TicketDatabase.getInstance();
        tdb.clear();

        UserFactory factory = new UserFactory();
        User u1 = factory.getUser("jésus","pw");

        EvenTicket t1 = new EvenTicket(u1, 20, "cinema");
        tdb.addTicket(t1);
        Assert.assertEquals("size after adding eventicket - should be 1",tdb.size(), 1);

        tdb.removeTicket(t1);
        Assert.assertFalse("testing removing ticket from db",tdb.contains(t1));

        Assert.assertEquals("size after removing eventicket - should be 0",tdb.size(), 0);

    }

    @Test
    public void t_calculateSplitEvenAndUneven() {
        UserFactory factory = new UserFactory();
        UserDatabase<User> udb = UserDatabase.getInstance();
        TicketDatabase<Ticket> tdb = TicketDatabase.getInstance();
        udb.clear();
        tdb.clear();


        User u1 = factory.getUser("jésus","pw");
        udb.add(u1);
        User u2 = factory.getUser("John Cena", "    ");
        udb.add(u2);
        User u3 = factory.getUser("padre", "tostrongforsecurity");
        udb.add(u3);


        EvenTicket t1 = new EvenTicket(u1, 30, "cinema");
        UnevenTicket t2 = new UnevenTicket(u1, 20, "popcorn");
        t2.addPayer(u2, 5.0);

        tdb.addTicket(t1);
        tdb.addTicket(t2);

        tdb.forEach(Ticket::calculateSplit);
        Assert.assertEquals("Testing balance after even and uneventicket - expected: 25",25,u1.getBalance(),0.001);

        Assert.assertEquals("Testing balance after even and uneventicket - expected: -15",-15.0,u2.getBalance(),0.001);

    }

    @Test
    public void t_calculateDebts() {
        Model model = new Model();
        UserFactory factory = new UserFactory();
        UserDatabase<User> udb = UserDatabase.getInstance();
        TicketDatabase<Ticket> tdb = TicketDatabase.getInstance();
        udb.clear();
        tdb.clear();

        User u1 = factory.getUser("jésus","pw");
        udb.add(u1);
        User u2 = factory.getUser("John Cena", "    ");
        udb.add(u2);
        User u3 = factory.getUser("padre", "tostrongforsecurity");
        udb.add(u3);


        EvenTicket t1 = new EvenTicket(u1, 30, "cinema");
        UnevenTicket t2 = new UnevenTicket(u1, 20, "popcorn");
        t2.addPayer(u2, 5.0);

        tdb.addTicket(t1);
        tdb.addTicket(t2);

        model.calculateTotal();

        Assert.assertArrayEquals("All balances should be 0 after settling",new double[] {0.0,0.0,0.0},
                new double [] {u1.getBalance(),u2.getBalance(),u3.getBalance()} ,0.001);


        Assert.assertEquals("This user should pay 15 to debt free user",15.0, u2.getAmountOwedTo(u1),0.001);
        Assert.assertEquals("This user should pay 10 to debt free user",10.0, u3.getAmountOwedTo(u1),0.001);


    }

    @Test
    public void t_calculateDebtsIsSimplified() {
        Model model = new Model();
        UserFactory factory = new UserFactory();
        UserDatabase<User> udb = UserDatabase.getInstance();
        TicketDatabase<Ticket> tdb = TicketDatabase.getInstance();
        udb.clear();
        tdb.clear();

        User u1 = factory.getUser("jésus","pw");
        udb.add(u1);
        User u2 = factory.getUser("John Cena", "    ");
        udb.add(u2);
        User u3 = factory.getUser("padre", "tostrongforsecurity");
        udb.add(u3);


        EvenTicket t1 = new EvenTicket(u1, 30, "cinema");
        UnevenTicket t2 = new UnevenTicket(u2, 20, "popcorn");
        t2.addPayer(u3, 5.0);

        tdb.addTicket(t1);
        tdb.addTicket(t2);

        model.calculateTotal();

        Assert.assertArrayEquals("All balances should be 0 after settling",new double[] {0.0,0.0,0.0},
                new double [] {u1.getBalance(),u2.getBalance(),u3.getBalance()} ,0.001);


        Assert.assertEquals("This user should pay 10 to debt free user",5.0, u2.getAmountOwedTo(u1),0.001);
        Assert.assertEquals("This user should pay 15 to debt free user",15.0, u3.getAmountOwedTo(u1),0.001);


    }





}
