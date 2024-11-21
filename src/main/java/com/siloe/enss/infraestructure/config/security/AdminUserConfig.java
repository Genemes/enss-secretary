package com.siloe.enss.infraestructure.config.security;

import com.siloe.enss.infraestructure.presentation.EmailPresentation;
import com.siloe.enss.infraestructure.presentation.RolePresentation;
import com.siloe.enss.infraestructure.presentation.PermissionPresentation;
import com.siloe.enss.infraestructure.presentation.AccountPresentation;
import com.siloe.enss.infraestructure.repository.PermissionRepository;
import com.siloe.enss.infraestructure.repository.RoleRepository;
import com.siloe.enss.infraestructure.repository.UserRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashSet;
import java.util.Set;

@Configuration
public class AdminUserConfig implements CommandLineRunner {

    private UserRepository userRepository;
    private RoleRepository roleRepository;
    private PermissionRepository permissionRepository;
    private BCryptPasswordEncoder passwordEncoder;

    public AdminUserConfig(UserRepository userRepository,
                           RoleRepository roleRepository,
                           PermissionRepository permissionRepository,
                           BCryptPasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.roleRepository = roleRepository;
        this.permissionRepository = permissionRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    @Transactional
    public void run(String... args) throws Exception {
        var permission = new PermissionPresentation("admin", "super usuario");
        permissionRepository.save(permission);
        var role = new RolePresentation("ADMIN", Set.of(permission));

        roleRepository.save(role);
        Set<RolePresentation> roles = new HashSet<>();
        roles.add(role);

        var user = new AccountPresentation();
        user.setUsername("admin");
        user.setEmail(EmailPresentation.of("admin@admin.com"));
        user.addRole(role);
        user.setPassword(passwordEncoder.encode("123"));

//        userRepository.save(user);
    }
}
