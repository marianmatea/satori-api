package com.satori.service;

import com.satori.dto.MemberAdminAddDto;
import com.satori.dto.MemberClubAddDto;
import com.satori.dto.MemberDto;
import com.satori.dto.MemberPageDto;
import com.satori.model.Member;

import java.security.Principal;
import java.util.List;

public interface MemberService {
    List<MemberDto> getAll();

    MemberPageDto getAllPagination(Integer pageNo);

    MemberPageDto getByUsername(Integer pageNo, Principal principal);

    Member create(MemberClubAddDto memberClubAddDto, Principal principal);

    void deleteById(Long id);

    MemberDto getById(Long id);

    void createMemberAdmin(MemberAdminAddDto memberAdminAddDto);
}
