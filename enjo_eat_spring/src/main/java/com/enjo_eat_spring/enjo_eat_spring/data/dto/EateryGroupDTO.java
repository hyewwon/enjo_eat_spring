package com.enjo_eat_spring.enjo_eat_spring.data.dto;

import com.enjo_eat_spring.enjo_eat_spring.data.entity.EateryGroup;
import com.enjo_eat_spring.enjo_eat_spring.data.entity.User;
import jakarta.validation.constraints.NotBlank;
import lombok.*;

public class EateryGroupDTO {

    @NoArgsConstructor
    @AllArgsConstructor
    @Getter
    @Builder
    public static class RequestDTO{
        private String groupName;
        private String groupComment;
        private String groupLocation;
        private int openFlag;
        private User user;

        public void setUser(User user) {
            this.user = user;
        }

        public EateryGroup toEntity(){
            return EateryGroup.builder()
                    .groupName(groupName)
                    .groupComment(groupComment)
                    .groupLocation(groupLocation)
                    .openFlag(openFlag)
                    .user(user)
                    .build();
        }
    }

    @NoArgsConstructor
    @AllArgsConstructor
    @Builder
    @Getter
    public static class ResponseDTO{
        private Long id;
        private String groupName;
        private String groupComment;
        private String groupLocation;
        private int openFlag;
        private User user;

        public ResponseDTO toDto(EateryGroup eateryGroup){
            return ResponseDTO.builder()
                    .id(eateryGroup.getId())
                    .groupName(eateryGroup.getGroupName())
                    .groupComment(eateryGroup.getGroupComment())
                    .groupLocation(eateryGroup.getGroupComment())
                    .openFlag(eateryGroup.getOpenFlag())
                    .user(eateryGroup.getUser())
                    .build();
        }
    }

}
