package entities;

import entities.AppUser;
import entities.RealmGroup;
import entities.UserGroupPK;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2020-06-11T12:12:29")
@StaticMetamodel(UserGroup.class)
public class UserGroup_ { 

    public static volatile SingularAttribute<UserGroup, UserGroupPK> userGroupPK;
    public static volatile SingularAttribute<UserGroup, AppUser> user;
    public static volatile SingularAttribute<UserGroup, RealmGroup> group;

}