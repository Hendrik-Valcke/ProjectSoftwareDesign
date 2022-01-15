package com.company;

import com.company.database.TicketDatabase;
import com.company.database.UserDatabase;
import com.company.factories.UserFactory;
import com.company.tickets.Ticket;
import com.company.users.User;

import static java.lang.Math.abs;


public class Model {
    //private TicketDatabase ticketDB;
    //private UserDatabase userDB;
    private UserFactory uFactory;

    public Model() {
        uFactory = new UserFactory();
    }

    public void addUserToDB(String name, String pw)
    {
        User u = uFactory.getUser(name, pw);
        UserDatabase.getInstance().add(u);
    }

    public void calculateTotal() {
        // set all balances
        TicketDatabase.getInstance().forEach(Ticket::calculateSplit);

        for (User user : UserDatabase.getInstance()) {
            if (user.getBalance() > 0.001) {
                settleUser(user);
            }
        }
    }

    private void settleUser(User user) {
        for (User obj : UserDatabase.getInstance()) {
            // obj user is in debt, use his negative balance to lower positive balance
            if(obj.isInDebt() && ( (obj.getBalance() + user.getBalance()) >=0) ) {
                obj.owesTo(user, abs(obj.getBalance()));
                user.addSaldo(obj.getBalance());
                obj.setBalance(0);

            // obj user is in debt, but using his entire negative balance to settle up would put the positive balance user
            // in debt
            } else if(obj.isInDebt() && ( (obj.getBalance() + user.getBalance()) < 0 ) ) {

                obj.addSaldo(user.getBalance());
                obj.owesTo(user, user.getBalance());
                user.setBalance(0);
                break;
            }
        }
    }

    public void printDebts() {
        for (User obj : UserDatabase.getInstance()) {
            obj.printDebt();
        }
    }

    public boolean checkLogin(String name, String password)
    {
        boolean loginSuccess = false;
        for (User user : UserDatabase.getInstance()) {
            if (user.getName().equals(name) && user.getPassWord().equals(password)) {
                loginSuccess = true;
                break;
            }
        }
        return loginSuccess;
    }
}
