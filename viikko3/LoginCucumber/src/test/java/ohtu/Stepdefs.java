package ohtu;

import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;
import java.util.ArrayList;
import java.util.List;
import static org.junit.Assert.*;
import ohtu.io.*;
import ohtu.data_access.*;
import ohtu.services.*;

public class Stepdefs {

    App app;
    StubIO io;
    UserDao userDao;
    AuthenticationService auth;
    List<String> inputLines;

    @Before
    public void setup() {
        userDao = new InMemoryUserDao();
        auth = new AuthenticationService(userDao);
        inputLines = new ArrayList<>();
    }

    @Given("^command login is selected$")
    public void commandLoginSelected() throws Throwable {
        inputLines.add("login");
    }

    @When("username {string} and password {string} are entered")
    public void usernameAndPasswordAreEntered(String username, String password) {
        inputLines.add(username);
        inputLines.add(password);

        io = new StubIO(inputLines);
        app = new App(io, auth);
        app.run();
    }

    @Then("system will respond with {string}")
    public void systemWillRespondWith(String expectedOutput) {
        assertTrue(io.getPrints().contains(expectedOutput));
    }

    @When("username {string} and wrong password {string} are entered")
    public void usernameAndWrongPasswordAreEntered(String username, String password) {
        inputLines.add(username);
        inputLines.add(password);

        io = new StubIO(inputLines);
        app = new App(io, auth);
        app.run();
    }

    @Then("system will respond with error {string}")
    public void systemWillRespondWithError(String expectedOutput) {
        assertTrue(io.getPrints().contains(expectedOutput));
    }

    @When("wrong username {string} wrong password {string} are entered")
    public void wrongUsernameWrongPasswordAreEntered(String username, String password) {
        inputLines.add(username);
        inputLines.add(password);

        io = new StubIO(inputLines);
        app = new App(io, auth);
        app.run();
    }

    @Given("command new is selected")
    public void commandNewIsSelected() {
        inputLines.add("new");
    }

    @Given("user {string} with password {string} is created")
    public void userWithPasswordIsCreated(String user, String password) {
        inputLines.add("new");
        inputLines.add(user);
        inputLines.add(password);
    }

}
