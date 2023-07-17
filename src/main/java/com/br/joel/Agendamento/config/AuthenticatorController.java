package com.br.joel.Agendamento.config;

import com.br.joel.Agendamento.DTO.AutenticatorDTO;
import com.br.joel.Agendamento.DTO.ResgiterDTO;
import com.br.joel.Agendamento.domain.User;
import com.br.joel.Agendamento.repository.UserRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
public class AuthenticatorController {

        @Autowired
    AuthenticationManager authenticationManager;


        @Autowired
    UserRepository userRepository;

    @PostMapping("/login")
    public ResponseEntity login(@RequestBody @Valid AutenticatorDTO dto){
        var userNameAndPassword = new UsernamePasswordAuthenticationToken(dto.login(), dto.password());
        var authentication = authenticationManager.authenticate(userNameAndPassword);

        return  ResponseEntity.ok().build();
    }


    @PostMapping("/register")
    public ResponseEntity register(@RequestBody @Valid ResgiterDTO dto){

        if(userRepository.findByLogin(dto.login()) != null){
            return ResponseEntity.badRequest().build();
        }

        String encryptedPassword = new BCryptPasswordEncoder().encode(dto.password());
        User user = new User(dto.login(), encryptedPassword, dto.role());
        userRepository.save(user);

        return ResponseEntity.ok().build();

    }
}
