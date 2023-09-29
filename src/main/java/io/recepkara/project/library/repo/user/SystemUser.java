package io.recepkara.project.library.repo.user;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class SystemUser {
    private  final  Integer id;
    private  final  String userName;
    private  final  String password;
}
