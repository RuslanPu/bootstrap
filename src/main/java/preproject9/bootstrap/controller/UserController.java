package preproject9.bootstrap.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import preproject9.bootstrap.model.Role;
import preproject9.bootstrap.model.User;
import preproject9.bootstrap.service.UserService;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Controller
@RequestMapping("/user")
public class UserController {

    @RequestMapping(value = "/userPage", method = RequestMethod.GET)
    public String userPage(ModelMap model) {
        User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        List<Role> rolesUser =(List<Role>) SecurityContextHolder.getContext().getAuthentication().getAuthorities();
        user.setRoles(rolesUser);
        model.addAttribute("user", user);
        return "user/userPage";
    }
}
