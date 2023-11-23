package umc.mission.domian;

import lombok.*;
import umc.mission.domian.common.BaseEntity;
import umc.mission.domian.enums.MissionStatus;

import javax.persistence.*;
@Entity
@Getter
@Builder
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
public class Mission extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // 회원식별자
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "member_id")
    private Member member;

    // 가게식별자
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "store_id")
    private Store store;

    // 지역식별자
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "region_id")
    private Region region;

    @Column(nullable = false, length = 50)
    private String name;

    private String missionSuccess;

    private String missionCost;

    private Integer point;

    @Enumerated(EnumType.STRING)
    @Column(columnDefinition = "VARCHAR(10) DEFAULT 'UNPASS'")
    private MissionStatus missionStatus;

}