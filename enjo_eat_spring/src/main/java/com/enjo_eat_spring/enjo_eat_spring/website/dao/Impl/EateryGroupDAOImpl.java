package com.enjo_eat_spring.enjo_eat_spring.website.dao.Impl;

import com.enjo_eat_spring.enjo_eat_spring.data.entity.EateryGroup;
import com.enjo_eat_spring.enjo_eat_spring.data.repository.EateryGroupRepository;
import com.enjo_eat_spring.enjo_eat_spring.website.dao.EateryGroupDAO;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EateryGroupDAOImpl implements EateryGroupDAO {
    EateryGroupRepository eateryGroupRepository;

    @Autowired
    public EateryGroupDAOImpl(EateryGroupRepository eateryGroupRepository){
        this.eateryGroupRepository = eateryGroupRepository;
    }

    @Override
    public List<EateryGroup> getGroupList() {
        return eateryGroupRepository.findAll();
    }

    @Override
    public EateryGroup getGroup(Long groupId) {
        EateryGroup eateryGroup = eateryGroupRepository.findById(groupId).orElseThrow(
                () -> new IllegalArgumentException("아이디값이 없습니다")
        );
        return eateryGroup;
    }

    @Override
    @Transactional
    public Long createGroup(EateryGroup eateryGroup) {
        EateryGroup eatery = eateryGroupRepository.save(eateryGroup);
        return eatery.getId();
    }

    @Override
    public Long updateGroup(EateryGroup eateryGroup, Long groupId) {
        EateryGroup group = eateryGroupRepository.findById(groupId).orElseThrow(
                () -> new IllegalArgumentException("아이디 값이 없습니다")
        );
        if(group.getUser() != eateryGroup.getUser()){
            throw new UsernameNotFoundException("수정 권한이 없습니다.");
        }
        group.update(eateryGroup.getGroupName(), eateryGroup.getGroupComment(), eateryGroup.getGroupLocation());
        eateryGroupRepository.save(group);
        return group.getId();
    }
}