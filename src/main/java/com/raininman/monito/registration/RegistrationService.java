package com.raininman.monito.registration;

import com.raininman.monito.appuser.AppUser;
import com.raininman.monito.appuser.AppUserRole;
import com.raininman.monito.appuser.AppUserService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class RegistrationService {

    private final AppUserService appUserService;

    private final EmailValidator emailValidator;
    public String register(RegistrationRequest request)
    {
        boolean isValidEmail = emailValidator.test(request.getEmail());
        if(!isValidEmail){
            throw new IllegalStateException("Email is not valid");
        }
        return appUserService.signUpUser(
                new AppUser(
                    request.getFirstname(),
                        request.getLastname(),
                        request.getEmail(),
                        request.getPassword(),
                        AppUserRole.USER
                )
        );
    }
}
