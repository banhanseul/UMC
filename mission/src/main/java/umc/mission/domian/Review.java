package umc.mission.domian;

import lombok.*;
import umc.mission.domian.common.BaseEntity;
import umc.mission.domian.enums.ReviewStatus;

import javax.persistence.*;

@Entity
@Getter
@Builder
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
public class Review extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // 회원 식별자
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "member_id")
    private Member member;

    // 가게 식별자
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "store_id")
    private Store store;

    @Column(nullable = false, length = 200)
    private String content;

    private Integer star;

    private String reviewImage;

    private String reply;

    // 리뷰의 존재 유무
    @Enumerated(EnumType.STRING)
    @Column(columnDefinition = "VARCHAR(10) DEFAULT 'EXIST'")
    private ReviewStatus reviewStatus;
}