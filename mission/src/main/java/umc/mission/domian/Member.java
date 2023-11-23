package umc.mission.domian;

import lombok.*;
import umc.mission.domian.common.BaseEntity;
import umc.mission.domian.enums.Gender;
import umc.mission.domian.enums.MemberStatus;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Builder
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
public class Member extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 50)
    private String name;

    @Column(nullable = false, length = 50)
    private String birth;

    @Column(length = 50)
    private String uid;

    @Column(length = 50)
    private String password;

    @Column(nullable = false, length = 50)
    private String email;

    @Column(nullable = false, length = 50)
    private String phoneNumber;

    private String phoneCheck;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false, length = 30)
    private Gender gender;

    @Column(length = 200)
    private String address;

    private Integer yearCheck;

    private Integer locationCheck;

    private Integer marketingCheck;

    @Enumerated(EnumType.STRING)
    @Column(columnDefinition = "VARCHAR(10) DEFAULT 'ACTIVE'")
    private MemberStatus memberStatus;

    // 리뷰
    @OneToMany(mappedBy = "member", cascade = CascadeType.ALL)
    private List<Review> reviewList = new ArrayList<>();

    // 미션
    @OneToMany(mappedBy = "member", cascade = CascadeType.ALL)
    private List<Mission> missionList = new ArrayList<>();

}
