package kr.ac.hansung.cse.hellospringdatajpa.controller;

import kr.ac.hansung.cse.hellospringdatajpa.entity.MyUser;
import kr.ac.hansung.cse.hellospringdatajpa.repo.UserRepository;
import kr.ac.hansung.cse.hellospringdatajpa.entity.Role;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.NoSuchElementException;
import jakarta.annotation.PostConstruct;

@Controller
@RequestMapping("/admin")
@PreAuthorize("hasRole('ROLE_ADMIN')")
public class AdminController {

    @Autowired
    private UserRepository userRepository;

    @GetMapping("/users")
    public String listUsers(Model model) {
        List<MyUser> users = userRepository.findAll();
        model.addAttribute("users", users);
        return "admin";
    }

    @PostMapping("/users/{id}/promote")
    public String promoteUser(@PathVariable Long id) {
        MyUser user = userRepository.findById(id)
                .orElseThrow(() -> new NoSuchElementException("해당 유저를 찾을 수 없습니다"));
        user.setRole(Role.ROLE_ADMIN);
        userRepository.save(user);
        return "redirect:/admin/users";
    }

    @PostMapping("/users/{id}/demote")
    public String demoteUser(@PathVariable Long id) {
        MyUser user = userRepository.findById(id)
                .orElseThrow(() -> new NoSuchElementException("해당 유저를 찾을 수 없습니다"));
        user.setRole(Role.ROLE_USER);
        userRepository.save(user);
        return "redirect:/admin/users";
    }

    @PostConstruct
    public void initDefaultAdmin() {
        String adminEmail = "admin@hansung.ac.kr";
        String defaultPassword = "admin123";

        if (userRepository.findByEmail(adminEmail).isEmpty()) {
            MyUser admin = new MyUser();
            admin.setEmail(adminEmail);
            admin.setPassword(new org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder().encode(defaultPassword));
            admin.setRole(Role.ROLE_ADMIN);
            userRepository.save(admin);
        }
    }
}
