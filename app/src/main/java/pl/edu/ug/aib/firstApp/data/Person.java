package pl.edu.ug.aib.firstApp.data;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Person {

    public String phoneNumber;
    public String name;
    public String company;
    public int ownerId;

}
