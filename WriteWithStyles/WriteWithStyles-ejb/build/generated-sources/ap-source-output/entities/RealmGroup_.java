package entities;

import entities.AppUser;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2020-06-11T12:12:29")
@StaticMetamodel(RealmGroup.class)
public class RealmGroup_ { 

    public static volatile SingularAttribute<RealmGroup, Integer> groupid;
    public static volatile CollectionAttribute<RealmGroup, AppUser> appUserCollection;
    public static volatile SingularAttribute<RealmGroup, String> groupname;

}