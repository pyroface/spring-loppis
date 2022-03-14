package se.iths.springloppis.service;

import org.springframework.stereotype.Service;
import se.iths.springloppis.entity.UserEntity;
import se.iths.springloppis.repository.UserRepository;

import javax.persistence.EntityNotFoundException;
import java.util.Optional;

@Service
public class UserService {

    UserRepository userRepository;

    public UserService(UserRepository userRepository){
        this.userRepository = userRepository;
    }

    public UserEntity createUser(UserEntity userEntity){
        return userRepository.save(userEntity);
    }

    public void deleteUser(Long id){
        UserEntity foundItem =  userRepository.findById(id).orElseThrow(EntityNotFoundException::new);
        userRepository.deleteById(foundItem.getId());
    }

    public Optional<UserEntity> findUserById(Long id){
        return userRepository.findById(id);
    }

    public Iterable<UserEntity> findAllUsers(){
        return userRepository.findAll();
    }

}
