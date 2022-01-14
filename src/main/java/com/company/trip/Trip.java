package com.company.trip;

public class Trip {
    //atributs
    private static Trip tripObject;
    //private UserDb users;
    //private TicketDb tickets;
    //private 

    public static Trip getInstance() //om het singleton object op te roepen
    {
        if ( tripObject==null)
        {
            tripObject=new Trip();
        }
        return tripObject;
    }

    public void addUser(String name)
    {
        //users.add(name);
    }

    public void removeUser(String name)
    {
        //users.remove()
    }

    public void addTicket()
    {
        //laat verschillende factories, verschillende tickets maken
        //tickets.add(type,payer,)
    }
}
