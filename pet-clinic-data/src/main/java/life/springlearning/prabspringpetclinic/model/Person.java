package life.springlearning.prabspringpetclinic.model;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;

//This annotation tells JPA not to create the table for this class
// We do not require a POJO of this class, it is only to be inherited
@MappedSuperclass
public class Person extends BaseEntity{
    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
}
