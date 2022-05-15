package com.satori.service.impl;

import com.satori.dto.MemberAdminAddDto;
import com.satori.dto.MemberClubAddDto;
import com.satori.dto.MemberDto;
import com.satori.dto.MemberPageDto;
import com.satori.model.Member;
import com.satori.repository.ClubRepository;
import com.satori.repository.MemberRepository;
import com.satori.service.MemberService;
import com.satori.util.MapperUtil;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.security.Principal;
import java.util.List;
import java.util.stream.Collectors;

@AllArgsConstructor
@Service
public class MemberServiceImpl implements MemberService {

    private final MemberRepository memberRepository;
    private final ClubRepository clubRepository;
    private final MapperUtil mapperUtil;

    @Override public List<MemberDto> getAll() {
        return memberRepository.findAll().stream()
                .map(mapperUtil::mapMemberToDto)
                .collect(Collectors.toList());
    }

    @Override public MemberPageDto getAllPagination(Integer pageNo) {
        var page = memberRepository.findByOrderByLastName(PageRequest.of(pageNo - 1, 8));
        return MemberPageDto.builder()
                .memberDtos(page.stream()
                        .map(mapperUtil::mapMemberToDto)
                        .collect(Collectors.toList()))
                .currentPage(page.getNumber() + 1)
                .totalPages(page.getTotalPages())
                .totalEntries(page.getTotalElements())
                .build();
    }

    @Override
    public MemberPageDto getByUsername(Integer pageNo, Principal principal) {
        return null;
    }

    @Override
    public Member create(MemberClubAddDto memberClubAddDto, Principal principal) {
        return null;
    }

/*    @Override public MemberPageDto getByUsername(Integer pageNo, Principal principal) {
        var page = memberRepository.findMembersByClubIdOrderByLastName(
                PageRequest.of(pageNo - 1, 8),
                userSecurityUtil.getClubId(principal));
        return MemberPageDto.builder()
                .memberDtos(page.stream()
                        .map(mapperUtil::mapMemberToDto)
                        .collect(Collectors.toList()))
                .currentPage(page.getNumber() + 1)
                .totalPages(page.getTotalPages())
                .totalEntries(page.getTotalElements())
                .build();
    }

    @Override public Member create(MemberClubAddDto memberClubAddDto, Principal principal) {
        var member = mapperUtil.mapMemberAddDto(memberClubAddDto);
        member.setClub(clubRepository
                .findById(userSecurityUtil.getClubId(principal))
                .orElseThrow(() -> new RuntimeException("No Club found!")));
        return memberRepository.save(member);
    }*/

    @Override public void deleteById(Long id) {
        memberRepository.deleteById(id);
    }

    @Override public MemberDto getById(Long id) {
        return mapperUtil.mapMemberToDto(memberRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Member not Found")));
    }

    @Override public void createMemberAdmin(MemberAdminAddDto memberAdminAddDto) {
        var member = mapperUtil.mapMemberAdminAddDto(memberAdminAddDto);
        if (memberAdminAddDto.getClubId() != null) {
            var club = clubRepository.findById(memberAdminAddDto.getClubId())
                    .orElseThrow(() -> new RuntimeException("No Club found!"));
            member.setClub(club);
        }
        memberRepository.save(member);
    }
}