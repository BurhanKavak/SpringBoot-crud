package com.burhan.app.rest.service.concretes;

import com.burhan.app.rest.exception.UserAlreadyExistException;
import com.burhan.app.rest.exception.UserNotFoundException;
import com.burhan.app.rest.model.User;
import com.burhan.app.rest.repository.UserRepository;
import com.burhan.app.rest.service.abstracts.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService implements IUserService {
    @Autowired
    private UserRepository repository;

    @Override
    public User save(User user){
        if (repository.getByFirstName(user.getFirstName()).isPresent() && repository.getByLastName(user.getLastName()).isPresent()&&
        repository.getByEmail(user.getEmail()).isPresent()){
            throw new UserAlreadyExistException("İsim,soyisim ve email farklı girmeniz gerekmektedir!");
        }
        return repository.save(user);
    }

    @Override
    public List<User> getAll() {
        return repository.findAll();
    }

    @Override
    public User getById(long id) {
        Optional<User> optionalUser = repository.findById(id);
        User user = optionalUser.orElseThrow(() -> new UserNotFoundException("User id :" + id));
        return user;

    }

    @Override
    public String delete(long id) {
        Optional<User> optionalUser = repository.findById(id);
        if (optionalUser.isEmpty()){
            throw new UserNotFoundException("User id :" + id);
        }
        repository.deleteById(id);
        return "Başarıyla Silindi";
    }

    @Override
    public String update(long id,User user) {
        Optional<User> optionalUser = repository.findById(id);
        if (optionalUser.isEmpty()){
            throw new UserNotFoundException("User id :" + id);
        }
        User oldUser = getById(id);
        oldUser.setLastName(user.getLastName());
        oldUser.setFirstName(user.getFirstName());
        oldUser.setEmail(user.getEmail());
        repository.save(oldUser);
        return "Başarıyla Güncellendi";
    }
}
