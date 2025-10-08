package com.example.IT_HRM.ServiceImpl;

import com.example.IT_HRM.DTO.EmployeeDTO;
import com.example.IT_HRM.DTO.UserDTO;
import com.example.IT_HRM.Entity.Employee;
import com.example.IT_HRM.Entity.User;
import com.example.IT_HRM.GlobalException.ResourceAlreadyExistsException;
import com.example.IT_HRM.GlobalException.ResourceNotFoundException;
import com.example.IT_HRM.Mapper.EmployeeMapper;
import com.example.IT_HRM.Mapper.UserMapper;
import com.example.IT_HRM.Repository.EmployeeRep;
import com.example.IT_HRM.Repository.UserRepository;
import com.example.IT_HRM.Service.EmployeeService;
import com.example.IT_HRM.Service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final UserMapper userMapper;
    private final EmployeeRep employeeRep;
    private final PasswordEncoder passwordEncoder;

    @Override
    public User create(UserDTO userDTO) {
        if ( !employeeRep.existsById(userDTO.getEmployee()) ) throw new ResourceNotFoundException("Employee",userDTO.getEmployee());
        if ( userRepository.existsById(userDTO.getEmployee()) ) throw new ResourceAlreadyExistsException("Employee",userDTO.getEmployee().toString());
        if ( userRepository.existsByName(userDTO.getUsername()) ) throw new ResourceAlreadyExistsException("Employee",userDTO.getUsername());

        passwordEncoder.encode(userDTO.getPassword());
        User user = userMapper.dtoToUser(userDTO);
        user.setUserGroup(userDTO.getGroup());
        return userRepository.save(user);
    }

    @Override
    public List<UserDTO> getUsers() {
        List<UserDTO> list = userRepository.findAll().stream().map(user -> userMapper.userToDTO(user)).toList();
        return list;
    }

    @Override
    public User getUserId(Long Id) {
        return userRepository.findById(Id).orElseThrow(() -> new ResourceNotFoundException("User", Id));
    }

    @Override
    public User updateUser(User user) {
        getUserId(user.getId());
        return userRepository.save(user);
    }

    @Override
    public List<User> allUser() {
        List<User> users = userRepository.findAll();
        User user = new User();

//        List<User> list1 = userRepository.findAll()
//                .stream()
//                .map(user -> {;
//                    EmployeeDTO employeeDTO = new EmployeeDTO();
//                    employeeDTO.setId(user.getEmployee().getId());
//                    Employee emp = EmployeeMapper.INSTANCE.DTOtoEmployee(employeeDTO);
//                    emp.setId(user.getEmployee().getId());
//
//                    user.setEmployee( emp );
//                    System.out.println(emp);
//                    return user;
//                })
//                .toList();

        return users;
    }

    @Override
    public Optional<User> getByUsername(String username) {
        ///User byEmployee = userRepository.findByEmployee(username);
        return null;
    }

//    public Long employeeToCode(Map<Employee, Long> empMap) {
//        if (empMap == null || empMap.isEmpty()) return null;
//
//        return empMap.keySet().stream()
//                .map(Employee::getId)
//                .filter(Objects::nonNull)
//                .findFirst()
//                .orElse(null);
//    }
}
