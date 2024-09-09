package com.app;

import com.app.persistence.entity.PermissionEntity;
import com.app.persistence.entity.RoleEntity;
import com.app.persistence.entity.RoleEnum;
import com.app.persistence.entity.UserEntity;
import com.app.persistence.repository.UserRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;
import java.util.Set;

@SpringBootApplication
public class SpringSecurityappApplication {
    public static void main(String[] args) {
        SpringApplication.run(SpringSecurityappApplication.class, args);



    }


    @Bean
    CommandLineRunner init(UserRepository userRepository){
        return args -> {
            /* Create Permission */
            PermissionEntity createPermission = PermissionEntity.builder()
                    .name("CREATE")
                    .build();

            PermissionEntity readPermission = PermissionEntity.builder()
                    .name("READ")
                    .build();

            PermissionEntity updatePermission = PermissionEntity.builder()
                    .name("UPDATE")
                    .build();

            PermissionEntity deletePermission = PermissionEntity.builder()
                    .name("DELETE")
                    .build();

            PermissionEntity refactorPermission = PermissionEntity.builder()
                    .name("REFACTOR")
                    .build();

            /*  CREATE ROLES */

            RoleEntity roleAdmin = RoleEntity.builder()
                    .roleEnum(RoleEnum.ADMIN)
                    .permissionList(Set.of(createPermission,readPermission,updatePermission,deletePermission))
                    .build();

            RoleEntity roleUser = RoleEntity.builder()
                    .roleEnum(RoleEnum.USER)
                    .permissionList(Set.of(createPermission,readPermission))
                    .build();

            RoleEntity roleInvited = RoleEntity.builder()
                    .roleEnum(RoleEnum.INVITED)
                    .permissionList(Set.of(readPermission))
                    .build();

            RoleEntity roleDeveloper = RoleEntity.builder()
                    .roleEnum(RoleEnum.DEVELOPER)
                    .permissionList(Set.of(createPermission,readPermission,updatePermission,deletePermission,refactorPermission))
                    .build();

            /* Create Users*/
            UserEntity userEdwin = UserEntity.builder()
                    .username("edwin")
                    .password("$2a$10$1BmSwMuXWHX5M5GJGRI7suZgKtKc8Y/LadxC1PgPWLz45DPN0Rsmu")
                    .isEnabled(true)
                    .accountNoExpired(true)
                    .accountNoLocked(true)
                    .credentialsNoExpired(true)
                    .roles(Set.of(roleAdmin))
                    .build();

            UserEntity userRicardo = UserEntity.builder()
                    .username("ricardo")
                    .password("$2a$10$1BmSwMuXWHX5M5GJGRI7suZgKtKc8Y/LadxC1PgPWLz45DPN0Rsmu")
                    .isEnabled(true)
                    .accountNoExpired(true)
                    .accountNoLocked(true)
                    .credentialsNoExpired(true)
                    .roles(Set.of(roleUser))
                    .build();

            UserEntity userLuis = UserEntity.builder()
                    .username("dafne")
                    .password("$2a$10$1BmSwMuXWHX5M5GJGRI7suZgKtKc8Y/LadxC1PgPWLz45DPN0Rsmu")
                    .isEnabled(true)
                    .accountNoExpired(true)
                    .accountNoLocked(true)
                    .credentialsNoExpired(true)
                    .roles(Set.of(roleInvited))
                    .build();

            UserEntity userDayiro = UserEntity.builder()
                    .username("dayiro")
                    .password("$2a$10$1BmSwMuXWHX5M5GJGRI7suZgKtKc8Y/LadxC1PgPWLz45DPN0Rsmu")
                    .isEnabled(true)
                    .accountNoExpired(true)
                    .accountNoLocked(true)
                    .credentialsNoExpired(true)
                    .roles(Set.of(roleDeveloper))
                    .build();

            userRepository.saveAll(List.of(userEdwin,userRicardo,userLuis,userDayiro));
        };
    }

}
