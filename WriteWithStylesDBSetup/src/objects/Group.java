/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package objects;

/**
 *
 * @author 101042618
 */
public class Group {
    private int GroupId;
    private String Name;

    public Group(int GroupId, String Name) {
        this.GroupId = GroupId;
        this.Name = Name;
    }

    public int getGroupId() {
        return GroupId;
    }

    public void setGroupId(int GroupId) {
        this.GroupId = GroupId;
    }

    public String getName() {
        return Name;
    }

    public void setName(String Name) {
        this.Name = Name;
    }    
}
