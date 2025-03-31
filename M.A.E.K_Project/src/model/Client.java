
package model;

/**
 * The Client class represents a client with a username, name, password, and age.
 * It provides methods to get and set these attributes.
 */
public class Client {
    private String username;
    private String client_name;
    private String client_password;
    private int age;

    /**
     * Constructs a new Client with the specified username, name, password, and age.
     *
     * @param username the username of the client
     * @param client_name the name of the client
     * @param client_password the password of the client
     * @param age the age of the client
     */
    public Client(String username, String client_name, String client_password, int age) {
        this.username = username;
        this.client_name = client_name;
        this.client_password = client_password;
        this.age = age;
    }

    /**
     * Returns the username of the client.
     *
     * @return the username
     */
    public String getUsername() {
        return username;
    }

    /**
     * Sets the username of the client.
     *
     * @param username the new username
     */
    public void setUsername(String username) {
        this.username = username;
    }

    /**
     * Returns the name of the client.
     *
     * @return the client name
     */
    public String getClient_name() {
        return client_name;
    }

    /**
     * Sets the name of the client.
     *
     * @param client_name the new client name
     */
    public void setClient_name(String client_name) {
        this.client_name = client_name;
    }

    /**
     * Returns the password of the client.
     *
     * @return the client password
     */
    public String getClient_password() {
        return client_password;
    }

    /**
     * Sets the password of the client.
     *
     * @param client_password the new client password
     */
    public void setClient_password(String client_password) {
        this.client_password = client_password;
    }

    /**
     * Returns the age of the client.
     *
     * @return the age
     */
    public int getAge() {
        return age;
    }

    /**
     * Sets the age of the client.
     *
     * @param age the new age
     */
    public void setAge(int age) {
        this.age = age;
    }

    /**
     * Returns a string representation of the client.
     *
     * @return a string representation of the client
     */
    @Override
    public String toString() {
        return "Username: " + username + "    Name: " + client_name + "    Password: " + client_password + "    Age: " + age;
    }
}
