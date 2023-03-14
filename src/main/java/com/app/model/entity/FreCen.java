package com.app.model.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;


@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "fresher_center", uniqueConstraints = {
        @UniqueConstraint(columnNames = {"fresher_id", "center_id"})
})
public class FreCen {
    @Id
    @Column(name = "fresher_center_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long fresherCenterId;

    @ManyToOne
    @JoinColumn(name = "fresher_id")
    @JsonIgnore
    Fresher fresher;

    @ManyToOne
    @JoinColumn(name = "center_id")
    @JsonIgnore
    Center center;
}
