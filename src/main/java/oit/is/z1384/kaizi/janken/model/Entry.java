package oit.is.z1384.kaizi.janken.model;

import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.javassist.expr.NewArray;
import org.springframework.stereotype.Component;

@Component
public class Entry {
  private List<String> users = new ArrayList<>();

  public void adduser(String username) {
    for (final String user : this.users) {
      if (username.equals(user)) {
        return;
      }
    }
    this.users.add(username);
  }

  public List<String> getUsers() {
    return this.users;
  }

  public void setUsers(List<String> users) {
    this.users = users;
  }
}
