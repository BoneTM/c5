package com.bone.c5.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

/**
 * @author Bone
 * @Package com.bone.c5.entity
 * @date 2020/7/7 14:50
 */
@Entity
@Data
@Table(name = "c5_site")
@NoArgsConstructor
@AllArgsConstructor
public class SiteEntity {
    @Id
    @Column(name = "label")
    private String label;

    @Column(name = "value")
    private String value;
}
