package com.PW_Pintilie_Sergiu.Store.Authentication;

import com.PW_Pintilie_Sergiu.Store.Security.JwtService;
import com.PW_Pintilie_Sergiu.Store.User.Role;
import com.PW_Pintilie_Sergiu.Store.User.User;
import com.PW_Pintilie_Sergiu.Store.User.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
@RequiredArgsConstructor
public class AuthenticationService {
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final JwtService jwtService;
    private final AuthenticationManager authenticationManager;
    public AuthenticationResponse register(RegisterRequest request){
        var user=new User(request.getFirstName(), request.getLastName(),request.getEmail(), passwordEncoder.encode(request.getPassword()), request.getRole());
        userRepository.save(user);
        var jwtToken=jwtService.generateToken(user);
        return AuthenticationResponse
                .builder()
                .token(jwtToken)
                .build();
    }
    public AuthenticationResponse authenticate(AuthenticationRequest request){
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        request.getEmail(),
                        request.getPassword()
                )
        );
        var user=userRepository.findByEmail(request.getEmail()).orElseThrow();
        var jwtToken=jwtService.generateToken(user);
        return AuthenticationResponse.builder().token(jwtToken).role(user.getRole().toString()).build();
    }
}
