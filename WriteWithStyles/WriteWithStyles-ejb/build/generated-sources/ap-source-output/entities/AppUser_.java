package entities;

import entities.RealmGroup;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2020-06-11T12:12:29")
@StaticMetamodel(AppUser.class)
public class AppUser_ { 

    public static volatile SingularAttribute<AppUser, String> firstname;
    public static volatile SingularAttribute<AppUser, String> password;
    public static volatile SingularAttribute<AppUser, String> address;
    public static volatile CollectionAttribute<AppUser, RealmGroup> realmGroupCollection;
    public static volatile SingularAttribute<AppUser, String> mobile;
    public static volatile SingularAttribute<AppUser, String> postcode;
    public static volatile SingularAttribute<AppUser, String> suburb;
    public static volatile SingularAttribute<AppUser, String> state;
    public static volatile SingularAttribute<AppUser, Integer> userid;
    public static volatile SingularAttribute<AppUser, String> email;
    public static volatile SingularAttribute<AppUser, String> lastname;

}