package com.spring.client.board.domain;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.ColumnDefault;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDateTime;

//JPA를 사용해서 테이블과 매핑할 클래스
//이 어노테이션이 명시된 클래스는 JPA가 관리하는 것으로 엔티티라 부른다.
@Getter
@Setter
@ToString
@Entity
@Table(name = "boot_board")
@SequenceGenerator(
        name = "boot_board_generator",
        sequenceName = "boot_board_seq",
        initialValue = 1,
        allocationSize = 1
)
public class Board {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "boot_board_generator")
    private Long no;

    @Column(length = 15, nullable = false)
    private String name;

    @Column(nullable = false)
    private String title;

    @Lob
    @Column(nullable = false)
    private String content;

//  엔티티가 생성되거나 업데이트 되는 시점의 날짜 데이터를 기록하는 설정
    @CreationTimestamp
    @ColumnDefault(value = "sysdate")
    private LocalDateTime regDate;

//  객체 타입(Integer)을 사용하는 이유는 null을 리턴할 수 있기 때문.
    @ColumnDefault(value = "0")
    private Integer hit = 0;
}
