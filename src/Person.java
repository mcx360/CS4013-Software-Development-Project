/**
 * The Person class represents an abstract person with a name and email.
 * It provides a common structure for entities with personal information.
 */
public abstract class Person {

    private String name;
    private String email;

    /**
     * Constructs a new Person with the specified name and email.
     *
     * @param name  The name of the person.
     * @param email The email of the person.
     */
    public Person(String name, String email) {
        this.name = name;
        this.email = email;
    }

    /**
     * Gets the name of the person.
     *
     * @return The name of the person.
     */
    public String getName() {
        return this.name;
    }

    /**
     * Gets the email of the person.
     *
     * @return The email of the person.
     */
    public String getEmail() {
        return email;
    }
}
