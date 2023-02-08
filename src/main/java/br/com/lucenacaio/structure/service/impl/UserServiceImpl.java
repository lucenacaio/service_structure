package br.com.lucenacaio.structure.service.impl;

import br.com.lucenacaio.structure.domain.User;
import br.com.lucenacaio.structure.dto.UserDTO;
import br.com.lucenacaio.structure.mapper.UserMapper;
import br.com.lucenacaio.structure.repository.UserRepository;
import br.com.lucenacaio.structure.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    private final BCryptPasswordEncoder bCryptPasswordEncoder;

    @Autowired
    public UserServiceImpl(UserRepository userRepository,
                           BCryptPasswordEncoder bCryptPasswordEncoder) {
        this.userRepository = userRepository;
        this.bCryptPasswordEncoder = bCryptPasswordEncoder;
    }


    @Override
    @Transactional(rollbackOn = Exception.class)
    public void save(UserDTO userDTO) {

        if (userDTO == null) {
            throw new IllegalArgumentException("UserDTO cannot be null");
        }

        String encryptedPassword = bCryptPasswordEncoder.encode(userDTO.getPassword());
        User user = UserMapper.INSTANCE.toEntity(userDTO, encryptedPassword);
        this.userRepository.save(user);
    }
}
