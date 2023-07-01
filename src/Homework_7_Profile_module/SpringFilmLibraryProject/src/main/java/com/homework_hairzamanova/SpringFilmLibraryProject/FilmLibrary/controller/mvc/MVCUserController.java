package com.homework_hairzamanova.SpringFilmLibraryProject.FilmLibrary.controller.mvc;

import com.homework_hairzamanova.SpringFilmLibraryProject.FilmLibrary.constants.Errors;
import com.homework_hairzamanova.SpringFilmLibraryProject.FilmLibrary.dto.UserDTO;
import com.homework_hairzamanova.SpringFilmLibraryProject.FilmLibrary.service.UserService;
import com.homework_hairzamanova.SpringFilmLibraryProject.FilmLibrary.service.userdetails.CustomUserDetails;
import jakarta.security.auth.message.AuthException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.Objects;

import static com.homework_hairzamanova.SpringFilmLibraryProject.FilmLibrary.constants.UserRolesConstants.ADMIN;

@Controller
@Slf4j
@RequestMapping("/users")
public class MVCUserController {

    private final UserService userService;

    public MVCUserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/registration")
    public String registration(Model model) {
        model.addAttribute("userForm", new UserDTO());
        return "registration";
    }

    @PostMapping("/registration")
    public String registration(@ModelAttribute("userForm") UserDTO userDTO,
                               BindingResult bindingResult) {
        if (userDTO.getLogin().equalsIgnoreCase(ADMIN) || userService.getUserByLogin(userDTO.getLogin()) != null) {
            bindingResult.rejectValue("login", "error.login", "Такой логин уже существует");
            return "registration";
        }
        if (userService.getUserByEmail(userDTO.getEmail()) != null) {
            bindingResult.rejectValue("email", "error.email", "Такой e-mail уже существует");
            return "registration";
        }
        userService.create(userDTO);
        return "redirect:login";
    }

    @GetMapping("/profile/{id}")
    public String userProfile(@PathVariable Integer id,
                              @ModelAttribute(value = "exception") String exception,
                              Model model) throws AuthException {
        CustomUserDetails customUserDetails = (CustomUserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        if (!Objects.isNull(customUserDetails.getId())) {
            if (!ADMIN.equalsIgnoreCase(customUserDetails.getUsername())) {
                if (!id.equals(customUserDetails.getId())) {
                    throw new AuthException(HttpStatus.FORBIDDEN + ": " + Errors.Users.USER_FORBIDDEN_ERROR);
                }
            }
        }
        model.addAttribute("user", userService.getOne(Long.valueOf(id)));
        model.addAttribute("exception", exception);
        return "profile/viewProfile";
    }

    @GetMapping("/profile/update/{id}")
    public String updateProfile(@PathVariable Integer id,
                                Model model) throws AuthException {
        CustomUserDetails customUserDetails = (CustomUserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        if (!id.equals(customUserDetails.getId())) {
            throw new AuthException(HttpStatus.FORBIDDEN + ": " + Errors.Users.USER_FORBIDDEN_ERROR);
        }
        model.addAttribute("userForm", userService.getOne(Long.valueOf(id)));
        return "profile/updateProfile";
    }

    @PostMapping("/profile/update")
    public String updateProfile(@ModelAttribute("userForm") UserDTO userDTOFromUpdateForm,
                                BindingResult bindingResult) {
        UserDTO userEmailDuplicated = userService.getUserByEmail(userDTOFromUpdateForm.getEmail());
        UserDTO foundUser = userService.getOne(userDTOFromUpdateForm.getId());
        if (userEmailDuplicated != null && !Objects.equals(userEmailDuplicated.getEmail(), foundUser.getEmail())) {
            bindingResult.rejectValue("email", "error.email", "Такой email уже существует");
            return "profile/updateProfile";
        }
        foundUser.setFirstName(userDTOFromUpdateForm.getFirstName());
        foundUser.setLastName(userDTOFromUpdateForm.getLastName());
        foundUser.setMiddleName(userDTOFromUpdateForm.getMiddleName());
        foundUser.setEmail(userDTOFromUpdateForm.getEmail());
        foundUser.setBirthDate(userDTOFromUpdateForm.getBirthDate());
        foundUser.setPhone(userDTOFromUpdateForm.getPhone());
        foundUser.setAddress(userDTOFromUpdateForm.getAddress());
        userService.update(foundUser);
        return "redirect:/users/profile/" + userDTOFromUpdateForm.getId();
    }

    @GetMapping("/list")
    public String listAllUsers(@RequestParam(value = "page", defaultValue = "1") int page,
                               @RequestParam(value = "size", defaultValue = "10") int pageSize,
                               Model model) {
        PageRequest pageRequest = PageRequest.of(page - 1, pageSize, Sort.by(Sort.Direction.ASC, "login"));
        Page<UserDTO> userPage = userService.listAll(pageRequest);
        model.addAttribute("users", userPage);
        return "users/viewAllUsers";
    }


}

