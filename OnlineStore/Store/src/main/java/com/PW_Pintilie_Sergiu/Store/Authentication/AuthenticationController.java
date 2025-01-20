package com.PW_Pintilie_Sergiu.Store.Authentication;

import com.PW_Pintilie_Sergiu.Store.User.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/security")
@RequiredArgsConstructor
public class AuthenticationController {
    private final AuthenticationService authenticationService;
    private final UserService userService;
    @PostMapping("/register")
    public String register(@ModelAttribute("registerForm") RegisterRequest registerForm){
        authenticationService.register(registerForm);
        return "redirect:/login";
    }

    @PostMapping("/authenticate")
    public ResponseEntity<AuthenticationResponse> authenticate(@RequestBody AuthenticationRequest request){
        return ResponseEntity.ok(authenticationService.authenticate(request));
    }

}
