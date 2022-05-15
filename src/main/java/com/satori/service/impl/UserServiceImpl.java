package com.satori.service.impl;

import com.satori.dto.UserAddDto;
import com.satori.dto.UserPageDto;
import com.satori.model.User;
import com.satori.repository.ClubRepository;
import com.satori.repository.UserRepository;
import com.satori.service.UserService;
import com.satori.util.MapperUtil;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@AllArgsConstructor
@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final ClubRepository clubRepository;
    private final MapperUtil mapperUtil;


    @Override public List<User> getAll() {
        return userRepository.findAll();
    }

    @Override public UserPageDto getAllPagination(Integer pageNo) {
        var page = userRepository.findByOrderByUsername(PageRequest.of(pageNo - 1, 8));
        return UserPageDto.builder()
                .userDtos(page.stream()
                        .map(mapperUtil::mapUserToDto)
                        .collect(Collectors.toList()))
                .currentPage(page.getNumber() + 1)
                .totalPages(page.getTotalPages())
                .totalEntries(page.getTotalElements())
                .build();
    }

    @Override public User createUser(UserAddDto userAddDto) {
/*        var user = mapperUtil.mapUserAddDto(userAddDto);
        if (userAddDto.getClubId() != null)
            user.setClub(clubRepository.findById(userAddDto.getClubId())
                    .orElseThrow(() -> new RuntimeException("Club not found")));
        return userRepository.save(user);*/
        return null;
    }

    @Override public User getUser(Long id) {
        return userRepository.findById(id).orElseThrow();
    }

    @Override public User updateUser(Long id, User user){
        var userDb = userRepository.findById(id).orElseThrow(() -> new RuntimeException("No user found"));
        userDb.setFirstName(user.getFirstName());
        userDb.setLastName(user.getLastName());
        userDb.setEmail(user.getEmail());
        userDb.setPhoneNumber(user.getPhoneNumber());
        userRepository.save(userDb);
        return user;
    }

    @Override public void deleteUser(Long id) {
        userRepository.deleteById(id);
    }
}