package ro.temeonline.api;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import ro.temeonline.controllers.ProfesorController;
import ro.temeonline.controllers.UserController;
import ro.temeonline.entities.Profesor;
import ro.temeonline.entities.User;

/**
 * Created by Vlad Butnaru on 1/29/2017.
 */
@Controller
public class AuthController {


    @RequestMapping(value = "/student/login", method = RequestMethod.POST, consumes = "application/json", produces = "application/json")
    public
    @ResponseBody
    User studentLogin(@RequestBody User user) {
        User u = UserController.loginUser(user.getEmail(), user.getParola());
        return u;
    }

    @RequestMapping(value = "/student/register", method = RequestMethod.POST, consumes = "application/json", produces = "application/json")
    public
    @ResponseBody
    boolean studentSignup(@RequestBody User user) {
        UserController.AddNew(user.getNume(), user.getPrenume(), user.getEmail(), user.getParola(), user.getAn());
        return true;
    }

    @RequestMapping(value = "/profesor/login", method = RequestMethod.POST, consumes = "application/json", produces = "application/json")
    public
    @ResponseBody
    Profesor profesorLogin(@RequestBody Profesor prof) {
        Profesor u = ProfesorController.loginUser(prof.getEmail(), prof.getPass());
        return u;
    }

    @RequestMapping(value = "/profesor/register", method = RequestMethod.POST, consumes = "application/json", produces = "application/json")
    public
    @ResponseBody
    boolean profesorSignup(@RequestBody Profesor prof) {
        ProfesorController.AddNew(prof.getNume(), prof.getPrenume(), prof.getEmail(), prof.getPass(), prof.getMaterie(), prof.getSpecializari());
        return true;
    }

}