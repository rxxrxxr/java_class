package com.gcw.restapi03_240306.users;

import com.gcw.restapi03_240306.exception.*;
import com.gcw.restapi03_240306.exception.ErrorCode;
import com.gcw.restapi03_240306.exception.LogicException;
import com.gcw.restapi03_240306.exception.UsersException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.nio.file.attribute.UserPrincipal;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;

    public User regist(User user){
        // 중복처리
        // 헤당되는 email이 있으면 중복나서 에러
        User emailUser = userRepository.findByEmail(user.getEmail());
        if(emailUser != null){
            throw new LogicException(ErrorCode.DUPLICATE);
        }

        User dbUser = userRepository.save(user);
        return dbUser;
    }

    public List<User> getAllUsers() {
        List<User> list = userRepository.findAll();
        return list;
    }

    public User getUserById(Long id) {
        Optional<User> optionalUser = userRepository.findById(id);
        if( optionalUser.isEmpty() ){
            throw new UsersException(ErrorCode.NOTFOUND);
        }
        else{
            return optionalUser.get();
        }
    }

    public User updateUser(User user){

        User emailUser = userRepository.findByEmail(user.getEmail());
        if(emailUser == null){
            throw new UsersException(ErrorCode.NOTUPDATEEMAIL);
        }
// 시간 이름 패스워드 성별 변경 가능.
        emailUser.setWdate(user.getWdate());
        emailUser.setUsername(user.getUsername());
        emailUser.setPassword(user.getPassword());
        emailUser.setGender(user.getGender());

        User dbUser = userRepository.save(emailUser);
        return dbUser;
    }

    public void delete(Long id) {
        //해당되는 아이디가 있으면 삭제해야됨
        //해당되는 아이디가 없으면 삭제할 유저가 없다고 알림
        Optional<User> dbUser = userRepository.findById(id);
        if (dbUser.isEmpty()){
            throw new UsersException(ErrorCode.NOTFOUND);
        }

        User getUser = dbUser.get();
        userRepository.delete(dbUser.get());
//        userRepository.deleteById(id); // 해당되는 id만 조회해서 delete

    }

    public void delete(){
        userRepository.deleteAll();
    }

}
