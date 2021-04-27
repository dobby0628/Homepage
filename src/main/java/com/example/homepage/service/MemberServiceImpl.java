package com.example.homepage.service;

import com.example.homepage.config.SecurityConfig;
import com.example.homepage.dto.MemberDTO;
import com.example.homepage.dto.SignupDTO;
import com.example.homepage.entity.MemberEntity;
import com.example.homepage.entity.MemberRole;
import com.example.homepage.repository.MemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class MemberServiceImpl implements MemberService, UserDetailsService {
    @Autowired
    MemberRepository memberRepository;
    @Autowired
    PasswordEncoder passwordEncoder;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<MemberEntity> result = memberRepository.findByMid(username);
        MemberEntity memberEntity = result.get();

        MemberDTO memberDTO = new MemberDTO(
                memberEntity.getMid(),
                memberEntity.getMpassword(),
                memberEntity.getRoleSet()
                .stream()
                .map(memberRole -> new SimpleGrantedAuthority(
                        "ROLE_" + memberRole.name()
                )).collect(Collectors.toSet())
        );

        memberDTO.setMusername(memberEntity.getMusername());
        memberDTO.setMemail(memberEntity.getMemail());
        memberDTO.setMphone(memberEntity.getMphone());

        return memberDTO;
    }

    @Override
    public void signup(SignupDTO signupDTO) {
        MemberEntity memberEntity = MemberEntity.builder()
                .mid(signupDTO.getMid())
                .mpassword(passwordEncoder.encode(signupDTO.getMpassword()))
                .musername(signupDTO.getMusername())
                .memail(signupDTO.getMemail())
                .mphone(signupDTO.getMphone())
                .build();

        memberEntity.addMemberRole(MemberRole.USER);

        memberRepository.save(memberEntity);
    }
}
