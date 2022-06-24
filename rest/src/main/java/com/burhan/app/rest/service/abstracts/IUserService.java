package com.burhan.app.rest.service.abstracts;

import com.burhan.app.rest.model.User;

import java.util.List;

public interface IUserService {
  public User save(User user);
  public List<User> getAll();
  public User getById(long id);
  public String delete(long id);
}
