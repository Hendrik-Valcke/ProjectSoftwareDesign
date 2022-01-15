package com.company;

import com.company.GUI.Window;
import com.company.database.TicketDatabase;
import com.company.database.UserDatabase;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Controller {
    private Window view;
    private Model model;
    private String returnScreen="start";


    public Controller(Model model, Window view) {
        this.view = view;
        this.model = model;
    }
    //methods to interact with UI (view)
    //basically all buttons call a function of the controller
    public void go2Start()
    {
        System.out.println("controller:start");
        //if there are no users, show a grayed out loginbutton
        view.showStartScreen(UserDatabase.getInstance().size() != 0, new Go2CreateUserListener(), new Go2LoginListener());
        view.setVisible(true);
    }
    public void go2CreateUser()
    {
        view.showCreateUserScreen(new Return2ScreenListener(),new SaveUserListener());
        view.setVisible(true);
    }
    public void go2Login()
    {
        //triggered when the user presses 'login'in startscreen or 'change user' in homescreen
        //the user will enter info and press the login button
        view.showLoginScreen(new Return2ScreenListener(),new LoginListener());
        view.setVisible(true);

    }
    public void go2Home()
    {
        returnScreen="home";
        view.showHomeScreen(new Go2StartListener(),new Go2CreateEvenTicketListener(),new Go2CreateSpecialTicketListener(),new CalcListener(), new Go2CreateUserListener(), new Go2RemoveUserListener(), getTicketContents(),getUsernames());
        view.setVisible(true);
    }
    private void go2RemoveUser() {
        view.showRemoveUserScreen(new Return2ScreenListener(),new RemoveUserListener(),getUsernames());
        view.setVisible(true);
    }



    //listeners:
    class Go2CreateUserListener implements ActionListener //go to create user screen
    {
        @Override
        public void actionPerformed(ActionEvent actionEvent) {
            go2CreateUser();
        }
    }
    class Go2StartListener implements ActionListener//go to startscreen
    {
        @Override
        public void actionPerformed(ActionEvent actionEvent) {
            go2Start();//back to startScreen
        }
    }
    class SaveUserListener implements ActionListener//save user to db from createUserScreen
    {
        @Override
        public void actionPerformed(ActionEvent actionEvent) {
            String name = view.getCuScreenName();
            String pw= view .getCuScreenPassword();
            createUser(name,pw);
            returnToPrevScreen();
        }
    }
    class Go2LoginListener implements ActionListener//go to loginscreen
    {
        @Override
        public void actionPerformed(ActionEvent actionEvent) {
            go2Login();
        }
    }
    class LoginListener implements ActionListener//login a user from loginScreen
    {
        @Override
        public void actionPerformed(ActionEvent actionEvent) {
            String name = view.getLoginScreen().getName();
            String pw= view.getLoginScreen().getPassWord();
            checkLogin(name,pw);
        }
    }
    class Go2CreateEvenTicketListener implements ActionListener//go to even ticket creator
    {
        @Override
        public void actionPerformed(ActionEvent actionEvent) {
           // go2CreateEvenTicket();
        }
    }
    class Go2CreateSpecialTicketListener implements ActionListener//go to special ticket creator
    {
        @Override
        public void actionPerformed(ActionEvent actionEvent) {
            //go2CreateSpecialTicket();
        }
    }
    class CalcListener implements ActionListener//calculate debts and show in debtscreen
    {
        @Override
        public void actionPerformed(ActionEvent actionEvent) {

        }
    }
    class Go2RemoveUserListener implements ActionListener //go to create user screen
    {
        @Override
        public void actionPerformed(ActionEvent actionEvent) {
            go2RemoveUser();
        }
    }
    class Return2ScreenListener implements ActionListener
    {
        @Override
        public void actionPerformed(ActionEvent actionEvent) {
            returnToPrevScreen();
        }
    }
    class RemoveUserListener implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent actionEvent) {
            view.showErrorMessage("Removing a user that is involved in tickets may break the app");
            String name=view.getRuScreenName();
            model.removeUserfromDB(name);
            if (getUsernames().length<=0)
            {
                view.showErrorMessage("no more users exist, returning to start");
                go2Start();
            }else
                returnToPrevScreen();
        }
    }

    //methods to interact with model
    public void createUser(String name, String pw)
    {
        model.addUserToDB(name,pw);
    }
    public void checkLogin(String name,String password)
    {
        //triggered when someone presses 'login' after entering info in loginScreen
        //a function that looks for the username in the database and confirms whether the password is correct
        if (model.checkLogin(name,password)) //true if name and pw are correct
        {
            go2Home();
        }else{//login failed: show error and reset loginscreen
            view.showErrorMessage("The entered name and password combination don't exist. Try again");
        }
    }
    public void returnToPrevScreen()
    {
        System.out.println("returning to "+returnScreen);
        if (returnScreen.equals("start"))
        {
            go2Start();
        }else if (returnScreen.equals("home"))
            go2Home();
    }
    public String[] getTicketContents()
    {
        return model.getTicketContents();
    }
    public String[] getUsernames()
    {
        String[] usernames=model.getUserNames();
        return usernames;
    }

}
