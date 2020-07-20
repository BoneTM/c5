package com.bone.c5.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Objects;

/**
 * @author Bone
 * @Package com.bone.c5.entity
 * @date 2020/7/7 14:50
 */
@Entity
@Data
@Table(name = "rankme")
@NoArgsConstructor
@AllArgsConstructor
public class RankmeEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "steam")
    private String steam;

    @Column(name = "name")
    private String name;

    @Column(name = "lastip")
    private String lastip;

    @Column(name = "score")
    private Integer score;

    @Column(name = "kills")
    private Integer kills;

    @Column(name = "deaths")
    private Integer deaths;

    @Column(name = "assists")
    private Integer assists;

    @Column(name = "suicides")
    private Integer suicides;

    @Column(name = "tk")
    private Integer tk;

    @Column(name = "shots")
    private Integer shots;

    @Column(name = "hits")
    private Integer hits;

    @Column(name = "headshots")
    private Integer headshots;

    @Column(name = "connected")
    private Integer connected;

    @Column(name = "rounds_tr")
    private Integer roundsTr;

    @Column(name = "rounds_ct")
    private Integer roundsCt;

    @Column(name = "lastconnect")
    private Integer lastconnect;

    @Column(name = "knife")
    private Integer knife;

    @Column(name = "glock")
    private Integer glock;

    @Column(name = "hkp2000")
    private Integer hkp2000;

    @Column(name = "usp_silencer")
    private Integer uspSilencer;

    @Column(name = "p250")
    private Integer p250;

    @Column(name = "deagle")
    private Integer deagle;

    @Column(name = "elite")
    private Integer elite;

    @Column(name = "fiveseven")
    private Integer fiveseven;

    @Column(name = "tec9")
    private Integer tec9;

    @Column(name = "cz75a")
    private Integer cz75A;

    @Column(name = "revolver")
    private Integer revolver;

    @Column(name = "nova")
    private Integer nova;

    @Column(name = "xm1014")
    private Integer xm1014;

    @Column(name = "mag7")
    private Integer mag7;

    @Column(name = "sawedoff")
    private Integer sawedoff;

    @Column(name = "bizon")
    private Integer bizon;

    @Column(name = "mac10")
    private Integer mac10;

    @Column(name = "mp9")
    private Integer mp9;

    @Column(name = "mp7")
    private Integer mp7;

    @Column(name = "ump45")
    private Integer ump45;

    @Column(name = "p90")
    private Integer p90;

    @Column(name = "galilar")
    private Integer galilar;

    @Column(name = "ak47")
    private Integer ak47;

    @Column(name = "scar20")
    private Integer scar20;

    @Column(name = "famas")
    private Integer famas;

    @Column(name = "m4a1")
    private Integer m4A1;

    @Column(name = "m4a1_silencer")
    private Integer m4A1Silencer;

    @Column(name = "aug")
    private Integer aug;

    @Column(name = "ssg08")
    private Integer ssg08;

    @Column(name = "sg556")
    private Integer sg556;

    @Column(name = "awp")
    private Integer awp;

    @Column(name = "g3sg1")
    private Integer g3Sg1;

    @Column(name = "m249")
    private Integer m249;

    @Column(name = "negev")
    private Integer negev;

    @Column(name = "hegrenade")
    private Integer hegrenade;

    @Column(name = "flashbang")
    private Integer flashbang;

    @Column(name = "smokegrenade")
    private Integer smokegrenade;

    @Column(name = "inferno")
    private Integer inferno;

    @Column(name = "decoy")
    private Integer decoy;

    @Column(name = "taser")
    private Integer taser;

    @Column(name = "mp5sd")
    private Integer mp5Sd;

    @Column(name = "breachcharge")
    private Integer breachcharge;

    @Column(name = "head")
    private Integer head;

    @Column(name = "chest")
    private Integer chest;

    @Column(name = "stomach")
    private Integer stomach;

    @Column(name = "left_arm")
    private Integer leftArm;

    @Column(name = "right_arm")
    private Integer rightArm;

    @Column(name = "left_leg")
    private Integer leftLeg;

    @Column(name = "right_leg")
    private Integer rightLeg;

    @Column(name = "c4_planted")
    private Integer c4Planted;

    @Column(name = "c4_exploded")
    private Integer c4Exploded;

    @Column(name = "c4_defused")
    private Integer c4Defused;

    @Column(name = "ct_win")
    private Integer ctWin;

    @Column(name = "tr_win")
    private Integer trWin;

    @Column(name = "hostages_rescued")
    private Integer hostagesRescued;

    @Column(name = "vip_killed")
    private Integer vipKilled;

    @Column(name = "vip_escaped")
    private Integer vipEscaped;

    @Column(name = "vip_played")
    private Integer vipPlayed;

    @Column(name = "mvp")
    private Integer mvp;

    @Column(name = "damage")
    private Integer damage;

    @Column(name = "match_win")
    private Integer matchWin;

    @Column(name = "match_draw")
    private Integer matchDraw;

    @Column(name = "match_lose")
    private Integer matchLose;

    @Column(name = "first_blood")
    private Integer firstBlood;

    @Column(name = "no_scope")
    private Integer noScope;

    @Column(name = "no_scope_dis")
    private Integer noScopeDis;

    @Column(name = "thru_smoke")
    private Integer thruSmoke;

    @Column(name = "blind")
    private Integer blind;

    @Column(name = "assist_flash")
    private Integer assistFlash;

    @Column(name = "assist_team_flash")
    private Integer assistTeamFlash;

    @Column(name = "assist_team_kill")
    private Integer assistTeamKill;

    @Column(name = "wallbang")
    private Integer wallbang;

}
