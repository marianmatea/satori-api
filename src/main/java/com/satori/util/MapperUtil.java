package com.satori.util;

import com.satori.dto.CategoryDto;
import com.satori.dto.ClubDto;
import com.satori.dto.CompetitionDto;
import com.satori.dto.MemberAdminAddDto;
import com.satori.dto.MemberClubAddDto;
import com.satori.dto.MemberDto;
import com.satori.dto.SeasonAddDto;
import com.satori.dto.SeasonDto;
import com.satori.dto.TrainerClubAddDto;
import com.satori.dto.TrainerDto;
import com.satori.dto.UserDto;
import com.satori.model.Category;
import com.satori.model.Club;
import com.satori.model.Competition;
import com.satori.model.Member;
import com.satori.model.Season;
import com.satori.model.Trainer;
import com.satori.model.User;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

@AllArgsConstructor
@Component
public class MapperUtil {

    private final ModelMapper modelMapper;

    public ClubDto mapClubToDto(Club club) {
        return modelMapper.map(club, ClubDto.class);
    }

    public Club mapClubDto(ClubDto clubDto) {
        return modelMapper.map(clubDto, Club.class);
    }

    public MemberDto mapMemberToDto(Member member) {
        var memberDto = modelMapper.map(member, MemberDto.class);
        if (member.getClub() != null)
            memberDto.setClubDto(mapClubToDto(member.getClub()));
        return memberDto;
    }

    public Member mapMemberAddDto(MemberClubAddDto memberClubAddDto) {
        LocalDate localDate = null;
        if (!memberClubAddDto.getMemberIdExpiry().isEmpty()) {
            DateTimeFormatter df = DateTimeFormatter.ofPattern("MM/dd/yyyy");
            localDate = LocalDate.parse(memberClubAddDto.getMemberIdExpiry());
        }
        return Member.builder()
                .firstName(memberClubAddDto.getFirstName())
                .lastName(memberClubAddDto.getLastName())
                .email(memberClubAddDto.getEmail())
                .phoneNumber(memberClubAddDto.getPhoneNumber())
                .status(memberClubAddDto.getStatus())
                .weight(memberClubAddDto.getWeight())
                .belt(memberClubAddDto.getBelt())
                .memberId(memberClubAddDto.getMemberId())
                .memberIdExpiry(localDate)
                .build();
    }

    public Member mapMemberAdminAddDto(MemberAdminAddDto memberAdminAddDto) {
        LocalDate localDate = null;
        if (!memberAdminAddDto.getMemberIdExpiry().isEmpty()) {
            DateTimeFormatter df = DateTimeFormatter.ofPattern("MM/dd/yyyy");
            localDate = LocalDate.parse(memberAdminAddDto.getMemberIdExpiry());
        }
        return Member.builder()
                .memberIdExpiry(localDate)
                .memberId(memberAdminAddDto.getMemberId())
                .belt(memberAdminAddDto.getBelt())
                .weight(memberAdminAddDto.getWeight())
                .status(memberAdminAddDto.getStatus())
                .phoneNumber(memberAdminAddDto.getPhoneNumber())
                .email(memberAdminAddDto.getEmail())
                .lastName(memberAdminAddDto.getLastName())
                .firstName(memberAdminAddDto.getFirstName())
                .build();
    }

    public Competition mapCompetitionDto(CompetitionDto competitionDto) {
        return modelMapper.map(competitionDto, Competition.class);
    }

    public CompetitionDto mapCompetitionToDto(Competition competition) {
        return modelMapper.map(competition, CompetitionDto.class);
    }

    public SeasonDto mapSeasonToDto(Season season) {
        return modelMapper.map(season, SeasonDto.class);
    }

    public Season mapSeasonAddDto(SeasonAddDto seasonAddDto) {
        var season = modelMapper.map(seasonAddDto, Season.class);
        if (!seasonAddDto.getStartDate().isEmpty()) {
            DateTimeFormatter df = DateTimeFormatter.ofPattern("MM/dd/yyyy");
            season.setStartDate(LocalDate.parse(seasonAddDto.getStartDate()));
        }
        if (!seasonAddDto.getFinishDate().isEmpty()) {
            DateTimeFormatter df = DateTimeFormatter.ofPattern("MM/dd/yyyy");
            season.setFinishDate(LocalDate.parse(seasonAddDto.getFinishDate()));
        }
        return season;
    }

    public TrainerDto mapTrainerToDto(Trainer trainer) {
        var trainerDto = modelMapper.map(trainer, TrainerDto.class);
        if (trainer.getClub() != null)
            trainerDto.setClubDto(mapClubToDto(trainer.getClub()));
        return trainerDto;
    }

    public Trainer mapTrainerAddDto(TrainerClubAddDto trainerClubAddDto) {
        LocalDate localDate = null;
        if (!trainerClubAddDto.getMemberIdExpiry().isEmpty()) {
            DateTimeFormatter df = DateTimeFormatter.ofPattern("MM/dd/yyyy");
            localDate = LocalDate.parse(trainerClubAddDto.getMemberIdExpiry());
        }
        return Trainer.builder()
                .firstName(trainerClubAddDto.getFirstName())
                .lastName(trainerClubAddDto.getLastName())
                .email(trainerClubAddDto.getEmail())
                .phoneNumber(trainerClubAddDto.getPhoneNumber())
                .memberId(trainerClubAddDto.getMemberId())
                .trainingType(trainerClubAddDto.getTrainingType())
                .memberIdExpiry(localDate)
                .build();
    }

    public CategoryDto mapCategoryToDto(Category category) {
        return modelMapper.map(category, CategoryDto.class);
    }

    public Category mapCategoryFromDto(CategoryDto categoryDto) {
        return modelMapper.map(categoryDto, Category.class);
    }

    public UserDto mapUserToDto(User user) {
        ClubDto clubDto = null;
        if (user.getClub() != null) {
            clubDto = mapClubToDto(user.getClub());
        }
        return UserDto.builder()
                .id(user.getId())
                .username(user.getUsername())
                .firstName(user.getFirstName())
                .lastName(user.getLastName())
                .clubDto(clubDto)
                .email(user.getEmail())
                .role(user.getRole())
                .phoneNumber(user.getPhoneNumber())
                .status(user.getStatus())
                .build();
    }
}