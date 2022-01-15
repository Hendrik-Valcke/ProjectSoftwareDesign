package unit_tests;

import com.company.database.UserDatabase;
import com.company.tickets.EvenTicket;
import com.company.tickets.Ticket;
import com.company.users.User;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class EvenTicket_UTest {
    public EvenTicket_UTest() {
    }

    @Before
    public void initialize() {

    }

    @Test
    public void t_getCreator() {
        User user =new User();
        EvenTicket evenTicketUnderTest = new EvenTicket(user, 10.5, "event0");

        Assert.assertEquals("Testing creator - input="+ user + " - should be " +user, user, evenTicketUnderTest.getCreator());


    }

    @Test
    public void t_getAmountPayed() {
        User user =new User();
        EvenTicket evenTicketUnderTest = new EvenTicket(user, 10.5, "event0");

        Assert.assertEquals("Testing amount payed - input=10- should be 10", 10.5, evenTicketUnderTest.getAmountPayed(), 0.0001);

    }

    @Test
    public void t_getEvent() {
        User user = new User();
        EvenTicket evenTicketUnderTest = new EvenTicket(user, 10, "event0");

        Assert.assertEquals("Testing naming - input=event0 - should be event0", "event0", evenTicketUnderTest.getEvent());
    }


    @Test
    public void t_testSplitCalc() {
        User u1 = new User("bert", "pw");
        User u2 = new User("mohammed", "zjnoen");
        User u3 = new User("Catalina", "senorita");

        UserDatabase<User> db = UserDatabase.getInstance();
        db.add(u1);
        db.add(u2);
        db.add(u3);

        Ticket t1 = new EvenTicket(u1,36,"botanische tuinen" );
        t1.calculateSplit();
        Assert.assertEquals("Testing splitcalculation -indebted user, should be 24", 24, u1.getBalance(), 0.001);

        Assert.assertEquals("Testing splitcalculation -user in debt, should be -12", -12.0, u2.getBalance(), 0.001);

    }
}
